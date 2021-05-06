package com.dongazul.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RequestMapping("/chat")

@Controller
public class ChatController {


	@PostMapping("/open")
	public void openPost() {
		log.debug("openPost() invoked.");

	} // ChatController
	
	@GetMapping("/rooms")
	public void roomsGet() {
		
		log.debug("roomsGet() invoked.");
	
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
