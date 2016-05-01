<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/excelExport.js" type="text/javascript"></script>

<script>
	$(window).ready(function() {
		var d = new Date();
		var filename=d.getFullYear()+"년"+(d.getMonth() + 1)+"월"+d.getDate()+"일"+"총괄표";

		$("#excelExport").click(function(){
			getExcel($("#totalchart"),filename);
		});
		//TODO
		setNav(0, 0);
	});
</script>
</head>
<body>
	<!-- Top Navigation : 로그인 -->
	<jsp:include page="./common/login_header_mini.jsp"></jsp:include>
	<div style="clear: right;"></div>
	
	<div class="container">
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">총괄표</h1>
		
		<span id="spanSubNameLeft">
		※ 참고사항 : 매출원가 미배치 인건비 미반영
		<fmt:formatNumber value="${vo.no_place_cost}" pattern="#,###" /> 천원  </span>
		<span id="spanSubNameLeft">
		=> 매출원가 미배치 인건비 반영 시 영업이익 : 
		<fmt:formatNumber value="${vo.sum_ebit-vo.no_place_cost}" pattern="#,###" /> 천원  </span>
		<span id="spanSubNameRight">단위 : [천원]</span>
		<button id="ExcelExport" value="Excel" style="background: transparent; border: none;">
			<img class="logo_img" src="/resources/images/Excel_2013_logo.png" style="width:15px;height:15px" />
		</button>
		<div id="chart">
	<table id="total" class="bordered" style="width:1600px;">

			<thead>
				<tr>
					<th rowspan="3">부서명</th>
					<th rowspan="3">구분</th>
					<th rowspan="3">계약금액</th>
					<th rowspan="3">매출액</th>
					<th rowspan="3">순매출액</th>
					<th rowspan="3">영업이익</th>
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
				<tr bgcolor="#FFFF99" style='font-weight:bold;'>
					<!-- 합계  -->
					<th class="odd" rowspan="4">합계</th>
					<th>추정실적 [A]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber value="${vo.sum_contract_cost}"
							pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.sum_income}"
							pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber value="${vo.sum_ebit}"
							pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_sales_cost}" pattern="#,###" /></td>
					<!-- 인건비합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_empl_cost_tot}" pattern="#,###" /></td>
					<!-- pj 직접  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_empl_cost_sqi + vo.sum_empl_cost_wait}" pattern="#,###" /></td>
					<!-- 영업인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_empl_cost_sales}" pattern="#,###" /></td>
					<!-- 지원인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_empl_cost_comm}" pattern="#,###" /></td>
					<!-- 외주인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_empl_cost_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_product_cost}" pattern="#,###" /></td>
					<!-- 경비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_normal_cost}" pattern="#,###" /></td>
				</tr>

				<tr>
					<th>목표 [B]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_team_vo.team_contract}" pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_team_vo.team_income}" pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_team_vo.team_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_team_vo.team_ebit}" pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_team_vo.team_net_income_bep}" pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_team_vo.team_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_team_vo.team_product}" pattern="#,###" /></td>
					<td></td>
				</tr>

				<tr>
					<th>달성률</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_contract_cost / vo.sum_team_vo.team_contract}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_income /vo.sum_team_vo.team_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 순매출액 -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_net_income/ vo.sum_team_vo.team_net_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_ebit /vo.sum_team_vo.team_ebit}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_sales_cost /vo.sum_team_vo.team_net_income_bep}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.sum_empl_cost_outsource /vo.sum_team_vo.team_outsource}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<th>차이 [A-B]</th>
					<td align="right"><fmt:formatNumber
							value="${vo.sum_contract_cost - vo.sum_team_vo.team_contract}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.sum_income - vo.sum_team_vo.team_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.sum_net_income - vo.sum_team_vo.team_net_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.sum_ebit - vo.sum_team_vo.team_ebit}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.sum_sales_cost - vo.sum_team_vo.team_net_income_bep}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td align="right"><fmt:formatNumber
							value="${vo.sum_empl_cost_outsource - vo.sum_team_vo.team_outsource}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr bgcolor="#FFFF99" style='font-weight:bold;'>
					<!-- S1  -->
					<th class="odd" rowspan="4">SI사업팀</th>
					<th>추정실적 [A]</th>
					<!-- 계약금액  -->
					<td align="right"> <fmt:formatNumber value="${vo.s1_contract_cost}"
							pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.s1_income}"
							pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber value="${vo.s1_ebit}"
							pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_sales_cost}" pattern="#,###" /></td>
					<!-- 인건비합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_empl_cost_tot}" pattern="#,###" /></td>
					<!-- pj 직접  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_empl_cost_sqi + vo.s1_empl_cost_wait}" pattern="#,###" /></td>
					<!-- 영업인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_empl_cost_sales}" pattern="#,###" /></td>
					<!-- 지원인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_empl_cost_comm}" pattern="#,###" /></td>
					<!-- 외주인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_empl_cost_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_product_cost}" pattern="#,###" /></td>
					<!-- 경비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_normal_cost}" pattern="#,###" /></td>
				</tr>

				<tr>
					<th>목표 [B]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_team_vo.team_contract}" pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_team_vo.team_income}" pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_team_vo.team_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_team_vo.team_ebit}" pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_team_vo.team_net_income_bep}" pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_team_vo.team_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_team_vo.team_product}" pattern="#,###" /></td>
					<td></td>
				</tr>

				<tr>
					<th>달성률</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_contract_cost / vo.s1_team_vo.team_contract}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_income /vo.s1_team_vo.team_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 순매출액 -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_net_income/ vo.s1_team_vo.team_net_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_ebit /vo.s1_team_vo.team_ebit}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_sales_cost /vo.s1_team_vo.team_net_income_bep}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s1_empl_cost_outsource /vo.s1_team_vo.team_outsource}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<th>차이 [A-B]</th>
					<td align="right"><fmt:formatNumber
							value="${vo.s1_contract_cost - vo.s1_team_vo.team_contract}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s1_income - vo.s1_team_vo.team_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s1_net_income - vo.s1_team_vo.team_net_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s1_ebit - vo.s1_team_vo.team_ebit}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s1_sales_cost - vo.s1_team_vo.team_net_income_bep}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s1_empl_cost_outsource - vo.s1_team_vo.team_outsource}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr bgcolor="#FFFF99" style='font-weight:bold;'>
					<!-- S2  -->
					<th class="odd" rowspan="4">커머스사업팀</th>
					<th>추정실적 [A]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber value="${vo.s2_contract_cost}"
							pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.s2_income}"
							pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber value="${vo.s2_ebit}"
							pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_sales_cost}" pattern="#,###" /></td>
					<!-- 인건비합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_empl_cost_tot}" pattern="#,###" /></td>
					<!-- pj 직접  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_empl_cost_sqi + vo.s2_empl_cost_wait}" pattern="#,###" /></td>
					<!-- 영업인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_empl_cost_sales}" pattern="#,###" /></td>
					<!-- 지원인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_empl_cost_comm}" pattern="#,###" /></td>
					<!-- 외주인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_empl_cost_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_product_cost}" pattern="#,###" /></td>
					<!-- 경비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_normal_cost}" pattern="#,###" /></td>
					</tr>

					<tr>
					<th>목표 [B]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_team_vo.team_contract}" pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_team_vo.team_income}" pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_team_vo.team_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_team_vo.team_ebit}" pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_team_vo.team_net_income_bep}" pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_team_vo.team_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_team_vo.team_product}" pattern="#,###" /></td>
					<td></td>
				</tr>

				<tr>
					<th>달성률</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_contract_cost / vo.s2_team_vo.team_contract}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_income /vo.s2_team_vo.team_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 순매출액 -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_net_income/ vo.s2_team_vo.team_net_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_ebit /vo.s2_team_vo.team_ebit}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_sales_cost /vo.s2_team_vo.team_net_income_bep}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.s2_empl_cost_outsource /vo.s2_team_vo.team_outsource}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<th>차이 [A-B]</th>
					<td align="right"><fmt:formatNumber
							value="${vo.s2_contract_cost - vo.s2_team_vo.team_contract}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s2_income - vo.s2_team_vo.team_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s2_net_income - vo.s2_team_vo.team_net_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s2_ebit - vo.s2_team_vo.team_ebit}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s2_sales_cost - vo.s2_team_vo.team_net_income_bep}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td align="right"><fmt:formatNumber
							value="${vo.s2_empl_cost_outsource - vo.s2_team_vo.team_outsource}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr bgcolor="#FFFF99" style='font-weight:bold;'>
					<!-- 에너지팀  -->
					<th class="odd" rowspan="4">에너지사업팀</th>
					<th>추정실적 [A]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber value="${vo.e_contract_cost}"
							pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.e_income}"
							pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.e_net_income}"
							pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber value="${vo.e_ebit}"
							pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber value="${vo.e_sales_cost}"
							pattern="#,###" /></td>
					<!-- 인건비합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_empl_cost_tot}" pattern="#,###" /></td>
					<!-- pj 직접  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_empl_cost_sqi + vo.e_empl_cost_wait}" pattern="#,###" /></td>
					<!-- 영업인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_empl_cost_sales}" pattern="#,###" /></td>
					<!-- 지원인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_empl_cost_comm}" pattern="#,###" /></td>
					<!-- 외주인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_empl_cost_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_product_cost}" pattern="#,###" /></td>
					<!-- 경비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_normal_cost}" pattern="#,###" /></td>
					</tr>

					<tr>
					<th>목표 [B]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_team_vo.team_contract}" pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_team_vo.team_income}" pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_team_vo.team_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_team_vo.team_ebit}" pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_team_vo.team_net_income_bep}" pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_team_vo.team_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_team_vo.team_product}" pattern="#,###" /></td>
					<td></td>
				</tr>

				<tr>
					<th>달성률</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_contract_cost / vo.e_team_vo.team_contract}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_income /vo.e_team_vo.team_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 순매출액 -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_net_income/ vo.e_team_vo.team_net_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_ebit /vo.e_team_vo.team_ebit}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_sales_cost /vo.e_team_vo.team_net_income_bep}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.e_empl_cost_outsource /vo.e_team_vo.team_outsource}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<th>차이 [A-B]</th>
					<td align="right"><fmt:formatNumber
							value="${vo.e_contract_cost - vo.e_team_vo.team_contract}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.e_income - vo.e_team_vo.team_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.e_net_income - vo.e_team_vo.team_net_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.e_ebit - vo.e_team_vo.team_ebit}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.e_sales_cost - vo.e_team_vo.team_net_income_bep}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td align="right"><fmt:formatNumber
							value="${vo.e_empl_cost_outsource - vo.e_team_vo.team_outsource}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr bgcolor="#FFFF99" style='font-weight:bold;'>
					<!-- 보안사업팀  -->
					<th class="odd" rowspan="4">보안사업팀</th>
					<th>추정실적 [A]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber value="${vo.n_contract_cost}"
							pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.n_income}"
							pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.n_net_income}"
							pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber value="${vo.n_ebit}"
							pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber value="${vo.n_sales_cost}"
							pattern="#,###" /></td>
					<!-- 인건비합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_empl_cost_tot}" pattern="#,###" /></td>
					<!-- pj 직접  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_empl_cost_sqi + vo.n_empl_cost_wait}" pattern="#,###" /></td>
					<!-- 영업인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_empl_cost_sales}" pattern="#,###" /></td>
					<!-- 지원인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_empl_cost_comm}" pattern="#,###" /></td>
					<!-- 외주인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_empl_cost_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_product_cost}" pattern="#,###" /></td>
					<!-- 경비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_normal_cost}" pattern="#,###" /></td>
				</tr>

				<tr>
					<th>목표 [B]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_team_vo.team_contract}" pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_team_vo.team_income}" pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_team_vo.team_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_team_vo.team_ebit}" pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_team_vo.team_net_income_bep}" pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_team_vo.team_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_team_vo.team_product}" pattern="#,###" /></td>
					<td></td>
				</tr>

				<tr>
					<th>달성률</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_contract_cost / vo.n_team_vo.team_contract}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_income /vo.n_team_vo.team_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 순매출액 -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_net_income/ vo.n_team_vo.team_net_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_ebit /vo.n_team_vo.team_ebit}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_sales_cost /vo.n_team_vo.team_net_income_bep}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.n_empl_cost_outsource /vo.n_team_vo.team_outsource}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<th>차이 [A-B]</th>
					<td align="right"><fmt:formatNumber
							value="${vo.n_contract_cost - vo.n_team_vo.team_contract}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.n_income - vo.n_team_vo.team_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.n_net_income - vo.n_team_vo.team_net_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.n_ebit - vo.n_team_vo.team_ebit}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.n_sales_cost - vo.n_team_vo.team_net_income_bep}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td align="right"><fmt:formatNumber
							value="${vo.n_empl_cost_outsource - vo.n_team_vo.team_outsource}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr bgcolor="#FFFF99" style='font-weight:bold;'>
					<!-- DS사업팀  -->
					<th class="odd" rowspan="4">미디어사업팀</th>
					<th>추정실적 [A]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber value="${vo.d_contract_cost}"
							pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.d_income}"
							pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.d_net_income}"
							pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber value="${vo.d_ebit}"
							pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber value="${vo.d_sales_cost}"
							pattern="#,###" /></td>
					<!-- 인건비합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_empl_cost_tot}" pattern="#,###" /></td>
					<!-- pj 직접  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_empl_cost_sqi + vo.d_empl_cost_wait}" pattern="#,###" /></td>
					<!-- 영업인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_empl_cost_sales}" pattern="#,###" /></td>
					<!-- 지원인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_empl_cost_comm}" pattern="#,###" /></td>
					<!-- 외주인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_empl_cost_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_product_cost}" pattern="#,###" /></td>
					<!-- 경비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_normal_cost}" pattern="#,###" /></td>
				</tr>

				<tr>
					<th>목표 [B]</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_team_vo.team_contract}" pattern="#,###" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_team_vo.team_income}" pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_team_vo.team_net_income}" pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_team_vo.team_ebit}" pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_team_vo.team_net_income_bep}" pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_team_vo.team_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_team_vo.team_product}" pattern="#,###" /></td>
					<td></td>
				</tr>

				<tr>
					<th>달성률</th>
					<!-- 계약금액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_contract_cost / vo.d_team_vo.team_contract}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_income /vo.d_team_vo.team_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 순매출액 -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_net_income/ vo.d_team_vo.team_net_income}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_ebit /vo.d_team_vo.team_ebit}"
							type="percent" maxIntegerDigits="3" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_sales_cost /vo.d_team_vo.team_net_income_bep}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<!-- 외주비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.d_empl_cost_outsource /vo.d_team_vo.team_outsource}"
							type="percent" maxIntegerDigits="3" /></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<th>차이 [A-B]</th>
					<td align="right"><fmt:formatNumber
							value="${vo.d_contract_cost - vo.d_team_vo.team_contract}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.d_income - vo.d_team_vo.team_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.d_net_income - vo.d_team_vo.team_net_income}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.d_ebit - vo.d_team_vo.team_ebit}"
							pattern="#,###" /></td>
					<td align="right"><fmt:formatNumber
							value="${vo.d_sales_cost - vo.d_team_vo.team_net_income_bep}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td align="right"><fmt:formatNumber
							value="${vo.d_empl_cost_outsource - vo.d_team_vo.team_outsource}"
							pattern="#,###" /></td>
					<td></td>
					<td></td>
				</tr>
				
				<tr bgcolor="#FFFF99" style='font-weight:bold;'>
					<!-- 전사 공통  -->
					<th class="odd" rowspan="4">기타</th>
					<th>추정실적 [A]</th>
					<!-- 계약금액  -->
					<td align="right"></td>
					<!-- 매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.c_income}"
							pattern="#,###" /></td>
					<!-- 순매출액  -->
					<td align="right"><fmt:formatNumber value="${vo.c_net_income}"
							pattern="#,###" /></td>
					<!-- 영업이익  -->
					<td align="right"><fmt:formatNumber value="${vo.c_ebit}"
							pattern="#,###" /></td>
					<!-- 매출원가합계  -->
					<td align="right"><fmt:formatNumber value="${vo.c_sales_cost}"
							pattern="#,###" /></td>
					<!-- 인건비합계  -->
					<td align="right"></td>
					<!-- pj 직접  -->
					<td align="right"></td>
					<!-- 영업인건비  -->
					<td align="right"></td>
					<!-- 지원인건비  -->
					<td align="right"></td>
					<!-- 외주인건비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.c_empl_cost_outsource}" pattern="#,###" /></td>
					<!-- 상품비  -->
					<td align="right"></td>
					<!-- 경비  -->
					<td align="right"><fmt:formatNumber
							value="${vo.c_normal_cost}" pattern="#,###" /></td>
				</tr>
				
			</tbody>
		</table>
		</div>
		</section>
	</div>
	
	<!-- 바닥 -->
	<div class="footerDiv">
		<jsp:include page="./common/footer.jsp"></jsp:include>
	</div>
</body>
</html>