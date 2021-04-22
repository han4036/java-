package com.dongazul.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileVO;
import com.dongazul.myapp.service.MemberService;
import com.dongazul.myapp.service.ProfileService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	MemberService service;
	
	@Autowired
	ProfileService service2;
	

	
	// 로그인 화면
	@GetMapping("/signIn")
	public void signInGet(HttpSession session) {
		log.debug("signInGet() invoked.");
	} // signInGet
	
	// 로그인 처리
	@PostMapping("/signIn")
	public String signInPost(MemberVO vo, ProfileVO check, Model model,
				HttpServletRequest req, RedirectAttributes rttr ) throws Exception {
		log.debug("signInPost(vo, req, rttr) invoked.");
		
		HttpSession session = req.getSession();
		
		MemberVO signIn = service.signIn(vo);
		
		
		ProfileVO select = service2.pfSelect(check);
		
		List<ProfileVO> man = service2.mSelect(check);
		
		List<ProfileVO> woman = service2.wSelect(check);
		
		if(signIn == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/login/signIn";
			
		} else {
				session.setAttribute("member", signIn);
				if(select == null) {
					
					return "/profile/create";
				} else {
					session.setAttribute("profile", select);
					rttr.addFlashAttribute("msg","프로필이 존재합니다.");
					if(select.getGender().equals("M")) {
						model.addAttribute("gender", woman);
					} else if(select.getGender().equals("W")){
						model.addAttribute("gender", man);
					}
				} // if-else
		} // if-else
		return "/matching/swipe";
	} // signInPost
	
	
	// 로그아웃 처리
	@GetMapping("/signOut")
	public String signOutGet(HttpSession session) {
		
		log.debug("signOutGet(session) invoked.");
		
		session.invalidate();
		
		return "/login/signIn";
	} // signOutPost
	
	// 아이디 찾기 화면
   @GetMapping("/findId")
   public void findIdGet() {
      log.debug("findIdGet() invoked.");      
   } // findIdGet
   
   // 아아디 찾기 처리
   @PostMapping("/findIdResult")
   public String findIdPost(Integer phonenumber, Model model, RedirectAttributes rttr) throws Exception {
      log.debug("findIdPost(phoneNumber) invoked.");
      
      String result = service.findId(phonenumber);
      
      if(result != null) {
    	  model.addAttribute("find", result);
    	  return "/login/findIdResult";
      } else {
    	  rttr.addAttribute("msg",false);
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
   public String findPwPost(String email, Model model, RedirectAttributes rttr) throws Exception {
      log.debug("findPwPost(email) invoked.");
      
      String pw = service.findPw(email);
      
      if(pw != null) {
    	  model.addAttribute("findPw", pw);
    	  return "/login/findPwResult";
      } else {
    	  rttr.addAttribute("msg", false);
    	  return "redirect:/login/findPw";
      } // if-else
      
   } // findPwPost

} // end class
