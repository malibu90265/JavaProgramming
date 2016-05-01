<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form id="project_settingSearchForm" name="project_settingSearchForm" method="post">
		<table class="search">
			<tr>
				<th>팀명</th>
				<td>
					<select id="tm_id_select" name="tm_id" onchange="selectChangeFunction();">
						<c:forEach var="team" items="${teamList}">
									<option id="${team.tm_id}">${team.tm_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>