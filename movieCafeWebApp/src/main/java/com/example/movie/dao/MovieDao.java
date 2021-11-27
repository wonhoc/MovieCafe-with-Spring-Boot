package com.example.movie.dao;

import java.util.ArrayList;

import com.example.movie.vo.MovieInfoVO;

public interface MovieDao {
	void insertMovie(MovieInfoVO movie);
	int compareMovie(String movieTitle);
	ArrayList<MovieInfoVO> selectMovieList(int startRow, int postSize);
	int selectTotalMovieCount();
	void deleteMovie(int movieNo);
	MovieInfoVO selectMovie(int movieNo);
	void updateMovie(MovieInfoVO movie);
}
