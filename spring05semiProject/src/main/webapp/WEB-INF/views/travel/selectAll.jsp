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
	<h2>여행지추천</h2>

	<form action="searchList.do" method="GET">
		<select name="searchWord">
			<option value="">여행할 달을 선택하세요.</option>
			<option value="1월">1월</option>
			<option value="2월">2월</option>
			<option value="3월">3월</option>
			<option value="4월">4월</option>
			<option value="5월">5월</option>
			<option value="6월">6월</option>
			<option value="7월">7월</option>
			<option value="8월">8월</option>
			<option value="9월">9월</option>
			<option value="10월">10월</option>
			<option value="11월">11월</option>
			<option value="12월">12월</option>
		</select> <input type="submit" value="검색" class="myButton">
	</form>

	<table border="1" id="boardList">
		<tr>
			<th>title</th>
			<th>location</th>
			<th>content</th>
			<th>travel date</th>
			<th>img</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td><a href="selectOne.do?attraction=${vo.attraction}">${vo.attraction}</a></td>
				<td>${vo.location}</td>
				<td>${vo.content}</td>
				<td>${vo.tdate}</td>
				<td><img src="resources/uploadimg/thumb_${vo.save_file_name}"></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="12">
				<c:forEach var="i" begin="1" end="${page_count}">
					<a href="selectAll.do?page=${i}">${i}</a>
				</c:forEach>
			</td>
		</tr>
	</table>

</body>
</html>