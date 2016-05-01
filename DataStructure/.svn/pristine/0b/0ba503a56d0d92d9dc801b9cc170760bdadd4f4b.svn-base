<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script> 
</head>
<body>
	<c:forEach var="hrPriceList" items="${hrPriceListByTeam}" varStatus="status">
		<div style="width:376px; float: left">
			<h3 style="text-align: left; margin: 5px;">${teamNameList.get(status.index) }</h3>
			<table class="bordered">
				<tr>
					<th class="hp_position">직급</th>
					<th class="hp_mon_price">월 단가(직접비)</th>
					<th class="hp_mon_cost">월 비용 (간접비 포함)</th>
				</tr>
				<c:forEach var="hrPrice" items="${hrPriceList }">
					<tr>
						<td class="hp_position">${hrPrice.hp_position }</td>
						<td class="hp_mon_price" style="text-align: right;"><fmt:formatNumber pattern="#,###" value="${hrPrice.hp_mon_price }"/></td>
						<td class="hp_mon_cost" style="text-align: right;"><fmt:formatNumber pattern="#,###" value="${hrPrice.hp_mon_cost }"/></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${status.count % 3 == 0 }">
			<div style="clear: both;"></div>
		</c:if>
	</c:forEach>
	<div style="clear: both;"></div>
</body>
</html>