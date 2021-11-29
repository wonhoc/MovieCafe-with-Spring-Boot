

//버튼 누르면 submit
$(document).ready(function() {

	$('#removeDetailMsgBtn').on('click', function() {
		const form = $('#removeForm');
		form.submit();
	});

});