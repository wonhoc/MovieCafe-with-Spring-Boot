package com.example.cardBoard.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.vo.BoardFileVO;
import com.example.cardBoard.vo.BoardVO;

@Repository("cardBoardDao")
public class CardBoardDaoImpl implements CardBoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	 @Override
	public List<BoardVO> selectCardBoardList() {
		 
		 System.out.println("call selectCardBoardList()");
		
		return this.sqlSession.selectList("cardBoard.selectCardBoardList");
		
	}//selectCardBoardList() end

	@Override
	public BoardVO selectCardBoard(int boardNo) {
		
		return this.sqlSession.selectOne("cardBoard.selectCardBoard", boardNo);
		
	}//selectCardBoard() end

	@Override
	public int insertBoard(HashMap<String, Object> boardMap) {
		
		this.sqlSession.insert("cardBoard.insertCardBoard", boardMap);	
		
		System.out.println("boardNo = " + boardMap.get("boardNo"));
		
		BigInteger tempNo = (BigInteger)boardMap.get("boardNo");

		int boardNo = tempNo.intValue();
		
		//System.out.println("Dao boardNo : " + boardNo);
		
		return boardNo;
		
	}//insertBoard() end

	@Override
	public void insertBoardFile(HashMap<String, Object> boardFileMap) {
		
		this.sqlSession.insert("cardBoard.insertCardBoardFile", boardFileMap);
		
	}//insertBoardFile() end

	@Override
	public void updateBoardCount(int boarNo) {
		
		this.sqlSession.update("cardBoard.updateBoardCount", boarNo);
		
	}//updateBoardCount() end
	
	//게시글 삭제
	@Override
	public void deleteCardBoard(int boarNo) {
		
		this.sqlSession.delete("cardBoard.deleteCardBoard", boarNo);
		
	}//deleteCardBoard() end
	
	//게시글 수정
	@Override
	public void updateCardBoard(HashMap<String, Object> modifyBoard) {
		
		this.sqlSession.update("cardBoard.modifyCardBoard", modifyBoard);
		
	}//updateCardBoard() end
	
	//게시글 파일 가져오기
	@Override
	public List<BoardFileVO> selectBoardFileLisrt() {
		
	return this.sqlSession.selectList("cardBoard.selectboardFileList");
		
	}//selectBoardFileLisrt() end

	@Override
	public List<BoardFileVO> selectBoardFile(int boarNo) {

		return this.sqlSession.selectList("cardBoard.selectBoardFile", boarNo);
		
	}//selectBoardFile() end
	 
	 
	
	
}//class end
