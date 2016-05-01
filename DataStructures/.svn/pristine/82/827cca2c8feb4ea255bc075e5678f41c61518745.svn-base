<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
	<div class="bordered"> <!--  style="overflow-y: scroll; max-height: 425px" -->
		<table>
			<tr>
				<th>성명</th>
				<th>직원구분</th>
				<th>기반분류</th>
				<th>등급</th>
				<th>전문기술</th>
				<th>현재 프로젝트</th>
				<th>투입만료일</th>
				<th>거주지</th>
			</tr>
			
			<c:forEach var = "candidateResultList" items="${candidateResultList}"> 
			<tr>
				<td>${candidateResultList.hr_name}</td>
				<td>${candidateResultList.hr_company}</td>
				<td>${candidateResultList.hr_cwm_env}</td>
				<td>${candidateResultList.hr_grade}</td>
				<td>${candidateResultList.hr_job_skill}</td>
				<td>${candidateResultList.pj_id}</td>
				<td>${candidateResultList.pd_end_date}</td>
				<td>${candidateResultList.hr_residence}</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>