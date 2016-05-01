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
		
		$("   ").keyup(function(){
			
			var requirePerson = $(" ").val();
			
			getDeployRequirementsConditionsAjax(requirePerson);
			
		});
		
	});
</script>
</head>
<body>
	
	<div>
		<form:form commandName="candidateSelectSearchForm" id="candidateSelectSearchForm" name="candidateSelectSearchForm" method="post">
		<span>대상자검색</span>
		<table>
			<tr>
				<th>검색조건</th>
				<th>일자</th>
				<th>직원/외주</th>
				<th>기술</th>
				<th>등급</th>
				<th>거주지</th>
			</tr>
			<tr>
				<td>우선순위</td>
				<!-- <select>
					<td><option>1</option></td>
					<td><option>2</option></td>
					<td><option>3</option></td>
					<td><option>4</option></td>
					<td><option>5</option></td>
				</select> -->
			</tr>
		</table>
		
		<div id="candidateSearchDetailForm">

		</div>


		</form:form>
	</div>

	
</body>
</html>