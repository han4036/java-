package com.dongazul.myapp.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.dongazul.myapp.domain.EmailDTO;
import com.dongazul.myapp.domain.LoginDTO;
import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.interceptor.AuthInterceptor;
import com.dongazul.myapp.service.MemberService;
import com.dongazul.myapp.utils.EmailSender;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/login")
public class LoginController {
	
	public static final String loginKey = "member";	
	
	public static final String rememberMeKey = 
					AuthInterceptor.rememberMeKey;
	
	@Autowired
	private MemberService memberservice;
	
	 @Autowired
	private EmailSender emailSender;

	
	
	// 로그인 처리
	@PostMapping("/signInPost")
	public String signInPost(
				LoginDTO dto,
				HttpSession session,
				Model model) throws Exception {
		
		log.debug("signInPost(dto, session, model) invoked.");
		
		MemberVO signIn = this.memberservice.signIn(dto);
		
		if(signIn != null) {
			
			model.addAttribute(loginKey, signIn);
			
			if(dto.isRememberme()) {
				
				   String email = dto.getEmail();
				   String rememberme = session.getId();
				   
				   int timeAmount = 1000 * 60 * 24 * 7;
				   Date rememberage =
						   new Date(System.currentTimeMillis() + timeAmount);
				   
				   this.memberservice.
				   updateMemberWithRememberMe(email, rememberme, rememberage);
				   
				   log.info("\t+ 자동로그인 정보 업데이트 완료.");
			} // if
		} 

		return null;	
	} // signInPost
	
	// 로그아웃 처리
	@GetMapping("/signOut")
	public String signOutGet(
			HttpServletRequest req,
			HttpServletResponse res,
			HttpSession session) throws Exception {
		
		log.debug("signOutGet(session) invoked.");
		
		MemberVO signIn = (MemberVO) session.getAttribute(loginKey);
		
		session.invalidate();
		
		Cookie rememberMeCookie = 
				WebUtils.getCookie(req, rememberMeKey);
			
		if(rememberMeCookie != null) {
			
			rememberMeCookie.setPath("/");
			rememberMeCookie.setMaxAge(0);	/*** 쿠키파괴를 위한 가장 중요한 설정 ***/
				
			res.addCookie(rememberMeCookie);	// 브라우저로 이 쿠키가 전송 => 파괴
		} // if
		
		if(signIn != null) {
			this.memberservice.
			updateMemberWithRememberMe(signIn.getEmail(), null, null);			
		} // if
		
		return "redirect:/";
	} // signOutPost
	
	// 아이디 찾기 화면
   @GetMapping("/findId")
   public void findIdGet() {
	   
      log.debug("findIdGet() invoked.");      
   } // findIdGet
   
   // 아아디 찾기 처리
   @PostMapping("/findIdResult")
   public String findIdPost(
		   MemberVO vo, 
		   Integer phonenumber, 
		   HttpSession session,
		   RedirectAttributes rttrs
		   ) throws Exception {
	   
      log.debug("findIdPost(phoneNumber) invoked.");
      
      String result = memberservice.findId(phonenumber);
      
      if(result != null) {
    	  session.setAttribute("FIND", result);
    	  return "/login/findIdResult";
      } else {
    	  rttrs.addFlashAttribute("msg", "이메일을 잘못입력하셨습니다");
    	  return "redirect:/login/findId";
      } // if-else
   } // findIdPost
   
   // 비밀번호 찾기 화면
   @GetMapping("/findPw")
   public void findPwGet() {
	   
      log.debug("findPwGet() invoked.");
   } // findPwGet
   
   // 비밀번호 찾기 처리
   @PostMapping("/findPwResult")
   public String findPwPost (@RequestParam Map<String, Object> params, RedirectAttributes rttrs) throws Exception {
      
	   log.info("findPwPost(paramMap, model)");	
	   EmailDTO email = new EmailDTO();
	   
       String phonenumber= (String) params.get("phonenumber");
       String e_mail= (String) params.get("email");
       
       String pw= this.memberservice.findPw(params);
       
       String htmlStr = "안녕하세요 '"+ phonenumber +"' 님\n" 
				+ "고객님의 비밀번호는"  + pw + "입니다 \n"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";

       if(pw!=null) {
    	   
           email.setContent(htmlStr);
           email.setReceiver(e_mail);
           email.setSubject(phonenumber+"님 비밀번호 찾기 메일입니다.");
           emailSender.SendEmail(email);
           
          rttrs.addFlashAttribute("msg", "이메일이 발송되었습니다.");
           return "redirect:/";
       } else {
    	   rttrs.addFlashAttribute("msg", "가입한 회원이 아닙니다.");
           return "redirect:/login/findPw";
       } // if-else

   } // findPwPost
   
} // end class
