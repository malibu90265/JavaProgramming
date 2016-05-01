<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="resources/css/common.css" type="text/css">


<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="resources/js/pjpostingSearch.js" type="text/javascript"></script>

<script src="resources/js/skill.js" type="text/javascript"></script>
<script src="resources/js/area.js" type="text/javascript"></script>
<style type="text/css">
body {
	font-family: "NanumGothic", "Dotum", "Gulim", "Arial", sans-serif;
	width: 350px;
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px;
}

.header {
	width: 100%;
	height: 70px;
	background-color: #02458B;
}

.header_area {
	width: 90%;
	height: 100%;
	left: 5%;
	position: relative;
}

.container {
	width: 90%;
	min-height: 820px;
	left: 5%;
	position: relative;
}

.header_area img {
	top: 8px;
	position: relative;
}

.header_area div {
	display: inline-block;
	height: 100%;
}

.header_area h1 {
	display: inline-block;
	color: white;
	margin-left: 30px;
}

.contents {
	display: inline-block;
	width: 1400px;
	vertical-align: top;
}

.contentsTitle {
	border-bottom: 1px solid grey;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

table th {
	background-color: rgb(232, 232, 232);
	border: 1px solid grey;
}

table td {
	border: 1px solid grey;
}
</style>
<script type="text/javascript">

	$(document).ready(function() {
		
		
			window.opener.getPjHistory();
			
		
		///calendar();
	});
	
</script>
</head>
<body style="width: 450px; height: 150px; overflow-x:hidden;  overflow-y:auto;">
	<div class="header" style="height: 50px; width: 640px;">
		<div class="header_area" height="50px">
			<div>
				<img src="resources/images/logo.png" />
			</div>
		</div>
	</div>
	<div style="margin-left: 40px; width: 600px; height: 300px; margin-bottom:40px;">

		<!-- TODO -->
		<h2 class="contentsTitle" style="width: 550px; margin: 5px">프로젝트 투입 이력</h2>
		<div>
			<table style="width: 550px; margin-top:20px" id="pjposting_history">
				<thead>
					<tr>
						<th style="width: 101px" align="center" >성명</th>
						<th style="width: 101px" align="center">직급</th>
						<th style="width: 101px" align="center">등급</th>
						<th style="width: 243px" align="center">투입 시작일</th>
						<th style="width: 243px" align="center">투입 만료일</th>
						
					</tr>
				</thead>
					<tbody id="pjposting_history_tbd">
				
					</tbody>
				</table>
		</div>
		<br/><br/>
		<input type="button" value="닫기" onclick="self.close()"/>
		<br/><br/>
	</div>
	
</body>
</html>