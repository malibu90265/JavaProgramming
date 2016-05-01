<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js" type="text/javascript"></script><script type="text/javascript" src="<c:url value="/resources/js/test/demoDeployRequirements.js"/>"></script>

<script>
/* 달력 출력 */
$("#pr_start_date").ready(function() { //입사일
	var id = "#pr_start_date";
	setDate(id);
	
});

$("#pr_end_date").ready(function() { //입사일
	var id = "#pr_end_date";
	setDate(id);
	
});
</script>
</head>
<body>
	<table>
		<tr>
			<th align="center">소요번호</th>
			<th align="center">등급</th>
			<th align="center">직무기술</th>
			<th align="center">배치일</th>
			<th align="center">종료일</th>
			<th align="center">개월 수</th>
			<th align="center">PJ 단가</th>
			<th align="center">배치예정자</th>
			<th align="center">등급</th>
			<th align="center">단가</th>
			<th align="center">거주지</th>
		</tr>
		
		
	<c:forEach var="i" begin="1" end="${requirePerson }">
		<tr>
			<td>
				<c:out value="${i }"></c:out> <!--소요번호-->
			</td>
			<td>
				<select name="ranks"> <!--등급 -->
					<c:forEach var="rank" items="${defaultRanks.keySet() }">
						<option value="${rank }" >${defaultRanks.get(rank) }</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="skills"> <!--직무기술 -->
					<c:forEach var="skill" items="${defaultSkills.keySet() }">
						<option value="${skill }" >${defaultSkills.get(skill) }</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<input type="text" id="pr_start_date" placeholder="ex) 0000-00-00" style="width:100%;"/>
			</td>
			<td>
				<input type="text" id="pr_end_date" placeholder="ex) 0000-00-00" style="width:100%;"/>
			</td>
			<td>
				개월 수
			</td>
			<td><!--PJ단가-->
				<input type="text" >
			</td>
			<td><!--배치예정자  -->
				<input type="text" >
			</td>
			<td><!--배치 예정자 이름 입력시 해당 직원의 등급과 단가, 거주지가 자동으로 입력됨 -->
				등급
			</td>
			<td>
				단가
			</td>
			<td>
				거주지
			</td>
			
		</tr>
	</c:forEach>
	</table>
</body>
</html>




<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<table>
		<tr>
			<th>인원번호</th>
			<th>등급</th>
			<th>전문기술</th>
			<th>요구기간</th>
		</tr>
	<c:forEach var="i" begin="1" end="${requirePerson }">
		<tr>
			<td>
				<c:out value="${i }"></c:out> 
			</td>
			<td>
				<select name="ranks">
					<c:forEach var="rank" items="${defaultRanks.keySet() }">
						<option value="${rank }" >${defaultRanks.get(rank) }</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="skills">
					<c:forEach var="skill" items="${defaultSkills.keySet() }">
						<option value="${skill }" >${defaultSkills.get(skill) }</option>
					</c:forEach>
				</select>
			</td>
			<td>
				요구기간
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html> --%>