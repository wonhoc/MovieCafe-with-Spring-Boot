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
		
		return null;
	}

	@Override
	public List<BoardVO> selectRecomRevList() {
		return this.sqlSession.selectList("Board.mainBestListSelect");
	}
	@Override
	public List<BoardVO> selectNoticeRevList() {
		return this.sqlSession.selectList("Board.mainNoticeListSelect");
	}
}
