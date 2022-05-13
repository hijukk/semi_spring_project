<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/list.css">
<link rel="stylesheet" href="resources/css/button.css?after">
<link rel="stylesheet" href="resources/css/form.css">
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
		$("#btn_idCheck").on("click", function(){
			console.log('onclick..');
			console.log($('#id').val());
			
			 $.ajax({
                 data: {id : $('#id').val()},
                 url: 'json_idCheck.do',
                 dataType: 'json',
                 type: 'GET',
                 success: function (responseData) {
                     console.log('success');
                     console.log(responseData.id);
                     let result = '';
                     
                     if($('#id').val() === responseData.id){
                        result = '중복된 아이디 입니다.';
                     }else{
                        result = '사용가능한 아이디 입니다.';
                     }
                        
                     $('#result_idCheck').text(result);
                 },
                 error: function (jqXHR, textStatus, errorThrown) {
                     alert("ajax error : " + textStatus + "\n" + errorThrown);
                 }
             });
			return false;
		});
		
		$("#pw2").on("keyup",function(){
			console.log("keyup...");
			
			var pw = document.getElementById('pw').value;
			var pw2 = document.getElementById('pw2').value;
			var result = "";
			
			if(pw != pw2){
				result = "비밀번호가 일치하지 않습니다";
				$('#result_pwCheck').text(result);
			}else{
				result = "비밀번호가 일치합니다";
				$('#result_pwCheck').text(result);
				
			}
		});
		 
	});
	
	function join(){
		var pw = document.getElementById('pw').value;
		var pw2 = document.getElementById('pw2').value;
		if(pw != pw2){
			alert("비밀번호가 맞지 않습니다.");
			event.preventDefault();
		} else{
			alert("회원가입 성공");
		}
	}
	
	
	
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>회원가입</h2>

	<!-- 안적으면 get 방식(기본) -->
	<form action="jInsertOK.do" method="post" onsubmit="join();">

		<table border="1" id="boardList">
			<tr>
				<th>id</th>
				<td><input type="text" name="id" id="id" placeholder="아이디를 입력해주세요" >
					<button id="btn_idCheck" class="myButton">중복확인</button>
					<span id="result_idCheck"></span>
				</td>
			</tr>
			<tr>
				<th>패쓰워드</th>
				<td><input type="password" name="pw" id="pw"  placeholder="비밀번호를 입력해주세요"></td>
			</tr>
			<tr>
				<th>패쓰워드 재확인</th>
				<td><input type="password" name="pw2" id="pw2" placeholder="비밀번호를 다시 한번 입력해주세요">
				<span id="result_pwCheck"></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" name="name" placeholder="이름을 입력해주세요"></td>
			</tr>
			<tr>
				<th>gender</th>
				<td><select name="gender">
						<option value="여">여</option>
						<option value="남">남</option>
				</select></td>
			</tr>
			<tr>
				<th>tel</th>
				<td><input type="text" name="tel" value="010-123"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="회원가입" class="myButton"></td>
			</tr>
		</table>

	</form>
</body>
</html>