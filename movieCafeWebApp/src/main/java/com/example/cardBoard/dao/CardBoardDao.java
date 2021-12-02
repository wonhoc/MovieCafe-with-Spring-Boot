package com.example.cardBoard.dao;

import java.util.HashMap;
import java.util.List;

import com.example.board.vo.BoardVO;

public interface CardBoardDao {

	public List<BoardVO> selectCardBoardList();
	public BoardVO selectCardBoard(int boardNo);
	public int insertBoard(HashMap<String, Object> boardMap);
	public void insertBoardFile(int boardNo);
}//interface end
