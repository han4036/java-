package com.dongazul.myapp.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@ControllerAdvice
public class CommonExceptionHandler {
	// 어떤 컨트롤러 메소드에서든, 지정된 예외(여기서는, BindExcption)가 발생하면,
	// 이 메소드가 예외처리 메소드로 동작한다고 지정하는 어노테이션이 @ExceptionHandler임!!
	@ExceptionHandler(NumberFormatException.class)
	public String NumberFormatException(Exception e, Model model) {
		log.debug("NumberFormatException(e, model) invoked.");
		
		log.error("1. Exception Type: " + e.getClass().getName());
		log.error("2. Exception Message: " + e.getMessage());
		// 결국 이 지정된 이름과 값을 Request Scope 공유영역에서 산출
		model.addAttribute("exception", e);
		
		return "/error/errorPage";
	}
		@ExceptionHandler(NoHandlerFoundException.class)
		public String NoHandlerFoundException(Exception e, Model model) {
			log.debug("NoHandlerFoundException() invoked.");
			
			log.error("1. Exception Type: " + e.getClass().getName());
			log.error("2. Exception Message: " + e.getMessage());
			model.addAttribute("exception2", e);
			
			return "/error/404Page";
		
	} // NoHandlerFoundException
	
} // end class
