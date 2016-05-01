<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/resources/js/deployRequirements/deployRequirements.js"/>"></script>
<style type="text/css">
	#bottomLine {margin-top:1.2%; border-top:none; text-align: right;}
	th {text-align: center;}
	#undeciededModifyTableForm {border-bottom:1px #cecece solid;}
</style>
</head>
<body>
	<div class="inputbordered" style="width:100%; height:100%; overflow-y: scroll;"><!-- max-height: 600px; -->
	<table id="undeciededModifyTableForm">
		<tr>
			<th style="width:6%;">소요 번호</th>
			<th style="width:8%;">등급</th>
			<th style="width:7%;">직무기술</th>
			<th style="width:19%;">기간</th>
			<th style="width:5%;">단가</th>
			<th style="width:10%;">배치<br/>예정자</th>
			<th style="width:10%;">투입여부</th>
			<th style="width:10%;">거주지</th>
		</tr>
		<c:forEach var="deployList" items="${deployList }" varStatus="i">
			<tr>
				<td id="pr_sq${i.count }" style="text-align: center;">${deployList.pr_sq }</td>
				<td id="pr_grade${i.count }" style="text-align: center;">${deployList.pr_grade }</td>
				<td id="pr_job_skill${i.count }" style="text-align: center;">${deployList.pr_job_skill }</td>
				<td id="pr_date${i.count }" style="text-align: center;">${deployList.pr_start_date }~<br/>${deployList.pr_end_date }</td>
				<td id="pr_uprice${i.count }" style="text-align: right;"><fmt:formatNumber>${deployList.pr_uprice }</fmt:formatNumber></td>
				<td id="pr_name${i.count }" style="text-align: center;">${deployList.pr_name }</td>
				<td id="isDeploy${i.count }" style="text-align: center;">${deployList.pd_name }</td>
				<td id="hr_residence${i.count }" style="text-align: center;">${deployList.hr_residence }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine">
				<span id="undecidedSaveBtn" style="cursor: pointer;">인사발령(투입처리)</span> 
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
</html>