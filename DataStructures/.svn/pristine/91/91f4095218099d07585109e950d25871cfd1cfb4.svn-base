<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	
	function setSpanTagDisabled(spanId){
		document.getElementById(spanId).disabled = true;
	}
	
	$(document).ready(function() {
		setSpanTagDisabled("jobSkillDeleteBtn");
	});
	
</script>

<form:form commandName="jobSkillVO" id="jobSkillInsertForm" name="jobSkillInsertForm">
	<table id="jobSkillInputbordered">
		<tr>
			<th>직무</th>
			<td>
				<input type="text" name="business_division" size="18" value="${jobSkillDivision }"/>
			</td>
		</tr>
		<tr>
			<th>기술</th>
			<td>
				<input type="text" name="each_skill" size="18" />
			</td>
		</tr>
	</table>
</form:form>

<div id="bottomLine">
	<span id="jobSkillInsertBtn">저장</span> 
	<span id="jobSkillDeleteBtn">삭제</span> 
	<span id="jobSkillResetBtn">비우기</span> 
</div>
	
