package com.example.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;

@Controller
public class boardController {

	@Autowired
	private BoardService boardServie;

	@GetMapping("/")
	public String main() {
		return "views/main";
	}
	

	@GetMapping("/boardwrite/{cateNo}")
	public String boardwrite(@PathVariable int cateNo, HttpServletRequest request, Model model) {
		/*
		HttpSession session  = request.getSession();
		model.addAttribute(session.getAttribute("userinfo"));
		*/
		model.addAttribute("rankType","A");
		
		return "views/board/boardwrite";
	}
	
	@PostMapping("/fileUpload")
	public String boardwrite(BoardVO board, HttpServletRequest request, Model model) {
		/*
		HttpSession session  = request.getSession();
		model.addAttribute(session.getAttribute("userinfo"));
		*/
		this.boardServie.createBoard(board);
		
		
		
		
		
		return "redirect:/views/board/boardlist";
	}
}
