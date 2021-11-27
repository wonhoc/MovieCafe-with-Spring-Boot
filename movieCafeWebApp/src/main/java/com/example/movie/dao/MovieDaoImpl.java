package com.example.movie.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.movie.vo.MovieInfoVO;

@Repository("movieDao")
public class MovieDaoImpl implements MovieDao {
	@Autowired
	private SqlSession sqlSession; 

	@Override
	public void insertMovie(MovieInfoVO movie) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareMovie(String movieTitle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<MovieInfoVO> selectMovieList(int startRow, int postSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTotalMovieCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteMovie(int movieNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public MovieInfoVO selectMovie(int movieNo) {
		return this.sqlSession.selectOne("Movie.selectMovie", movieNo);
	}

	@Override
	public void updateMovie(MovieInfoVO movie) {
		// TODO Auto-generated method stub

	}

}
