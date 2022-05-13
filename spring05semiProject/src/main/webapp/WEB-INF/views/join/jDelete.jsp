<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/list.css">
<link rel="stylesheet" href="resources/css/button.css?after">
<link rel="stylesheet" href="resources/css/form.css">
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
	function jDelete(){
		alert("탈퇴가 완료되었습니다.");
	}
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>회원 탈퇴</h2>

	<!-- 안적으면 get 방식(기본) -->
	<form action="jDeleteOK.do" onsubmit="jDelete();">

		<table border="1" id="boardList" >
			<tr>
				<td>${param.id} 회원을 탈퇴시키겠습니까? 
				<input type="hidden" name="id" value="${param.id}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="탈퇴" class="myButton"></td>
			</tr>
		</table>

	</form>
</body>
</html>