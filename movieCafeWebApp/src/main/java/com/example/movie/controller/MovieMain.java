package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.movie.service.GuanramService;
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
	public String detailMovie(@PathVariable String movieId) {
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
	public String registerGuanram(@RequestParam("movieId") String movieId, @RequestParam("userId") String userId,
			@RequestParam("review") String review, @RequestParam("rating") int rating) {
		MovieGuanramVO guanram = new MovieGuanramVO(userId, Integer.parseInt(movieId), review, rating);
		this.guanramService.registerGuanram(guanram);
		return "views/movie/detailMovie";
	}
}
