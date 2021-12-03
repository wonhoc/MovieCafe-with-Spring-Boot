package com.example.cardBoard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.vo.BoardFileVO;
import com.example.cardBoard.dao.CardBoardDao;
import com.example.cardBoard.vo.BoardVO;

@Service("cardBoardService")
public class CardBoardServiceImpl implements CardBoardService {

	@Autowired
	private CardBoardDao cardBoardDao;
	
	//리뷰게시판 목록
	@Override
	public List<BoardVO> getCardBoardList() {
		
		//리뷰게시판 리스트
		List<BoardVO> boardList =  this.cardBoardDao.selectCardBoardList();
		//파일이 있는 리뷰게시판 정보
		List<BoardFileVO> boardFileList = this.cardBoardDao.selectBoardFileLisrt();
		
		//리턴할 List
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		for(BoardVO board : boardList) {
			
			ArrayList<BoardFileVO> boardFileArray = new ArrayList<BoardFileVO>();
			
			for(BoardFileVO boardFile : boardFileList) {
				
				System.out.println("board : " + board.getBoardNo());
				System.out.println("boardFile : " + boardFile.getBoardNo());
				
				if(board.getBoardNo() == boardFile.getBoardNo()) {
					
					boardFileArray.add(boardFile);
					System.out.println("boardFile : " + boardFile.toString());
								
				}//if end
				
				board.setBoardfileList(boardFileArray);
				
			}//for end
				
			list.add(board);
			
		}//for end
		
		return list;
		
	}//getCardBoardList() end
	
	//리뷰게시판 상세보기
	@Override
	public BoardVO getCardBoardDetail(int boardNo) {
		
		BoardVO board = this.cardBoardDao.selectCardBoard(boardNo);
		
		//파일정보
		ArrayList<BoardFileVO> boardFileList = (ArrayList<BoardFileVO>)this.cardBoardDao.selectBoardFile(boardNo);
		
		board.setBoardfileList(boardFileList);
		
		return board;
		
	}//getCardBoardDetail() end

	@Override
	public void writeBoard(HashMap<String, Object> boardMap) {
		
		//게시글 입력
		int boardNo = this.cardBoardDao.insertBoard(boardMap);
		
		//게시글 파일 업로드
		HashMap<String, Object> boardFileMap = (HashMap<String, Object>)boardMap.get("boardFileMap");
		boardFileMap.put("boardNo", boardNo);
		
		System.out.println("boardfileSys : " + boardFileMap.get("boardfileSys"));
		System.out.println("boardfileOrigin : " + boardFileMap.get("boardfileOrigin"));
		System.out.println("boardfileSize : " + boardFileMap.get("boardfileSize"));
		System.out.println("boardNo : " + boardFileMap.get("boardNo"));
		
		//게시글 파일 업로드
		this.cardBoardDao.insertBoardFile(boardFileMap);

	}//writeBoard() end
	
	//조회수 증가
	@Override
	public void upBoardCount(int boarNo) {
		
		this.cardBoardDao.updateBoardCount(boarNo);
		
	}//upBoardCount() end

	//게시글 삭제
	@Override
	public void removeCardBoard(int boarNo) {
		
		this.cardBoardDao.deleteCardBoard(boarNo);
		
	}
	
	//게시글 수정
	@Override
	public void modifyCardBoard(HashMap<String, Object> modifyBoard) {
		
		this.cardBoardDao.updateCardBoard(modifyBoard);

	}//modifyCardBoard() end
	
	
	
	
	
}//class end
