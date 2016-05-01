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
	<c:forEach var="condition" items="${conditions}" varStatus="status">
		<tr>
			<td>
				<c:out value="${status.count }"></c:out> 
			</td>
			<td>
				${condition.rank }
			</td>
			<td>
				${condition.professionalSkill }
			</td>
			<td>
				요구기간
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>