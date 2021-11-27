package com.example.service.movie;

import java.util.ArrayList;

import com.example.domain.movie.MovieGuanramVO;
import com.example.domain.movie.MovieInfoVO;

public interface MovieService {
	void registerMovie(MovieInfoVO movie);
	int compaerMovie(String movieTitle);
	ArrayList<MovieInfoVO> retrieveMovieList(int startRow, int postSize);
	int retrieveTotalMovieCount();
	void removeMovie(int movieNo);
	MovieInfoVO retrieveMovieDetail(int movieNo);
	public void modifyMovie(MovieInfoVO movie);
	public void registerGuanram(MovieGuanramVO guanram);
	void removeGuanram(int movieNo, String userId);
	public int upLikeGuanram(int movieNo, String userId);
}
