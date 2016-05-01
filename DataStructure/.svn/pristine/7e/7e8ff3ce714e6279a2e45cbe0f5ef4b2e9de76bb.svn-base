<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div id="categoryTable" >
		<table class="categoryBordered">
			<tr>
				<th>대분류ID</th>
				<th>대분류명</th>
				<th>Color</th>
			</tr>
			<c:forEach var="category" items="${categoryList}">
				<tr class="categoryRow" >
					<td>${category.id }</td>
					<td>${category.name }</td>
					<td style="background-color: ${category.color };"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>