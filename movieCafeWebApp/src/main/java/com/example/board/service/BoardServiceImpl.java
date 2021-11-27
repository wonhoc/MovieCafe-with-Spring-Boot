package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.BoardDao;
import com.example.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> readAllByCateNo(int cateNo) {
		return this.boardDao.selectList(cateNo);
	}

	@Override
	public BoardVO readOne(int boardNo) {
		return this.boardDao.selectBoard(boardNo);
	}

	
}
