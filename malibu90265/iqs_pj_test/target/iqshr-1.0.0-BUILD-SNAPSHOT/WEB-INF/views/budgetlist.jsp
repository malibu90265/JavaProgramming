<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project 재무정보 목록</title>

<style>
.container {
	position: relative;
}

nav.elem {
	position: absolute;
	left: 0px;
	width: 200px;
}

section {
	/* position is static by default */
	margin-left: 200px;
}

#topMenu {
	height: 30px;
	width: 850px;
}

#topMenu ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
}

#topMenu ul li {
	color: white;
	background-color: #2d2d2d;
	float: left;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
	position: relative;
}

.menuLink, .submenuLink {
	text-decoration: none;
	display: block;
	width: 150px;
	font-size: 12px;
	font-weight: bold;
	font-family: "Trebuchet MS", Dotum;
}

.menuLink { /* 상위 메뉴의 글씨색을 흰색으로 설정 */
	color: white;
}

.topMenuLi:hover .menuLink { /* 상위 메뉴의 li에 마우스오버 되었을 때 스타일 설정 */
	color: red; /* 글씨 색 빨간색 */
	background-color: #4d4d4d; /* 배경색을 밝은 회색으로 설정 */
}

.submenuLink { /* 하위 메뉴의 a 태그 스타일 설정 */
	color: #2d2d2d; /* 글씨 색을 RGB(2D2D2D)로 설정 */
	background-color: white; /* 배경색을 흰색으로 설정 */
	border: solid 1px black; /* 테두리를 설정 */
	margin-top: -1px; /* 위 칸의 하단 테두리와 아래칸의 상단 테두리가 겹쳐지도록 설덩 */
}

.longLink { /* 좀 더 긴 메뉴 스타일 설정 */
	width: 190px; /* 넓이는 190px로 설정 */
}

.submenu { /* 하위 메뉴 스타일 설정 */
	position: absolute; /* html의 flow에 영향을 미치지 않게 absolute 설정 */
	height: 0px; /* 초기 높이는 0px로 설정 */
	overflow: hidden; /* 실 내용이 높이보다 커지면 해당 내용 감춤 */
	transition: height .2s; /* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(기본) */
	-webkit-transition: height .2s;
	/* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 크롬/사파라ㅣ) */
	-moz-transition: height .2s;
	/* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 파폭) */
	-o-transition: height .2s;
	/* height를 변화 시켰을 때 0.2초간 변화 되도록 설정(구버전 오페라) */
}

.topMenuLi:hover .submenu { /* 상위 메뉴에 마우스 모버한 경우 그 안의 하위 메뉴 스타일 설정 */
	height: 155px;
}

.submenuLink:hover {
	color: red;
	background-color: #dddddd;
}

html, body {
	margin: 0px;
	padding: 0px;
	font-size: 12px;
}

#blog-header-container {
	position: fixed;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 75px;
	background-color: #fff;
}

#blog-header-container h1 {
	position: relative;
	left: 20px;
	font-size: 2.0em;
	font-weight: bold;
}

#menu-container {
	position: fixed;
	top: 60px;
	left: 0px;
	width: 100%;
	height: 45px;
	padding-left: 10px;
	padding-top: 8px;
	box-sizing: border-box;
	background-color: #2d2d2d;
	-webkit-transition: padding-left 200ms linear;
	-moz-transition: padding-left 200ms linear;
	-ms-transition: padding-left 200ms linear;
	-o-transition: padding-left 200ms linear;
	transition: padding-left 200ms linear;
}

#menu-container.fixed {
	padding-left: 70px;
	opacity: 0.95;
	-webkit-box-shadow: 0 1px 5px 1px rgba(0, 0, 0, 0.2);
	box-shadow: 0 1px 5px 1px rgba(0, 0, 0, 0.2);
}

#menu-container .menu-item {
	font-size: 1.4em;
	font-weight: bold;
	color: #fff;
}

#menu-container .menu-icon {
	display: block !important;
	position: absolute;
	left: -50px;
	top: 14px;
	font-size: 1.6em;
	font-weight: bold;
	color: #fff;
	-webkit-transition: left 300ms linear;
	-moz-transition: left 300ms linear;
	-ms-transition: left 300ms linear;
	-o-transition: left 300ms linear;
	transition: left 300ms linear;
}

#menu-container .menu-icon.on {
	left: 15px;
}

#blog-container {
	margin-top: 100px;
	padding: 20px;
}
</style>

<script type="text/javascript">
	function getBizMile(pj_id) {
		var formData = document.userForm;
		formData.action = "getBizMile.iqspf?pj_id=" + pj_id;
		formData.submit();
	}
	var currentScrollTop = 0;

	// 비동기식 jQuery이므로 window load 후 jQuery를 실행해야 함
	window.onload = function() {
		// 새로고침 했을 경우를 대비한 메소드 실행
		scrollController();

		// 스크롤을 하는 경우에만 실행됨
		$(window).on('scroll', function() {
			scrollController();
		});
	}

	// 메인 메뉴의 위치를 제어하는 함수
	function scrollController() {
		currentScrollTop = $(window).scrollTop();
		if (currentScrollTop < 150) {
			$('#blog-header-container').css('top', -(currentScrollTop));
			$('#menu-container').css('top', 150 - (currentScrollTop));
			if ($('#menu-container').hasClass('fixed')) {
				$('#menu-container').removeClass('fixed');
				$('#menu-container .menu-icon').removeClass('on');
			}
		} else {
			if (!$('#menu-container').hasClass('fixed')) {
				$('#blog-header-container').css('top', -150);
				$('#menu-container').css('top', 0);
				$('#menu-container').addClass('fixed');
				$('#menu-container .menu-icon').addClass('on');
			}
		}
	}
</script>
</head>
<body>
	<div id="blog-header-container">
		<h1>SQI 업무관리 시스템</h1>
	</div>
	<div id="menu-container">
		<div class="menu-icon" style="display: none;">SQI.</div>
		<div id="topMenu">
			<ul>
				<li class="topMenuLi"><a class="menuLink" href="iqspMain.iqspf">SQI soft</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="bizList.iqspf">프로젝트관리</a>
					<ul class="submenu">
						<li><a href="bizList.iqspf" class="submenuLink longLink">프로젝트
								현황표</a></li>
						<li><a href="insertproject.iqspf"
							class="submenuLink longLink">새 프로젝트 추가</a></li>
						<li><a href="teamList.iqspf" class="submenuLink longLink">팀
								정보</a></li>
						<li><a href="projectBudgetinfo.iqspf"
							class="submenuLink longLink">프로젝트 재무정보</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="totalChart.iqspf">손익현황</a>
					<ul class="submenu">
						<li><a href="totalChart.iqspf" class="submenuLink">손익추정 종합표</a></li>
						<li><a href="compareChart.iqspf" class="submenuLink ">전주대비표</a></li>
						<li><a href="#" class="submenuLink ">추세분석</a></li>

					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">기타 사항</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">추가 사항</a></li>
			</ul>
		</div>
	</div>
	<div id="blog-container">
		<span class="label"></span>

		<nav class="elem elem-red"> <span class="label"></span>
		<ul>
			<li><a href="budgetlist.iqspf">재무 정보</a></li>
			<li><a href="#">전주 대비표</a></li>
			<li><a href="#">추세 분석</a></li>
			<li><a href="#">연간 목표</a></li>
		</ul>
		<span class="endlabel"></span> </nav>

		<section class="elem elem-green">
		<p>
		<center>
			<h2>재무 정보</h2>
			<form name="userForm" method="post">

				<table border="1">
					<tr>
						<th>상&nbsp;&nbsp;태</th>
						<th>PJ&nbsp;&nbsp;명</th>
						<th>마일스톤</th>
						<th>시&nbsp;작&nbsp;일</th>
						<th>완&nbsp;료&nbsp;일</th>
						<th>계&nbsp;약&nbsp;액</th>
						<th>매&nbsp;출&nbsp;액</th>
						<th>순매출액</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="project">
						<tr>
							<td><a href='getProject.iqspf?pj_id=${project.pj_id}'>${project.pj_prog}</a></td>
							<td><a href='getMoney.iqspf?pj_id=${project.pj_id}'>
									${project.pj_name}</a></td>
							<td><input type="button"
								onclick="getBizMile('${project.pj_id}')"></td>
							<td><input type="text" size=3 name=pj_biz
								value="${project.pj_start_day}" /></td>
							<td><input type="text" size=3 name=pj_biz
								value="${project.pj_end_day}" /></td>
							<td><input type="text" size=3 name=pj_biz
								value="${project.budget_contract_sales_coma}" /></td>
							<td><input type="text" size=3 name=pj_biz
								value="${project.budget_sales_coma}" /></td>
							<td>${project.profit}</td>
						</tr>
					</c:forEach>
				</table>
				<input type="button" value="수정" onclick="budgetUpdate()" />
				&nbsp;&nbsp;
			</form>
		</center>
	</div>




</body>
</html>





