package com.example.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	
	@RequestMapping("/detail")
	public ModelAndView detailBoard(ModelAndView mav) {
		mav.setViewName("board/detailBoard");
		BoardVO board = new BoardVO(1,"제목", "2021-11-24 11:11:11","내용 김두부",5,"김두부");
	CommentVO  comment = new CommentVO(1,"댓글내용","2021-11-21 11:11:11","김두부",1);
	mav.addObject("cateNo",1);
mav.addObject("board",board);
mav.addObject("rankType",'A');
mav.addObject("comment",comment);
mav.addObject("horse","말머리");
	return mav;
	}
	
	@RequestMapping("/detailTip")
	public ModelAndView detailTip(ModelAndView mav) {
		mav.setViewName("board/detailBoardTip");
		BoardVO board = new BoardVO(1,"제목", "2021-11-24 11:11:11","내용 김두부",5,"김두부");
	CommentVO  comment = new CommentVO(1,"댓글내용","2021-11-21 11:11:11","김두부",1);
	mav.addObject("cateNo",1);
mav.addObject("board",board);
mav.addObject("rankType",'A');
mav.addObject("comment",comment);
mav.addObject("horse","말머리");
	return mav;
	
	}
}
