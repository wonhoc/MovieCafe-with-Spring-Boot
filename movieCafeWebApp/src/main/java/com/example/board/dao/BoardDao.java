package com.example.board.dao;

import java.util.List;
import java.util.Map;

import com.example.board.vo.BoardFileVO;
import com.example.board.vo.BoardVO;
import com.example.board.vo.CommentVO;
import com.example.board.vo.RecomVO;
import com.example.board.vo.ReportVO;

public interface BoardDao {

	List<BoardVO> selectList(int cateNo);
	BoardVO selectBoard(int boardNo);
	void insertBoard(BoardVO board);
	void insertBoardFile(BoardFileVO file);
	void insertBoardTip(BoardVO board);
	void updateBoard(BoardVO board);
	void deleteBoard(int boardNo);	
	
	void insertRecommend(RecomVO recommend);
	void deleteRecommend(RecomVO recommend);
	boolean selectIsRecom(RecomVO recommend);
	
	void insertReport(ReportVO report);
	void deleteReport(ReportVO report);
	boolean selectIsReport(ReportVO report);
	int lastId();
	List<BoardVO> selectRecomRevList();
	List<BoardVO> selectNoticeRevList();

	
	List selectComList(int boardNo);
	void insertComment(CommentVO comment);
	void selectMap(Map map);
	void deleteComment(int comNo);
	void updateComment(CommentVO comment);

}
