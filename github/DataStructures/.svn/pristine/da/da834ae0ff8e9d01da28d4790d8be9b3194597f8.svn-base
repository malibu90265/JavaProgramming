<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table id="skillEnvSearch">
	<tr>
		<th>환경분류</th>
		<td>
			<select id="skillEnvSelectBox">
				<c:forEach var="skillEnv" items="${skillEnvList }">
					<c:choose>
						<c:when test="${skillEnv eq skillEnvDivision }">
							<option value="${skillEnv }" selected="selected">${skillEnv }</option>
						</c:when>
						<c:otherwise>
							<option value="${skillEnv }">${skillEnv }</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
	</tr>
</table>
