<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/js/total/projectBudgetInfo.js"/>"></script>
<script type="text/javascript">
var check = false;

//check된 값 가져오기 
function getProjectListbyChecked(){
	var tm_id = $("select[name=team_id]").val();
	var chk = document.getElementsByName("checkboxes");
	var len = chk.length;
	var checkRow = "";
	var checkCnt = 0;
	var checkLast = "";
	var status = "";
	var cnt = 0;
	for(var i=0; i<len;i++){
		if(chk[i].checked == true){
			checkCnt++;
			checkLast = i;
		}
	}
	
	for(var i=0; i<len;i++){
		if(chk[i].checked==true){
			checkRow = chk[i].value;
			
			if(checkCnt == 1){
				status += "" + checkRow+"";
			}
			else{
				if( i== checkLast){
					status += "" + checkRow + "";
				}
				else{
					status += "" + checkRow + "";
				}
			}
			cnt ++;
			checkRow ="";
		}
	}
	getCheckBoxValue(status);
}

</script>
</head>

<body>
	<table class="search" style="float:left;">
			<tr>
				<th>팀명</th>
				<td>
					<select id="teamSelect" name="team_id" onchange="changeFunc();" style="font-size: 1.5vh; font-size: 1.5vm;">
						<option value="0">선택</option>
						<c:forEach var="team" items="${teamList}">
							<option id="${team.tm_id }">${team.tm_name }</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type="checkbox" name ="checkboxes" value="1" onclick="getProjectListbyChecked()" />이월
					<input type="checkbox" name="checkboxes" value="2" onclick="getProjectListbyChecked()" />완료
					<input type="checkbox" name="checkboxes" value="3" onclick="getProjectListbyChecked()" />대기
					<input type="checkbox" name="checkboxes" value="4" onclick="getProjectListbyChecked()" />A급
					<input type="checkbox" name="checkboxes" value="5" onclick="getProjectListbyChecked()" />B급
				</td>
			</tr>
		</table>
		<div id="circle0" style="margin-left:10px; margin-top:5px; float:left;"></div>
		<div id="circle1" style="margin-left:10px; margin-top:5px; float:left;"></div>
		<div id="circle2" style="margin-left:10px; margin-top:5px; float:left;"></div>
		<div id="circle3" style="margin-left:10px; margin-top:5px; float:left;"></div>
		<div id="circle4" style="margin-left:10px; margin-top:5px; float:left;"></div>
		<div id="circle5" style="margin-left:10px; margin-top:5px; float:left;"></div>
		<div id="circle6" style="margin-left:10px; margin-top:5px; float:left;"></div>
		
	
	
</body>
</html>




<%-- <table class="search">
	<tr>
		<th>팀명</th>
		<td>
			<select id="teamSelect" name="team_id" onchange="changeFunc();" style="font-size: 1.2vh; font-size: 1.2vm;">
				<option value="0">선택</option>
				<c:forEach var="team" items="${teamList}">
					<option id="${team.tm_id }">${team.tm_name }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
</table> --%>
