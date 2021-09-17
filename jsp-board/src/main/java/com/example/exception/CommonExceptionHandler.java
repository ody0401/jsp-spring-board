package com.example.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(MemberAlreadyExistException.class)
	public String handleMemberAlreadyExistException(MemberAlreadyExistException ex, WebRequest request, Model model) {
		log.info("handleMemberAlreadyExistException");
		
		model.addAttribute("ex", ex);
		
		return "error/alreadyExist";
		
	}

}
