package com.example.message.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface AddressDao {
	
	//보낸사람 주소록에 저장
	void insertAddr(Map map);
	
	//받는 사람들 조회
	ArrayList<String> selectAddr(int sendMsgNo);
	
	//보낸 쪽지 삭제
	void deleteAddress(int SendMsgNo);
	
	//수신확인 조회
	ArrayList<Integer> selectIsread(int sendMsgNo);
	
	//읽음확인 업데이트
	void updateisRead(HashMap<String, Object> updateMap);
	
	
}//interface end
