<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table class="pjStageBordered">  
		<tr>
			<th>영업단계</th>
		</tr>
	</table>
<div style="height: 240px;overflow: auto; overflow-x: hidden; text-overflow: ellipsis;">
	<table class="pjStageBordered">  
		<c:forEach var="stage" items="${pjStageList}">
			<tr>
				<td class="pjStageRow" id="${stage.pj_stage_id }">${stage.pj_stage_name }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>