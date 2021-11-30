package com.example.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dao.BoardDao;
import com.example.board.vo.BoardFileVO;
import com.example.board.vo.BoardVO;
import com.example.board.vo.RecomVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	//게시글 목록 조회
	@Override
	public List<BoardVO> readAllByCateNo(int cateNo) {
		return this.boardDao.selectList(cateNo);
	}

	//게시글 상세조회
	@Override
	public BoardVO readOne(int boardNo) {
		return this.boardDao.selectBoard(boardNo);
	}

	//인기글조회
	@Override
	public List<BoardVO> readRecomRevList() {
		return this.boardDao.selectRecomRevList();
	}
	//공지글조회
	@Override
	public List<BoardVO> readNoticeRevList() {
		return this.boardDao.selectNoticeRevList();
	}
	
	//게시글 작성
	@Override
	public void createBoard(BoardVO board) {
		
		this.boardDao.insertBoard(board);
	}

	//팁 게시글 작성
	@Override
	public void createTipBoard(BoardVO board) {
		this.boardDao.insertBoardTip(board);
		
	}
	
	//게시글 수정
	@Override
	public void modifyBoard(BoardVO board) {
		this.boardDao.updateBoard(board);
		
	}
	
	//게시글 삭제
	@Override
	public void removeBoard(int boardNo) {
		this.boardDao.deleteBoard(boardNo);
	}

	//게시글 신고
	@Override
	public void reportBoard(int boardNo) {
		this.boardDao.reportBoardDao(boardNo);
	}

	//게시글 추천
	@Override
	public void createRecommend(RecomVO recommend) {
		this.boardDao.insertRecommend(recommend);
		
	}

	//게시글 추천 취소
	@Override
	public void dropRecommend(RecomVO recommend) {
		this.boardDao.deleteRecommend(recommend);		
	}

	//게시글 추천 이력 조회
	@Override
	public boolean readIsRecom(RecomVO recommend) {
		return this.boardDao.selectIsRecom(recommend);
	}
	
	
}
