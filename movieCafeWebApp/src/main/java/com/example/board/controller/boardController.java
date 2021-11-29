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

	@GetMapping("/boardwrite/{cateNo}")
	public String boardwrite(@PathVariable int cateNo, HttpServletRequest request, Model model) {
		/*
		 * HttpSession session = request.getSession();
		 * model.addAttribute(session.getAttribute("userinfo"));
		 */
		model.addAttribute("rankType", "A");
		if (cateNo == 4) {
			return "views/board/boardwriteTip";
		} else
			return "views/board/boardwrite";
	}

	@PostMapping("/fileUpload")
	public String boardwrite(BoardVO board, int cateNo, HttpServletRequest request, Model model) {
		/*
		 * HttpSession session = request.getSession();
		 * model.addAttribute(session.getAttribute("userinfo"));
		 */
		this.boardServie.createBoard(board);

		return "redirect:/views/board/boardlist";
	}

	@PostMapping("/NewMemfileUpload")
	public String boardwriteNewMem(BoardVO board, int cateNo, HttpServletRequest request, Model model) {
		/*
		 * HttpSession session = request.getSession();
		 * model.addAttribute(session.getAttribute("userinfo"));
		 */
		this.boardServie.createNewMemBoard(board);

		return "redirect:/views/board/boardlist";
	}

	@PostMapping("/tipfileUpload")
	public String boardwriteTip(int cateNo, BoardVO board, HttpServletRequest request, Model model) {

		this.boardServie.createTipBoard(board);

		return "redirect:/views/board/boardlist";
	}

	// 게시글 상세보기
	@GetMapping("/detail/{boardNo}")
	public String deltailboard(@PathVariable int boardNo, Model model) {

		BoardVO board = boardServie.readOne(boardNo);

		model.addAttribute("board", board);
	

		return "views/board/boardDetail";
	}

	// 게시글 수정폼불러오기
	@GetMapping("/modifyform/{boardNo}")
	public String boardModifyForm(@PathVariable int boardNo,  Model model) {

		
		model.addAttribute("rankType", "A");
		BoardVO board = boardServie.readOne(boardNo);
		board.setBoardNo(boardNo);
		
		model.addAttribute("board",board);
		if(board.getHorseNo()>=1 && board.getHorseNo()<8  ) 
			{
			model.addAttribute("cateNo",2);
			return "views/board/boardModifyForm";
			}
		else if(board.getHorseNo()==8 || board.getHorseNo()==9  ) 
			{
			model.addAttribute("cateNo",3);
			return "views/board/boardModifyForm";
			}
		else if(board.getHorseNo()==10 || board.getHorseNo()== 11 )
			{
			model.addAttribute("cateNo",4);
			return "views/board/boardTipModifyForm";
			}
		else {
			model.addAttribute("cateNo",1);
			return "views/board/boardModifyForm";
		}
		
	}

	//게시글 수정
	@PostMapping("/modifyboard/{cateNo}")
	public String boardModify(BoardVO board, @PathVariable int cateNo, Model model) {
		/*
		 * HttpSession session = request.getSession();
		 * model.addAttribute(session.getAttribute("userinfo"));
		 */
		
		if (cateNo==1) this.boardServie.modifyBoardNewMem(board);
		else
		this.boardServie.modifyBoard(board);


		
	
		return "redirect:/boardlist/{cateNo}";
	}

}

