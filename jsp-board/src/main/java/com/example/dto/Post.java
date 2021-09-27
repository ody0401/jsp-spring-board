package com.example.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
	
	private int id;
	private String title;
	private String content;
	private String writer;
	private int hits;
	
	private LocalDateTime regDate;
	private LocalDateTime updDate;

}
