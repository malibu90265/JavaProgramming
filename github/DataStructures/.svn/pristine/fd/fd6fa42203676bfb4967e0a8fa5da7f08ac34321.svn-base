<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script>
$(document).ready(function() {
	getUndecidedList($( "#tm_name" ).val());
});


$('#tm_name').change(function() {    
	//alert($( "#tm_name" ).val());
	getUndecidedList($( "#tm_name" ).val());
	$("#undecidedModifyForm").empty();
});  
</script>
</head>
<body>
	
	<!-- Search form -->
	<div id="searchteam" style="width:100%"><!-- width:300px; -->
		<table>
			<tr>
				<th style="text-align: center">팀 명</th>
				<td>
					<select id="tm_name" name="tm_name" title="팀명"  style="width:100%; border: 0; text-align: center;" 
							>
						<c:forEach var="teams" items="${teams}">
							<option value="${teams.tm_id}">
								${teams.tm_name}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>