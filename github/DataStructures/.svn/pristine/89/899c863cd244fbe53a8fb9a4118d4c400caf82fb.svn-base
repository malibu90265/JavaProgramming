<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#humanResourceTd {cursor: pointer;}
	#outHumaResourceListTable {width: 100%;}
</style>
</head>
<body>

	<!-- list 바꾸기.. 사진은 나중에. -->
	
	<table id="outHumaResourceListTable">
		<c:forEach var="outHumanResource" items="${outHumanResourceList}" varStatus="i" >
			<c:if test="${i.index % 5 == 0 } ">
				<tr class="humanResourcesRow">
			</c:if>
			
				<c:choose>
					<c:when test="${outHumanResource.hr_grade == '특급'}">
						<td id="humanResourceTd" class="humanResourcesTd" style="background-color:#A8E2EB;">
							<div>${outHumanResource.hr_name }</div>
							<div>${outHumanResource.hr_grade}</div>
						</td>
					</c:when>
					<c:when test="${outHumanResource.hr_grade == '중급'}">
						<td id="humanResourceTd" class="humanResourcesTd" style="background-color:#D0C75D;">
							<div>${outHumanResource.hr_name }</div>
							<div>${outHumanResource.hr_grade}</div>
						</td>
					</c:when>
					<c:when test="${outHumanResource.hr_grade == '고급'}">
						<td id="humanResourceTd" class="humanResourcesTd" style="background-color:#FEB369;">
							<div>${outHumanResource.hr_name }</div>
							<div>${outHumanResource.hr_grade}</div>
						</td>
					</c:when>
					<c:when test="${outHumanResource.hr_grade == '초급'}">
						<td id="humanResourceTd" class="humanResourcesTd" style="background-color:#fed223;">
							<div>${outHumanResource.hr_name }</div>
							<div>${outHumanResource.hr_grade}</div>
						</td>
					</c:when>
					<c:otherwise>
						<td id="humanResourceTd" class="humanResourcesTd" >
							<div>${outHumanResource.hr_name }</div>
							<div>${outHumanResource.hr_grade}</div>
						</td>
					</c:otherwise>
				</c:choose>
				
			<c:if test="${i.index % 5 == 4 || i.index == outHumanResourceList.size() }">
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>