$(document).ready(function() {

	//목록 버튼 클릭시 목록으로 이동
	$('#btnGoList').click(function(){
		location.href="/cardBoardList"
	});	
	//목록 이동 끝
	
	//게시글 작성 유효성검사
	$('#btnWriteFormSubmit').click(function(){
	
		let isSuccees = true;
		
		let boardTitle = $('#boardTitle').val().trim();
		let boardContent = $('#boardContent').val().trim();
		
		if(boardTitle == ''){
			alert('제목을 입력해주세요');
			isSuccees = false;
		};
		
		if(boardContent == ''){
			alert('내용을 입력해주세요');
			isSuccees = false;
		};
		
		if(isSuccees){
			$('#FormCardBoardWrite').submit();
			
		};
		
		
	
	});
	//게시글 작성 유효성검사 끝
	
	
	
});//ready end