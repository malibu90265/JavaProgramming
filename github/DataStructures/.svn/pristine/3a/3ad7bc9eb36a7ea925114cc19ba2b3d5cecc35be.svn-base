<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<!-- <script type="text/javascript">
	
	// 소요인원수 집어넣을 것.
	var pjId = '${pjId}';
	$(document).ready(function() {
		getCandidateDetailFormAjax(pjId);
	}); 
</script> -->
<style type="text/css">
	#candidateDetailFormDiv {max-height: 80vh; overflow-y: auto;}
	#candidateDetailFormTable {width:100%;}
</style>
</head>
<body>
	<h2 style="text-align:center;">인력소요</h2>
	<div class="bordered" id="candidateDetailFormDiv">
		<table class="menuSearch" id="candidateDetailFormTable">
			<tr>
				<th rowspan="2">번호</th>
				<th rowspan="2">등급</th>
				<th rowspan="2">전문기술</th>
				<th colspan="2">투입기간</th>
			</tr>
			<tr>
				<th>투입일</th>
				<th>만료일</th>
			</tr>
			
			<c:forEach var = "list" items="${candidateConditionList}">
				<c:choose>
					<c:when test="${list.pr_name == NULL or list.pr_name =='' }">
						<tr class ="candidateDetailRow" style="cursor: pointer;">		
							<td>${list.pr_sq}</td> <!--번호/등급/전문기술/투입일/만료일/직원외주  -->
							<td>${list.pr_grade}</td> <!--번호/등급/전문기술/투입일/만료일/직원외주  -->
							<td>${list.pr_job_skill}</td>	
							<td>${list.pr_start_date}</td>	
							<td>${list.pr_end_date}</td>	
						</tr>
					</c:when>
					<c:otherwise>
						<tr class ="candidateDetailRow" style="cursor: pointer; background: #E6F0FB;">		
							<td>${list.pr_sq}</td> <!--번호/등급/전문기술/투입일/만료일/직원외주  -->
							<td>${list.pr_grade}</td> <!--번호/등급/전문기술/투입일/만료일/직원외주  -->
							<td>${list.pr_job_skill}</td>	
							<td>${list.pr_start_date}</td>	
							<td>${list.pr_end_date}</td>	
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table>
	</div>
	<form:form  commandName = "candidateVO" id="conditionForm"  method="post">
		<input type="hidden" 	id="pr_sq"			name="pr_sq">
		<input type="hidden" 	id="pr_grade"		name="pr_grade">
		<input type="hidden" 	id="pr_job_skill"	name="pr_job_skill">
		<input type="hidden" 	id="pr_start_date"	name="pr_start_date">
		<input type="hidden" 	id="pr_end_date"	name="pr_end_date">
		<input type="hidden" 	id="pj_loc"			name="pj_loc">
 	</form:form>
</body>
</html>