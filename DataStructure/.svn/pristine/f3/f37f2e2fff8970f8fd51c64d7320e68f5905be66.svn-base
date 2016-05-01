<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		$(".pjBudgetRow").click(function() {
			var pj_id = $(this).children().eq(3).text();
			var pb_no = $(this).children().eq(1).text();
			var tm_id = $("#pjBudgetSearchDiv").find("#tm_id_select option:selected").attr('id');
			
			$("#modifiedPbNum").val(pb_no);
			$("#changedPjId").val( pj_id );
			if(pb_no == ""){
				alert("등록된 예산 번호가 없으므로 신규추가 창으로 이동합니다.");
				calculateNewBudgetInfoAjax(tm_id,pj_id,pb_no);
			}
			else{
				getBudgetInsertFormAjaxtest(pj_id, pb_no);
			}
		});
	});
	
</script>
</head>
<body>

	<table class="bordered">
		<tr>
			<th class="borderedPST">상태</th>
			<th class="borderedPJN">예산번호</th>
			<th class="borderedPJD">예산등록일</th>
			<th class="borderedPI">프로젝트ID</th>
			<th class="borderedPN" style="width: 395px;">프로젝트명</th>
		</tr>
	</table>
	
	<div id="pjBudgetFirstList">
	<table class="bordered">
		<c:forEach var="projectBudget" items="${projectBudgetList}">
			<tr class="pjBudgetRow">
				<td class="borderedPST">${projectBudget.pj_status_name }</td>
				<td class="borderedPJN" id ="pb_no">${projectBudget.pb_no}</td>
				<td class="borderedPJD">${projectBudget.pb_date}</td>
				<td class="borderedPI" id ="pj_id">${projectBudget.pj_id }</td>
				<td class="borderedPN">${projectBudget.pj_name }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<input type="hidden" id="changedPjId" />
	<input type="hidden" id="modifiedPbNum"/>
	
	 <div id="pjBudgetSelectedListForm"></div> 
	
</body>
</html>