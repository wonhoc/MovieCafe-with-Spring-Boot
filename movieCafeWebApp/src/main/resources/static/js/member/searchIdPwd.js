	$(document).ready(function() { 
			//아이디 찾기
			$('#inputNameConBtn').on('click', function() {
				const sendUserName = $('#inputUserName').val();
				const sendUserContact = $('#userContact').val();
				
				getForgetId('/returnId', sendUserName, sendUserContact);
				
			});
			
			const getAjax3 = function(url, username, usercon) {
				return new Promise( (resolve, reject) => {
					$.ajax({
					
						url: url,
						method: 'POST',
						dataType: 'text',
						data: {
							sendUserName1 : username,
							sendUserContact1 : usercon
							
						},
						success: function(data) {
							resolve(data);
						},
						error : function(e) {
							reject(e);
						}
						
					});
					
				});
			};
			
			async function getForgetId(url, sendUserName, sendUserContact) {
				console.log('sendUserName =', sendUserName);
				console.log('sendUserContact = ', sendUserContact);
			
					try {
					const result3 = await getAjax3(url, sendUserName, sendUserContact);
					console.log(result3);
			 if(result3.length >= 1) {
						alert("아이디는 " + result3 + " 입니다.");				
					} else {
						alert("아이디를 찾는데 실패하였습니다.");
					} 
					
				} catch(error5) {
					console.log("error5 : ", error5);
					}    
				} 
			
			
			//생년월일 선택 부분 구현
			var now = new Date();
			var birthYear = now.getFullYear();
			var birthMonth = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1): '0'+(now.getMonth() + 1);
			var birthDate = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+ (now.getDate());
			
			for(var i = 1900; i <= birthYear; i++) {
				
				$('#birthYear').append('<option value ="'+ i +'" >' + i + '년</option>');
			};
			for(var i = 1; i <= 12; i++) {
				if (i < 10) {
					$('#birthMonth').append("<option value='0" + i + "'>0" + i+ "월</option>");
						} else {
							$('#birthMonth').append("<option value='" + i + "'>" + i+ "일</option>");
						}
					}
			for (var i = 1; i <= 31; i++) {
				if (i < 10) {
					$("#birthDate").append(
							"<option value='0" + i + "'>0" + i
									+ "</option>");
				} else {
					$("#birthDate").append(
							"<option value='" + i + "'>" + i
									+ "</option>");
				}
			}
			$("#birthYear > option[value="+birthYear+"]").attr("selected", "true");
			$("#birthMonth > option[value="+birthMonth+"]").attr("selected", "true");
			$("#birthDate > otpion[value="+birthDate+"]").attr("selected", "true");

		
			//비밀번호 찾기
			$('#inputNameConBirBtn').on('click', function() {
				
				
				const inputUserId2 = $('#inputUserId2').val();
				const inputUserCon2 = $('#inputUserCon2').val();
				const inputUserBir2 = $('#birthYear').val() +"-" + $('#birthMonth').val() + "-" + $('#birthDate').val();
				
				console.log(inputUserId2 + inputUserCon2 + inputUserBir2);
				
				getForgetPw('/returnPwd', inputUserId2,inputUserCon2,inputUserBir2);
			});
			
			const getAjax4 = function(url, inputUserId2, inputUserCon2,inputUserBir2 ) {
				return new Promise((resolve, reject) => {
					$.ajax({
					
						url: url,
						method: 'POST',
						dataType: 'text',
						data: {
							inputUserId2 : inputUserId2,
							inputUserCon2 : inputUserCon2,
							inputUserBir2 : inputUserBir2
						},
						success: function(data) {
							resolve(data);
						},
						error: function(e) {
							reject(e);
						}
					});
				});
			};
			async function getForgetPw(url, inputUserId2, inputUserCon2, inputUserBir2) {
			
				try {
					const result4 = await getAjax4(url,inputUserId2, inputUserCon2, inputUserBir2 );
					console.log(result4);
						if (result4.length >= 1) {
							alert("비밀번호는" + result4 + "입니다.");
						} else {
							alert("비밀번호를 찾는데 실패하였습니다.");
						}
				
					}catch (error6) {
						console.log("error6 : ", error6);
					
				}				
			}
		})