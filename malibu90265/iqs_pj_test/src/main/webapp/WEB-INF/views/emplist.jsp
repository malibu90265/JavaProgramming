<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<title> 직원 명부 관리</title>
<script src="resources/js/jquery-1.11.0.js"></script>
<script src="resources/js/jquery-1.11.0.min.js"></script>
<script src="resources/js/emp_list.js"></script>
<script src="resources/js/teamName.js" type="text/javascript" ></script>	
<script type="text/javascript">
	$(window).ready(function() {
		//TODO
		setNav(2, 0);
	});
	function kuisin(idMyDiv){
	     var objDiv = document.getElementById(idMyDiv);

	      if(objDiv.style.display=="block"){ objDiv.style.display = "none"; }
	     else{ objDiv.style.display = "block"; } 
	}
</script>
</head>
<body>
	<!-- Top Navigation : 로그인 -->
	<jsp:include page="./common/login_header_mini.jsp"></jsp:include>
	<div style="clear:both;"></div>
	
	<div class="container">
		<section class="contents"> <!-- TODO -->
			<h1 class="contentsTitle">직원 명부 관리</h1>
			<table class="search">
				<tr>
					<th>사업팀</th>
					<td>
						<input class="input_check" checked="checked" onclick="kuisin('1Steam');" id="1Schk" name="input_chk" type="checkbox" value="1S" /> SI사업팀 
						<input class="input_check" id="2Schk" name="input_chk" onclick="kuisin('2Steam');" type="checkbox" value="2S" /> 커머스사업팀 
						<input class="input_check" id="3Echk" name="input_chk" type="checkbox" onclick="kuisin('3Eteam');" value="3E" /> 에너지사업팀 
						<input class="input_check" id="4Nchk" name="input_chk" type="checkbox" onclick="kuisin('4Nteam');" value="4N" /> 보안사업팀 
						<input class="input_check"  id="5Dchk" 	name="input_chk" type="checkbox" onclick="kuisin('5Dteam');"value="5D" /> 미디어사업팀
					</td>
				</tr>
			</table>
			
			<div class="inputContent"  scrolling="no" style="overflow-x: auto; ">
				<div style="width: 6000px; text-align: center;"><!--유의 사항 : 데이터가 늘어나서 6000px가 늘어나면 div가 밑으로 내려가 버림 밑으로 내려갈시 width 조정  -->
					<div class="teamWrap" style=" display: block; border: 1px solid black; float: left;" id="1Steam"></div>
					<div class="teamWrap" style="display: none; border: 1px solid black; float: left;" id="2Steam"></div>
					<div class="teamWrap" style="display: none; border: 1px solid black; float: left;" id="3Eteam"></div>
					<div class="teamWrap" style="display: none; border: 1px solid black; float: left;" id="4Nteam"></div>
					<div class="teamWrap" style="display: none; border: 1px solid black; float: left;" id="5Dteam"></div>
				</div>
			</div>
		 </section>
	</div>
</body>
</html>