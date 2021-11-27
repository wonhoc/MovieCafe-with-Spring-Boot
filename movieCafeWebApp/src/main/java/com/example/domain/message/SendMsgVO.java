package com.example.domain.message;

import java.util.ArrayList;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	private ArrayList<String> address;
	private ArrayList<Integer>isRead;
	
}// class end
