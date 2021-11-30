// 추천 처리
$(document).ready(function() {
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
                        alert(data.result);
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
	    $("#recomBtn").click(	    		
	    	function() {
	    			
	    			
	    			const boardNo = $('#boardNo').val();
	    			
                    console.log(boardNo);
	    			
		    		requestRecomProcess('/insertRecom', boardNo);

	    		
				
            }
	    );
});
	  