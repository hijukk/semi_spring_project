<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll</title>
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
	<h2>회원목록 ${session_id}접속</h2>

	<form action="jSearchList.do">
		<select name="searchKey">
			<option value="id">id</option>
			<option value="gender">gender</option>
		<input type="text"  name ="searchWord" value="hi"> 
		</select> <input type="submit" class="myButton">
	</form>

	<table border="1" id="boardList">
		<tr>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>jdate</th>
			<th>gender</th>
			<th>tel</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td><a href="jSelectOne.do?id=${vo.id}">${vo.id}</a></td>
				<td>${vo.pw}</td>
				<td>${vo.name}</td>
				<td>${vo.jdate}</td>
				<td>${vo.gender}</td>
				<td>${vo.tel}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<c:forEach var="i" begin="1" end="${page_count}">
					<a href="jSelectAll.do?page=${i}">${i}</a>
				</c:forEach>
			</td>
		</tr>
	</table>

</body>
</html>