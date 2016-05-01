<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>인력 배치 현황</title>

<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/jquery-1.11.0.min.js"></script>
<script src="resources/js/emp_standby.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script src="resources/reveal/jquery.reveal.js"></script>
<script src="resources/js/emp_detail.js"></script>
<script src="resources/js/teamName.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<link rel="stylesheet" type="text/css"
	href="resources/reveal/reveal.css">
<style type="text/css">
body {
	font-family: "HelveticaNeue", "Helvetica-Neue", "Helvetica", "Arial",
		sans-serif;
}

.big-link {
	display: block;
	text-align: center;
	color: #06f;
}

.fuck td {
	border: 0;
}

.hoverTable {
	border-collapse: collapse;
	border-width: 0px 0px 0px 0px;
	table-layout: fixed;
	border-collapse: collapse;
}

.hoverTable td {
	height: 25px;
	border: #4e95f4 1px solid;
}

.hoverTable tr:hover {
	background-color: #ffff99;
	font-weight: bold;
}

.nohoverTable {
	border-collapse: collapse;
	border-width: 0px 0px 0px 0px;
	table-layout: fixed;
	border-collapse: collapse;
}

.nohoverTable td {
	height: 25px;
	border: #4e95f4 1px solid;
}

a:VISITED {
	color: blue;
}

/* .hoverTable tr:ACTIVE {
        background-color: blue;
} */
</style>
<script>
	/* $(window).ready(function() {

		setNav(2, 2);
	}); */
	
	/* $(document).ready(function() {
		
	}); */
</script>

</head>


<body>
	<div class="container">
		<section class="contents"> 
		<h1 class="contentsTitle">인력 배치 현황</h1>
		<table>
			<tr id="appendTd">
				<th style="width:100px; height:30px;">배치 현황</th>
				<th>
					<select id="sel" name="sel" style="width: 150px; height: 30px;" onChange="selectEvent(this)"> 
							<option value="teampj" selected="selected" style="text-align: center;">PJ별 투입현황</option>
							<option value="empmap" style="text-align: center;">직원/외주 투입맵</option>
							<option value="standby" style="text-align: center;">미배치v대기 현황</option>
					</select> 
					<!-- <input type="hidden" value="검색" id="search" /> -->
				</th>
			</tr>
		</table>
				<!-- <td class="inputContent" style="width:160px; height:30px; float: left; ">
						<input class="input_check" id="1Schk" name="input_chk" type="radio" value="1S" /> SI1 
						<input class="input_check" id="2Schk" name="input_chk" type="radio" value="2S" /> SI2 
						<input class="input_check" id="Enchk" name="input_chk" type="radio" value="En" /> Energy
				</td>
				<td id="divisionEmp" style="width:160px; height:30px; float: left; ">
					<input type="radio" name="division" id="emp_form" value="직원" checked onclick="emp_map()"/>직원
					<input type="radio" name="division" id="out_form" value="외주" onclick="out_map()"/>외주
				</td> -->
		<br>



		<div id="alldiv" style="float: inherit; height: 600px;">
			<!-- detailList  -->
			<div id="standByInfo1" style="float: left; margin: 0 auto;">
				<div id="standByInfo" style="display: inline; float: inherit;  "></div>
				<div id="detailProject" style="display: inline; float: inherit;"></div>
			</div>
			<div id="standByInfo2" style="display: inline; float: inherit;  "></div>
			<div id="standByInfo3" style="display: inline; float: inherit;"></div>

		</div>
		
		
		<div id="myModal" class="reveal-modal"></div>
		</section>
	</div>

</body>

</html>