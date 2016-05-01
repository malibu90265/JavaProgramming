<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#cadidateListTableDiv {height: 70vh; height: 70vm; overflow-y: auto;}
	#cadidateListTable {width:100%; }
</style>
</head>
<body>
    <div id="cadidateListTableDiv">
		<table class="bordered" id="cadidateListTable">
			<tr>
				<th>프로젝트ID</th>
				<th>소요인원</th>
			</tr>
			<!--  style="width:200px; max-height:650px; overflow-y: scroll;" -->
			<!--  style="width:180px; table-layout: fixed;" -->
		<c:forEach var="list" items="${searchTeamProjectList}" varStatus="i">
			<tr class="candidateRow" style="cursor: pointer;">
				<td style="text-align:left;">${list.pj_id}</td>
				<td style="text-align:center;">${list.emp_cnt}</td>			<!-- 소요인원 -->
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>