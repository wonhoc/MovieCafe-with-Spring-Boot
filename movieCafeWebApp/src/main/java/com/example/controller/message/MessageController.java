package com.example.controller.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
	
	//쪽지쓰기 폼 요청 
	@GetMapping("/sendMsgForm")
	public String sendMsgForm() {
		
		return "message/sendMsgForm";
		 
	}//sendMsgForm()
	
}//class end
