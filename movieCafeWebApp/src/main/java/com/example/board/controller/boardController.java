package com.example.board.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

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
		if(cateNo==4)
		{
			return "views/board/boardwriteTip";
		}
		else	return "views/board/boardwrite";
	}
	
	@PostMapping("/fileUpload")
	public String boardwrite(BoardVO board, int cateNo, HttpServletRequest request, Model model) {
		/*
		HttpSession session  = request.getSession();
		model.addAttribute(session.getAttribute("userinfo"));
		*/
		this.boardServie.createBoard(board);
	
		return "redirect:/views/board/boardlist";
	}
	
	@PostMapping("/NewMemfileUpload")
	public String boardwriteNewMem(BoardVO board, int cateNo,HttpServletRequest request, Model model) {
		/*
		HttpSession session  = request.getSession();
		model.addAttribute(session.getAttribute("userinfo"));
		*/
		this.boardServie.createNewMemBoard(board);
	
		return "redirect:/views/board/boardlist";
	}
	
	@PostMapping("/tipfileUpload")
	public String boardwriteTip( int cateNo,BoardVO board,HttpServletRequest request, Model model) {
		
			this.boardServie.createTipBoard(board); 
		
	
		return "redirect:/views/board/boardlist";
	}
}
