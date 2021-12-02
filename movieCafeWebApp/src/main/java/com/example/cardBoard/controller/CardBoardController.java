package com.example.cardBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String cardBoardList(Model model) {
	
		//리뷰게시판 글 목록
		List<BoardVO> cardBoardList = this.cardBoardService.getCardBoardList();
		
		model.addAttribute("cardBoardList", cardBoardList);
			
		return path + "cardBoardList";
	
	}//cardBoardList() end
	
	//리뷰게시판 상세보기 요청
	@GetMapping("/cardBoardDetail/{cardboardNo}")
	public String cardBoardDetail(Model model) {
		
		//this.cardBoardService
		
		return path + "cardBoardDetail";
		
	}//cardBoardDetail () end
	
}//class end
