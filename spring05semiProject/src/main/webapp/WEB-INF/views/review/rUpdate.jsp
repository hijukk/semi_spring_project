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
</script>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>맛집게시글 수정</h2>
	<!-- 안적으면 get 방식(기본) -->
	<form action="rUpdateOK.do" method="post" enctype="multipart/form-data">

		<table border="1" id="boardList">
			<tr>
				<th>num</th>
				<td>${vo2.rnum}<input type="hidden" name="rnum"
					value="${vo2.rnum}"></td>
			</tr>
			<tr>
				<th>title</th>
				<td><input type="text" name="rtitle" value="${vo2.rtitle}"></td>
			</tr>
			<tr>
				<th>content</th>
				<td><textarea rows="10" cols="30" name="rcontent">${vo2.rcontent}</textarea></td>
			</tr>
			<tr>
				<th>writer</th>
				<td><input type="text" name="rwriter" value="${session_id}"></td>
			</tr>
			<tr>
				<th>image</th>
				<td><input type="file" name="multipartFile"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="myButton"></td>
			</tr>
		</table>

	</form>
</body>
</html>