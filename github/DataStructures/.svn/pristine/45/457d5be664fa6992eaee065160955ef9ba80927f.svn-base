<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>추세분석</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/total/week_chart.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main_css/demo.css"/>" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/total/week_chart.js"/>"></script>
<link rel="stylesheet" type="text/css" href="/resources/js/total/nvd3/build/nv.d3.css" />
<script src="/resources/lib/d3.v3.js" charset="utf-8"></script>
<script src="/resources/nv.d3.js"></script>
<script src="/resources/src/tooltip.js"></script>
<script src="/resources/src/utils.js"></script>
<script src="/resources/src/interactiveLayer.js"></script>
<script src="/resources/src/models/legend.js"></script>
<script src="/resources/src/models/axis.js"></script>
<script src="/resources/src/models/scatter.js"></script>
<script src="/resources/src/models/line.js"></script>
<script src="/resources/src/models/lineChart.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		getMiniHeaderAjax();
		getWeekChartSearchPageAjax();
		
	});
</script>
</head>
<body>
	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader"></div>
	
	<div class="container">
		<div class="contents">
			<h1 class="contentsTitle">추세분석</h1>
			
			<div id="week_chart_searchForm"></div>
			
			<div id="week_chart"></div>
		</div>
	</div>
	
</body>
</html>
