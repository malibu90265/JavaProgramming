<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form:form commandName="pjProgressSearchVO" id="pjProgressSearchForm" name="pjProgressSearchForm" method="post">
		<table class="search">
			<tr>
				<th class="basic" style="width: 60px;">팀명</th>
				<td>
					<select id="tm_id" name="tm_id" onchange="getProjectListByPjProgressSearchConditionsPageAjax('#pjProgressSearchForm');">
						<c:forEach var="team" items="${teamList }">
							<option value="${team.tm_id }">${team.tm_name }</option>
						</c:forEach>
					</select>
				</td>
				<th class="basic" style="width: 90px;">추진 상태</th>
				<td>
					<select name="pj_status_id" onchange="getProjectListByPjProgressSearchConditionsPageAjax('#pjProgressSearchForm');">
						<option value="0">전체</option>
						<c:forEach var="pjStatus" items="${pjStatusList}">
							<option value="${pjStatus.pj_status_id }">${pjStatus.pj_status_name }</option>
						</c:forEach>
					</select>
				</td>
				<th class="basic" style="width: 70px;">년월주</th>
				<td>
					<select id="pp_date" name="pp_date" onchange="getProjectListByPjProgressSearchConditionsPageAjax('#pjProgressSearchForm');">
						<c:forEach var="week" items="${weekList }">
							<c:choose>
								<c:when test="${week eq presentWeek }">
									<option value="${week }" selected="selected">${week }</option>
								</c:when>
								<c:otherwise>
									<option value="${week }">${week }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
