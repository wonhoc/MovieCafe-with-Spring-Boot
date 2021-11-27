package com.example.member.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.member.domain.UserInfoVo;

@Repository("userInfoDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSessionTemplate session;
	
	
	@Override
	public int checkIsUser(UserInfoVo userInfoVo) {
		String userId = userInfoVo.getUserId();
		String userPwd = userInfoVo.getUserPwd();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		
		return session.selectOne("Member.checkIsUser", map);
	}


	@Override
	public void loginUser(UserInfoVo userInfVo) {
		// TODO Auto-generated method stub
		
	}
}
