package com.example.message.dao;

import java.util.List;

import com.example.message.vo.SendMsgVO;

public interface SendMsgDao {
	
	//쪽지 보내기
	public int insertMessage(SendMsgVO msgVo);
	
	//보낸 쪽지 모두 조회
	public List<SendMsgVO> selectSendMsgList(String userId);
	
	//보낸 쪽지 삭제
	public void deleteSendMsg(int SendMsgNo);
	
	//보낸 쪽지 상세조회
	public SendMsgVO selectSendMsg(int sendMsgNo);
	
	//보낸 쪽지 갯수 조회
	public int selectTotalSendMsg(String userId);
	
}//interface end
