package com.example.movie.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.movie.vo.GuanramListVO;
import com.example.movie.vo.MovieGuanramVO;

@Repository("guanramDao")
public class GuanramDaoImpl implements GuanramDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<GuanramListVO> selectGuanramList(int movieNo) {
		List<GuanramListVO> guanramList = new ArrayList<GuanramListVO>();
		guanramList = this.sqlSession.selectList("Movie.selectGuanramList", movieNo);
		return guanramList;
	}

	@Override
	public void insertGuanram(MovieGuanramVO guanram) {
		this.sqlSession.insert("Movie.insertGuanram", guanram);
	}

	@Override
	public int compareUserId(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteGuanram(int guanramNo) {
		this.sqlSession.delete("Movie.deleteGuanram", guanramNo);

	}

	@Override
	public void deleteMovieGuanram(int movieNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void upLikecount(int movieNo, String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int selectGuanramLike(int movieNo, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
