<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	#nonTable {height: 53vh; height: 53vm; overflow-y:auto; overflow-x: hidden; white-space: nowrap;}
	#nonTableTable td {border-bottom: 1px solid #cecece;}
</style>
</head>
<body>
	<div id="laborExcel" class="bordered">
		<table>
			<tr>
				<th rowspan="2" style="width: 9%">프로젝트</th>
				<th rowspan="2" style="width: 9%">직원/외주</th>
				<th rowspan="2" style="width: 9%">성명</th>
				<th rowspan="2" style="width: 9% ">직급/등급</th>
				<th rowspan="2" style="width: 9%">직급단가</th>
				<th colspan="2" style="width: 21%">투입기간</th>
				<th rowspan="2" style="width: 9%">투입률</th>
				<th rowspan="2" style="width: 9%">MM합계</th>
				<th rowspan="2" style="width: 10%">인건비 계</th>
			</tr>
			<tr>
				<th>시작일</th><th>종료일</th>
			</tr>
		</table>
		<div  id="nonTable">
			<table id="nonTableTable" >
				<c:forEach var="costmap" items="${costmapList }" varStatus="i" >
					<c:choose>
						<c:when test="${costmap.pj_id == '합계'}">
							<tr style="background: #EBF5FF;">
								<td style="width: 9%; font-weight: bold;">${costmap.pj_id }</td>
								<td style="width: 10%; text-align:center;"></td>
								<td style="width: 4%;">${costmap.pd_name }</td>
								<td style="width: 9%; text-align:center;">
									<c:choose>
										<c:when test="${costmap.hr_position == null || costmap.hr_position == ''}">
											${costmap.hr_grade }
										</c:when>
										<c:otherwise>
											${costmap.hr_position }
										</c:otherwise>
									</c:choose>
								</td>
								<td style="width: 9%; text-align: right;">
									<c:if test="${costmap.hp_mon_price != 0 }">
										<fmt:formatNumber pattern="#,###" value="${costmap.hp_mon_price }"/>	
									</c:if>
								</td>
								<td style="width: 10%; text-align: center;">${costmap.pd_start_date }</td>
								<td style="width: 10%; text-align: center;">${costmap.pd_end_date }</td>
								<td style="width: 9%; text-align: right;">
									<c:if test="${costmap.pd_ratio != 0 }">
										${costmap.pd_ratio }
									</c:if>
								</td>
								<td style="width: 9%; text-align: right; font-weight: bold;">${costmap.pd_mm }</td>
								<td style="width: 10%; text-align: right; font-weight: bold;"><fmt:formatNumber pattern="#,###" value="${costmap.cost }"/></td>
							</tr>
						</c:when>
						
						<c:when test="${costmap.pj_id == '대기/미배치'}">
							<tr style="background: #EBF5FF;">
								<td style="width: 9%; font-weight: bold;">${costmap.pj_id }</td>
								<td style="width: 10%; text-align:center;">
									<c:choose>
										<c:when test="${costmap.hr_position == null || costmap.hr_position == ''}">
											""
										</c:when>
										<c:otherwise>
											직원
										</c:otherwise>
									</c:choose>
								</td>
								<td style="width: 4%;">${costmap.pd_name }</td>
								<td style="width: 9%; text-align:center;">
									<c:choose>
										<c:when test="${costmap.hr_position == null || costmap.hr_position == ''}">
											${costmap.hr_grade }
										</c:when>
										<c:otherwise>
											${costmap.hr_position }
										</c:otherwise>
									</c:choose>
								</td>
								<td style="width: 9%; text-align: right;">
									<c:if test="${costmap.hp_mon_price != 0 }">
										<fmt:formatNumber pattern="#,###" value="${costmap.hp_mon_price }"/>	
									</c:if>
								</td>
								<td style="width: 10%; text-align: center;">${costmap.pd_start_date }</td>
								<td style="width: 10%; text-align: center;">${costmap.pd_end_date }</td>
								<td style="width: 9%; text-align: right;">
									<c:if test="${costmap.pd_ratio != 0 }">
										${costmap.pd_ratio }
									</c:if>
								</td>
								<td style="width: 9%; text-align: right; font-weight: bold;">${costmap.pd_mm }</td>
								<td style="width: 10%; text-align: right; font-weight: bold;"><fmt:formatNumber pattern="#,###" value="${costmap.cost }"/></td>
							</tr>
						</c:when>
						
						<c:otherwise>
							<tr>
								<td style="width: 9%;">${costmap.pj_id }</td>
								<td style="width: 10%; text-align:center;">
									<c:choose>
										<c:when test="${costmap.hr_position == null || costmap.hr_position == ''}">
											외주
										</c:when>
										<c:otherwise>
											직원
										</c:otherwise>
									</c:choose>
								</td>
								<td style="width: 4%;">${costmap.pd_name }</td>
								<td style="width: 9%; text-align:center;">
									<c:choose>
										<c:when test="${costmap.hr_position == null || costmap.hr_position == ''}">
											${costmap.hr_grade }
										</c:when>
										<c:otherwise>
											${costmap.hr_position }
										</c:otherwise>
									</c:choose>
								</td>
								<td style="width: 9%; text-align: right;">
									<c:if test="${costmap.hp_mon_price != 0 }">
										<fmt:formatNumber pattern="#,###" value="${costmap.hp_mon_price }"/>	
									</c:if>
								</td>
								<td style="width: 10%; text-align: center;">${costmap.pd_start_date }</td>
								<td style="width: 10%; text-align: center;">${costmap.pd_end_date }</td>
								<td style="width: 9%; text-align: right;">
									<c:if test="${costmap.pd_ratio != 0 }">
										${costmap.pd_ratio }
									</c:if>
								</td>
								<td style="width: 9%; text-align: right;">${costmap.pd_mm }</td>
								<td style="width: 10%; text-align: right;"><fmt:formatNumber pattern="#,###" value="${costmap.cost }"/></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
		</div> <!-- nonTable -->
	</div> <!-- laborExcel -->
</body>
</html>