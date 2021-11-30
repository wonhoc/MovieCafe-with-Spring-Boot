package com.example.board.service;

import java.util.ArrayList;
import java.util.List;

import com.example.board.vo.BoardVO;
import com.example.board.vo.RecomVO;

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

	//추천
	void createRecommend(RecomVO recommend);
	void dropRecommend(RecomVO recommend);
	boolean readIsRecom(RecomVO recommend);
	
}
