<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
	$(document).ready(function() {
		
		initProfitAndLoss();
		
		/* 값이 바뀌는 경우*/
		$(".pj_mm").keyup(function() {
		
			// 총 MM
			$("#mmResult").text( calcMMResult());
			
			// 인건비
			$("#pjPersonnelCost").text( calcPjLaborCost() );	
			
			// 외주비
			$("#pj_outsrc_cost").text( calcPjOutsrcCost() );
			
			// 순매출액 = 매출액 - 상품비 - 외주비
			$("#netSales").text( calcNetsales() );
			
			// 영업이익 = 순매출 - 인건비 - 경비
			$("#salesProfit").text( calcSalesProfit() );
		});
		
		// 상품비 변경되는 경우
		$("#pj_matl_cost").keyup(function() {
			// 순매출액 = 매출액 - 상품비 - 외주비
			$("#netSales").text( calcNetsales() );
			
			// 영업이익 = 순매출 - 인건비 - 경비
			$("#salesProfit").text( calcSalesProfit() );
		});
		
		// 추가경비 변경되는 경우
		$("#pj_extra_cost").keyup(function() {
			// 영업이익 = 순매출 - 인건비 - 경비
			$("#salesProfit").text( calcSalesProfit() );
		});
		
		
		
		$("#pjProfitAndLossResetBtn").click(function() {
			$("#pj_sqi_mm").val(0);
			$("#pj_out_mm").val(0);
			$("#pj_matl_cost").val(0);
			$("#pj_extra_cost").val(0);
			
			initProfitAndLoss();
		});
		
	});
	
	function validationCheck() {
		if($("#pj_sqi_mm").val() == "" || $("#pj_sqi_mm").val() == null) {
			alert("추정직원MM을 입력하세요.");
			return false;
		}
		
		if($("#pj_out_mm").val() == "" || $("#pj_out_mm").val() == null) {
			alert("추정외주MM을 입력하세요.");
			return false;
		}
		
		if($("#pj_matl_cost").val() == "" || $("#pj_matl_cost").val() == null) {
			alert("상품비를 입력하세요.");
			return false;
		}
		
		if($("#pj_extra_cost").val() == "" || $("#pj_extra_cost").val() == null) {
			alert("추가경비를 입력하세요.");
			return false;
		}
		
		return true;
	}
	
	// 처음에 들어왔을 작동되게
	function initProfitAndLoss() {
		// Comma (추정직원MM, 추정외주MM, 상품비, 추가경비)
		$("#pj_matl_cost").val(Comma($("#pj_matl_cost").val()));
		$("#pj_extra_cost").val(Comma($("#pj_extra_cost").val()));
		
		// 인건비
		$("#pjPersonnelCost").text( calcPjLaborCost() );
		
		// 외주비
		$("#pj_outsrc_cost").text( Comma($("#pj_outsrc_cost").text()) );
		
		// 직접경비 
		$("#pjDirectCost").text( calcPjDirectCost() );
		
		// 순매출액 
		$("#netSales").text( calcNetsales() );
		
		// 영업이익 
		$("#salesProfit").text( calcSalesProfit() );
	}
	
	// 총 MM 계산
	 function calcMMResult() {
		var mmResult = $("#pj_sqi_mm").val()*1 + $("#pj_out_mm").val()*1;
		return mmResult;
	} 
	
	// 인건비 계산
	function calcPjLaborCost() {
		var pjPersonnelCost = $("#tm_sqi_mm_cost").val() * (removeComma($("#pj_sqi_mm").val())*1);
		return Comma(pjPersonnelCost.toString());
	}
	
	// 외주비 계산
	function calcPjOutsrcCost() {
		var pjOutsrcCost = $("#tm_out_mm_cost").val() * (removeComma($("#pj_out_mm").val())*1)
		return Comma(pjOutsrcCost.toString());
	}
	
	// 직접경비 계산 = 금년 매출액 * 기본경비율 : 현재 페이지에서 변하지 않는 값
	function calcPjDirectCost() {
		var pjDirectCost = ( Math.round(removeComma($("#pj_year_sales").text()) * ($("#tm_expnc_rate").val()*1) / 100) );
		return Comma(pjDirectCost.toString());
	}
	
	// 순매출액 계산 = 금년 매출액 - 상품비 - 외주비
	function calcNetsales() {
		var netSales = removeComma($("#pj_year_sales").text()) - removeComma($("#pj_matl_cost").val())*1 - removeComma($("#pj_outsrc_cost").text())*1;
		return Comma(netSales.toString());
	}
	
	// 영업이익 계산 = 순매출액 - 인건비 - 직접경비 - 추가경비
	function calcSalesProfit() {
		var salesProfit = removeComma(calcNetsales()) - removeComma(calcPjLaborCost()) - removeComma(calcPjDirectCost()) - removeComma($("#pj_extra_cost").val())*1;
		return Comma(salesProfit.toString());
	}
	
	
	
</script>
</head>
<body>
	<form:form commandName="projectVO" id="pjProfitAndLossModifyForm" name="pjProfitAndLossModifyForm" method="post">
		<table class="inputbordered">
			<tr>
				<th>프로젝트ID</th>
				<td style="text-align: left;">
					${projectVO.pj_id }
					<input type="hidden" name="pj_id" id="pj_id" value="${projectVO.pj_id }" />
					<input type="hidden" name="tm_id" value="${projectVO.tm_id }" />
					<input type="hidden" name="pj_status_name"  id="pj_status_name" value="${projectVO.pj_status_name}" />
				</td>
			</tr>
		</table>
		
		<table class="inputbordered" style="margin-top: 5px;">
			<tr>
				<th>소요인원수</th>
				<td>${projectVO.pj_req_num }</td>
			</tr>
			<tr>
				<th>추정직원MM<span class="requiredAttr">*</span></th>
				<td><input type="text" name="pj_sqi_mm" id="pj_sqi_mm" class="pj_mm" value="${projectVO.pj_sqi_mm }" style="text-align:right;">
				</td>
			</tr>
			<tr>
				<th>추정외주MM<span class="requiredAttr">*</span></th>
				<td><input type="text" name="pj_out_mm" id="pj_out_mm" class="pj_mm" value="${projectVO.pj_out_mm}" style="text-align:right;">
				</td>
			</tr>
			<tr>
				<th>총 MM</th>
				<td id="mmResult">${projectVO.pj_out_mm + projectVO.pj_sqi_mm}</td>
			</tr>
		</table>
			
		<table class="inputbordered" style="margin-top: 5px;">
			<tr>
				<th>금년 매출액</th>
				<td id="pj_year_sales"><fmt:formatNumber type="number" pattern="#,###" value="${projectVO.pj_year_sales }"/></td>
			</tr>
			<tr>
				<th>계약액</th>
				<td><fmt:formatNumber type="number" pattern="#,###" value="${projectVO.pj_amount }" /></td>
			</tr>
			<tr>
				<th>상품비<span class="requiredAttr">*</span></th>
				<td><input type="text" name="pj_matl_cost" id="pj_matl_cost" value="${projectVO.pj_matl_cost }" 
							onkeyup="num_onlyAndComma(this)" style="text-align:right;"></td>
			</tr>
			<tr>
				<th>외주비</th>
				<td id="pj_outsrc_cost">${projectVO.pj_outsrc_cost }</td>
			</tr>
			<tr>
				<th>순매출</th>
				<td id="netSales"></td>
			</tr>
			<tr>
				<th>인건비</th>
				<td id="pjPersonnelCost"></td>
			</tr>
			<tr>
				<th>직접경비</th>
				<td id="pjDirectCost"></td>
			</tr>
			<tr>
				<th>추가경비<span class="requiredAttr">*</span></th>
				<td><input type="text" name="pj_extra_cost" id="pj_extra_cost" value="${projectVO.pj_extra_cost }" 
							onkeyup="num_onlyAndComma(this)" style="text-align:right;"></td>
			</tr>
			<tr>
				<th>영업손익</th>
				<td id="salesProfit"></td>
			</tr>
		</table>
		
		<!-- 외주비 -->
		<input type="hidden" id="outsrc_cost" name="pj_outsrc_cost" >
	</form:form>
	
		
	<!-- 기본경비율 -->
	<input type="hidden" id="tm_expnc_rate" value="${teamVO.tm_expnc_rate }" />  
	
	<!-- 팀 직원 mm 단가 -->
	<input type="hidden" id="tm_sqi_mm_cost" value="${teamVO.tm_sqi_mm_cost }" />
	
	<!-- 팀 외주 mm 단가 -->
	<input type="hidden" id="tm_out_mm_cost" value="${teamVO.tm_out_mm_cost }" />
		
	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine">
				<span id="pjProfitAndLossModifyBtn">저장</span> 
				<span id="pjProfitAndLossDeleteBtn" style="visibility: hidden;">삭제</span> 
				<span id="pjProfitAndLossResetBtn">비우기</span>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
</html>