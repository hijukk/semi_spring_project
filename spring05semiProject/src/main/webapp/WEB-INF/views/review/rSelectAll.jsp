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
	<h2>맛집 게시글</h2>

	<form action="rSearchList.do">
		<select name="searchKey">
			<option value="rtitle">title</option>
			<option value="rcontent">content</option>
			<option value="rwriter">writer</option>
		</select> <input type="text" name="searchWord" value="떡볶이"> <input
			type="submit" class="myButton">
	</form>

	<table border="1" id="boardList">
		<tr>
			<th>행번호</th>
			<th>글번호</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>wdate</th>
			<th>img</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.rn}</a></td>
				<td><a href="rSelectOne.do?rnum=${vo.rnum}">${vo.rnum}</a></td>
				<td>${vo.rtitle}</td>
				<td>${vo.rcontent}</td>
				<td>${vo.rwriter}</td>
				<td>${vo.rdate}</td>
				<td><img width="50px"
					src="resources/ruploadimg/thumb_${vo.rsave_file_name}"></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
			<c:forEach var="i" begin="1" end="${page_count}">
					<a href="rSelectAll.do?page=${i}">${i}</a>
			</c:forEach></td>
		</tr>
	</table>

</body>
</html>