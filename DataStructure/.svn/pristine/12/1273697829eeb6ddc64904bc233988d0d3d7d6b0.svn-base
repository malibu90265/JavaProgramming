<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>영업마일스톤</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
				$('#searchteam').setTeamdiv({all:true});
				$.datepicker.regional['ko'] = {
					closeText : '닫기',
					prevText : '이전달',
					nextText : '다음달',
					currentText : '오늘',
					monthNames : [ '1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)',
							'5월(MAY)', '6월(JUN)', '7월(JUL)', '8월(AUG)',
							'9월(SEP)', '10월(OCT)', '11월(NOV)', '12월(DEC)' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
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

				$('#cus_meet').datepicker();
				$('#cus_meet').datepicker("option", "maxDate",
						$("#needs_anal").val());
				$('#cus_meet').datepicker(
						"option",
						"onClose",
						function(selectedDate) {
							$("#needs_anal").datepicker("option", "minDate",
									selectedDate);
						});

				$('#needs_anal').datepicker();
				$('#needs_anal').datepicker("option", "minDate",
						$("#cus_meet").val());
				$('#needs_anal').datepicker("option", "maxDate",
						$("#cus_converse").val());
				$('#needs_anal').datepicker(
						"option",
						"onClose",
						function(selectedDate) {
							$("#cus_meet").datepicker("option", "maxDate",
									selectedDate);
							$("#cus_converse").datepicker("option", "minDate",
									selectedDate);
						});

				$('#cus_converse').datepicker();
				$('#cus_converse').datepicker("option", "minDate",
						$("#needs_anal").val());
				$('#cus_converse').datepicker("option", "maxDate",
						$("#present").val());
				$('#cus_converse').datepicker(
						"option",
						"onClose",
						function(selectedDate) {
							$("#needs_anal").datepicker("option", "maxDate",
									selectedDate);
							$("#present").datepicker("option", "minDate",
									selectedDate);
						});

				$('#present').datepicker();
				$('#present').datepicker("option", "minDate",
						$("#cus_converse").val());
				$('#present').datepicker("option", "maxDate",
						$("#propose").val());
				$('#present').datepicker(
						"option",
						"onClose",
						function(selectedDate) {
							$("#cus_converse").datepicker("option", "maxDate",
									selectedDate);
							$("#propose").datepicker("option", "minDate",
									selectedDate);
						});

				$('#propose').datepicker();
				$('#propose').datepicker("option", "minDate",
						$("#present").val());
				$('#propose').datepicker("option", "maxDate",
						$("#contract").val());
				$('#propose').datepicker(
						"option",
						"onClose",
						function(selectedDate) {
							$("#present").datepicker("option", "maxDate",
									selectedDate);
							$("#contract").datepicker("option", "minDate",
									selectedDate);
						});

				$('#contract').datepicker();
				$('#contract').datepicker("option", "minDate",
						$("#propose").val());
				$('#contract').datepicker("option", "maxDate",
						$("#perform").val());
				$('#contract').datepicker(
						"option",
						"onClose",
						function(selectedDate) {
							$("#propose").datepicker("option", "maxDate",
									selectedDate);
							$("#perform").datepicker("option", "minDate",
									selectedDate);
						});

				$('#perform').datepicker();
				$('#perform').datepicker("option", "minDate",
						$("#contract").val());
				$('#perform').datepicker("option", "maxDate",
						$("#afterservice").val());
				$('#perform').datepicker(
						"option",
						"onClose",
						function(selectedDate) {
							$("#contract").datepicker("option", "maxDate",
									selectedDate);
							$("#afterservice").datepicker("option", "minDate",
									selectedDate);
						});

				$('#afterservice').datepicker();
				$('#afterservice').datepicker("option", "minDate",
						$("#perform").val());
				$('#afterservice').datepicker(
						"option",
						"onClose",
						function(selectedDate) {
							$("#perform").datepicker("option", "maxDate",
									selectedDate);
						});
			});
</script>
<script src="resources/js/bizmile_view.js" type="text/javascript"></script>
<script src="resources/js/teamName.js" type="text/javascript"></script>
<script>
	$(window).ready(function() {
		//TODO
		setNav(1, 3);
	});
</script>
<style type="text/css">

.fuck td {
	border: 0;
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
height:23px;
	border: 1px solid grey;
}
</style>
</head>

<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">계약진행</h1>
		<div id="wrap" style="width: 1900px; margin: auto;">
			<input id="outemp" type="hidden" value="">
			<div id="main" style="margin-top: 10px;">
				<div id="left_main" style="width: 550px; background: white; margin-right: 20px; float: left;">
					<table>
						<tr>
							<th style="width: 120px">프로젝트 ID</th>
							<td style="width: 120px"><input type=text id=pj_id></td>
							<th style="width: 140px">팀</th>
							<td style="width: 120px">
								<div id="searchteam">
									<select id="team" name="team_id" title="skill" style="width: 100%;height:100%;">
										<option value="al">전체</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<th>상태 &nbsp;</th>
							<td style="text-align: right"><select id="pj_prog" style="width: 100%">
									<option value="" selected>전체</option>
									<option value="1이월">이월</option>
									<option value="2완료">완료</option>
									<option value="3대기">대기</option>
									<option value="4A급">A급</option>
									<option value="5B급">B급</option>
									<option value="6C급">C급</option>
									<option value="7종결">종결</option>
							</select></td>
							<th style="width: 140px">영업단계</th>
							<td style="width: 120px"><select id="biz_stat"
								style="width: 100%">
									<option value="" selected="selected">전체</option>
									<option value="고객접촉">1.고객접촉</option>
									<option value="니즈분석">2.니즈분석</option>
									<option value="고객면담">3.고객면담</option>
									<option value="pt발표">4.PT발표</option>
									<option value="제안입찰">5.제안입찰</option>
									<option value="계약">6.계약</option>
									<option value="수행">7.수행</option>
									<option value="사후관리(MA)">8.사후관리(MA)</option>
							</select></td>
						</tr>
					</table>
					<div style="text-align: right; margin-top: 3px; margin-bottom: 18px;">
						<!--  <input type="button" id=searchbutton value="검색"/>-->
					</div>
					<table class="fuck" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td>
								<div>
									<table width="532px" cellspacing="1" cellpadding="0" border="0" class="hover">
										<tr>
											<th style="width: 109px; ">팀명</th>
											<th style="width: 169px">프로젝트ID</th>
											<th style="width: 121px">상태</th>
											<th style="width: 121px">영업단계</th>
										</tr>
									</table>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="search_result" style="height: 600px; width:549px; overflow-y: auto"></div>
							</td>
						</tr>
					</table>
				</div>

				<div id="right_main" style="/* width: 600px;*/ background: white; float: left; margin-left: 70px; margin-top: 90px;">
					<table style="width: 450px; height: 400px">
						<tr>
							<th width="25px" colspan="5" align="center">영업 마일스톤</th>
						</tr>
						<tr>
							<th style="width: 130px;" bordercolor="black">프로젝트 ID</th>
							<td align=center>
								<input type="text" name="pj_id_ret" id="pj_id_ret" 
									style="width: 97%; height:100%; text-align: center"
									readonly="readonly" disabled="disabled" />
							</td>
							<th style="width: 90px;">팀 명</th>
							<td style="width: 90px;" align=center>
								<input type="text" name="team_name_ret" id="team_name_ret"
								style="width: 97%; height:100%; text-align: center" readonly="readonly"
								disabled="disabled" />
							</td>
						</tr>
						<tr align=center>
							<th bordercolor="black" colspan=1>1. 고객접촉</th>
							<td colspan=3>
								<input type="text" name="cus_meet"
									id="cus_meet" style="width: 99%; height:100%; text-align: center"
									disabled="disabled" />
							</td>
						</tr>
						<tr align=center>
							<th bordercolor="black" colspan=1>2. 니즈분석</th>
							<td colspan=3><input type="text" name="needs_anal"
								id="needs_anal" style="width: 99%; height:100%;text-align: center"
								disabled="disabled" />
							</td>
						</tr>
						<tr align=center>
							<th bordercolor="black" colspan=1>3. 고객면담</th>
							<td colspan=3><input type="text" name="cus_converse"
								id="cus_converse" style="width: 99%; height:100%; text-align: center"
								disabled="disabled" />
							</td>
						</tr>
						<tr align=center>
							<th bordercolor="black" colspan=1>4. PT발표</th>
							<td colspan=3>
								<input type="text" name="present" id="present"
									style="width: 99%; height:100%; text-align: center" disabled="disabled" />
							</td>
						</tr>
						<tr align=center>
							<th bordercolor="black" colspan=1>5. 제안입찰</th>
							<td colspan=3>
								<input type="text" name="propose" id="propose"
									style="width: 99%; height:100%;text-align: center" disabled="disabled" />
							</td>
						</tr>
						<tr align=center>
							<th bordercolor="black" colspan=1>6. 계약</th>
							<td colspan=3>
								<input type="text" name="contract"
									id="contract" style="width: 99%; height:100%; text-align: center" disabled="disabled" />
							</td>
						</tr>
						<tr align=center>
							<th bordercolor="black" colspan=1>7. 수행</th>
							<td colspan=3>
								<input type="text" name="perform" id="perform"
									style="width: 99%; height:100%;text-align: center" disabled="disabled" />
							</td>
						</tr>
						<tr align=center>
							<th bordercolor="black" colspan=1>8. 사후관리(MA)</th>
							<td colspan=3>
								<input type="text" name="afterservice"
									id="afterservice" style="width: 99%; height:100%;text-align: center" disabled="disabled" />
							</td>
						</tr>
					</table>
					<div style="text-align: right; margin-top: 7px;">
						<input type="button" id=update value="저장" disabled="disabled" />
						<input type="button" id=cancel value="취소" disabled="disabled" style="margin-left: 15px;"  />
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>