<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach var="humanResource" items="${humanResourceList }" varStatus="i" >
			<c:if test="${i.index % 4 == 0 } ">
				<tr class="humanResourcesRow">
			</c:if>
					<td id="humanResourceTd">
						<%-- <img src="<c:out value="/resources/employee/${humanResource.hr_img}"/>"> --%>
						<img src="<c:out value="/humanResource/download/${humanResource.hr_name}"/>">
						<div>${humanResource.hr_name }</div>
						<div>${humanResource.hr_position }</div>
					</td>
			<c:if test="${i.index % 4 == 3 || i.index == humanResourceList.size() }">
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>