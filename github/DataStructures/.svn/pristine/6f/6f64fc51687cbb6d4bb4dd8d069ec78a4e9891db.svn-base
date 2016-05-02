<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		
		$(".projectRow").click(function() {
			var pj_id = $(this).children().eq(1).text();
			getProjectModifyFormAjax(pj_id);
		});
		
		
 		var value = $("#dateT").width()/3 - 1;
		$("#test").css('width', value);
	
	});
	
</script>
</head>
<body>
	<table class="bordered">
		<tr>
			<th class="pjStatusT">상태</th>
			<th class="pjIdT">프로젝트ID</th>
			<th class="pjNameT">프로젝트명</th>
			<th class="pjOrderT">영업단계</th>
			<th class="pjOrderT">발주고객</th>
			<th class="pjSignT">계약액</th>
			<th class="pjDateT" id="dateT">시작일</th>
			<th class="pjDateT">종료일</th>
		</tr>
	</table>
	<div style="max-height: 650px; overflow:scroll; overflow-x: hidden; white-space: nowrap;">
		<table class="bordered">
		<c:forEach var="project" items="${projectList}" varStatus="status">
			<tr class="projectRow">
				<td class="pjStatusT">${project.pj_status_name}</td>
				<td class="pjIdT">${project.pj_id }</td>
				<td class="pjNameT">${project.pj_name }</td>
				<td class="pjOrderT">
					<c:forEach var="projectStage" items="${projectStageList }">
						<c:if test="${projectStage.pj_stage_id eq project.pj_stage }">
							${projectStage.pj_stage_name }
						</c:if>
					</c:forEach>
				</td>
				<td class="pjOrderT">${project.pj_order_client }</td>
				<td class="pjSignT" style="text-align: right;"><fmt:formatNumber pattern="#,###" value="${project.pj_amount }" /></td>
				<td class="pjDateT">${project.pj_start_date }</td>
				<td class="pjDateScrollT" id="test" >${project.pj_end_date }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>