package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Member;

@SpringBootTest
public class MemberServiceTests {
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	@Test
	public void signup() throws Exception {
		
		Member member = Member.builder()
				.userId("user")
				.userName("user")
				.userPw(passwordEncoder.encode("1234"))
				.build();
		
		
		memberService.signup(member);
		
		
	}

}
