<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
	// 소요인원수 집어넣을 것.
	var requirePerson = "0";
	$(document).ready(function() {
		
		//getDeployRequirementsConditionsAjax(requirePerson);
		
	});
</script>
</head>
<body>
	
	<div>
		<table>
			<tr>
				<th>프로젝트ID</th>
				<td id="pj_id">${budgetVO.pj_id}</td>
			</tr>
			<tr>
				<th>프로젝트 기간</th>
				<td>[${budgetVO.pj_start_day}] - [${budgetVO.pj_end_day}]</td>
			</tr>
			<tr>
				<th>기반분류</th>
				<td>${budgetVO.pj_require}</td>
			</tr>
			<tr>
				<th>소요인원수</th>
				<td>${budgetVO.pn_num}</td>
			</tr>
		</table>
	</div>
	
	<div id="deployRequirementsConditions">
		
	</div>
		
	<div style="text-align: right;">
		<span id="deployRequirementsModifyBtn" style="cursor: pointer;">수정</span>
		<span id="deployRequirementsDeleteBtn" style="cursor: pointer;">삭제</span>
		<span id="deployRequirementsResetBtn" style="cursor: pointer;">처음으로</span> 
	</div>
	
</body>
</html>