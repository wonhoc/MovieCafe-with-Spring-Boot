package com.example.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.service.BoardService;
import com.example.board.vo.CommentVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class commentController {

	@Autowired
	private BoardService boardService;
	
	
	@PostMapping("/createCom")
	public Map comCreate(@RequestBody CommentVO comment) {
		comment.setUserId("test_user01");
		Map<String, Object> map = new HashMap<String, Object>();
		this.boardService.createComment(comment);
		this.boardService.readMapCommentList(map); 
		List<CommentVO> commentList  = (List<CommentVO>)map.get("results");
		return map;
	}
	
	
	@PostMapping("/remove/{comNo}/{boardNo}")
	public Map removeMap(@PathVariable("comNo") int comNo, @PathVariable("boardNo") int boardNo) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(boardNo, boardNo);
		this.boardService.removeComment(comNo);
		List<CommentVO> list = boardService.readCommentList(boardNo);
		map.put("results", list);
		return map;
	}
}
 