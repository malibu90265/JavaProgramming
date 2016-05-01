<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$("#tm_id").change(function(){
		var tm_id = $("#tm_id option:selected").text();
		alert(tm_id);
		getEmpStandBySearchTeam(tm_id);
	});
	
</script>
</head>
<body>
	<form id="searchForm" name="searchForm">
		<table border="1">
			<tr>
				<th colspan="2">
					<input type="radio" name="stanby" value="wating">대기자
					<input type="radio" name="standby" value="expectantWaiting" >대기예정자
				</th>
				<td colspan="2">
					<input type="text" id="standByName" name="standByName" />
				</td>
			</tr>
			<tr>
				<th>기준일자(기준월)</th>
				<td>
					<select>
						<!-- option 월
						optionGropu 사용할 수 있나 알아보기. -->
					</select>
				</td>
				<th>팀명</th>
				<td>
					<select name="tm_id" id="tm_id">
						<option value="">선택</option>
						<c:forEach var="team" items="${teamList }">
							<option value="${team.tm_id }">${team.tm_name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>