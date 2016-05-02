<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>팀별 손익정보</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/projectbudgetinfo.js" type="text/javascript"></script>
<script src="resources/js/excelExport.js" type="text/javascript"></script>

<style type="text/css">
.fuck td {
	border: 0;
}

.main_table {
	border: solid;
	border-color: #000000;
	border-collapse: collapse;
	border-width: 0px 0px 0px 0px;
	table-layout: fixed;
}

.main_table td {
	border: 1px solid grey;
}
</style>

<script type="text/javascript">
	$(window).ready(function() {
		//TODO
		setNav(1, 2);
	});
	function changeFunc() {
		var formData = document.userForm;
		formData.action = "projectBudgetinfo.iqspf";
		formData.submit();
	}

	function scrollX() {
		document.all.mainDisplayRock.scrollLeft = document.all.bottomLine.scrollLeft;
		document.all.topLine.scrollLeft = document.all.bottomLine.scrollLeft;
	}

	function scrollY() {
		document.all.leftDisplay.scrollTop = document.all.mainDisplayRock.scrollTop;
		document.all.mainDisplayRock.scrollTop = document.all.leftDisplay.scrollTop;
	}
</script>
</head>

<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">팀별 손익정보</h1>
		<div id="wrap" style="margin: auto;">
			<input id="outemp" type="hidden" value="">
			<form name="userForm" method="post">
				팀별 검색 : <select id="selectBox" name="team_id"
					onchange="changeFunc();">
					<option <c:if test="${team_id eq '1S'}"> selected </c:if>
						value="1S">SI사업팀</option>
					<option <c:if test="${team_id eq '2S'}"> selected </c:if>
						value="2S">커머스사업팀</option>
					<option <c:if test="${team_id eq '3E'}"> selected </c:if>
						value="3E">에너지사업팀</option>
					<option <c:if test="${team_id eq '4N'}"> selected </c:if>
						value="4N">보안사업팀</option>
					<option <c:if test="${team_id eq '5D'}"> selected </c:if>
						value="5D">미디어사업팀</option>
						<option <c:if test="${team_id eq '6C'}"> selected </c:if>
						value="6C">전사공통</option>
				</select>
				
				<input type="button" id="excelExport" value="Excel" style="margin-left: 20px;">
			</form>
			<p></p>
		</div>
		<div id="budget" style="height: 700px; margin-left: 160px;">
			<table class="fuck" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<!-- 위 왼쪽 테이블 -->
					<td>
						<TABLE width="150px" cellspacing="1" cellpadding="0" border="0"
							class="main_table">
							<tr>

								<th width="50px" height="65px" rowspan="3">상&nbsp;&nbsp;태</th>
								<th style="width: 100px" rowspan="3">프로젝트&nbsp;ID</th>
							</tr>
							<tr></tr>
							<tr></tr>
							<tr>
								<td bgcolor="#FFCCFF" height="21px"></td>
								<td bgcolor="#FFCCFF" height="21px"></td>
							</tr>

						</TABLE>
					</td>
					<!--위 오른쪽 테이블 -->
					<td>
						<DIV id="topLine" style="width: 1204px; overflow: hidden;">
							<TABLE class="main_table" width="1830px" cellspacing="1"
								cellpadding="0" border="0">
								<tr>
									<th style="width: 226px; border-left: 0;" rowspan="3 ">프로젝트&nbsp;명</th>
									<th style="width: 110px" rowspan="3">시&nbsp;작&nbsp;일</th>
									<th style="width: 110px" rowspan="3">완&nbsp;료&nbsp;일</th>
									<th style="width: 90px" rowspan="3">계&nbsp;약&nbsp;액</th>
									<th style="width: 90px" rowspan="3">매&nbsp;출&nbsp;액</th>
									<th style="width: 90px" rowspan="3">순매출액</th>
									<th style="width: 90px" rowspan="3">영업이익</th>
									<th width="823px" height="21px" colspan="9">매출원가</th>
									<th colspan="3">M/M</th>
								</tr>
								<tr>
									<th style="width: 90px;" rowspan="2">합계</th>
									<th height="21px" colspan="6">인건비</th>
									<th style="width: 90px" rowspan="2">상품비</th>
									<th style="width: 90px" rowspan="2">경비</th>
									<th style="width: 65px" rowspan="2">계</th>
									<th style="width: 65px" rowspan="2">직원</th>
									<th style="width: 65px" rowspan="2">외주</th>
								</tr>
								<tr>
									<th style="height: 21px; width: 90px">계</th>
									<th style="width: 90px">PJ직접</th>
									<th style="width: 90px">공통/대기</th>
									<th style="width: 90px">영업</th>
									<th style="width: 90px">지원</th>
									<th style="width: 90px">외주</th>
								</tr>
								<tr bgcolor="#FFCCFF" style='font-weight: bold;'>
									<td style="border-left: 0;" height="21px" colspan="3"
										align="center">합계</td>
									<c:set var="sum_contract_sales" value="0" />
									<c:set var="sum_pj_income" value="0" />
									<c:set var="sum_pj_net_income" value="0" />
									<c:set var="sum_ebit" value="0" />
									<c:set var="sum_budget_sales" value="0" />
									<c:set var="sum_empl_cost_tot" value="0" />
									<c:set var="sum_budget_sqi_cost" value="0" />
									<c:set var="sum_empl_cost_wait" value="0" />
									<c:set var="sum_empl_cost_sales" value="0" />
									<c:set var="sum_empl_cost_comm" value="0" />
									<c:set var="sum_budget_outsource_cost" value="0" />
									<c:set var="sum_budget_product_cost" value="0" />
									<c:set var="sum_budget_normal_cost" value="0" />
									<c:set var="sum_mm_tot" value="0" />
									<c:set var="sum_pj_sqi_mm" value="0" />
									<c:set var="sum_pj_outsource_mm" value="0" />
									<c:forEach items="${requestScope.list}" var="project">
										<c:set var="sum_contract_sales"
											value="${sum_contract_sales+ project.budget_contract_sales}" />
										<c:set var="sum_pj_income"
											value="${sum_pj_income+ project.pj_income}" />
										<c:set var="sum_pj_net_income"
											value="${sum_pj_net_income+ project.pj_net_income}" />
										<c:set var="sum_ebit" value="${sum_ebit+ project.ebit}" />
										<c:set var="sum_budget_sales"
											value="${sum_budget_sales+ project.budget_sales}" />
										<c:set var="sum_empl_cost_tot"
											value="${sum_empl_cost_tot+ project.empl_cost_tot}" />
										<c:set var="sum_budget_sqi_cost"
											value="${sum_budget_sqi_cost+ project.budget_sqi_cost}" />
										<c:set var="sum_empl_cost_wait"
											value="${sum_empl_cost_wait+ project.empl_cost_wait}" />
										<c:set var="sum_empl_cost_sales"
											value="${sum_empl_cost_sales+ project.empl_cost_sales}" />
										<c:set var="sum_empl_cost_comm"
											value="${sum_empl_cost_comm+ project.empl_cost_comm}" />
										<c:set var="sum_budget_outsource_cost"
											value="${sum_budget_outsource_cost+ project.budget_outsource_cost}" />
										<c:set var="sum_budget_product_cost"
											value="${sum_budget_product_cost+ project.budget_product_cost}" />
										<c:set var="sum_budget_normal_cost"
											value="${sum_budget_normal_cost+ project.budget_normal_cost}" />
										<c:set var="sum_pj_sqi_mm"
											value="${sum_pj_sqi_mm + project.pj_sqi_mm} " />
										<c:set var="sum_pj_outsource_mm"
											value="${sum_pj_outsource_mm + project.pj_outsource_mm} " />
									</c:forEach>
									<!-- 계약액 -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_contract_sales}" pattern="#,###" /></td>
									<!-- 매출액  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_pj_income}" pattern="#,###" /></td>
									<!-- 순매출액 -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_pj_net_income - team_comm}" pattern="#,###" /></td>
									<!-- 영업이익  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_ebit - team_comm}" pattern="#,###" /></td>
									<!--  매출원가 합계 -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_budget_sales + team_comm}" pattern="#,###" /></td>
									<!-- 인건비 합계  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_empl_cost_tot + team_comm}" pattern="#,###" /></td>
									<!-- pj 직접 합계  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_budget_sqi_cost}" pattern="#,###" /></td>
									<!-- 공통/대기 합계  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_empl_cost_wait}" pattern="#,###" /></td>
									<!-- 영업합계  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_empl_cost_sales}" pattern="#,###" /></td>
									<!-- 지원합계 -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_empl_cost_comm}" pattern="#,###" /></td>
									<!-- 외주합계 -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_budget_outsource_cost + team_comm}"
											pattern="#,###" /></td>
									<!-- 상품비합계  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_budget_product_cost}" pattern="#,###" /></td>
									<!-- 경비합계  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_budget_normal_cost}" pattern="#,###" /></td>
									<td width="65px" align="right"><fmt:formatNumber
											maxFractionDigits="2"
											value="${sum_pj_sqi_mm + sum_pj_outsource_mm}"
											pattern="#,##0.0" /></td>
									<td width="65px" align="right"><fmt:formatNumber
											maxFractionDigits="1" value="${sum_pj_sqi_mm}"
											pattern="#,##0.0" /></td>
									<td width="65px" align="right"><fmt:formatNumber
											maxFractionDigits="1" value="${sum_pj_outsource_mm}"
											pattern="#,##0.0" /></td>
								</tr>
							</TABLE>
						</DIV>
					</td>
				</tr>
				<!-- header종료 -->
				<tr>


					<!-- 왼쪽아래 고정내용 -->
					<TD>
						<DIV id="leftDisplay"
							style="width: 153px; height: 580px; overflow: hidden;"
							onscroll="scrollY()">
							<TABLE width="150px" cellspacing="1" cellpadding="0" border="0"
								class="main_table">
								<c:forEach items="${requestScope.list}" var="project">
									<tr>
										<!-- 상태 -->
										<td style="border-top: 0" width="50px" height="21px"
											align="center">${project.pj_prog }</td>
										<!-- 프로젝트 ID-->
										<td style="border-top: 0" width="100px" pxalign="center" align="center">${project.pj_id}</td>
									</tr>
								</c:forEach>
								<tr>
									<td style="border-top: 0" width="50px" height="21px"
										align="center">공통</td>
									<td></td>
								</tr>
							</TABLE>
						</DIV>
					</TD>
					<!-- 오른쪽아래 -->
					<td>
						<DIV id="mainDisplayRock"
							style="width: 1220px; height: 580px; overflow-y: scroll; overflow-x: hidden;"
							onscroll="scrollY()">
							<TABLE width="1830px" cellspacing="1" cellpadding="0" border="0"
								class="main_table">
								<c:forEach items="${requestScope.list}" var="project">
									<tr>
										<!-- 프로젝트 명-->
										<td
											style="height: 21px; width: 224px; text-overflow: ellipsis; overflow: hidden; border-top: 0; border-left: 0;"
											align="center"><nobr>${project.pj_name}<nobr></td>
										<!-- 시작일-->
										<td style="border-top: 0" width=" 110px" align="center">${project.pj_start_day}</td>
										<!-- 완료일 -->
										<td style="border-top: 0" width=" 110px" align="center">${project.pj_end_day}</td>
										<!-- 계약액-->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.budget_contract_sales}" pattern="#,###" /></td>
										<!-- 매출액 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.pj_income}" pattern="#,###" /></td>
										<!-- 순매출액-->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.pj_net_income}" pattern="#,###" /></td>
										<!-- 영업이익-->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.ebit}" pattern="#,###" /></td>
										<!-- 매출원가 합계 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.budget_sales}" pattern="#,###" /></td>
										<!-- 인건비 합계 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.empl_cost_tot}" pattern="#,###" /></td>
										<!-- pj 직접 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.budget_sqi_cost}" pattern="#,###" /></td>
										<!-- 공통/대기 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.empl_cost_wait}" pattern="#,###" /></td>
										<!-- 영업 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.empl_cost_sales}" pattern="#,###" /></td>
										<!-- 지원 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.empl_cost_comm}" pattern="#,###" /></td>
										<!-- 외주 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.budget_outsource_cost}" pattern="#,###" /></td>
										<!-- 상품비 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.budget_product_cost}" pattern="#,###" /></td>
										<!-- 경비 -->
										<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
												value="${project.budget_normal_cost}" pattern="#,###" /></td>
										<!-- M/M 합계 -->
										<td style="border-top: 0" width=" 65px" align="right"><fmt:formatNumber
												maxFractionDigits="2"
												value="${project.pj_sqi_mm + project.pj_outsource_mm}"
												pattern="#,##0.0" /></td>
										<!-- SQI M/M -->
										<td style="border-top: 0" width=" 65px" align="right"><fmt:formatNumber
												maxFractionDigits="1" value="${project.pj_sqi_mm}"
												pattern="#,##0.0" /></td>
										<!-- 외주 M/M -->
										<td style="border-top: 0" width=" 65px" align="right"><fmt:formatNumber
												maxFractionDigits="1" value="${project.pj_outsource_mm}"
												pattern="#,##0.0" /></td>
									</tr>
								</c:forEach>
								<tr>
									<td
										style="height: 21px; width: 224px; text-overflow: ellipsis; overflow: hidden; border-top: 0; border-left: 0;"
										align="center"></td>
									<!-- 시작일-->
									<td style="border-top: 0" width=" 110px" align="center"></td>
									<!-- 완료일 -->
									<td style="border-top: 0" width=" 110px" align="center"></td>
									<!-- 계약액-->
									<td style="border-top: 0" width=" 90px" align="right"></td>
									<!-- 매출액 -->
									<td style="border-top: 0" width=" 90px" align="right"></td>
									<!-- 순매출액-->
									<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
											value="-${team_comm}" pattern="#,###" /></td>
									<!-- 영업이익-->
									<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
											value="-${team_comm}" pattern="#,###" /></td>
									<!-- 매출원가 합계 -->
									<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
											value="${team_comm}" pattern="#,###" /></td>
									<!-- 인건비 합계 -->
									<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
											value="${sum_empl_cost_wait + sum_empl_cost_sales + 
											sum_empl_cost_comm + team_comm}" pattern="#,###" /></td>
									<!-- pj 직접 -->
									<td style="border-top: 0" width=" 90px" align="right"></td>
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_empl_cost_wait}" pattern="#,###" /></td>
									<!-- 영업합계  -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_empl_cost_sales}" pattern="#,###" /></td>
									<!-- 지원합계 -->
									<td width="90px" align="right"><fmt:formatNumber
											value="${sum_empl_cost_comm}" pattern="#,###" /></td>
									<!-- 외주 -->
									<td style="border-top: 0" width=" 90px" align="right"><fmt:formatNumber
											value="${team_comm}" pattern="#,###" /></td>
									<!-- 상품비 -->
									<td style="border-top: 0" width=" 90px" align="right"></td>
									<!-- 경비 -->
									<td style="border-top: 0" width=" 90px" align="right"></td>
									<!-- M/M 합계 -->
									<td style="border-top: 0" width=" 65px" align="right"></td>
									<!-- SQI M/M -->
									<td style="border-top: 0" width=" 65px" align="right"></td>
									<!-- 외주 M/M -->
									<td style="border-top: 0" width=" 65px" align="right"></td>
								</tr>
							</TABLE>
						</DIV>
					</td>
				</tr>
				<TR>
					<TD valign="top">
						<TABLE cellspacing="0" cellpadding="0" border="0">
							<TR>

							</TR>
						</TABLE>
					</TD>
					<TD>
						<DIV id="bottomLine"
							style="width: 1204px; overflow-x: scroll; overflow-y: hidden;"
							onscroll="scrollX()">
							<TABLE width="1830px" cellspacing="1" cellpadding="0" border="1">
								<TR>
									<td height="0" norwap class="BG_WHITE_RIGHT"></td>
								</TR>
							</TABLE>
						</DIV>
					</TD>
				</TR>
			</table>
		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>