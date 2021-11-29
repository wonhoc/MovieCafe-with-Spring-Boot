package com.example.board.service;

import java.util.List;

import com.example.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> readAllByCateNo(int cateNo);
	
	BoardVO readOne(int boardNo);
	
	void removeBoard(int boardNo);
	
	void reportBoard(int boardNo);
}
