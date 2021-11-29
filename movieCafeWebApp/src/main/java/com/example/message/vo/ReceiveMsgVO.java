package com.example.message.vo;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ReceiveMsgVO {
	
	private int receiveMsgNo;
	private String writerId;
	private String receiveMsgContent;
	private String msgWdate;
	private int isRead;
	
}// class end
