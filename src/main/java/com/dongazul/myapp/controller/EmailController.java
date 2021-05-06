//package com.dongazul.myapp.controller;
//
//import java.util.Random;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dongazul.myapp.service.EmailService;
//
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.extern.log4j.Log4j;
//
//@Log4j
//@NoArgsConstructor
//
//@RequestMapping("/email")
//@Setter
//@Controller
//public class EmailController {
//	
//	
//    private EmailService emailService;
//
//
//    @ResponseBody
//	@PostMapping(value= "/eSend", produces = "application/json")
//	public boolean sendMailAuth(HttpSession session, @RequestParam String email) {
//    	
//    	log.debug("sendMailAuth(session, email) invoked.");
//    	
//        int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
//        
//        String joinCode = String.valueOf(ran);
//        
//        session.setAttribute("joinCode", joinCode);
// 
//        String subject = "회원가입 인증 코드 발급 안내 입니다.";
//        
//        StringBuilder sb = new StringBuilder();
//        
//        sb.append("귀하의 인증 코드는 " + joinCode + " 입니다.");
//        
//        return emailService.send(
//        		subject, 
//        		sb.toString(),
//        		"dobest0998@gmail.com",
//        		email,
//        		null
//        		);
//    }
//	
//	@PostMapping("/reception")
//	public void recvEmailPost() {
//		log.debug("recvEmailPost");
//	} // reception
//
//}
