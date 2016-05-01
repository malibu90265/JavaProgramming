<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#projectBudgetInfoDetailTable {width: 40%;}
</style>
</head>

<!--20151110 선택한 상태 별 손익 합계 List를 가져와야 함 -->
<body>
	<div id="projectBudgetInfoDetailForm" >
		<table cellspacing="1" id="projectBudgetInfoDetailTable" class="bordered">
			<tr>
				<th colspan="2" style="width: 100px;" rowspan="3" bgcolor="yellow">구분</th>
				<th rowspan="3" bgcolor="yellow" style="width: 100px;">팀</th>
				<th rowspan="3" bgcolor="yellow" style="width: 100px;">상태</th>
				<th colspan="3" style="text-align: center; width: 100px;">${project.pj_id}</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: right;">${project.pj_start_date}</td>
			</tr>
			<tr>
				<td colspan="3" style="text-align: right;">${project.pj_end_date}</td>
			</tr>
			<tr>
				<th colspan="2" >계약액</th>
				<td style="text-align: right;"><fmt:formatNumber value="${totalSumList.totalContract}" pattern="#,###" /></td> <!-- 팀 -->
				<td style="text-align: right;"></td> <!-- 상태 --> 
				<td colspan="3" style="text-align: right;"><fmt:formatNumber value="${project.totalContract}" pattern="#,###" /></td> <!-- 프로젝트 -->
			</tr>
			<tr>
				<th colspan="2">매출액</th>
				<td style="text-align: right;"><fmt:formatNumber value="${totalSumList.yearSales}" pattern="#,###" /></td> 
				<td style="text-align: right;"><fmt:formatNumber value="${project.yearSales}" pattern="#,###" /></td> 
				<td colspan="3" style="text-align: right;"></td> 
			</tr>
			<tr>
				<th colspan="2">순매출액</th>
				<td style="text-align: right;"><fmt:formatNumber value="${totalSumList.netSales }" pattern="#,###" /></td>
				<td style="text-align: right;"><fmt:formatNumber value="${project.netSales}" pattern="#,###" /></td>
				<td colspan="3" style="text-align: right;"></td>
			</tr>
			<tr>
				<th colspan="2">영업이익</th>
				<td style="text-align: right;"><fmt:formatNumber value="${totalSumList.profitSales }" pattern="#,###" /></td>
				<td style="text-align: right;"><fmt:formatNumber value="${project.profitSales}" pattern="#,###" /></td>
				<td colspan="3" style="text-align: right;"></td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="#ffe6ff">매출원가 합계</td>
				<td bgcolor="#ffe6ff" style="text-align: right;"><fmt:formatNumber value="${totalSumList.totalSalesCost }" pattern="#,###" /></td>
				<td bgcolor="#ffe6ff" style="text-align: right;"><fmt:formatNumber value="${project.totalSalesCost}" pattern="#,###" /></td>
				<td colspan="3" bgcolor="#ffe6ff" style="text-align: right;"></td>
			</tr>
			<tr>
				<th rowspan="7">인건비</th>
			</tr>
			<tr>
				<td bgcolor="#ffe6ff">합계</td>
				<td bgcolor="#ffe6ff" style="text-align: right;"><fmt:formatNumber value="${totalSumList.totalLaborCost }" pattern="#,###" /></td>
				<td bgcolor="#ffe6ff" style="text-align: right;"><fmt:formatNumber value="${project.totalLaborCost}" pattern="#,###" /></td>
				<td colspan="3" bgcolor="#ffe6ff" style="text-align: right;"></td>
			</tr>
			<tr>
				<th>PJ직접</th>
				<td><fmt:formatNumber value="${totalSumList.totalDirectCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${project.totalDirectCost}" pattern="#,###" /></td>
				<td colspan="3" ></td>
			</tr>
			<tr>
				<th>공통/대기</th>
				<td><fmt:formatNumber value="${totalSumList.commonAndWaitCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${project.commonAndWaitCost}" pattern="#,###" /></td>
				<td colspan="3" ></td>
			</tr>
			<tr>
				<th>영업</th>
				<td><fmt:formatNumber value="${totalSumList.totalSales }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${project.totalSales}" pattern="#,###" /></td>
				<td colspan="3" ></td>
			</tr>
			<tr>
				<th>지원</th>
				<td><fmt:formatNumber value="${totalSumList.totalSupport }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${project.totalSupport}" pattern="#,###" /></td>
				<td colspan="3" ></td>
			</tr>
			<tr>
				<th>외주</th>
				<td><fmt:formatNumber value="${totalSumList.totalOutCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${project.totalOutCost}" pattern="#,###" /></td>
				<td colspan="3" ></td>
			</tr>
			<tr>
				<th colspan="2">상품비</th>
				<td><fmt:formatNumber value="${totalSumList.totalMatlCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${project.totalMatlCost}" pattern="#,###" /></td>
				<td colspan="3" ></td>
			</tr>
			<tr>
				<th colspan="2">경비</th>
				<td><fmt:formatNumber value="${totalSumList.totalCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${project.totalCost}" pattern="#,###" /></td>
				<td colspan="3" ></td>
			</tr>
			<tr>
				<th rowspan="3">MM</th>
				<td bgcolor="#ffe6ff">합계</td>
				<td bgcolor="#ffe6ff"><fmt:formatNumber value="${totalSumList.totalLaborMM + totalSumList.totalOutMM}" pattern="#,### ##.#" /></td>
				<td bgcolor="#ffe6ff"><fmt:formatNumber value="${project.totalLaborMM + project.totalOutMM}" pattern="#,### ##.#" /></td>
				<td colspan="3" bgcolor="#ffe6ff"></td>
			</tr>
			<tr>
				<th>직원MM</th>
				<td><fmt:formatNumber value="${totalSumList.totalLaborMM }" pattern="#,### ##.#" /></td>
				<td><fmt:formatNumber value="${project.totalLaborMM}" pattern="#,### ##.#" /></td>
				<td colspan="3" ></td>
			</tr>
			<tr>
				<th>외주MM</th>
				<td><fmt:formatNumber value="${totalSumList.totalOutMM }" pattern="#,### ##.#" /></td>
				<td><fmt:formatNumber value="${project.totalOutMM}" pattern="#,### ##.#" /></td>
				<td colspan="3" ></td>
			</tr>
		</table>




	</div>
</body>
</html>

 --%>
<%-- 2015-11-10 기존 LIST 파일 


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<style type="text/css">


.main_table td {
	border: 1px solid grey;
}

.leftTable {
	width: 600px;	
}

.leftTable tr:last{
	width: 400px;	
	background-color: grey;
}
</style>
<script type="text/javascript">

	$(document).ready(function() {
		/* 파일 다운로드 */
		var d = new Date();
		var filename=d.getFullYear()+"년"+(d.getMonth() + 1)+"월"+d.getDate()+"일"+"팀별 손익정보";
		$("#ExcelExport").click(function() { 
			getExcel($("#budget"), filename);
		});
	})
</script>
</head>
<body>
	<!-- 엑셀파일 다운로드 -->
	<div style="width: 100%; margin-bottom: 10px; text-align: right;">
		<button id="ExcelExport" value="Excel" style="background: transparent; border: none;">
			<img class="logo_img" src="/resources/images/Excel_2013_logo.png" style="width: 15px; height: 15px" />
		</button>
	</div>
	<div id="budget" style="width: 100%">
		<!-- HEADER -->
		<table cellspacing="1" class="bordered">
			<tr>
				<th rowspan="3" class="pjStatusT">상태</th>
				<th rowspan="3" class="pjIdT">프로젝트ID</th>
				<th rowspan="3" class="pjNameT">프로젝트명</th>
				
				<th rowspan="3" class="pjDateT">시작일</th>
				<th rowspan="3" class="pjDateT">완료일</th>
				<th rowspan="3" class="NumT">계약액</th>
				<th rowspan="3" class="NumT">매출액</th>
				<th rowspan="3" class="NumT">순매출액</th>
				<th rowspan="3" class="NumT">영업이익</th>
				<th colspan="9" class="NumTT">매출원가</th>
				<th colspan="3" class="MMTT">M/M</th>
			</tr>
			<tr>
				<th rowspan="2" class="NumT" style="border-left: 1px solid #ccc">합계</th>
				<th colspan="6" class="NumST">인건비</th>
				<th rowspan="2" class="NumT">상품비</th>
				<th rowspan="2" class="NumT">경비</th>
				<th rowspan="2" class="MM" style="border-left: 1px solid #ccc">계</th>
				<th rowspan="2" class="MM">직원</th>
				<th rowspan="2" class="MM">외주</th>
			</tr>
			<tr>
				<th class="NumT">계</th>
				<th class="NumT">PJ직접</th>
				<th class="NumT">공통/대기</th>
				<th class="NumT">영업</th>
				<th class="NumT">지원</th>
				<th class="NumT">외주</th>
			</tr>
			<!-- 합계 (분홍색 행) -->
			<tr bgcolor="#ffe6ff" style='font-weight: bold; font-size:1.2vm; font-size:1.2vh;'>
				<td colspan="5" align="center">합계</td>
				<td><fmt:formatNumber value="${totalSumList.totalContract}" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.yearSales}" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.netSales }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.profitSales }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalSalesCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalLaborCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalDirectCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.commonAndWaitCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalSales }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalSupport }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalOutCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalMatlCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalCost }" pattern="#,###" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalLaborMM + totalSumList.totalOutMM}" pattern="#,### ##.#" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalLaborMM }" pattern="#,### ##.#" /></td>
				<td><fmt:formatNumber value="${totalSumList.totalOutMM }" pattern="#,### ##.#" /></td>
			</tr>
		</table>
		
		<div id="projectBudgetInfoListTable">
			<table cellspacing="1" class="bordered">
				<!-- 프로젝트 데이터 -->
				<c:forEach var="project" items="${resultList}">
					<tr class="dataList">
						<td class="pjStatusT">${project.pj_status}</td>
						<td class="pjIdT">${project.pj_id}</td>
						<td class="pjNameT">${project.pj_name}</td>
						<td class="pjDateT">${project.pj_start_date}</td>
						<td class="pjDateT">${project.pj_end_date}</td>
						
						<!-- 계약액 -->
						<td class="NumT"><fmt:formatNumber value="${project.totalContract}" pattern="#,###" /></td>
						<!-- 매출액  -->
						<td class="NumT"><fmt:formatNumber value="${project.yearSales}" pattern="#,###" /></td>
						<!-- 순매출액 -->
						<td class="NumT"><fmt:formatNumber value="${project.netSales}" pattern="#,###" /></td>
						<!-- 영업이익  -->
						<td class="NumT"><fmt:formatNumber value="${project.profitSales}" pattern="#,###" /></td>
						<!--  매출원가 합계 -->
						<td class="NumT"><fmt:formatNumber value="${project.totalSalesCost}" pattern="#,###" /></td>
						<!-- 인건비 합계  -->
						<td class="NumT"><fmt:formatNumber value="${project.totalLaborCost}" pattern="#,###" /></td>
						<!-- pj 직접 합계  -->
						<td class="NumT"><fmt:formatNumber value="${project.totalDirectCost}" pattern="#,###" /></td>
						<!-- 공통/대기 합계  -->
						<td class="NumT"><fmt:formatNumber value="${project.commonAndWaitCost}" pattern="#,###" /></td>
						<!-- 영업합계  -->
						<td class="NumT"><fmt:formatNumber value="${project.totalSales}" pattern="#,###" /></td>
						<!-- 지원합계 -->
						<td class="NumT"><fmt:formatNumber value="${project.totalSupport}" pattern="#,###" /></td>
						<!-- 외주합계 -->
						<td class="NumT"><fmt:formatNumber value="${project.totalOutCost}" pattern="#,###" /></td>
						<!-- 상품비합계  -->
						<td class="NumT"><fmt:formatNumber value="${project.totalMatlCost}" pattern="#,###" /></td>
						<!-- 경비합계  -->
						<td class="NumT"><fmt:formatNumber value="${project.totalCost}" pattern="#,###" /></td>
						<!-- MM 계  -->
						<td class="MM"><fmt:formatNumber value="${project.totalLaborMM + project.totalOutMM}" pattern="#,### ##.#" /></td>
						<!-- MM 직원 -->
						<td class="MM"><fmt:formatNumber value="${project.totalLaborMM}" pattern="#,### ##.#" /></td>
						<td>${project.totalLaborMM}</td>
						<!-- MM 외주 -->
						<td class="MM"><fmt:formatNumber value="${project.totalOutMM}" pattern="#,### ##.#" /></td>
					</tr>	
				</c:forEach>
			</table>
		</div>	
	</div>
</body>
</html> --%>