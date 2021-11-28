package com.example.message.vo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class SendMsgVO {
	
	private int sendMsgNo;
	private String sendMsgContent;
	private String msgWdate;
	private String writerId;
	private ArrayList<AddressVO> addresses;
	
}// class end
