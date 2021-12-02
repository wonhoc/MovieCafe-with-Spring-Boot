package com.example.cardBoard.controller;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.file.FileUploadUtils;
import com.example.board.vo.BoardVO;
import com.example.cardBoard.service.CardBoardService;
import com.example.member.vo.UserInfoVo;
import com.example.util.FileUploadService;

@Controller
public class CardBoardController {
	
	@Autowired
	private CardBoardService cardBoardService;

	private final String path = "views/cardBoard/";	//경로
	
	//리뷰게시판 목록 요청
	@GetMapping("/cardBoardList")
	public String cardBoardList(Model model) {
	
		//리뷰게시판 글 목록
		List<BoardVO> cardBoardList = this.cardBoardService.getCardBoardList();
		
		model.addAttribute("cardBoardList", cardBoardList);
			
		return path + "cardBoardList";
	
	}//cardBoardList() end
	
	//리뷰게시판 상세보기 요청
	@GetMapping("/cardBoardDetail/{cardboardNo}")
	public String cardBoardDetail(Model model, @PathVariable int cardboardNo) {
		
		BoardVO cardBoard =  this.cardBoardService.getCardBoardDetail(cardboardNo);
		//조회수 증가
		this.cardBoardService.upBoardCount(cardboardNo);
		model.addAttribute("cardBoard", cardBoard);
		
		return path + "cardBoardDetail";
		
	}//cardBoardDetail () end
	
	//리뷰게시판 글쓰기 요청
	@GetMapping("/cardBoardWriterForm")
	public String cardBoardWriterForm(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		
		//만약 로그인 되지 않은 상태에서 요청한다면 메인페이지로 이동하게 만듦
		String movepath = "";
		
		if(user == null) {
			
			movepath = "redirect:/";
			
		}else {
			movepath = path + "cardBoardWriterForm";
		}
		
		return movepath;
		
	}//boardWrite() end
	
	//글 작성
	@PostMapping("/cardBoardWrite")
	public String cardBoardWrite(@RequestParam String boardTitle,
								 @RequestParam String boardContent,
								 @RequestParam int horseNo,
								 @RequestPart(value = "fileList", required = false) MultipartFile photoSys,
								 HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		
		String userId = user.getUserId();
		
		HashMap<String, Object> boardMap = new HashMap<String, Object>();
		
		boardMap.put("userId", userId);
		boardMap.put("boardTitle", boardTitle);
		boardMap.put("boardContent", boardContent);
		boardMap.put("horseNo", horseNo);
		
		
		this.cardBoardService.writeBoard(boardMap);
		
		return "redirect:/cardBoardList";
		
	}//cardBoardWrite() end
	
	//리뷰게시판 게시글 삭제 요청
	@GetMapping("/deleteCardBoard/{boardNo}/{userNick}")
	public String deleteCardBoard(@PathVariable(value = "boardNo") int boardNo,
								  @PathVariable(value = "userNick") String userNick,
								HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		
		//System.out.println("session : " + user.getUserNick());
		//System.out.println("path boardNo : " +  boardNo);
		//System.out.println("path userNick : " +  userNick);
		
		//아무나 못지우게 설정
		if(userNick.equals(user.getUserNick())) {
			
			this.cardBoardService.removeCardBoard(boardNo);
			
		}//if end
		
		return "redirect:/cardBoardList";
		
	}//class end
	
	//게시글 수정 요청
	@GetMapping("/modifyCardBoardForm/{boardNo}/{userNick}")
	public String modifyCardBoardForm (@PathVariable(value = "boardNo") int boardNo,
										@PathVariable(value = "userNick") String userNick,
										HttpServletRequest req, 
										Model model) 
	{
		
		HttpSession session = req.getSession();
		
		UserInfoVo user = (UserInfoVo)session.getAttribute("userInfo");
		
		
		
	
		//수정폼 요청
		if(userNick.equals(user.getUserNick())) {
			
			BoardVO cardBoard = this.cardBoardService.getCardBoardDetail(boardNo);
			
			model.addAttribute("cardBoard", cardBoard);
			
			return  path + "modifyCardBoardForm";
			
		}//if end
		
		
		return "redirect:/cardBoardList";
		
	}//modifyCardBoardForm() end
	
	//게시글 수정
	@PostMapping("/modifyCardBoard")
	public String modifyCardBoard(Model model) {
		
		HashMap<String, Object> modifyBoard = new HashMap<String, Object>();
		
		//this.cardBoardService.modifyCardBoard(modifyBoard);
		
		
		return "redirect:/cardBoardList";
		
	}//modifyCardBoard() end
	
	
	
}//class end
