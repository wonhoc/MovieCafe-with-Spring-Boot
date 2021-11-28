package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie.dao.GuanramDao;
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
	public void removeGuanram(int movieNo, String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int upLikeGuanram(int movieNo, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
