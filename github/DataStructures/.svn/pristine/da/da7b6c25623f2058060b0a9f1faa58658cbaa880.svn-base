<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		setDeleteSpanTagDisabled("teamDeleteBtn");
	});
	
</script>
</head>
<body>
	<form:form commandName="teamVO" id="teamInsertForm" name="teamInsertForm" method="post">
	<table class="inputbordered">
		<tr>
			<th>년도<span class="requiredAttr">*</span></th>
			<td style="text-align: left;"><input type="text" readonly="readonly" name="tm_year" id="tm_year"></td>
		</tr>
		<tr>
			<th>팀ID<span class="requiredAttr">*</span></th>
			<td style="text-align: left;"><input type="text" name="tm_id" id="tm_id"></td>
		</tr>
		<tr>
			<th>팀명<span class="requiredAttr">*</span></th>
			<td><input type="text" name="tm_name" id="tm_name"></td>
		</tr>
		</table>
		
		<table class="inputbordered" style="margin-top:10px">
		<tr>
			<th>계약목표<span class="requiredAttr">*</span></th>
			<td><input type="text" name="tm_contract" id="tm_contract" onkeyup="num_onlyAndComma(this)"></td>
		</tr>
		<tr>
			<th>매출목표<span class="requiredAttr">*</span></th>
			<td><input type="text" name="tm_sales" id="tm_sales" class="calcNetSales"
						onkeyup="num_onlyAndComma(this)"></td>
		</tr>
		<tr>
			<th>순매출목표</th>
			<td class="tm_net_sales" style="text-align:right"></td>
		</tr>
		<tr>
			<th>이익목표<span class="requiredAttr">*</span></th>
			<td><input type="text" name="tm_profit" id="tm_profit"
						onkeyup="num_onlyAndComma(this)"></td>
		</tr>
		<tr>
			<th>예상외주비</th>
			<td><input type="text" name="tm_outsrc_cost" id="tm_outsrc_cost" class="calcNetSales"
						onkeyup="num_onlyAndComma(this)"></td>
		</tr>
		<tr>
			<th>예상상품비</th>
			<td><input type="text" name="tm_matl_cost" id="tm_matl_cost" class="calcNetSales"
						onkeyup="num_onlyAndComma(this)"></td>
		</tr>
		<tr>
			<th>기본경비율 (%)</th>
			<td><input type="text" name="tm_expnc_rate" id="tm_expnc_rate" onChange ="mmCheck(this)" onkeyup="num_range(this)"></td>
		</tr>
		</table>
		
		<table class="inputbordered" style="margin-top:10px">
		<tr>
			<th>MM 목표 (mm)</th>
			<td><input type="text" name="tm_mm" id="tm_mm" onkeyup="num_only(this)"></td>
		</tr>
		<tr>
			<th>인원수</th>
			<td><input type="text" name="tm_num" id="tm_num" onkeyup="num_only(this)"></td>
		</tr>
		<tr>
			<th>팀 공통인건비</th>
			<td><input type="text" name="tm_ind_lcost" id="tm_ind_lcost"
						onkeyup="num_onlyAndComma(this)"></td>
		</tr>
		<tr>
			<th>팀 공통경비</th>
			<td><input type="text" name="tm_ind_expense" id="tm_ind_expense"
						onkeyup="num_onlyAndComma(this)"></td>
		</tr>
		<tr>
			<th>팀 외주 MM단가</th>
			<td><input type="text" name="tm_sqi_mm_cost" id="tm_sqi_mm_cost"
						onkeyup="num_onlyAndComma(this)"></td>
		</tr>
		<tr>
			<th>팀 직원 MM단가</th>
			<td><input type="text" name="tm_out_mm_cost" id="tm_out_mm_cost"
						onkeyup="num_onlyAndComma(this)"></td>
		</tr>
	</table>
	</form:form>
	
	<div id="bottomLine">
		<span id="teamSaveBtn">저장</span>
		<span id="teamDeleteBtn">삭제</span>
		<span id="teamResetBtn">비우기</span>
	</div>
</body>
</html>