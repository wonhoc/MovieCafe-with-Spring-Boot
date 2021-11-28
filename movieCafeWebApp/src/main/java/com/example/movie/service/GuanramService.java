package com.example.movie.service;

import com.example.movie.vo.MovieGuanramVO;

public interface GuanramService {
	void registerGuanram(MovieGuanramVO guanram);
	public void removeGuanram(int movieNo, String userId);
	public int upLikeGuanram(int movieNo, String userId);
}
