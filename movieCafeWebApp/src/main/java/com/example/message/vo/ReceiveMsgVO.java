package com.example.message.vo;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReceiveMsgVO {
	
	private int receiveMsgNo;
	private String writerId;
	private String receiveMsgContent;
	private String msgWdate;
	private int isRead;
	
}// class end
