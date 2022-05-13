<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mySelectAll</title>
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
	<h2>찜목록</h2>
	<table border="1" id="boardList">
		<tr>
			<th>attraction</th>
			<th>id</th>
			<th>save_date</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td><a href="mySelectOne.do?attraction=${vo.attraction}&id=${vo.id}">${vo.attraction}</a></td>
				<td>${vo.id}</td>
				<td>${vo.save_date}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>