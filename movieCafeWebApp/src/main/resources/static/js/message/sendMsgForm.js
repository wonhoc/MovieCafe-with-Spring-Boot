// 받는사람 숫자 
var temp = 0;
// 받는사람, 내용 없을시 false return
$(document).ready(function() {
    
    
    $('#content').on('blur', 'input[name=reciveId]', function() {
        
        let inputId = $(this).val();
        receivechkProcess('${pageContext.request.contextPath}/CheckReceiveId.do',inputId);
        
        
    });
    
        $('#sendMsgBtn').on('click', function() {
          //  내용유효성 검사 				
            if($('#sendMsgContent').val().trim() == '') {
                alert('내용을 정확하게 입력해주세요.');
                return false;
            }
           // 내용유효성 검사 끝 
        // 받는 사람 유효성 검사 
        $('input[name=reciveId]').each(function(i) {
            const name = $(this).val();

            if(name == '') {
                alert('받는 사람을 입력해주세요.');
                return false;							
            }
            
        $('#sendMsgForm').submit();
        
        });						
       // 받는 사람 유효성 검사 끝 
            });

        // Ajax 
         const getAjax = function(url, userId) {
            return new Promise( (resolve, reject) => {
                $.ajax({
                    url: url,
                    method: 'POST',
                    dataType: 'json',
                    data: {
                        userId: userId
                    },
                    //콜백함수
                    success: function(data) {
                        resolve(data);
                    },
                    error : function(e) {
                        reject(e);
                    }
                });
            });
        };
        
        async function receivechkProcess(url, userId) {

            console.log('name = ' , userId);
            try {
                const result = await getAjax(url, userId);
                console.log("result : ", result.resultCount);
                if(result.resultCount == 0 ) {
                    alert(userId +  '에게는 쪽지를 보낼 수 없습니다.\n아이디를 다시확인 해주세요.');
                    $('#sendMsgBtn').attr("disabled", true);
                    $('#infoSendtext').html('<div>아이디를 다시 확인해주세요</div>');
                 }else{
                     $('#sendMsgBtn').attr("disabled", false);
                     $('#infoSendtext').html('');
                 }
            } catch (error)  {
                console.log("error : ", error);	
                
            }
        }
        
       
	//받는사람 추가 
	$('#plusFrom').on('click', function() {
	    if(temp<4){temp = temp + 1;}else{
	        alert('쪽지는 한번에 5명까지만 보낼 수 있습니다.');
	        return false;			
	    }		
	    const htmlstr = '<br><input type="text" name="reciveId" id="reciveId" placeholder="받는사람">'
	        + '<button type="button" id="minForm">-</button>';
	    $('#recieveId').append(htmlstr);		
	});


});



//  버튼 클릭시 받는사람 삭제 --%>
$(document).on("click","#minForm",function(){
    temp = temp -1;
    $(this).prev().prev().remove();
    $(this).prev().remove();
    $(this).remove();
});