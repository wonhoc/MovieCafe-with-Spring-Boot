package com.example.message.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public void insertAddr(Map map) {
		
		
		this.sqlSession.insert("Msg.insertAddr",map);
		

	}//insertAddr() end

	@Override
	public ArrayList<String> selectAddr(int sendMsgNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddress(int SendMsgNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Integer> selectIsread(int sendMsgNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateisRead(HashMap<String, Object> updateMap) {
		
		//DB에 업데이트
		this.sqlSession.update("Msg.updateAddressIsread", updateMap);

	}//updateisRead() end

}//class end
