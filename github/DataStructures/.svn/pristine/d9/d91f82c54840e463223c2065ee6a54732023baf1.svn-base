<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>배치대상자 검색</title>
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/candidate_css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/demo.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/candidateRequirements/candidateRequirements.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	getMiniHeaderAjax();
	selectTeam();
	searchTeamProject("1S15");		
	getCandidateDetailForm(); //인력 소요 List
	getCandidateSearchForm(); // 검색 form
	
	var pjId;
	
	$("#candidateDiv").on("click", ".candidateRow", function() {
		pjId = $(this).children().eq(0).text();
		getCandidateDetailForm(pjId);
		
		$(".selected").removeClass("selected");
		$(this).addClass("selected");
		
	});
	
	var pr_sq;
	
	$("#candidateDetailForm").on("click", ".candidateDetailRow", function() {
		
		$("#pr_sq").val($(this).children().eq(0).text());
		pr_sq = $(this).children().eq(0).text();
		$("#pr_grade").val($(this).children().eq(1).text());
		$("#pr_job_skill").val($(this).children().eq(2).text());
		$("#pr_start_date").val($(this).children().eq(3).text());
		$("#pr_end_date").val($(this).children().eq(4).text());
		$("#pj_loc").val($(this).children().eq(5).text());
		
		$(".selected2").removeClass("selected2");
		$(this).addClass("selected2");
		
		var grade = $(this).children().eq(1).text();
		$("#candidateSearchForm").css("display","");
		getCandidateSearchForm();
		
	});
	
	$('#candidateSearchForm').on("click", ".candidateSearchResultRow", function() {
		var hr_name = $(this).children().eq(0).text();
		
		if(confirm(hr_name+"을 배치하시겠습니까?"))
			insertRequireOnCandidate(pjId, pr_sq, hr_name);
	});
	
});
</script>
<style type="text/css">
	#teamSearch { width: 100%; }
	#candidateSearchForm {border: none; box-shadow:none;}
	.leftContents, .centerContents, .rightContents {font-size: 1.5vh; font-size: 1.5vm;}
</style>
</head>
<body>
	<div id="miniHeader"></div>
	<div style="clear: both;"></div>
	
	<div class="container">
		<div class="contents">
			<table id="topTableName">
				<tr>
					<th class="contentsTitle">배치 대상자 검색</th>
				</tr>
			</table>
			
			<div style="clear: both;"></div>
			<!-- 이전 버튼 : 인력 미결현황 -->
			<a id="preEmployInfoAtag" href="<c:url value="/humanResource/undecided"/>">
				<div id="preEmployInfo" >
					<div id="insidePreEmployInfo">인력<br/>미결현황</div>
				</div>
			</a>
			<div style="clear: inherit;"></div>
		
			<!-- Search form -->
			<div class="leftContents">
				<div id="teamSearch" class="search" ></div> 
				<!-- Project List -->
				<div id="candidateDiv" ></div>
			</div>
			<div style="clear: right;"></div>

			<!-- 인력 소요 List  -->
			<div class="centerContents">
				<div id="candidateDetailForm" ></div>
			</div>
			<div style="clear: right;"></div>
 			
			<div class="rightContents">	
				<!-- 대상자 검색 조건 -->	
				<div id="candidateSearchForm" ></div>	
				<!-- 대상자 검색 결과 List -->
				<div id="candidateSearchResultForm" ></div>
			</div>
			
			<div style="clear: inherit;"></div>
			<!-- 이전 버튼 : 투입관리 -->
			<a id="afterEmployInfoAtag" href="<c:url value="/employeeInput/employeeInput"/>">
				<div id="afterEmployInfo" >
					<div id="insideAfterEmployInfo">투입관리</div>
				</div>
			</a>
			<div style="clear: both;"></div>
		
		</div><!-- contents -->
	</div><!-- container -->
</body>
</html>