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
.hover {
	border: solid;
	border-color: #000000;
	border-collapse: collapse;
	border-width: 0px 0px 0px 0px;
	table-layout: fixed;
}
.hover tr:hover {
	background-color: #ffff99;
	font-weight: bold;
}
.hover td{
height:25px;
	border: 1px solid grey;
}
</style>
<title>직원 현황</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/jquery-1.11.0.js"></script>
<script>

	
	
$(document).ready(function(){

		//TODO
		$("#searchAny").keyup(function() {
			$("tr", "#searchTable").each(function(i, v) {
				var seach = $("#searchAny").val();
				if ($(v).children().eq(1).html().indexOf(seach)) {
					$(v).attr("hidden", true);
				} else {
					console.log("search")
					$(v).attr("hidden", false);

				}
			})
		});
	 $("#search").click(function(){
		 var result="";
		
		 $("tr","#searchTable").each(function(k,v){
				if(($(v).children().eq(0).find("input:checked").attr("id"))!=undefined)
				{
					if(result!="")
						result+="/";
					result+=$(v).children().eq(0).find("input:checked").attr("id");
				}
			}); 
		 window.opener.getReturnPm(result);
		 self.close();
	 });
})
</script>
</head>

<body style="width: 320px; height: 250px;">
	<div class="header" style="height: 50px; width: 320px;">
		<div class="header_area" hieght="50px">
			<div>
				<img src="resources/images/logo.png" />
			</div>
		</div>
	</div>
	<div style="margin-left: 40px; width: 255px; height: 180px;">
		<h3 class="contentsTitle" style="width: 255px; margin: 5px">PM검색<input type="text" id="searchAny" placeholder="이름검색" style=" margin-bottom:5px; margin-left:28%; width: 25%; height: 100%" /></h3>
		<div style="margin-left: 15px">
		<form name="empListForm">

		<table width="180px">
				<tr>
				<th style="width: 20px"> </th>
					<th style="width: 100px">직원명</th>
					<th style="width: 50px">직급</th>
				</tr>
		</table>
		<div style="width:197px; height: 400px; overflow:auto ">
			<table width="170px" class="hover" id="searchTable">
			<c:forEach items="${requestScope.list}" var="member">
				<tr>
					<td style="border-top:0; width: 20px"><input type="checkbox" id="${member.name}"/></td>
					<td style="border-top:0; width: 100px" id="memname">${member.name}</th>
					<td style="border-top:0; width: 50px">${member.position}</td>
				</tr>
			</c:forEach>
		</table>
		</div><p>
			<input type="button" id="search" value="확인"/>
		</form>
		</div>
		</div>
</body>
</html>
