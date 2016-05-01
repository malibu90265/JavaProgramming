<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script>
$(document).ready(function() {
	searchDeployRequirements($( "#tm_name" ).val());
	
});

$('#tm_name').change(function() {    
	//alert($( "#tm_name" ).val());
	searchDeployRequirements($( "#tm_name" ).val());
	$("#deployRequirementsForm").empty();
});  
</script>
<style type="text/css">
	#searchteam {width: 100%;}
	#tm_name {width:100%; border: 0;}
</style>
</head>
<body>
	
	<!-- Search form -->
	<div id="searchteam">
		<table>
			<tr>
				<th style="text-align: center;">팀 명</th>
				<td>
					<select id="tm_name" name="tm_name" title="팀명" >
						<c:forEach var="deployRequirement" items="${searchTeamList}">
							<option value="${deployRequirement.tm_id}">
								${deployRequirement.tm_name}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>