 package com.dongazul.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.service.MemberService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@NoArgsConstructor

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	// 회원가입 화면
	@GetMapping("/signUp")
	public void signUpGet() throws Exception {
		
		log.info("signUpGet() invoked.");
	} // signUpGet
	
	// 회원가입 처리
	@PostMapping("/signUp")
	public String signUpPost(MemberVO vo, Model model) throws Exception {
		
		log.info("signUpPost(vo) invoked.");
		
		int result = service.emailCheck(vo);
		
		try {
			if(result==1) {
				
				model.addAttribute("exam", result);
				
				return "/member/signUp";
				
			} else if(result==0) {
				
				service.signUp(vo);
				
			}
		} catch(Exception e) {
			throw new RuntimeException();
		}
		
		return "redirect:/login/signIn";
		
	} // signUpPost
		//이메일 인증 전송
		@PostMapping("/authSend")
		public void authSendPost () {
			
			log.debug("authSendPost() invoked.");
			
		} // authSendPost
		
		// 이메일 인증 응답
		@PostMapping("/authRecv")
		public void authRecvPost() {
			
			log.debug("authRecvPost() invoked.");

		} // authRecvPost
		
		// 비밀번호 변경 화면
		@GetMapping("/changePw")
		public void infoGet() {
			
			log.debug("infoGet() invoked.");
		
		} // infoGet
		
		// 비밀번호 변경 처리
		@PostMapping("/changePw")
		public String infoPost(MemberVO vo, HttpSession session) throws Exception {
			
			log.debug("infoPost() invoked.");
			
			service.memberUpdate(vo);
			
			session.invalidate();
			
			return "redirect:/login/signIn";
	
		} // infoPost
		
		// 회원탈퇴화면 보여주기
		@GetMapping("/dropOut")
		public void dropOutGet() {
			
			log.debug("dropOutGet() invoked.");
		
		} // dropOutGet
		// 회원탈퇴 처리
		@PostMapping("/dropOut")
		public String dropOutPost(
				MemberVO vo,
				HttpSession session,
				RedirectAttributes rttr
				) throws Exception {
			
			// 세션에 있는 member를 가져와 member변수에 넣어줍니다.
			MemberVO member = (MemberVO) session.getAttribute("member");
			// 세션에있는 비밀번호
			String sessionPass = member.getPasswd();
			// vo로 들어오는 비밀번호
			String voPass = vo.getPasswd();
			
			if(!(sessionPass.equals(voPass))) {
				rttr.addFlashAttribute("msg", false);
				return "redirect:/member/dropout";
			}
			service.memberDelete(vo);
			session.invalidate();
			return "redirect:/login/signIn";
		
 	} // dropOutPost
	   
	   // 이메일 중복 체크
	   @ResponseBody
	   @PostMapping("/emailCheck")
       public int emailCheck(MemberVO vo) throws Exception {
		   
	   int result = service.emailCheck(vo);
	   
	   return result;
	} // emailCheck

} // end class
