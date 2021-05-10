package com.dongazul.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dongazul.myapp.domain.ProfileDTO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RequestMapping("/chat")

@Controller
public class ChatController {

	
	
	
	@GetMapping("/open")
	public void openGet() {
		log.debug("openGet() invoked.");

	} // openGet

	@PostMapping("/open")
	public void openPost() {
		log.debug("openPost() invoked.");

	} // openPost
	
	@GetMapping("/rooms")
	public void roomsGet(Model model, HttpServletRequest req) {
		log.debug("roomsGet() invoked.");
		
		HttpSession session = req.getSession();
		
		ProfileDTO user = (ProfileDTO) session.getAttribute("profile");
		
		model.addAttribute("info",user.getNickname());
		
		
		
	
	} // roomsGet
	
	@GetMapping("/window")
	public void windowGet(String message) {
		
		log.debug("windowGet() invoked.");

	} // windowGet
	
	@PostMapping("/do")
	public void doPost() {
		log.debug("doPost() invoked.");

	} // doPost
	
	@PostMapping("/exit")
	public void exitPost() {
		log.debug("exitPost() invoked.");
	
	} // exitPost
	
	
	
} // end class
