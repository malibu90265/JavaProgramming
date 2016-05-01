<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		$(document).ready(function() {
			var d = new Date();
			var filename = d.getFullYear() + "년" + (d.getMonth() + 1) + "월"
					+ d.getDate() + "일(" + $("#wr_date").val() + " 주) " + "전주대비표";

			$("#ExcelExport").click(function() {
				getExcel($("#chart"), filename);
			});
		});
	</script>
</head>
<body>
	<div id="chart">
		<div>
			<button id="ExcelExport" value="Excel" style="background: transparent; border: none; float: right; clear: both;">
				<img class="logo_img" src="/resources/images/Excel_2013_logo.png" style="width: 15px; height: 15px" />
			</button>
		</div>
		<!-- 손익변동 -->
		<h4>1.손익변동</h4>
		<table class="bordered">
			<thead>
				<tr>
					<th rowspan="2">부서명</th>
					<th colspan="4">차이</th>
					<th colspan="4">현재 기준 (${presentWeek})</th>
					<th colspan="4">전주 기준 (${lastWeek})</th>
				</tr>
				<tr>
					<th>계약액</th>
					<th>매출액</th>
					<th>순매출액</th>
					<th>영업이익</th>
					<th>계약액</th>
					<th>매출액</th>
					<th>순매출액</th>
					<th>영업이익</th>
					<th>계약액</th>
					<th>매출액</th>
					<th>순매출액</th>
					<th>영업이익</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="key" items="${totalWeekReportList.keySet() }">
					<tr>
						<th>${key }</th>
						<!-- 차이  -->
						<!-- 계약금  -->
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getDifferenceWeekReportVO().totalContract }"
								pattern="#,###" /></td>
						<!-- 매출액  -->
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getDifferenceWeekReportVO().yearSales }"
								pattern="#,###" /></td>
						<!-- 순매춣액  -->
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getDifferenceWeekReportVO().netSales }"
								pattern="#,###" /></td>
						<!-- 영업이익  -->
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getDifferenceWeekReportVO().profitSales }"
								pattern="#,###" /></td>
						<!-- 현재  -->
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getPresentWeekReportVO().totalContract}" pattern="#,###" /></td>
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getPresentWeekReportVO().yearSales}" pattern="#,###" /></td>
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getPresentWeekReportVO().netSales}" pattern="#,###" /></td>
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getPresentWeekReportVO().profitSales}" pattern="#,###" /></td>
						<!-- 전주  -->
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getLastWeekReportVO().totalContract}" pattern="#,###" /></td>
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getLastWeekReportVO().yearSales}" pattern="#,###" /></td>
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getLastWeekReportVO().netSales}" pattern="#,###" /></td>
						<td><fmt:formatNumber
								value="${totalWeekReportList.get(key).getLastWeekReportVO().totalContract}" pattern="#,###" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h4>2.비용(매출원가)변동</h4>
		<table class="bordered">
			<thead>
				<tr>
					<th rowspan="2">부서명</th>
					<th colspan="4">차이</th>
					<th colspan="4">현재 기준(${presentWeek })</th>
					<th colspan="4">전주 기준(${lastWeek })</th>
				</tr>
				<tr>
					<th>총매출원가</th>
					<th>인건비</th>
					<th>상품비</th>
					<th>경비</th>
					<th>총매출원가</th>
					<th>인건비</th>
					<th>상품비</th>
					<th>경비</th>
					<th>총매출원가</th>
					<th>인건비</th>
					<th>상품비</th>
					<th>경비</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="key" items="${totalWeekReportList.keySet() }">
				<tr bgcolor="#FFFF99" style='font-weight:bold;'>
					<th>${key }</th>
					<!-- 차이  -->
					<!-- 총매출원가  -->
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getDifferenceWeekReportVO().totalSalesCost }"
							pattern="#,###" /></td>
					<!-- 인건비  -->
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getDifferenceWeekReportVO().totalLaborCost }"
							pattern="#,###" /></td>
					<!-- 상품비  -->
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getDifferenceWeekReportVO().totalMatlCost }"
							pattern="#,###" /></td>
					<!-- 경비  -->
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getDifferenceWeekReportVO().totalCost }"
							pattern="#,###" /></td>
					<!-- 현재  -->
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getPresentWeekReportVO().totalSalesCost}" pattern="#,###" /></td>
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getPresentWeekReportVO().totalLaborCost}" pattern="#,###" /></td>
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getPresentWeekReportVO().totalMatlCost}" pattern="#,###" /></td>
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getPresentWeekReportVO().totalCost}" pattern="#,###" /></td>
					<!-- 전주  -->
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getLastWeekReportVO().totalSalesCost}" pattern="#,###" /></td>
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getLastWeekReportVO().totalLaborCost}" pattern="#,###" /></td>
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getLastWeekReportVO().totalMatlCost}" pattern="#,###" /></td>
					<td><fmt:formatNumber
							value="${totalWeekReportList.get(key).getLastWeekReportVO().totalCost}" pattern="#,###" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<h4>3.손익 변동 내역</h4>
		<table class="bordered">
			<thead>
				<tr>
					<th>팀명</th>
					<th>프로젝트 ID</th>
					<th>이전 상태</th>
					<th>이후 상태</th>
					<th>계약액</th>
					<th>매출액</th>
					<th>순매출액</th>
					<th>영업이익</th>
					<th>수정일</th>
				</tr>
			</thead>
			<c:forEach items="${weekLogReportVO}" var="weekLog">
				<tr>
					<th>${weekLog.tm_id}</th>
					<td>${weekLog.pj_id}</td>
					<td>${weekLog.wl_before_st}</td>
					<td>${weekLog.wl_after_st}</td>
					<td><fmt:formatNumber value="${weekLog.wl_diff_contract}" pattern="#,###" /></td>
					<td><fmt:formatNumber value="${weekLog.wl_diff_sales}" pattern="#,###" /></td>
					<td><fmt:formatNumber value="${weekLog.wl_diff_netsales}" pattern="#,###" /></td>
					<td><fmt:formatNumber value="${weekLog.wl_diff_profit}" pattern="#,###" /></td>
					<td>${weekLog.wl_LMD}</td>
				</tr>
			</c:forEach>
		</table>
	</div>		
</body>
</html>
