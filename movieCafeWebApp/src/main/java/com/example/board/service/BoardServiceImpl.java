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
		return this.boardDao.selectList(cateNo);
	}

	

	@Override
	public void removeBoard(int boardNo) {
		this.boardDao.deleteBoard(boardNo);
	}

	@Override
	public void reportBoard(int boardNo) {
		this.boardDao.reportBoardDao(boardNo);
	}
	
  @Override
	public void createBoard(BoardVO board) {
		/*int no = boardDao.lastId();
		
		
		if(board.getBoardfileList() != null) {
		for (BoardFileVO file : board.getBoardfileList()) {
		
			file.setBoardNo(no);
			this.boardDao.insertBoardFile(file);
		}
		}
		*/
		this.boardDao.insertBoard(board);
	}

	@Override
	public void createNewMemBoard(BoardVO board) {
		this.boardDao.insertBoardNewMem(board);
		
	}

	@Override
	public void createTipBoard(BoardVO board) {
		this.boardDao.insertBoardTip(board);
		
	}

	@Override
	public void modifyBoard(BoardVO board) {
		this.boardDao.updateBoard(board);
		
	}
	
	@Override
	public void modifyBoardNewMem(BoardVO board) {
		this.boardDao.updateBoardNewMem(board);
		
	}

	@Override
	public BoardVO readOne(int boardNo) {
		return this.boardDao.selectBoard(boardNo);
	}

	public List<BoardVO> readRecomRevList() {
		return this.boardDao.selectRecomRevList();
	}
	@Override
	public List<BoardVO> readNoticeRevList() {
		return this.boardDao.selectNoticeRevList();
	}

}
