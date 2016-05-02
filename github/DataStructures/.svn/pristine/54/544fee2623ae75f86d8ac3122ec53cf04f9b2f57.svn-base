<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새 프로젝트 추가</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/customerManager.js" type="text/javascript"></script>
<script type="text/javascript">
	$(window).ready(function() {
		//TODO
		setNav(1,5);
	});
</script>
<style type="text/css">
.fuck td {
	border: 0;
}

.main_table {
	border: solid;
	border-color: #000000;
	border-collapse: collapse;
	border-width: 0px 0px 0px 0px;
	table-layout: fixed;
}

.main_table td {
	height: 23px;
	border: 1px solid grey;
}

.main_table tr:hover {
	background-color: #ffff99;
	font-weight: bold;
}
</style>
</head>

<body>
<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">고객 관리</h1>
		<div id="wrap" style="width: 1900px; margin: auto;">
			<input id="outemp" type="hidden" value="">
			<div id="main" style="margin-top: 10px;">
				<div id="left_main"
					style="height: 600px; width: 500px; background: white; margin-right: 20px; float: left;">
					<table style="width: 480px">
						<tr>
							<th style="width: 100px">업체 구분</th>
							<td><select style="width: 100%" name="searchteam" id="searchcus">
									<option value="">전체</option>
									<option value="수주계약">수주계약업체</option>
									<option value="외주업체">외주업체</option>
									<option value="상품판매">상품판매업체</option>
							</select></td>
							<th style="width: 100px" >고 객 명</th>
							<td><input style="width: 96%" type=text name=searchname id=searchid></td>
						</tr>
					</table>
					<div
						style="text-align: right; margin-top: 5px; margin-bottom: 18px; margin-right: 10px">
					<!-- 	<input type="button" id=searchbutton value="검색" />&nbsp;&nbsp; --><br/>
					</div>
					<div id="search_result"></div>
				</div>

				<div id="right_main"
					style="height: 600px; width: 650px; background: white; float: left; margin-left: 70px; margin-top:4%">
					<form name="userForm" method="post">
						<table style="width: 550px">
							<thead>
								<tr>
									<th style="height: 30px" colspan="5" align="center">고객 정보</th>
								</tr>
							</thead>
							<tr>
									<th style="width:150px; height: 25px">구분</th>
								<td><select style="width: 100%; height: 100%" id="customer_div"><option value="">선택하세요
								<option value=0>수주계약
								<option value=1>외주업체
								<option value=2>상품판매
								</select></td>
								</tr>
								<tr>
								<th style="width:150px; height: 25px">고객 명*</th>
								<td style="width: 200px"><input type="text" name="customer_name" id="customer_name" style="width: 98%"
									placeholder="ex)KT" /><input type="text" id="h_name" hidden ></td>

							</tr>
							<tr>
								<th style="height: 25px">신용등급</th>
								<td><input style="width:98%; height: 100%;"type="text" name="customer_credit" id="customer_credit" /></td>
							</tr>
							<tr>
								<th style="height: 25px">사업자 등록번호</th>
								<td><input type="text" name="customer_name"
									id="customer_regno" style="width:98%; height: 100%;ime-mode: disabled;"
									placeholder="10자리" /> 
							</tr>
							<tr>
								<th style="height: 25px">대표이사 명</th>
								<td><input type="text" name="customer_head"
									id="customer_head" style="width:98%;height: 100%; ime-mode: disabled;"
									 /> 
							</tr>
							<tr>
								<th style="height: 25px">고객 주소</th>
								<td><input type="text" name="customer_loc"
									id="customer_loc" style="width:98%; height: 100%;ime-mode: disabled;"
									 /> 
							</tr>
							<tr>
								<th style="height: 61px">비고</th>
								<td colspan="3"><textarea name="etc" id="etc"
										style="width: 97%; height: 100%;" ></textarea></td>
							</tr>
						</table>
						<div style="margin-left:60%; margin-top: 7px;">
							<input type="button" value="저장" id="update" />&nbsp;&nbsp;
							<input type="button" value="삭제" id="delete" disabled=true />&nbsp;&nbsp;
							<input type="button" value="취소" id="cancel" />&nbsp;&nbsp;
						</div>
					</form>
				</div>
		</section>
	</div>
		<jsp:include page="./common/footer.jsp"></jsp:include>


</body>
</html>