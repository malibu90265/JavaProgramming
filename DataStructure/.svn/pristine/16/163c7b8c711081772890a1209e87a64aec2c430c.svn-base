<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	// 년도 검색
	$("#searchYear").change(function() {
		var searchYear = $(this).children("option:selected").text();
		getEstimationSignupYearAjax(searchYear);
		
	});
	// 프로젝트 검색
	$('#pj_id').change(function() {
		var pj_id = $(this).children("option:selected").text();
		getEstimationSignupProjectAjax(pj_id);
	});
	
	
</script>
<style type="text/css">
	#searchTable, #searchYear, #pj_id {width: 100%;}
</style>
</head>
<body>
	
	<form:form commandName="estimationVO" id="estimationSearchForm" name="estimationSearchForm">
			<table id="searchTable">
				<tr>
					<th>년도 검색</th>
					<td>
						<select name="searchYear" id="searchYear"> 
							<c:forEach var="searchYear_rank" items="${yearSearch}" varStatus="status">
							<option value="${yearSearch[status.index]}">${yearSearch[status.index]}</option>
							</c:forEach>
						</select>
					</td>
					<th>프로젝트ID</th>
					<td>
						<select name="pj_id" id="pj_id"> 
							<c:forEach var="pj_id_rank" items="${pjIDOptions.keySet()}">
							<option value="${pjIDOptions.get(pj_id)}">${pjIDOptions.get(pj_id_rank)}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
	</form:form>
</body>
</html>