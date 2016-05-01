<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form id="jobSkillModifyForm" name="jobSkillModifyForm">
	<input type="hidden" name="business_division_origin" value="${jobSkill.business_division }">
	<input type="hidden" name="each_skill_origin" value="${jobSkill.each_skill }">
	<table id="jobSkillInputbordered">
		<tr>
			<th>직무</th>
			<td>
				<input type="text" name="business_division_modify" size="18" value="${jobSkill.business_division }"/>
			</td>
		</tr>
		<tr>
			<th>기술</th>
			<td>
				<input type="text" name="each_skill_modify" size="18" value="${jobSkill.each_skill }" />
			</td>
		</tr>
	</table>
</form:form>

<form:form commandName="jobSkillVO" id="jobSkillDeleteForm" name="jobSkillDeleteForm">
	<input type="hidden" name="business_division" value="${jobSkill.business_division }">
	<input type="hidden" name="each_skill" value="${jobSkill.each_skill }">
</form:form>

<div id="bottomLine">
	<span id="jobSkillModifyBtn">저장</span> 
	<span id="jobSkillDeleteBtn">삭제</span> 
	<span id="jobSkillResetBtn">비우기</span> 
</div>
	
