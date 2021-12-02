package com.example.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.member.service.UserService;
import com.example.member.vo.UserInfoVo;
import com.example.util.FileUploadService;

@Controller
public class UserInfoController {
	@Autowired
	private UserService userService; 
	
	@Autowired
    private FileUploadService fileUploadService;

	// 회원가입 버튼 클릭시 작성 폼으로 이동
	@GetMapping("/joinUser")
	public String joinUser() {
		return "/views/member/joinUserForm";
	}
	// 로그인
	@PostMapping("/requestlogin") 
	public String loginController(
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "userPwd") String userPwd,
			HttpSession session, Model model){
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId); 
		map.put("userPwd", userPwd);

		int isCheckUser = this.userService.isCheckUserCount(map);
		
		//로그인에 성공했을 경우
		if (isCheckUser == 1) {
			// 세션 유지 시간 : 30분
			session.setMaxInactiveInterval(60*60);

			UserInfoVo user = userService.uploadUserInfo(userId);
			// 세션에 가져온 유저정보 등록
			session.setAttribute("userInfo", user);
			return "redirect:/main";
		} else { 
			// 리다이렉트로 로그인 페이지 다시
			return "redirect:/loginFailCaseOne";
		}
	}
	@GetMapping("/loginFail") 
		public String loginFail() {
			return "views/member/loginFail";
	}
	// ID, PW를 정확하게 입력하지 않았을 경우 -> Alert 창 띄우는 html 지난 후 loginFail로 이동
	@GetMapping("/loginFailCaseOne")
	public String loginFailOne() {
		return "views/member/loginFailCaseOne";
	}
	// 비로그인 상태로 게시판의 상세 보기를 시도했을 경우 -> Alert 창 띄우는 html 지난 후 loginFail로 이동
	@GetMapping("/loginFailCaseTwo")
	public String loginFailTwo() {
		return "views/member/loginFailCaseTwo";
	}

	// 회원 가입
	@PostMapping(value = "/joinUserRequest")
	public String joinUserRequest(@RequestParam(value = "userId1") String userId,
			@RequestParam(value = "userPwd1") String userPwd, @RequestParam(value = "userEmail") String userEmail,
			@RequestParam(value = "birthYear") String tempYear, @RequestParam(value = "birthMonth") String tempMonth,
			@RequestParam(value = "birthDate") String tempDate, @RequestParam(value = "contact1") String tempCon1,
			@RequestParam(value = "contact2") String tempCon2, @RequestParam(value = "contact3") String tempCon3,
			@RequestParam(value = "userNick") String userNick, @RequestParam(value = "userName") String userName,
			@RequestParam(value = "pickGender") String gender, Model model) {

		UserInfoVo user = new UserInfoVo();

		user.setUserId(userId);
		user.setUserPwd(userPwd);
		user.setUserEmail(userEmail);

		String userBirth = tempYear + "-" + tempMonth + "-" + tempDate;
		user.setUserBirth(userBirth);

		String userContact = tempCon1 + "-" + tempCon2 + "-" + tempCon3;
		user.setUserContact(userContact);

		user.setUserNick(userNick);
		user.setUserName(userName);
		user.setGender(gender);
		this.userService.insertUserInfo(user);
		return "views/main";

	}

	// 회원가입 과정에서 아이디 중복 체크
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public @ResponseBody String checkIdAjax(@RequestParam("userId") String reqId) {
		String inputId = reqId.trim();
		int isCheckId = userService.isCheckId(inputId);
		String checkResult = "";
		// 아이디가 중복이 아니면 0 = 가입 가능
		// 아이디가 중복이면 1 = 사용 불가
		if (isCheckId == 0) {
			checkResult = "false";

		} else if (isCheckId == 1) {
			checkResult = "true";
		}
		return checkResult;

	}

	// 회원가입 과정에서 닉네임 중복 체크
	@RequestMapping(value = "/checkNick", method = RequestMethod.POST)
	public @ResponseBody String checkNickAjax(@RequestParam("userNick") String reqNick) {
		String inputId = reqNick.trim();
		int isCheckNick = userService.isCheckNick(inputId);
		String checkResult = "";
		// 닉네임이 중복이 아니면 0 = 가입 가능
		// 넥니엠이 중복이면 1 = 사용 불가
		if (isCheckNick == 0) {
			checkResult = "false";

		} else if (isCheckNick == 1) {
			checkResult = "true";
		}
		return checkResult;

	}

	@GetMapping(value = "/gomypage")
	public ModelAndView myPage(HttpServletRequest req, ModelAndView model) {
		HttpSession session = req.getSession();
		UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
		System.out.println("세션 정보 : " + userInfo.toString());

		model.setViewName("/views/member/mypage");

		model.addObject("userId",userInfo.getUserId());
		model.addObject("userNick",userInfo.getUserNick());
		model.addObject("joinDate",userInfo.getJoinDate());


		return model;

	}
	
	// 관리자의 사용자 정보 조회
	   @GetMapping("/listUser")
	   public String listUser(Model model) {
	      List<UserInfoVo> users = this.userService.retrieveUserList();
	      model.addAttribute("userList", users);
	      return "views/member/listUser";
	   }

	   // 사용자 정보 조회 ajax
	   @GetMapping("/getList")
	   public @ResponseBody List<UserInfoVo> userList() {
	      List<UserInfoVo> users = this.userService.retrieveUserList();
	      return users;
	   }

	   // 회원정보상세조회
	   @GetMapping("/modifyUserForm")
	   public String modifyUserForm(HttpServletRequest req, Model model) {
	      HttpSession session = req.getSession();
	      UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
	      UserInfoVo user = this.userService.retrieveUser(userInfo.getUserId());
	      model.addAttribute("user", user);
	      return "views/member/modifyUser";
	   }

	// 회원정보수정
	      @PostMapping("/modifyUser")
	      public String modifyUser(HttpServletRequest request,@RequestParam("userId1") String userId, @RequestParam("userPwd1") String userPwd,
	            @RequestParam("userEmail") String userEmail, @RequestParam("birthYear") String tempYear,
	            @RequestParam("birthMonth") String tempMonth, @RequestParam("birthDate") String tempDate,
	            @RequestParam("contact1") String tempCon1, @RequestParam("contact2") String tempCon2,
	            @RequestParam("contact3") String tempCon3, @RequestParam("userNick") String userNick,
	            @RequestParam("userName") String userName, @RequestParam("gender") String gender,
	            @RequestPart(value = "imgInput",required = false) MultipartFile photoSys, 
	             Model model) {

	         UserInfoVo user = new UserInfoVo();
	         user.setUserId(userId);
	         user.setUserPwd(userPwd);
	         user.setUserEmail(userEmail);

	         String userBirth = tempYear + "-" + tempMonth + "-" + tempDate;
	         user.setUserBirth(userBirth);

	         String userContact = tempCon1 + "-" + tempCon2 + "-" + tempCon3;
	         user.setUserContact(userContact);

	         user.setUserNick(userNick);
	         user.setUserName(userName);
	         user.setGender(gender);
	         user.setPhotoOrigin(photoSys.getOriginalFilename());
	         String imgname = null;
	            if(!photoSys.getOriginalFilename().isEmpty()) {
	               imgname = fileUploadService.restore(photoSys, request);
	            }else {
	               imgname = "default.png";
	            }
	         user.setPhotoSys(imgname);
	         HttpSession session = request.getSession();
	         UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
	         user.setBoardCount(userInfo.getBoardCount());
	         user.setComCount(userInfo.getComCount());
	         user.setExitdate(userInfo.getExitdate());
	         user.setExitType(userInfo.getExitType());
	         user.setJoinDate(userInfo.getJoinDate());
	         user.setRankType(userInfo.getRankType());
	         user.setReportCount(userInfo.getReportCount());
	         System.out.println(user);
	         this.userService.modifyUser(user);
	         return "redirect:/";
	      }

	   // 패스워드 확인
	   @PostMapping("/pwdCheck")
	   public String pwdCheck(HttpServletRequest req, @RequestParam String userPwd) {
	      HttpSession session = req.getSession();
	      UserInfoVo userinfo = (UserInfoVo) session.getAttribute("userInfo");
	      boolean result = userinfo.getUserPwd().equals(userPwd);

	      if (result) {
	         return "redirect:/deleteUser";
	      } else {
	         return "views/member/pwdCheck";
	      }
	   }

	   @GetMapping("/deleteUser")
	   public String deleteUser() {
	      return "views/member/deleteUser";
	   }

	   @GetMapping("/exitUser")
	   public String exitUser() {
	      return "views/member/pwdCheck";
	   }

	// 로그아웃
	@GetMapping("/Logout")
	public String logoutAndReturn(HttpSession session) {
		// 세션에 올라온 유저정보 삭제 후 세션 종료
		session.invalidate();
		
		return "redirect:/main";
	}

	@PostMapping("/deleteUser")
	public String deleteUser(HttpSession session) {
		UserInfoVo userInfo = (UserInfoVo) session.getAttribute("userInfo");
		this.userService.removeUser(userInfo.getUserId());
		
		session.invalidate(); 
		return "redirect:/main";
	
	}
	 
	@GetMapping("/searchIdPwd")
	public String goSearch() {
		System.out.println("00000000000000000000000");
		return "views/member/searchIdPwd";
	}
	
	// 아이디 찾기
	@RequestMapping(value="/returnId", method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam ("sendUserName1") String name, 
									@RequestParam ("sendUserContact1") String userContact
									) {
	
		Map<String, String> map = new HashMap<String, String>();
		map.put("name",name);
		map.put("userContact", userContact);    
	
		String getReturnId = this.userService.researchId(map);
		System.out.println("리턴ID : "+ getReturnId); 
		return getReturnId;  
		   
		
 		}
	
	//비밀번호 찾기
	@RequestMapping(value="/returnPwd", method=RequestMethod.POST)
	public @ResponseBody String checkPwd(@RequestParam("inputUserId2") String userId,
							@RequestParam("inputUserCon2") String userContact,
							@RequestParam("inputUserBir2") String userBirth)  {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userContact", userContact);
		map.put("userBirth", userBirth);
		
		
		String getReturnPwd = this.userService.researchPwd(map);
		System.out.println("리턴PWD : " + getReturnPwd); 
		return getReturnPwd;  
	}
		
}
	

