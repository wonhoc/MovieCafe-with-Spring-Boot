package com.example.domain.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardLocationVO {
	private int boardNo;
	private String apiX;
	private String apiY;
}
