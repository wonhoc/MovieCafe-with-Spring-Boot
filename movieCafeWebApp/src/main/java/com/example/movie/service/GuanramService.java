package com.example.movie.service;

import java.util.List;

import com.example.movie.vo.GuanramListVO;
import com.example.movie.vo.MovieGuanramVO;

public interface GuanramService {
	void registerGuanram(MovieGuanramVO guanram);
	List<GuanramListVO> selectGuanramList(int movieNo);
	public void removeGuanram(int guanramNo);
	public int upLikeGuanram(int guanramNo);
}
