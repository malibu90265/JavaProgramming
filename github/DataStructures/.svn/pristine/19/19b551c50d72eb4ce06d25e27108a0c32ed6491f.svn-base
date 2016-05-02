<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div id="grid" class="grid">
		<c:forEach var="menu" items="${menuList }" >
		<div class="grid__item"
			id="dragText ${menu.categoryId } ${menu.sq}"
			draggable="true"
			ondragstart="drag(event)"
			style='background-color:<c:out value="${menu.categoryColor}"/>;'>
				<a draggable="false" href='<c:url value="${menu.url }"/>'>
					${menu.categoryName}<br/><p draggable="false">${menu.name}</p>
				</a>
		</div>
		</c:forEach>
	</div>
	
</body>
</html>