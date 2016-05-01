<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	
	$(document).ready(function() {
		var id = ".datepicker";
		setDate(id);
	});
</script>
</head>
<body>

	<form:form commandName="projectVO" id="projectInsertForm" name="projectInsertForm" method="post">
		<table class="inputbordered">
			<tr>
				<th>팀 명</th>
				<td id="tm_name"></td>
			</tr>
			<tr>
				<th>프로젝트 ID<span class="requiredAttr">*</span></th>
				<td><input type="text" name="pj_id" id="pj_id"></td>
			</tr>
			<tr>
				<th>프로젝트명<span class="requiredAttr">*</span></th>
				<td><input type="text" name="pj_name" id="pj_name"></td>
			</tr>
			<tr>
				<th>상태<span class="requiredAttr">*</span></th>
				<td><select id="pjStatusSelect" name="pj_status">
						<option value="0">선택</option>
						<c:forEach var="status" items="${pjStatusList }">
							<option value="${status.pj_status_id}">${status.pj_status_name}</option>
						</c:forEach>
				</select></td>
			</tr>
			</table>
	
			<table class="inputbordered" style="margin-top:5px">
			<tr>
				<th>발주 고객명<span class="requiredAttr">*</span></th>
				<td><input type="text" name="pj_order_client"
					id="pj_order_client"></td>
			</tr>
			<tr>
				<th>계약 고객명<span class="requiredAttr">*</span></th>
				<td><input type="text" name="pj_sign_client"
					id="pj_sign_client"></td>
			</tr>
			<tr>
				<th>계약액<span class="requiredAttr">*</span></th>
				<td><input type="text" class="setYearSales" name="pj_amount" id="pj_amount" 
							onkeydown="num_only(this)" style="text-align:right;"></td>
			</tr>
			<tr>
				<th>프로젝트 시작일<span class="requiredAttr">*</span></th>
				<td><input type="text" style="text-align: center;" class="datepicker setYearSales" name="pj_start_date" id="pj_start_date"value = ""></td>
			</tr>
			<tr>
				<th>프로젝트 종료일<span class="requiredAttr">*</span></th>
				<td><input type="text" style="text-align: center;" class="datepicker setYearSales" name="pj_end_date" id="pj_end_date" value = ""></td>
			</tr>
			<tr>
				<th>금년 매출액<span class="requiredAttr">*</span></th>
				<td>
					<input type="text" name="pj_year_sales" id="pj_year_sales" 
								onkeydown="num_only(this)" style="text-align:right;">
				</td>
			</tr>
			<tr>
				<th>영업 단계<span class="requiredAttr">*</span></th>
				<td><select id="pjStageSelect" name="pj_stage">
						<option value="0">선택</option>
						<c:forEach var="stage" items="${pjStageList}">
							<option value="${stage.pj_stage_id}">${stage.pj_stage_name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>제안일</th>
				<td><input type="text" style="text-align: center;" class="datepicker" name="pj_propose_date"
					id="pj_propose_date" value = ""></td>
			</tr>
			<tr>
				<th>계약일</th>
				<td><input type="text" style="text-align: center;" class="datepicker" name="pj_contract_date" id="pj_contract_date" value = ""></td>
			</tr>
			<tr>
				<th>비 고</th>
				<td><input type="text" style="text-align: left; height:50px;" class="pj_memo" name="pj_memo" id="pj_memo" value = ""></td>
			</tr>
			<tr>
				<th>최종 수정일</th>
				<td></td>
			</tr>
			
		</table>
		
		<!-- 팀 ID -->
		<input type="hidden" name="tm_id" id="tm_id">
		
	</form:form>

	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine">
				<span id="projectSaveBtn">저장</span> 
				<span id="projectDeleteBtn">삭제</span>
				<span id="projectResetBtn">비우기</span>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
		
</body>
</html>