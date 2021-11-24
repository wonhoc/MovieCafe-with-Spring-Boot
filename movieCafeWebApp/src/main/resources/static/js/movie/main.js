$(document).ready(function() {
	$(".add_btn").on("click", function() {

		console.log("clocked");
	});

	$(".deleteBtn").on("click", function() {

		if (confirm("이 영화 정보를 삭제하시겠습니까?") == true) {
			location.replace('removeMovie.do?movieNo=' + $(this).val());
			alert("삭제되었습니다.")
		} else {
			return;
		}
	});


});