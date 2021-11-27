package com.example.biz;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.member.service.UserService;

@SpringBootTest
class MovieCafeWebAppApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void test() {

		Map<String, String> map = new HashMap<String, String>();

		map.put("userId", "test_user01");
		map.put("userPwd", "asdf1234");

		int isCheckUser = this.userService.isCheckUserCount(map);
		System.out.println(isCheckUser);
		if (isCheckUser == 1) {
			System.out.println(userService.uploadUserInfo(map.get("userId")).toString());

		}
	}

}
