package com.example.message.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.message.dao.SendMsgDao;
import com.example.message.vo.ReceiveMsgVO;
import com.example.message.vo.SendMsgVO;

@Service("msgService")
public class MsgServiceImpl implements MsgService {
	
	@Autowired
	SendMsgDao sendMsgDao;
	
	@Override
	public void registerMsg(SendMsgVO msgVo) {
		
	//방금 insert된 보낸메세지의 pk값
	int sendMsgNo =	this.sendMsgDao.insertMessage(msgVo);

	}//registerMsg() end

	@Override
	public ArrayList<SendMsgVO> retrieveSendMsgList(String userId, int startRow, int postSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendMsgVO retrieveSendMsg(int sendMsgNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSendMsg(int sendMsgNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public int rerieveTotalSendMsg(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ReceiveMsgVO> retrieveReceiveMsgList(String userId, int startRow, int postSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiveMsgVO retrieveReceiveMsg(int receiveMsgNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeReceiveMsg(int receiveMsgNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public int rerieveTotalReceiveMsg(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ReadUpdateRemove(int receiveMsgNo, String receiveId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRead(int sendMsgNo, String receiveId) {
		// TODO Auto-generated method stub

	}

}//class end
