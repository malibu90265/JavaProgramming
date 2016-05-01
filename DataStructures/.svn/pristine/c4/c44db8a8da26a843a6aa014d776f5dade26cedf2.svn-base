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
	
	//이름검색
	$("#hr_name").keyup(function(event) {
		var hr_name = $("#hr_name").val();
		getOutHumanResourceSearchNameAjax(hr_name);
	});
	
	//등급검색
	$("#hr_grade").keyup(function(event) {
		var hr_grade = $("#hr_grade").val();
		getOutHumanResourceSearchGradeAjax(hr_grade);
	});
	
</script>
<style type="text/css">
 #projectSearchTable th {width: 15%;}
 #projectSearchTable td select, #projectSearchTable td input[type="text"] {width: 100%;}
</style>
</head>
<body>
	
	<form:form commandName="" id="" name="">
		<table id="projectSearchTable">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" id="hr_name" name="hr_name" >
				</td>
				<th>등급</th>
				<td>
					<input type="text" id="hr_grade" name="hr_grade">
				</td>
			</tr>
		</table>
	</form:form>	
		<div id="outHumanList"></div>
</body>
</html>