<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table>
		<tr>
			<th>인원번호</th>
			<th>등급</th>
			<th>전문기술</th>
			<th>요구기간</th>
		</tr>
	<c:forEach var="condition" items="${conditions }" varStatus="status">
		<tr>
			<td>
				<c:out value="${status.count }"></c:out> 
			</td>
			<td>
				<select name="ranks">
					<c:forEach var="rank" items="${defaultRanks.keySet() }">
						<c:choose>
							<c:when test="${condition.rank eq rank}">
								<option value="${rank }" selected="selected" >${defaultRanks.get(rank) }</option>
							</c:when>
							<c:otherwise>
								<option value="${rank }" >${defaultRanks.get(rank) }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="skills">
					<c:forEach var="skill" items="${defaultSkills.keySet()}">
						<c:choose>
							<c:when test="${condition.professionalSkill eq skill }">
								<option value="${skill }" selected="selected" >${defaultSkills.get(skill) }</option>
							</c:when>
							<c:otherwise>
								<option value="${skill }" >${defaultSkills.get(skill) }</option>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</select>
			</td>
			<td>
				요구기간
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>