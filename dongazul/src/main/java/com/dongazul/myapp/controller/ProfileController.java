 package com.dongazul.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongazul.myapp.domain.MemberVO;
import com.dongazul.myapp.domain.ProfileVO;
import com.dongazul.myapp.service.ProfileService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RequestMapping("/profile")

@Controller
public class ProfileController {
	
	@Setter(onMethod_=@Autowired)
	private ProfileService service;
	
	
	
	@GetMapping("/create")
	public void createGet() {
		log.debug("createGet() invoked.");
		
		
	} // createGet
	
	@PostMapping("/create")
	public String createPost(HttpSession session, ProfileVO profile, MemberVO member,RedirectAttributes rttr) 
			throws Exception {
		log.debug("createPost() invoked");
		
		service.pfCreate(profile);
		
		return "/matching/swipe";
		
	} // createPost
	
	@GetMapping("/info")
	public void infoGet() {
		log.debug("infoGet() invoked.");

	} // infoGet
	
	@PostMapping("/update")
	public void updatePost() {
		log.debug("updatePost() invoked.");
	
	} // updatePost

} // end class
