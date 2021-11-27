package com.example.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.BoardDao;
import com.example.board.vo.BoardFileVO;
import com.example.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> readAllByCateNo(int cateNo) {
		return null;
	}

	@Override
	public void createBoard(BoardVO board) {
		int no = boardDao.lastId();
		
		
		if(board.getBoardfileList() != null) {
		for (BoardFileVO file : board.getBoardfileList()) {
		
			file.setBoardNo(no);
			this.boardDao.insertBoardFile(file);
		}
		}
		this.boardDao.insertBoard(board);
	}

}
