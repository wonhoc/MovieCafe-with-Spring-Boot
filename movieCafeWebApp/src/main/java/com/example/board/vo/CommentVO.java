package com.example.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CommentVO {
	private @NonNull int comNo;
	private @NonNull String comContent;
	private String comWdate;
	private @NonNull String userId;
	private String userNick;
	private int boardNo;
}
