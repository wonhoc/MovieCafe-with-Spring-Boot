package com.example.message.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.message.service.MsgService;
import com.example.message.vo.AddressVO;
import com.example.message.vo.SendMsgVO;

@Controller
public class MessageController {
	
	@Autowired
	private MsgService msgService;
	
	//path설정
	private final String path = "views/message/";
	
	//쪽지쓰기 폼 요청 
	@GetMapping("/sendMsgForm")
	public String sendMsgForm() {
		
		return this.path +"sendMsgForm";
		 
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
		
		//로컬에서 테스트할 아이디 지정하기
		sendMsg.setWriterId("test_user01");
		
		//보낼 쪽지 메세지 set
		sendMsg.setSendMsgContent(sendMsgContent);
		
		//받을 사람들 set
		ArrayList<AddressVO> addrs = new ArrayList<AddressVO>();	//address ArrayList
		
		//reciveId배열에서 받을 id값 꺼내서 addr에 add
		for(String id : reciveId) {
			
			AddressVO addr = new AddressVO(); //addrs에 넣을 객체
			addr.setReceiveId(id);	//객체에 받을id 바인딩
			addrs.add(addr);	//addrs에 addr 바인딩
			
		}//for end
		
		sendMsg.setAddresses(addrs);
		
		//DB에 저장
		this.msgService.registerMsg(sendMsg);
		
		//보낸 메세지 페이지로 이동
		return "redirect:/sendMsgList";
		
	}//sendMsg() end
	
	
	//내가 쓴 쪽지 전체 목록 페이지 요청
	@GetMapping("/sendMsgList")
	public String sendMsgList(Model model) {
		
		//세션에 올라온 사용자 ID
		//HttpSession session = req.getSession();
		//UserInfoVo user = session.getAttribute("userInfo");
		//String userid = user.getuserId();
		
		//로컬에서 테스트할 userid
		String userid = "test_user01";
		
		//보낸 메세지들 받기
		ArrayList<SendMsgVO> sendMsgList = (ArrayList<SendMsgVO>)this.msgService.retrieveSendMsgList(userid);
		
		model.addAttribute("sendMsgList", sendMsgList);
		
		/*
		for(SendMsgVO sendmsg : sendMsgList) {
			
			ArrayList<AddressVO> addrs = sendmsg.getAddresses();
			
			for(AddressVO addr : addrs) {
				
				System.out.println(addr.toString());
				
			}//for end
	
		}//for end
		*/
		
		//sendMsgList로 이동
		return this.path + "sendMsgList";
		
	}//sendMsgList() end 
	
	
	
}//class end
