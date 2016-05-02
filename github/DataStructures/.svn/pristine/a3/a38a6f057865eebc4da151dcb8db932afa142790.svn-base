<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/js/deployRequirements/deployRequirements.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/endDateCheck.js"/>"></script>
<style type="text/css">
	#insertDivDeployRequired {overflow-y:scroll; width:100%; max-height:55vh;max-height:55vm;}
	th {text-align:center;}
	select {width:100%;}
</style>
</head>
<body>
<div id="insertDivDeployRequired">
	<table>
		<tr>
			<th style="width:3%; text-align:center;">소요 번호</th>
			<th style="width:5%; text-align:center;">등급</th>
			<th style="width:6%; text-align:center;">직무기술</th>
			<th style="width:8%; text-align:center;">배치일</th>
			<th style="width:8%; text-align:center;">종료일</th>
			<th style="width:3%; text-align:center;">개월 수</th>
			<th style="width:5%; text-align:center;">배치 단가</th>
			<th style="width:5%; text-align:center;">배치예정자</th>
			<th style="width:3%; text-align:center;">등급</th>
			<th style="width:3%; text-align:center;">인력 단가</th>
			<th style="width:5%; text-align:center;">거주지</th>
		</tr>
		<c:forEach var="insertedRequired" items="${insertedRequired }" varStatus="i">
		<c:if test="${i.count <= num}">
			<tr>
				<td id="pr_sq${i.count}" style="text-align:center;">
					<c:out value="${insertedRequired.pr_sq}"></c:out> <!--소요번호-->
				</td>
				<td>
					<select name="ranks${i.count}" id="ranks${i.count}"> <!--등급 -->
						<c:forEach var="rank" items="${rankOptions}">
							<option value="${rank }" <c:if test="${rank eq insertedRequired.pr_grade }">selected='selected'</c:if>>
							${rank }</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="skills" id="skill${i.count}" > <!--직무기술 -->
						<option value="">선택</option>
						<c:forEach var="skill" items="${jobSkillOptions.keySet()}">
							<option value="${jobSkillOptions.get(skill)}" <c:if test="${jobSkillOptions.get(skill) eq insertedRequired.pr_job_skill }">selected='selected'</c:if>>
							${jobSkillOptions.get(skill)}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type="text" id="pr_start_date${i.count}" style="width:100%; text-align:right;"value="${insertedRequired.pr_start_date }"
						 onfocus="setMonth(${i.count})" onchange="setMonth(${i.count}); startDateCheck(this.id);"/>
				</td>
				<td>
					<input type="text" id="pr_end_date${i.count}" style="width:100%; text-align:right;" value="${insertedRequired.pr_end_date }"
						  onfocus="setMonth(${i.count})" onchange="setMonth(${i.count}); endDateCheck(this.id);"/>
				</td>
				<td id="months${i.count}" style="text-align:center;" value="0">0</td>
				<td><!--배치단가-->
					<input type="text" id="pr_uprice${i.count}" style="width:100%; text-align:right;" value="${insertedRequired.pr_uprice }" onkeyup="pr_upriceIsNum(${i.count })"/>
				</td>
				<td><!--배치예정자  -->
					<input type="text" id="pr_name${i.count}"  style="width:100%; text-align:right;" value="${insertedRequired.pr_name }" onkeyup="getHr(${i.count})"/>
				</td>
				<td id="hr_grade${i.count}" style="text-align:center;"><!--배치 예정자 이름 입력시 해당 직원의 등급과 단가, 거주지가 자동으로 입력됨 -->
				</td>
				<td id="hr_uprice${i.count}" style="text-align:right;">
				</td>
				<td id="hr_residence${i.count}" style="text-align:center;">
				</td>
			</tr>
		</c:if>
		</c:forEach>
		
		<c:forEach var="i" begin="${count + 1 }" end="${num}">
			<tr>
				<td id="pr_sq${i}" style="text-align:center; ">
					<c:out value="${i}"></c:out> <!--소요번호-->
				</td>
				<td>
					<select name="ranks${i}" id="ranks${i}"> <!--등급 -->
						<c:forEach var="rank" items="${rankOptions}">
							<option value="${rank }" >${rank }</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="skills" id="skill${i}" > <!--직무기술 -->
					<option value="">선택</option>
						<c:forEach var="skill" items="${jobSkillOptions.keySet()}">
							<option value="${jobSkillOptions.get(skill)}" >${jobSkillOptions.get(skill)}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type="text" id="pr_start_date${i}" style="width:100%; text-align:right;" value="${pj_start_date }"
						  onfocus="setMonth(${i})" onchange="setMonth(${i}); startDateCheck(this.id);"/>
				</td>
				<td>
					<input type="text" id="pr_end_date${i}" style="width:100%; text-align:right;" value="${pj_end_date }"
						 onfocus="setMonth(${i})" onchange="setMonth(${i}); endDateCheck(this.id);"/>
				</td>
				<td id="months${i}" style="text-align:center;">0</td>
				<td style="width:100px;"><!--배치단가-->
					<input type="text" id="pr_uprice${i}" style="width:100%; text-align:right;" onkeyup="pr_upriceIsNum(${i})"/>
				</td>
				<td style="width:100px;"><!--배치예정자  -->
					<input type="text" id="pr_name${i}" style="width:100%; text-align:right;" onkeyup="getHr(${i})"/>
				</td>
				<td id="hr_grade${i}" style="text-align:center;"><!--배치 예정자 이름 입력시 해당 직원의 등급과 단가, 거주지가 자동으로 입력됨 -->
				</td>
				<td id="hr_uprice${i}" style="text-align:right;">
				</td>
				<td id="hr_residence${i}" style="text-align:center;">
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>