package com.example.board.vo;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ReportVO {
	@NonNull private int boardNo;
	private String userId;	//신고 당한 사람
	@NonNull private String repoter;	//신고 한 사람
}
