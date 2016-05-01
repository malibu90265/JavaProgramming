<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<!-- 입력 값 검증을 위한 js 파일 include -->
<script type="text/javascript">

	$(document).ready(function() {
		setSpanTagDisabled("categoryDeleteBtn");
	});
	
	function setSpanTagDisabled(spanId){
		document.getElementById(spanId).disabled = true;
	}
	
	var myPicker = new jscolor.color(document.getElementById("myfield"), {hash:true});
	
</script>
</head>
<body>
	<form:form commandName="categoryVO" id="categoryInsertForm" name="categoryInsertForm">
		<table class="categoryInputbordered">
			<tr>
				<th>대분류명</th>
				<td>
					<input type="text" name="name" id="categoryName" onkeypress="if(event.keyCode == 13){return false;}" placeholder="영어+한글 입력">
				</td>
			</tr>
			<tr>
				<th>Color</th>
				<td>
					<input id="myfield" name="color" value="#000000">
				</td>
			</tr>
		</table>
	</form:form>
	
	<div id="bottomLine">
		<span id="categoryInsertBtn">저장</span> 
		<span id="categoryDeleteBtn">삭제</span> 
		<span id="categoryResetBtn">비우기</span> 
	</div>
	
</body>
</html>