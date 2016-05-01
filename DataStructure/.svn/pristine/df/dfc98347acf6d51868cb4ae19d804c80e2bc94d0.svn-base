<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
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

<script type="text/javascript">
	function changeFunc() {
		var formData = document.userForm;
		formData.action = "weekend.do";
		formData.submit();
	}
</script>
<script>
	$(window).ready(function() {
		var d = new Date();
		var filename=d.getFullYear()+"년"+(d.getMonth() + 1)+"월"+d.getDate()+"일"+"전주대비표";

		$("#ExcelExport").click(function(){
			getExcel($("#weekendchart"),filename);
		});
		//TODO
		setNav(0, 1);
	});
</script>
</head>
<body>
	<!-- Top Navigation : 로그인 -->
	<jsp:include page="./common/login_header_mini.jsp"></jsp:include>
	<div style="clear: right;"></div>
	
	<div class="container">
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">전주 대비표</h1>
			<div id="history">
				 <form name="userForm" method="post">
				 <!-- *********** 검색 폼 변경합니다~ -->
				 <table class="search">
				 	<tr>
				 		<th>검색</th>
				 		<td>
				 			<select name="wb_date" id="wb_date" onchange="changeFunc();">
								<c:forEach items="${requestScope.date_list}" var="date">
									<option <c:if test="${wb_date eq date}"> selected </c:if>
									value="${date}">${date}
								</c:forEach>
							</select>
				 		</td>
				 	</tr>
				 </table>
				</form>
			</div>
			<div id="topDiv">
				<!-- 제목 및 엑셀 -->
				<span id="spanSubNameLeft">1.손익변동</span>
				<span id="spanSubNameRight">단위 : [천원]</span>
				<button id="ExcelExport" value="Excel" >
					<img class="logo_img" src="/resources/images/Excel_2013_logo.png" />
				</button>
				
				<div id="chart">
				<div style="clear: both"></div>
				
				<div id="first">
				<table class="bordered" style="width: 1600px;">
					<thead>
						<tr>
							<th rowspan="2">부서명</th>
							<th colspan="4">차이</th>
							<th colspan="4">현재 기준 (${vo.current_s1.wb_date})</th>
							<th colspan="4">전주 기준 (${vo.last_s1.wb_date})</th>
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
						<tr bgcolor="#FFFF99" style='font-weight:bold;'>
							<th>합계</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_contract - vo.last_tot.wb_contract }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_income - vo.last_tot.wb_income }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_netincome - vo.last_tot.wb_netincome }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_ebit - vo.last_tot.wb_ebit }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_ebit}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_tot.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_tot.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_tot.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_tot.wb_ebit}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>SI사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_contract - vo.last_s1.wb_contract }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_income - vo.last_s1.wb_income }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_netincome - vo.last_s1.wb_netincome }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_ebit - vo.last_s1.wb_ebit }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_ebit}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_s1.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s1.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s1.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s1.wb_ebit}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>커머스사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_contract - vo.last_s2.wb_contract }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_income - vo.last_s2.wb_income }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_netincome - vo.last_s2.wb_netincome }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_ebit - vo.last_s2.wb_ebit }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_ebit}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_s2.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s2.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s2.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s2.wb_ebit}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>에너지사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_contract - vo.last_e.wb_contract }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_income - vo.last_e.wb_income }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_netincome - vo.last_e.wb_netincome }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_ebit - vo.last_e.wb_ebit }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_ebit}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_e.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_e.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_e.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_e.wb_ebit}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>보안사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_contract - vo.last_n.wb_contract }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_income - vo.last_n.wb_income }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_netincome - vo.last_n.wb_netincome }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_ebit - vo.last_n.wb_ebit }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_ebit}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_n.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_n.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_n.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_n.wb_ebit}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>미디어사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_contract - vo.last_d.wb_contract }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_income - vo.last_d.wb_income }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_netincome - vo.last_d.wb_netincome }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_ebit - vo.last_d.wb_ebit }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_ebit}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_d.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_d.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_d.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_d.wb_ebit}" pattern="#,###" /></td>
						</tr>
						
						<tr>
							<th>기타</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_contract - vo.last_c.wb_contract }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_income - vo.last_c.wb_income }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_netincome - vo.last_c.wb_netincome }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_ebit - vo.last_c.wb_ebit }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_ebit}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_c.wb_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_c.wb_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_c.wb_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_c.wb_ebit}" pattern="#,###" /></td>
						</tr>

					</tbody>
				</table>
				<br> <br>
			</div>
			
			<div id="second">
				<span id="spanSubNameLeft">2.비용(매출원가)변동</span>
				<span id="spanSubNameRight">단위 : [천원]</span>
				<table class="bordered" style="width: 1600px;">
					<thead>
						<tr>
							<th rowspan="2">부서명</th>
							<th colspan="4">차이</th>
							<th colspan="4">현재 기준</th>
							<th colspan="4">전주 기준</th>
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
						<tr bgcolor="#FFFF99" style='font-weight:bold;'>
							<th>합계</th>
							<!-- 차이  -->
							<!-- 총매출원가  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_sales_cost - vo.last_tot.wb_sales_cost }"
									pattern="#,###" /></td>
							<!-- 인건비  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_sal - vo.last_tot.wb_sal }"
									pattern="#,###" /></td>
							<!-- 상품비  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_product - vo.last_tot.wb_product }"
									pattern="#,###" /></td>
							<!-- 경비  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_charge - vo.last_tot.wb_charge }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_tot.wb_charge}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_tot.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_tot.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_tot.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_tot.wb_charge}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>SI사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_sales_cost - vo.last_s1.wb_sales_cost }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_sal - vo.last_s1.wb_sal }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_product - vo.last_s1.wb_product }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_charge - vo.last_s1.wb_charge }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s1.wb_charge}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_s1.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s1.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s1.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s1.wb_charge}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>커머스사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_sales_cost - vo.last_s2.wb_sales_cost }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_sal - vo.last_s2.wb_sal }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_product - vo.last_s2.wb_product }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_charge - vo.last_s2.wb_charge }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_s2.wb_charge}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_s2.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s2.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s2.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_s2.wb_charge}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>에너지사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_sales_cost - vo.last_e.wb_sales_cost }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_sal - vo.last_e.wb_sal }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_product - vo.last_e.wb_product }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_charge - vo.last_e.wb_charge }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_e.wb_charge}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_e.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_e.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_e.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_e.wb_charge}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>보안사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_sales_cost - vo.last_n.wb_sales_cost }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_sal - vo.last_n.wb_sal }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_product - vo.last_n.wb_product }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_charge - vo.last_n.wb_charge }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_n.wb_charge}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_n.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_n.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_n.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_n.wb_charge}" pattern="#,###" /></td>
						</tr>

						<tr>
							<th>미디어사업팀</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_sales_cost - vo.last_d.wb_sales_cost }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_sal - vo.last_d.wb_sal }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_product - vo.last_d.wb_product }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_charge - vo.last_d.wb_charge }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_d.wb_charge}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_d.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_d.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_d.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_d.wb_charge}" pattern="#,###" /></td>
						</tr>
						
						
						<tr>
							<th>기타</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_sales_cost - vo.last_c.wb_sales_cost }"
									pattern="#,###" /></td>
							<!-- 매출액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_sal - vo.last_c.wb_sal }"
									pattern="#,###" /></td>
							<!-- 순매춣액  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_product - vo.last_c.wb_product }"
									pattern="#,###" /></td>
							<!-- 영업이익  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_charge - vo.last_c.wb_charge }"
									pattern="#,###" /></td>
							<!-- 현재  -->
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.current_c.wb_charge}" pattern="#,###" /></td>
							<!-- 전주  -->
							<td align="right"><fmt:formatNumber
									value="${vo.last_c.wb_sales_cost}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_c.wb_sal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_c.wb_product}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${vo.last_c.wb_charge}" pattern="#,###" /></td>
						</tr>
						

					</tbody>

				</table>
				<br> <br>
			</div>
			
			<div id="third">
				<span id="spanSubNameLeft">3.손익 변동 내역</span>
				<table class="bordered" style="width: 1600px;">
					<thead>
						<tr>
							<th>팀&nbsp;&nbsp;명</th>
							<th>프로젝트 ID</th>
							<th>이전 상태</th>
							<th>이후 상태</th>
							<th>계약액</th>
							<th>매출액</th>
							<th>순매출액</th>
							<th>영업이익</th>
							<th>수정자</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${requestScope.list}" var="weekend">
						<tr>
							<th>${weekend.team_name}</th>
							<td align="center">${weekend.pj_id}</td>
							<td align="center">${weekend.pre_state}</td>
							<td align="center">${weekend.post_state}</td>
							<td align="center"><fmt:formatNumber
									value="${weekend.week_contract}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${weekend.week_income}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${weekend.week_netincome}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${weekend.week_ebit}" pattern="#,###" /></td>
							<td align="right">${weekend.empl_id}</td>
							<td align="center">${weekend.timestamp}</td>
						</tr>
					</c:forEach>
				</table>
			
			</div>
		</div>
			</div>
		</section>
	</div>
	<div style="clear:inherit;"></div>
	<div class="footerDiv">
		<jsp:include page="./common/footer.jsp"></jsp:include>
	</div>
</body>
</html>