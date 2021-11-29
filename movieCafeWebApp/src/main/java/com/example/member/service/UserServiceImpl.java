package com.example.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member.dao.UserDao;
import com.example.member.vo.UserInfoVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int isCheckUserCount(Map map) {
		return this.userDao.checkIsUser(map);
	}

	@Override
	public UserInfoVo uploadUserInfo(String userId) {
		return this.userDao.sendUserInfo(userId);
		
	}

	@Override
	public UserInfoVo insertUserInfo(UserInfoVo user) {
		return this.userDao.registUserInfo(user);
	}

	@Override
	public int isCheckId(String isId) {
		return this.userDao.isExistId(isId);
	}

	@Override
	public int isCheckNick(String isNick) {
		return this.userDao.isExistNick(isNick);
	}

	@Override
	public List<UserInfoVo> retrieveUserList() {
		return this.userDao.selectUserList();
	}

	@Override
	public UserInfoVo retrieveUser(String userId) {
		return this.userDao.selectUser(userId);
		
	}

	@Override
	public void modifyUser(UserInfoVo user) {
		this.userDao.update(user);
		
	}

	

	@Override
	public void removeUser(String userId) {
		this.userDao.deleteUser(userId);
		
	}

	
}
