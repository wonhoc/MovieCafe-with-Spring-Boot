$(document).ready(function () {
    $(".like").on("click", function() {
    	console.log("wow");
    	$(this).removeClass('far');
    	$(this).addClass('fas');
    	
    	const obj = $(this);
    	const userId = $(this).prevAll('.id').text();
    	
    	console.log(obj);
     	
    	 $.ajax({
             url:'${pageContext.request.contextPath}/upLikeGuanram.do',
             method: 'GET',
             dataType: 'json',
             data: {
                movieNo: '${param.movieNo}' ,
                reviewId: userId
             },
             success:function(data){   
            	 obj.find('p').hide(); 
            	 obj.find('.review_text').html(data.upLikeCount);
                	
             },
             error:function(error){
                 console.log(error);
             }
         }); 
    	
    });
    
  });