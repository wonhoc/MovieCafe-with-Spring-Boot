package com.example.message.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ReceiveMsgVO {
	
	private int receiveMsgNo;
	private String writer;
	private String receiveId;
	private String receiveMsgContent;
	private String msgWdate;
	private int isRead;
	
}// class end
