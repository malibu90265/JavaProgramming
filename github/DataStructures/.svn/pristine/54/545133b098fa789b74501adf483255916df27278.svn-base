<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	
	$(document).ready(function() {
		setSpanTagDisabled("pjStatusDeleteBtn");
		
	});
	
	function setSpanTagDisabled(spanId){
		document.getElementById(spanId).disabled = true;
	}
	
	var myPicker = new jscolor.color(document.getElementById("pj_status_color"), {hash:true});
	
</script>

<form:form commandName="projectStatusVO" id="pjStatusInsertForm" name="pjStatusInsertForm">
	<table class="pjStatusInputbordered">
		<tr>
			<th>추진상태</th>
			<td>
				<input type="text" name="pj_status_name" size="10"/>
			</td>
		</tr>
		<tr>
			<th>Color</th>
			<td>
				<input type="text" id="pj_status_color" name="pj_status_color" size="10" value="#000000" />
			</td>
		</tr>
	</table>
</form:form>

<div id="bottomLine">
	<span id="pjStatusInsertBtn">저장</span> 
	<span id="pjStatusDeleteBtn">삭제</span> 
	<span id="pjStatusResetBtn">비우기</span> 
</div>
	
