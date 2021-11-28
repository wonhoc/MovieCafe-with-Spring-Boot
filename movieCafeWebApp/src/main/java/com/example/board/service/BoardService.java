package com.example.board.service;

import java.util.List;

import com.example.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> readAllByCateNo(int cateNo);
	List<BoardVO> readRecomRevList();
	List<BoardVO> readNoticeRevList();
}
