package com.example.domain.message;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReceiveMsgVo {
	
	private int receiveMsgNo;
	private String writerId;
	private String receiveMsgContent;
	private String msgWdate;
	private int isRead;
	
}// class end
