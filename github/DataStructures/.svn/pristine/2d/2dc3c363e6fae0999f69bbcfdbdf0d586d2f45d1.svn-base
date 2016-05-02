<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form id="skillEnvModifyForm" name="skillEnvModifyForm">
	<input type="hidden" name="environment_division_origin" value="${skillEnv.environment_division }">
	<input type="hidden" name="each_environment_origin" value="${skillEnv.each_environment }">
	<table id="skillEnvInputbordered">
		<tr>
			<th>구분</th>
			<td>
				<input type="text" name="environment_division_modify" size="18" value="${skillEnv.environment_division }"/>
			</td>
		</tr>
		<tr>
			<th>환경</th>
			<td>
				<input type="text" name="each_environment_modify" size="18" value="${skillEnv.each_environment }" />
			</td>
		</tr>
	</table>
</form:form>

<form:form commandName="skill_envVO" id="skillEnvDeleteForm" name="skillEnvDeleteForm">
	<input type="hidden" name="environment_division" value="${skillEnv.environment_division }">
	<input type="hidden" name="each_environment" value="${skillEnv.each_environment }">
</form:form>

<div id="bottomLine">
	<span id="skillEnvModifyBtn">저장</span> 
	<span id="skillEnvDeleteBtn">삭제</span> 
	<span id="skillEnvResetBtn">비우기</span> 
</div>
	
