<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>직원 현황</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/history.js" type="text/javascript"></script>
<script>

	
	
function setCus(Obj,name){
	console.log(name)
	console.log(Obj)
//	Obj="#"+Obj;
	var val= window.opener.document.getElementById(Obj);
	val.value=name;
	self.close();
}
</script>
</head>

<body style="width: 350px; height: 250px;">
	<div class="header" style="height: 50px; width: 350px;">
		<div class="header_area" hieght="50px">
			<div>
				<img src="resources/images/logo.png" />
			</div>
		</div>
	</div>
	<div style="margin-left: 40px; width: 300px;">
		<h2 class="contentsTitle" style="width: 280px; margin: 5px">${requestScope.list[0].name}의 단가이력</h2>
		<form name="empListForm">
		<div style="margin-left: 10px;">
		<table style="width: 260px">
			<thead>
				<tr>
					<th style="width: 21px"></th>
					<th style="width: 100px">계 약 일</th>
					<th style="width: 50px">단 가</th>
					<th style="width: 75px">투입 인원</th>
				</tr>
			</thead>
			</table>
			<div style="height: 200px; overflow-y:auto  ">
			<table style="width: 260px" id="searchTable" name="searchTable">
			<c:forEach items="${requestScope.list}" var="cus">
				<tr class="customer">
					<td style="border-top:0; width: 21px" align="center"><input type="checkbox"  /></td>
					<td style="border-top:0; width: 100px" align="center" class="customer_credit">${cus.hire_date}</td>
					<td style="border-top:0; width: 50px" align="center" class="customer_credit">${cus.salary}</td>
					<td style="border-top:0; width: 75px" align="center" class="customer_credit">${cus.mpm}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		</div>
		<p>
		<div style="margin-left: 210px">
		<input type="button" id="delete" value="삭제">
		</div>
		</form>
		</div>
</body>
</html>
