$(document).ready(function() {
        const getAjax = function(url, comContent,boardNo) {
            return new Promise( (resolve, reject) => {
                $.ajax({                        
                    url: url,
                    method: 'GET',
                    dataType: 'json',
                    data: {
                    	url: url,
                     	comContent: comContent,
                     	boardNo: boardNo
                    },
                    success: function(data) {                    	
                        resolve(data);
                    }, 
                    error: function(e) {                    	
                        reject(e);
                    }
                });
            });
        }
        /*
        const removeComment = function(url, comNo, boardNo) {
            // resolve, reject는 자바스크립트에서 지원하는 콜백 함수이다.
            return new Promise( (resolve, reject) => {
                $.ajax({                        
                    url: url,
                    method: 'GET',
                    dataType: 'json',
                    data: {
                    	url: url,
                    	comNo: comNo,
                    	boardNo: boardNo
                    },
                    success: function(data) {                    	
                        resolve(data);
                    }, 
                    error: function(e) {    
                        reject(e);
                    }
                });
            });
        }   

        const modifyComment = function(url, comNo, comContent, boardNo) {
            // resolve, reject는 자바스크립트에서 지원하는 콜백 함수이다.
            return new Promise( (resolve, reject) => {
                $.ajax({                        
                    url: url,
                    method: 'GET',
                    dataType: 'json',
                    data: {
                    	url: url,
                    	comNo: comNo,
                    	comContent: comContent,
                    	boardNo: boardNo
                    },
                    success: function(data) {                    	
                        resolve(data);
                    }, 
                    error: function(e) {                    	
                        reject(e);
                    }
                });
            });
        }   
        */
        
        //댓글 리스트
        async function requestProcess(url, comContent, boardNo) {
            try {
            	var boardNo = $('#boardNo').val();
            	let comList = null;
            	
            	comList = await getAjax(url, comContent,boardNo);	
            	
            	console.log(comList);
            	     
                                   
                $('#ListComment').html("");
               
			 	let htmlStr = [];
			 	for(let i = 0; i< comList.length; i++) {
			 		htmlStr.push('<tr>');
			 		htmlStr.push('<td>' + comList[i].userId + '</td>');
			 		htmlStr.push('<td>' + comList[i].comWdate + '</td>');
			 		htmlStr.push('</tr>');		
			 		htmlStr.push('<tr>');	
			 		htmlStr.push('<td colspan="2" class="comContent">' + comList[i].comContent + '</td>');
			 		htmlStr.push('</tr>');
			 		htmlStr.push('<tr>');	
			 		htmlStr.push('<td colspan="2">');
			 		htmlStr.push('<button class="modifyFormBtn" type="button">수정</button>&nbsp;');		
			 		htmlStr.push('<button class="removeBtn" type="button">삭제</button>');			
			 		htmlStr.push('</td>');					
			 		htmlStr.push('</tr>');
		 		
			 	}         
			 	
			 	$('#ListComment').html(htmlStr.join(""));
                  
            } catch (error) {
                console.log("error : ", error);   
            }
        }
        
        
        /*
        //댓글 삭제용 함수
        async function removeRequestProcess(url, comNo, boardNo) {
            try {
            	let comList = null;
            	
            		comList = await removeComment(url, comNo,boardNo);	
            		$('#ListComment').html("");
                    
    			 	let htmlStr = [];
    			 	for(let i = 0; i< comList.length; i++) {
    			 		htmlStr.push('<table id=' + comList[i].comNo +'>');
    			 		htmlStr.push('<tbody>');
    			 		htmlStr.push('<tr>');
    			 		htmlStr.push('<td>' + comList[i].userId + '</td>');
    			 		htmlStr.push('<td>' + comList[i].comWdate + '</td>');
    			 		htmlStr.push('</tr>');		
    			 		htmlStr.push('<tr>');	
    			 		htmlStr.push('<td colspan="2" class="comContent">' + comList[i].comContent + '</td>');
    			 		htmlStr.push('</tr>');
    			 		htmlStr.push('<tr>');	
    			 		htmlStr.push('<td colspan="2">');
    			 		htmlStr.push('<button class="modifyFormBtn" type="button">수정</button>&nbsp;');		
    			 		htmlStr.push('<button class="removeBtn" type="button">삭제</button>');			
    			 		htmlStr.push('</td>');					
    			 		htmlStr.push('</tr>');
    			 		htmlStr.push('</tbody>');
    			 		htmlStr.push('</table>');				 		
    			 	}         
            
    			 	$('#ListComment').html(htmlStr.join(""));
            }catch (error) {
                console.log("error : ", error);   
            }
        }
		
        //댓글 수정용 함수
        async function modifyRequestProcess(url, comNo, comContent, boardNo) {
            try {
            	let comList = null;
            	
            		comList = await modifyComment(url, comNo, comContent, boardNo);	
            	                   
                $('#ListComment').html("");
               
			 	let htmlStr = [];
			 	for(let i = 0; i< comList.length; i++) {
			 		htmlStr.push('<table id=' + comList[i].comNo +'>');
			 		htmlStr.push('<tbody>');
			 		htmlStr.push('<tr>');
			 		htmlStr.push('<td>' + comList[i].userId + '</td>');
			 		htmlStr.push('<td>' + comList[i].comWdate + '</td>');
			 		htmlStr.push('</tr>');		
			 		htmlStr.push('<tr>');	
			 		htmlStr.push('<td colspan="2" class="comContent">' + comList[i].comContent + '</td>');
			 		htmlStr.push('</tr>');
			 		htmlStr.push('<tr>');	
			 		htmlStr.push('<td colspan="2">');
			 		htmlStr.push('<button class="modifyFormBtn" type="button">수정</button>&nbsp;');		
			 		htmlStr.push('<button class="removeBtn" type="button">삭제</button>');			
			 		htmlStr.push('</td>');					
			 		htmlStr.push('</tr>');
			 		htmlStr.push('</tbody>');
			 		htmlStr.push('</table>');				 		
			 	}         
			 	
			 	$('#ListComment').html(htmlStr.join(""));
                  
            } catch (error) {
                console.log("error : ", error);   
            }
        }
        */
        //댓글 작성
	    $('#addComBtn').on('click', function() {
	    	var board = $('#sboardNo').val();
	    	const comContent = $('#addComContent').val();
	    	requestProcess('/comWrite', comContent, board);
	   
	    });
        
/*
        $('#ListComment').on('click', '.modifyFormBtn', function() {                
        	const comNo = $(this).parents('table').attr('id');
        	$('#modifyComment').insertAfter('#' + comNo);                	
        	const comContent = $(this).parents('tbody').find('.comContent').text();                
        	$('#modifyComContent').val(comContent);
        	$('#comNo').val(comNo);
        	$('#modifyComment').show();
        	$('#' + comNo).hide();                	
        });
       
        
        //댓글 삭제
        $('#ListComment').on('click', '.removeBtn', function() { 
        	const boardNo = ${requestScope.board.boardNo};
        	const comNo = $(this).parents('table').attr('id');
        	removeRequestProcess('${pageContext.request.contextPath}/board/removeComment.do', comNo, boardNo);        	
        });
        
        
        //댓글 취소
        $('#cancel').on('click', function() {
        	const comNo = $('#comNo').val();
        	$('#' + comNo).show();    
        	$('#modifyComment').hide();
        	$('#modifyComment').insertAfter('#addComment');
        });
        
        //댓글 수정
        $('#modifyBtn').on('click', function() {
        	const comNo = $('#comNo').val();
        	const comContent = $('#modifyComContent').val();
        	const boardNo = ${requestScope.board.boardNo};
        	modifyRequestProcess('${pageContext.request.contextPath}/board/modifyComment.do', comNo, comContent, boardNo);   
        
        });
        
        //추천처리
        const recomAjax = function(url, boardNo) {
            return new Promise( (resolve, reject) => {
                $.ajax({                        
                    url: url,
                    method: 'GET',
                    dataType: 'json',
                    data: {
                    	url: url,
                     	boardNo: boardNo
                     	
                    },
                    success: function(data) {                    	
                        resolve(data);
                    }, 
                    error: function(e) {                    	
                        reject(e);
                    }
                });
            });
        }   
        
        
        //추천등록용 함수
        async function requestRecomProcess(url, boardNo) {
            try {
            	await recomAjax(url,boardNo);
            	
            	
            	}         
			 	 catch (error) {
                console.log("error : ", error);   
            }
        }
        
        
        //추천 insert
        let isRecommend = true;
        console.log("is", isRecommend);
	    $("#recomBtn").click(	    		
	    	function() {
	    		
	    	
	    		if(isRecommend) {
	    			alert("추천완료");
	    			isRecommend = false;
	    			const boardNo = ${requestScope.board.boardNo};
		    		requestRecomProcess('${pageContext.request.contextPath}/board/recomBoard.do', boardNo);
	    		} else {
	    			alert("추천취소");
	    			isRecommend = true;	 
	    			const boardNo = ${requestScope.board.boardNo};
		    		requestRecomProcess('${pageContext.request.contextPath}/board/recomBoard.do', boardNo);
	    		}
	    		
	    	 }
	    );
        
	    
	    <!--  신고 처리 -->
        const reportAjax = function(url, boardNo) {
            return new Promise( (resolve, reject) => {
                $.ajax({                        
                    url: url,
                    method: 'GET',
                    dataType: 'json',
                    data: {
                    	url: url,
                     	boardNo: boardNo
                     	
                    },
                    success: function(data) {                    	
                        resolve(data);
                    }, 
                    error: function(e) {                    	
                        reject(e);
                    }
                });
            });
        }   
        
        
        //신고등록용 함수
        async function requestReportProcess(url, boardNo) {
            try {
            	await reportAjax(url,boardNo);         	
            	}         
			 	 catch (error) {
                console.log("error : ", error);   
            }
        }
        
        
        //신고 insert
       $("#reportBtn").click(	    		
	    	function() {
	    		alert("신고완료");
	    			const boardNo = ${requestScope.board.boardNo};
		    		requestReportProcess('${pageContext.request.contextPath}/board/reportBoard.do', boardNo);
	    		
	    	 }
	    );
        */
	});
	    