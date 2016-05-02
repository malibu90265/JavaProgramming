<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/team_css/total-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script type="text/javascript" src="<c:url value="/resources/js/total/projectBudgetInfo.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/total/progressbar.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/total/jquery-circle-progress/dist/circle-progress.js"/>"></script>

<title>팀별 손익정보</title>
<script type="text/javascript">
	$(document).ready(function() {
		getMiniHeaderAjax();
		getProjectBudgetInfoSearchFormAjax();
		
		//프로젝트 선택시 색깔 변경
		$("#projectBudgetInfoListForm").on("click", ".projectBudgetInfoRow",function() {
			$(".selected").removeClass("selected");
			$(this).addClass("selected");
		});
		
	});
</script>
</head>
<body>
	<div id="miniHeader"></div>
	
	<div class="container">
		<div class="contents">
			<h2 class="contentsTitle">팀별손익정보</h2>
			<div id="projectBudgetInfoSearchForm"></div>
			<br>
			
		</div>
		
		<div style="clear:both;">&nbsp;&nbsp;</div>
		<div>
			<div id="projectBudgetInfoListForm"></div>
		</div>
	</div>
</body>
</html>