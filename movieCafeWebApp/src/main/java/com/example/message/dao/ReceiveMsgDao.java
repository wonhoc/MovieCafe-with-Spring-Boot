package com.example.message.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.message.vo.ReceiveMsgVO;

public interface ReceiveMsgDao {
	
	//쪽지 작성
	void insertMessage(ArrayList<ReceiveMsgVO> receiveMsgs, int sendMsgNo);
	
	//받은 쪽지 모두 조회
	List<ReceiveMsgVO> selectReceiveMsgList(String userId);
	
	//받은 쪽지 삭제
	void deleteReceiveMsg(HashMap<String, Object> map);
	
	//받은쪽지 상세 조회
	public ReceiveMsgVO selectReceiveMsg(int receiveMsgNo);
	
	//클릭시 읽음확인 업데이트
	public void updateIsread(HashMap<String, Object> updateMap);
	
	//받은 쪽지 갯수 조회
	int selectTotalReceiveMsg(String userId);
	
	
	
}//interface end
