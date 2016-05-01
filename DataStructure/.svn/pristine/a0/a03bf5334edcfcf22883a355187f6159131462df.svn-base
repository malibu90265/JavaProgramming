<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="skillEnvBordered">
	<tr>
		<th>구분</th>
		<th>환경</th>
	</tr>
</table>
<div style="height: 240px;overflow: auto; overflow-x: hidden; text-overflow: ellipsis;">
<table class="skillEnvBordered" style="width: 316px;">
	<c:forEach var="skillEnv" items="${skillEnvList}">
		<tr class="skillEnvRow">
			<td>${skillEnv.environment_division }</td>
			<td>${skillEnv.each_environment }</td>
		</tr>
	</c:forEach>
</table>
</div>
