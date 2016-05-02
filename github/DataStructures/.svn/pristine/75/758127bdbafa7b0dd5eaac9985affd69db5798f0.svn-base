<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- template -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 여기까지 Template-->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="/resources/images/ico_bz.ico" />
<link rel="stylesheet" href="/resources/css/login_css/style.css">

<!-- Bootstrap core CSS -->
<link href="/resources/css/login_css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/css/login_css/ie-emulation-modes-warning.js"></script>

<!-- Custom styles for this template -->
<link href="/resources/css/login_css/carousel.css" rel="stylesheet">

<title>IQSbz</title>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.js"/>'></script>
<script type="text/javascript">
	function init() {
		// 비번 자동완성 끄기
		var fields = document.querySelectorAll('input[type="password"]');
		for (var i = 0; i < fields.length; i++) {
			fields[i].autocomplete = "off";
		}
		var fieldsName = document.querySelectorAll('input[type="text"]');
		for (var i = 0; i < fieldsName.length; i++) {
			fieldsName[i].autocomplete = "off";
		}
	}

	// TODO 정보 불러오기
	$(document).ready(function() {

		//getProjectList();
		randomtip();

	});

	this.randomtip = function() {

		var pause = 3000; // define the pause for each tip (in milliseconds) 
		var length = $("#tips li").length;
		var temp = -1;

		this.getRan = function() {
			// get the random number
			var ran = Math.floor(Math.random() * length) + 1;
			return ran;
		};
		this.show = function() {
			var ran = getRan();
			// to avoid repeating
			while (ran == temp) {
				ran = getRan();
			}
			;
			temp = ran;
			$("#tips li").hide();
			$("#tips li:nth-child(" + ran + ")").fadeIn("fast");
		};

		show();
		setInterval(show, pause);

	};
</script>
</head>
<body>


	<ul id="tips">
			<li>SQI소프트의 영업관리 시스템 IQSbz</li>
			<li>정보, 손익 관리 시스템 입니다.</li>
	</ul>
	<div class="login">
		<div class="left-logo">
			<img class="img"  src="/resources/images/iqsbzlogonew.png">
		</div><!-- left-logo -->
		<div class="center-login">
		<div class="login_input">
			<form id="login-form" method="post" action="<c:url value="/login_main"/>">
				<h1>로 그 인</h1>
				<input type="text" placeholder="Email" name="email" id="email" autocomplete="off" /><span id="pMail"> @sqisoft.com</span>
				<div>
					<input type="password" placeholder="Password" name="password" id="password" autocomplete="off" />
				</div><!-- password-container -->
				<!-- 로그인 버튼 -->
				<button class="button submit" type="submit">로그인</button>
				<div style="color: red;">${message }</div>
			</form>
		</div><!-- login_input -->
		</div><!-- center-login -->
		<div class="rignt-date">
		<script language="JavaScript"> 
				var today = new Date( ) 
				document.write(today.getFullYear() , "년 " , 
		        today.getMonth( )+1 , "월 " , today.getDate( ) , "일 ");
		        var week = new Array('일', '월', '화', '수', '목', '금', '토');
				document.write(week[today.getDay()] + '요일' + '<br />');
		</script> 
		</div><!-- right-date -->
	</div><!-- login -->

<div style="clear: both;"></div>
<!-- 행사사진 -->
    <!-- Carousel
    ================================================== -->
 <div class="slider">
   <div id="myCarousel" class="carousel slide" data-ride="carousel">
     <!-- Indicators -->
     <!-- 동그라미7개 -->
     <ol class="carousel-indicators">
       <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
       <li data-target="#myCarousel" data-slide-to="1"></li>
       <li data-target="#myCarousel" data-slide-to="2"></li>
     </ol>
     
     <!-- 행사사진7장 -->
     <div class="carousel-inner" role="listbox">
       <div class="item active">
         <img src="/admin/download/1" alt="First slide">
         <div class="container">
           <div class="carousel-caption">
           </div>
         </div>
       </div>
       <div class="item">
         <img src="/admin/download/2" alt="Second slide">
         <div class="container">
           <div class="carousel-caption">
           </div>
         </div>
       </div>
       <div class="item">
         <img src="/admin/download/3" alt="Third slide">
         <div class="container">
           <div class="carousel-caption">
           </div>
         </div>
       </div>
       
     </div>
     <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
       <span class="sr-only">Previous</span>
     </a>
     <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
       <span class="sr-only">Next</span>
     </a>
   </div><!-- /.carousel -->
   <div class="footer">
	<img width="250" src="/resources/images/sqisoftlogo.png">
</div>
</div><!-- slider -->

 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="/resources/css/login_css/bootstrap.min.js"></script>
    <script src="/resources/css/login_css/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/resources/css/login_css/ie10-viewport-bug-workaround.js"></script>
</body>
</html>