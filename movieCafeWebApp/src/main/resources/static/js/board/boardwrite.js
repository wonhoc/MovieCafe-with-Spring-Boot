window.addEventListener('load', function() {
    const saveBtn = document.getElementById('saveBtn');
   
    saveBtn.addEventListener('click', function() {
    
    const boardTitle = $('#boardTitle').val();
    const boardContent = $('#boardContent').val();
        if(boardTitle == ""){
            alert("제목을 입력해주세요.");
        }else if(boardContent == ""){
            alert("내용을 입력해주세요.");
        }else{
        const form = document.getElementById('form');
        form.submit();
    }
    }); 
})