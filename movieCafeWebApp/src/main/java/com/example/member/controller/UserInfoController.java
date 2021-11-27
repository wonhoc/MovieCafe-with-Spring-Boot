package com.example.member.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member.service.UserService;

@Controller
public class UserInfoController {
	@Autowired
	private UserService userService;
	
	public SqlSessionTemplate session;
	
	@RequestMapping("/login")
	public void loginController(@RequestParam S) {
		int isCheckUser = this.userService.isCheckUserCount(user);
		if (isCheckUser == 1) {
			
			()
			
			
			
		}
		
	}

}
