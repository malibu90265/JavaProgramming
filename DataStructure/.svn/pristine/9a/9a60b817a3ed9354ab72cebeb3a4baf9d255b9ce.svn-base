<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript">
	var index;
	$(document).ready(function() {
		            
		var targetValue;
		$('select').focus(function() {
			targetValue = $(this).val();
		});
		
		$("#candidateSearchBtn").click(function(){
			getCandidateSearchResultForm(".candidateCom");
		});
		
	});
</script>
<style type="text/css">
	#candidateSearchFormDiv {border: none;}
	#candidateSearchFormTable {width: 100%;}
	select {width: 100%; border:none;}
</style>
</head>
<body>
	<div id="candidateSearchFormDiv">
		<h2 style="text-align:center;">대상자 검색 조건 순위</h2>
		<table class="search" id="candidateSearchFormTable" >
			<tr>
				<th>1</th>
				<th>2</th>
				<th>3</th>
				<th>4</th>
				<th>5</th>
				<th rowspan="2" id="candidateSearchBtn" style="text-align=center; cursor: pointer;">검색</th>
			</tr>
			<tr id="selectOptionsTr">
				<td><select class="priority" id="0" onchange="setSelectOptions(0)">
							<option value="선택">선택</option>
							<option value="일자">일자</option>
							<option value="직원">직원</option>
							<option value="기술">기술</option>
							<option value="등급">등급</option>
							<option value="거주지">거주지</option>
				</select></td>
				<c:forEach var="priority" begin="1" end="4">
					<td><select class="priority" id="${priority}" onchange="setSelectOptions(${priority})">
							<option value="선택">선택</option>
					</select></td>
				</c:forEach>
				
			</tr>
		</table>
		
		
		<div>
			<form:form commandName = "candidateVO"
						id="candidateSelectSearchForm" name="candidateSelectSearchForm" method="post">
				<input type="hidden" id="one"			name="one" />
				<input type="hidden" id="two"			name="two"/>
				<input type="hidden" id="three"			name="three"/>
				<input type="hidden" id="four"			name="four"/>
				<input type="hidden" id="five"			name="five"/>
				<input type="hidden" id="pr_sq"			name="pr_sq" 			value="${candidateVO.pr_sq}">
				<input type="hidden" id="pr_grade"		name="pr_grade" 	value="${candidateVO.pr_grade}">
				<input type="hidden" id="pr_job_skill"	name="pr_job_skill" value="${candidateVO.pr_job_skill}">
				<input type="hidden" id="pr_start_date"	name="pr_start_date" value="${candidateVO.pr_start_date}">
				<input type="hidden" id="pr_end_date"	name="pr_end_date" 	value="${candidateVO.pr_end_date}">
				<input type="hidden" id="pj_loc"		name="pj_loc" 		value="${candidateVO.pj_loc}">
			</form:form>
		</div>
		
		<br><br>
		
		<div id="candidateSearchResultForm"></div>
		
	</div>


</body>
</html>