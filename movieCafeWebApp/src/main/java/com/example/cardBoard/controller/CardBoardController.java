package com.example.cardBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.board.vo.BoardVO;
import com.example.cardBoard.service.CardBoardService;

@Controller
public class CardBoardController {
	
	@Autowired
	private CardBoardService cardBoardService;

	private final String path = "views/cardBoard/";	//경로
	
	//리뷰게시판 목록 요청
	@GetMapping("/cardBoardList")
	public String cardBoardList() {
		
	List<BoardVO> cardBoardList = this.cardBoardService.getCardBoardList();
	
		System.out.println("cardBoardList size = " + cardBoardList.size());
		
	return path + "cardBoardList";
	
	}//cardBoardList() end
	
	
}//class end
