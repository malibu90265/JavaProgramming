<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form id="projectSearchForm" name="projectSearchForm" method="post">
		<table class="search">
			<tr>
				<th>팀명</th>
				<td>
				<select id="tm_id_select" name="tm_id" onchange="selectChangeFunction();">
						<c:forEach var="team" items="${teamList }" varStatus="status">
							<c:choose>
								<c:when test="${status.first}">
									<option id="${team.tm_id }" selected="selected">${team.tm_name }</option>
								</c:when>
								<c:otherwise>
									<option id="${team.tm_id }">${team.tm_name }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					
					
				</td>
				<th>상태</th>
				<td>
					<select id="pj_status_select" name="pj_status" onchange="selectChangeFunction();">
						<option id="0">전체</option>
						<c:forEach var="key" items="${pjStatusMap.keySet()}">
							<option id="${key }">${pjStatusMap.get(key) }</option>
						</c:forEach>
					</select>
				</td>
				<th>수정일</th>
				<td>
					<select id="pj_modify_select" name="pj_modify" onchange="selectChangeFunction();">
						<option id="0">해당없음</option>
						<option id="1">1주일</option>
						<option id="2">2주일</option>
						<option id="3">1달</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>