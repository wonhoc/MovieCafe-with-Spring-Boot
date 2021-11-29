const url = window.location.pathname.split('/');
const movieId = url[2];

function addRating() {
    let count = document.getElementById("rank").value;
    console.log(count);
    for(let i=0; i<count; i++){
        $(".rank").append(`
        <i class="fas fa-star review_text"></i>
        `);
    }
}

$(document).ready(function () {
    //addRating();

    $(".like").on("click", function() {
        console.log("clicked");
    	$(this).removeClass('far');
    	$(this).addClass('fas');
    	
    	const obj = $(this);

        console.log(document.getElementById("listSize").value);
        $("#listSize").append(``)

     	console.log(document.getElementById("guanramReview").value);
        console.log(obj.find('#guanramReview'));
    	 $.ajax({
             url:'http://localhost:8080/upLike',
             method: 'GET',
             dataType: 'json',
             data: {
                guanramNo: document.getElementById("guanramNo").value
             },
             success:function(data){   
                obj.find('.review_text').html(data);
             },
             error:function(error){
                 console.log(error);
             }
         }); 
    	
    });

    $.ajax({
        url: `https://yts.mx/api/v2/movie_details.json?movie_id=${movieId}&with_cast=true`,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $(".loadingBox").remove();
            const movieData = data.data.movie;
            let actors = [];
            let genres = [];

            $('input[id=imgUrl]').attr('value',movieData.medium_cover_image);
            $('input[id=title]').attr('value',movieData.title);
            
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