<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	$(document).ready(function() {
		var size = "${budgetList.size() }";
		var pj_id = $("#changedPjId").val();
		
		if(size > 0) {
			var pb_no = $("#modifiedPbNum").val();
			if(pb_no == null || pb_no == "") {
				pb_no = $("#budgetSelectedListTable").find("tr:last").children().eq(1).text();
			}
			
			getBudgetInsertFormAjaxtest(pj_id, pb_no);
		}
		else {
			getBudgetInsertFormAjax(pj_id);
		}
		
		$("#lastPbNo").val($(".selectedBudgetRow" + size + " #pb_no").text());
	});
	
</script>
</head>
<body>
	<table class="bordered" id="budgetSelectedTable">
		<tr>
			<th>프로젝트ID</th>
			<th>예산번호</th>
			<th style="width: 200px;">예산등록일</th>
		</tr>
		
		<tbody></tbody>
	</table>
	<div style="max-height: 280px; overflow: scroll; overflow-x:hidden;">
		<table id="budgetSelectedListTable" class="bordered">
			<c:forEach var="budget" items="${budgetList}" varStatus="status">
				<tr class="selectedBudgetRow selectedBudgetRow${status.count }" style="height: 40px;">
				 	<td id ="pj_id">${budget.pj_id}</td>
					<td id="pb_no">${budget.pb_no }</td>
					<td id="pb_date">${budget.pb_date }</td>
				</tr>
			</c:forEach>
			
			<c:if test="${budgetList.size() == 0}" >
				<tr>
					<td colspan="3">등록된 예산 정보가 없습니다.</td>
				</tr>
			</c:if>
		</table>
	</div>
	<input type="hidden" id="lastPbNo"/>
</body>
</html>