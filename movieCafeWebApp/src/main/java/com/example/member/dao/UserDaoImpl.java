package com.example.member.dao;

import java.sql.ResultSet;
import java.util.List;
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
	public List<UserInfoVo> selectUserList() {
		return this.sqlSession.selectList("Member.selectAll");
	}


	@Override
	public UserInfoVo selectUser(String userId) {
		return this.sqlSession.selectOne("Member.selectOne", userId);
		
	}


	@Override
	public void update(UserInfoVo user) {
		this.sqlSession.update("Member.update", user);
		
	}


	


	@Override
	public void deleteUser(String userId) {
		this.sqlSession.update("Member.selfDelete", userId);
		
	}

	
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
	
	// 권한 설정을 위해 유저 정보 가져옴
	// DAO는 기존거 활용
	@Override
	public UserInfoVo getUserByID(String userId) {		
		System.out.println("DAO 아이디 출력값 : "+userId);

		return sqlSession.selectOne("Member.loginUser", userId);
		
	}

}
