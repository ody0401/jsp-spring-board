package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.dao.IMemberDao;
import com.example.dto.CustomUser;
import com.example.dto.Member;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IMemberDao memberDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		try {
			Member member = memberDao.readByUserId(username);
			
			return member == null ? null : new CustomUser(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

}
