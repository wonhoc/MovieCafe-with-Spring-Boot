package com.example.board.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class SearchVO {
	int cateNo;
	String keyfield;
	String keyword;
	
}
