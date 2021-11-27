$(document).ready(function () {
    $("#imgInput").on("change", handleImgFileSelect);
    $('#form').submit(function() {

    	let flag = true;
    	const title = $('#title').val();

        const director = $('#director').val();
        const actor = $('#actor').val();
        const genre = $('#genre').val();
        const runtime = $('#runtime').val();
        const link = $('#link').val();
        const age = $('#age > option:selected').val();
        const date = $('#date').val();
        const image =  $("#imgInput").val()
        if (title == "" || director == "" || actor == "" || genre == "" || 

        		runtime == "" || link == "" || age == 0 || date == "") {
            alert("정보를 모두 입력해주세요");
            flag = false;
        } else if(image == "") {
        	alert("이미지 파일을 추가해주세요");
        	flag = false;

        } 
        return flag;
    });
  });
  function handleImgFileSelect(e) {
    let files = e.target.files;
    let filesArr = Array.prototype.slice.call(files);
    filesArr.forEach(function (f) {
      if (!f.type.match("image.*")) {
        alert("확장자는 이미지 확장자만 가능합니다.");
        return;
      }
      let reader = new FileReader();
      reader.onload = function (e) {
        $("#img").attr("src", e.target.result);
      };
      reader.readAsDataURL(f);
    });
  }/**
 * 
 */