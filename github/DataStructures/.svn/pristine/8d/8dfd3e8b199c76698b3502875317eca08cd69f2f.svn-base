<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div id="deployRequirementsTable" style="width: 498px; height: 500px; overflow-y: auto; float: left; text-align: center;">
		<table>
			<tr>
				<th>상태</th>
				<th>팀</th>
				<th>프로젝트ID</th>
				<th>프로젝트기간</th>
				<th>기반분류</th>
				<th>소요인원수</th>
				<th>배치인원수</th>
				<th>투입인원수</th>
				<th>근무지</th>
			</tr>
			
			<c:forEach var="item" items="${budgetVO }" varStatus="i">
			<tr class="deployRequirementsRow" style="cursor: pointer;">
					<td id="id${i.index}">${item.pj_prog }</td>
					<td>${item.team_name }</td>
					<td >${item.pj_id }</td>
					<td>${item.pj_start_day } ~ ${item.pj_end_day }</td>
					<td>${item.pj_require }</td>
					<td>${item.pn_num }</td>
					<td>${item.emp_cnt2 }</td>
					<td>${item.emp_cnt}</td>
					<td>${item.pj_loc}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>