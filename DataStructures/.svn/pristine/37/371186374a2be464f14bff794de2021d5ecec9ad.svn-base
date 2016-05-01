<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		
		var id = ".datepicker";
		setDate(id);
		
		$("#pj_amount").val( Comma($("#pj_amount").val()) );
		$("#pj_year_sales").val( Comma($("#pj_year_sales").val()) );
	});
	
</script>
</head>
<body>
	
	<form:form commandName="projectVO" name="projectModifyForm" id="projectModifyForm" method="post">
		<table class="inputbordered">
			<tr>
				<th>팀 명</th>
				<td>${projectVO.tm_name}
					<input type="hidden" id="tm_id" name="tm_id" value="${projectVO.tm_id}"/>
				</td>
			</tr>
			<tr>
				<th>프로젝트 ID<span class="requiredAttr">*</span></th>
				<td>
					${projectVO.pj_id}
					<input type="hidden" id="pj_id" name="pj_id" value="${projectVO.pj_id}" readonly="readonly"  style="background-color:#e6e6fa;"/>
				</td>
			</tr>
			<tr>
				<th>프로젝트명<span class="requiredAttr">*</span></th>
				<td><input type="text" id="pj_name" name="pj_name" value="${projectVO.pj_name}" /></td>
			</tr>
			<tr>
				<th>상태<span class="requiredAttr">*</span></th>
				<td>
					<select id="pjStatusSelect" name="pj_status">
						<option value="0">선택</option>
						<c:forEach var="status" items="${pjStatusList }">
							<c:choose>
								<c:when test="${status.pj_status_id eq projectVO.pj_status }">
									<option value="${status.pj_status_id}" selected="selected">${status.pj_status_name}</option>
								</c:when>
								<c:otherwise>
									<option value="${status.pj_status_id}">${status.pj_status_name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			</table>
		
			<table class="inputbordered" style="margin-top:10px">
			<tr>
				<th>발주 고객명<span class="requiredAttr">*</span></th>
				<td><input type="text" id="pj_order_client" name="pj_order_client" value="${projectVO.pj_order_client}" /></td>
			</tr>
			<tr>
				<th>계약 고객명<span class="requiredAttr">*</span></th>
				<td><input type="text" id="pj_sign_client" name="pj_sign_client" value="${projectVO.pj_sign_client}" /></td>
			</tr>
			<tr>
				<th>계약액<span class="requiredAttr">*</span></th>
				<td><input type="text" class ="setYearSales" id="pj_amount" name="pj_amount"   value="${projectVO.pj_amount}" 
							onkeydown="num_only(this)" style="text-align:right;"/></td>
			</tr>
			<tr>
				<th>프로젝트 시작일<span class="requiredAttr">*</span></th>
				<td><input type="text" style="text-align: center;" class="datepicker setYearSales" name="pj_start_date" id="pj_start_date" value="${projectVO.pj_start_date}" /></td>
			</tr>
			<tr>
				<th>프로젝트 종료일<span class="requiredAttr">*</span></th>
				<td><input type="text" style="text-align: center;" class="datepicker setYearSales" id="pj_end_date" name="pj_end_date" value="${projectVO.pj_end_date}" /></td>
			</tr>
			<tr>
				<th>금년 매출액<span class="requiredAttr">*</span></th>
				<td>
					<input type="text" name="pj_year_sales" id="pj_year_sales" value = "${projectVO.pj_year_sales }" 
								onkeydown="num_only(this)" style="text-align:right;" />
				</td>
			</tr>
			<tr>
				<th>영업 단계<span class="requiredAttr">*</span></th>
				<td>
					<select id="pjStageSelect" name="pj_stage">
						<option value="0">선택</option>
						<c:forEach var="stage" items="${pjStageList}">
							<c:choose>
								<c:when test="${stage.pj_stage_id eq projectVO.pj_stage }">
									<option value="${stage.pj_stage_id}" selected="selected">${stage.pj_stage_name}</option>
								</c:when>
								<c:otherwise>
									<option value="${stage.pj_stage_id}">${stage.pj_stage_name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>제안일</th>
				<td><input type="text" style="text-align: center;" class="datepicker" id="pj_propose_date" name="pj_propose_date" value="${projectVO.pj_propose_date}" /></td>
			</tr>
			<tr>
				<th>계약일</th>
				<td><input type="text" style="text-align: center;" class="datepicker" id="pj_contract_date" name="pj_contract_date" value="${projectVO.pj_contract_date}" /></td>
			</tr>
			<tr>
				<th>비 고</th>
				<td><input type="text" style="text-align: left; height:50px;" class="pj_memo" name="pj_memo" id="pj_memo" value = "${projectVO.pj_memo}"></td>
			</tr>
			<tr>
				<th>최종 수정일</th>
				<td>${projectVO.pj_LMD}</td>
			</tr>
		</table>
	</form:form>
	
	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine">
				<span id="projectModifyBtn">저장</span> 
				<span id="projectDeleteBtn">삭제</span>
				<span id="projectResetBtn">비우기</span>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>

</body>
</html>