package com.example.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.service.BoardService;
import com.example.board.vo.RecomVO;
import com.example.member.vo.UserInfoVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RecomController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/insertRecom")
	public Map insertRecom(RecomVO recommend, HttpServletRequest req) {

		HttpSession session = req.getSession();
		UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = userInfo.getUserId();
		System.out.println("userId");

		int boardNo = recommend.getBoardNo();
		RecomVO recom = new RecomVO(userId, boardNo);

		boolean isRecomed = this.boardService.readIsRecom(recom);

		if (isRecomed) {
			this.boardService.dropRecommend(recom);
			map.put("result", "추천 취소");
		} else {
			this.boardService.createRecommend(recom);
			map.put("result", "추천 완료");
		}

		return map;
	}
}
