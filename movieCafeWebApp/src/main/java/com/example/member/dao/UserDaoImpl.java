package com.example.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.member.vo.UserInfoVo;

@Repository("userInfoDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int checkIsUser(Map map) {
		return sqlSession.selectOne("Member.checkIsUser", map); 
	}


	@Override
	public UserInfoVo sendUserInfo(String user) { 
		return sqlSession.selectOne("Member.loginUser", user);
	}


	@Override
	public UserInfoVo registUserInfo(UserInfoVo user) {
		System.out.println(user.toString());
		return sqlSession.selectOne("Member.insertUser", user);
	}


	@Override
	public int isExistId(String isId) {
		return sqlSession.selectOne("Member.checkId", isId);
	}


	@Override
	public int isExistNick(String isNick) {
		return sqlSession.selectOne("Member.checkNick", isNick);

	}

}
