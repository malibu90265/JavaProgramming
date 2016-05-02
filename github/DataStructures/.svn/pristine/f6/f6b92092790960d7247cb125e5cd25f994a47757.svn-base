<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인력 정보 관리</title>



<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<script src="resources/js/input_function.js" type="text/javascript"></script>
<script src="resources/js/input_search.js" type="text/javascript"></script>
<script src="resources/js/emp_detail.js" type="text/javascript"></script>
<script src="resources/js/emp_duplication.js" type="text/javascript"></script>
<script src="resources/js/emp_inputck.js" type="text/javascript"></script>
<script src="resources/js/skill.js" type="text/javascript"></script>
<script src="resources/js/teamName.js" type="text/javascript"></script>
<script src="resources/js/area.js" type="text/javascript"></script>
<script src="resources/js/outSal_history.js" type="text/javascript"></script>

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

a:VISITED {
	color: green;
}

/* .hoverTable tr:ACTIVE {
        background-color: blue;
} */
</style>
<script>
	$(window).ready(function() {
		//TODO
		setNav(2, 3);
		$('#area').setAreadiv();
		
		
		
	});
	
	

</script>

</head>

<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>

		<section class="contents" style="width: 1600px;">
		<h1 class="contentsTitle">직원/외주 상세정보</h1>

		<span class="endlabel"></span> <section>
		<div style="width: 600px; float: left;">
			<div id="left_main"
				style="width: 600px; margin-right: 10px;  float: left;">
				<input type="hidden" id=empCheck value="E" />

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" id=cancel
					value="검색 초기화" style="height: 30px;" />
				<p>
				<table style="width: 600px;" id="searchtable">
					<tr>
						<th align="right" style="height: 30px;">팀</th>
							<td><div id="teamsearch"></div></td>
						<th align="right" style="height: 30px;">입사년도 / 계약년도</th>
							<td><select name="searchyear" id="searchyear" style="height: 30px; width: 99%;"></select></td>
					</tr>
					<tr>
						<th align="right" style="height: 30px;">직 급</th>
							<td><select id="searchposition" name="searchposition" style="height: 30px; width: 99%;">
									<option value="">전체</option>
									<option value="5사원">사원</option>
									<option value="4대리">대리</option>
									<option value="3과장">과장</option>
									<option value="2차장">차장</option>
									<option value="1부장">부장</option>
									<option value="0임원">임원</option>
									<option value="A기능사">기능사</option>
									<option value="9초급">초급</option>
									<option value="8중급">중급</option>
									<option value="7고급">고급</option>
									<option value="6특급">특급</option>
								</select></td>
						<th style="height: 30px;" align="right">이름</th>
							<td><input type=text name=searchname id=searchname style="height: 30px; width: 99%;"></td>
					</tr>
					<tr>
						<th style="height: 30px;" align="right">거주지</th>
							<td colspan="3"><div id="searcharea"></div></td>
					</tr>
					<tr>
						<th style="height: 30px" align="right">전문기술</th>
							<!-- 		skill 코드화 였을 때 검색 -->
							<!-- 	<td><div id="searchSkill"></div></td> -->
							<td><select name="searchskill" id="searchskill" style="height: 30px; width: 99%;">
									<option value="" selected="selected">선택하세요</option>
    								<option value="SERVER">SERVER</option>
    								<option value="UI">UI</option>
    								<option value="DB">DB</option>
    								<option value="모바일">모바일</option>
    								<option value="빌드">빌드</option>
    								<option value="기타">기타</option>
								</select></td>
						<th style="height: 30px;" align="right">기반분류</th>
							<td>
<!-- 						<input type name=searchcwm id=searchcwm style="height: 30px; width: 99%;"> -->
									<input type="checkbox" id="envclass_c" name="envclass_c" value="C">C
									<input type="checkbox" id="envclass_w" name="envclass_w" value="W">W
									<input type="checkbox" id="envclass_m" name="envclass_m" value="M">M
							</td>
					</tr>
					<tr>
						<th style="height: 30px" align="right">직원구분</th>
							<td><select id = "searchdiv" name = "searchdiv" style="height: 30px; width: 99%">
									<option value = "al">전체</option>
									<option value = "직원">직원</option>
									<option value = "외주">외주</option>
								</select></td>
						<th style="height: 30px" align="right">업무분야</th>
							<td><select id="searchskill2" style="height: 30px; width: 99%" name="searchskill2nd"></select></td>
					</tr>
				</table>
				<p>
				<TABLE class="fuck" cellpadding="0" cellspacing="0" border="0">
					<TR>
						<TD>
							<div>
								<table width="580px" cellspacing="1" cellpadding="0" border="0"
									class="hoverTable">
									<tr>
										<th style="width: 99px">이 름</th>
										<th style="width: 112px">팀명</th>
										<th style="width: 56px">직급 /  등급</th>
										<th style="width: 122px">입 사 일</th>
										<th style="width: 122px">퇴 사 일</th>
										<th style="width: 55px">직원/ 외주</th>
									</tr>
								</table>
							</div>
						</TD>
					</TR>
					<tr>
						<td>
							<div id="search_result"
								style="width: 597px; height: 450px; overflow-y: auto;"></div>
						</td>
					</tr>
				</TABLE>

				<div id="detail_result">
					<input type="hidden" id="hideId" value="" />
				</div>
			</div>
		</div>


		<div style="width: 750px; float: left; margin-left: 55px; margin-top:10px; ">
			<!-- <form method="post" name="frm" action="insert.iqshr" enctype="multipart/form-data"> -->
			<form method="post" name="frm" enctype="multipart/form-data">
				<input type="radio" name="division" id="emp_form" value="직원" checked
					onchange="change('E')"> 직원 <input type="radio"
					name="division" id="out_form" value="외주" onchange="change('O')" onclick="setMpm()" >외주<font class="emp_duplication"></font>
				<P>
				<div style="float:left; width:718px; height: 660px; overflow-y:auto; ">
				<table style="font-size: 5" width="700px;" height="650px" id="emptable">
					<tbody>
						<tr>
							<td style="width: 175px; height: 210px;" align="center" rowspan="4"> <img
								src="resources/images/emp_nophoto.jpg" id=emp_photo width="160px" height="210px"
								name="photo22"  ><br>
								<input style="width:99%" type=file id="upload" name="photo11"
								onchange="empPictureUpload(event)" />

							</td>
							<!-- <input type=file id="upload" name="photo11" onchange="img_input()"/></td> -->
							<th style="width:100px "align="right">직&nbsp;원&nbsp;명 *</th>
							<td><input style="width: 99%; height: 100%" type="text" id="emp_name" name=name  />
								 <input type="text" id="h_name" hidden /></td>
						</tr>
						<tr>
							<th height="60px" align="right">소&nbsp;속&nbsp;&nbsp;</th>
							<td><input style="width: 99%; height: 100%" type="text" id=emp_company value="SQI소프트(주)" name=company disabled></td>
						</tr>
						<tr>
							<th align="right" id=hire_title>입&nbsp;사&nbsp;일 *</th>
							<td><input style="width: 99%; height: 100%" type="text" 
								id=hire_date name="hire_date" /></td>
						</tr>
						<tr>
							<th align="right">경&nbsp;력 *</th>
							<td><input type="text" style="border:0;width: 40% ;height: 100%; text-align:right;" id="career_date_Y" name="career_date_Y" value="" placeholder="YY" onkeydown="salaykeycheck()">년
								<input style="border:0; text-align:right;width: 40%;height: 100%" type="text"id="career_date_M"	name="career_date_M" value="" placeholder="MM" onkeydown="salaykeycheck()">월
							</td>
						</tr>
						<tr id = "to">
							<th  colspan="2" align="right" id=timeoff>휴&nbsp;직&nbsp;일&nbsp;&nbsp;</th>
							<td  align="left"><input type = "checkbox" id ="time_off" name="time_off" value="0" onclick = "tock()">휴직
							&nbsp;
							<input type="text" id="to_start_day" style="width: 38%; height: 100%" name="to_start_day"> ~ 
							<input type="text" id="to_end_day" style="width: 38%; height: 100%" name="to_end_day"></td>
						</tr>
						<tr id = "off">
							<th colspan="2" align="right" id=quit_title>퇴&nbsp;사&nbsp;일&nbsp;&nbsp;</th>
							<td  align="left"><input style="width: 99%; height: 100%"type="text" id=quit_date name="quit_date"></td>
						</tr>
						<tr>
							<th colspan="2" align="right" id=phonenum_title>연&nbsp;락&nbsp;처&nbsp;&nbsp;</th>
							<td align="left"><select style="width: 30%; height: 100%" id="emp_phonenum1" name="phonenum1">
									<option value="010" selected="selected">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="02">02</option>
							</select> - <input style="width: 30%; height: 100%"type="text" id=emp_phonenum2
								name="phonenum2"
								onkeydown="salaykeycheck()" /> - <input style="width: 30%; height: 100%"type="text"
								id=emp_phonenum3 
								name="phonenum3" onkeydown="salaykeycheck()" /></td>
						</tr>
						<tr>

							<th colspan="2" align="right" id=position_title>직&nbsp;급 *</th>
							<td  align="left"><select style="width: 48%; height: 100%"
								id="emp_position" name="position"></select> <select style="width: 48%; height: 100%"
								 id="emp_grade" name="grade">
									<option value="">선택하세요
									<option value="6특급">특급
									<option value="7고급">고급
									<option value="8중급">중급
									<option value="9초급">초급
							</select></td>
						</tr>
						<tr>

							<th colspan="2" align="right" id=position_title>단&nbsp;가 *</th>
							<td  align="left">
								<input  type="text" id="emp_salary" name="emp_salary" value="" style="width: 99%; height: 100%;"/>
								</td>
						</tr>
						<tr>
							<th colspan="2" align="right">사&nbsp;업&nbsp;팀 *</th>
							<td align="left"><div id="team_id" style="height: 100%"></div></td>
						</tr>
						<tr>
							<th colspan="2" align="right"  id=area_title>거&nbsp;주&nbsp;지 *</th>
							<td align="left"><div id="area" name="area" style="height: 100%" ></div></td>
						</tr>

						<tr>
							<th colspan="2" align="right" id="email_title">E-mail *</th>
							<td ><input type="text" id=emp_email style="text-align:right; border:0; width: 59%; height: 100%"
								name=email> <font id="mail_form">@sqisoft.com</font>
							</td>
						</tr>
						<tr>
							<th colspan="2" align="right">기반&nbsp;분류&nbsp;&nbsp;</th>
							<td align="left" colspan="2">
									<input type="checkbox" id="envclass" name="envclass" value="C">C
									<input type="checkbox" id="envclass" name="envclass" value="W">W
									<input type="checkbox" id="envclass" name="envclass" value="M">M
							
							<!-- 	<input style="width: 99%; height: 100%"type="text" id="emp_etc"	name=etc /> -->
							<!-- 	<input type="hidden" id="salary" name="salary" value=""></input>		 -->
							</td>
						</tr>
						<tr>

							<th colspan="2" align="right">전문&nbsp;기술&nbsp;&nbsp;</th>
							<td align="left">
							
								<!--  <div id="skill_div"></div> -->
							
								<select id="skill" name="skill" style=" width: 100px;">
									<option value="" selected="selected">선택하세요</option>
    								<option value="SERVER">SERVER</option>
    								<option value="UI">UI</option>
    								<option value="DB">DB</option>
    								<option value="모바일">모바일</option>
    								<option value="빌드">빌드</option>
    								<option value="기타">기타</option>
    							</select>
							</td>
						</tr>
						<tr>
							<th colspan="2" align="right">업무&nbsp;분류&nbsp;&nbsp;</th>
							<td align="left" colspan="2">
								<div id="job_div"></div>
							</td>
							<td hidden id="realName"></td>

						</tr>
						
					</tbody>
				</table>
				</div>
				<p>
				<div style="margin-left: 69%;" >
					<input type="button" value="저장" id="update_btn" /> &nbsp;&nbsp;<input
						type="button" value="삭제" id="delete_btn" disabled="disabled">&nbsp;&nbsp;
					<input type="button" value="취소" id="rst_btn" />
				</div>
			</form>
		</div>
		</section>
	</div>


	<p>
		<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>


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
			//         showOn: 'both',
			//         buttonText: "달력",
			changeMonth : true,
			changeYear : true,
			showButtonPanel : true,
			yearRange : 'c-99:c+99',
		};
		$.datepicker.setDefaults($.datepicker.regional['ko']);

		$('#hire_date').datepicker();
		$('#hire_date').datepicker("option", "maxDate", $("#quit_date").val());
		$('#hire_date').datepicker("option", "onClose", function(selectedDate) {
			$("#quit_date").datepicker("option", "minDate", selectedDate);
		});

		$('#quit_date').datepicker();
		$('#quit_date').datepicker("option", "minDate", $("#hire_date").val());
		$('#quit_date').datepicker("option", "onClose", function(selectedDate) {
			$("#hire_date").datepicker("option", "maxDate", selectedDate);
		});
		
		$('#to_start_day').datepicker();
		$('#to_start_day').datepicker("option", "maxDate", $("#to_end_day").val());
		$('#to_start_day').datepicker("option", "onClose", function(selectedDate) {
			$("#to_end_day").datepicker("option", "minDate", selectedDate);
		});

		$('#to_end_day').datepicker();
		$('#to_end_day').datepicker("option", "minDate", $("#to_start_day").val());
		$('#to_end_day').datepicker("option", "onClose", function(selectedDate) {
			$("#to_start_day").datepicker("option", "maxDate", selectedDate);
		});
		
	}
</script>



</html>