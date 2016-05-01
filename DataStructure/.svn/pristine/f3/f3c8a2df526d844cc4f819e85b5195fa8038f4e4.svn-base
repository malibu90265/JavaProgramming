<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible"
	content="IE=edge,chrome=1; charset=utf-8;">
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/SetNum.js" type="text/javascript"></script>
<script>
	
	function setNav(main, sub, sub2) {
		$(".mainNav", "#mainNavContainer").eq(main).addClass("navSelected");
		$(".subNav", "#subNavContainer").eq(sub).addClass("navSelected");
		$(".subNav", "#subNavContainer").eq(sub).next().show();
		if (sub2 != null) {
			$(".subNav", "#subNavContainer").eq(sub).next().children().eq(sub2)
					.addClass("navSelected");
		}
	}
	$(window).ready(function() {
		//TODO
		setNav(0, 3, 0);
	});	
	function teamUpdate(team_id){
		var check = confirm("수정하시겠습니까?");
		if (check) {
			var formData = document.userForm;
	 		formData.action="teamUpdate.iqspf?team_id="+team_id;
	 		formData.submit(); 
	 		} else {
			return;
		}
 	}
	
	function teamList(){
		var check = confirm("취소하시겠습니까?");
		if (check) {
			var formData = document.userForm;
	 		formData.action="teamList.iqspf";
	 		formData.submit();		
		} else {
			return;
		}
 	}
	
	function getTeam(team_id){
			var formData = document.teamForm;
			formData.action="getTeam.iqspf?team_id=" + team_id;
	 		formData.submit(); 
 	}
</script>
</head>
<body>
	<div class="header">
		<div class="header_area">
			<div>
				<img src="resources/images/logo.png" />
			</div>
			<div id="mainNavContainer">
				<div class="mainNav">
					<a href="totalChart.iqspf">손익현황</a>
				</div>
				<div class="mainNav">
					<a href="bizList.iqspf">프로젝트현황</a>
				</div>
				<div class="mainNav">인력현황</div>
			</div>
		</div>
	</div>
	<div class="container">
		<section id="subNavContainer">
		<div class="subNav">
			<a href="totalChart.iqspf">총괄표</a>
		</div>
		<div class="subNav">전주대비표</div>
		<div class="subNavD2Container">
			<div class="subNavD2">
				<a href="totalChart.iqspf">총괄표</a>
			</div>
			<div class="subNavD2">전주대비표</div>
			<div class="subNavD2">추세분석</div>
			<div class="subNavD2">연간목표</div>
		</div>
		<div class="subNav">추세분석</div>
		<div class="subNavD2Container">
			<div class="subNavD2">총괄표</div>
			<div class="subNavD2">전주대비표</div>
			<div class="subNavD2">추세분석</div>
			<div class="subNavD2">연간목표</div>
		</div>
		<div class="subNav">
			<a href="teamList.iqspf">연간목표</a>
		</div>

		</section>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">연간목표</h1>
		<div id="left_main"
			style="height: 900px; width: 550px; background: white; margin-right: 20px; float: left;">
			<p>
				<팀 선택>
			</p>
			<form name="teamForm" method="post">
				<table class="ex1">
					<thead>
						<tr>
							<th width="120">팀&nbsp;&nbsp;이름</th>
							<th width="120">계약목표</th>
							<th width="120">매출목표</th>
							<th width="120">순매출목표</th>
						</tr>
					</thead>
					<c:forEach items="${requestScope.list}" var="team">
						<tr onclick="getTeam('${team.team_id}')">
							<td align="center">${team.team_name}</td>
							<td align="right"><fmt:formatNumber
									value="${team.team_contract_goal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${team.team_sales_goal}" pattern="#,###" /></td>
							<td align="right"><fmt:formatNumber
									value="${team.team_netsales_goal}" pattern="#,###" /></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<div id="right_main"
			style="height: 900px; width: 550px; background: white; margin-right: 20px; float: left;">
			<p>
				<팀 목표 상세정보>
			</p>
			<form name="userForm" method="post">
				<table>
					<tr>
						<th width="150">팀 ID</th>
						<td width="150" align="center">${requestScope.vo.team_id}</td>
						<th width="150">팀&nbsp;&nbsp;이름</th>
						<td width="150" align="center">${requestScope.vo.team_name}</td>
					</tr>
					<tr>
						<th>계약목표</th>
						<td align="center"><input type="text" class="text"
							name="team_contract_goal" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_contract_goal_str}" /></td>
						<th>매출목표</th>
						<td align="center"><input type="text" class="text"
							name="team_sales_goal" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_sales_goal_str}" /></td>
					</tr>
					<tr>
						<th>순매출목표</th>
						<td align="center"><input type="text" class="text"
							name="team_netsales_goal" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_netsales_goal_str}" /></td>
						<th>손익목표</th>
						<td align="center"><input type="text" class="text"
							name="team_pl_goal" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_pl_goal_str}" /></td>
					</tr>
					<tr>
						<th>순매출BEP</th>
						<td align="center"><input type="text" class="text"
							name="team_netsales_bep" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_netsales_bep_str}" /></td>
						<th>인건비</th>
						<td align="center"><input type="text" class="text"
							name="team_labor_cost" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_labor_cost_str}" /></td>
					</tr>
					<tr>
						<th>영업비</th>
						<td align="center"><input type="text" class="text"
							name="team_biz_cost" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_biz_cost_str}" /></td>
						<th>간접비</th>
						<td align="center"><input type="text" class="text"
							name="team_indirect_cost" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_indirect_cost_str}" /></td>
					</tr>
					<tr>
						<th>공통외주비</th>
						<td align="center"><input type="text" class="text"
							name="team_outsource_cost" size="20"
							style="ime-mode: disabled; text-align: right;"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.team_outsource_cost_str}" /></td>
						<th>기본경비율</th>
						<td align="right"><input type="text" class="text"
							name="team_perofcost" size="20"
							style="ime-mode: disabled; text-align: right; width: 89%"
							onkeypress="return isFloat(event)"
							value="${requestScope.vo.team_perofcost}" />%</td>
					</tr>
					<tr>
						<th>M/M</th>
						<td align="center"><input type="text" name="team_mm"
							size="20" style="ime-mode: disabled; text-align: right;"
							value="${requestScope.vo.team_mm}"
							onkeypress="return isFloat(event)" /></td>
					</tr>
				</table>
				<br />
				<div style="text-align: right; margin-top: 7px;">
					<input type="button" value="저장"
						onclick="teamUpdate('${requestScope.vo.team_id}')" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="취소" onclick="teamList()" />&nbsp;&nbsp;
				</div>
			</form>
		</div>
		</section>
	</div>
	<div class="footer">
		<p>서울시 영등포구 경인로 775 (문래동3가) 에이스하이테크시티 1동 803호</p>
		<p>TEL : 02-2109-1900 / FAX : 02-2109-1999 / MAIL :
			webmaster@sqisoft.com</p>
		<p>Copyright ⓒ 1999~2014 SQISOFT ALL RIGHTS RESERVED.</p>
	</div>
</body>
</html>