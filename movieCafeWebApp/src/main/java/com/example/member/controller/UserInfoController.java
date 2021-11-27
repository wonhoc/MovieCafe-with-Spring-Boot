package com.example.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member.service.UserService;

@Controller
public class UserInfoController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void loginController(@RequestParam(value = "userId") String userId, 
								@RequestParam (value="userPwd") String userPwd) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		
		int isCheckUser = this.userService.isCheckUserCount(map);
		System.out.println(isCheckUser);
		if (isCheckUser == 1) {
				System.out.println(userService.uploadUserInfo(userId).toString());
			
			}
		}
	

}
