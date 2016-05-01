<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form:form commandName="teamVO" id="modifyTeamForm" name="modifyTeamForm" method="post">
		<table class="inputbordered">
			<tr>
				<th>년도</th>
				<td style="text-align: left;">${team.tm_year }<input type="hidden" name="tm_year" id="tm_year" value="${team.tm_year }" ></td>
			</tr>
			<tr>
				<th>팀ID</th>
				<td style="text-align: left;">${team.tm_id }<input type="hidden" name="tm_id" id="tm_id" value="${team.tm_id }"></td>
			</tr>
			<tr>
				<th>팀명</th>
				<td><input type="text" id="tm_name" name="tm_name" value="${team.tm_name }"></td>
			</tr>
		</table>
	
		<table class="inputbordered" style="margin-top:10px">
			<tr>
				<th>계약목표</th>
				<td><input type="text" id="tm_contract" name="tm_contract" onkeyup="num_onlyAndComma(this)" value="${team.tm_contract }"></td>
			</tr>
			<tr>
				<th>매출목표</th>
				<td><input type="text" id="tm_sales" name="tm_sales" class="calcNetSales" onkeyup="num_onlyAndComma(this)" value="${team.tm_sales }"></td>
			</tr>
			<tr>
				<th>순매출목표</th>
				<td class="tm_net_sales" style="text-align:right">${team.tm_sales - team.tm_outsrc_cost - team.tm_matl_cost}</td>
			</tr>
			<tr>
				<th>이익목표</th>
				<td><input type="text" id="tm_profit" name="tm_profit" onkeyup="num_onlyAndComma(this)" value="${team.tm_profit}"></td>
			</tr>
			<tr>
				<th>예상외주비</th>
				<td><input type="text" id="tm_outsrc_cost" name="tm_outsrc_cost" class="calcNetSales" onkeyup="num_onlyAndComma(this)" value="${team.tm_outsrc_cost }"></td>
			</tr>
			<tr>
				<th>예상상품비</th>
				<td><input type="text" id="tm_matl_cost" name="tm_matl_cost" class="calcNetSales" onkeyup="num_onlyAndComma(this)" value="${team.tm_matl_cost }"></td>
			</tr>
			<tr>
				<th>기본경비율 (%)</th>
				<td><input type="text" id="tm_expnc_rate" name="tm_expnc_rate" onChange ="mmCheck(this)" onkeyup="num_range(this)" value="${team.tm_expnc_rate }"></td>
			</tr>
		</table>
	
		<table class="inputbordered" style="margin-top:10px">
			<tr>
				<th>MM 목표 (mm)</th>
					<td><input type="text" id="tm_mm" name="tm_mm" onkeyup="num_only(this)" value="${team.tm_mm }"></td>
			</tr>
			<tr>
				<th>인원수</th>
				<td><input type="text" id="tm_num" name="tm_num" onkeyup="num_only(this)" value="${team.tm_num }"></td>
			</tr>
			<tr>
				<th>팀 공통인건비</th>
				<td><input type="text" id="tm_ind_lcost" name="tm_ind_lcost" onkeyup="num_onlyAndComma(this)" value="${team.tm_ind_lcost }"></td>
			</tr>
			<tr>
				<th>팀 공통경비</th>
				<td><input type="text" id="tm_ind_expense" name="tm_ind_expense" onkeyup="num_onlyAndComma(this)" value="${team.tm_ind_expense }"></td>
			</tr>
			<tr>
				<th>팀 외주 MM단가</th>
				<td><input type="text" id="tm_out_mm_cost" name="tm_out_mm_cost" onkeyup="num_onlyAndComma(this)" value="${team.tm_out_mm_cost }"></td>
			</tr>
			<tr>
				<th>팀 직원 MM단가</th>
				<td><input type="text" id="tm_sqi_mm_cost" name="tm_sqi_mm_cost" onkeyup="num_onlyAndComma(this)" value="${team.tm_sqi_mm_cost }"></td>
			</tr>
		</table>
	</form:form>

	<div id="bottomLine">
		<span id="teamModifyBtn">저장</span>
		<span id="teamDeleteBtn">삭제</span>
		<span id="teamResetBtn">비우기</span>
	</div>
</body>
</html>