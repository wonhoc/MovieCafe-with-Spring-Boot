package com.example.cardBoard.dao;

import java.util.HashMap;
import java.util.List;

import com.example.board.vo.BoardFileVO;
import com.example.cardBoard.vo.BoardVO;

public interface CardBoardDao {

	public List<BoardVO> selectCardBoardList();
	public BoardVO selectCardBoard(int boardNo);
	public int insertBoard(HashMap<String, Object> boardMap);
	public void insertBoardFile(HashMap<String, Object> boardFileMap);
	public void updateBoardCount(int boarNo);
	public void deleteCardBoard(int boarNo);
	public void updateCardBoard(HashMap<String, Object> modifyBoard);
	public List<BoardFileVO> selectBoardFileLisrt();
	public List<BoardFileVO> selectBoardFile(int boarNo);
}//interface end
