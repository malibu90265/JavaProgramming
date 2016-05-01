<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>jQuery DynaMeter Plugin</title>
	
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/gage/css/libs/jquery-ui-1.10.3.custom.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/gage/css/libs/jquery.snippet.min.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/gage/css/jquery.dynameter.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/gage/css/gage.css">
</head>
<body>
<!-- 계약액 달성율 계산 -->
<c:set var="contractReal" value="${gageRealVO.contractReal}"/>
<c:set var="contractGoal" value="${gageGoalVO.contractGoal}"/>
<fmt:parseNumber var="var1" value="${ (contractReal/contractGoal)*100}" integerOnly = "true"/>
<!-- 매출액 달성율 계산 -->
<c:set var="SalesReal" value="${gageRealVO.salesReal}"/>
<c:set var="SalesGoal" value="${gageGoalVO.salesGoal}"/>
<fmt:parseNumber var="var2" value="${ (SalesReal/SalesGoal)*100}" integerOnly = "true"/>
<!-- 순매출 달성율 계산  -->
<c:set var="netSalesReal" value="${gageRealVO.salesReal}"/>
<c:set var="netSalesGoal" value="${gageGoalVO.salesGoal}"/>
<fmt:parseNumber var="var3" value="${ (netSalesReal/netSalesGoal)*100}" integerOnly = "true"/>
<!-- 영업이익 달성율 계산 -->
<c:set var="profitReal" value="${gageRealVO.profit}"/>
<c:set var="profitGoal" value="${gageGoalVO.profit}"/>
<fmt:parseNumber var="var3" value="${ (profitReal/profitGoal)*100}" integerOnly = "true"/>
<div id = "gage2">
	<!-- <div id="contractDiv"></div> -->
	<table border="1" class="bordered">
		<tr >
			<th colspan="2" >계약액</th>
			<th colspan="2" >매출액</th>
			<th colspan="2" >순매출</th>
			<th colspan="2" >영업이익</th>
		</tr>
		<tr>
			<th><div id="contractDiv"></div></th>
			<td>목표: <fmt:formatNumber value="${gageGoalVO.contractGoal}" pattern="#,###" />억</td>
			<th><div id="yearSalesDiv"></div></th>
			<td>목표: <fmt:formatNumber value="${gageGoalVO.salesGoal}" pattern="#,###" />억</td>
			<th><div id="netSalesDiv"></div></th>
			<td>목표: <fmt:formatNumber value="${gageGoalVO.netSalesGoal}" pattern="#,###" />억</td>
			<th><div id="profitDiv"></div></th>
			<td>목표: <fmt:formatNumber value="${gageGoalVO.profit}" pattern="#,###" />억</td>
		</tr>
</table>
</div>
	
	<script type="text/javascript" src="/resources/css/main_css/gage/js/libs/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="/resources/css/main_css/gage/js/libs/jquery-ui-1.10.3.custom.min.js"></script>
	<script type="text/javascript" src="/resources/css/main_css/gage/js/libs/jquery.snippet.min.js"></script>
	<script type="text/javascript" src="/resources/css/main_css/gage/js/jquery.dynameter.js"></script>
	<script type="text/javascript">
		var $contractMeter, $yearSalesMeter, $netSalesMeter;
		$( function () {
			
		    $contractMeter = $("#contractDiv").dynameter({
		    	width: 250,
		    	label: <fmt:parseNumber value="${(contractReal/contractGoal)*100}" integerOnly = "true"/>+'% 달성',
		    	value: <c:out value="${gageRealVO.contractReal}"/>,
		    	min: 0,
		    	max: <c:out value="${gageGoalVO.contractGoal}"/> ,
		    	unit:'',
		    	regions: {
		    		.1: 'error',
		    		.2: 'warn',
		    		.3: 'normal'
		    	}
		    });
	       
		    $yearSalesMeter = $("#yearSalesDiv").dynameter({
		    	width: 250,
		    	label: <fmt:parseNumber  value="${ (SalesReal/SalesGoal)*100}" integerOnly = "true"/>+'% 달성',
		    	value: <c:out value="${gageRealVO.salesReal}" />,
		    	min: 0.0,
		    	max: <c:out value="${gageGoalVO.salesGoal}" />,
		    	unit: '',
		    	regions: {
		    		.1: 'error',
		    		.2: 'warn',
		    		.3: 'normal'
		    	}
		    });
		   
		    
		 
		    $netSalesMeter = $("#netSalesDiv").dynameter({
		    	width: 250,
		    	label: <fmt:parseNumber value="${ (netSalesReal/netSalesGoal)*100}" integerOnly = "true"/>+'% 달성',
		    	value: <c:out value="${gageRealVO.netSalesReal}" />,
		    	min: 0,
		    	max: <c:out value="${gageGoalVO.netSalesGoal}" />,
		    	unit: ' ',
		    	regions: {
		    		.1: 'error',
		    		.2: 'warn',
		    		.3: 'normal'
		    	}
		    });
	       
	        
	     
		    $profit = $("div#profitDiv").dynameter({
		    	width: 250,
		    	label: <fmt:parseNumber  value="${ (profitReal/profitGoal)*100}" integerOnly = "true"/>+'% 달성',
		    	value: <c:out value="${gageRealVO.profit}" />,
		    	min: 0,
		    	max: <c:out value="${gageGoalVO.profit}" />,
		    	unit: '',
		    	regions: {
		    		.01: 'error',
		    		.02: 'warn',
		    		.03: 'normal'
		    	}
		    });
	       

			// Initialize code panels.
			/* $('pre.sh_html').snippet('html',{style:"dull",showNum:false});
			$('pre.sh_javascript').snippet('javascript',{style:"dull",showNum:false}); */
		});
	</script>

</body>

</html>