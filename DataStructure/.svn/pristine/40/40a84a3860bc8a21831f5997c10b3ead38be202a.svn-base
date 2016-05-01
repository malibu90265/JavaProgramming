<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
	// 소요인원수 집어넣을 것.
	var pjId = ${deployRequirements.pjId};
	
	$(document).ready(function() {
		
		getDemoDeployRequirementsConditionsModifyAjax(pjId);
		
		$("#requirePerson").keyup(function(){
			
			var requirePerson = $("#requirePerson").val();
			
			getDemoDeployRequirementsConditionsAjax(requirePerson);
			
		});
		
	});
</script>
</head>
<body>
	
	<div>
		<form:form commandName="deployRequirementsVO" id="deployRequirementsModifyForm" name="deployRequirementsModifyForm" method="post">
		<table>
			<tr>
				<th>상태</th>
				<td>
					<input type="text" name="pjStatus" value="${deployRequirements.pjStatus }"/>
				</td>
			</tr>
			<tr>
				<th>프로젝트ID</th>
				<td>
					<input type="text" id="pjId" name="pjId" readonly="readonly" value="${deployRequirements.pjId }"/>
				</td>
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
					<input type="text" id="requirePerson" name="pjDeployRequirements" value="${deployRequirements.pjDeployRequirements }">
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
		<div id="deployRequirementsConditions">
		
		</div>
		</form:form>
	</div>
	
	<div id="bottomLine" style="text-align: right;">
		<span id="deployRequirementsSaveBtn" style="cursor: pointer;">저장</span>
		<span id="deployRequirementsCancelBtn" style="cursor: pointer;">취소</span>
		<span id="deployRequirementsBackBtn" style="cursor: pointer;">되돌리기</span> 
	</div>
	
</body>
</html>