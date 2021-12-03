$(document).ready(function() {
	$('#MsgHomeBtn').on('click',
		function() {
			window
				.open(
					'/sendMsgList',
					'_blank',
					'height=500, width=500, resizable=no');
		});

});
