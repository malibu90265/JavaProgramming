<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>PM평가 등록</title>
<style>
	#cssTable th {text-align:center;}
</style>
</head>
<body>

	<div>
	<form:form commandName="estimationVO" id="estimationModifyForm" name="estimationModifyForm" method="post">
		<table id="cssTable">
			<tr>
				<th>SQ</th>
				<th>프로젝트ID</th>
				<th>성명</th>
				<th>등급</th>
				<th colspan="2">투입기간</th>
				<th>직무기술</th>
				<th>기반분류</th>
				<th>개발성과</th>
				<th>인성평가</th>
				<th>평가 설명</th>
			</tr>
			<c:forEach var="pmsEstimation" items="${pmsEstimationList }" varStatus="i" >
					<tr>
						<td>
							${i.count}
							<input type="hidden" id="count" name="count" value="${count }" >
						</td>
						<td>${pmsEstimation.pj_id }
							<input type="hidden" id="pj_id${i.count}" name="pj_id${i.count}" value="${pmsEstimation.pj_id }" >
						</td>
						<td>${pmsEstimation.pd_name }
							<input type="hidden" id="pd_name${i.count}" name="pd_name${i.count}" value="${pmsEstimation.pd_name }" >
						</td>
						<td>${pmsEstimation.hr_grade }</td>
						<td>${pmsEstimation.pd_start_date }</td>
						<td>${pmsEstimation.pd_end_date }</td>
						<td>${pmsEstimation.hr_job_skill }</td>
						<td>${pmsEstimation.hr_cwm_env }</td>
						<td>
							<select name="pd_abc${i.count}"> 
								<c:forEach var="pd_abc_rank" items="${pdAbcOptions.keySet() }">
									<c:choose>
										<c:when test="${pd_abc_rank == pmsEstimation.pd_abc}">
											<option value="${pd_abc_rank}" selected="selected">${pdAbcOptions.get(pd_abc_rank)}</option>
										</c:when>
										<c:otherwise>
											<option value="${pd_abc_rank}" >${pdAbcOptions.get(pd_abc_rank)}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
						<td>
							<select name="pd_soft_abc${i.count}"> 
								<c:forEach var="pd_soft_abc_rank" items="${pdAbcOptions.keySet() }">
									<c:choose>
										<c:when test="${pd_soft_abc_rank == pmsEstimation.pd_soft_abc}">
											<option value="${pd_soft_abc_rank}" selected="selected">${pdAbcOptions.get(pd_soft_abc_rank)}</option>
										</c:when>
										<c:otherwise>
											<option value="${pd_soft_abc_rank}" >${pdAbcOptions.get(pd_soft_abc_rank)}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
						<td style="width: 40%;">
						<!-- TODO 텍스트 글자 제한 -->
							<textarea style="width: 100%;" onkeydown="pdAbcDescLength(this,560);" id="pd_abc_desc${i.count}" name="pd_abc_desc${i.count}" placeholder="평가 설명은 300자 내로 적어주세요.">${pmsEstimation.pd_abc_desc }</textarea>
						</td>
					</tr>
			</c:forEach>
		</table>
	</form:form>
	</div>
	<span id="estimationModifyBtn">저장</span>
</body>
</html>


