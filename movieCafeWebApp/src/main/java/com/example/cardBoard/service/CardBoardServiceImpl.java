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
		
		//게시글 파일 업로드
		HashMap<String, Object> boardFileMap = (HashMap<String, Object>)boardMap.get("boardFileMap");
		
		
		
		
	}//writeBoard() end
	
	//조회수 증가
	@Override
	public void upBoardCount(int boarNo) {
		
		this.cardBoardDao.updateBoardCount(boarNo);
		
	}//upBoardCount() end

	//게시글 삭제
	@Override
	public void removeCardBoard(int boarNo) {
		
		this.cardBoardDao.deleteCardBoard(boarNo);
		
	}
	
	//게시글 수정
	@Override
	public void modifyCardBoard(HashMap<String, Object> modifyBoard) {
		
		this.cardBoardDao.updateCardBoard(modifyBoard);
		
		
		
	}//modifyCardBoard() end
	
	
	
	
	
}//class end
