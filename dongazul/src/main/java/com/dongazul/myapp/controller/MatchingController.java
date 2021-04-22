package com.dongazul.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;



@Log4j
@NoArgsConstructor


@RequestMapping("/matching")

@Controller
public class MatchingController {

	
	@GetMapping("/swipe")
	public void swipeGet() {
		log.debug("swipeGet() invoked.");
		
//		return "matching/swipe";
	} // swipeGet
	
	
	@GetMapping("/profile")
	public void profileGet() {
		log.debug("profileGet() invoked.");
		
//		return "matching/profile";
	} // profileGet
	
	
	@PostMapping("/like")
	public void likePost() {
		log.debug("likePost() invoked.");
		
//		return "matching/like";
	} // likePost
	
	
} // end class
