<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인력 배치 관리</title>
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />

<script src="resources/js/move.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="resources/js/pjpostingSearch.js" type="text/javascript"></script>
<script src="resources/js/skill.js" type="text/javascript"></script>

<style type="text/css">
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
	height: 21px;
	border: #4e95f4 1px solid;
}
.hoverTable tr:hover {
	background-color: #ffff99;
	font-weight: bold;
}
.nohoverTable td {
	border: #4e95f4 1px solid;
}
#pj_loc {
    width: 130px;
    text-overflow: ellipsis;
    -o-text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
    word-wrap: normal !important;
    display: block;
    border: 0px;
}
</style>

<script>
	$(window).ready(function() {
		//TODO
		$("#searchAny").keyup(function(){
			$("tr","#ready").each(function(i,v){
				var seach=$("#searchAny").val();
				if($(v).children().eq(1).html().indexOf(seach))	{
					$(v).attr("hidden",true);
				}
				else {
					console.log("search")
					$(v).attr("hidden",false);
				}
			});
		});
		setNav(2, 1);
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		calendar();

	});
	
	function calendar() {
		$.datepicker.regional['ko'] = {
			closeText : '닫기'
			, prevText : '이전달'
			, nextText : '다음달'
			, currentText : '오늘'
			, monthNames : [ '1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)','5월(MAY)', '6월(JUN)', '7월(JUL)', '8월(AUG)'
							, '9월(SEP)', '10월(OCT)', '11월(NOV)', '12월(DEC)' ]
			, monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월'
								 , '9월', '10월', '11월', '12월' ]
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
		$('#searchstartday').datepicker("option", "onClose", function(selectedDate) {
			$("#searchendday").datepicker("option", "minDate", selectedDate);
		});
		$('#searchendday').datepicker();
		$('#searchendday').datepicker("option", "minDate", $("#searchstartday").val());
		$('#searchendday').datepicker("option",	"onClose", function(selectedDate) {
			$("#searchstartday").datepicker("option", "maxDate", selectedDate);
		});
	}
	
	function OpenWindow(url, intWidth, intHeight) {
		winObject = window.open(url, "_blank", "width=" + intWidth + ",height=" + intHeight + ", resizable=no, scrollbars=no");
	}
</script>

</head>

<body>
	
	<div class="container">
		<section class="contents"> <!-- TODO -->
			<h1 class="contentsTitle">인력 배치 관리</h1>
			<div style="width: 1900px; margin: auto;">
				<div id="main" style="margin-top: 10px;">
					<div id="left_main"	style="height: 600px; width: 400px; background: white; margin-right: 20px; float: left;">
						<strong>
							<font size=3 color="#000075">◈ 프로젝트 목록 </font>
						</strong>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<table>
							<tr>
								<th style="width: 150px">프로젝트ID</th>
								<td>
									<input style="width: 98%" type="text" id=searchid name=searchid />
								</td>
							</tr>
							<tr>
								<th>상태</th>
								<td>
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
								<td>
									<input type="text" style="width: 45%;" id="searchstartday" name="searchstartday" />
									~
									<input type="text" style="width: 45%;" id="searchendday" name="searchendday" />
								</td>
							</tr>
						</table>
							
						<input type="button" style="margin-bottom: 5px;margin-top: 5px; margin-left: 303px;" value="프로젝트 검색" id="pjsearchbutton" />
						<br>
						<table width="400px" cellspacing="1" cellpadding="0" border="0" class="hoverTable">
							<tr>
								<th style="width: 55px">상 태</th>
								<th style="width: 95px">프로젝트ID</th>
								<th style="width: 210px">프로젝트 기간</th>
								<th style="width: 40px">맵핑인원</th>
							</tr>
						</table>

						<div id="search_result" style="width: 422px; height: 600px; overflow-y: auto"></div>
						<input type="hidden" value="" id="pj_end_day" /> 
						<input type="hidden" value="" id="pj_id_ret" />
						<div style="width: 960px; float: left; margin-left: 20px;">
							<div style="float: left;">
								<strong>
									<font size=3 color="#000075">&nbsp;&nbsp;&nbsp;◈ 프로젝트 인력배치 </font>
									</strong>
							</div>
							
							<div style="float: left" id="pj_detail_res">
							<br>
							<table border="1" style="width:650px"class="needsTable">
								<tr>
									<th align="center" style="width: 105px" colspan="2" >프로젝트 ID</th>
									<td align="center"  colspan="2" id="pj_id" style="width: 135px" ></td>
									<th align="center" >기반분류</th>
									<td align="center"id="pj_require" style="width: 80px"></td>
									<th align="center" style="width: 105px" >요구인원 수</th>
									<td align="center" id="pj_num"></td>
								</tr>
								<tr>
									<th align="center" style="width: 165px" colspan="3" >프로젝트 기간</th>
									<td align="center" colspan="3"  id="pj_period"></td>
									<th align="center" >근무지</th>
									<td align="center" style="width: 130px; height:24px; ellipsis; overflow: hidden;" id="pj_loc"></td>
								</tr>
								<tr>
									<th align="center" style="width: 24px;"></th>
									<th align="center" style="width: 75px;">번호</th>
									<th align="center" style="width: 75px;">등급</th>
									<th align="center" style="width: 70px;border-right:1px solid #E8E8E8;"></th>
									<th align="left" style="width: 159px;" colspan="2"  >전문기술</th>
									<th align="center" style="width: 226px;" colspan="2" >요구기간</th>
								</tr> 
							</table>
							
							<div id="pj_need_detail"  scrolling="no" style="overflow-y: auto;width:670px;height:105px;margin-bottom: 20px;"></div>
								
							<div style=" float: right; margin-top:120px;margin_left:20px;">
								<input type="button" value="투입이력조회" onclick="location.href=javascript:OpenWindow('getPJHistory.do','640px','600px')" >
							</div>
							&nbsp;&nbsp;&nbsp;
							<div style="height: 600px; float: left;">
								<div style="width: 1100px; margin-left: px; margin-bottom: 5px">
									<strong>
										<font size=3 color="#000075">&nbsp;&nbsp;&nbsp;◈프로젝트 투입 현황</font>
									</strong>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<strong>
										<font size=3 color="#000075">&nbsp;&nbsp;&nbsp;◈ 프로젝트 배치 예정</font>
									</strong>
								</div>	
								<table style="width: 1120px" class="hoverTable" border="1">
									<tr>
										<th align="center" style="width: 21px;"></th>
										<th align="center" style="width: 106px;">이 름</th>
										<th align="center" style="width: 43px;">구분</th>
										<th align="center" style="width: 42px;">등급</th>
										<th align="center" style="width: 111px;">현재 프로젝트</th>
										<th align="center" style="width: 93px;">투입 시작일</th>  
										<th align="center" style="width: 96px;">투입 만료일</th>
										<th hidden align="center" style="width: 118px;">현재 사용기술</th>
										<th align="center" style="width: 30px; border: 0; background-color: white;"></th>
										<th align="center" style="width: 110px;">배치 프로젝트</th>
										<th align="center" style="width: 94px;">배치 예정일</th>
										<th align="center" style="width: 94px;">배치 만료일</th>
										<th align="center" style="width: 113px;">사용기술</th>
										<th align="center" style="width: 159px;">거주지</th>
									</tr>
								</table>
								<div id="pjposting_result" style="height: 210px; width: 1170px; overflow-y: auto;"></div><!-- 데이터들 불러오는 곳 가로 조정 하기   -->	
								<div align="center" style="margin-top: 7px;">
									<input type="button" id="pjpostingsave" value="저장" style="margin-left:650px;"/>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" id="pjpostingcancle" onclick = "pjpostingcancle()" value="취소" /><br>
									<img src="resources/images/up.png" style="width: 30px; cursor: pointer" onclick="moveUp()" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img src="resources/images/down.png" style="width: 30px; cursor: pointer" onclick="moveDown()" />
								</div>
								<div style="margin-bottom: 5px">
									<br>
									<strong>
										<font size=3 color="#000075">&nbsp;&nbsp;&nbsp;◈배치 대상자</font>
									</strong>
									&nbsp;&nbsp;
									<input type="button" value="인원 검색" onclick="location.href=javascript:OpenWindow('searchEmpl.do','640px','600px')">
									<strong>
										<font size=3 color="#000075">&nbsp;&nbsp;이름 검색 : </font>
									</strong>
									<input type="text" id="searchAny"/>
								</div>
								<TABLE class="fuck" cellpadding="0" cellspacing="0" border="0">
									<TR>
										<TD>
											<table style="width: 1152px;" cellspacing="1" cellpadding="0" border="0" class="hoverTable">
												<tr>
													<th style="width: 21px;" align="center" style=></th>
													<th style="width: 106px;" align="center" style=>이 름</th>
													<th style="width: 72px;" align="center">구분</th>
													<th style="width: 72px;" align="center">등급</th>
													<th style="width: 120px;" align="center">현재 프로젝트</th>
													<th style="width: 115px;" align="center">투입 만료일</th>
													<th hidden style="width: 120px;" align="center">현재 사용기술</th>
													<th style="width: 75px; border: 0; background-color: white;"></th>
													<th style="width: 120px;" align="center">배치 프로젝트</th>
													<th style="width: 97px;" align="center">배치 예정일</th>
													<th align="center">보 유 기 술</th>
													<th style="width: 135px;" align="center" >거주지</th>
												</tr>
											</table>
										</TD>
									</TR>
									<tr>
										<td>
											<div id="res" style="height: 165px; width: 1170px; overflow-y:auto; " >
												<table style="width: 1152px;" id="ready" cellspacing="1" cellpadding="0" border="0" class="hoverTable" >
													<tbody id="posting1_tbd_movedown"></tbody>
													<tbody id="posting1_tbd"></tbody>
												</table>
											</div>
										</td>
									</tr>
								</TABLE>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

