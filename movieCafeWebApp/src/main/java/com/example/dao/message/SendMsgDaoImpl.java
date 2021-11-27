package com.example.dao.message;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.message.SendMsgVO;

@Repository("sendMsgDao")
public class SendMsgDaoImpl implements SendMsgDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertMessage(SendMsgVO msgVo) {
		
		return 0;
		
	}//insertMessage() end

	@Override
	public ArrayList<SendMsgVO> selectSendmsg(String userId, int startRow, int postSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSendMsg(int SendMsgNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public SendMsgVO selectSendMsg(int sendMsgNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTotalSendMsg(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}//class end
