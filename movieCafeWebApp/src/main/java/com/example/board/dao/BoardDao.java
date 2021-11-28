package com.example.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.board.vo.BoardVO;

public interface BoardDao {

	List<BoardVO> selectList(int cateNo);
	List<BoardVO> selectRecomRevList();
	List<BoardVO> selectNoticeRevList();
}
