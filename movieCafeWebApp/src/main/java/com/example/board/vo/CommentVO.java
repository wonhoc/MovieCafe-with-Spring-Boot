package com.example.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
	private int comNo;
	private String comContent;
	private String comWdate;
	private String userId;
	private String userNick;
	private int boardNo;
}
