<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>소요배치</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/test/demoDeployRequirements.js"/>"></script>
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			getCandidateList(); //프로젝트 List
			
			getCandidateDetailForm(); //인력 소요 List
			
			getCandidateSearchForm(); //대상자 검색
			
			
			$("#candidateDiv").on("click", ".candidateRow", function(){
				var pjId = $(this).children().eq(1).text(); 
				
				getCandidateDetailForm(pjId);
			});
			 
			
			
		});
	</script>
</head>
<body>
	
	<h3>배치 대상자 검색</h3>
	
	
	<!-- Project List -->
	<div id="candidateDiv"style="padding-top: 50px;">
	
	</div>
	
	<!-- Candidate Detail Form -->
	<div id="candidateDetailForm" style="float: left; padding-left: 200px">
	
	</div>
	
	<div id="candidateSearchForm" style="float: left; padding-left: 200px">
	</div>
	
	<div id="candidateSearchDetailForm " style="float: left; padding-left: 200px">
	</div>
	
	
	<div style="clear: both"></div>
</body>
</html>