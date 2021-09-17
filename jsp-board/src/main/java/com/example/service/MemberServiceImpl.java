package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.IMemberDao;
import com.example.dto.Member;
import com.example.dto.MemberAuth;
import com.example.exception.MemberAlreadyExistException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements IMemberService {
	
	private final IMemberDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void signup(Member member) throws Exception {
		
		log.info("signup start member: " + member);
		
		Member getMember = dao.getUser(member.getUserId());
		
		log.info("getUser: " + getMember);
		
		if (getMember == null) {
			
			member.setUserPw(passwordEncoder.encode(member.getUserPw()));
			
			dao.create(member);
			
			MemberAuth memberAuth = new MemberAuth();
			
			memberAuth.setUserNo(member.getUserNo());
			memberAuth.setAuth("ROLE_MEMBER");
			
			dao.createAuth(memberAuth);
			
		} else {
			throw new MemberAlreadyExistException("이미 가입한 아이디입니다");
		}
		
		
		log.info("signup end member: " + member);
		
		
	}

}
