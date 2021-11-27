package com.example.service.message;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.domain.message.ReceiveMsgVO;
import com.example.domain.message.SendMsgVO;

@Service("msgService")
public class MsgServiceImpl implements MsgService {
	
	
	
	@Override
	public void registerMsg(SendMsgVO msgVo) {
		// TODO Auto-generated method stub

	}

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
