package com.example.movie.dao;

import java.util.ArrayList;

import com.example.movie.vo.GuanramListVO;
import com.example.movie.vo.MovieGuanramVO;

public interface GuanramDao {
	ArrayList<GuanramListVO> selectGuanramList(int movieNo);
	void insertGuanram(MovieGuanramVO guanram);
	int compareUserId(String userId);
	void deleteGuanram(int movieNo, String userId);
	void deleteMovieGuanram(int movieNo);
	void upLikecount(int movieNo, String userId);
	int selectGuanramLike(int movieNo, String userId);
}
