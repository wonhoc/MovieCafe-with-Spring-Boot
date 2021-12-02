package com.example.cardBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.vo.BoardVO;
import com.example.cardBoard.dao.CardBoardDao;

@Service("cardBoardService")
public class CardBoardServiceImpl implements CardBoardService {

	@Autowired
	private CardBoardDao cardBoardDao;
	
	//리뷰게시판 목록 요청
	@Override
	public List<BoardVO> getCardBoardList() {
		
	return this.cardBoardDao.selectCardBoardList();
		
	}//getCardBoardList() end

	@Override
	public BoardVO getCardBoardDetail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}//class end
