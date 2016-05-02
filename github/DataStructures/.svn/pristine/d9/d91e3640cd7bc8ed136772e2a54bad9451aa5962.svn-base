<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>인력 미결 현황</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/bottom-area.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/undecided/standardform.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/humanResource/undecided/undecided.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vaildCheck.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	var pj_id;
	var num;
	
	getMiniHeaderAjax();
	selectTeam();
	
	$("#undecidedListForm").on("click", ".UndecidedRow", function() {
		pj_id = $(this).children().eq(0).text();
		num = $(this).children().eq(2).text();
		$(".selected").removeClass("selected");
		$(this).addClass("selected");
		getUndecidedModifyForm(pj_id);
	});
	
	$("#undecidedModifyForm").on("click", "#undecidedSaveBtn", function() {
		if(confirm("정말 인사발령을 하시겠습니까?")) {
		for(var i = 1; i <= num; i++) {
			var isDeploy0 = $('#isDeploy' + i).text();
			var pr_name = $("#pr_name" + i).text();
			if(isDeploy0.trim() == '' && pr_name.trim() != "") {
				var pr_sq = $("#pr_sq" + i).text();
				var pr_start_date = $("#pr_date" + i).text().split('~')[0];
				var pr_end_date = $("#pr_date" + i).text().split('~')[1];
				var pr_uprice = $("#pr_uprice" + i).text().replace(",", "");
				var pr_name = $("#pr_name" + i).text();
				
				insertUndecided(pj_id, pr_sq, pr_start_date, pr_end_date, pr_uprice, pr_name);
			}
		}
		alert("투입완료하였습니다");
		getUndecidedList($("#tm_name").val());
		getUndecidedModifyForm(pj_id);
		}
	});
});
</script>
<style type="text/css">
	.search {width:70%; font-size: 1.5vh; font-size: 1.5vm;}
	#undecidedModifyForm {width:100%; height:67vh; height:67vm; font-size: 1.5vh; font-size: 1.5vm;} /* width:870px; */
	#undecidedListForm {width:100%; height:70vh; height:70vm; font-size: 1.5vh; font-size: 1.5vm; border: none;}
</style>
</head>
<body>

	<!-- header -->
	<div id="miniHeader"></div>
	<div style="clear: right;"></div>
	
	<div class="container">
		<table id="topTableName">
			<tr>
				<th><p id="topTableP">인력 미결 현황</p></th>
			</tr>
		</table>
		
		<div style="clear: both;"></div>
		<!-- 이전 버튼 : 배치 소요관리 -->
			<a id="preEmployInfoAtag" href="<c:url value="/deployRequirements/deployRequirements"/>">
				<div id="preEmployInfo" >
					<div id="insidePreEmployInfo">배치<br/>소요관리</div>
				</div>
			</a>
		<div style="clear: inherit;"></div>
		
		<div class="leftContents">
			<!-- Search form -->
		 	<div id="undecidedSearchForm" class="search" ></div> 
		 	
			<!-- List -->
			<div id="undecidedListForm" style="clear: both"></div>
		</div>
		
		<div style="clear: inherit;"></div>
		
		<div class="rightContents">
			<!-- 프로젝트 정보 및 소요인원 입력 화면 -->
			<div id="undecidedModifyForm"  ></div>
		</div>
		
		<div style="clear: inherit;"></div>
		<!-- 이전 버튼 : 배치대상자 -->
			<a id="afterEmployInfoAtag" href="<c:url value="/candidateSearch"/>">
				<div id="afterEmployInfo" >
					<div id="insideAfterEmployInfo">배치<br/>대상자</div>
				</div>
			</a>
		<div style="clear: both;"></div>
	</div>
</body>
</html>


