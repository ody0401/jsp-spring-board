package com.example.dao;

import com.example.dto.Member;
import com.example.dto.MemberAuth;

public interface IMemberDao {
	
	public void create(Member member) throws Exception;
	
	public void createAuth(MemberAuth memberAuth) throws Exception;
	
	public Member readByUserId(String userId) throws Exception;
	
	public Member getUser(String id) throws Exception;

}
