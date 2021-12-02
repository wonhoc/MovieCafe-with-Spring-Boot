const url = window.location.pathname.split('/');
const movieId = url[2];
let guanramNo;
let guanramLike;

function uplike(t) {
    if(t.querySelector('i').getAttribute('id') == 'clicked'){
        return;
    }

    //let obj = $(this);
    console.log(t.querySelector('p').getAttribute('id'));

    $.ajax({
        url: '/upLike',
        method: 'GET',
        dataType: 'json',
        data: {
            guanramNo: t.querySelector('p').getAttribute('id')
        },
        success: function (data) {
            guanramLike = data;

            t.innerHTML = `<i class="fas fa-heart review_text heart" id="clicked"></i><p class="review_text" id="${t.querySelector('p').getAttribute('id')}">${data}</p>`;

        },
        error: function (error) {
            console.log(error);
        }
    });
}

$(document).ready(function () {
    $('.heart').click(function () {
        alert("000");
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

            $('input[id=imgUrl]').attr('value', movieData.medium_cover_image);
            $('input[id=title]').attr('value', movieData.title);

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

    $.ajax({
        url: '/guanramList',
        method: 'GET',
        dataType: 'json',
        data: {
            movieId: movieId
        },
        success: function (data) {

            $('#pagination-div').twbsPagination({
                totalPages: Math.ceil(data.length / 10),   // 총 페이지 번호 수
                visiblePages: 5,   // 하단에서 한번에 보여지는 페이지 번호 수
                startPage: 1, // 시작시 표시되는 현재 페이지
                initiateStartPageClick: true,   // 플러그인이 시작시 페이지 버튼 클릭 여부 (default : true)
                first: "<<",   // 페이지네이션 버튼중 처음으로 돌아가는 버튼에 쓰여 있는 텍스트
                prev: "<",   // 이전 페이지 버튼에 쓰여있는 텍스트
                next: ">",   // 다음 페이지 버튼에 쓰여있는 텍스트
                last: ">>",   // 페이지네이션 버튼중 마지막으로 가는 버튼에 쓰여있는 텍스트
                nextClass: "page-item next",   // 이전 페이지 CSS class
                prevClass: "page-item prev",   // 다음 페이지 CSS class
                lastClass: "page-item last",   // 마지막 페이지 CSS calss
                firstClass: "page-item first",   // 첫 페이지 CSS class
                pageClass: "page-item",   // 페이지 버튼의 CSS class
                activeClass: "active",   // 클릭된 페이지 버튼의 CSS class
                disabledClass: "disabled",   // 클릭 안된 페이지 버튼의 CSS class
                anchorClass: "page-link",   //버튼 안의 앵커에 대한 CSS class

                onPageClick: function (event, page) {
                    //클릭 이벤트
                    let startRow = (page - 1) * 5;
                    $(".guanramList").empty();
                    let html = "";
                    for (let i = startRow; i < startRow + 5; i++) {

                        guanramLike = data[i].guanramLike;

                        html += '<div class="guanram"><img src="/upload/' + data[i].photoSys + '" alt="profile" class="review_profile" />';
                        html += '<p class="review_text id" >' + data[i].userId + '</p>';
                        html += '<p class="review_text content">' + data[i].guanramReview + '</p>';
                        html += '<p class="review_text date">' + data[i].guanramWdate.substring(0, 11) + '</p>';
                        html += '<div class="like" onclick="uplike(this)"><i class="far fa-heart review_text heart"></i>';
                        html += '<p class="review_text" id="' + data[i].guanramNo + '">' + guanramLike + '</p></div>';
                        html += '<div class="rank">';
                        for (let j = 0; j < data[i].guanramRating; j++) {
                            html += '<i class="fas fa-star review_text"></i>';
                        }
                        html += '</div>';

                        html += '<button type="submit" class="btn btn-light" onclick="location.href=\'/deleteGuanram/' + movieId + '?guanramNo=' + data[i].guanramNo + '\';">삭제</button></div>';

                        $(".guanramList").html(html);
                    }

                }
            });
        },
        error: function (error) {
            console.log(error);

        }
    });

});
