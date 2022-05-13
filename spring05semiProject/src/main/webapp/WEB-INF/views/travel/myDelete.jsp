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
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>찜삭제</h2>

	<!-- 안적으면 get 방식(기본) -->
	<form action="myDeleteOK.do">

		<table border="1" id="boardList">
			<tr>
				<td>${vo2.id}의 ${vo2.attraction} 글을 찜 삭제하시겠습니까? 
				<input type="hidden" name="attraction" value="${vo2.attraction}"></td>
				<input type="hidden" name="id" value="${vo2.id}"></td>
			</tr>
			<tr>
				<td><input type="submit" class="myButton" ></td>
			</tr>
		</table>

	</form>
</body>
</html>