package com.example.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.service.BoardService;
import com.example.board.vo.CommentVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class commentController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/comWrite")
	
	public Map comWrite(CommentVO comment) {
		Map<String, Object> map = new HashMap<String, Object>();
		comment.setUserId("test_user01");
		int no = comment.getBoardNo();
		this.boardService.createComment(comment);
		this.boardService.readCommentList(no);
		this.boardService.readMapCommentList(map);
		List<CommentVO> commentList  = (List<CommentVO>)map.get("results");
		System.out.println("comList = " + commentList.toString());
		return map;
	}
 }