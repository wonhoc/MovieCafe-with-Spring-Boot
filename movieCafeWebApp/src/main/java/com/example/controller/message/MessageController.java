package com.example.controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.message.SendMsgVO;
import com.example.service.message.MsgService;

@Controller
public class MessageController {
	
	@Autowired
	MsgService msgService;
	
	//쪽지쓰기 폼 요청 
	@GetMapping("/sendMsgForm")
	public String sendMsgForm() {
		
		return "view/message/sendMsgForm";
		 
	}//sendMsgForm() end
	
	//쪽지 쓰기 요청
	@PostMapping("/sendMsg")
	public String sendMsg(@RequestParam String sendMsgContent,
						  @RequestParam String[] reciveId,
						  HttpServletRequest req) {
		
		//세션에 올라온 사용자 ID
		//HttpSession session = req.getSession();
		//UserInfoVo user = session.getAttribute("userInfo");
		//String userid = user.getuserId();
		
		SendMsgVO sendMsg = new SendMsgVO();	//insert할 객체
		
		//session에있는 userId set
		//sendMsg.setWriterId(userid);
		
		//보낼 쪽지 메세지 set
		sendMsg.setSendMsgContent(sendMsgContent);
		
		//
		
		
		
		 
		
		
		return null;
		
	}//sendMsg() end
	
}//class end
