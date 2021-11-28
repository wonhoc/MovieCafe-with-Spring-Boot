package com.example.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie.dao.GuanramDao;
import com.example.movie.vo.GuanramListVO;
import com.example.movie.vo.MovieGuanramVO;

@Service("guanramService")
public class GuanramServiceImpl implements GuanramService {
	@Autowired
	private GuanramDao guanramDao;

	@Override
	public void registerGuanram(MovieGuanramVO guanram) {
		this.guanramDao.insertGuanram(guanram);

	}

	@Override
	public List<GuanramListVO> selectGuanramList(int movieNo) {
		return this.guanramDao.selectGuanramList(movieNo);
	}

	@Override
	public void removeGuanram(int guanramNo) {
		this.guanramDao.deleteGuanram(guanramNo);

	}

	@Override
	public int upLikeGuanram(int movieNo, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
