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
public class Board {
	
	private int id;
	
	private String title;
	
	private String writer;
	
	private String content;
	
	private int hits;
	
	private LocalDateTime regDate;
	private LocalDateTime updDate;

}
