<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- 상세 내용 수정 하는 페이지!!!!  -->
<!DOCTYPE html>
<html>
<head>
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
		
		
	<c:forEach var="condition" items="${conditions }" varStatus="status">
		<tr>
			<td>
				<c:out value="${status.count }"></c:out> 
			</td>
			<td>
				<select name="ranks">
					<c:forEach var="rank" items="${defaultRanks.keySet() }">
						<c:choose>
							<c:when test="${condition.rank eq rank}">
								<option value="${rank }" selected="selected" >${defaultRanks.get(rank) }</option>
							</c:when>
							<c:otherwise>
								<option value="${rank }" >${defaultRanks.get(rank) }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="skills">
					<c:forEach var="skill" items="${defaultSkills.keySet()}">
						<c:choose>
							<c:when test="${condition.professionalSkill eq skill }">
								<option value="${skill }" selected="selected" >${defaultSkills.get(skill) }</option>
							</c:when>
							<c:otherwise>
								<option value="${skill }" >${defaultSkills.get(skill) }</option>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</select>
			</td>
			<td>
				소요일
			</td>
			<td>
				종료일
			</td>
			<td>
				MM계산
			</td>
			<td>
				PJ단가
			</td>
			<td>
				배치예정자
			</td>
			<td>
				등급
			</td>
			<td>
				단가
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>