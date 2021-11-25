package com.example.dao.message;

import java.util.ArrayList;

import com.example.domain.message.SendMessageVo;

public interface SendMsgDao {
	
	//쪽지 보내기
	public int insertMessage(SendMessageVo msgVo);
	
	//보낸 쪽지 모두 조회
	public ArrayList<SendMessageVo> selectSendmsg(String userId, int startRow, int postSize);
	
	//보낸 쪽지 삭제
	public void deleteSendMsg(int SendMsgNo);
	
	//보낸 쪽지 상세조회
	public SendMessageVo selectSendMsg(int sendMsgNo);
	
	//보낸 쪽지 갯수 조회
	public int selectTotalSendMsg(String userId);
	
}//interface end
