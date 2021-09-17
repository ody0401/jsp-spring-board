package com.example.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.IBoardDao;
import com.example.dto.Board;
import com.example.dto.PaginationDto;
import com.example.dto.Post;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements IBoardService {
	
	private final IBoardDao dao;
	
	private int pageSize = 10;
	
	private int tempEnd, start, totalPage, end;
	
	private boolean prev, next;
	
	private List<Integer> pageList;

	@Transactional
	@Override
	public void write(Board dto) throws Exception {
		
		dao.insert(dto);
		
	}
	
	@Transactional
	@Override
	public void update(Board dto, int id) throws Exception {
		
		dto.setId(id);
		
		dao.update(dto);
		
	}
	
	@Transactional
	@Override
	public List<Post> getAllPosts() throws Exception {
		
		dao.allPosts();
		
		return null;
	
	}

	@Transactional
	@Override
	public PaginationDto pagination(int pageNo) throws Exception {
		
		tempEnd = (int)(Math.ceil(pageNo/10.0)) * 10;
		
		start = tempEnd - 9;
		
		totalPage = (int)(Math.ceil(dao.totalPage()/10.0));  
		
		end = totalPage > tempEnd? tempEnd : totalPage;
		
		prev = start > 1;
		
		next = totalPage > tempEnd;
		
		pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
		
		PaginationDto pagination = PaginationDto.builder()
				.tempEnd(tempEnd)
				.start(start)
				.totalPage(totalPage)
				.end(end)
				.prev(prev)
				.next(next)
				.pageList(pageList)
				.build();
		
		
		return pagination;
	}

	@Transactional
	@Override
	public List<Post> postList(int pageNo) throws Exception {
		
		List<Post> dto = dao.postList((pageNo-1) * 10, pageSize);
		
		return dto;
		
	}

	@Transactional
	@Override
	public Post getPostOne(int id) throws Exception {

		Post dto = dao.getPostOne(id);
		
		return dto;
	}

	@Override
	public void delete(int id) throws Exception {
		dao.delete(id);
	}
	
	

}
