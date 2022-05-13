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
	<h2>${vo2.attraction} 정보</h2>
	<form action="myDelete.do">
		<table border="1" id="boardList">
			<tr>
				<th>attraction</th>
				<th>location</th>
				<th>content</th>
				<th>tdate</th>
				<th>img</th>
			</tr>
			<tr>
				<td><input type="hidden" name="attraction"
					value="${vo2.attraction}"> <input type="hidden" name="id"
					value="${vo2.id}">${vo2.attraction}</td>
				<td><input type="hidden" name="location"
					value="${vo2.location}">${vo2.location}</td>
				<td><input type="hidden" name="content" value="${vo2.content}">${vo2.content}</td>
				<td><input type="hidden" name="tdate" value="${vo2.tdate}">${vo2.tdate}</td>
				<td><input type="hidden" name="file"
					value="${vo2.save_file_name}"><img width="50px"
					src="resources/uploadimg/${vo2.save_file_name}"></td>
			</tr>
		</table>
		<input type="submit" class="myButton" value="찜삭제">
	</form>

</body>
</html>