<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		
		getDeployRequirementsConditionsAjax(0);
		
		$("#requirePerson").keyup(function(){
			
			var requirePerson = $("#requirePerson").val();
			
			getDeployRequirementsConditionsAjax(requirePerson);
			
		});
		
	});
</script>
</head>
<body>
	
	<div>
		<form:form id="deployRequirementsInsertForm" name="deployRequirementsInsertForm" method="post">
		<table>
			<tr>
				<th>프로젝트ID</th>
				<td>
				</td>
			</tr>
			<tr>
				<th>프로젝트 기간</th>
				<td>
				</td>
			</tr>
			<tr>
				<th>기반분류</th>
				<td>
				</td>
			</tr>
			<tr>
				<th>소요인원수</th>
				<td>
				</td>
			</tr>
		</table>
		</form:form>
	</div>
	
	<div id="deployRequirementsConditions">
		
	</div>
		
	<div style="text-align: right;">
		<span id="deployRequirementsInsertBtn" style="cursor: pointer;">추가</span> 
		<span id="deployRequirementsResetBtn" style="cursor: pointer;">초기화</span> 
	</div>
	
</body>
</html>