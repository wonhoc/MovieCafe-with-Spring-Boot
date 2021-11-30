package com.example.board.dao;

import java.util.List;
import java.util.Map;

import com.example.board.vo.BoardFileVO;
import com.example.board.vo.BoardVO;
import com.example.board.vo.CommentVO;

public interface BoardDao {

	List<BoardVO> selectList(int cateNo);
	BoardVO selectBoard(int boardNo);
	void insertBoard(BoardVO board);
	void insertBoardFile(BoardFileVO file);
	void insertBoardTip(BoardVO board);
	void updateBoard(BoardVO board);
	void deleteBoard(int boardNo);	
	void reportBoardDao(int bordNo);	
	int lastId();
	List<BoardVO> selectRecomRevList();
	List<BoardVO> selectNoticeRevList();
	List selectComList(int boardNo);
	void insertComment(CommentVO comment);
	void selectMap(Map map);
}
