package com.example.cardBoard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.vo.BoardVO;
import com.example.cardBoard.dao.CardBoardDao;

@Service("cardBoardService")
public class CardBoardServiceImpl implements CardBoardService {

	@Autowired
	private CardBoardDao cardBoardDao;
	
	//리뷰게시판 목록
	@Override
	public List<BoardVO> getCardBoardList() {
		
	return this.cardBoardDao.selectCardBoardList();
		
	}//getCardBoardList() end
	
	//리뷰게시판 상세보기
	@Override
	public BoardVO getCardBoardDetail(int boardNo) {
		
		return this.cardBoardDao.selectCardBoard(boardNo);
		
	}//getCardBoardDetail() end

	@Override
	public void writeBoard(HashMap<String, Object> boardMap) {
		
		//게시글 입력
		int BoardNo = this.cardBoardDao.insertBoard(boardMap);
		
	}//writeBoard() end
	
	
	
	
	
}//class end
