<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.1.min.js">
	
	
	
</script>


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
	
	function isNumber(evt) {
    	evt = (evt) ? evt : window.event;
    	var charCode = (evt.which) ? evt.which : evt.keyCode;
    	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    			return false;
    		}
    	return true;
	}
	
	var SetComma = function(str) {

		str = str.replace(/,/g, '');
		var retValue = "";
		for (i = 1; i <= str.length; i++) {
			if (i > 1 && (i % 3) == 1)
				retValue = str.charAt(str.length - i) + "," + retValue;
			else
				retValue = str.charAt(str.length - i) + retValue;
		}

		return retValue;
	}
	
	function budgetUpdate(pj_id){
		var check = confirm("저장하시겠습니까?");
		if (check) {
			var formData = document.userForm;
	 		formData.action="updateBudgetCost.iqspf?pj_id="+pj_id;
	 		formData.submit();
	 		self.close();
	 		} else {
			return;
		}
 	}
	
	
</script>

<title>상품비/추가경비 수정</title>
</head>
<body style="width: 350px; height: 250px;">
	<div class="header" style="height: 50px; width: 672px;">
		<div class="header_area" hieght="50px">
			<div>
				<img src="resources/images/logo.png" />
			</div>
		</div>
	</div>
	<div style="margin-left: 40px; width: 610px; height: 200px;">

		<!-- TODO -->
		<h3 class="contentsTitle" style="width: 600px; margin: 5px">상품비/추가경비
			수정</h3>
		<form name="userForm" method="post">
			<table>

				<thead>
					<tr>
						<th style="width: 120px">프로젝트 ID</th>
						<td style="width: 120px" align="center">${vo.pj_id}<input type="text" name="team_id" id="team_id" value="${vo.team_id}" hidden></td>
						<th style="width: 150px">프로젝트 명</th>
						<td style="width: 150px" align="center">${vo.pj_name}</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>상품비</th>
						<td><input type="text" class="text"
							name="budget_product_cost" 
							style="ime-mode: disabled; text-align: right; width: 99%"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.budget_product_cost}" /></td>
						<th>추가경비</th>
						<td><input type="text" class="text" name="pj_extra_cost"
							style="ime-mode: disabled; text-align: right; width: 99%"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.pj_extra_cost}" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		<div style="text-align: right; margin-top: 7px;">
			<input type="button" value="저장"
				onclick="budgetUpdate('${requestScope.vo.pj_id}')" />&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="취소" onclick="teamList()" />&nbsp;&nbsp;
		</div>
	</div>
</body>
</html>