package com.example.member.dao;

import com.example.member.domain.UserInfoVo;

public interface UserDao {
	
	int checkIsUser(UserInfoVo userInfoVo);
	void loginUser(UserInfoVo userInfVo);
	

}
