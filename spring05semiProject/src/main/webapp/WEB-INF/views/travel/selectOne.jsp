<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		// 		$("#btn_update").on("click", function() {

		// 			let session_id = '${session_id}';
		// 			console.log("session_id: ", session_id);

		// 			if (session_id == 'admin') {
		// 				location.href = "update.do?attraction=${vo2.attraction}";
		// 			} else {
		// 				alert("접근권한이 없습니다.");
		// 			}

		// 			return false;

		// 		});
		// 		$("#btn_delete").on("click", function() {

		// 			let session_id = '${session_id}';
		// 			console.log("session_id: ", session_id);

		// 			if (session_id == 'admin') {
		// 				location.href = "delete.do?attraction=${vo2.attraction}";
		// 			} else {
		// 				alert("접근권한이 없습니다.");
		// 			}

		// 			return false;

		// 		});
	});
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>${vo2.attraction} 여행지 정보</h2>
	<table border="1" id="boardList">
		<tr>
			<th>title</th>
			<td>${vo2.attraction}</td>
		</tr>
		<tr>
			<th>location</th>
			<td>${vo2.location}</td>
		</tr>
		<tr>
			<th>content</th>
			<td>${vo2.content}</td>
		</tr>
		<tr>
			<th>travel date</th>
			<td>${vo2.tdate}</td>
		</tr>
		<tr>
			<th>img</th>
			<td><img src="resources/uploadimg/${vo2.save_file_name}"></td>
		</tr>
	</table>
	<a href="myInsertOK.do?attraction=${vo2.attraction}" class="myButton">찜</a>

	<!-- admin일때만 수정삭제 보여줌 -->
	<c:if test="${session_id=='admin'}">
		<a href="update.do?attraction=${vo2.attraction}" class="myButton">수정</a>
		<a href="delete.do?attraction=${vo2.attraction}" class="myButton">삭제</a>
	</c:if>

</body>
</html>