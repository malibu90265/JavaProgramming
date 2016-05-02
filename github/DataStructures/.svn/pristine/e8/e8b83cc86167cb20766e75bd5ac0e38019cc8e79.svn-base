<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>프로젝트 예산관리</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/project_css/pjBudget-list-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src='<c:url value="/resources/js/project/pjBudget.js"/>'></script>
</head>
<body>
	<div class="container" style="margin-left : 30px;">
		<section class="contents">
			<h1 class="contentsPopupTitle">프로젝트 예산 변경 내역</h1>
			<div id="pjBudgetHistoryList">
					<table class="pjIdbordered">
						<tr>
							<td>프로젝트 ID</td>
							<td bgcolor="white">${pj_id}</td>
						</tr>
				</table>
			</div>
			<div style=" float: left;">
					<table class="pjbordered">	
						<tr>
							<th class="pb_no">예산번호</th>
						</tr>
						<tr>
							<th class="pb_date">예산등록일</th>
						</tr>
					</table>
					<table class="pjbordered">
						<tr>
							<th class="pb_start_date">PJ시작일</th>
						</tr>
						<tr>
							<th class="pb_end_date">PJ종료일</th>
						</tr>
						<tr>
							<th class="pb_put_num">투입인원수</th>
						</tr>
						<tr>
							<th class="pb_sqi_mm">직원 MM</th>
						</tr>
						<tr>
							<th class="pb_out_mm">외주 MM</th>
						</tr>
						<tr>
							<th class="pb_total_mm">총 MM</th>
						</tr>
					</table>
					<table class="pjbordered">
						<tr>
							<th class="pb_sales">매출액</th>
						</tr>
						<tr>
							<th class="pb_matl_cost">상품비</th>
						</tr>
						<tr>
							<th class="pb_outsrc_cost">외주비</th>
						</tr>
						<tr>
							<th class="pb_basic_cost">순매출</th>
						</tr>
						<tr>
							<th class="pb_labor_cost">인건비</th>
						</tr>
						<tr>
							<th class="pb_self_cost">직접경비</th>
						</tr>
						<tr>
							<th class="pb_extra_cost">추가경비</th>
						</tr>
						<tr>
							<th class="pb_outsrc_cost">영업이익</th>
						</tr>
					</table>
			</div>
				<c:forEach var="pjList" items="${pjBudgetList}" varStatus="status">
				<div style=" float: left;">
					<table class="popupbordered" >
						<tr>
							<th>${pjList.pb_no}</th>
						</tr>
						<tr>
							<th>${pjList.pb_date}</th>
						</tr>
					</table>
					<table class="popupbordered">	
						<tr>
							<th>${pjList.pb_start_date}</th>
						</tr>
						<tr>
							<th>${pjList.pb_end_date}</th>
						</tr>
						<tr>
							<th align="right" id="pb_put_num">${pjList.pb_put_num}</th>
						</tr>
						<tr>
							<th align="right" id="pb_sqi_mm">${pjList.pb_sqi_mm}</th>
						</tr>
						<tr>
							<th align="right" id="pb_out_mm">${pjList.pb_out_mm}</th>
						</tr>
						<tr>
							<td align="right" id="mmResult">${pjList.mmResult}</td>
						</tr>
					</table>
					<table class="popupbordered">
						<tr>
							<th align="right" id="pb_sales"><fmt:formatNumber pattern = "#,###" value = "${pjList.pb_sales}"/> </th>
						</tr>
						<tr>
							<th align="right" id="pb_matl_cost"><fmt:formatNumber pattern = "#,###" value = "${pjList.pb_matl_cost}"/> </th>
						</tr>
						<tr>
							<th align="right" id="pb_outsrc_cost"><fmt:formatNumber pattern = "#,###" value = "${pjList.pb_outsrc_cost}"/> </th>
						</tr>
						<tr>
							<th align="right" id="netSales"><fmt:formatNumber pattern = "#,###" value = "${pjList.netSales}"/></th>
						</tr>
						<tr>
							<th align="right" id="pb_labor_cost"><fmt:formatNumber pattern = "#,###" value = "${pjList.pb_labor_cost}"/> </th>
						</tr>
						<tr>
							<th align="right" id="pjDirectCost"><fmt:formatNumber pattern = "#,###" value = "${pjList.pjDirectCost}"/></th>
						</tr>
						<tr>
							<th align="right" id="pb_extra_cost"><fmt:formatNumber pattern = "#,###" value = "${pjList.pb_extra_cost}"/> </th>
						</tr>
						<tr>
							<th align="right" id="salesProfit"><fmt:formatNumber pattern = "#,###" value = "${pjList.salesProfit}"/></th>
						</tr>
					</table>
				</div>
			</c:forEach>
		</section>
	</div>
</body>
</html>