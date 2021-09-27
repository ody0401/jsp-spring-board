package com.example.service;

import java.util.List;

import com.example.dto.Reply;

public interface IReplyService {
	
	public void write(Reply reply) throws Exception;
	
	public List<Reply> getReply(int id) throws Exception;

}
