<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>배치 관리</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/test/demoDeployManagement.js"/>"></script>
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			getDeployManagementList(); //프로젝트 List
			
			getDeployManagementSearchForm(); //인력 배치 관리 검색
			
			getDeployManagementDetailForm(); //인력 배치 내역
			
			
			$("#deployManagementDiv").on("click", ".deployManagementRow", function(){
				var pjId = $(this).children().eq(1).text(); 
				
				getDeployManagementDetailForm(pjId);
			});
			 
			
			
		});
	</script>
</head>
<body>
	
	<h3>배치 관리</h3>
	
	
	<!-- Project List -->
	<div id="deployManagementDiv"style="padding-top: 50px;">
	
	</div>
	
	<!-- 인력 배치 관리(검색) -->
	<div id="deployManagementSearchForm" style="float: left; padding-left: 200px">
	
	</div>
	
	<div id="deployManagementDetailForm" style="float: left; padding-left: 200px">
	</div>

	
	<div style="clear: both"></div>
</body>
</html>