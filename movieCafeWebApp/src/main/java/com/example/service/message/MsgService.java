package com.example.service.message;

import java.util.ArrayList;

import com.example.domain.message.ReceiveMsgVo;
import com.example.domain.message.SendMessageVo;

public interface MsgService {
	
	//쪽지 작성
	public void registerMsg(SendMessageVo msgVo);
	
	//보낸쪽지 모두 조회
	ArrayList<SendMessageVo> retrieveSendMsgList(String userId, int startRow, int postSize);
	
	//보낸쪽지 상세조회
	SendMessageVo retrieveSendMsg(int sendMsgNo);
	
	//보낸 쪽지 삭제
	void removeSendMsg(int sendMsgNo);
	
	//보낸쪽지 갯수확인
	int rerieveTotalSendMsg(String userId);
	
	
	
	//받은쪽지 모두 조회
	ArrayList<ReceiveMsgVo> retrieveReceiveMsgList(String userId, int startRow, int postSize);

	//받은쪽지 상세조회
	ReceiveMsgVo retrieveReceiveMsg(int receiveMsgNo);
	
	//받은쪽지 삭제
	void removeReceiveMsg(int receiveMsgNo);
	
	//받은쪽지 갯수 조회
	int rerieveTotalReceiveMsg(String userId);
	
	
	
	//삭제시 안읽은쪽지 읽음으로 전환
	void ReadUpdateRemove(int receiveMsgNo, String receiveId);
	
	//쪽지 수신확인
	void updateRead(int sendMsgNo, String receiveId);
	
	
	
	
	
}//interface end
