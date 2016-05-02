<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="search">
	<tr>
		<th>검색</th>
		<td>
			<select id="tm_id" onchange="weekChartSelectChangeFunction()">
				<option value="all">전체</option>
				<c:forEach var="team" items="${teamList}">
					<option value="${team.tm_id}" ${team.tm_id == tm_id?'selected':'' }>${team.tm_name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
</table>
<h5>단위 : 백 만원</h5>