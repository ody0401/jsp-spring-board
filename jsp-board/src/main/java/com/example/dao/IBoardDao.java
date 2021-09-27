package com.example.dao;

import java.util.List;

import com.example.dto.Board;
import com.example.dto.Post;

public interface IBoardDao {
	
	public void insert(Board dto) throws Exception;
	
	public List<Post> allPosts() throws Exception;
	
	public int totalPage() throws Exception;
	
	public List<Post> postList(int page, int pageSize) throws Exception;
	
	public Post getPostOne(int id) throws Exception;
	
	public void update(Board dto) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public void increaseHits(int id) throws Exception;

}
