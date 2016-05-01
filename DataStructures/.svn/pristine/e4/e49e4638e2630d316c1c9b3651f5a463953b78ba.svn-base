<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<!-- <style type="text/css">
	.bordered {height: 700px; overflow-y: auto;}
	h2 {text-align:center;}
	#cadidateMiddiv {clear: both;}
	#candidateBottomDiv {cursor: pointer; background-color: #cecece; border-radius:5px; float:left; clear: right; padding: 3px 5px;}
	#divOne,#divTwo {text-align:left; float:left; clear: right;}
</style> -->
<script>
$(document).ready(function() {
	searchTeamProject($( "#tm_name" ).val());
});

$('#tm_name').change(function() {    
	searchTeamProject($( "#tm_name" ).val());
});  
</script>
<style type="text/css">
	#teamSearch table {width:100%; }
</style>
</head>
<body>
	<!-- Search form -->
	<div id="teamSearch" >
		<table>
			<tr>
				<th style="text-align: center;">팀 명</th>
				<td>
					<select id="tm_name" name="tm_name" title="팀명"style="width:100%; border: none;">
						<c:forEach var="candidateTest" items="${searchTeamList}">
							<option value="${candidateTest.tm_id}">
								${candidateTest.tm_name}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
