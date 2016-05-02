<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table class="domainBordered">
		<tr>
			<th>업무분류</th>
		</tr>
	</table>
<div style="height: 240px;overflow: auto; overflow-x: hidden; text-overflow: ellipsis;">
	<table class="domainBordered">
		<c:forEach var="domain" items="${domainVO}">
			<tr class="domainRow">
				<td id="${domain.domain_id}">${domain.each_domain}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>