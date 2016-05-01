<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	// 팀 검색
	$('#tm_id').change(function() {
		var tm_id = $(this).children("option:selected").val();
		getEstimationSearchTeamAjax(tm_id);
	});
	
	
	$("#hr_name").keyup(function(event) {
		var hr_name = $("#hr_name").val();
		getEstimationSearchNameAjax(hr_name);
	});
	
</script>
<style type="text/css">
	/* #searchTable, #searchTable select {width: 100%;} */
</style>
</head>
<body>
	
	<form:form commandName="estimationVO" id="estimationSearchForm" name="estimationSearchForm">
		<table id="searchTable">
			<tr>
				<th>팀명</th>
				<td>
					<select name="tm_id" id="tm_id">
						<c:forEach var="rank" items="${teamOptions.keySet() }">
							<option value="${rank }" >${teamOptions.get(rank) }</option>
						</c:forEach>
					</select>
				</td>
				<th>이름검색</th>
				<td>
					<input type="text" id="hr_name" name="hr_name" >
				</td>
			</tr>
		</table>
	</form:form>	
</body>
</html>