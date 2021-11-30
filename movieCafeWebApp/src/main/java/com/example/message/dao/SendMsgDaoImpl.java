package com.example.message.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.message.vo.SendMsgVO;

@Repository("sendMsgDao")
public class SendMsgDaoImpl implements SendMsgDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertMessage(SendMsgVO msgVo) {
		
		//보낸 메세지 저장
		HashMap<String, Object> sendMsg = new HashMap<String, Object>();
		
		sendMsg.put("writerId", msgVo.getWriterId());
		sendMsg.put("sendMsgContent", msgVo.getSendMsgContent());
		
		//System.out.println("writerId : " + sendMsg.get("writerId"));
		//System.out.println("sendMsgContent : " + sendMsg.get("sendMsgContent"));
		 
		//DB에 insert
		this.sqlSession.insert("Msg.insertSendMsg", sendMsg);
		//mapper에서 insert된 pk의 값을 가져온다.
		//BigInteger형으로 리턴되므로 형변환해주기
		//System.out.println("class : " + sendMsg.get("sendMsgNo").getClass().getName()); 
		
		BigInteger tempNo = (BigInteger)sendMsg.get("sendMsgNo");

		int sendMsgNo = tempNo.intValue();
		
		System.out.println("Dao sendMsgNo : " + sendMsgNo);
		
		return sendMsgNo;
			
	}//insertMessage() end
	
	//전체 보낸 메세지 조회
	@Override
	public List<SendMsgVO> selectSendMsgList(String userId) {
			
		return this.sqlSession.selectList("Msg.selectSendMsgList", userId);
		
	}//selectSendMsgList() end
	
	//보낸메세지 삭제
	@Override
	public void deleteSendMsg(int[] SendMsgNos) {
		
		for(int sendMsgNo : SendMsgNos) {
			
			this.sqlSession.delete("Msg.deleteSendMsgNo", sendMsgNo);
			
		}//for end
		
	}//deleteSendMsg() end

	//보낸 메세지 상세보기
	@Override
	public SendMsgVO selectSendMsg(int sendMsgNo) {
		
		return this.sqlSession.selectOne("Msg.selectSendMsg", sendMsgNo);
		
	}

	@Override
	public int selectTotalSendMsg(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//보낼 사람 검증
	@Override
	public int selectId(String userId) {
		
		return this.sqlSession.selectOne("Msg.selectUserId", userId);
		
	}//selectId() end
	
	

}//class end
