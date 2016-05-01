<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form:form commandName="menuVO" id="menuModifyForm" name="menuModifyForm">
		<input type="hidden" name="originalSq" value="${menu.sq }"/>
		<input type="hidden" name="originalCategoryId" value="${menu.categoryId }"/>
		<table class="menuInputbordered">
			<tr>
				<th>대분류명</th>
				<td>
					<select id="categoryId" name="categoryId">
						<c:forEach var="category" items="${categoryList }">
							<c:choose>
								<c:when test="${category.id == menu.categoryId }">
									<option value="${category.id }" selected="selected">${category.name }</option>
								</c:when>
								<c:otherwise>
									<option value="${category.id }">${category.name }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>메뉴순서</th>
				<!-- 입력 시, 1 ~ lastSq 사이의 숫자만 입력하는 필드 검증이 필요함. -->
				<td>
					<input type="text" name="sq" id="menuSq" value="${menu.sq }" placeholder="menuSq를 입력해주세요.">
				</td>
			</tr>
			<tr>
				<th>메뉴명</th>
				<!-- 영어와 한글에 대한 입력필드 검증이 필요함. -->
				<td>
					<input type="text" id="menuName" name="name" value="${menu.name }" placeholder="menuName을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<th>메뉴URL</th>
				<!-- /로 시작해서 영어 -> / -> . 로만 입력이 되는 검증이 필요함. -->
				<td>
					<input type="text" id="menuURL" name="url" value="${menu.url }" placeholder="url을 입력해주세요.">
				</td>
			</tr>
		</table>
	</form:form>
	
	<div id="bottomLine">
		<span id="menuModifyBtn">저장</span> 
		<span id="menuDeleteBtn">삭제</span> 
		<span id="menuResetBtn">비우기</span> 
	</div>
	
</body>
</html>