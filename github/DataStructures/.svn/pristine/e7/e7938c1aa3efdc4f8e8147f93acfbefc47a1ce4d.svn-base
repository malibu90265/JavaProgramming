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
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="resources/js/excelExport.js" type="text/javascript"></script>
<script src="resources/js/jquery-1.11.0.js"></script>
<script type="text/javascript">
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

$(document).ready(function () {
	var d = new Date();
	var filename=d.getFullYear()+"년"+(d.getMonth() + 1)+"월"+d.getDate()+"일"+"프로젝트 현황";
	$("#excel").click(function(){
		getExcel($("#project"),filename);
	});
	$("#pj_id").keyup(function(){
		$.ajax({
			type : "POST",
			url:"/salSearch",
			async : false,
			dataType : "json",
			data:{
				pj_id: pj_id.value,
				division: division.value
			},

			success : function(search) {	
				console.log(search)
				
				var html="";
				
				$.each(search, function (index, item) {
					 html+= '<table width="1200px" class="hover" cellspacing="1" cellpadding="0" border="0" style="text-align: center">'; 
					html += '<tr  style="cursor:pointer">';
					html += '<th style="border-top: 0" width="123px">'+"팀 ID"+'</th>';
					   html += '<th style="border-top: 0" width="138px">'+"PJ ID"+'</th>';
					   html += '<th style="border-top: 0" width="146px">'+"이름"+'</th>';
					   html += '<th style="border-top: 0" width="96px">'+"구분"+'</th>';
					   html += '<th style="border-top: 0" width="96px">'+"단가"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"시작일"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"종료일"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"MM"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"직원단가"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"투입비용"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"직원합계"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"외주합계"+'</th>';
					var sum=0;
					var sum_emp=0;
					var sum_out=0;
					  for (var i=0; i<item.length; i++){
						  sum+=parseFloat(item[i].mm);
						 
						  if (item[i].month_unit_cost !=0) {
							  sum_emp += item[i].month_unit_cost * item[i].mm;
						  } else {
							  sum_out += item[i].salary* item[i].mm
						  }
						 
						  html += '<tr  style="cursor:pointer">';
					   html += '<td style="border-top: 0" width="123px">'+item[i].team_id+'</td>';
					   html += '<td style="border-top: 0" width="138px">'+item[i].pj_id+'</td>';
					   html += '<td style="border-top: 0" width="146px">'+item[i].name+'</td>';
					   html += '<td style="border-top: 0" width="96px">'+item[i].division+'</td>';
					   html += '<td style="border-top: 0" width="96px">'+item[i].salary+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+item[i].pj_start_day+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+item[i].pj_end_day+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+item[i].mm+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+item[i].month_unit_cost+'</td>';
					   if (item[i].month_unit_cost !=0) {
					   html += '<td style="border-top: 0" width="196px">'+item[i].month_unit_cost * item[i].mm+'</td>';
					  } else {
						  html += '<td style="border-top: 0" width="196px">'+ item[i].salary* item[i].mm+'</td>';
					  } 
					   if (item[i].month_unit_cost !=0) {
						   html += '<td style="border-top: 0" width="196px">'+item[i].month_unit_cost * item[i].mm+'</td>';
					   } else {
						   html += '<td style="border-top: 0" width="196px"></td>';
					   }
					   
					   if (item[i].month_unit_cost !=0) {
						   html += '<td style="border-top: 0" width="196px"></td>';
					   } else {
						   html += '<td style="border-top: 0" width="196px">'+ item[i].salary* item[i].mm+'</td>';
					   }
					   
					   html += '</tr>';
					   
					  }
					  html += '<td style="border-top: 0" width="123px">Total</td>';
					   html += '<td style="border-top: 0" width="138px"></td>';
					   html += '<td style="border-top: 0" width="146px"></td>';
					   html += '<td style="border-top: 0" width="96px"></td>';
					   html += '<td style="border-top: 0" width="96px"></td>';
					   html += '<td style="border-top: 0" width="196px"></td>';
					   html += '<td style="border-top: 0" width="196px"></td>';
					   html += '<td style="border-top: 0" width="196px">'+sum+'</td>';
					   html += '<td style="border-top: 0" width="196px"></td>';
					   html += '<td style="border-top: 0" width="196px">'+SetComma(String(parseInt((sum_emp+sum_out))))+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+SetComma(String(parseInt((sum_emp))))+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+SetComma(String(parseInt((sum_out))))+'</td>';
					  
					   html += '</table>';
					  
					   $("#project").html(html);
					
				});
							
				},
				error : function(xhr) {
					alert("search error html = " + xhr.statusText);
				}			
			});
	});
	$("#division").keyup(function(){
		$.ajax({
			type : "POST",
			url:"/salSearch",
			async : false,
			dataType : "json",
			data:{
				pj_id: pj_id.value,
				division: division.value
			},

			success : function(search) {	
				console.log(search)
				
				var html="";
				
				$.each(search, function (index, item) {
					 html+= '<table width="900px" class="hover" cellspacing="1" cellpadding="0" border="0" style="text-align: center">'; 
					html += '<tr  style="cursor:pointer">';
					html += '<th style="border-top: 0" width="123px">'+"팀 ID"+'</th>';
					   html += '<th style="border-top: 0" width="138px">'+"PJ ID"+'</th>';
					   html += '<th style="border-top: 0" width="146px">'+"이름"+'</th>';
					   html += '<th style="border-top: 0" width="96px">'+"구분"+'</th>';
					   html += '<th style="border-top: 0" width="96px">'+"단가"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"시작일"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"종료일"+'</th>';
					   html += '<th style="border-top: 0" width="196px">'+"MM"+'</th>';
					var sum=0;
					
					  for (var i=0; i<item.length; i++){
						  sum+=parseFloat(item[i].mm);
						  html += '<tr  style="cursor:pointer">';
					   html += '<td style="border-top: 0" width="123px">'+item[i].team_id+'</td>';
					   html += '<td style="border-top: 0" width="138px">'+item[i].pj_id+'</td>';
					   html += '<td style="border-top: 0" width="146px">'+item[i].name+'</td>';
					   html += '<td style="border-top: 0" width="96px">'+item[i].division+'</td>';
					   html += '<td style="border-top: 0" width="96px">'+item[i].salary+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+item[i].pj_start_day+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+item[i].pj_end_day+'</td>';
					   html += '<td style="border-top: 0" width="196px">'+item[i].mm+'</td>';
					   html += '</tr>';
					   
					  }

					  
					
					   html += '</table>';
					   html+='<input type="text" value='+sum+'>'
					   $("#project").html(html);
					
				});
							
				},
				error : function(xhr) {
					alert("search error html = " + xhr.statusText);
				}			
			});
	});
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

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    		return false;
    }
    return true;
}

function isFloat(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        if (charCode == 46)
        	return true;
        else 
    		return false;
    }
    return true;
}
	$(window).ready(function() {
		//TODO
		setNav(1,1);
	});
</script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="resources/js/area.js" type="text/javascript"></script>
</head>

<body>
<%-- <jsp:include page="./common/header.jsp"></jsp:include> --%>
	<div class="container">
		<%-- <jsp:include page="./common/left.jsp"></jsp:include> --%>

		<h1 class="contentsTitle">프로젝트</h1>
		<div id="wrap" style="width: 1900px; margin: auto;">
				
			<input id="pj_id" type="text" value="" placeholder="pj_id" ><input id="division" type="text" value="" placeholder="직원 OR 외주">
			<input id="excel" type="button" value="excel" />
			<div id="main" style="margin-top: 10px;">
			<section class="contents"> <!-- TODO -->
			<div id="project"> </div>

			
		</section>
		<div>

	</div>
	
	
		<jsp:include page="./common/footer.jsp"></jsp:include>


</body>
</html>