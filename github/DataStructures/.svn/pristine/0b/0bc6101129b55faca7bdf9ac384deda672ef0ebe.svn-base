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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/excelExport.js" type="text/javascript"></script>
<script src="resources/js/bizlist.js" type="text/javascript"></script>
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

function strip_tags (input, allowed) {
    allowed = (((allowed || "") + "").toLowerCase().match(/<[a-z][a-z0-9]*>/g) || []).join(''); // making sure the allowed arg is a string containing only tags in lowercase (<a><b><c>)
    var tags = /<\/?([a-z][a-z0-9]*)\b[^>]*>/gi,
        commentsAndPhpTags = /<!--[\s\S]*?-->|<\?(?:php)?[\s\S]*?\?>/gi;
    return input.replace(commentsAndPhpTags, '').replace(tags, function ($0, $1) {        return allowed.indexOf('<' + $1.toLowerCase() + '>') > -1 ? $0 : '';

    });
}
$(window).ready(function() {
	
	var d = new Date();
	var filename=d.getFullYear()+"년"+(d.getMonth() + 1)+"월"+d.getDate()+"일"+"프로젝트 현황";
	$("#excelExport").click(function(){
		getExcel($("#wrap"),filename);
	});
	setNav(1, 0);
	$("#keyword").keyup(function(){
	$("tr","#mainT").each(function(i,v){
		var seach=$("#keyword").val();
		var comp=strip_tags($(v).children().eq(1).html(),"");		
		var res=comp.indexOf(seach);
		if(res==-1)
		{	
			
			$(v).attr("hidden",true);
			$("tr","#leftT").eq(i).attr("hidden",true);
		}
		else 
		{
			console.log(res)
			$(v).attr("hidden",false);
			$("tr","#leftT").eq(i).attr("hidden",false);
		}
	})})
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

</script>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">프로젝트 현황</h1>
		<div style="width: 100%; margin-bottom: 10px;">
			<input type="button" value="검색조건" onclick="javascript:OpenWindow('searchPopup.iqspf','350','350')" style="margin-right: 900px;">
			<input type="button" id="excelExport" value="Excel" style="margin-right: 200px;" />
			단위:[천원]
		</div>
		<div id="wrap" style="height: 700px; margin-left: 160px;">   
			<table class="fuck" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<!-- 위 왼쪽 테이블 -->
					<td>
						<TABLE id="bizTopleft" width="359px" cellspacing="1" cellpadding="0" border="0"
							class="main_table">
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
								class="main_table" id="leftT" >
								<c:forEach items="${requestScope.list}" var="project">
									<tr>
									<th style="border-top: 0; width: 117px">${project.team_name}</th>
									<td style="border-top: 0; width: 55px" align="center">${project.pj_prog}</td>
									<td style="border-top: 0; width: 81px; text-overflow: ellipsis; overflow: hidden;" align="center"><nobr>${project.state}</nobr></td>
									<td style="border-top: 0; width: 106px" align="center"><a href='insertproject.iqspf?pj_id=${project.pj_id}'
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
											align="center"><a href='insertproject.iqspf?pj_id=${project.pj_id}'
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







			<%-- <table style="table-layout: fixed; width: 2000px">
				<thead>
					<tr>

						<th style="width: 255px">프로젝트 명</th>
						<th style="width: 100px">계약 고객</th>
						<th style="width: 100px">발주 고객</th>

						<th style="width: 110px">시&nbsp;작&nbsp;일</th>
						<th style="width: 110px">완&nbsp;료&nbsp;일</th>
						<th style="width: 45px">기&nbsp;&nbsp;간</th>
						<th style="width: 85px">Pj수행비율</th>

						<th style="width: 90px">계&nbsp;약&nbsp;액</th>
						<th style="width: 90px">매&nbsp;출&nbsp;액</th>
						<th style="width: 90px">외주비</th>
						<th style="width: 90px">상품비</th>
						<th style="width: 90px">순매출액</th>
						<th style="width: 65px">총&nbsp;MM</th>
						<th style="width: 65px">자사MM</th>
						<th style="width: 65px">외주MM</th>
						<th style="width: 100px">P&nbsp;&nbsp;M</th>
						<th style="width: 100px">비&nbsp;&nbsp;고</th>
					</tr>
				</thead>
				<c:forEach items="${requestScope.list}" var="project">
					<tr>
						<td style="text-overflow: ellipsis; overflow: hidden;"
							align="center"><a
							href='getProject.iqspf?pj_id=${project.pj_id}'
							style="text-decoration: none"> <nobr>${project.pj_name}
									<nobr></a></td>
						<td style="text-overflow: ellipsis; overflow: hidden;"
							align="center"><nobr>${project.customer_name}
								<nobr></td>
						<td style="text-overflow: ellipsis; overflow: hidden;"
							align="center"><nobr>${project.top_customer}
								<nobr></td>
						<td align="center">${project.pj_start_day}</td>
						<td align="center">${project.pj_end_day}</td>


						<td align="right"><fmt:formatNumber
								value="${project.pj_period}" pattern="#,###" /></td>
						<td align="right">${project.pj_operate}%</td>

						<td align="right"><fmt:formatNumber
								value="${project.budget_contract_sales}" pattern="#,###" /></td>
						<td align="right"><fmt:formatNumber
								value="${project.budget_sales}" pattern="#,###" /></td>
						<td align="right"><fmt:formatNumber
								value="${project.budget_outsource}" pattern="#,###" /></td>
						<td align="right"><fmt:formatNumber
								value="${project.budget_product_cost}" pattern="#,###" /></td>
						<td align="right">${project.profit}</td>
						<td align="right">${project.pj_sqimm+project.pj_outmm}</td>
						<td align="right">${project.pj_sqimm}</td>
						<td align="right">${project.pj_outmm}</td>
						<td style="text-overflow: ellipsis; overflow: hidden;"
							align="center"><nobr>${project.pj_pm}
								<nobr></td>
						<td style="text-overflow: ellipsis; overflow: hidden;"
							align="center"><nobr>${project.pj_etc}
								<nobr></td>
					</tr>
				</c:forEach>
			</table> --%>

		</div>
		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>
