<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script type="text/javascript" src="resources/js/jquery-3.6.0.min.js"></script>
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
			// 				error : function(jqXHR, textStatus, errorThrown) {
			// 					alert("ajax error : " + textStatus + "\n" + errorThrown);
			// 					rtn = false;
			// 				}
			});

			return flag;

		});//end login

	});
</script>
</head>
<body>
	<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<!-- <link rel="icon" href="http://bootstrapk.com/favicon.ico"> -->

<title>Index</title>

<!-- Bootstrap core CSS -->
<link href="http://bootstrapk.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="http://bootstrapk.com/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Custom styles for this template -->
<link href="http://bootstrapk.com/examples/carousel/carousel.css"
	rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#" id="session_id">${session_id}님
							안녕하세요</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.do">Index</a></li>
							<li class="dropdown_review"><a href="#"
								class="dropdown-toggle1" data-toggle="dropdown" role="button"
								aria-expanded="false">여행 <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="insert.do" id="btn_insert">여행지 추천 글쓰기</a></li>
									<li><a href="selectAll.do">여행지 추천</a></li>
									<li><a href="mySelectAll.do" id="btn_mySelect">내 찜리스트</a></li>
								</ul></li>
							<li class="dropdown_review"><a href="#"
								class="dropdown-toggle2" data-toggle="dropdown" role="button"
								aria-expanded="false">맛집 <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="rInsert.do">후기 글쓰기</a></li>
									<li><a href="rSelectAll.do">후기 게시판</a></li>
								</ul></li>
							<c:if test="${session_id==null}">
								<li><a href="jInsert.do">회원가입</a></li>
								<li><form id="login" action="loginOK.do" method="post">
										<input type="text" name="id" id="logid" size=10 value="hiju">
										<input type="password" name="pw" size=10 value="hi123456">
										<input type="submit" value="로그인">
									</form></li>
							</c:if>
							<c:if test="${session_id!=null}">
								<li><a href="logout.do">로그아웃</a></li>
								<li><a href="jSelectAll.do">회원정보 보기</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>


	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide" src="resources/img/경주.jpg"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>경주</h1>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide" src="resources/img/구례.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>구례</h1>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="resources/img/대관령.jpg"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>대관령</h1>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->
	<br>
	<br>
	<br>
	<br>

	<!-- FOOTER -->
	<footer>
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>
		<p>
			&copy; 2022 HeejuKo. &middot; <a href="#">Privacy</a> &middot; <a
				href="#">Terms</a>
		</p>
	</footer>

	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="http://bootstrapk.com/dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="http://bootstrapk.com/assets/js/vendor/holder.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="http://bootstrapk.com/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>


</body>
</html>