$(document).ready(function() {
			
			//프로필 사진 미리보기
			$("#imgInput").on("change", function handleImgFileSelect(e) {
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
			  });
		     
			
			
			//아이디 중복 체크 
			$('#userId1').bind('focusout', function(){
				const userId = $('#userId1').val();
				
				if(userId== "") {
					$('#resultId').text('아이디는 필수 입력 항목입니다.');
                	$('#resultId').css('color', 'red');
                	$('#isSubmitBtn').attr("disabled",true);
				}  else {
					idchkProcess('/checkId', userId);	
				};

			});
			
			const getAjax2 = function(url, userId) {
				return new Promise( (resolve, reject) => {
					$.ajax({
						url: url,
						method: 'POST',
						data: {
						userId : userId 
						},
						//콜백함수
						success: function(data) {
							resolve(data);
						},
						error : function(e) {
							reject(e);
						}
					});
				});
			};
			
			async function idchkProcess(url, userId) {
				try {
					const result = await getAjax2(url, userId);					
					if(result == 'true') {
	                	$('#resultId').text('이미 사용중인 아이디 입니다.');
	                	$('#resultId').css('color', 'red');
	                	
	                	$('#isSubmitBtn').attr("disabled",true);
					} else if (result == 'false'){
	                	$('#resultId').text('사용 가능한 아이디입니다.');
	                	$('#resultId').css('color', 'blue');
	                	$('#isSubmitBtn').attr("disabled",false);
					}
					} catch (error)  {
						console.log("error : ", error);	
					
					}
				}
						
						
						
			//닉네임 중복 체크
			$('#userNick').bind('focusout', function() {
				const userNick = $('#userNick').val();
				if(userNick == "") {
					$('#result').text('닉네임은 필수 입력 항목입니다.');
                	$('#result').css('color', 'red');
                	$('#isSubmitBtn').attr("disabled",true);
				}  else {
					sendProcess('/checkNick', userNick);		
				};
				
				
			});
			
			 const getAjax1 = function(url, userNick) {
		            return new Promise( (resolve, reject) => {
		                $.ajax({                        
		                    url: url,
		                    method: 'POST',
		                    data: {
		                    	userNick: userNick           
		                    },
		                    // 콜백함수
		                    success: function(data) {
		                    	resolve(data);
		                   
		                    }, 
		                    error: function(e) {                    	
		                        reject(e);
		                    }
		                });
		            });
		        };   
			
			
			async function sendProcess(url, userNick) {
				console.log('userNick : ', userNick);
	            try {
	                const result = await getAjax1(url, userNick);	               
	                console.log("result : ", result.isUserNick);    
	                if(result == "true") {
	                	$('#result').text('이미 사용중인 닉네임입니다.');
	                	$('#result').css('color', 'red');
	                	$('#isSubmitBtn').attr("disabled",true);
	                }  else if (result == "false"){
	                	$('#result').text('사용 가능한 닉네임입니다.');
	                	$('#result').css('color', 'blue');
	                	$('#isSubmitBtn').attr("disabled",false);
	                }
	            } catch (error) {
	                console.log("error : ", error);   
	            }
	        }
			
			//생년월일 선택 부분 구현
			var now = new Date();
			var birthYear = now.getFullYear();
			var birthMonth = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1): '0'+(now.getMonth() + 1);
			var birthDate = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+ (now.getDate());
			
			for(var i = 1900; i <= birthYear; i++) {
				
				$('#birthYear').append('<option value ="'+ i +'" >' + i + '년</option>')
			}
			for(var i = 1; i <= 12; i++) {
				if (i < 10) {
					$('#birthMonth').append("<option value='0" + i + "'>0" + i+ "</option>");
						} else {
							$('#birthMonth').append("<option value='" + i + "'>" + i+ "</option>");
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

			
			//입력한 비밀번호 재확인 
			$('#userPwdCheck1').bind('keyup', function() {
				var p1 = document.getElementById('userPwd1').value;
				var p2 = document.getElementById('userPwdCheck1').value;
				if(p1 != p2) {
					pwdcheck.innerText="비밀번호가 일치하지 않습니다. 다시 입력해주세요.";
					pwdcheck.style.color="red";
					$('#isSubmitBtn').attr("disabled",true);
				} else {
					pwdcheck.innerText="비밀번호가 일치합니다.";
					pwdcheck.style.color="blue";
					$('#isSubmitBtn').attr("disabled",false);
				};	
			});
			
			
				//전체 유효성 검증
				$('#isSubmitBtn').on('click', function() {
					
					if($('#userId1').val() == "" || $('#userId1').val() == null ||
					   $('#userPwd1').val() == "" || $('#userPwd1').val() == null ||
					   $('#userEmail').val() == "" || $('#userEmail').val() == null ||
					   $('#contact2').val() == "" || $('#contact2').val() == null || 
					   $('#contact3').val() == "" || $('#contact3').val() == null ||
					   $('#userNick').val() == "" || $('#userNick').val() == null ||
					   $('#userName').val() == "" || $('#userName').val() == null )
					  	 {
						console.log($('#userId1').val());
						console.log($('#userPwd1').val());
						console.log($('#userEmail').val());
						console.log($('#imgInput').val());
						console.log($('#contact2').val());
						console.log($('#contact3').val());
						console.log($('#userNick').val());
						console.log($('#userName').val());
						alert("필수 항목을 입력하지 않았습니다. 다시 확인해주세요.");
					} else {
						$('#inputLoginData').submit();	
					}
				});
				

				// 비밀번호 길이, 유효성 (영문, 특수, 숫자 포함규칙)검증 
				$('#userPwd1').bind('keyup', function() {
					var pwdRule = /^(?=.*[a-zA-z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{10,30}$/; 
					var p3 = $('#userPwd1').val();
					if (p3.length < 10 || p3.length > 20) {
						$('#pwdcheck0').text("비밀번호는 10~20자 사이로 입력해야 합니다.");
						$('#pwdcheck0').css('color', 'red');
	                	$('#isSubmitBtn').attr("disabled",true);
					} else if (p3.length >= 10 && pwdRule.test(p3) == true){
						$('#pwdcheck0').text("사용할 수 있는 비밀번호 입니다.");
						$('#pwdcheck0').css('color', 'blue');
					} else if (p3.length >= 10 && pwdRule.test(p3) == false) {
						$('#pwdcheck0').text("비밀번호는 영문대소문자, 특수문자, 숫자를 포함해야 합니다.");
						$('#pwdcheck0').css('color', 'red');
	                	$('#isSubmitBtn').attr("disabled",true);
					}
				});
				
				//이메일 유효성 검증 
				$('#userEmail').bind('keyup', function() {
					var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
					var p4 = $('#userEmail').val();
					
					if(emailRule.test(p4) == true) {
						$('#emailcheck').text("사용할 수 있는 이메일입니다.");
						$('#emailcheck').css('color', 'blue');
						$('#isSubmitBtn').attr("disabled",false);
					} else {
						$('#emailcheck').text("형식에 맞지 않는 이메일입니다.");
						$('#emailcheck').css('color', 'red');
						$('#isSubmitBtn').attr("disabled",true);
					}
				})		
				
		});