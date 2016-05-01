<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<!-- 입력 값 검증을 위한 js 파일 include -->
<script type="text/javascript">
	
	function setSpanTagDisabled(spanId){
		document.getElementById(spanId).disabled = true;
	}
	
	$(document).ready(function() {
		
		setSpanTagDisabled("pjStageDeleteBtn");
		
	});
	
</script>
</head>
<body>
	<table id="pjStageInputbordered">
		<tr>
			<th>영업단계</th>
			<td>
				<input type="text" id="pj_stage_name" name="pj_stage_name" size="9">
			</td>
		</tr>
	</table>
	
	<div id="bottomLine">
		<span id="pjStageInsertBtn">저장</span> 
		<span id="pjStageDeleteBtn">삭제</span> 
		<span id="pjStageResetBtn">비우기</span> 
	</div>
	
</body>
</html>