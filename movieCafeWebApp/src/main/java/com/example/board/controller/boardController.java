package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;

@Controller
public class boardController {

	@Autowired
	private BoardService boardServie;
	
	@GetMapping("/boardlist/{cateNo}")
	public String boardlist(@PathVariable int cateNo, Model model) {
		
		List<BoardVO> list = boardServie.readAllByCateNo(cateNo);
		model.addAttribute("list",list);
		
		return "views/board/boardlist";
	}
	
	@GetMapping("/detail/{boardNo}")
	public String deltailboard(@PathVariable int boardNo, Model model) {
		
		BoardVO board = boardServie.readOne(boardNo);
		
		model.addAttribute("board",board);
		
		return "views/board/boardDetail";
	}
	 
	
}
