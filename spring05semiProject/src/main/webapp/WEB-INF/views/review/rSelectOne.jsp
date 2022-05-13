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
		// 				location.href = "rUpdate.do?rnum=${vo2.rnum}";
		// 			} else {
		// 				alert("접근권한이 없습니다.");
		// 			}

		// 			return false;

		// 		});
		// 		$("#btn_delete").on("click", function() {

		// 			let session_id = '${session_id}';
		// 			console.log("session_id: ", session_id);

		// 			if (session_id == 'admin') {
		// 				location.href = "rDelete.do?rnum=${vo2.rnum}";
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
	<h2>${vo2.rtitle}후기</h2>

	<table border="1" id="boardList">
		<tr>
			<th>num</th>
			<td>${vo2.rnum}</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${vo2.rtitle}</td>
		</tr>
		<tr>
			<th>content</th>
			<td>${vo2.rcontent}</td>
		</tr>
		<tr>
			<th>writer</th>
			<td>${vo2.rwriter}</td>
		</tr>
		<tr>
			<th>wdate</th>
			<td>${vo2.rdate}</td>
		</tr>
		<tr>
			<th>img</th>
			<td><img src="resources/ruploadimg/${vo2.rsave_file_name}"></td>
		</tr>
	</table>

	<!-- 로그인사람이 admin이거나 글쓴사람과 같을때만 보여줌 -->
	<!-- 로그인안하면 아예 이페이지 못들어옴 -->
	<c:if
		test="${session_id == 'admin'||session_id == vo2.rwriter}">
		<a href="rUpdate.do?rnum=${param.rnum}" class="myButton">수정</a>
		<a href="rDelete.do?rnum=${param.rnum}" class="myButton">삭제</a>
	</c:if>
</body>
</html>