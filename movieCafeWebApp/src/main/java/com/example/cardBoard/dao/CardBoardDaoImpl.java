package com.example.cardBoard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.vo.BoardVO;

@Repository("cardBoardDao")
public class CardBoardDaoImpl implements CardBoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	 @Override
	public List<BoardVO> selectCardBoardList() {
		 
		 System.out.println("call selectCardBoardList()");
		
		return this.sqlSession.selectList("cardBoard.selectCardBoardList");
		
	}//selectCardBoardList() end
	
	
}//class end
