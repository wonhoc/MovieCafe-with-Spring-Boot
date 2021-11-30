package com.example.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.service.BoardService;
import com.example.board.vo.RecomVO;
import com.example.board.vo.ReportVO;
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
	
	@GetMapping("/insertReport")
	public Map insertReport(ReportVO report, HttpServletRequest req) {

		HttpSession session = req.getSession();
		UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
		Map<String, Object> map = new HashMap<String, Object>();
		String repoter = userInfo.getUserId();
		
		int boardNo = report.getBoardNo();
		
		String userId = report.getUserId();
		ReportVO reports = new ReportVO(boardNo, userId, repoter);
		ReportVO reportHasTwo = new ReportVO(boardNo, repoter);
		boolean isReported = this.boardService.readIsReport(reportHasTwo);
		System.out.println(isReported);
		if (isReported) {
			this.boardService.dropReport(reportHasTwo);
			map.put("result", "신고 취소");
		} else {
			this.boardService.createReport(reports);
			map.put("result", "신고 완료");
		}

		return map;
	}
}
