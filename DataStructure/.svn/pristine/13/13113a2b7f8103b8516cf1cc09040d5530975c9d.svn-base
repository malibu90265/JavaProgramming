<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PJ투입MAP</title>
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/demo.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/common.css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/empPjMap/empPjMap.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		getMiniHeaderAjax();
		//getEmpPjMapCheckBoxAjax();
		
		//getEmpPjMapList();
	});
	function kuisin(idMyDiv){
		var objDiv = document.getElementById(idMyDiv);
		
		if(objDiv.style.display=="block"){ objDiv.style.display = "none"; }
		else{ objDiv.style.display = "block"; } 
	}
</script>
<style type="text/css">
	#inputContentDIV {width:100%; overflow-x: auto;}
	.inputContent {width: 600%;}
	.teamWrap {display: none; border: solid #ccc 1px; float: left;}
	#topTableName {margin-top: 20px; margin-bottom: 0.5%;}
	#empPjMapCheckBox {margin-bottom: 0.8%;}
</style>
</head>
<body>
	
	<div id="miniHeader"></div>
	<div style="clear: inherit;"></div>
	
	<div class="container">
		<div class="contents">
			<table id="topTableName">
				<tr>
					<th id="contentsTitle">PJ투입MAP</th>
				</tr>
			</table>
			   
			<!-- checkbox 부분  -->
			<div id="empPjMapCheckBox">
				<form>
					<table>
						<tr>
							<c:forEach var="team" items="${teamList }" varStatus="i">
							<td>
								<input type="checkbox" id="${team.tm_id}chk" class="input_check" name="input_check" onclick="kuisin('${team.tm_id}team')" value="${team.tm_id }" />${team.tm_name }
							</td>
							</c:forEach>
						</tr>
					</table>
					<table>
						<tr>
							<td><font color="#FFDEAD">■</font> : 직원     <font color="#EAEAEA">■</font> : 외주     <font color="#CEF279">■</font> : 투입 예정  </td>
						</tr>
					</table>
				</form>
			</div>
			
			<!-- list부분 -->
			<div id="inputContentDIV" scrolling="no">
				<div class="inputContent" >
					<c:forEach var="team" items="${teamList }">
						<div class="teamWrap" id="${team.tm_id}team"></div>
					</c:forEach>
				</div>
			</div>
		</div><!-- contents -->
	</div><!-- container -->
</body>
</html>

