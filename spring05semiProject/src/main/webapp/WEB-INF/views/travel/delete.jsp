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
	<h2>여행게시글 삭제</h2>
	<!-- 안적으면 get 방식(기본) -->
	<form action="deleteOK.do">

		<table border="1" id="boardList">
			<tr>
				<td>${param.attraction} 글을 정말 삭제?? 
				<input type="hidden" name="attraction" value="${param.attraction}"></td>
			</tr>
			<tr>
				<td><input type="submit" class="myButton"></td>
			</tr>
		</table>

	</form>
</body>
</html>