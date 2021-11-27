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
	private BoardService boardService;
	
	@GetMapping("/boardlist/{cateNo}")
	public String boardlist(@PathVariable int cateNo, Model model) {
		
		System.out.println(cateNo);
		List<BoardVO> list = boardService.readAllByCateNo(cateNo);
		
		System.out.println(list.toString());
		
		model.addAttribute("list",list);
		
		return "views/board/boardlist";
	}
	
}
