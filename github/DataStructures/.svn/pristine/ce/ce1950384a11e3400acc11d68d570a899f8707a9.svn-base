<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#candidateSearchResultFormDiv {max-height: 60vh; max-height: 60vm; overflow-y: auto;}
	#candidateSearchResultFormTable {width:100%; border: 1px #cecece dotted;}
	#candidateSearchResultFormTable tr {border: 1px #cecece dotted;}
</style>
</head>
<body>
	<div class="bordered" id="candidateSearchResultFormDiv">
		<table id="candidateSearchResultFormTable">
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
			
			<c:forEach var = "resultList" items="${candidateResultList}"> 
			<tr class="candidateSearchResultRow" style="cursor : pointer;">
				<td style="text-align:left;">${resultList.hr_name}</td>
				<td>${resultList.hr_company}</td>
				<td>${resultList.hr_cwm_env}</td>
				<td>${resultList.hr_grade}</td>
				<td>${resultList.hr_job_skill}</td>
				<td style="text-align:left;">${resultList.pj_id}</td>
				<td>${resultList.pd_end_date}</td>
				<td>${resultList.hr_residence}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	

</body>
</html>