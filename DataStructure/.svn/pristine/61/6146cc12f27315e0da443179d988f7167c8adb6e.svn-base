<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인력 배치 관리</title>

<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="resources/js/pjpostingSearch_Sample.js" type="text/javascript"></script>
<script src="resources/js/skill.js" type="text/javascript"></script>

<style type="text/css">
section {float: left; width: 1410px;}
.container.modity{width: 95%;min-width: 1600px;}
section.leftContent{float: left; width: 44.7%; min-height: 750px;}
section.rightContent{float:left; width: 55%; min-height: 750px; }
section.rightContent .content{margin: 20px 0 20px 24px;}
table.searchBox{  table-layout: fixed;border: 1px; border-spacing: 1; text-align: center; width: 610px;min-height: 350px;}
table.searchResult{  table-layout: fixed;border: 1px; border-spacing: 1; text-align: center; }
.searchResult tr:hover {
	background-color: #ffff99;
	font-weight: bold;
}
table.hoverTable{width:97.8%; border: 0; border-spacing: 1; text-align: center;table-layout: fixed;}
.subTitle{font-weight: bold; font-size: 16px; color: #000075; line-height: 20px; padding-bottom: 5px; margin: 0;}
 .nohoverTable {
	border-collapse: collapse;
	border-width: 0px 0px 0px 0px;
	table-layout: fixed;
	text-align: center;
} 
.nohoverTable tr:hover {
	background-color: #ffff99;
	font-weight: bold;
	border :  150px;
}
.nohoverTable td {
	border: #ADA7A3 1px solid;
}

</style>

<script type="text/javascript">
$(window).ready(function() {
	setNav(2, 1);

    $.datepicker.regional['ko'] = {
        closeText: '닫기',
        prevText: '이전달',
        nextText: '다음달',
        currentText: '오늘',
        monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
        '7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월',
        '7월','8월','9월','10월','11월','12월'],
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        weekHeader: 'Wk',
        dateFormat: 'yy-mm-dd',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '',
//         showOn: 'both',
//         buttonText: "달력",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: 'c-99:c+99',
    };
    $.datepicker.setDefaults($.datepicker.regional['ko']);


    $('#searchstartday').datepicker();
    $('#searchstartday').datepicker("option", "maxDate", $("#searchendday").val());
    $('#searchstartday').datepicker("option", "onClose", function ( selectedDate ) {
        $("#searchendday").datepicker( "option", "minDate", selectedDate );
    });
 
    $('#searchendday').datepicker();
    $('#searchendday').datepicker("option", "minDate", $("#searchstartday").val());
    $('#searchendday').datepicker("option", "onClose", function ( selectedDate ) {
    	$("#searchstartday").datepicker( "option", "maxDate", selectedDate );
    });
    $('#inputperiod_1').datepicker();
    $('#inputperiod_1').datepicker("option", "maxDate", $("#inputperiod_2").val());
    $('#inputperiod_1').datepicker("option", "onClose", function ( selectedDate ) {
        $("#inputperiod_2").datepicker( "option", "minDate", selectedDate );
    });
 
    $('#inputperiod_2').datepicker();
    $('#inputperiod_2').datepicker("option", "minDate", $("#inputperiod_1").val());
    $('#inputperiod_2').datepicker("option", "onClose", function ( selectedDate ) {
    	$("#inputperiod_1").datepicker( "option", "maxDate", selectedDate );
    });
});
</script>
</head>
<body>
	<%-- <jsp:include page="./common/header.jsp"></jsp:include> --%>
	<div class="container modity">
		<%-- <jsp:include page="./common/left.jsp"></jsp:include> --%>
		<section>
			<h1 class="contentsTitle">인력 배치 관리</h1>
			<section class="leftContent">
				<p class="subTitle">◈ 프로젝트 목록 </p>
				<br/>
				<table>
					<colgroup>
						<col style="width: 150px;" />
						<col style="width: 250px;" />
						<col style="width: 150px;" />
					</colgroup>
					<tbody>
						<tr>
							<th>프로젝트ID</th>
							<td><input style="width: 98%" type="text" id=searchid
								name=searchid /></td>
							<td style="border:0px;background-color: white;"></td>
						</tr>
						<tr>
							<th>상태</th>
							<td><select style="width: 99%" name="searchprog"
								id="searchprog">
									<option value="al">ALL</option>
									<option value="4A급">A급</option>
									<option value="3대기">대기
									<option value="2완료">완료</option>
									<option value="1이월">이월</option>
							</select></td>
							<td style="border:0px; background-color: white;"></td>
						</tr>
						<tr>
							<th>기간</th>
							<td><input type="text" style="width: 45%;"
								id="searchstartday" name="searchstartday" class="inputDate"/>~<input type="text"
								style="width: 45%;" id="searchendday" name="searchendday" class="inputDate" /></td>
							<td style="background-color: white;border:0px;"> 
						<!-- 	<input type="button" style="margin-left: 20px" value="프로젝트 검색" id="pjsearchbutton" /> -->
							</td>
						</tr>
						</tbody>
					</table>
					
					<br>
					<table class="searchBox">
						<colgroup>
						<col style="width: 55px;" />
						<col style="width: 95px;" />
						<col style="width: 220px;" />
						<col style="width: 73px;" />
						<col style="width: 43px;" />
						<col style="width: 125px;" />
						</colgroup>
						<thead>
							<tr>
								<th >상 태</th>
								<th >프로젝트ID</th>
								<th >프로젝트 기간</th>
								<th >기반분류</th>
								<th >소요인원</th>
								<th >근무지</th>
							</tr>
						</thead>				
					</table>
					<div id="search_result" style="height:560px;width:100%; overflow-y: auto" ></div> 
			</section>
			<section class="rightContent">
				<div class="content">
					<p class="subTitle">◈ 프로젝트 인력배치 </p>
					<br/>
					<table style="table-layout: fixed;">
					<colgroup>
						<col style="width: 110px;" />
						<col style="width: 110px;" />
						<col style="width: 120px;" />
						<col style="width: 120px;" />
						<col style="width: 120px;" />
					</colgroup>
						<tr>
							<th>성명</th>
							<td><input type="text" style="width:110px" id="inputname" /></td>
							<th>투입기간</th>
							<td><input type="text" style="width:120px" id="inputperiod_1" placeholder="ex) 0000-00-00"/></td>
							<td><input type="text" style="width:120px" id="inputperiod_2" placeholder="ex) 0000-00-00" /></td>
							<td hidden id="division"></td>
						</tr>
					</table>
					<br/>
					<input type="button" style="margin-left: 280px;padding-left:20px;padding-right:20px;" value="저장" id="historysave" />
					<input type="button" style="margin-left: 20px;padding-left:20px;padding-right:20px;" value="삭제" id="historydelete" />
					<input type="button" style="margin-left: 20px;padding-left:20px;padding-right:20px;" value="취소" id="historycancle" />
				</div>
				<div class="content">
					<p class="subTitle">◈프로젝트 투입 현황</p>
					<br/>
					<table class="hoverTable">
						<colgroup>
						<col style="width: 110px;" />
						<col style="width: 220px;" />
						<col style="width: 52px;" />
						<col style="width: 80px;" />
						<col style="width: 52px;" />
						<col style="width: 88px;" />
						<col style="width: 135px;" />
						</colgroup>
						<thead>
							<tr>
								<th >성 명</th>
								<th >프로젝트 기간</th>
								<th >구분</th>
								<th >기반분류</th>
								<th >등급</th>
								<th >전문기술</th>
								<th >거주지</th>
							</tr>
							
						</thead>
						
						</tbody>
					</table>
					<div id="pjposting_talble" 
							style="height: 500px; width: 765px; overflow-y: auto;scrollbars:no;">
							<!-- 현재, 미래 배치된 사람  -->
							<div id="pjposting_result"></div>
							
							<!-- 과거에 배치된 사람  -->
							<div id="pjposting_history"></div>
							</div>
					</div>
				
			<!-- 	<div class="content">
					<p class="subTitle">◈프로젝트 투입 현황</p>
				</div> -->
			</section>
		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>