package com.example.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public BoardVO selectBoard(int boardNo) {
		
		return this.sqlSession.selectOne("selectDetailBoard", boardNo);
	}

	@Override
	public void deleteBoard(int boardNo) {
		this.sqlSession.delete("deleteBoard", boardNo);
	}

	@Override
	public void reportBoardDao(int bordNo) {
		this.sqlSession.insert("reportBoard", bordNo);
	}

	
}
