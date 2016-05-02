<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="pjStatusBordered">
	<tr>
		<th>추진상태</th>
		<th>Color</th>
	</tr>
</table>
<div style="height:280px; overflow: auto; overflow-x: hidden; text-overflow: ellipsis;">
<table class="pjStatusBordered" style="width: 325px;">
	<c:forEach var="pjStatus" items="${pjStatusList}">
		<tr class="pjStatusRow">
			<td id="${pjStatus.pj_status_id }">${pjStatus.pj_status_name }</td>
			<td style="background-color: ${pjStatus.pj_status_color };"></td>
		</tr>
	</c:forEach>
</table>
</div>
