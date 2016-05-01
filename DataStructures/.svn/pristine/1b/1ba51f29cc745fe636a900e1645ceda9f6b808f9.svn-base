<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>프로젝트 현황</title>

<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/excelExport.js"	type="text/javascript"></script>
<script src="resources/js/bizlist.js"		type="text/javascript"></script>

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
	height: 23px;
	border: 1px solid grey;
}

.main_table tr:hover {
	background-color: #ffff99;
	font-weight: bold;
}
</style>
</head>

<script>
	function strip_tags(input, allowed) {
		allowed = (((allowed || "") + "").toLowerCase().match(
				/<[a-z][a-z0-9]*>/g) || []).join(''); // making sure the allowed arg is a string containing only tags in lowercase (<a><b><c>)
		var tags = /<\/?([a-z][a-z0-9]*)\b[^>]*>/gi, commentsAndPhpTags = /<!--[\s\S]*?-->|<\?(?:php)?[\s\S]*?\?>/gi;
		return input
				.replace(commentsAndPhpTags, '')
				.replace(
						tags,
						function($0, $1) {
							return allowed
									.indexOf('<' + $1.toLowerCase() + '>') > -1 ? $0
									: '';

						});
	}
	$(window).ready( function() {
		//프로젝트 현황의 프로젝트 ID, 사업팀, 상태 체크박스를 체크한다.
		//프로그램 검색시 모든 검색어를 토큰(공백)을 통해 처리하기 때문에
		//search 스트링 추가시 주의가 필요하다. 순서는 반드시 일치해야 한다.
		//
		//순서 
		//	1. 반드시 팀명이 들어가야 하고 공백
		//	2. 반드시 프로젝트 ID가 들어가야 하고 공백
		//	3. 반드시 체크리스트 ID가 들어가야 하고 공백
		
		// 체크리스트의 값은 { 1이월, 2완료, 3대기, 4종결, 5A급,6B급, 7C급, 최신} 값으로 구분하기 때문에
		// 위와 같은 값이 아니면 질의가 불가능.
		
		//<-- 검색 표준화 시작
		$("#projectId").keyup(function(){
			var searchQuery="";
			searchQuery += $("#team_id").val() + " ";
			searchQuery += $("#projectId").val() + " ";
			$("input[name=chkStatus]:checked").each(function(index) {
				var checkedList = $(this).val();
				searchQuery += " " + checkedList + "";
			});
			
			bizlistAjax(searchQuery);
		});
		
		$("#team_id").on("click", function() {
			var searchQuery="";
			searchQuery += $("#team_id").val() + " ";
			searchQuery += $("#projectId").val() + " ";
			$("input[name=chkStatus]:checked").each(function(index) {
				var checkedList = $(this).val();
				searchQuery += " " + checkedList + "";
			});
			
			bizlistAjax(searchQuery);
		});
		
		$(".chkStatus").on("click", function() {
			var searchQuery="";
			searchQuery += $("#team_id").val() + " ";
			searchQuery += $("#projectId").val() + " ";
			$("input[name=chkStatus]:checked").each(function(index) {
				var checkedList = $(this).val();
				searchQuery += " " + checkedList + "";
			});
			
			bizlistAjax(searchQuery);
		});
		//검색 표준화 끝 -->
		
		var d = new Date();
		var filename = d.getFullYear() + "년" + (d.getMonth() + 1) + "월"
				+ d.getDate() + "일" + "프로젝트 현황";
		$("#excelExport").click(function() {
			getExcel($("#wrap"), filename);
		});
		setNav(1, 0);
		$("#keyword").keyup(function() {
			$("tr", "#mainT").each(
					function(i, v) {
						var seach = $("#keyword").val();
						var comp = strip_tags($(v).children()
								.eq(1).html(), "");
						var res = comp.indexOf(seach);
						if (res == -1) {
	
							$(v).attr("hidden", true);
							$("tr", "#leftT").eq(i).attr(
									"hidden", true);
						} else {
							console.log(res)
							$(v).attr("hidden", false);
							$("tr", "#leftT").eq(i).attr(
									"hidden", false);
						}
					})
		})
	});
	function OpenWindow(url, intWidth, intHeight) {
		winObject = window.open(url, "_blank", "width=" + intWidth + ",height="
				+ intHeight + ", resizable=no, scrollbars=no");
	}
	function scrollX() {
		document.all.mainDisplayRock.scrollLeft = document.all.bottomLine.scrollLeft;
		document.all.topLine.scrollLeft = document.all.bottomLine.scrollLeft;
	}

	function scrollY() {
		document.all.leftDisplay.scrollTop = document.all.mainDisplayRock.scrollTop;
		document.all.mainDisplayRock.scrollTop = document.all.leftDisplay.scrollTop;
	}
	
	function bizlistAjax(searchQuery) {
		$.ajax({
			type : "POST",
			url : "/bizlist.action",
			async : false,
			dataType : "json",
			data : {
				search : searchQuery
			},
			success : function(data) {
				
				var html = '<table width="359px" cellspacing="1" cellpadding="0" border="0" class="main_table">';
				$.each(data.list, function(entryIndex, list) {				
					html += '<tr id="'+list.pj_id+'">';
					html += '<th style="border-top:0; width: 117px">' + list.team_name+ '</th>'; // 팀명
					html += '<td align="center" style="border-top:0; width: 55px">' + list.pj_prog + '</td>';// 상태
					html += '<td align="center" style="border-top:0; width: 81px; text-overflow: ellipsis; overflow: hidden;"><nobr>' + list.state + '</nobr></td>';// 영업단계
					html += '<td style="border-top:0; width: 106px; text-overflow: ellipsis; overflow: hidden;" align="center"><a href="insertproject.iqspf?pj_id='+list.pj_id+'" style="text-decoration: none">' + list.pj_id + "</a></td>";// 프로젝트ID" ;
					html += "</tr>";
				});
				html += "</table>";
				$("#leftDisplay").html(html);
				
				var html = '<table width="1725px" cellspacing="1" cellpadding="0" border="0" class="main_table">';
				$.each(data.list, function(entryIndex, list) {
					var sum=Number(list.pj_sqimm)+Number(list.pj_outmm);
					if (list.pj_pm == null) {
						list.pj_pm = "";
					}
					if (list.pj_etc == null) {
						list.pj_etc = "";
					}
					if (list.top_customer == null) {
						list.top_customer = "";
					}	
					if (list.pj_sqimm == null){
						list.pj_sqimm = "";
					}
					if (list.pj_outmm == null){
						list.pj_outmm = "";
					}
					if (list.customer_name == null){
						list.customer_name = "";
					}
					
					
					html += "<tr>";
					html += '<td align="center" style="border-top:0; border-left:0; width:266px; text-overflow: ellipsis; overflow: hidden;"><a href="insertproject.iqspf?pj_id='+list.pj_id+'" style="text-decoration: none"><nobr>' + list.pj_name + "</nobr></a></td>";// 프로젝트명
					html += '<td align="center" style="border-top:0; width:95px; text-overflow: ellipsis; overflow: hidden;"><nobr>' + list.customer_name + '</nobr></td>';// 발주고객
					html += '<td align="center" style="border-top:0; width:95px; text-overflow: ellipsis; overflow: hidden;"><nobr>' + list.top_customer + '</nobr></td>';// 계약고객
					html += '<td style="border-top:0; width:117px;" align="center">' + list.pj_start_day + "</td>";
					html += '<td style="border-top:0; width:117px;" align="center">' + list.pj_end_day + "</td>";
					html += '<td style="border-top:0; width:50px;" align="right">' + list.pj_period + "</td>";// 기간
					html += '<td style="border-top:0; width:91px;" align="right">' + list.pj_operate + '%' + "</td>";// 수행비율

					html += '<td style="border-top:0; width:96px;" align="right">' + SetComma(String(list.budget_contract_sales)) + "</td>";// 계약액
					html += '<td style="border-top:0; width:95px;" align="right">'+ SetComma(String(list.budget_sales))+"</td>";// 매출액
					html += '<td style="border-top:0; width:95px;" align="right">' + SetComma(String(list.budget_outsource)) + "</td>";// 외주비
					html += '<td style="border-top:0; width:95px;" align="right">' + SetComma(String(list.budget_product_cost)) + "</td>";// 상품비
					html += '<td style="border-top:0; width:95px;" align="right">'+ SetComma(String(list.profit))+"</td>";// 순매출액
					html += '<td style="border-top:0; width:69px;" align="right">'+  sum + " </td>";// 총 MM
					html += '<td style="border-top:0; width:69px;" align="right">' + list.pj_sqimm + "</td>";// 자사MM
					html += '<td style="border-top:0; width:69px;" align="right">' + list.pj_outmm + "</td>";// 외주MM
					html += '<td style="border-top:0; width:105px; text-overflow: ellipsis; overflow: hidden;"	align="center"><nobr>' + list.pj_pm + '</nobr></td>';// PM
					html += '<td style="border-top:0; width:105px; text-overflow: ellipsis; overflow: hidden;" align="center"><nobr>' + list.pj_etc + "</nobr></td>";// 비고
					html += "</tr>";
				});
				html += "</table>";
				$("#mainDisplayRock").html(html);				
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}
		});
	}
	
</script>
<body>
	<%-- <jsp:include page="./common/header.jsp"></jsp:include> --%>
	<div class="container">
		<%-- <jsp:include page="./common/left.jsp"></jsp:include> --%>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">프로젝트 현황</h1>
		<!--검색 버튼 표준화  start -->
		<table border="1" style="width: 1000px;">
			<tr>
				<td style="background-color: rgb(232, 232, 232);">
					프로젝트ID
				</td>
				
				<td>
					<input	type="text"
							style="width: 100px;" 
							id="projectId"
							name="projectId"/>
				</td>
				
				<td style="background-color: rgb(232, 232, 232);">
					사업 팀
				</td>

				<td>
					<select id="team_id" name="team_id">
						<option	value="al">전체</option>
						<option	value="1S">SI사업팀</option>
						<option	value="2S">커머스사업팀</option>
						<option	value="3E">에너지사업팀</option>
						<option	value="4N">보안사업팀</option>
						<option	value="5D">미디어사업팀</option>
					</select>
				</td>

				<td style="background-color: rgb(232, 232, 232);">상태</td>

				<td>
					<input	type="checkbox" class="chkStatus" name="chkStatus" value="1이월"/>이월 
					<input	type="checkbox" class="chkStatus" name="chkStatus" value="2완료"/>완료 
					<input	type="checkbox" class="chkStatus" name="chkStatus" value="3대기"/>대기 
					<input	type="checkbox" class="chkStatus" name="chkStatus" value="4종결"/>종결 
					<input	type="checkbox" class="chkStatus" name="chkStatus" value="5A급"/>A급 
					<input	type="checkbox" class="chkStatus" name="chkStatus" value="6B급"/>B급 
					<input	type="checkbox" class="chkStatus" name="chkStatus" value="7C급"/>C급 
					<input	type="checkbox" class="chkStatus" name="chkStatus" value="최신"/>최신수정
					<!-- <input	type="button"	class="searchProjectStatus" value="임시검색테스트"/> -->
					
				</td>
			</tr>
		</table>


		<div style="width: 100%; margin-bottom: 10px;">
			<span style="padding-left: 1200px;">다운로드 
			<input id="excelExport"
				type="image" src="/resources/images/excel-download-icon.gif"
				style="width: 20px; height: 20px;">
			</span> 단위:[천원]
		</div>
		<div id="wrap" style="height: 700px; margin-left: 160px;">
			<table class="fuck" cellpadding="0" cellspacing="0">
				<!--검색 버튼 표준화  끝 -->
				<tr>
					<!-- 위 왼쪽 테이블 -->
					<td>
						<TABLE id="bizTopleft" width="359px" cellspacing="1"
							cellpadding="0" border="0" class="main_table">
							<tr>
								<th style="width: 117px">팀&nbsp;&nbsp;명</th>
								<th style="width: 55px">상&nbsp;&nbsp;태</th>
								<th style="width: 81px">영업단계</th>
								<th style="width: 106px">프로젝트 ID</th>
							</tr>
						</TABLE>
					</td>
					<!-- 위 오른쪽 테이블 -->
					<td>
						<DIV id="topLine" style="width: 1004px; overflow: hidden;">
							<TABLE class="main_table" width="1725px" cellspacing="1"
								cellpadding="0" border="0">
								<tr>
									<th style="border-left: 0; width: 266px">프로젝트 명</th>
									<th style="width: 95px">발주 고객</th>
									<th style="width: 95px">계약 고객</th>
									<th style="width: 117px">시&nbsp;작&nbsp;일</th>
									<th style="width: 117px">완&nbsp;료&nbsp;일</th>
									<th style="width: 50px">기&nbsp;&nbsp;간</th>
									<th style="width: 91px">Pj수행비율</th>

									<th style="width: 96px">계&nbsp;약&nbsp;액</th>
									<th style="width: 95px">매&nbsp;출&nbsp;액</th>
									<th style="width: 95px">외주비</th>
									<th style="width: 95px">상품비</th>
									<th style="width: 95px">순매출액</th>
									<th style="width: 69px">총&nbsp;MM</th>
									<th style="width: 69px">자사MM</th>
									<th style="width: 69px">외주MM</th>
									<th style="width: 105px">P&nbsp;&nbsp;M</th>
									<th style="width: 105px">비&nbsp;&nbsp;고</th>
								</tr>
							</TABLE>
						</DIV>
					</td>
				</tr>
				<!-- 헤더종료 -->
				<tr>
					<!-- 왼쪽 아래 -->
					<td>
						<DIV id="leftDisplay"
							style="width: 364px; height: 580px; overflow: hidden;"
							onscroll="scrollY()">
							<TABLE width="359px" cellspacing="1" cellpadding="0" border="0"
								class="main_table" id="leftT">
								<c:forEach items="${requestScope.list}" var="project">
									<tr>
										<th style="border-top: 0; width: 117px">${project.team_name}</th>
										<td style="border-top: 0; width: 55px" align="center">${project.pj_prog}</td>
										<td
											style="border-top: 0; width: 81px; text-overflow: ellipsis; overflow: hidden;"
											align="center"><nobr>${project.state}</nobr></td>
										<td style="border-top: 0; width: 106px" align="center"><a
											href='insertproject.iqspf?pj_id=${project.pj_id}'
											style="text-decoration: none">${project.pj_id}</a></td>
									</tr>
								</c:forEach>
							</TABLE>
						</DIV>
					</td>
					<!-- 오른쪽 아래 -->
					<td>

						<DIV id="mainDisplayRock"
							style="width: 1021px; height: 580px; overflow-y: scroll; overflow-x: hidden;"
							onscroll="scrollY()">
							<TABLE width="1725px" cellspacing="1" cellpadding="0" border="0"
								class="main_table" id="mainT">
								<c:forEach items="${requestScope.list}" var="project">
									<tr>
										<!-- 										<td -->
										<!-- 											style="border: 0; width: 0px; text-overflow: ellipsis; overflow: hidden;" -->
										<%-- 											align="center"><nobr>${project.pj_id}<nobr></td> --%>
										<td
											style="border-top: 0; border-left: 0; width: 266px; text-overflow: ellipsis; overflow: hidden;"
											align="center"><a
											href='insertproject.iqspf?pj_id=${project.pj_id}'
											style="text-decoration: none"><nobr>${project.pj_name}</nobr></a></td>
										<td
											style="border-top: 0; width: 95px; text-overflow: ellipsis; overflow: hidden;"
											align="center"><nobr>${project.customer_name}</nobr></td>
										<td
											style="border-top: 0; width: 95px; text-overflow: ellipsis; overflow: hidden;"
											align="center"><nobr>${project.top_customer}</nobr></td>
										<td style="border-top: 0; width: 117px;" align="center">${project.pj_start_day}</td>
										<td style="border-top: 0; width: 117px;" align="center">${project.pj_end_day}</td>
										<td style="border-top: 0; width: 50px;" align="right"><fmt:formatNumber
												value="${project.pj_period}" pattern="#,###" /></td>
										<td style="border-top: 0; width: 91px;" align="right">${project.pj_operate}%</td>
										<td style="border-top: 0; width: 96px;" align="right"><fmt:formatNumber
												value="${project.budget_contract_sales}" pattern="#,###" /></td>
										<td style="border-top: 0; width: 95px;" align="right"><fmt:formatNumber
												value="${project.budget_sales}" pattern="#,###" /></td>
										<td style="border-top: 0; width: 95px;" align="right"><fmt:formatNumber
												value="${project.budget_outsource}" pattern="#,###" /></td>
										<td style="border-top: 0; width: 95px;" align="right"><fmt:formatNumber
												value="${project.budget_product_cost}" pattern="#,###" /></td>
										<td style="border-top: 0; width: 95px;" align="right">${project.profit}</td>
										<td style="border-top: 0; width: 69px;" align="right">${project.pj_sqimm+project.pj_outmm}</td>
										<td style="border-top: 0; width: 69px;" align="right">${project.pj_sqimm}</td>
										<td style="border-top: 0; width: 69px;" align="right">${project.pj_outmm}</td>
										<td
											style="border-top: 0; width: 105px; text-overflow: ellipsis; overflow: hidden;"
											align="center"><nobr>${project.pj_pm}</nobr></td>
										<td
											style="border-top: 0; width: 105px; text-overflow: ellipsis; overflow: hidden;"
											align="center"><nobr>${project.pj_etc}</nobr></td>
									</tr>
								</c:forEach>
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
							style="width: 1004px; overflow-x: scroll; overflow-y: hidden;"
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
		</div>
		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>