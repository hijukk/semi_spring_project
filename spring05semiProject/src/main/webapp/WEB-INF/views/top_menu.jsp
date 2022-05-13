<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		console.log("onload");
		$("#login").on("submit", function() {
			console.log("submit");
			console.log($("#logid").val());
			var flag = false;
			
			$.ajax({
				data : {
					id : $('#logid').val()
				},
				url : 'json_idCheck.do',
				dataType : 'json',
				type : 'GET',
				//async: false 옵션을 추가하여 flag에 값이 제대로 반영
				async: false,
				success : function(responseData) {
					console.log('success');
					console.log(responseData);

					if ($('#logid').val() === responseData.id) {
						flag = true;
					} else if (responseData.id == null) {
						alert("존재하지 않는 회원입니다");
						flag = false;
					}

				}
			});//success

			return flag;

		});//end login

	});
</script>

<ul>
	<li><a href="index.do" class="active">index.do</a></li>
	<li><a href="insert.do" id="btn_insert">여행지 추천 글쓰기</a></li>
	<li><a href="selectAll.do">여행지 추천</a></li>
	<li><a href="mySelectAll.do" id="btn_mySelect">내 찜리스트</a></li>
	<li><a href="rInsert.do">후기 글쓰기</a></li>
	<li><a href="rSelectAll.do">후기 게시판</a></li>
	<c:if test="${session_id==null}">
		<li><a href="jInsert.do">회원가입</a></li>
		<li><form action="loginOK.do" id="login" method="post">
				<input type="text" name="id" id="logid" size=10 value="hiju"> 
				<input type="password" name="pw" size=10 value="hi123456"> 
				<input type="submit" value="로그인">
			</form></li>
	</c:if>
	<c:if test="${session_id!=null}">
		<li><a href="logout.do">${session_id}님 로그인 중</a></li>
		<li><a href="jSelectAll.do">회원정보 보기</a></li>
	</c:if>
</ul>
