<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div id="menuTable">
		<table class="menuBordered">
			<tr>
				<th>대분류명</th>
				<th>메뉴순서</th>
				<th>메뉴명</th>
				<th>메뉴URL</th>
			</tr>
			<c:forEach var="menu" items="${menuList}">
				<tr class="menuRow">
					<td class="${menu.categoryId }">${menu.categoryName }</td>
					<td>${menu.sq }</td>
					<td>${menu.name }</td>
					<td>${menu.url }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>