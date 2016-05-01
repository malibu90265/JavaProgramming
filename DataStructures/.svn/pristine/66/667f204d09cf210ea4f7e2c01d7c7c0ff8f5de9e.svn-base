<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="resources/css/teststyle.css" rel="stylesheet" type='text/css'>
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<link href="resources/css/nv.d3.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/lib/d3.v3.js" charset="utf-8"></script>
<script src="resources/nv.d3.js"></script>
<script src="resources/src/tooltip.js"></script>
<script src="resources/src/utils.js"></script>
<script src="resources/src/interactiveLayer.js"></script>
<script src="resources/src/models/legend.js"></script>
<script src="resources/src/models/axis.js"></script>
<script src="resources/src/models/scatter.js"></script>
<script src="resources/src/models/line.js"></script>
<script src="resources/src/models/lineChart.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/excelExport.js" type="text/javascript"></script>

<script type="text/javascript">
	
	$(window).ready(function() {
		
		setNav(0, 2);
		
	});
	function setXaxis(){
		$("#chart1").find("g").find("text").each(function(i,v){
			console.log($(v).html());
		})
	}
	function changeFunc() {
		var formData = document.userForm;
		formData.action = "Chart.do";
		formData.submit();
	}

	defaultChartConfig("chart1", dummyStocks(53), true, true, {
		forceY : true
	});
	function defaultChartConfig(containerid, data, guideline, useDates,auxOptions) {
		if (auxOptions === undefined)
			auxOptions = {};
		if (guideline === undefined)
			guideline = true;
		nv.addGraph(function() {
			var chart;
			chart = nv.models.lineChart().useInteractiveGuideline(guideline);

			chart.x(function(d, i) {
				return d.x;
			});

			if (auxOptions.width)
				chart.width(auxOptions.width);

			if (auxOptions.height)
				chart.height(auxOptions.height);

			if (auxOptions.forceY)
				chart.forceY([ 0 ]);

			chart.margin({
				right : 40
			});
			chart.xAxis // chart sub-models (ie. xAxis, yAxis, etc) when accessed directly, return themselves, not the parent chart, so need to chain separately
			.axisLabel('(주차)').tickFormat(d3.format(","));

			chart.yAxis.axisLabel('(백만원)').tickFormat(d3.format(',.1f'));

			d3.select('#' + containerid + ' svg').datum(data).transition()
					.duration(500).call(chart);

			nv.utils.windowResize(chart.update);

			return chart;
		});
	}
	function dummyStocks(numPoints) {
		numPoints = numPoints || 200;
		function SChart(key, startPrice, Goal, disable, isArea) {
			var rval = {
				key : key,
				values : [],
				disabled : disable
			};
			if (isArea)
				rval.area = true;
			for (var i = 0; i < numPoints; i++) {
				rval.values.push({
					x : i,
					y : startPrice/1000
				});
				var rnp = 27 - i;
				var rnd = 0.2 * rnp;
				var top = 1 + Math.exp(rnd);
				var changePct = 1 / top;
				startPrice = Goal * changePct;

			}
/* 			rval.push(); */
			return rval;
		}
		
		function Flotter(key, startPrice, item ,isArea) {
			var rval = {
				key : key,
				values : []
			};
			if (isArea)
				rval.area = true;
			for (var i = 0; i < item.length+1; i++) {
				rval.values.push({
					x : i,
					y : startPrice/1000
				});
				startPrice = item[i];
			}
			return rval;
		}
		
		
		var stocks = [];
		
		contract = '${requestScope.vo.team_contract}';
		income = '${requestScope.vo.team_income}';
		netincome = '${requestScope.vo.team_net_income}';
		ebit = '${requestScope.vo.team_ebit}';
		
		var contract_arr = new Array();
		var income_arr = new Array();
		var net_income_arr = new Array();
		var ebit_arr = new Array();
		
	  	<c:forEach items="${requestScope.list}" var="list">
	  	contract_arr.push("${list.wc_contract}");
	  	income_arr.push("${list.wc_income}");
	  	net_income_arr.push("${list.wc_netincome}");
	  	ebit_arr.push("${list.wc_ebit}");
	  	</c:forEach>
	  	
	  	stocks.push(Flotter("계약누계", 0, contract_arr));
	  	stocks.push(Flotter("매출누계", 0, income_arr));
		stocks.push(Flotter("순매출누계", 0, net_income_arr));
	  	stocks.push(Flotter("영업이익", 0, ebit_arr));
	  
	  	stocks.push(SChart("계약목표", 0, contract, false));
		stocks.push(SChart("매출목표", 0, income, true));
		stocks.push(SChart("순매출목표", 0, netincome, true));
		stocks.push(SChart("영업이익목표", 0, ebit, true));
		return stocks;
	}
</script>
<title>추세분석</title>
</head>
<body>
	<!-- Top Navigation : 로그인 -->
	<jsp:include page="./common/login_header_mini.jsp"></jsp:include>
	<div style="clear: right;"></div>
	
	<div class="container">
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">추세분석</h1>
		<div style="width: 1200px; margin-left: 170px;">
			<form name="userForm" method="post">
			<table class="search">
				<tr>
					<th>팀별 검색</th>
					<td>
						<select id="selectBox" name="team_id"
							onchange="changeFunc();">
							<option <c:if test="${team_id eq 'all'}"> selected </c:if>
								value="all">전체</option>
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
						</select>
					</td>
				</tr>
			</table>
			<span id="spanSubNameRight">단위:[백만원]</span>
			</form>
			
			<div class='chart full' id='chart1'>
				<svg></svg>
			</div>
		</div>

		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>