<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table class="menuSearch">
		<tr>
			<th>대분류</th>
			<td>
				<select id="categorySearch">
					<c:choose>
						<c:when test="${selectId eq 0 }">
							<option value="0" selected="selected">전체</option>
						</c:when>
						<c:otherwise>
							<option value="0">전체</option>
						</c:otherwise>
					</c:choose>
					<c:forEach var="category" items="${categoryList }">
						<c:choose>
							<c:when test="${category.id eq categoryId}">
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
	</table>
</body>
</html>