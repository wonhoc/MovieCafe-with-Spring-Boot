package com.example.board.service;

import java.util.List;

import com.example.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> readAllByCateNo(int cateNo);
	void createBoard(BoardVO board);
	void createNewMemBoard(BoardVO board);
	void createTipBoard(BoardVO board);
	
}
