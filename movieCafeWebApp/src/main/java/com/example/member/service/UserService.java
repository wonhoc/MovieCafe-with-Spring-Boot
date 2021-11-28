package com.example.member.service;

import java.util.Map;

import com.example.member.vo.UserInfoVo;

public interface UserService {
	int isCheckUserCount(Map map);
	UserInfoVo uploadUserInfo(String userId);
	UserInfoVo insertUserInfo(UserInfoVo user);
	int isCheckId(String isId);
	int isCheckNick(String isNick);
	

}
