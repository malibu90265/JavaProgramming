<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>


<script>
	$(function() {
		$(".startNeedsDate" ).datepicker();
		$(".endNeedsDate" ).datepicker();		
	});
</script>
</head>
<body>
	<table id="pjNeedsTable" border="1" style>
		<tr>
			<th>인원번호</th>
			<th>등급</th>
			<th>전문기술</th>
			<th>요구기간</th>
			<th>직원/외주</th>
			<th>근무지</th>
		</tr>
		<c:choose>
			<c:when test="${requirePerson eq '-1'}">
			</c:when>
			<c:otherwise>
				<c:forEach var="pjNeeds" items="${pjNeedsVO }" begin="0" end="${requirePerson }" step="1">
		
					<tr>
						<td><c:out value="${pjNeeds.pn_num }"></c:out></td>
						<td><select id="pjGrade">
								<c:choose>
									<c:when test="${pjNeeds.pn_grade eq '특급' }">
										<option value="${pjNeeds.pn_grade}" selected="selected">특급</option>
										<option value="고급">고급</option>
										<option value="중급">중급</option>
										<option value="초급">초급</option>
									</c:when>
									<c:when test="${pjNeeds.pn_grade eq '고급' }">
										<option value="특급">특급</option>
										<option value="${pjNeeds.pn_grade}" selected="selected">고급</option>
										<option value="중급">중급</option>
										<option value="초급">초급</option>
									</c:when>
									<c:when test="${pjNeeds.pn_grade eq '중급' }">
										<option value="특급">특급</option>
										<option value="고급">고급</option>
										<option value="${pjNeeds.pn_grade}" selected="selected">중급</option>
										<option value="초급">초급</option>
									</c:when>
									<c:when test="${pjNeeds.pn_grade eq '초급' }">
										<option value="특급">특급</option>
										<option value="고급">고급</option>
										<option value="중급">중급</option>
										<option value="${pjNeeds.pn_grade}" selected="selected">초급</option>
									</c:when>
									<c:otherwise>
										<option value="특급" selected="selected">특급</option>
										<option value="고급">고급</option>
										<option value="중급">중급</option>
										<option value="초급">초급</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td><select id="pjSkill">
								<c:choose>
									<c:when test="${pjNeeds.pn_skill eq 'SERVER' }">
										<option value="${pjNeeds.pn_skill}" selected="selected">SERVER</option>
										<option value="UI">UI</option>
										<option value="DB">DB</option>
										<option value="모바일">모바일</option>
										<option value="빌드">빌드</option>
										<option value="기타">기타</option>
									</c:when>
									<c:when test="${pjNeeds.pn_skill eq 'UI' }">
										<option value="SERVER">SERVER</option>
										<option value="${pjNeeds.pn_skill}" selected="selected">UI</option>
										<option value="DB">DB</option>
										<option value="모바일">모바일</option>
										<option value="빌드">빌드</option>
										<option value="기타">기타</option>
									</c:when>
									<c:when test="${pjNeeds.pn_skill eq 'DB' }">
										<option value="SERVER">SERVER</option>
										<option value="UI">UI</option>
										<option value="${pjNeeds.pn_skill}" selected="selected">DB</option>
										<option value="모바일">모바일</option>
										<option value="빌드">빌드</option>
										<option value="기타">기타</option>
									</c:when>
									<c:when test="${pjNeeds.pn_skill eq '모바일' }">
										<option value="SERVER">SERVER</option>
										<option value="UI">UI</option>
										<option value="DB">DB</option>
										<option value="${pjNeeds.pn_skill}" selected="selected">모바일</option>
										<option value="빌드">빌드</option>
										<option value="기타">기타</option>
									</c:when>
									<c:when test="${pjNeeds.pn_skill eq '빌드' }">
										<option value="SERVER">SERVER</option>
										<option value="UI">UI</option>
										<option value="DB">DB</option>
										<option value="모바일">모바일</option>
										<option value="${pjNeeds.pn_skill}" selected="selected">빌드</option>
										<option value="기타">기타</option>
									</c:when>
									<c:when test="${pjNeeds.pn_skill eq '기타' }">
										<option value="SERVER">SERVER</option>
										<option value="UI">UI</option>
										<option value="DB">DB</option>
										<option value="모바일">모바일</option>
										<option value="빌드">빌드</option>
										<option value="${pjNeeds.pn_skill}" selected="selected">기타</option>
									</c:when>
									<c:otherwise>
										<option value="SERVER" selected="selected">SERVER</option>
										<option value="UI">UI</option>
										<option value="DB">DB</option>
										<option value="모바일">모바일</option>
										<option value="빌드">빌드</option>
										<option value="기타">기타</option>
									</c:otherwise>
								</c:choose>
						</select></td>
						<td>
							<input	type="text"
										style="width: 138px; text-align: center;"
										id="startNeedsDate" 
										value="${pjNeeds.pn_day_from}"
										class="startNeedsDate"/> - 
		
							<input	type="text"
										style="width: 138px; text-align: center;"
										id="endNeedsDate"
										value="${pjNeeds.pn_day_to}"
										class="endNeedsDate"/>				</td>
		
						<td><select id="pjNeedsDivision">
								<c:choose>
									<c:when test="${pjNeeds.division eq '직원' }">
										<option value="${pjNeeds.division}" selected="selected">직원</option>
										<option value="외주">외주</option>
									</c:when>
									<c:when test="${pjNeeds.division eq '외주' }">
										<option value="직원">직원</option>
										<option value="${pjNeeds.division}" selected="selected">외주</option>
									</c:when>
									<c:otherwise>
										<option value="직원" selected="selected">직원</option>
										<option value="외주">외주</option>
									</c:otherwise>
								</c:choose>
						</select></td>
		
						<td><input id="pjNeedsArea" type="text" class="area" disabled="disabled" value="${pjNeeds.area}">
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>