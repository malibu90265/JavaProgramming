<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>PM평가 등록</title>
<style>
	#cssTable th {text-align:center;}
</style>
</head>
<body>

	<table id="cssTable">
		<tr>
			<th>SQ</th>
			<th>프로젝트ID</th>
			<th>성명</th>
			<th>등급</th>
			<th colspan="2">투입기간</th>
			<th>직무기술</th>
			<th>기반분류</th>
			<th>개발성과</th>
			<th>인성평가</th>
			<th>평가 설명</th>
		</tr>
		<c:forEach var="pmsEstimation" items="${pmsEstimationList }" varStatus="i" >
				<tr>
					<td>${i.count}</td>
					<td>${pmsEstimation.pj_id }</td>
					<td>${pmsEstimation.pd_name }</td>
					<td>${pmsEstimation.hr_grade }</td>
					<td>${pmsEstimation.pd_start_date }</td>
					<td>${pmsEstimation.pd_end_date }</td>
					<td>${pmsEstimation.hr_job_skill }</td>
					<td>${pmsEstimation.hr_cwm_env }</td>
					<td>${pmsEstimation.pd_abc }</td>
					<td>${pmsEstimation.pd_soft_abc }</td>
					<td id="descTd">${pmsEstimation.pd_abc_desc }</td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>


