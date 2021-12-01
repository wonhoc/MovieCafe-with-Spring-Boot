package com.example.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentVO {
	@NonNull private int comNo;
	@NonNull private String comContent;
	private String comWdate;
	private String userId;
	private String userNick;
	private int boardNo;
}
