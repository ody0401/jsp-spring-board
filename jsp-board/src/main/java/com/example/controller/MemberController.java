package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.Member;
import com.example.service.IMemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class MemberController {
	
	private final IMemberService service;

	@GetMapping("/login")
	public String loginForm(String error, String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "로그인 실패");
			log.info("error: " + error);
		}
		
		return "user/login";
	}
	
	@GetMapping("/signup")
	public String signupForm(Model model) {
		
		model.addAttribute("member", new Member());
		
		return "user/signup";
	}
	
	
	@PostMapping("/signup")
	public String signup(@Validated Member member, BindingResult result, Model model, RedirectAttributes rttr) throws Exception {
		
		if(result.hasErrors()) {
			
			return "user/register";
		}
		
		
		
		service.signup(member);
		
		
		return "redirect:/user/signupSuccess";
	}
	
	@GetMapping("/signupSuccess")
	public String signupSuccess() throws Exception {
		
		return "user/signupSuccess";
	}
	
}
