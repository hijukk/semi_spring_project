<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/list.css">
<link rel="stylesheet" href="resources/css/button.css?after">
<link rel="stylesheet" href="resources/css/form.css">
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>회원정보</h2>

	<table border="1" id="boardList">
		<tr>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>jdate</th>
			<th>gender</th>
			<th>tel</th>
		</tr>
		<tr>
			<td>${vo2.id}</td>
			<td>${vo2.pw}</td>
			<td>${vo2.name}</td>
			<td>${vo2.jdate}</td>
			<td>${vo2.gender}</td>
			<td>${vo2.tel}</td>
		</tr>
	</table>
	<a href="jUpdate.do?id=${vo2.id}" class="myButton">수정</a>
	<a href="jDelete.do?id=${vo2.id}" class="myButton">탈퇴</a>
</body>
</html>