<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table class="search">
		<tr>
			<th>팀명</th>
			<td>
				<select name="tm_id" id="tm_id" onchange="selectChangeFunction();"> 
					<c:forEach var="team" items="${teamList}">
						<option value="${team.tm_id}">${team.tm_name}</option>
					</c:forEach>
				</select>
			</td>
			<th id="allTeamPriceBtn">전체조회</th>
		</tr>
	</table>
</body>
</html>
