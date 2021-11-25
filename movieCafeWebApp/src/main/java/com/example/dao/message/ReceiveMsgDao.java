package com.example.dao.message;

import java.util.ArrayList;

import com.example.domain.message.ReceiveMsgVo;

public interface ReceiveMsgDao {
	
	//쪽지 작성
	void insertMessage(String sendMsg ,String receiveId, int sendMsgNo, String writer);
	
	//보낸 쪽지 모두 조회
	ArrayList<ReceiveMsgVo> selectReceiveMsgList(String userId, int startRow, int postSize);
	
	//보낸 쪽지 삭제
	void deleteReceiveMsg(int receiveMsgNo);
	
	//보낸쪽지 상세 조회
	public ReceiveMsgVo selectReceiveMsg(int receiveMsgNo);
	
	//보낸 쪽지 갯수 조회
	int selectTotalReceiveMsg(String userId);
	
	//보낼사람 아이디가 있는지 없는지 확인
	int selectId(String userId);
	
}//interface end
