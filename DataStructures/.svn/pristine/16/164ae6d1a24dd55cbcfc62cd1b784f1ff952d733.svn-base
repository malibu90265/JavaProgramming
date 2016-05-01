<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>월별 대기 조회</title>

<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/waitingList_css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/waitingList/waitingList.js"/>"></script>
	
<script type="text/javascript">
	$(document).ready(function() {
		
		// 기본 출력 : 헤더, 검색, 리스트
		getMiniHeaderAjax();
		getwaitingListSearchForm();
		
		// 1~12월
		//getwaitingListJanuaryToDecember();
		
		// 해당 년도
		var thisDate = new Date();
		var currentYear = thisDate.getFullYear();
		$(".contentsTitle").text(currentYear+" 월 별 대기/예정자 조회");
		
		getwaitingListSearchAction(thisDate.getMonth() + 1, thisDate.getMonth() + 1);
		
	});
</script>
<style type="text/css">
	#waitingListSearchForm {width:28%; font-size: 1.5vh; font-size: 1.5vm;}
</style>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader"></div>
	
	<div style="clear: both;"></div>
	
	<div class="container">
		<div class="contents">
			<table id="topTableName">
				<tr>
					<th class="contentsTitle"></th>
				</tr>
			</table>
				<!-- 검색 -->
				<div id="waitingListSearchForm" class="search"></div>
				
				<div style="clear: inherit;"></div>
				
				<!-- 팀별 인력 List -->
				<div id="coverwaitingList">
					<div id="waitingListJanuaryToDecember" class="bordered" ></div>
				</div>
			<div style="clear: both"></div>
		</div>
	</div>

</body>
</html>