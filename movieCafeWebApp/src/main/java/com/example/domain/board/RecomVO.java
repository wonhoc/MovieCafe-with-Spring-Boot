package com.example.domain.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecomVO {
	private int boardNo;
	private String userId;
	private boolean isRecom;
}
