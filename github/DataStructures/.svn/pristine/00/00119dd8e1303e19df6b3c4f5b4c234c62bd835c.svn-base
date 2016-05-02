<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>총괄표</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/total/total_chart.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main_css/demo.css"/>" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/excelExport.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script> 

<script>
	$(window).ready(function() {
		getMiniHeaderAjax();
		
		var d = new Date();
		var filename = d.getFullYear() + "년" + (d.getMonth() + 1) + "월"
				+ d.getDate() + "일" + "총괄표";

		$("#ExcelExport").click(function() {
			getExcel($("#chart"), filename);
		});
	});
</script>
</head>
<body>
	<div id="miniHeader" style="width: 100%;"></div>

	<div class="container">
		<section class="contents">
			<!-- TODO -->
			<h1 class="contentsTitle">총괄표</h1>

			<div id="chart">
				<div style="width: 90%; text-align: right;">
					<button id="ExcelExport" value="Excel" style="background: transparent; border: none;">
						<img class="logo_img" src="/resources/images/Excel_2013_logo.png" style="width: 15px; height: 15px" />
					</button>
				</div>
				<table id="total" class="bordered">
					<thead>
						<tr>
							<th rowspan="3">부서명</th>
							<th rowspan="3">구분</th>
							<th rowspan="3">계약금액</th>
							<th rowspan="3">매출액</th>
							<th rowspan="3">순매출액</th>
							<th bgcolor="#FFDEAE" rowspan="3" style='font-weight: bold;'>영업이익</th>
							<th colspan="8">매출원가</th>
						</tr>
						<tr>
							<th class="long" rowspan="2">소계</th>
							<th class="long" colspan="5">인건비</th>
							<th class="long" rowspan="2">상품비</th>
							<th class="long" rowspan="2">경비</th>
						</tr>
						<tr>
							<th class="sub">계</th>
							<th class="sub">직접(개발)</th>
							<th class="sub">영업</th>
							<th class="sub">지원</th>
							<th class="sub">외주</th>
						</tr>
					</thead>
					<tbody>
						<!-- 팀별 데이터 출력 -->
						<c:forEach var="key" items="${totalList.keySet()}">
							<tr bgcolor="#FFFF99" style='font-weight: bold;'>
								<th class="odd" rowspan="4">
									<!-- 팀 리스트 출력 -->
									${key}
								</th>
								<th>추정실적 [A]</th>
								<!-- 계약금액  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalContract}" pattern="#,###" /></td>
								<!-- 매출액  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().yearSales}" pattern="#,###" /></td>
								<!-- 순매출액  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().netSales}" pattern="#,###" /></td>
								<!-- 영업이익  -->
								<td bgcolor="#FFDEAE" align="right"><fmt:formatNumber value="${totalList.get(key).getEstimationResult().profitSales}"
										pattern="#,###" /></td>
								<!-- 매출원가합계  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalSalesCost}" pattern="#,###" /></td>
								<!-- 인건비합계  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalLaborCost}" pattern="#,###" /></td>
								<!-- pj 직접  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalDirectCost}"
										pattern="#,###" /></td>
								<!-- 영업인건비  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalSales}" pattern="#,###" /></td>
								<!-- 지원인건비  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalSupport}" pattern="#,###" /></td>
								<!-- 외주인건비  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalOutCost}" pattern="#,###" /></td>
								<!-- 상품비  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalMatlCost}" pattern="#,###" /></td>
								<!-- 경비  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getEstimationResult().totalCost}" pattern="#,###" /></td>
							</tr>
							<c:if test='${key ne "경영지원팀" }'>
							<tr>
								<th>목표 [B]</th>
								<!-- 계약금액  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getGoal().totalContract}" pattern="#,###" /></td>
								<!-- 매출액  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getGoal().yearSales}" pattern="#,###" /></td>
								<!-- 순매출액  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getGoal().netSales}" pattern="#,###" /></td>
								<!-- 영업이익  -->
								<td bgcolor="#FFDEAE" align="right"><fmt:formatNumber
										value="${totalList.get(key).getGoal().profitSales}" pattern="#,###" /></td>
								<!-- 매출원가합계  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getGoal().totalSalesCost}" pattern="#,###" /></td>
								<!-- 계  -->
								<td></td>
								<!-- 직접(개발)인건비  -->
								<td></td>
								<!-- 영업인건비  -->
								<td></td>
								<!-- 지원인건비  -->
								<td></td>
								<!-- 외주비  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getGoal().totalOutCost}" pattern="#,###" /></td>
								<!-- 상품비  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getGoal().totalMatlCost}" pattern="#,###" /></td>
								<td></td>
							</tr>
							<tr>
								<th>달성률</th>
								<!-- 계약금액  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getAchievementRate().totalContract}"
										pattern="#,###" />%</td>
								<!-- 매출액  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getAchievementRate().yearSales}"
										pattern="#,###" />%</td>
								<!-- 순매출액 -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getAchievementRate().netSales}"
										pattern="#,###" />%</td>
								<!-- 영업이익  -->
								<td bgcolor="#FFDEAE" align="right"><fmt:formatNumber
										value="${totalList.get(key).getAchievementRate().profitSales}"
										pattern="#,###" />%</td>
								<!-- 매출원가합계  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getAchievementRate().totalSalesCost}"
										pattern="#,###" />%</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<!-- 외주비  -->
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getAchievementRate().totalOutCost}"
										pattern="#,###" />%</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<th>차이 [A-B]</th>
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getDifferenceResult().totalContract}"
										pattern="#,###" /></td>
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getDifferenceResult().yearSales}"
										pattern="#,###" /></td>
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getDifferenceResult().netSales}"
										pattern="#,###" /></td>
								<td bgcolor="#FFDEAE" align="right"><fmt:formatNumber
										value="${totalList.get(key).getDifferenceResult().profitSales}"
										pattern="#,###" /></td>
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getDifferenceResult().totalSalesCost}"
										pattern="#,###" /></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td align="right"><fmt:formatNumber
										value="${totalList.get(key).getDifferenceResult().totalOutCost}"
										pattern="#,###" /></td>
								<td></td>
								<td></td>
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</div>
</body>
</html>