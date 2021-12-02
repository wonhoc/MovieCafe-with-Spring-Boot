package com.example.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.service.BoardService;
import com.example.board.vo.CommentVO;
import com.example.member.vo.UserInfoVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class commentController {

	@Autowired
	private BoardService boardService;
	
	
	@PostMapping("/createcom")
	   public Map comCreate(@RequestBody CommentVO comment, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
	      
		
		System.out.println("userInfo = "+userInfo.getUserId());	
		
		
		
		
	      int boardNo = comment.getBoardNo();
	      System.out.println("boardNo"+boardNo);
	      System.out.println("userInfo.getUserId() = "+userInfo.getUserId());
	      
	      comment.setUserId(userInfo.getUserId());
	      
	      Map<String, Object> map = new HashMap<String, Object>();
	      this.boardService.createComment(comment);
	      List<CommentVO> list = boardService.readCommentList(boardNo);
	      
	      System.out.println(list.toString());
	      
	      map.put("results", list);
	      
	      return map;
	   }
	
	
	@PostMapping("/remove/{comNo}/{boardNo}")
	public Map removeMap(@PathVariable("comNo") int comNo, @PathVariable("boardNo") int boardNo,HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
		Map<Object, Object> map = new HashMap<Object, Object>();
		model.addAttribute("userInfo", userInfo);
		
		map.put(boardNo, boardNo);
		this.boardService.removeComment(comNo);
		List<CommentVO> list = boardService.readCommentList(boardNo);
		map.put("results", list);
		return map;
	}
	

	@PostMapping("/modifycom")
	   public Map modifyMap(@RequestBody CommentVO comment, HttpServletRequest req) {
	      HttpSession session = req.getSession();
	      UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
	      Map<String, Object> map = new HashMap<String, Object>();
	      CommentVO modiCom = new CommentVO(comment.getComNo(), comment.getComContent());
	      this.boardService.modifyComment(modiCom);
	      List<CommentVO> list = boardService.readCommentList(comment.getBoardNo());
	      map.put("results", list);
	      return map;
	   }
}
 