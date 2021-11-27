package com.example.movie.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie.dao.MovieDao;
import com.example.movie.vo.MovieGuanramVO;
import com.example.movie.vo.MovieInfoVO;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao movieDao;

	@Override
	public void registerMovie(MovieInfoVO movie) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compaerMovie(String movieTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<MovieInfoVO> retrieveMovieList(int startRow, int postSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int retrieveTotalMovieCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeMovie(int movieNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public MovieInfoVO retrieveMovieDetail(int movieNo) {
		return this.movieDao.selectMovie(movieNo);
	}

	@Override
	public void modifyMovie(MovieInfoVO movie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerGuanram(MovieGuanramVO guanram) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeGuanram(int movieNo, String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int upLikeGuanram(int movieNo, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
