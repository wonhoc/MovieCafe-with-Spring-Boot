package com.example.member.dao;

import java.util.Map;

import com.example.member.vo.UserInfoVo;

public interface UserDao {
	
	int checkIsUser(Map map);
	UserInfoVo sendUserInfo(String user);
	UserInfoVo registUserInfo(UserInfoVo user);
	int isExistId(String isId);
	int isExistNick(String isNick);
	
	
	

}
