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
		
		setSpanTagDisabled("roleDeleteBtn");
	});
	

	
</script>
</head>
<body>
	<table id="roleInputbordered">
		<tr>
			<th>역할분류</th>
			<td>
				<input type="text" id="each_role" name="each_role" size="13">
			</td>
		</tr>
	</table>
	
	<div id="bottomLine">
		<span id="roleInsertBtn">저장</span> 
		<span id="roleDeleteBtn">삭제</span> 
		<span id="roleResetBtn">비우기</span> 
	</div>
	
</body>
</html>