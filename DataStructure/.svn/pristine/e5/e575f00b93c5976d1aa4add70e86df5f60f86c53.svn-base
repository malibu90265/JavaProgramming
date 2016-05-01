<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
	// 소요인원수 집어넣을 것.
	var pjId = ${   };
	
	$(document).ready(function() {
		
		getCandidateDetailFormAjax(pjId);
		
	});
</script>
</head>
<body>
	
	<div>
		<table border="1">
			<tr>
				<th rowspan="2">번호</th>
				<th rowspan="2">등급</th>
				<th rowspan="2">전문기술</th>
				<th colspan="2">투입기간</th>
				<th rowspan="2">직원/외주</th>
			</tr>
			<tr>
				<th>투입일</th>
				<th>만료일</th>
			</tr>
			
			<c:forEach var = "    " items="${    }">
				<tr>			
					<td>${    }</td> <!--번호/등급/전문기술/투입일/만료일/직원외주  -->
					<td>${    }</td>	
					<td>${    }</td>	
					<td>${    }</td>	
					<td>${    }</td>	
					<td>${    }</td>				
				</tr>
			</c:forEach>

		</table>
	</div>
	
	<div id=" detail form이 들어올 자리!">
	
	
	
	</div>
	
		
	
</body>
</html>