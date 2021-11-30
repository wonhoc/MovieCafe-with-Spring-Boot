package com.example.board.vo;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	private int boardNo;//
	private  String userId;//
	private String boardTitle;//
	private String boardWdate;//
	private String boardContent;//
	private int boardCount;//
	private int recomCount;
	private int commentCount;
	private int cateNo;//
	private int horseNo;//
	private String horse;//
	private int boardNotice;//
	private String userNick;//
	private String apiX;//
	private String apiY;//

	private ArrayList<BoardFileVO> boardfileList = new ArrayList<BoardFileVO>();
	private ArrayList<CommentVO> commentList = new ArrayList<CommentVO>();
}
