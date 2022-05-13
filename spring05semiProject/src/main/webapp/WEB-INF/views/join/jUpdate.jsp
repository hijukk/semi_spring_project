<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/list.css">
<link rel="stylesheet" href="resources/css/button.css?after">
<link rel="stylesheet" href="resources/css/form.css">
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
	function jUpdate(){
		alert("수정이 완료되었습니다.");
	}
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>회원 수정</h2>

	<!-- 안적으면 get 방식(기본) -->
	<form action="jUpdateOK.do" onsubmit="jUpdate();" method="post">

		<table border="1" id="boardList">
			<tr>
				<th>id</th>
				<td>${vo2.id}<input type="hidden" name="id" value="${vo2.id}"></td>
			</tr>
			<tr>
				<th>pw</th>
				<td><input type="text" name="pw" value="${vo2.pw}"></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" name="name" value="${vo2.name}"></td>
			</tr>
			<tr>
				<th>tel</th>
				<td><input type="text" name="tel" value="${vo2.tel}"></td>
			</tr>
			<tr>
				<th>가입날짜</th>
				<td>${vo2.jdate}<input type="hidden" name="jdate" value="${vo2.jdate}"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${vo2.gender}<input type="hidden" name="gender" value="${vo2.gender}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="수정" class="myButton"></td>
			</tr>
		</table>

	</form>
</body>
</html>