<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<!-- 입력 값 검증을 위한 js 파일 include -->
<script type="text/javascript">
	var myPicker = new jscolor.color(document.getElementById("myfield"), {hash:true});
</script>
</head>
<body>
	<form:form commandName="categoryVO" id="categoryModifyForm" name="categoryModifyForm">
		<input type="hidden" id="categoryId" name="id" value="${category.id }"/>
		<table class="categoryInputbordered">
			<tr>
				<th>대분류명</th>
				<td>
					<input type="text" id="categoryName" name="name" onkeypress="if(event.keyCode == 13){return false;}" placeholder="영어+한글 입력" value="${category.name }">
				</td>
			</tr>
			<tr>
				<th>Color</th>
				<td>
					<input id="myfield" name="color" value="${category.color }">
				</td>
			</tr>
		</table>
	</form:form>
	
	<div id="bottomLine">
		<span id="categoryModifyBtn">저장</span> 
		<span id="categoryDeleteBtn">삭제</span> 
		<span id="categoryResetBtn">비우기</span> 
	</div>
	
</body>
</html>