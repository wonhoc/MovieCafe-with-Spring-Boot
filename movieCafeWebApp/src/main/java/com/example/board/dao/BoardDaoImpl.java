package com.example.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.vo.BoardFileVO;
import com.example.board.vo.BoardVO;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> selectList(int cateNo) {
		
		return this.sqlSession.selectList("selectByCateNo", cateNo);
	}

	@Override
	public void insertBoard(BoardVO board) {
		this.sqlSession.insert("insertBoardCall", board);
	}

	@Override
	public void insertBoardNewMem(BoardVO board) {
		this.sqlSession.insert("insertNewMemBoardCall",board);
		
	}

	@Override
	public void insertBoardFile(BoardFileVO file) {
		this.sqlSession.insert("insertBoardFileCall",file);
		
	}

	@Override
	public int lastId() {
		return this.sqlSession.selectOne("lastId");
	}

	@Override
	public void insertBoardTip(BoardVO board) {
		this.sqlSession.insert("insertTipBoardCall", board);
		
	}

	@Override
	public void updateBoard(BoardVO board) {
		this.sqlSession.update("updateBoardCall", board);
		
	}

	@Override
	public BoardVO selectBoard(int boardNo) {
		
		return this.sqlSession.selectOne("selectDetailBoard", boardNo);
	}

	@Override
	public void updateBoardNewMem(BoardVO board) {
		this.sqlSession.update("updateBoardNewMemCall", board);
		
	}

	
}
