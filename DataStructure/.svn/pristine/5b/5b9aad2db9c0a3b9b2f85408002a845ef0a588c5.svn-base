<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전주대비표</title>
<link rel="stylesheet" type="text/css" href="menu.css">
<link rel="stylesheet" type="text/css" href="tables.css">

<script type="text/javascript">
	function viewMain() {
		var formData = document.userForm;
		formData.action = "iqspMain.iqspf";
		formData.submit();
	}

	function viewDistrib() {
		var formData = document.userForm;
		formData.action = "distibView.iqspf";
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
		<h1>손익 현황</h1>
	</div>
	<div id="menu-container">
		<div id="topMenu">
			<ul>
				<li class="topMenuLi"><a class="menuLink" href="iqspMain.iqspf">SQI
						soft</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink"
					href="<c:url value="/totalChart.iqspf"/>">총 괄 표</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink"
					href="compareChart.iqspf">전 주 대 비 표</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">추 세 분 석</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="teamList.iqspf">연
						간 목 표</a></li>
			</ul>
		</div>
	</div>
	<div id="blog-container">
		<span class="label"></span>

		<nav class="elem elem-red">
		<ul>
			<li><a href="projectList.iqspf">프로젝트 현황표</a></li>
			<li><a href="insertproject.iqspf">새 프로젝트 추가</a></li>
			<li><a href="teamList.iqspf">팀 정보</a></li>

		</ul>
		</nav>


		<section>
		<p>
		<center>
			<h2>전주대비표</h2>
			<form name="userForm" method="post">

				<table class="ex1">
					<thead>
						<tr>
							<th rowspan="2">부서명</th>
							<th colspan="4">현재 기준</th>
							<th colspan="4">전주 기준</th>
							<th colspan="4">차이</th>
						</tr>
						<tr>
							<td class="sub">계약액</td>
							<td class="sub">매출액</td>
							<td class="sub">순매출액</td>
							<td class="sub">영업이익</td>

							<td class="sub">계약액</td>
							<td class="sub">매출액</td>
							<td class="sub">순매출액</td>
							<td class="sub">영업이익</td>

							<td class="sub">계약액</td>
							<td class="sub">매출액</td>
							<td class="sub">순매출액</td>
							<td class="sub">영업이익</td>
						</tr>
					</thead>
					<!--합계  -->
					<tbody>
						<tr>
							<th>합계</th>
							<!-- 차이  -->
							<!-- 계약금  -->
							<td>0</td>
							<!-- 매출액  -->
							<td>0</td>
							<!-- 순매출액  -->
							<td>0</td>
							<!-- 영업이익  -->
							<td>0</td>
							
							<!-- 현재  -->
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<!-- 전주  -->
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>

						<!--SI1  -->
						<tr>
							<th>SI 1팀</th>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>

						<tr>
							<th>SI 2팀</th>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>

						<tr>
							<th>에너지사업팀</th>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>

						<tr>
							<th>보안사업팀</th>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>

						<tr>
							<th>DS사업팀</th>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>

						<tr>
							<th>기 타</th>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>
					</tbody>
				</table>

				<br> <br>



				<table class="ex1">
					<thead>
						<tr>
							<th rowspan="2">부서명</th>
							<th colspan="4">현재 기준</th>
							<th colspan="4">전주 기준</th>
							<th colspan="4">차이</th>
						</tr>
						<tr>
							<td class="sub">총 매출원가</td>
							<td class="sub">인건비</td>
							<td class="sub">상품비</td>
							<td class="sub">경비</td>

							<td class="sub">총 매출원가</td>
							<td class="sub">인건비</td>
							<td class="sub">상품비</td>
							<td class="sub">경비</td>

							<td class="sub">총 매출원가</td>
							<td class="sub">인건비</td>
							<td class="sub">상품비</td>
							<td class="sub">경비</td>
						</tr>
					</thead>
					<!--합계  -->
					<tr>
						<th>합계</th>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>

					<!--SI1  -->
					<tr>
						<th>SI 1팀</th>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>

					<tr>
						<th>SI 2팀</th>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>

					<tr>
						<th>에너지사업팀</th>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>

					<tr>
						<th>보안사업팀</th>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>

					<tr>
						<th>DS사업팀</th>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>

					<tr>
						<th>기 타</th>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
						<td>0</td>
					</tr>
				</table>

				<br> <br>

				<table class="ex1">
					<thead>
						<tr>
							<th>부서명</th>
							<th>실적 변동 내역</th>
							<th>인건비(직원/외주) 변동 내역</th>
							<th>상품비/경비 변동 내역</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>SI 1팀</th>
							<td>0 </td>
							<td class="odd1" rowspan="5">내용</td>
							<td class="odd1" rowspan="5">내용</td>
						</tr>
						<tr>
							<th>SI 2팀</th>
							<td>0</td>
						</tr>
						<tr>
							<th>에너지사업팀</th>
							<td>0</td>
						</tr>
						<tr>
							<th>보안사업팀</th>
							<td>0</td>
						</tr>
						<tr>
							<th>DS사업팀</th>
							<td>0</td>
						</tr>
					</tbody>



				</table>


				<%-- <c:forEach items="${requestScope.list}" var="">
						<tr>
							<!-- 사업팀 -->
							<td>${project.team_id}</td>
							<!-- 상태 -->
							<td>${project.pj_prog}</td>
							<!-- 프로젝트 ID -->
							<td>${project.pj_id}</td>
							<!-- 프로젝트 명 -->
							<td>${project.pj_name}</td>
							<!-- 시작일 -->
							<td>${project.pj_start_day}</td>
							<!-- 완료일 -->
							<td>${project.pj_end_day}</td>
							<!-- 계약액 -->
							<td>${project.budget_contract_sales_coma}</td>
							<!-- 매출액 -->
							<td>${project.budget_sales_coma}</td>
							<!-- 순매출액 -->
							<td>${project.budget_outsource_cost_coma}</td>
							<!-- 영업이익 -->
							<td>${project.profit}</td>
							<!-- 매출원가 합계 -->
							<td>영업이익</td>
							<!-- 인건비합계 -->
							<td>총MM</td>
							<!-- PJ직접 -->
							<td>자사MM</td>
							<!-- 공통/대기 -->
							<td>외주MM</td>
							<!-- 영업 -->
							<td>외주MM</td>
							<!-- 지원 -->
							<td>외주MM</td>
							<!-- 외주 -->
							<td>${project.exempl_sal}</td>
							<!-- 상품비 -->
							<td>상품비</td>
							<!-- 경비 -->
							<td>외주MM</td>
							<!-- M/M 합계-->
							<td>외주MM</td>
							<!-- 직원 M/M -->
							<td>외주MM</td>
							<!-- 외주 M/M -->
							<td>${project.exmm}</td>
						</tr>
					</c:forEach> --%>


				&nbsp;&nbsp;<input type="button" value="메인화면 보기"
					onclick="viewMain()" />&nbsp;&nbsp;
			</form>
		</center>
		</p>
	</div>



</body>
</html>