package com.example.message.service;

import java.util.ArrayList;
import java.util.List;

import com.example.message.vo.ReceiveMsgVO;
import com.example.message.vo.SendMsgVO;

public interface MsgService {
	
	//쪽지 작성
	public void registerMsg(SendMsgVO msgVo);
	
	//보낸쪽지 모두 조회
	List<SendMsgVO> retrieveSendMsgList(String userId);
	
	//보낸쪽지 상세조회
	SendMsgVO retrieveSendMsg(int sendMsgNo);
	
	//보낸 쪽지 삭제
	void removeSendMsg(int[] sendMsgNos);
	
	//보낸쪽지 갯수확인
	int rerieveTotalSendMsg(String userId);
	
	
	
	//받은쪽지 모두 조회
	ArrayList<ReceiveMsgVO> retrieveReceiveMsgList(String userId);

	//받은쪽지 상세조회
	ReceiveMsgVO retrieveReceiveMsg(int receiveMsgNo);
	
	//받은쪽지 삭제
	void removeReceiveMsg(int receiveMsgNo);
	
	//받은쪽지 갯수 조회
	int rerieveTotalReceiveMsg(String userId);
	
	
	
	//삭제시 안읽은쪽지 읽음으로 전환
	void ReadUpdateRemove(int receiveMsgNo, String receiveId);
	
	//쪽지 수신확인
	void updateRead(int sendMsgNo, String receiveId);
	
	
	
	
	
}//interface end
