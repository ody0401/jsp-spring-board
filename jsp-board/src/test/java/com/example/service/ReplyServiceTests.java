package com.example.service;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Reply;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class ReplyServiceTests {
	
	@Autowired
	private IReplyService service;
	
	@Test
	public void write() throws Exception {
		
		int num = (int)(Math.random() * 5);
		
		IntStream.rangeClosed(1,10).forEach(i -> {
			
			
			Reply reply = Reply.builder()
					.boardNo(i)
					.userNo(2)
					.reply("hihi")
					.ref(i)
					.refOrder(num)
					.step(0)
					.build();
			
			try {
				service.write(reply);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		});
	}
	
	@Test
	public void getReply() throws Exception {
		
		log.info("reply: " + service.getReply(2));
	}
	
	@Transactional
	@Test
	public void reply() throws Exception {
		
		Reply reply = Reply.builder()
				.boardNo(2)
				.userNo(2)
				.reply("hihijk")
				.ref(12)
				.refOrder(0)
				.step(1)
				.build();
		service.write(reply);
	}
	
	@Transactional
	@Test
	public void bigger() throws Exception {
		
		Reply reply = Reply.builder()
				.boardNo(2)
				.userNo(2)
				.reply("hihijk")
				.ref(13)
				.refOrder(4)
				.step(2)
				.build();
		service.write(reply);
	}

}
