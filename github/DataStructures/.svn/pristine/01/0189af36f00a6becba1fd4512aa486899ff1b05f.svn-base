<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보 수정</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="resources/js/jquery-1.11.0.js" type="text/javascript"></script>
<script 
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="resources/js/teamName.js" type="text/javascript"></script>
<script src="resources/js/SetNum.js" type="text/javascript"></script>
<script src="resources/js/area.js" type="text/javascript"></script>


<script type="text/javascript">

$(document).ready(function () {
	$("#area").setAreadiv({});
	loc = '${requestScope.vo.pj_loc}';
	$("#area").setArea(1,loc,{})
	$("#team_id").setTeamdiv({selectVal:$("#team_id").attr("team")});
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
    
    
    $('#pj_id').change(function(){
		$.ajax({
			type : "POST",
			url:"/pjCheck",
			async : false,
			dataType : "json",
			data:{pj_id:$("#pj_id").val()},
			success : function(data) {		
				 var html = '<tr>';
				if(data.res > 0){
					alert('중복된 ID입니다.');
					var test = document.getElementById("pj_id");
					 test.value="";
					 $("#pj_id").focus();
				}
				html += '</tr>'; 
				  
			    $("#duplres").html(html);

			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}			
		});
	});	

	$('#pj_id').keyup(function(){
		if(pj_id.value.length>6)
		{
			alert('프로젝트ID의 최대 길이는 6자입니다.')
			var test = document.getElementById("pj_id");
			 test.value=pj_id.value.substr(0,6);
		}
	});	
	$('#pj_operate').keyup(function(){
		if(pj_operate.value.length>3 )
		{
			alert('프로젝트수행비율의 최대 값은 100입니다.')
			var test = document.getElementById("pj_operate");
			 test.value=pj_operate.value.substr(0,3);
		}
		if(pj_operate.value>100)
		{
			alert('프로젝트수행비율의 최대 값은 100입니다.')
			var test = document.getElementById("pj_operate");
			 test.value="";
		}
	});
	$('#pj_pm').click(function(){
		$.ajax({
			type : "POST",
			url:"/nameExist",
			async : false,
			dataType : "json",
			data:{
				pj_pm : pj_pm.value
			},
			success : function(data) {		
//				$.each(data,function(entryIndex, entry){	
				//json으로 넘어오므로 파싱이 필요없음 data=JSON.parse(data);
				 var html = '<tr>';
				if(data.res > 0){
				}else{
					if(data.e_name == ""){
						 html += '<td id="duplresval" style="color:blue">' + '' + '</td>';
					}else{
						 
						 window.open('/nameSerch','windows','width=800,height=900,scrollbars=yes');

					}
				}
				 html += '</tr>'; 
				  
			    $("#duplres").html(html);

			},
			error : function(xhr) {
				alert("error html = " + xhr.statusText);
			}			
		});
	});	

	$('#customer_name').click(function(){		
		var test="client";
		var Obj="customer_name";
		window.open('/customerSerch.do?obj='+Obj,'windows','width=800,height=900,scrollbars=yes');
		 
	})
	$('#top_customer').click(function(){		
		var test="client";
		var Obj="top_customer";
		window.open('/customerSerch.do?obj='+Obj,'windows','width=800,height=900,scrollbars=yes');
		 
	})
	$('#customer_reg').click(function(){
		window.open('/customerReg.do','windows','width=800,height=900,scrollbars=yes');
	})
    
});

	function projectUpdate(pj_id) {
		var formData = document.userForm;
		formData.action = "projectUpdate.iqspf?pj_id=" + pj_id;
		formData.submit();
	}
	function projectDelete(pj_id) {
		var formData = document.userForm;
		formData.action = "projectDelete.iqspf?pj_id=" + pj_id;
		formData.submit();
	}
	
	$(window).ready(function() {
		//TODO
		setNav(1, 0);
	});
	function viewMain() {
		var formData = document.userForm;
		formData.action = "bizList.iqspf";
		formData.submit();
	}
</script>
</head>

<body>
	<jsp:include page="./common/header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="./common/left.jsp"></jsp:include>
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">프로젝트 정보 수정</h1>
		<div id="wrap" style="width: 1900px; margin: auto;">
			<form name="userForm" method="post" action="projectUpdate.iqspf">
				<table>
					<thead>
						<tr>
							<th colspan="4" align="center">기본 정보</th>
						</tr>
					</thead>
					<tr>
						<th>팀&nbsp;명</th>
						<td><div id="team_id" team="${requestScope.vo.team_id}"></div></td>
						<th>프로젝트 진행상태</th>
						<td><select style="width: 100%" name="pj_prog">
								<option value="${requestScope.vo.pj_prog}" selected>${requestScope.vo.pj_prog}
								<option value="1이월">이월
								<option value="2완료">완료
								<option value="3대기">대기
								<option value="4A급">A급
								<option value="5B급">B급
								<option value="6C급">C급
								<option value="7종결">종결
						</select></td>

					</tr>
					<tr>
						<th>프로젝트&nbsp;ID</th>
						<td>${requestScope.vo.pj_id}</td>
						<th>프로젝트이름</th>
						<td><input style="width: 97%" type="text" name="pj_name"
							value="${requestScope.vo.pj_name}" /></td>

					</tr>

					<tr>
						<th>발주 고객</th>
						<td><input style="width: 97%" type="text"
							name="customer_name" value="${requestScope.vo.customer_name}" /></td>
						<th>계약 고객</th>
						<td><input style="width: 97%" type="text"
							name="top_customer" value="${requestScope.vo.top_customer}" /></td>
					</tr>

					<tr>
						<th>프로젝트 시작일</th>
						<td><input style="width: 97%" type="text" name="pj_start_day"
							id="pj_start_day" value="${requestScope.vo.pj_start_day}" /></td>
						<th>프로젝트 종료일</th>
						<td><input style="width: 97%" type="text" name="pj_end_day"
							id="pj_end_day" value="${requestScope.vo.pj_end_day}" /></td>
					</tr>
					<tr>
					<th>프로젝트 수행비율</th>
						<td><input
							style="ime-mode: disabled; text-align: right; width: 90%"
							type="text" name="pj_operate" onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.pj_operate}">%</td>
						<th>계약액</th>
						<td><input
							style="ime-mode: disabled; text-align: right; width: 97%"
							type="text" name="budget_contract_sales"
							id="budget_contract_sales" onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)" value="" /></td>

						
					</tr>
					<tr>
					<th>상품비</th>
						<td><input
							style="ime-mode: disabled; text-align: right; width: 97%"
							type="text" name="budget_product_cost" id="budget_product_cost"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)" value="" /></td>
						<th>외주비</th>
						<td><input
							style="ime-mode: disabled; text-align: right; width: 97%"
							type="text" name="budget_outsource" id="budget_outsource"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)" value="" /></td>

					</tr>
					<tr>
						<th>SQI MM</th>
						<td><input
							style="ime-mode: disabled; text-align: right; width: 97%"
							type="text" name="pj_sqimm" onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.pj_sqimm}" /></td>

						<th>외주 MM</th>
						<td><input
							style="ime-mode: disabled; text-align: right; width: 97%"
							type="text" name="pj_outmm" onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)"
							value="${requestScope.vo.pj_outmm}" /></td>
					</tr>
					<tr>
						<th>추가경비</th>
						<td><input
							style="ime-mode: disabled; text-align: right; width: 97%"
							type="text" name="pj_extra_cost" id="pj_extra_cost"
							onkeypress="return isNumber(event)"
							onkeyup="this.value=SetComma(this.value)" value="" /></td>
							<td colspan=2></td>
					</tr>
					<tr>
							<th>담당 PM</th>
						<td><input style="width: 97%" type="text" name="pj_pm"
							id="pj_pm" value="${requestScope.vo.pj_pm}" /></td>
						<th>지역</th>
						<td><div id="area"></div></td>
					</tr>
					<tr>

						<th>비고</th>
						<td colspan="3"><input style="width: 99%" type="text"
							name="pj_etcpj_etc" value="${requestScope.vo.pj_etc}" /></td>
						<td><div id="duplres"></div></td>
					</tr>
					<thead>
						<tr>
							<th colspan="4" align="center">주요 기능 및 분야</th>
						</tr>
					</thead>
					<tr>
						<td colspan="4"><textarea name="pj_require"
								value="${requestScope.vo.pj_require}"
								style="width: 99%; height: 61px;" cols="100" maxlength="100"></textarea></td>
					</tr>
				</table>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="입력"
					onclick="projectUpdate('${requestScope.vo.pj_id}')" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="삭제"
					onclick="projectDelete('${requestScope.vo.pj_id}')" /> <input
					type="button" value="이전" onclick="viewMain()" />
			</form>
		</div>
		</section>
	</div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
<script type="text/javascript">

	var budget_contract_sales = '${requestScope.vo.budget_contract_sales}';
	var budget_product_cost = '${requestScope.vo.budget_product_cost}';
	var budget_outsource = '${requestScope.vo.budget_outsource}';
	var pj_extra_cost = '${requestScope.vo.pj_extra_cost}';

	document.getElementById("budget_contract_sales").value = SetComma(String(budget_contract_sales)); 
	document.getElementById("budget_product_cost").value = SetComma(String(budget_product_cost)); 
	document.getElementById("budget_outsource").value = SetComma(String(budget_outsource)); 
	document.getElementById("pj_extra_cost").value = SetComma(String(pj_extra_cost)); 
</script>
</body>


</html>