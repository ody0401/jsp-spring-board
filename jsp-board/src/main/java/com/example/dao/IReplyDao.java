package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.dto.Reply;

public interface IReplyDao {

	public void write(Reply reply) throws Exception;
	
	public List<Reply> getReply(int id) throws Exception;
	
	public List<HashMap<String, Integer>> getLastRef() throws Exception;
	
	public int getLastStepOrder() throws Exception;
	
	public int getLastOrder(int ref) throws Exception;
	
	public List<HashMap<String, Integer>> biggerOrder(int ref,int refOrder) throws Exception;
	
	public List<HashMap<String, Integer>> isStepBigger(int step) throws Exception;
	
	public List<HashMap<String, Integer>> eqStep(int step, int refOrder) throws Exception;
	
	public void nestedReply(Reply reply) throws Exception;

	public void plusOrder(int refOrder) throws Exception;
	
	public void deleteReply(int boardId) throws Exception;
}
