package com.example.message.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.member.vo.UserInfoVo;
import com.example.message.service.MsgService;
import com.example.message.vo.AddressVO;
import com.example.message.vo.ReceiveMsgVO;
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
		HttpSession session = req.getSession();
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		String userid = user.getUserId();
		
		SendMsgVO sendMsg = new SendMsgVO();	//insert할 객체
		
		//session에있는 userId set
		//sendMsg.setWriterId(userid);

		sendMsg.setWriterId(userid);
		
		//보낼 쪽지 메세지 set
		sendMsg.setSendMsgContent(sendMsgContent);
		
		//받을 사람들 set
		ArrayList<AddressVO> addrs = new ArrayList<AddressVO>();	//address ArrayList
		
		//수신함에 저장
		ArrayList<ReceiveMsgVO> receiveMsgs = new ArrayList<ReceiveMsgVO>();
		//수신자 정보 저장
		ReceiveMsgVO receiveMsg = new ReceiveMsgVO();
		receiveMsg.setWriter(userid);	//보낸사람
		receiveMsg.setReceiveMsgContent(sendMsgContent); //수신 메세지
		
		//reciveId배열에서 받을 id값 꺼내서 addr에 add
		for(String id : reciveId) {
			
			AddressVO addr = new AddressVO(); //addrs에 넣을 객체
			addr.setReceiveId(id);	//객체에 받을id 바인딩
			addrs.add(addr);	//addrs에 addr 바인딩
			
			receiveMsg.setReceiveId(id); //받을사람 바인딩
			receiveMsgs.add(receiveMsg); //수신자정보 배열에 저장
			
		}//for end
		
		sendMsg.setAddresses(addrs);
		
		//DB에 저장
		this.msgService.registerMsg(sendMsg, receiveMsgs);
		
		//보낸 메세지 페이지로 이동
		return "redirect:/sendMsgList";
		
	}//sendMsg() end
	
	
	//내가 쓴 쪽지 전체 목록 페이지 요청
	@GetMapping("/sendMsgList")
	public String sendMsgList(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		String userid = user.getUserId();
		
		//보낸 메세지들 받기
		ArrayList<SendMsgVO> sendMsgList = (ArrayList<SendMsgVO>)this.msgService.retrieveSendMsgList(userid);
		
		model.addAttribute("sendMsgList", sendMsgList);
		
		
		for(SendMsgVO sendmsg : sendMsgList) {
			
			ArrayList<AddressVO> addrs = sendmsg.getAddresses();
			
			//System.out.println(sendmsg.toString());
			
			for(AddressVO addr : addrs) {
			
				//System.out.println(addr.toString());
				
			}//for end
	
		}//for end
		
		
		//sendMsgList로 이동
		return this.path + "sendMsgList";
		
	}//sendMsgList() end
	
	@PostMapping("/removeSendMsg")
	public String removeSendMsg(@RequestParam int[] removeCheckBox) {
		
		this.msgService.removeSendMsg(removeCheckBox);
		
		return "redirect:/sendMsgList";
		
	}//removeSendMsg() end
	
	//받은 메세지 상세보기 요청
	@GetMapping("/sendMsgDetail/{sendMsgNo}")
	public String sendMsgDetail(@PathVariable int sendMsgNo
								,Model model) {
		//DB에서 상세조회
		SendMsgVO sendMsg = this.msgService.retrieveSendMsg(sendMsgNo);
		
		//model에 add
		model.addAttribute("sendMsg", sendMsg);
		
		//sendMsgDetail로 이동
		return this.path + "sendMsgDetail";
		
	}//sendMsgDetail() end
	
	//보낸메세지 상세보기 페이지에서 삭제
	@PostMapping("/removeDetailSendMsg")
	public String removeDetailSendMsg(@RequestParam int sendMsgNo) {
		
		int[] sendMsgnos = { sendMsgNo };
		
		this.msgService.removeSendMsg(sendMsgnos);
		
		return "redirect:/sendMsgList";
	}
	
	//받은 메세지 목록 요청
	@GetMapping("/receiveMsgList")
	public String receiveMsgList(Model model, HttpServletRequest req) {
		
		
		HttpSession session = req.getSession();
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		String userid = user.getUserId();
	
		//DB에서 받은메세지 조회
		List<ReceiveMsgVO> receiveMsgList = this.msgService.retrieveReceiveMsgList(userid);
		
		System.out.println("receiveMsgList" + receiveMsgList.toString());
		
		//model에 add
		model.addAttribute("receiveMsgList", receiveMsgList);
		//System.out.println("길이" + receiveMsgList.size());
		/*
		for(ReceiveMsgVO temp : receiveMsgList) {
			
			System.out.println("받은 메세지" + temp.toString());
		}
		*/
		//페이지 이동
		return path + "receiveMsgList";
		
	}//receiveMsgList() end
	
	//받은 메세지 상세보기
	@GetMapping("/receiveMsgDetail/{receiveMsgNo}/{isRead}")
	public String receiveMsgDetail(@PathVariable int receiveMsgNo,
								   @PathVariable int isRead,
									Model model, 
									HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		String userid = user.getUserId();
		
		ReceiveMsgVO receiveMsg = this.msgService.retrieveReceiveMsg(receiveMsgNo);
		
		//읽음상태가 0이라면 1로 업데이트해주기
		if(isRead == 0) {
			
			this.msgService.updateRead(receiveMsgNo, userid);
			
		}//if end
		
		model.addAttribute("receiveMsg", receiveMsg);
		
		return this.path + "receiveMsgDetail";
		
	}//receiveMsgDetail() end
	
	//받은메세지 목록에서 삭제 요청
	@PostMapping("/removeReceiveMsg")
	public String removeReceiveMsg(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		String userid = user.getUserId();
		
		//선택한 checkBox의 value 배열
		String[] removeCheckBox = req.getParameterValues("removeCheckBox");
		
		HashMap<String, Object> deleteMap = new HashMap<String, Object>();
		
		deleteMap.put("receiveId", userid);
		
		System.out.println("removeCheckBox.length() : " + removeCheckBox.length);
		
		
		for(String nos : removeCheckBox) {
			//receiveMsgNo값
			int no = Integer.parseInt(nos.substring(0, nos.indexOf(",")));
			//isRead값
			int isRead = Integer.parseInt(nos.substring(nos.indexOf(",") + 1, nos.length()));
			
			//System.out.println("nos : " + nos);
			//System.out.println("no" + no);
			//System.out.println("isRead" + isRead);
			
			deleteMap.put("receiveMsgNo", no);

			//1일경우 이미 읽었으므로 업데이트하지 않고 바로 삭제
			if(isRead == 1) {
				
				this.msgService.removeReceiveMsg(deleteMap);
				
			}else {
				//db에 업데이트하고
				this.msgService.updateRead(no, userid);
				//삭제
				this.msgService.removeReceiveMsg(deleteMap);
				
			}//if end
	
	
		}//for end
			
		return "redirect:/receiveMsgList";
		
	}///removeReceiveMsg() end
	
	
	//받은메세지 상세보기에서 삭제 요청
	@PostMapping("/removeDetailReceiveMsg")
	public String removeDetailReceiveMsg(@RequestParam int receiveMsgNo, HttpServletRequest req) {
	
		HttpSession session = req.getSession();
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		String userid = user.getUserId();
		
		HashMap<String, Object> deleteMap = new HashMap<String, Object>();
		
		deleteMap.put("receiveId", userid);
			
		deleteMap.put("receiveMsgNo", receiveMsgNo);

		//삭제
		this.msgService.removeReceiveMsg(deleteMap);

		return "redirect:/receiveMsgList";
		
	}//removeDetailReceiveMsg() end
	
	//Ajax 보낼 사람 검증
	@RequestMapping(value = "/checkReceiveId", method = RequestMethod.POST)
	public @ResponseBody String CheckReceiveId(@RequestParam("userId") String inputId) {
		
		System.out.println("inputId : " + inputId);
		
		int resultCount =  this.msgService.searchUser(inputId);
		
		System.out.println("resultCount : " + resultCount);
		
		return Integer.toString(resultCount);
		
	}//CheckReceiveId() end
	
	
	
	
}//class end
