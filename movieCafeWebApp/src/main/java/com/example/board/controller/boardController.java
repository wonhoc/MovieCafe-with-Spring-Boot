package com.example.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	 
	@PostMapping("/detail/deleteBoard/{boardNo}")
	public String deleteBoard(@PathVariable int boardNo, @RequestParam("cateNo") int cateNo) {
		
		System.out.println("카테고리 넘버 = " + cateNo);
		
		System.out.println("넘버 = "+ boardNo);
		
		this.boardServie.removeBoard(boardNo);
		
		if (cateNo == 1) {
			return "redirect:/boardlist/1";
		}else if(cateNo ==2){
			return "redirect:/boardlist/2";
		}else if(cateNo ==3){
			return "redirect:/boardlist/3";
		}else{
			return "redirect:/boardlist/4";
	}

	}
	
	@GetMapping("/detail/report/{boardNo}")
	public String report(@PathVariable int boardNo) {
		
		this.boardServie.reportBoard(boardNo);
		
		return "redirect://detail/{boardNo}";
	}
	
	
	
}