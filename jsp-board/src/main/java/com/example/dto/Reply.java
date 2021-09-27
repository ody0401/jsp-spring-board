package com.example.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {
	
	private int id;
	
	private int userNo;
	
	private int boardNo;
	
	private String reply;
	
	private int ref;
	
	private int step;
	
	private int refOrder;
	
	private int parentId;
	
	private LocalDateTime regDate;
	
	private LocalDateTime updDate;
	
	private List<Board> boardList;
	private List<Member> memberList; 

}
