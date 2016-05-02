<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	
	function setSpanTagDisabled(spanId){
		document.getElementById(spanId).disabled = true;
	}
	
	$(document).ready(function() {
		setSpanTagDisabled("skillEnvDeleteBtn");
	});
	
</script>

<form:form commandName="skill_envVO" id="skillEnvInsertForm" name="skillEnvInsertForm">
	<table id="skillEnvInputbordered">
		<tr>
			<th>구분</th>
			<td>
				<input type="text" name="environment_division" size="18" value="${skillEnvDivision }"/>
			</td>
		</tr>
		<tr>
			<th>환경</th>
			<td>
				<input type="text" name="each_environment" size="18" value="${skillEnv.each_environment }" />
			</td>
		</tr>
	</table>
</form:form>

<div id="bottomLine">
	<span id="skillEnvInsertBtn">저장</span> 
	<span id="skillEnvDeleteBtn">삭제</span> 
	<span id="skillEnvResetBtn">비우기</span> 
</div>
	
