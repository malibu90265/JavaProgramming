<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MainPage</title>
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="resources/css/main_css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/main_css/demo.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/main_css/bottom-area.css" />
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.js"/>'></script>
	<script type="text/javascript">

	function allowDrop(ev) {
		ev.preventDefault();
	}
	
	var parentClassName = "";
	function drag(ev) {
		ev.dataTransfer.setData("text", ev.target.id);
		var data = ev.dataTransfer.getData("text");
		parentClassName = document.getElementById(data).parentNode.className;
	}

	// 개별 항목을 즐겨찾기(상단바)에 올립니다.
	function drop(ev) {
		ev.preventDefault();
		var data = ev.dataTransfer.getData("text");
		// 데이터가 있을 경우. target은 위치를 바라봄.
		if( ev.target.className == "grid__item") {
			alert("이미 데이터가 있습니다.");
		}
		else {
			var cloneData = document.getElementById(data).cloneNode(true);
			ev.target.appendChild(cloneData);
		}
	}
	
	// 즐겨찾기에 있는 데이터를 쓰레기통으로 넣습니다.
	function bookmarkDrop(ev) {
		if (parentClassName == "grid") {
				ev.preventDefault();
				alert("original data");
			}
		else {
				ev.preventDefault();
				var data = ev.dataTransfer.getData("text");
				if( document.getElementById(data).parentNode.className == "drop-area__item") {
					alert(document.getElementById(data).parentNode.className 
							+"\n"+ document.getElementById(data).lastChild);
					ev.target.appendChild(document.getElementById(data));
					ev.target.removeChild(document.getElementById(data));
					alert("클론만 지운다고!!!");
				}
				else {
					alert(document.body.childNodes);
					/* alert(ev.currentTarget.className +"\n"+ ev.target.localName +"\n"+ ev.target.nodeName
							 +"\n"+ ev.target.appendChild(document.getElementById(data))); */
					alert("클론 아니라고~~!!!");
				}
			}
		}
	</script>

</head>
<body>
<!-- ************************************ 
	error 1: 휴지통 : main_script.jsp
	toDo: 색 입히기  : main.jsp
	************************************* -->
		<div class="container" >
			<!-- Top Navigation : 로그인 -->
			<div class="codrops-top clearfix">
				<span class="right">
					<a class="codrops-icon codrops-icon-drop" href="####">
						<span><i class="fa fa-sign-in"></i> 로그인</span>
					</a>
				</span>
			</div>
			<div style="clear:both;"></div>
			<!-- 상단 (로고 + 즐겨찾기 + 쓰레기통) -->
			<div class="drop-area" >
				<div class="logo__item">
					<a href="###">
						<img class="logo_img" src="/resources/images/sqisoftlogo.png" alt="Dual-View Slideshow Image"/>
					</a>
				</div>
				<div class="drop-area__item" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
				<div class="drop-area__item" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
				<div class="drop-area__item" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
				<div class="drop-area__item" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
				<div class="drop-area__item" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
				<div class="drop-area__item" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
				<div class="drop-area__item_trash_can" ondrop="bookmarkDrop(event)" ondragover="allowDrop(event)"><i class="fa fa-fw fa-trash"></i></div>
			</div><!-- drop-area -->
			<div style="clear:both;"></div>
			
			<div class="content">
				<!-- 중간 메뉴 -->
				<div id="grid" class="grid">
				<c:forEach var="i" begin="1" end="26">
					<div class="grid">
						<div class="grid__item" id="dragText${i }" draggable="true" ondragstart="drag(event)" >dragText<br/><p>${i }</p></div>
					</div>
					<c:if test="${i % 8 == 0 }">
						<div style="clear: both;"></div>
					</c:if>
				</c:forEach>
				</div>
				<div style="clear: both;"></div>
				
				<!-- 바닥 -->
				<div id="bottom">
					<section class="related">
						<p>서울시 영등포구 경인로 775 (문래동3가) 에이스하이테크시티 1동 803호</p>
						<p>TEL : 02-2109-1900 / FAX : 02-2109-1999 / MAIL : webmaster@sqisoft.com</p>
						<p>Copyright ⓒ 1999~2014 SQISOFT ALL RIGHTS RESERVED.</p>
					</section>
				</div>
			</div><!-- /content -->
		</div><!-- /container -->
	</body>
</html>