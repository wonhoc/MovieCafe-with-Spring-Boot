package com.example.biz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.member.dao.UserDao;
import com.example.member.domain.UserInfoVo;

@SpringBootTest
class MovieCafeWebAppApplicationTests {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test1() {
		UserInfoVo user = new UserInfoVo();
		user.setUserId("test_user01");
		user.setUserPwd("asdf1234");
		
		
		int result = this.userDao.checkIsUser(user);
		System.out.println(result);
	}

}
