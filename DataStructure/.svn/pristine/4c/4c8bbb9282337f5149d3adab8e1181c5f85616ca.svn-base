<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="menu.css">
<link rel="stylesheet" type="text/css" href="tables.css">

<title>배부 정보</title>

<script type="text/javascript">
	function viewMain() {
		var formData = document.userForm;
		formData.action = "iqspMain.iqspf";
		formData.submit();
	}
	function distribUpdate() {
		var formData = document.userForm;
		formData.action = "distribUpdatePage.iqspf";
		formData.submit();
	}
	var currentScrollTop = 0;

	// 비동기식 jQuery이므로 window load 후 jQuery를 실행해야 함
	window.onload = function() {
		// 새로고침 했을 경우를 대비한 메소드 실행
		scrollController();

		// 스크롤을 하는 경우에만 실행됨
		$(window).on('scroll', function() {
			scrollController();
		});
	}

	// 메인 메뉴의 위치를 제어하는 함수
	function scrollController() {
		currentScrollTop = $(window).scrollTop();
		if (currentScrollTop < 150) {
			$('#blog-header-container').css('top', -(currentScrollTop));
			$('#menu-container').css('top', 150 - (currentScrollTop));
			if ($('#menu-container').hasClass('fixed')) {
				$('#menu-container').removeClass('fixed');
				$('#menu-container .menu-icon').removeClass('on');
			}
		} else {
			if (!$('#menu-container').hasClass('fixed')) {
				$('#blog-header-container').css('top', -150);
				$('#menu-container').css('top', 0);
				$('#menu-container').addClass('fixed');
				$('#menu-container .menu-icon').addClass('on');
			}
		}
	}
</script>
</head>
<body>
	<div id="blog-header-container">
		<h1>프로젝트 현황</h1>
	</div>
	<div id="menu-container">
		<div id="topMenu">
			<ul>
				<li class="topMenuLi"><a class="menuLink" href="iqspMain.iqspf">SQI
						soft</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">프로젝트 정보</a>
					<ul class="submenu">
						<li><a href="bizList.iqspf" class="submenuLink longLink">프로젝트
								예상 현황</a></li>
						<li><a href="insertproject.iqspf"
							class="submenuLink longLink">프로젝트 입력</a></li>
						<li><a href="projectBudgetinfo.iqspf"
							class="submenuLink longLink">프로젝트 재무 정보</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">계약 진행</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">인력 요소</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">실행 예산</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">고객 정보</a></li>
			</ul>
		</div>
	</div>
	<div id="blog-container">
		<span class="label"></span>

		<nav class="elem elem-red">
		<ul>
			<li><a href="bizList.iqspf">프로젝트 현황표</a></li>
			<li><a href="insertproject.iqspf">새 프로젝트 추가</a></li>
			<li><a href="teamList.iqspf">팀 정보</a></li>
			<li><a href="projectBudgetinfo.iqspf">프로젝트 재무정보</a></li>

		</ul>
		</nav>

		<p>
		<center>
			<h2>배부 정보</h2>
			<form name="userForm" method="post">
				<input type="button" value="수정" align="right"
					onclick="distribUpdate()" />
				<table class="ex1">
					<thead>
						<tr>
							<th rowspan="3">팀&nbsp;&nbsp;명</th>
							<th colspan="3">배부기준 금액</th>
							<th colspan=7">배부 금액</th>
						</tr>
						<tr>
							<td class="long" colspan="3">순매출액</td>
							<td class="long" colspan="3">간접인건비(PJ 직접 외)</td>
							<td class="long" colspan="3">고정경비</td>
							<td class="long">변동경비</td>
						</tr>
						<tr>
							<td class="sub">총액</td>
							<td class="sub">B급</td>
							<td class="sub">배부기준</td>
							<td class="sub">공통/대기</td>
							<td class="sub">영업</td>
							<td class="sub">지원(전사)</td>
							<td class="sub">간접(전사)</td>
							<td class="sub">팀공통</td>
							<td class="sub">계</td>
							<td class="sub">변동율(PJ)</td>
						</tr>
					</thead>
					<!-- SI 1팀 -->
					<tr>
						<!-- 팀명 -->
						<th>SI 1팀</th>
						<!-- 총액 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_s1}" /></td>
						<!-- B급 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_s1_b}" /></td>
						<!-- 배부기준 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_s1 -
								requestScope.vo.di_net_incomde_s1_b}" /></td>
						<!-- 공통/대기 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_wait_s1}" /></td>
						<!-- 영업 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_sales_s1}" /></td>
						<!-- 지원(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_s1 * requestScope.vo.empl_cost_comm}" /></td>
						<!-- 간접(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_s1 * requestScope.vo.di_indirect_tot}" />
						</td>
						<!-- 팀공통 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_common_cost_si1}" /></td>
						<!-- 계 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_s1 * requestScope.vo.di_indirect_tot + 
								requestScope.vo.di_common_cost_si1}" /></td>
						<!-- 변동율(PJ) -->
						<td align="right">${requestScope.vo.di_changerate_si1}%</td>
					</tr>
					<!-- SI2 팀 -->
					<tr>
						<!-- 팀명 -->
						<th>SI 2팀</th>
						<!-- 총액 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_s2}" /></td>
						<!-- B급 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_s2_b}" /></td>
						<!-- 배부기준 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_s2 - 
								requestScope.vo.di_net_incomde_s2_b}" /></td>
						<!-- 공통/대기 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_wait_s2}" /></td>
						<!-- 영업 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_sales_s2}" /></td>
						<!-- 지원(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_s2 * requestScope.vo.empl_cost_comm}" /></td>
						<!-- 간접(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_s2 * requestScope.vo.di_indirect_tot}" /></td>
						<!-- 팀공통 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_common_cost_si2}" /></td>
						<!-- 계 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_s2 * requestScope.vo.di_indirect_tot + 
								requestScope.vo.di_common_cost_si2}" /></td>
						<!-- 변동율(PJ) -->
						<td align="right">${requestScope.vo.di_changerate_si2}%</td>
					</tr>
					<!-- 에너지사업팀 -->
					<tr>
						<!-- 팀명 -->
						<th>에너지사업팀</th>
						<!-- 총액 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_energy}" /></td>
						<!-- B급 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_energy_b}" /></td>
						<!-- 배부기준 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_energy - 
								requestScope.vo.di_net_incomde_energy_b}" /></td>
						<!-- 공통/대기 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_wait_energy}" /></td>
						<!-- 영업 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_sales_energy}" /></td>
						<!-- 지원(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_energy * requestScope.vo.empl_cost_comm}" /></td>
						<!-- 간접(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_energy * requestScope.vo.di_indirect_tot}" /></td>
						<!-- 팀공통 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_common_cost_energy}" /></td>
						<!-- 계 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_energy * requestScope.vo.di_indirect_tot + requestScope.vo.di_common_cost_energy}" /></td>
						<!-- 변동율(PJ) -->
						<td align="right">${requestScope.vo.di_changerate_energy}%</td>
					</tr>
					<!-- 보안사업팀 -->
					<tr>
						<!-- 팀명 -->
						<th>보안사업팀</th>
						<!-- 총액 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_security}" /></td>
						<!-- B급 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_security_b}" /></td>
						<!-- 배부기준 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_security - 
								requestScope.vo.di_net_incomde_security_b}" /></td>
						<!-- 공통/대기 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_wait_security}" /></td>
						<!-- 영업 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_sales_security}" /></td>
						<!-- 지원(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_security * requestScope.vo.empl_cost_comm}" /></td>
						<!-- 간접(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_security * requestScope.vo.di_indirect_tot}" /></td>
						<!-- 팀공통 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_common_cost_security}" /></td>
						<!-- 계 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_security * requestScope.vo.di_indirect_tot + requestScope.vo.di_common_cost_security}" /></td>
						<!-- 변동율(PJ) -->
						<td align="right">${requestScope.vo.di_changerate_security}%</td>
					</tr>
					<!-- DS 사업팀 -->
					<tr>
						<!-- 팀명 -->
						<th>DS사업팀</th>
						<!-- 총액 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_ds}" /></td>
						<!-- B급 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_ds_b}" /></td>
						<!-- 배부기준 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_ds - 
								requestScope.vo.di_net_incomde_ds_b}" />
						</td>
						<!-- 공통/대기 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_ds_b}" /></td>
						<!-- 영업 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_wait_ds}" /></td>
						<!-- 지원(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_ds * requestScope.vo.empl_cost_comm}" /></td>
						<!-- 간접(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_ds * requestScope.vo.di_indirect_tot}" /></td>
						<!-- 팀공통 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_common_cost_ds}" /></td>
						<!-- 계 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_standard_ds * requestScope.vo.di_indirect_tot +
								requestScope.vo.di_common_cost_ds}" /></td>
						<!-- 변동율(PJ) -->
						<td align="right">${requestScope.vo.di_changerate_ds}%</td>
					</tr>
					<!-- 계 -->
					<tr>
						<!-- 팀명 -->
						<th>계</th>
						<!-- 총액 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_tot}" /></td>
						<!-- B급 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_tot_b}" /></td>
						<!-- 배부기준 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.di_net_incomde_tot - requestScope.vo.di_net_incomde_tot_b}" /></td>
						<!-- 공통/대기 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_wait_s1 +
								requestScope.vo.empl_cost_wait_s2 +
								requestScope.vo.empl_cost_wait_security +
								requestScope.vo.empl_cost_wait_energy +
								requestScope.vo.empl_cost_wait_ds}" /></td>
						<!-- 영업 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0"
								value="${requestScope.vo.empl_cost_sales_s1 +
								requestScope.vo.empl_cost_sales_s2 +
								requestScope.vo.empl_cost_sales_security +
								requestScope.vo.empl_cost_sales_energy +
								requestScope.vo.empl_cost_sales_ds}" /></td>
						<!-- 지원(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0" value="${requestScope.vo.empl_cost_comm}" /></td>
						<!-- 간접(전사) -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="0" value="${requestScope.vo.di_indirect_tot}" /></td>
						<!-- 팀공통 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="4"
								value="${requestScope.vo.di_common_cost_si1 + 
								requestScope.vo.di_common_cost_si2 +
								requestScope.vo.di_common_cost_security +
								requestScope.vo.di_common_cost_ds +
								requestScope.vo.di_common_cost_energy}" />
						</td>
						<!-- 계 -->
						<td align="right"><fmt:formatNumber type="number"
								maxFractionDigits="4"
								value="${requestScope.vo.di_indirect_tot +
								requestScope.vo.di_common_cost_si1 + 
								requestScope.vo.di_common_cost_si2 +
								requestScope.vo.di_common_cost_security +
								requestScope.vo.di_common_cost_ds +
								requestScope.vo.di_common_cost_energy}" /></td>
						<td></td>

					</tr>
				</table>
				&nbsp;&nbsp;<input type="button" value="메인화면 보기"
					onclick="viewMain()" />&nbsp;&nbsp;
			</form>
		</center>
		</p>
	</div>






</body>
</html>





