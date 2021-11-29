package com.example.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.vo.BoardFileVO;
import com.example.board.vo.BoardVO;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;

	// 게시글 목록 조회
	@Override
	public List<BoardVO> selectList(int cateNo) {

		return this.sqlSession.selectList("selectByCateNo", cateNo);

	}

	// 인기글 조회
	@Override
	public List<BoardVO> selectRecomRevList() {
		return this.sqlSession.selectList("Board.mainBestListSelect");
	}

	// 공지글 조회
	@Override
	public List<BoardVO> selectNoticeRevList() {
		return this.sqlSession.selectList("Board.mainNoticeListSelect");
	}

	// 게시글 상세보기
	@Override
	public BoardVO selectBoard(int boardNo) {
		return this.sqlSession.selectOne("selectDetailBoard", boardNo);
	}

	// 게시글 작성
	@Override
	public void insertBoard(BoardVO board) {
		this.sqlSession.insert("insertBoardCall", board);
	}

	// 팁 게시글 작성
	@Override
	public void insertBoardTip(BoardVO board) {
		this.sqlSession.insert("insertTipBoardCall", board);

	}

	// 파일 등록
	@Override
	public void insertBoardFile(BoardFileVO file) {
		this.sqlSession.insert("insertBoardFileCall", file);

	}

	// LAST_ID구하기
	@Override
	public int lastId() {
		return this.sqlSession.selectOne("lastId");
	}

	// 게시글 수정
	@Override
	public void updateBoard(BoardVO board) {
		this.sqlSession.update("updateBoardCall", board);

	}

	// 게시글 삭제
	@Override
	public void deleteBoard(int boardNo) {
		this.sqlSession.delete("deleteBoard", boardNo);
	}

	//게시글 신고
	@Override
	public void reportBoardDao(int bordNo) {
		this.sqlSession.insert("reportBoard", bordNo);
	}

}