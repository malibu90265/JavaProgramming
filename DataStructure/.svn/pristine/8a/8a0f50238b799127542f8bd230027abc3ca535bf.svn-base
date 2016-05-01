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
		
		setSpanTagDisabled("menuDeleteBtn");
	});
	

	
</script>
</head>
<body>
	<form:form commandName="menuVO" id="menuInsertForm" name="menuInsertForm">
		<table class="menuInputbordered">
			<tr>
				<th>대분류명</th>
				<td>
					<select id="categoryId" name="categoryId">
						<c:forEach var="category" items="${categoryList }">
							<option value="${category.id }">${category.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>메뉴순서</th>
				<td>
					<input type="text" name="sq" id="menuSq" placeholder="menuSq를 입력해주세요." >
				</td>
			</tr>
			<tr>
				<th>메뉴명</th>
				<!-- 영어와 한글에 대한 입력필드 검증이 필요함. -->
				<td>
					<input type="text" id="menuName" name="name" placeholder="menuName을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<th>메뉴URL</th>
				<!-- /로 시작해서 영어와 / 로만 입력이 되는 검증이 필요함. -->
				<td>
					<input type="text" id="menuURL" name="url" placeholder="url을 입력해주세요.">
				</td>
			</tr>
		</table>
	</form:form>
	
	<div id="bottomLine">
		<span id="menuInsertBtn">저장</span> 
		<span id="menuDeleteBtn">삭제</span> 
		<span id="menuResetBtn">비우기</span> 
	</div>
	
</body>
</html>