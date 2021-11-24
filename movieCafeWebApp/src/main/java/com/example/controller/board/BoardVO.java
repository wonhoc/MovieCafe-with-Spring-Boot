package com.example.controller.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BoardVO {
	private int boardNo;
//	private String userId;
	private String boardTitle;
	private String boardWdate;
	private String boardContent;
	private int boardCount;
//	private int recomCount;
//	private int commentCount;
//	private int cateNo;
//	private int horseNo;
	//private String horse;
	//private int boardNotice;
	private String userNick;
//	private String apiX;
	//private String apiY;

	/*
	 * private ArrayList<BoardFileVo> boardfileList = new ArrayList<BoardFileVo>();
	 * private ArrayList<BoardLocationVo> boardLocationList = new
	 * ArrayList<BoardLocationVo>(); private ArrayList<CommentVo> commentList = new
	 * ArrayList<CommentVo>();
	 */
}
