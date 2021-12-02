package com.example.board.dao;

import java.util.List;
import java.util.Map;

import com.example.board.vo.BoardFileVO;
import com.example.board.vo.BoardVO;
import com.example.board.vo.CommentVO;
import com.example.board.vo.RecomVO;
import com.example.board.vo.ReportVO;
import com.example.board.vo.SearchVO;

public interface BoardDao {

	List<BoardVO> selectList(int cateNo);
	BoardVO selectBoard(int boardNo);
	void insertBoard(BoardVO board);
	void insertBoardFile(BoardFileVO file);
	void insertBoardTip(BoardVO board);
	void updateBoard(BoardVO board);
	void deleteBoard(int boardNo);	
	
	// ************검색 추가 코드 시작*********************
	List<BoardVO> selectSearchByTitle(SearchVO search);
	List<BoardVO> selectSearchByContent(SearchVO search);
	List<BoardVO> selectSearchByUser(SearchVO search);
	List<BoardVO> selectSearchByAll(SearchVO search);
	List<BoardVO> selctSearchByHorse(SearchVO search);
	// ************검색 추가 코드 끝*********************
	
	//추천 수 구하기
	int selectRecomCount(int boardNo);
	int selectCommCount(int boardNo);
	
	// 댓글 수 구하기
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
