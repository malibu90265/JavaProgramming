<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
</head>
<body>
	<table class="bordered">
		<tr>
			<th class="tablePST">상태</th>
			<th class="tablePI">프로젝트ID</th>
			<th class="tablePN">프로젝트명</th>
			<th class="tablePCN">계약액</th>
			<th class="tablePCN" style="width: 131px;">영업손익</th>
		</tr>
	</table>
	<div style="width:685px; white-space:nowrap; overflow: scroll; overflow-x: hidden; max-height: 650px;">
		<table class="bordered">
			<c:forEach var="project" items="${projectList}" varStatus="status">
				<tr class="pjProfitAndLossRow">
					<td class="tablePST">${project.pj_status_name}</td>
					<td class="tablePI">${project.pj_id }</td>
					<td class="tablePN">${project.pj_name }</td>
					<td class="tablePCN" style="text-align: right;"><fmt:formatNumber type="number" pattern="#,###" value="${project.pj_amount }"/></td>
					<td class="tablePCN" style="text-align: right;"><fmt:formatNumber type="number" pattern="#,###" value="${project.salesProfit }"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>