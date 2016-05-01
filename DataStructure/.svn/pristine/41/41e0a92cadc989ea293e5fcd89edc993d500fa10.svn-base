<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#deployRequirementsTable {overflow-y: scroll; width: 100%; max-height: 70vh; max-height: 70vm;}
	#deployRequirementsTb {width: 100%;}
	#deployRequirementsTb th {text-align: center;}
	.pj_id {text-align: left;}
	.pj_name {text-overflow:ellipsis; overflow:hidden;}
</style>
</head>
<body>
	<div id="deployRequirementsTable">
		<table id="deployRequirementsTb" style="table-layout: fixed;">
			<tr>
				<th style="width:30%;">프로젝트ID</th>
				<th>프로젝트 명</th>
			</tr>
	<!-- 	</table>
	</div>
	<div id="deployRequirementsTable">
		<table style="table-layout: fixed;"> -->
			<c:forEach var="deployRequirement" items="${searchTeamProjectList }">
				<tr class="deployRequirementsRow">
					<td class="pj_id">${deployRequirement.pj_id }</td>
					<td class="pj_name" style="text-overflow:ellipsis; overflow:hidden;"><nobr>${deployRequirement.pj_name }</nobr></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>

