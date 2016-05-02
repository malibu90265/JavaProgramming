<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
	
</script>
</head>
<body>
	<table class="bordered">
		<tr>
			<th style="width: 100px;">프로젝트ID</th>
			<th style="width: 300px;">프로젝트명</th>
			<th style="width: 100px;">PM명</th>
			<th style="width: 113px;">근무지</th>
		</tr>
	</table>
	<div id="projectListTable" style="width: 619px; max-height: 630px; overflow: scroll; overflow-x: hidden; white-space: nowrap;">
		<table class="bordered" style="width: 580px;">
			<c:forEach var="project_setting" items="${project_settingList}">
				<tr class="project_settingRow">
					<td style="width:100px; text-overflow:ellipsis; overflow: hidden;">${project_setting.pj_id }</td>
					<td style="width:300px; text-overflow:ellipsis; overflow: hidden;">${project_setting.pj_name }</td>
					<td style="width:100px; text-overflow:ellipsis;">${project_setting.pj_pm }</td>
					<td style="width:100px; text-overflow:ellipsis;">${project_setting.pj_loc }</td>
				</tr>
			</c:forEach>
		</table>
	</div>	
</body>
