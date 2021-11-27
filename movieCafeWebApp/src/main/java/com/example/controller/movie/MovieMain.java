package com.example.controller.movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieMain {
	@GetMapping("/")
	public String home() {
		return "views/main";
	}
	
	@GetMapping("/detail")
	public String detailMovie() {
		return "movie/detailMovie";
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
