<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#deployRequirementsTable {width:100%; height:100%; overflow-y: auto;}
	#deployRequirementsTb {width:100%; table-layout: fixed; border-bottom:1px #cecece solid;}
	#deployRequirementsTb th {text-align: center;}
</style>
</head>
<body>
	<div id="deployRequirementsTable" >
		<table id="deployRequirementsTb" class="bordered" >
			<tr>
				<th style="width: 23%">프로젝트ID</th>
				<th style="width: 27%">프로젝트 명</th>
				<th>소요</th>
				<th>미배치</th>
				<th>미투입</th>
				<th>과투입</th>
			</tr>
			<c:forEach var="UndecidedList" items="${UndecidedList }">
				<tr class="UndecidedRow" >
					<td class="pj_id" style="text-align: left;">${UndecidedList.pj_id }</td>
					<td class="pj_name" style="text-align: left; text-overflow:ellipsis; overflow:hidden"><nobr>${UndecidedList.pj_name }</nobr></td>
					<td class="require_num" style="text-align: center;">${UndecidedList.require_num }</td>
					<td class="placements_num" style="text-align: center;">${UndecidedList.placements_num }</td>
					<td class="deployless_num" style="text-align: center;">${UndecidedList.deployless_num }</td>
					<td class="deploy_num" style="text-align: center;">${UndecidedList.deploy_num }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>

