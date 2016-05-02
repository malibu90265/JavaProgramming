<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table class="roleBordered">
		<tr>
			<th>역할분류</th>
		</tr>
	</table>
<div style="height: 240px;overflow: auto; overflow-x: hidden; text-overflow: ellipsis;">
	<table class="roleBordered">
		<c:forEach var="role" items="${roleList}">
			<tr>
				<td class="roleRow" id="${role.role_id }">${role.each_role }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>