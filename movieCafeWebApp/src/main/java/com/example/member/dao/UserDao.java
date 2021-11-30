package com.example.member.dao;

import java.util.List;
import java.util.Map;

import com.example.member.vo.UserInfoVo;

public interface UserDao {

	int checkIsUser(Map map);

	UserInfoVo sendUserInfo(String user);

	UserInfoVo registUserInfo(UserInfoVo user);

	int isExistId(String isId);

	int isExistNick(String isNick);

	// 관리자가 회원리스트조회를 한다
	List<UserInfoVo> selectUserList();

	// 회원상세정보조회
	UserInfoVo selectUser(String userId);

	void update(UserInfoVo user);

	

	// 자진탈퇴처리
	void deleteUser(String userId);
	
	public UserInfoVo getUserByID(String userId);

}
