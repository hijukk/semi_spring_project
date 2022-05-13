<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<link rel="stylesheet" href="resources/css/menu.css">
<link rel="stylesheet" href="resources/css/list.css">
<link rel="stylesheet" href="resources/css/button.css?after"">
<link rel="stylesheet" href="resources/css/form.css">
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("onload");
	});
</script>
</head>
<body>
	<script>
	function tUpdate(){
		alert("게시글 수정이 완료되었습니다.");
	}
	</script>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>맛집 게시글 수정</h2>
	<!-- 안적으면 get 방식(기본) -->
	<form action="updateOK.do" method="post" enctype="multipart/form-data" onsubmit="tUpdate();">

		<table border="1" id="boardList">
			<tr>
				<th>attraction</th>
				<td><input type="hidden" name="attraction"
					value="${vo2.attraction}">${vo2.attraction}</td>
			</tr>
			<tr>
				<th>location</th>
				<td><input type="text" name="location" value="${vo2.location}"></td>
			</tr>
			<tr>
				<th>content</th>
				<td><textarea rows="10" cols="30" name="content">${vo2.content}</textarea></td>
			</tr>
			<tr>
				<th>tdate</th>
				<td>날짜<br> <input type='checkbox' name='tdate' value='1월'>1월
					<input type='checkbox' name='tdate' value='2월'>2월 <input
					type='checkbox' name='tdate' value='3월'>3월 <input
					type='checkbox' name='tdate' value='4월'>4월 <input
					type='checkbox' name='tdate' value='5월'>5월 <input
					type='checkbox' name='tdate' value='6월'>6월 <br> <input
					type='checkbox' name='tdate' value='7월'>7월 <input
					type='checkbox' name='tdate' value='8월'>8월 <input
					type='checkbox' name='tdate' value='9월'>9월 <input
					type='checkbox' name='tdate' value='10월'>10월 <input
					type='checkbox' name='tdate' value='11월'>11월 <input
					type='checkbox' name='tdate' value='12월'>12월
				</td>
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