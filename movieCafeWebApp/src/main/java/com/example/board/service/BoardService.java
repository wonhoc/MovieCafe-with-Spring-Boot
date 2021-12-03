package com.example.board.service;

import java.util.List;
import java.util.Map;

import com.example.board.vo.BoardFileVO;
import com.example.board.vo.BoardVO;
import com.example.board.vo.CommentVO;
import com.example.board.vo.RecomVO;
import com.example.board.vo.ReportVO;
import com.example.board.vo.SearchVO;

public interface BoardService {

	List<BoardVO> readAllByCateNo(int cateNo);	
	BoardVO readOne(int boardNo);
	void createBoard(BoardVO board);
	void createTipBoard(BoardVO board);
	void modifyBoard(BoardVO board);
	void removeBoard(int boardNo);
	int readRecomCount(int boardNo);
	int readCommCount(int boardNo);

	//검색추가 코드
	List<BoardVO> searchBoard(SearchVO search);
	
	
	List<BoardVO> readRecomRevList();
	List<BoardVO> readNoticeRevList();

	
	//파일 등록
	void createFile(BoardFileVO file);
	int lastId();
	void modifyFile(BoardFileVO file);
	void removeFile(int boardFileNo);
	BoardFileVO readBoardFile(int boardNo);
	
	//추천
	void createRecommend(RecomVO recommend);
	void dropRecommend(RecomVO recommend);
	boolean readIsRecom(RecomVO recommend);

	//신고
	void createReport(ReportVO report);
	void dropReport(ReportVO report);
	boolean readIsReport(ReportVO report);
	

	List<CommentVO> readCommentList(int boardNo);
	void createComment(CommentVO comment);
	void readMapCommentList(Map map);
	void removeComment(int comNo);
	void modifyComment(CommentVO comment);
}
