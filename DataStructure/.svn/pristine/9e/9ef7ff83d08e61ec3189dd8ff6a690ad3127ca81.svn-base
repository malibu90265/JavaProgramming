<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/js/employeeInput/employeeInput.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/employeeInput/jquery.fixedheadertable.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	
	});
</script>
<style type="text/css">
	#employeeInputTableTh {width: 100%;}
	#employeeInputTb {width: 100%; table-layout: fixed;}
	#employeeInputTable {height: 70vh; height: 70vm; overflow-y:scroll;}
	th {text-align: center;}
</style>
</head>
<body>
	<div>
		<table id="employeeInputTableTh">
			<tr>
				<th style="width:30%;">프로젝트ID</th>
				<th>프로젝트 명</th>
			</tr>
		</table>
	</div>
	<div id="employeeInputTable" >
		<table id="employeeInputTb" >
			<c:forEach var="employeeInput" items="${searchTeamProjectList }">
				<tr class="employeeInputRow" >
					<td class="pj_id"style="width:32%;">${employeeInput.pj_id }</td>
					<td class="pj_name" style="text-overflow:ellipsis; overflow:hidden;"><nobr>${employeeInput.pj_name }</nobr></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>

