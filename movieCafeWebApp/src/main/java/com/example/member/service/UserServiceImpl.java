package com.example.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member.dao.UserDao;
import com.example.member.domain.UserInfoVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int isCheckUserCount(UserInfoVo user) {
		return this.userDao.checkIsUser(user);
	}

}
