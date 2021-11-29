package com.example.message.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.message.vo.ReceiveMsgVO;

@Repository("receiveMsgDao")
public class ReceiveMsgDaoImpl implements ReceiveMsgDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertMessage(ArrayList<ReceiveMsgVO> receiveMsgs, int sendMsgNo) {
		
		for(ReceiveMsgVO receiveMsg : receiveMsgs) {
			
			receiveMsg.setReceiveMsgNo(sendMsgNo);
			
			this.sqlSession.insert("Msg.insertReceiveMsg", receiveMsg);
			
		}//for end

	}//insertMessage() end
	
	//받은 메세지 전체 조회
	@Override
	public List<ReceiveMsgVO> selectReceiveMsgList(String userId) {
		
		return this.sqlSession.selectList("Msg.selectReceiveMsgList", userId);
		
	}//selectReceiveMsgList() end

	@Override
	public void deleteReceiveMsg(int receiveMsgNo) {
		// TODO Auto-generated method stub

	}
	
	//받은 메세지 상세조회
	@Override
	public ReceiveMsgVO selectReceiveMsg(int receiveMsgNo) {
		
		return this.sqlSession.selectOne("Msg.selectReceiveMsg", receiveMsgNo);
	}

	@Override
	public int selectTotalReceiveMsg(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//클릭시 읽음확인 업데이트
	@Override
	public void updateIsread(HashMap<String, Object> updateMap) {
		
		//DB에 업데이트
		this.sqlSession.update("Msg.updateReceiveIsread", updateMap);
		
	}//updateIsread() end
	
	

}//class end
