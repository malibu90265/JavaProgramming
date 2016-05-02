<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>humanResourceSearchForm</title>
<script type="text/javascript">
	
	//팀 검색.
	$('#tm_id').change(function() {
		var tm_name = $("#tm_id option:selected").text();
		getHumanResourceSearchTeamAjax(tm_name);
	});
	
	//이름으로 검색
	$("#hr_name").keyup(function(event) {
		var hr_name = $("#hr_name").val();
		getHumanResourceSearchNameAjax(hr_name);
	});

	
</script>
<style type="text/css">
 #projectSearchTable th {width: 8%;}
 #projectSearchTable td select, #projectSearchTable td input[type="text"] {width: 100%;}
</style>
</head>
<body>
	
		<table id="projectSearchTable">
			<tr>
				<th>팀명</th>
				<td style="width:20%;">
					<select name="tm_id" id="tm_id"> 
						<c:forEach var="tm_id_rank" items="${teamOptions.keySet()}">
						<option value="${teamOptions.get(tm_id)}">${teamOptions.get(tm_id_rank)}</option>
						</c:forEach>
					</select>
				</td>
				<th>이름</th>
				<td style="width:20%;">
					<input type="text" id="hr_name" name="hr_name" >
				</td>
				<td style="width:40%;">* 퇴사자는 이름 검색만 가능합니다.</td>
			</tr>
		</table>
		<div id="HumanList"></div>
</body>
</html>