<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인력소요</title>

<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<!-- <link rel="stylesheet" href="resources/css/tab/tab.css" type="type/css" /> -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!-- <script src="resources/js/skill.js" type="text/javascript"></script>-->
<script src="resources/js/teamName.js" type="text/javascript"></script> 
<script src="resources/js/pjneeds_search.js" type="text/javascript"></script>
<script src="resources/js/pjneeds_detail.js" type="text/javascript"></script>

<style type="text/css">

big-link {
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
/* Define the hover highlight color for the table row */
.hoverTable tr:hover {

	background-color: #ffff99;
	font-weight: bold;
}
</style>

<script>
	$(window).ready(function() {
		//TODO
		setNav(1, 4);
		initialize();
	});
</script>

</head>
<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>

		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">인력소요 정보 등록</h1>
		<div id="wrap" style="width: 1900px; margin: auto;">
			<input id="outemp" type="hidden" value="">
			<div id="main" style="margin-top: 10px;">
				<div id="left_main"
					style="height: 600px; width: 500px; background: white; margin-right: 20px; float: left;">
					<br> <strong><font size=3 color="#000075">&nbsp;&nbsp;&nbsp;
							◈ 프로젝트 검색 </font></strong>
					<br>
					<hr style="width: 500px;" align="left" />
					<br>
					<table>
						<tr>
							<th>프로젝트 ID &nbsp;</th>
							<td><input type=text name=searchid id=searchid 
								style="text-align: center;"></td>
						</tr>
						<tr>
							<th>팀 이름</th>
							<td><div id="searchteam"></div></td>
							<th style="width: 130px">상태</th>
							<td style="text-align: right"><select style="width: 80px"
								name="searchprog" id="searchprog">
									<option value="" selected>전체
									<option value="4A급">A급</option>
									<option value="3대기">대기</option>
									<option value="2완료">완료</option>
							</select></td>
						</tr>
						
					</table>
					 <br>
					<hr style="width: 500px;" align="left" />

					<table class="fuck" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td>
								<div>
									<table width="477px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">
										<tr>
											<th style="width: 114px">팀</th>
											<th style="width: 173px">프로젝트 ID</th>
											<th style="width: 90px">상태</th>
											<th style="width: 97px">요구인원</th>
										</tr>
									</table>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="search_list"
									style="width: 498px; height: 500px; overflow-y: auto"></div>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>


		<div id="jogun" style="width: 700px; float: left; margin-left: 70px;margin-top: 7px;">
			<form method="post" name="frm" action="Pjneeds_Insert.action"
				enctype="multipart/form-data">
				<p>
					<strong> 프로젝트ID :</strong> <input type="text" name="pj_id"
						id="pj_id" style="text-align: center"><br> <br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <strong>기간 :</strong> <input type="text" name="pj_start_day" id="pj_start_day"  style="text-align: center">
					- <input type="text" name="pj_end_day" id="pj_end_day"  style="text-align: center"> <br> <br>
					&nbsp;
					<strong> 요구인원 :</strong> <input type="text" name="pn_num"
						id="pn_num"  style="text-align: center">  
						&nbsp;&nbsp;
					<strong> 기반분류 :</strong> <input type="text" name="pj_require"
						id="pj_require"  style="text-align: center">
				</p>
				<strong><font size=3 color="#000075">&nbsp;&nbsp;&nbsp;
						◈ 인력소요 요구조건</font></strong>
				<hr style="width: 600px; float:left;">
				<div style="margin-top: 30px;">
					<input type="hidden" id="temp_pj_start_day" value="" /> 
					<input type="hidden" id="temp_pj_end_day" value=""/> 
					<table border="1" style="margin:0px 10px 0px; padding:80px; width: 590px;">
						<colgroup>
							<col style="width: 90px;" />
							<col style="width: 62px;" />
							<col style="width: 95px;" />
							<col style="width: *;" />
						</colgroup>
						<thead>
							<tr>
								<th>인원번호</th>
								<th>등급</th>
								<th>전문기술</th>
								<th>요구기간</th>
							</tr>
						</thead>
					</table>	
					<div id="pj_need_detail"  scrolling="no" style="overflow-y: auto;height: 435px;">
					</div>
					<br>
					<div align="left" style="float:left; margin-top:5px; margin-left: 420px">
						<input type="button" value="저장" id="submit_btn" 
							disabled="disabled">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="취소" id="cancel_btn">
					</div>
					<br>
				</div>
			</form>
		</div>
		</section>
	</div>

	<jsp:include page="./common/footer.jsp"></jsp:include>

</body>


<script type="text/javascript">
	$(document).ready(function() {
		calendar();
	});
	function calendar() {
		$.datepicker.regional['ko'] = {
			closeText : '닫기',
			prevText : '이전달',
			nextText : '다음달',
			currentText : '오늘',
			monthNames : [ '1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)',
					'5월(MAY)', '6월(JUN)', '7월(JUL)', '8월(AUG)', '9월(SEP)',
					'10월(OCT)', '11월(NOV)', '12월(DEC)' ],
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
			weekHeader : 'Wk',
			dateFormat : 'yy-mm-dd',
			firstDay : 0,
			isRTL : false,
			showMonthAfterYear : true,
			yearSuffix : '',
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : 'c-99:c+99',
		}; 
		$.datepicker.setDefaults($.datepicker.regional['ko']);
	}
</script>

<!-- <script type="text/javascript">
	function salaykeycheck(){ // 키코드값을 매개변수로 받는다
		var code = window.event.keyCode;
		var id=event.target.id;
		if((code >=48 && code <=57) || (code >=96 && code <=105) || code == 110 || code == 190 || code ==8 || code == 9 || code ==13 ||code ==46) {
			window.event.returnValue = true;
		
			
			return;
		}
		alert ("숫자만 입력 가능합니다.");
		window.event.returnValue =false;
		$("#"+id).val(0);
		$("#emp_salary").val("");
	}
		
	function disabledcheck(){
		var id=event.target.id;
		var pj_start_day=$("#temp_pj_start_day").val();
		var pj_end_day=$("#temp_pj_end_day").val();
		$('#specialfrom').datepicker("option", "minDate", pj_start_day);
		$('#specialto').datepicker("option", "maxDate", pj_end_day);
		$('#advancedfrom').datepicker("option", "minDate", pj_start_day);
		$('#advancedto').datepicker("option", "maxDate", pj_end_day);
		$('#intermidatefrom').datepicker("option", "minDate", pj_start_day);
		$('#intermidateto').datepicker("option", "maxDate", pj_end_day);
		$('#beginnerfrom').datepicker("option", "minDate", pj_start_day);
		$('#beginnerto').datepicker("option", "maxDate", pj_end_day);
		$('#engineerfrom').datepicker("option", "minDate", pj_start_day);
		$('#engineerto').datepicker("option", "maxDate", pj_end_day);
		if($("#"+id).val()>0){
			$("#"+id+"from").attr('disabled',false);
			$("#"+id+"to").attr('disabled',false);
			$("#"+id+"from").attr("value",pj_start_day);
			$("#"+id+"to").attr("value",pj_end_day);
			
		}else if($("#"+id).val()<=0){
			$("#"+id+"from").attr('disabled',true);
			$("#"+id+"to").attr('disabled',true);
			$("#"+id+"from").attr("value","");
			$("#"+id+"to").attr("value","");
		}
	}
		
		
</script>
 -->
 
 
<!-- <script type="text/javascript">
function peoTotal(){
	//인력소요 요구조건의 인원수가 공백일 경우 0으로 처리
	var id=event.target.id;
	if($("#"+id).val() < 0 || $("#"+id).val() == null || $("#"+id).val()== "" ){
		$("#"+id).val(0);
		
	}
	
    var special = parseInt(document.getElementById('special').value,10);
    var advanced = parseInt(document.getElementById('advanced').value,10);
    var intermidate = parseInt(document.getElementById('intermidate').value,10);
    var beginner = parseInt(document.getElementById('beginner').value,10);
    var engineer = parseInt(document.getElementById('engineer').value,10);
    
    document.getElementById('peoplenum').value = (special + advanced + intermidate + beginner + engineer).toString();
	}
</script> -->
    
    

</html>