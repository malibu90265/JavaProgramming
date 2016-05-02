<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="jobSkillBordered">
	<tr>
		<th>직무</th>
		<th>기술</th>
	</tr>
</table>
<div style="height: 240px;overflow: auto; overflow-x: hidden; text-overflow: ellipsis;">
<table class="jobSkillBordered" style="width: 316px;">
	<c:forEach var="jobSkill" items="${jobSkillList}">
		<tr class="jobSkillRow">
			<td>${jobSkill.business_division }</td>
			<td>${jobSkill.each_skill }</td>
		</tr>
	</c:forEach>
</table>
</div>
