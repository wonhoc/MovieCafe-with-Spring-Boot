
$(document).ready(function() {
    // 추천 처리   
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
                       const recomCnt = data.recomCnt;
                        $("#originRecom").html("");
                        	let str = '<td>'+ recomCnt + '</td>'
                       $("#originRecom").html(str);
                       
                        
                        resolve(data);
                    }, 
                    error: function(e) {                       
                        reject(e);
                    }
                });
            });
        };   
        
        
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
                   
                
                requestRecomProcess('/insertRecom', boardNo);

             
            
            }
       );




        // *****************************신고 처리
              
    const reportAjax = function(url, boardNo, userId) {
        return new Promise( (resolve, reject) => {
            $.ajax({                        
                url: url,
                method: 'GET',
                dataType: 'json',
                data: {
                    boardNo: boardNo,
                    userId : userId
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
    
    
    //신고등록용 함수
    async function requestReportProcess(url, boardNo, userId) {
        try {
            await reportAjax(url,boardNo, userId);
    
            }         
              catch (error) {
            console.log("error : ", error);   
        }
    }
    
    
    //신고 버튼 이벤트
    $("#reportBtn").click(             
        function() {
                
                console.log($('#userId').val());
                const boardNo = $('#boardNo').val();
               // const userId = "test_user08";
                const userId = $('#writer').val();
                requestReportProcess('/insertReport', boardNo, userId);

            
            
        }
    ); 
});
     