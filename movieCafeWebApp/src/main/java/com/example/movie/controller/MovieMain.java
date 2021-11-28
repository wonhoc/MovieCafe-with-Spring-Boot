package com.example.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.movie.service.GuanramService;
import com.example.movie.vo.GuanramListVO;
import com.example.movie.vo.MovieGuanramVO;

@Controller
public class MovieMain {
	@Autowired
	private GuanramService guanramService;
	
	@GetMapping("/")
	public String home() {
		return "views/main";
	}

	@GetMapping("/detailMovie/{movieId}")
	public String detailMovie(@PathVariable String movieId, Model model) {
		List<GuanramListVO> guanramList = this.guanramService.selectGuanramList(Integer.parseInt(movieId));
		model.addAttribute("guanramList", guanramList);
		return "views/movie/detailMovie";
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
	public String registerGuanram(@PathVariable String movieId, @RequestParam("movieId") String movieNo, @RequestParam("userId") String userId,
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
}
