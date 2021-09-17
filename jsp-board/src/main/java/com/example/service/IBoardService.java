package com.example.service;

import java.util.List;

import com.example.dto.Board;
import com.example.dto.PaginationDto;
import com.example.dto.Post;

public interface IBoardService {
	
	public void write(Board dto) throws Exception;

	public List<Post> getAllPosts() throws Exception;
	
	public PaginationDto pagination(int pageNo) throws Exception;
	
	public List<Post> postList(int pageNo) throws Exception;
	
	public Post getPostOne(int id) throws Exception;
	
	public void update(Board dto, int id) throws Exception;
	
	public void delete(int id) throws Exception;

}
