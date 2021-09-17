package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class CommonController {
	
	@GetMapping("/")
	public String index() {
		
		return "redirect:/board";
	}
	
	@GetMapping("/error/accessError")
	public String accessDenied(Authentication auth, Model model) {
		log.info("access Denide: " + auth);
		
		model.addAttribute("msg", "Access Denied");
		
		return "error/accessError";
	}

}
