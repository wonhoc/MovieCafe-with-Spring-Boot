package com.example.cardBoard.service;

import java.util.HashMap;
import java.util.List;

import com.example.board.vo.BoardVO;

public interface CardBoardService {

	public List<BoardVO> getCardBoardList();
	public BoardVO getCardBoardDetail(int boardNo);
	public void writeBoard(HashMap<String, Object> boardMap);
	public void upBoardCount(int boarNo);
	public void removeCardBoard(int boarNo);
	public void modifyCardBoard(HashMap<String, Object> modifyBoard);
}//interface end
