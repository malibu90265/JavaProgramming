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
		<link rel="stylesheet" type="text/css" href="/resources/css/main_css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/main_css/bottom-area.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/main_css/standardform.css" />

	<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/admin/dragDrop.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/admin/mymenuHeader.js"/>'></script>
	<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			getLoginHeaderAjax();
			
			getMyMenuHeaderAjax();
			
			getMenuListPage();
			
			getChangePasswordPageAjax();
			
			getGagePage();
			
			
		});
		
		 
		
	</script>
	


	<style type="text/css">
		#noticeSection {width:9%; margin-left:7%; margin-top:8%; text-align:left; font-size:4.5vh; font-size:4.5vm; font-weight: bold; color:#adadad; float: left; clear: right;}
		#bodyDiv {width:73%; float: left; clear: right;}
	</style>
	</head>
	<body>
		<div class="container" >
			<!-- Top Navigation : 로그아웃/로고/비번 변경 -->
			<div id="loginHeaderDiv">
			
			</div>
			<div style="clear:both;"></div>
			
			<!-- 상단 (로고 + 즐겨찾기 + 쓰레기통) -->
			<div id="mymenuHeader">
			</div>
			<div style="clear:both;"></div>
			
			<!-- 왼쪽 글 -->
			<div id="noticeSection">BZ<br/>MENU</div>
			<!-- 메뉴 -->
			<div id="bodyDiv">
			<!-- 알림창 -->
				<div class="noticeDiv">
					<span id="sss">[ 금액 단위 : 천 원 ]</span><span>&nbsp;&nbsp;모든 페이지의 원화 금액 단위는 천원 입니다.</span> <br/>
				</div>
				<!-- 중간 메뉴 -->
				<div class="content">
				</div><!-- /content -->
				
			</div>
			<div style="clear:both;"></div>
			<div id="gage" class="bottom"></div>
		</div><!-- /container -->
		
		
	</body>
	
	<!-- 비밀번호 변경 팝업 -->
	<div id="changePasswordDiv">
	</div>
</html>