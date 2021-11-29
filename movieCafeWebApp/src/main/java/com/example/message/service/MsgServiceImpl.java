package com.example.message.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.message.dao.AddressDao;
import com.example.message.dao.SendMsgDao;
import com.example.message.vo.AddressVO;
import com.example.message.vo.ReceiveMsgVO;
import com.example.message.vo.SendMsgVO;

@Service("msgService")
public class MsgServiceImpl implements MsgService {
	
	@Autowired
	private SendMsgDao sendMsgDao;
	@Autowired
	private AddressDao addressDao;
	
	//쪽지 작성
	@Override
	public void registerMsg(SendMsgVO msgVo) {
		
		//방금 insert된 보낸메세지의 pk값
		int sendMsgNo =	this.sendMsgDao.insertMessage(msgVo);
		
		System.out.println("sendMsgNo :" + sendMsgNo);
		
		//받는 아이디 만큼 주소록에 저장
		ArrayList<AddressVO> addrs = msgVo.getAddresses();
		//입력할 데이터들
		HashMap<String, Object> addrMap = new HashMap<String, Object>();
		addrMap.put("sendMsgNo", sendMsgNo);
		
		//주소록에 저장
		for(AddressVO addr : addrs) {
			
			addrMap.put("receiveId", addr.getReceiveId()); 
			
			this.addressDao.insertAddr(addrMap);
	
		}//for end
	
		
	}//registerMsg() end
	
	//보낸 메세지 전체 조회
	@Override
	public List<SendMsgVO> retrieveSendMsgList(String userId) {
		
		return this.sendMsgDao.selectSendMsgList(userId);

	}//retrieveSendMsgList() end
	
	//보낸 메세지 상세보기
	@Override
	public SendMsgVO retrieveSendMsg(int sendMsgNo) {
		
		return this.sendMsgDao.selectSendMsg(sendMsgNo);
		
	}//retrieveSendMsg() end
	
	//보낸 메세지 삭제
	@Override
	public void removeSendMsg(int[] sendMsgNos) {
		
		this.sendMsgDao.deleteSendMsg(sendMsgNos);

	}//removeSendMsg() end
	
	
	@Override
	public int rerieveTotalSendMsg(String userId) {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public ArrayList<ReceiveMsgVO> retrieveReceiveMsgList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


}//class end
