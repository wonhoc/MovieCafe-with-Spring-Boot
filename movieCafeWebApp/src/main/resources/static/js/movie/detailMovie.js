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

    const url = window.location.pathname.split('/');
    const movieId = url[2];

    $.ajax({
        url: `https://yts.mx/api/v2/movie_details.json?movie_id=${movieId}&with_cast=true`,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $(".loadingBox").remove();
            const movieData = data.data.movie;
            console.log(movieData.cast.length);
            let actors = [];
            let genres = [];
            movieData.cast.forEach((actor) => actors.push(actor.name));
            movieData.genres.forEach((genre) => genres.push(genre));
            $(".top_left").append(`
            <img
                src="${movieData.medium_cover_image}"
                alt="image" class="detail_img" />
            <div class="detail_content">
                <h1 class="detail_title">${movieData.title}</h1>
                <p class="detail_text">배우 : ${actors.join(', ')}</p>
                <p class="detail_text">장르 : ${genres.join(', ')}</p>
                <p class="detail_text">러닝타임 : ${movieData.runtime} 분</p>
                <p class="detail_text">개봉연도 : ${movieData.year} 년</p>
                <p class="detail_text">평점 : ${movieData.rating} / 10</p>
            </div>
            `);
        },
        beforeSend: function () {
            $(".top_left").append(`
            <div class="loadingBox">
                <P class="loadingText">로딩중</P>
                <div class="loader10"></div>
            </div> `);
        },
        error: function (error) {
            console.log(error);
        }
    });
    
  });