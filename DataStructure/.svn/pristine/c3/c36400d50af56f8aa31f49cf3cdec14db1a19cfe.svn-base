<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	var myPicker = new jscolor.color(document.getElementById("pj_status_color"), {hash:true});
</script>
<form:form commandName="projectStatusVO" id="pjStatusModifyForm" name="pjStatusModifyForm">
	<input type="hidden" id="pj_status_id" name="pj_status_id" value="${projectStatus.pj_status_id }"/>
	<table class="pjStatusInputbordered">
		<tr>
			<th>추진상태</th>
			<td>
				<input type="text" name="pj_status_name" size="10" value="${projectStatus.pj_status_name}"/>
			</td>
		</tr>
		<tr>
			<th>Color</th>
			<td>
				<input type="text" id="pj_status_color" name="pj_status_color" size="10" value="${projectStatus.pj_status_color }" />
			</td>
		</tr>
	</table>
</form:form>

<div id="bottomLine">
	<span id="pjStatusModifyBtn">저장</span> 
	<span id="pjStatusDeleteBtn">삭제</span> 
	<span id="pjStatusResetBtn">비우기</span> 
</div>
	
