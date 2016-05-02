<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table class="bordered" id="team">
		<tr>
			<th class="borderTN">팀명</th>
			<th class="borderTU">인원</th>
			<th class="borderTC" style="text-align: center;">계약</th>
			<th class="borderTS" style="text-align: center;">매출</th>
			<th class="borderTS" style="text-align: center;">순매출</th>
			<th class="borderTP" style="text-align: center;">이익</th>
		</tr>
		<c:forEach var="list" items="${teamList}">
			<tr class="teamRow" style="cursor: pointer;">
				<td class="borderTN" id="${list.tm_id }">${list.tm_name}</td>
				<td class="borderTU">${list.tm_num}</td>
				<td class="borderTC"><fmt:formatNumber type="number" pattern="#,###" value="${list.tm_contract}"/></td>
				<td class="borderTS"><fmt:formatNumber type="number" pattern="#,###" value="${list.tm_sales}"/></td>
				<td class="borderTS"><fmt:formatNumber type="number" pattern="#,###" value="${list.tm_sales - list.tm_matl_cost - list.tm_outsrc_cost}"/></td>
				<td class="borderTP"><fmt:formatNumber type="number" pattern="#,###" value="${list.tm_profit}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
