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
	<c:forEach var="i" begin="1" end="${requirePerson }">
		<tr>
			<td>
				<c:out value="${i }"></c:out> 
			</td>
			<td>
				<select name="ranks">
					<c:forEach var="rank" items="${defaultRanks.keySet() }">
						<option value="${rank }" >${defaultRanks.get(rank) }</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="skills">
					<c:forEach var="skill" items="${defaultSkills.keySet() }">
						<option value="${skill }" >${defaultSkills.get(skill) }</option>
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