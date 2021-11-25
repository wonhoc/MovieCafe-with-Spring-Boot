package com.example.domain.message;

import java.util.ArrayList;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SendMessageVo {
	
	private int sendMsgNo;
	private String sendMsgContent;
	private String msgWdate;
	private String writerId;
	private ArrayList<String> address;
	private ArrayList<Integer>isRead;
	
}// class end
