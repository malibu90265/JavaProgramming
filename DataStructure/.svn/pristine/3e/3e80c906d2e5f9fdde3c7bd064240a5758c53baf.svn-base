<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/js/deployMap/monthlyDeployMap.js"/>"></script>
<script type="text/javascript">
	// 검색
	$("input").on( "click", function() {
		if("직원" == $("input:checked").val()) {
			emp_map();
		}
		else if("외주" == $("input:checked").val()) {
			out_map();
		}
		else {
			emp_map();
		}
	});
	
	//팀, 이름 검색
	$('#tm_id').change(function() {
		var tm_name = $("#tm_id option:selected").text();
		var radioId = $("input:checked").val();
		
		getTeamSearch(tm_name, radioId);
	});
	$("#hr_name").keyup(function(event) {
		var hr_name = $("#hr_name").val();
		getNameSearch(hr_name);
	});
</script>
<style type="text/css">
	#monthlyDeployMapSearchTable {width:100%;}/* width:900px; */
</style>
</head>
<body>
<!-- onchange로 받아서 일괄 실행? -->
	<table id="monthlyDeployMapSearchTable" >
		<tr>
			<th>직원/외주 선택</th>
			<td id="divisionEmp">
				직원<input type="radio" id="emp_form" name="foo" value="직원" checked="checked" onclick="emp_map()" />
				외주<input type="radio" id="out_form" name="foo" value="외주" onclick="out_map()" />
			</td>
			<th>팀명</th>
			<td>
				<select name="tm_id" id="tm_id" onchange="deployMapChange();" >
					<c:forEach var="team" items="${teamList }">
						<option value="${team.tm_id }">${team.tm_name }</option>
					</c:forEach>
				</select>
			</td>
			<th>이름</th>
			<td>
				<input type="text" id="hr_name" name="hr_name"/>
			</td>
		</tr>
	</table>
	
</body>
</html>