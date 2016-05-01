
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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/duplicationCheck.js" type="text/javascript"></script>
<script src="resources/js/teamName.js" type="text/javascript"></script>
<script src="resources/js/area.js" type="text/javascript"></script>
<script src="resources/js/SetNum.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function () {
    var pjId = "${pj_id}";
    if(pjId != null && pjId != "" && pjId != undefined){
   // 	$("#h_id").val(pjId);
    	$("#searchid").val(pjId);
    }
});
</script>

<script src="resources/js/insertproject.js" type="text/javascript"></script>
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
height:25px;
	border: 1px solid grey;
}
</style>
</head>
<script type="text/javascript">

$(document).ready(function () {

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


    $('#pj_start_day').datepicker();
    $('#pj_start_day').datepicker("option", "maxDate", $("#pj_end_day").val());
    $('#pj_start_day').datepicker("option", "onClose", function ( selectedDate ) {
        $("#pj_end_day").datepicker( "option", "minDate", selectedDate );
    });
 
    $('#pj_end_day').datepicker();
    $('#pj_end_day').datepicker("option", "minDate", $("#pj_start_day").val());
    $('#pj_end_day').datepicker("option", "onClose", function ( selectedDate ) {
    	$("#pj_start_day").datepicker( "option", "maxDate", selectedDate );
    });
    
});

	$(window).ready(function() {
		//TODO
		setNav(1,1);
	});
</script>

</head>

<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">프로젝트 관리</h1>
		<div id="wrap" style="width: 1900px; margin: auto;">
			<input id="outemp" type="hidden" value="">
			<input id="h_id" type="hidden" value="" />
			<div id="main" style="margin-top: 10px;">
				<div id="left_main"
					style="height: 600px; width: 500px; background: white; margin-right: 50px; float: left;">
					<table>
						<tr>
							<th>프로젝트 ID&nbsp;</th>
							<td><input  style="height: 100%" type=text name=searchname id=searchid value="" ></td>
							<th style="width: 100px">팀</th>
							<td style="width: 120px"><div id="teamsearch"><select style="width:100%;height:30px;" id="searchteam" name="searchteam" title="skill"><option selected="selected" value="al">전체</option></select></div></td>
						</tr>
						<tr>
							<th height="30px">상태 &nbsp;</th>
							<td style="text-align: right"><select style="width: 100%; height: 100%"
								name="pj_prog" id="searchprog">
									<option value="" selected>전체
									<option value="1이월">이월
									<option value="2완료">완료
									<option value="3대기">대기
									<option value="4A급">A급
									<option value="5B급">B급
									<option value="6C급">C급
									<option value="7종결">종결
							</select></td>

						</tr>
					</table>
				 	<div style="text-align: right; margin-top: 3px; margin-bottom: 18px;">
					<!-- <input type="button" id=searchbutton value="검색" />&nbsp;&nbsp; -->	
					</div> 

					<table class="fuck" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td>
								<div>
									<table width="490px" cellspacing="1"
								cellpadding="0" border="0" class="hover">
										<tr>
											<th style="width: 123px; ">팀명</th>
											<th style="width: 138px">프로젝트ID</th>
											<th style="width: 96px">상태</th>
											<th style="width: 113px">계약액</th>
										</tr>
									</table>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div id="search_result" style="height: 600px; width:507px; overflow-y: auto"></div>
							</td>
						</tr>
					</table>
				</div>

				<div id="right_main"
					style="margin-left:50px; height: 600px; width: 650px; background: white; float: left;">
					<form name="userForm" method="post">
							<p style="text-align: right;margin-right: 55px;">단위[천원]</p>
						<table style="width: 600px; height: 620px; font-size: 18px " >
							<thead>
								<tr>
									<th style="font-size: 20px" height="40px" colspan="5" align="center">기본 정보</th>
								</tr>
							</thead>
							<tr>
								<th align="right">팀명 *</th>
								<td><div id="team_div"style="height:100%;"></div></td>
							</tr>
							<tr>
								<th align="right">진행상태&nbsp;</th>
								<td style=""><select style="width: 100%; height:100%; text-align: left" 
									name="pj_prog" id="pj_prog" >
										<option value="1이월" >이월
										<option value="2완료">완료
										<option value="3대기">대기
										<option value="4A급">A급
										<option value="5B급">B급
										<option value="6C급">C급
										<option value="7종결">종결
								</select></td>
							</tr>
							<tr>
								<th align="right">프로젝트ID *</th>
								<td ><input type="text" name="pj_id" id="pj_id" style="width: 99%;height:100%;" 
									placeholder="- 최대길이 6자" value="" /></td>
							</tr>
							<tr>
								<th align="right">프로젝트명 *</th>
								<td><input style="width: 99%;height:100%;" type="text" name="pj_name"
									id="pj_name" value="" /></td>
							</tr>
							<tr>
								<th align="right">발주 고객 </th>
								<td><input type="text" name="customer_name"
									id="customer_name" style="width: 77%; height:100%; ime-mode: disabled;"
									placeholder="ex)KT" value="" /> <input type="button" value="신규등록"
									id="customer_reg"  /></td>
							</tr>
							<tr>
								<th align="right">계약 고객 </th>
								<td><input type="text" name="top_customer"
									id="top_customer" style="width:99%; height:100%; ime-mode: disabled;"
									placeholder="ex)KT" value="" /></td>
							</tr>
							<tr>
								<th align="right">시작일 *</th>
								<td style="text-align: right"><input style="width: 99%;height:100%;"
									type="text" name="pj_start_day" id="pj_start_day" value="" /></td>
							</tr>
							<tr>
								<th align="right">종료일 *</th>
								<td style="text-align: right"><input style="width: 99%;height:100%;"
									type="text" name="pj_end_day" id="pj_end_day" value="" /></td>
							</tr>
							<tr>
								<th align="right">프로젝트 수행비율</th>
								<td><input type="text" class="text"
									name="pj_operate" id="pj_operate"
									style="width: 93%; height:100%; ime-mode: disabled; text-align: right;"
									onkeypress="numkeycheck()" placeholder="0~100%"  value="" />%</td>
								<!--<td><input type="text" name="budget_operate" >%</td>  -->
							</tr>
							<tr>
								<th align="right">계약액 *</th>
								<td align="right"><input type="text" class="text"
									id="budget_contract_sales" name="budget_contract_sales"
									style="ime-mode: disabled; text-align: right; width: 99%; height:100%;"
									onkeypress="return isNumber(event)"
									onkeyup="this.value=SetComma(this.value)"  value="" /></td>
								<!-- <td><input type="text" name="budget_contract_sales" /></td> -->
							</tr>
							<tr>
								<th align="right">외&nbsp;주&nbsp;비&nbsp; </th>
								<td><input type="text" class="text" name="budget_outsource"
									id="budget_outsource"
									style="ime-mode: disabled; text-align: right; width: 99%; height:100%;"
									onkeypress="return isNumber(event)"
									onkeyup="this.value=SetComma(this.value)"  value="" /></td>
							</tr>
							<tr>
								<th align="right">상&nbsp;품&nbsp;비&nbsp; </th>
								<td align="right"><input type="text" class="text"
									name="budget_product_cost" id="budget_product_cost"
									style="width: 99% ;height:100%; ime-mode: disabled; text-align: right;"
									onkeypress="return isNumber(event)"
									onkeyup="this.value=SetComma(this.value)" value=""  /></td>
								<!--<td><input type="text" name="budget_product_cost" /></td>  -->
							</tr>
							<tr>
								<th align="right">SQI&nbsp;MM&nbsp; </th>

								<td align="right"><input type="text" name="pj_sqimm"
									id="pj_sqimm"
									style="ime-mode: disabled; text-align: right; width: 99%; height:100%;"
									onkeypress="return isFloat(event)"	onkeyup="this.value=SetComma(this.value)"value="" /></td>
								<!--<td><input type="text" name="pj_sqimm" /></td>  -->
							</tr>
							<tr>
								<th align="right">외주&nbsp;MM&nbsp; </th>
								<td align="right"><input type="text" name="pj_outmm"
									id="pj_outmm"
									style="width: 99%;height:100%; ime-mode: disabled; text-align: right;"
									onkeypress="return isFloat(event)" onkeyup="this.value=SetComma(this.value)"value="" /></td>
							</tr>
							<tr>
								<th align="right">지&nbsp;&nbsp;역&nbsp;*</th>
								<td><div style="height: 100%" id="area" ></div></td>
							</tr>
							<tr>
								<th align="right">담당&nbsp;PM&nbsp;</th>
								<td><input style="width:99%;height:100%;" value="" type="text" name="pj_pm" id="pj_pm" readonly placeholder="클릭하여 입력해주세요"/></td>
							</tr>
							<tr>
								<th align="right">비&nbsp;&nbsp;고&nbsp; </th>
								<td style="height: 45px" colspan="3"><textarea name="pj_etc" id="pj_etc" value=""
										style=" width: 98%; height:100%" placeholder="프로젝트 특이사항"></textarea></td>
							</tr>
							<tr>
								<th align="right">기반분류</th>
								<td style="height: 30px" colspan="3">
								<!--  
								<textarea name="pj_require" id="pj_require" value=""
										style=" width: 98%; height:100%;" placeholder="ex) C W M"></textarea>
										-->
										<input type="checkbox" name="pj_require" value="C">C
										<input type="checkbox" name="pj_require" value="W">W
										<input type="checkbox" name="pj_require" value="M">M
										</td>
							</tr>
						</table>
						<div style="margin-top: 7px; margin-left: 67%">
							<input type="button" value="저장" id="update"/>&nbsp;&nbsp;
							<input type="button" value="삭제" id="delete" disabled=true/>&nbsp;&nbsp;
							<input type="button" value="취소" id="cancel"/>&nbsp;&nbsp;
						</div>
					</form>
				</div>
			</div>
		</div>
		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
</body>
</html>