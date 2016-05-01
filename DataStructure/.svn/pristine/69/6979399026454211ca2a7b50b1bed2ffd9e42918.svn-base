<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인력 배치 관리</title>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
<script	src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script	src="http://malsup.github.com/jquery.form.js"></script>
<script	src="resources/js/pjpostingSearch_Sample.js" type="text/javascript"></script>
<script src="resources/js/skill.js" type="text/javascript"></script>

<script type="text/javascript">
	$(window).ready(
		function() {
			setNav(2, 1);
			$.datepicker.regional['ko'] = {
				closeText : '닫기'
				, prevText : '이전달'
				, nextText : '다음달'
				, currentText : '오늘'
				, monthNames : [ '1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)'
									, '5월(MAY)', '6월(JUN)', '7월(JUL)', '8월(AUG)'
									, '9월(SEP)', '10월(OCT)', '11월(NOV)', '12월(DEC)' ]
				, monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월'
										,'7월', '8월', '9월', '10월', '11월', '12월' ]
				, dayNames : [ '일', '월', '화', '수', '목', '금', '토' ]
				, dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ]
				, dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ]
				, weekHeader : 'Wk'
				, dateFormat : 'yy-mm-dd'
				, firstDay : 0
				, isRTL : false
				, showMonthAfterYear : true
				, yearSuffix : ''
				, changeMonth : true
				, changeYear : true
				, showButtonPanel : true
				, yearRange : 'c-99:c+99'
			};
			$.datepicker.setDefaults($.datepicker.regional['ko']);
			$('#searchstartday').datepicker();
			$('#searchstartday').datepicker("option", "maxDate", $("#searchendday").val());
			$('#searchstartday').datepicker( "option", "onClose", function(selectedDate) {
				$("#searchendday").datepicker("option", "minDate", selectedDate);
			});
			$('#searchendday').datepicker();
			$('#searchendday').datepicker("option", "minDate", $("#searchstartday").val());
			$('#searchendday').datepicker("option", "onClose", function(selectedDate) {
				$("#searchstartday").datepicker("option", "maxDate", selectedDate);
			});
			$('#inputperiod_1').datepicker();
			$('#inputperiod_1').datepicker("option", "maxDate", $("#inputperiod_2").val());
			$('#inputperiod_1').datepicker("option", "onClose", function(selectedDate) {
				$("#inputperiod_2").datepicker("option", "minDate",	selectedDate);
			});
			$('#inputperiod_2').datepicker();
			$('#inputperiod_2').datepicker("option", "minDate", $("#inputperiod_1").val());
			$('#inputperiod_2').datepicker("option", "onClose", function(selectedDate) {
				$("#inputperiod_1").datepicker("option", "maxDate",	selectedDate);
			});
		});
</script>
</head>
<body>
	<jsp:include page="./common/login_header_mini.jsp"></jsp:include>
	<div class="container modity">
		<section class="contents">
			<h1 class="contentsTitle">인력 배치 관리</h1>
			<section class="leftContents" >
				<div class="contentsTitle" >
				<span>프로젝트 목록</span>
				</div>
				<div style="clear: right;"></div>
					<div>
					<table class="search" style="float: left;">
						<tbody>
							<tr>
								<th>프로젝트ID</th>
								<td colspan="3" style="border: 0px; background-color: white;">
									<input style="width: 100%" type="text" id=searchid name=searchid />
								</td>
							</tr>
							<tr>
								<th>상태</th>
								<td colspan="3" style="border: 0px; background-color: white;">
									<select style="width: 99%" name="searchprog" id="searchprog">
										<option value="al">ALL</option>
										<option value="4A급">A급</option>
										<option value="3대기">대기
										<option value="2완료">완료</option>
										<option value="1이월">이월</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>기간</th>
								<td style="background-color: white; border: 0px;">
									<input type="text" style="width:100%;" id="searchstartday" name="searchstartday" class="inputDate" />
								</td>

								<td style="background-color: white; border: 0px;">~
								</td>
								
								<td style="background-color: white; border: 0px;">
									<input type="text" style="width: 100%; float:right;" id="searchendday" name="searchendday" class="inputDate" />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div style="clear: right;"></div>
				<table class="bordered" style="width:100%">
					<colgroup>
						<col style="width: 46px;" />
						<col style="width: 80px;" />
						<col style="width: 154px;" />
						<col style="width: 43px;" />
						<col style="width: 43px;" />
						<col style="width: 125px;" />
					</colgroup>
					<thead>
						<tr>
							<th>상 태</th>
							<th>프로젝트ID</th>
							<th style="text-align: center;">프로젝트 기간</th>
							<th style="text-align: center;">기반<br/><br/><br/>분류</th>
							<th style="text-align: center;">소요<br/><br/><br/>인원</th>
							<th style="text-align: center;">근무지</th>
						</tr>
					</thead>
				</table>
				<div id="search_result"
					style="height: 560px; width: 100%; overflow-y: auto"></div>
			</section>
			<section class="rightContents">
				<div class="content">
					<span id="spanSubNameLeft">프로젝트 인력배치</span>
					<br />
					<table class="search" style="float: left; clear: right;">
						<tr>
							<th>성명</th>
							<td>
								<input type="text" id="inputname" style="width:100px;"/>
							</td>
							<th>투입기간</th>
							<td>
								<input type="text" id="inputperiod_1" placeholder="ex) 0000-00-00" style="width:41%;"/>
								~
								<input type="text" id="inputperiod_2" placeholder="ex) 0000-00-00" style="float:rigth; width:41%"/>
							</td>
							<td hidden id="division"></td>
						</tr>
					</table>
					<div style="float:right; clear: inherit; padding-right: 35px;">
						<input type="button" value="저장" id="historysave" /> 
						<input type="button" value="삭제" id="historydelete" /> 
						<input type="button" value="비우기" id="historycancle" />
					</div>
				</div>
				<div style="clear: both;"></div>
				<div class="content">
					<div class="contentsTitle">
						<span>프로젝트 투입 현황</span>
					</div>
					<div style="clear: both;"></div>
					<div>
					<table class="bordered" style="width: 665px;">
						<colgroup>
							<col style="width: 107px;" />
							<col style="width: 217px;" />
							<col style="width: 52px;" />
							<col style="width: 80px;" />
							<col style="width: 52px;" />
							<col style="width: 88px;" />
							<col style="width: 135px;" />
							</colgroup>
						<thead>
							<tr>
								<th style="text-align: center;">성 명</th>
								<th style="text-align: center;">프로젝트 기간</th>
								<th style="text-align: center;">구분</th>
								<th style="text-align: center;">기반<br/><br/><br/>분류</th>
								<th style="text-align: center;">등급</th>
								<th style="text-align: center;">전문기술</th>
								<th style="text-align: center;">거주지</th>
							</tr>
						</thead>
						</tbody>
					</table>
					</div>
					<div id="pjposting_talble" style="height: 500px; width: 765px; overflow-y: auto; scrollbars: no;">
						<!-- 현재, 미래 배치된 사람  -->
						<div id="pjposting_result"></div>
						<!-- 과거에 배치된 사람  -->
						<div id="pjposting_history"></div>
					</div>
				</div>
			</section>
		</section>
	</div>
	<div class="clear"></div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>