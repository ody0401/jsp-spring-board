package com.example.service;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Board;
import com.example.dto.PaginationDto;
import com.example.dto.Post;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardServiceTests {

	@Autowired
	private IBoardService iBoardService;

	@Test
	public void insertDummies() throws Exception {

		IntStream.rangeClosed(1, 100).forEach(i -> {
			Board dto = Board.builder()
					.title("title" + i)
					.writer("writer" + i)
					.content("content" + i)
					.build();

			try {
				iBoardService.write(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

	}

	@Transactional
	@Test
	public void update() throws Exception {

		int id = 2;

		Board dto = Board.builder().title("title3").writer("writer3").content("content3").build();

		iBoardService.update(dto, id);

		log.info("dto:" + dto);
	}

	@Transactional
	@Test
	public void getPosts() throws Exception {

		int pageSize = 1;

		List<Post> dto = iBoardService.postList(pageSize);

		log.info("dto:" + dto);

		log.info("dto.get:" + dto.get(1));
	}

	@Transactional
	@Test
	public void pagination() throws Exception {

		int pageSize = 1;

		PaginationDto dto = iBoardService.pagination(pageSize);

		log.info("dto:" + dto);
	}

	@Transactional
	@Test
	public void getOne() throws Exception {

		int id = 1;

		Post dto = iBoardService.getPostOne(id, 0);

		log.info("dto:" + dto);
	}

}
