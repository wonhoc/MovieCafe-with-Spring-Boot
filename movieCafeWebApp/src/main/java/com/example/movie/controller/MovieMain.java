package com.example.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieMain {
	@GetMapping("/")
	public String home() {
		return "views/main";
	}
	
	@GetMapping("/detailMovie/{movieId}")
	public String detailMovie(@PathVariable String movieId) {
		return "views/movie/detailMovie";
	}
	
	@GetMapping("/boardForm")
	public String boardForm() {
		return "movie/movieBoardForm";
	}
	
	@GetMapping("/guanramForm")
	public String guanramForm() {
		return "movie/registerGuanram";
	}
}
