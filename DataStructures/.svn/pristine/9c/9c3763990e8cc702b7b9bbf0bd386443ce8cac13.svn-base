<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
	// 소요인원수 집어넣을 것.
	var pjId = ${deployRequirements.pjId };
	
	$(document).ready(function() {
		
		getDemoDeployRequirementsConditionsDetailAjax(pjId);
		
	});
</script>
</head>
<body>
	
	<div>
		<table>
			<tr>
				<th>상태</th>
				<td>${deployRequirements.pjStatus }</td>
			</tr>
			<tr>
				<th>프로젝트ID</th>
				<td id="pjId">${deployRequirements.pjId }</td>
			</tr>
			<tr>
				<th>프로젝트기간</th>
				<td>
					프로젝트기간
				</td>
			</tr>
			<tr>
				<th>기반분류</th>
				<td>
					기반분류
				</td>
			</tr>
			<tr>
				<th>소요인원수</th>
				<td>
					${deployRequirements.pjDeployRequirements }
				</td>
			</tr>
			<tr>
				<th>배치인원수</th>
				<td>
					배치인원수
				</td>
			</tr>
			<tr>
				<th>투입인원수</th>
				<td>
					투입인원수
				</td>
			</tr>
		</table>
	</div>
	
	<div id="deployRequirementsConditions">
		
	</div>
		
	<div id="bottomLine" style="text-align: right;">
		<span id="deployRequirementsModifyBtn">수정</span>
		<span id="deployRequirementsDeleteBtn">삭제</span>
		<span id="deployRequirementsResetBtn">처음으로</span> 
	</div>
	
</body>
</html>