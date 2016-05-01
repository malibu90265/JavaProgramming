<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

	function setSpanTagDisabled(spanId){
		document.getElementById(spanId).disabled = true;
	}

	var pbSales;
	$(document).ready(function() {
		
		initProfitAndLoss();
		setSpanTagDisabled("pjBudgetDeleteBtn");
		
		$("#pb_sales").click(function(){
			$(this).val("");
		});
	
		$("#pb_matl_cost").click(function(){
			$(this).val("");
		});
		
		$("#pb_matl_cost").click(function(){
			$(this).val("");
		});
		
		
		/* 값이 바뀌는 경우 */
		
		// 총매출액 변경되는 경우
		$("#pb_sales").keyup(function() {
			// 순매출액 = 매출액 - 상품비 - 외주비
			$("#netSales").text( calcNetsales() );
			
			// 직접경비
			$("#pbDirectCost").text( calcPbDirectCost() );
			
			// 영업이익 = 순매출 - 인건비 - 경비
			$("#salesProfit").text( calcSalesProfit() );
		});
		
		// 상품비 변경되는 경우
		$("#pb_matl_cost").keyup(function() {
			// 순매출액 = 매출액 - 상품비 - 외주비
			$("#netSales").text( calcNetsales() );
			
			// 영업이익 = 순매출 - 인건비 - 경비
			$("#salesProfit").text( calcSalesProfit() );
		});
		
		// 추가경비 변경되는 경우
		$("#pb_extra_cost").keyup(function() {
			// 영업이익 = 순매출 - 인건비 - 경비
			$("#salesProfit").text( calcSalesProfit() );
		});
		
		// 변경내역 누르면
		$("#pjBudgetHistoryBtn").click(function() {
			var formId = "pjBudgetInsertForm";
			popupWindow(formId);
		});
		
		var id = ".datepicker";
		setDate(id);
		
	});
	
</script>
</head>
<body>
	<form:form commandName="budgetVO" id="pjBudgetInsertForm" name="pjBudgetInsertForm" method="post">
		<table class="inputbordered">
			<tr>
				<th>프로젝트ID</th>
				<td id="pjId"  style="text-align: left;">${budgetVO.pj_id}</td>
			</tr>
		</table>
		
		<table class="inputbordered" style="margin-top: 10px;">
			<tr>
				<th>예산 번호<span class="requriedAttr">*</span></th>
				<td style="text-align: left;"><input type="text" id="pb_no" name="pb_no" value="${budgetVO.pb_no}"/></td>
			</tr>
			<tr>
				<th>예산 등록일</th>
				<td style="text-align: left;">${budgetVO.pb_date}</td>
			</tr>
		</table>
		
		<table class="inputbordered" style="margin-top: 10px;">
			<tr>
				<th>프로젝트 시작일<span class="requriedAttr">*</span></th>
				<td><input type="text" class = "datepicker" name="pb_start_date" id="pb_start_date" value="${budgetVO.pb_start_date}"
						style="text-align: center;"></td>
			</tr>
			<tr>
				<th>프로젝트 종료일<span class="requriedAttr">*</span></th>
				<td><input type="text" class = "datepicker" name="pb_end_date" id="pb_end_date" value="${budgetVO.pb_end_date}"
						style="text-align: center;"></td>
			</tr>
			<tr>
				<th>투입 인원수</th>
				<td>${budgetVO.pb_put_num }</td>
			</tr>
			<tr>
				<th>직원MM</th>
				<td id="pbSqiMM">
					${budgetVO.pb_emp_mm }
					<input type="hidden" id="pb_emp_mm" name="pb_emp_mm" value="${budgetVO.pb_emp_mm }" />
				</td>
			</tr>
			<tr>
				<th>외주MM</th>
				<td id="pbOutMM">
					${budgetVO.pb_outEmp_mm }
					<input type="hidden" id="pb_outEmp_mm" name="pb_outEmp_mm" value="${budgetVO.pb_outEmp_mm }" />
				</td>
			</tr>
			<tr>
				<th>총 MM</th>
				<td id="mmResult"></td>
			</tr>
		</table>
			
		<table class="inputbordered right" style="margin-top: 10px;">
			<tr>
				<th>총 매출액<span class="requriedAttr">*</span></th>
				<td><input type="text" name="pb_sales" id="pb_sales" value="${budgetVO.pb_sales}" onkeyup="num_onlyAndComma(this);"
					style="text-align: right;"/></td>
			</tr>
			<tr>
				<th>상품비<span class="requriedAttr">*</span></th>
				<td><input type="text" name="pb_matl_cost" id="pb_matl_cost" value="${budgetVO.pb_matl_cost}" onkeyup="num_onlyAndComma(this);"
					style="text-align: right;"/></td>
			</tr>
			<tr>
				<th>외주비</th>
				<td id="pbOutsrcCost">
					<fmt:formatNumber type="number" pattern="#,###" value="${budgetVO.pb_outsrc_cost}"/>
					<input type="hidden" id="pb_outsrc_cost" name="pb_outsrc_cost" value="${budgetVO.pb_outsrc_cost}" />
				</td>
			</tr>
			<tr>
				<th>순매출</th>
				<td id="netSales"></td>
			</tr>
			<tr>
				<th>인건비</th>
				<td id="pbLaborCost">
					<fmt:formatNumber type="number" pattern="#,###" value="${budgetVO.pb_labor_cost}"/>
					<input type="hidden" id="pb_labor_cost" name="pb_labor_cost" value="${budgetVO.pb_labor_cost}">
				</td>
			</tr>
			<tr>
				<th>직접경비</th>
				<td id="pjDirectCost"></td>
			</tr>
			<tr>
				<th>추가경비<span class="requriedAttr">*</span></th>
				<td><input type="text" name="pb_extra_cost" id="pb_extra_cost" value="${budgetVO.pb_extra_cost}" onkeyup="num_onlyAndComma(this);"
					style="text-align: right;"></td>
			</tr>
			<tr>
				<th>영업이익</th>
				<td id="salesProfit"></td>
			</tr>
		</table>
		
		<!-- 프로젝트ID -->
		<input type="hidden" name="pj_id" id="pj_id" value="${budgetVO.pj_id}"/>
	</form:form>
		
	<!-- 기본경비율 -->
	<input type="hidden" id="tm_expnc_rate" value="${teamVO.tm_expnc_rate }" />  
	
	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine">
				<span id="pjBudgetHistoryBtn">변경내역</span> 
				<span id="pjBudgetInsertBtn">저장</span> 
				<span id="pjBudgetDeleteBtn">삭제</span> 
				<span id="makeNewPjBudgetBtn">신규추가*</span>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
</html>