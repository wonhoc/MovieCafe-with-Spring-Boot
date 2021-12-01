package com.example.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.board.vo.BoardVO;
import com.example.board.vo.CommentVO;

public interface BoardService {

	List<BoardVO> readAllByCateNo(int cateNo);	
	BoardVO readOne(int boardNo);
	void createBoard(BoardVO board);
	void createTipBoard(BoardVO board);
	void modifyBoard(BoardVO board);
	void removeBoard(int boardNo);
	void reportBoard(int boardNo);

	List<BoardVO> readRecomRevList();
	List<BoardVO> readNoticeRevList();

	List<CommentVO> readCommentList(int boardNo);
	void createComment(CommentVO comment);
	void readMapCommentList(Map map);
	void removeComment(int comNo);
}
