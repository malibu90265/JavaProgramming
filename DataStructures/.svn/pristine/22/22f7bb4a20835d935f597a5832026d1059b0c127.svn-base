<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table id="jobSkillSearch">
	<tr>
		<th>직무분류</th>
		<td>
			<select id="jobSkillSelectBox">
				<c:forEach var="jobSkill" items="${jobSkillList }">
					<c:choose>
						<c:when test="${jobSkill eq jobSkillDivision }">
							<option value="${jobSkill }" selected="selected">${jobSkill }</option>
						</c:when>
						<c:otherwise>
							<option value="${jobSkill }">${jobSkill }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
	</tr>
</table>
