<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>월 별 투입 map</title>
<link rel="shortcut icon" href="../favicon.ico">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/waitingList_css/deloyMapCommon.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/deployMap/monthlyDeployMap.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		// 기본 출력 : 헤더, 검색, 리스트
		getMiniHeaderAjax();
		getWatingListSearchForm();
		
		// 월별 투입 맵
		emp_map();
		
	});
</script>
<style type="text/css">
	.search {width:60%;} /* width:900px; */
	#standByInfo {width: 90%; height: 70vh; height: 70vm;}
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
					<th class="contentsTitle">월 별 투입 MAP</th>
				</tr>
			</table>
				<!-- 검색 -->
			<div id="monthlyDeployMapSearchForm" class="search"></div>
			
			<div style="clear: inherit;"></div>
			
			<!-- 팀별 인력 List -->
			<div id="standByInfo" class="bordered"></div>

		</div>
				
		<div style="clear: both"></div>
	</div>
</body>

</html>