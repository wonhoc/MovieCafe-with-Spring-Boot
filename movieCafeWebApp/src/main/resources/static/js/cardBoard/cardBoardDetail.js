$(document).ready(function() {

	//목록 버튼 클릭시 목록으로 이동
	
	$('#btnGoList').click(function(){
		location.href="/cardBoardList"
	});	
	//목록 이동 끝
	
	//삭제 버튼 클릭시 삭제
	$('#btnDelete').click(function(){
		
		let boardNo = $('#boardNo').val();
		let userNick = $('#userNick').val();
		
		location.href="/deleteCardBoard/" + boardNo + "/" + userNick;
		
	});
	//삭제 버튼 클릭시 삭제 끝
	
	//수정 버튼시 수정
	$('#btnModify').click(function(){
	
		let boardNo = $('#boardNo').val();
		let userNick = $('#userNick').val();
		
		location.href="/modifyCardBoardForm/" + boardNo + "/" + userNick;
	
	});
	//수정 끝
	
});