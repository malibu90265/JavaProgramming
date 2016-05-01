<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	#costmapSearchTable, #costmapSearchTable select {width: 100%;}
</style>
</head>
<body>
	<table id="costmapSearchTable">
			<tr>
				<th>팀명</th>
				<td>
					<select name="tm_id" id="tm_id"> 
						<option value="0">선택</option>
						<c:forEach var="team" items="${teamList}">
							<option value="${team.tm_id}">${team.tm_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
</body>
</html>