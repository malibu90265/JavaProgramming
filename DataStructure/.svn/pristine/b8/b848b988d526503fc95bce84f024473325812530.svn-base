<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome page</title>

<script src="resources/js/input_function.js" type="text/javascript" ></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="resources/js/input_search.js" type="text/javascript" ></script>

<script src="resources/js/emp_detail.js" type="text/javascript" ></script>
<script src="resources/js/emp_duplication.js" type="text/javascript" ></script>
<script src="resources/js/emp_inputck.js" type="text/javascript" ></script>

</head>

<body>

<div id="wrap" style="width:1900px; margin:auto;">

<input id="outemp" type="hidden" value="">

 <div id="header" style="height:60px; background:black;">
 </div>
  
 <div id="main" style="margin-top:10px;">
   <div id="left_main" style="height:900px; width:600px; background:white; margin-right:10px; float:left;">
     <h2 style="font: 돋움체">직원정보</h2>
   이름 &nbsp;<input type = text name = searchname id = searchname >
     팀 &nbsp;<select name="searchteam" id = "searchteam">
                        		<option value="" >팀선택</option> 
                               <option value="SI1" >SI1</option>                              
                               <option value="SI2" >SI2</option>
                               <option value="DS팀" >DS팀</option>
                               <option value="보안사업팀" >보안사업팀</option>
                               <option value="에너지사업팀" >에너지사업팀</option>
                               <option value="경영지원팀" >경영지원팀</option>
                        </select>
                        <input type="button" id = searchbutton value="검색" /><br><br><br><br><br>
     

           <div id="search_result"></div>
            <div id="detail_result"></div>
   
   </div>

   <div id="right_main" style="height:900px; width:1290px; background:white; float:left;">
    <form method="post" name="frm" action="insert.iqshr" enctype="multipart/form-data">
<div align=center>
<table border=1>
	<tr>
		<td><h3><input type="radio" name="division" id=emp_form value="E" checked onchange="change('E')" onclick="empclick()"> 직원
			<input type="radio" name="division" id=out_form value="O" onchange="change('O')" onclick="outclick()"> 외주
			</h3>
		 </td>
		 <td>
		 	<!-- <div align = right><input type ="button" value="초기화" onclick="rst_click();" ></div>
		 	 -->
		 </td>
	<tr>	
	<tr>
		<td ><br><h3>직 원 명 : <input type="text" id=emp_name name=name onKeyPress="namekeycheck(event.keyCode)"> &emsp;&emsp;&emsp;<font class="emp_duplication"></font></h3><br></td>
		<td rowspan="4"> &emsp;&emsp;&emsp;<img src ="resources/images/emp_nophoto.jpg" id=emp_photo name="photo22" width=177 height=236><br>
						 &emsp;&emsp;&emsp;<input type=file id="upload" name="photo11" onchange=img_input() />
		</td>
	</tr>
	<tr>
		<td>
		<h3>사원식별자 : <input type="text" id=emp_identification name=identification disabled > </h3>
		</td>
	</tr>
	<tr>
		<td>
		<b><font size=4 >입사일 :  </font></b><input type="text" id=hire_date name="hire_date" />
		</td>
	</tr>
	<tr>
		<td>
		<h3>경력기준일 : <input type="text" id=career_date name="career_date"> </h3>
		</td>
		
	</tr>
	<tr>
		<td>
		<b><font size=3>퇴사일 : </font></b><input type="text" id=quit_date name="quit_date"> 
		</td>
	</tr>
	<tr>
		<td>
		<b><font size=4>직급 :</font></b> <select id="emp_position" name="position" title="emp_position">
						<option value="">선택하세요</option>
						<option value="사원">사원</option>
						<option value="대리">대리</option>
						<option value="과장">과장</option>
						<option value="부장">부장</option>
					</select>
		</td>
	</tr>
	<tr>
		<td>
		<h3>팀  명 : <select id="emp_team_name" name="team_name" title="emp_position">
						<option value="">선택하세요</option>
						<option value="SI1팀">SI1팀</option>
						<option value="SI2팀">SI2팀</option>
						<option value="보안사업팀">보안사업팀</option>
						<option value="에너지사업팀">에너지사업팀</option>
						<option value="DS사업팀">DS사업팀</option>
						<option value="경영지원팀">경영지원팀</option>
					</select></h3>
		</td>
	</tr>
	<tr>
		<td>
		<h3>직  무 : <select id="emp_job" name="job" title="emp_job">
						<option value="">선택하세요</option>
						<option value="개발">개발</option>
						<option value="영업">영업</option>
						<option value="회계">회계</option>
						<option value="PM">PM</option>
												
					</select> </h3>
		</td>
	</tr>
	<tr>
		<td>
		<b><font size=4>연봉 : </font></b><input type="text" id=emp_salary name=salary onkeydown="salaykeycheck()">원
		</td>
	</tr>
	<tr>
		<td>
		<b><font size=4>E-mail : </b></font><input type="text" id=emp_email name=email> <font size=4 id="mail_form">@sqisoft.com</font>
		</td>
	</tr>
	<tr>
		<td>
		<h3>전문분야 : &emsp;DBMS &emsp;&emsp; 언어&emsp;&emsp;&emsp;  OS &emsp;&emsp;Middleware&emsp; Network&emsp;&emsp; Web&emsp;&emsp; Framework </h3><br>
				   &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<select id="skill_db" name="skillD" title="skill_db">
						<option value="">선택하세요</option>
						<option value="Oracle">Oracle</option>
						<option value="Informix">Informix</option>
						<option value="Sybase">Sybase</option>
						<option value="My-SQL">My-SQL</option>	
						<option value="DB2">DB2</option>	
						<option value="과장">기타</option>							
					</select>
					 <select id="skill_lang" name="skillL" title="skill_lang">
						<option value="">선택하세요</option>
						<option value="C/C++">C/C++</option>
						<option value="JAVA">JAVA</option>
						<option value="VB/Delphi">VB/Delphi</option>
						<option value="Script">Script</option>
						<option value="PowerBuilder">PowerBuilder</option>
						<option value="과장">기타</option>						
					</select>
					 <select id="skill_os" name="skillO" title="skill_os">
						<option value="">선택하세요</option>
						<option value="HP">HP</option>
						<option value="Sun">Sun</option>
						<option value="Linux">Linux</option>
						<option value="WindowsNT">WindowsNT</option>
						<option value="과장">기타</option>						
					</select>
					 <select id="skill_middle" name="skillM" title="skill_middle">
						<option value="">선택하세요</option>
						<option value="Corbra">Corbra</option>
						<option value="Tuxedo">Tuxedo</option>
						<option value="EJB">EJB</option>	
						<option value="COM/DCOM">COM/DCOM</option>
						<option value="과장">기타</option>						
					</select>
					 <select id="skill_network" name="skillN" title="skill_network">
						<option value="">선택하세요</option>
						<option value="TCP/IP">TCP/IP</option>
						<option value="SNMP">SNMP</option>
						<option value="TMN(CMIP)">TMN(CMIP)</option>
						<option value="WAP">WAP</option>
						<option value="과장">기타</option>							
					</select>
					<select id="skill_web" name="skillW" title="skill_web">
						<option value="">선택하세요</option>
						<option value="HTML">HTML</option>
						<option value="ASP">ASP</option>
						<option value="JSP">JSP</option>	
						<option value="PHP">PHP</option>
						<option value="CGI">CGI</option>
						<option value="과장">기타</option>							
					</select>
					<select id="skill_framework" name="skillF" title="skill_framework">
						<option value="">선택하세요</option>
						<option value=".NET">.NET</option>
						<option value="MFC">MFC</option>
						<option value="SOA">SOA</option>	
						<option value="과장">기타</option>						
					</select>
		</td>
	</tr>
	<tr>
	<td></td>
	<td>
		<div align=right>
		<input type="button" value="저장" onclick = "blank_ck()">

		<input type="button" value="수정" hidden id="modify_btn">

		<%-- <input type="button" value="수정" hidden id="modify_btn" onclick="document.location.href='/iqshr/updateView.iqshr?name=${} &identification=${}'" > --%>

		<input type="reset" value="취소" onclick="rst_click();">
		</div>
	</td>
	</tr>
</table>
</div>

</form>
   </div>
 </div>

 

 


</body>


<script type="text/javascript">
$(document).ready(function(){
	calendar();	
});
function calendar(){
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
    
    
    $('#career_date').datepicker({
    	maxDate:'+0d'
    });
    
    $('#hire_date').datepicker();
    $('#hire_date').datepicker("option", "maxDate", $("#quit_date").val());
    $('#hire_date').datepicker("option", "onClose", function ( selectedDate ) {
        $("#quit_date").datepicker( "option", "minDate", selectedDate );
    });
 
    $('#quit_date').datepicker();
    $('#quit_date').datepicker("option", "minDate", $("#hire_date").val());
    $('#quit_date').datepicker("option", "onClose", function ( selectedDate ) {
        $("#hire_date").datepicker( "option", "maxDate", selectedDate );
    });
}
</script>

</html>