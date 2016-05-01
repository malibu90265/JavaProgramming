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

<script>
$(document).ready(function(){
	$('#reg_btn').click(function(){
		$.ajax({
			type : "POST",
			url:"/customerUpdate.action",
			async : false,
			dataType : "json",
			data:{				
				customer_div : 0,
				customer_name : customer_name.value,
				customer_credit : customer_credit.value,
				customer_head : "",
				customer_loc : "",
				etc : "",
				h_name : "",
				customer_regno : customer_regno.value
			},

			success : function() {	
				alert("등록되었습니다")			
				self.close();
			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}			
		});
		
	});	
	
}); 
</script>
</head>

<body style="width: 350px; height: 250px;">
	<div class="header" style="height: 50px; width: 400px;">
		<div class="header_area">
			<div>
				<img src="resources/images/logo.png" />
			</div>
		</div>
	</div>
	<div style="margin-left: 40px; width: 305px; height: 180px;">
		<h2 class="contentsTitle" style="width: 305px; margin: 5px">고객 신규 등록</h2>
		<form name="empListForm">
			<table>
				<thead>
					<tr>
						<th>고객구분</th>
						<td >
						<input type="radio" name="customer_div" id="cutomer_div" checked value="수주계약">수주계약<br>
						<input type="radio" name="customer_div" id="cutomer_div" value="외주업체" disabled>외주업체<br>
						<input type="radio" name="customer_div" id="cutomer_div" value="상품구매" disabled>상품구매
						</td>

					</tr>
					<tr>
						<th>고객명</th>
						<td><input type="text" class="text" name="customer_name"
							id="customer_name"
							style="width: 98%; ime-mode: disabled; text-align: right;"/></td>
					</tr>
					<tr>
						<th>신용등급</th>
						<td><input type="text" class="text" name="customer_credit"
							id="customer_credit"
							style="width: 98%; ime-mode: disabled; text-align: right;"/></td>
					</tr>
					<tr>
						<th>사업자 등록번호</th>
						<td><input type="text" class="text"
									name="customer_regno" id="customer_regno"
									style="width:98%; ime-mode: disabled; text-align: right;"/>
						</td>
					</tr>
				</thead>
				
			</table>
			<p>
			<input type="button" id ="reg_btn" value="등록" />
		</form>
	</div>
</body>
</html>
