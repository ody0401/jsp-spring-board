package com.example.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDto {
	
	private int tempEnd;
	
	private int start;
	
	private int totalPage;
	
	private int end;
	
	private boolean prev, next;
	
	private List<Integer> pageList;
	
	
	
	

}
