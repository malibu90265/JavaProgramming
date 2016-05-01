<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script>
$('#tm_name').change(function() {    
	searchEmployeeInput($( "#tm_name" ).val());
	$("#employeeInputDetailForm1").empty();
});  
</script>
<style type="text/css">
	#searchteam {width: 100%;}
</style>
</head>
<body>
	
	<!-- Search form -->
	<div id="searchteam">
		<table>
			<tr>
				<th style="text-align: right;">팀 명</th>
				<td>
					<select id="tm_name" name="tm_name" title="팀명" style="width:100%; border: 0;">
						<c:forEach var="employeeInput" items="${searchTeamList}">
							<option value="${employeeInput.tm_id}">
								${employeeInput.tm_name}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>