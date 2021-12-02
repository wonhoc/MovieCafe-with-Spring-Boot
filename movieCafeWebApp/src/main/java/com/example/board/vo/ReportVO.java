package com.example.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ReportVO {

	@NonNull private int boardNo;
	private String userId;	//신고 당한 사람
	@NonNull private String repoter;
	
}
