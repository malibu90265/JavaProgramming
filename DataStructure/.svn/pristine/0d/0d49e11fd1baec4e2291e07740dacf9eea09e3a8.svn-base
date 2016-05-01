<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<!-- 프로젝트 배치/투입 현황 -->
<body>
	<table>
		<tr>
			<th colspan="14" style="text-align: center;">프로젝트 배치/투입 현황</th>
		</tr>
		<tr>
			<th style="text-align:center;">투입 번호</th>
			<th style="text-align:center;">성명</th>
			<th style="text-align:center;">소요 번호</th>
			<th style="text-align:center;">투입일</th>
			<th style="text-align:center;">소요일</th>
			<th style="text-align:center;">투입 만료일</th>
			<th style="text-align:center;">소요 만료일</th>
			<th style="text-align:center;">투입단가</th>
			<th style="text-align:center;">배치단가</th>
			<th style="text-align:center;">투입등급</th>
			<th style="text-align:center;">소요등급</th>
			<th style="text-align:center;">투입기술</th>
			<th style="text-align:center;">소요기술</th>
			<th style="text-align:center;">투입율</th>
		</tr>
		<c:forEach var="employeeInputDetailForm2List" items="${employeeInputDetailForm2List }">
			<tr class="employeeInputRow">				
				<td id="pd_sq" style="text-align:center;">${employeeInputDetailForm2List.pd_sq}</td>
				<td id="pd_name" style="text-align:right;">${employeeInputDetailForm2List.pd_name }</td>
				<td id="pr_sq" style="text-align:center;">${employeeInputDetailForm2List.pr_sq}</td>
				<td id="pd_start_date" style="text-align:right;" >${employeeInputDetailForm2List.pd_start_date }</td>
				<td id="pr_start_date" style="text-align:right;">${employeeInputDetailForm2List.pr_start_date }</td>
				<td id="pd_end_date" style="text-align:right;">${employeeInputDetailForm2List.pd_end_date }</td>
				<td id="pr_end_date" style="text-align:right;">${employeeInputDetailForm2List.pr_end_date }</td>
				<td id="pd_uprice" style="text-align:right;"><fmt:formatNumber>${employeeInputDetailForm2List.pd_uprice }</fmt:formatNumber></td>
				<td id="pr_uprice" style="text-align:right;"><fmt:formatNumber>${employeeInputDetailForm2List.pr_uprice }</fmt:formatNumber></td>
				<td id="pd_grade" style="text-align:right;">${employeeInputDetailForm2List.hr_grade }</td>
				<td id="pr_grade" style="text-align:right;">${employeeInputDetailForm2List.pr_grade }</td>
				<td id="pd_job_skill" style="text-align:right;">${employeeInputDetailForm2List.hr_job_skill }</td>
				<td id="pr_job_skill" style="text-align:right;">${employeeInputDetailForm2List.pr_job_skill }</td>
				<td id="pd_ratio" style="text-align:right;">${employeeInputDetailForm2List.pd_ratio }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

