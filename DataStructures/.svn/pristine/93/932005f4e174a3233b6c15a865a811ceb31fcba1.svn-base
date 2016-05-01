<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인건비 확인</title>
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/costmap/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/demo.css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/humanResource/costmap/costmap.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/excelExport.js"/>"></script>

<script type="text/javascript">
	$(document).ready(function() {
		
		// 기본 출력 : 헤더, 검색, 리스트
		getMiniHeaderAjax();
		getCostmapSearchForm();
		
		//팀 검색
		$('#costmapSearchForm').on("change", "#tm_id", function() {
			var tm_id = $("#tm_id option:selected").val();
			getCostmapSearchTeamAjax(tm_id);
		});
		
		// excel
		$("#ExcelExport").click(function() {
			if($("#tm_id option:selected").val() != 0) {
				var d = new Date();
				var tm_name = $("#tm_id option:selected").text();
				
				var filename = d.getFullYear() + "년" + (d.getMonth() + 1) + "월" + d.getDate() + "일" + tm_name + " 직원&외주 배치";
				
				getExcel($("#costmapList > #laborExcel"), filename);
			}
		});
	});
</script>
<style type="text/css">
	#costmapSearchForm {width: 17%;}
	#costmapList {font-size:1.5vh; font-size:1.5vm; width: 100%; height: 60vh; height: 60vm; overflow: hidden;}
	#ExcelExport img {width: 18px; height: 18px}
</style>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader"></div>
	<div style="clear: inherit;"></div>
	
	<div class="container">
		<div class="contents">
			<table id="topTableName">
				<tr>
					<th><p id="contentsTitle">인건비 확인</p></th>
				</tr>
			</table>
			<!-- 검색 -->
			<div id="costmapSearchForm" class="search" ></div>
			<div style="clear: inherit;"></div>
			
			<!-- 팀별 인력 List -->
			<div style="width: 100%; text-align: right;">
				<button id="ExcelExport" value="Excel" style="background: transparent; border: none;">
					<img class="logo_img" src="/resources/images/Excel_2013_logo.png" />
				</button>
			</div>
			<div id="costmapList" class="bordered"></div>
			<div style="clear: inherit;"></div>
		</div><!-- contents -->
	</div><!-- container -->
</body>
</html>