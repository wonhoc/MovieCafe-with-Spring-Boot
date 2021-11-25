package com.example.dao.member;

import com.example.domain.member.UserInfoVo;

public interface UserDao {
	
	int checkIsUser(UserInfoVo userInfoVo);
	void loginUser(UserInfoVo userInfVo);
	

}
