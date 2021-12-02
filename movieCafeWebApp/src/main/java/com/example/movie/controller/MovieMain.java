package com.example.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;
import com.example.member.vo.UserInfoVo;
import com.example.movie.service.GuanramService;
import com.example.movie.vo.GuanramListVO;
import com.example.movie.vo.MovieGuanramVO;

@Controller
public class MovieMain {
	@Autowired
	private GuanramService guanramService;
	
	@Autowired
	private BoardService boardServie;
	
	@GetMapping("/")
	public String home(HttpSession session) {
		return "views/index";
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		List<BoardVO> recomList = this.boardServie.readRecomRevList();
		List<BoardVO> noticeList = this.boardServie.readNoticeRevList();
		model.addAttribute("recomList", recomList);
		model.addAttribute("noticeList", noticeList);
		return "views/main";
	}

	@GetMapping("/detailMovie/{movieId}")
	public String detailMovie(@PathVariable String movieId, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		List<GuanramListVO> guanramList = this.guanramService.selectGuanramList(Integer.parseInt(movieId));
		UserInfoVo userInfo = (UserInfoVo)session.getAttribute("userInfo");
		
		model.addAttribute("guanramList", guanramList);
		model.addAttribute("userInfo", userInfo);
		return "views/movie/detailMovie";
	}

	@GetMapping("/guanramList")
	public @ResponseBody List<GuanramListVO> guanramList(@RequestParam("movieId") String movieId) {
		return this.guanramService.selectGuanramList(Integer.parseInt(movieId));
	}
	

	@PostMapping("/guanramForm")
	public String guanramForm(@RequestParam("movieId") String movieId, @RequestParam("imgUrl") String imgUrl,
			@RequestParam("title") String title, Model model) {
		model.addAttribute("movieId", movieId);
		model.addAttribute("imgUrl", imgUrl);
		model.addAttribute("title", title);
		return "views/movie/registerGuanram";
	}

	@PostMapping("/detailMovie/{movieId}")
	public String registerGuanram(@PathVariable String movieId,
			@RequestParam("movieId") String movieNo, @RequestParam("userId") String userId,
			@RequestParam("review") String review, @RequestParam("rating") int rating, Model model) {
		MovieGuanramVO guanram = new MovieGuanramVO(userId, Integer.parseInt(movieNo), review, rating);
		this.guanramService.registerGuanram(guanram);
		List<GuanramListVO> guanramList = this.guanramService.selectGuanramList(Integer.parseInt(movieNo));
		model.addAttribute("guanramList", guanramList);
		return "redirect:/detailMovie/" + movieId;
	}
	
	@PostMapping("/deleteGuanram/{movieId}")
	public String deleteGuanram(@PathVariable String movieId, @RequestParam("guanramNo") int guanramNo, Model model) {
		this.guanramService.removeGuanram(guanramNo);
		List<GuanramListVO> guanramList = this.guanramService.selectGuanramList(Integer.parseInt(movieId));
		model.addAttribute("guanramList", guanramList);
		return "views/movie/detailMovie";
	}
	
	@GetMapping("/upLike")
	public @ResponseBody int upLike(@RequestParam("guanramNo") int guanramNo) {
		int likeCount = this.guanramService.upLikeGuanram(guanramNo);
		return likeCount;
	}
}
