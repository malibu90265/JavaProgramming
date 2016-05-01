<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div style="text-align:left;">
		<c:forEach var="pjStatus" items="${pjStatusList }">
			<span class="pjStatusColor" style='background-color:<c:out value="${pjStatus.pj_status_color}"/>; color:<c:out value="${pjStatus.pj_status_text_color}"/>;'>
				${pjStatus.pj_status_name }
			</span>
		</c:forEach>
	</div>
	<div style="height: 590px; overflow:auto; overflow-x:hidden; ">
		<table class="bordered">
			<tr>
				<c:forEach var="project" items="${projectList}" varStatus="status">
					<c:if test="${status.count != 1 && status.count % 5 == 1 }"><tr/><tr></c:if>
					<th class="pjProgress" id="${project.pj_id }" style='background-color:<c:out value="${project.pj_status_color}"/>; color:<c:out value="${project.pj_status_text_color}"/>;'>
						${project.pj_id }
					</th>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>