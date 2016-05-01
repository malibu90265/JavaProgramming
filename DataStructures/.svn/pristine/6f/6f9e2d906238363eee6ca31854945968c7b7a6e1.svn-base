<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<!-- 프로젝트 인력 투입 -->
<script type="text/javascript" src="<c:url value="/resources/js/endDateCheck.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/employeeInput/employeeInput.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vaildCheck.js"/>"></script>
</head>
<script>

	$(document).ready(function() {
		$("#pd_sq").keyup(function(event) {
			var code = event.keyCode;

			var num = $("#pd_sq").val();
			if (!isNumber(num)) {
				if (num != "" || num != null) {	}
				$("#pd_sq").val(num.replace(/[^(0-9)]/gi, ""));
			}
		});
		
		$("#pr_sq").keyup(function(event) {
			var code = event.keyCode;

			var num = $("#pr_sq").val();
			if (!isNumber(num)) {
				if (num != "" || num != null) {	}
				$("#pr_sq").val(num.replace(/[^(0-9)]/gi, ""));
			}
		});

	});
</script>
<body>		
	<div>
		<table>
			<tr>
				<th colspan="13" style="text-align: center;">프로젝트 인력 투입</th>
			</tr>
			<tr>
				<th style="width:4%; text-align: center;">투입 번호</th>
				<th style="width:8%; text-align: center;">성명</th>
				<th style="width:4%; text-align: center;">소요번호</th>
				<th style="width:8%; text-align: center;">투입일</th>
				<th style="width:8%; text-align: center;">만료일</th>
				<th style="width:5%; text-align: center;">투입율</th>
				<td style="border-bottom:none"></td>
				<th style="width:8%; text-align: center;">단가</th>
				<th style="width:8%; text-align: center;">등급</th>
				<th style="width:8%; text-align: center;">기반분류</th>
				<th style="width:9%; text-align: center;">직무기술</th>
				<th style="width:8%; text-align: center;">외주평가</th>
				<th style="width:14%; text-align: center;">거주지</th>
			</tr>
			<tr>
				<!--투입번호-->
				<td id="pd_sq" style="text-align: center;"></td>
				<!--성명-->
				<td style="width:9%;"><input type="text" id="pd_name" style="width:100%; text-align: right;" onkeyup="getHr('')"/></td>
				<!--소요번호-->
				<td id = "pr_sq" style="width:9%; text-align: center;"></td>
				<!--투입일-->
				<td style="width:9%;"><input type="text" id="pd_start_date" style="width:100%; text-align: right;"  placeholder="ex) 0000-00-00" onfocus="setDate()" onchange="startDateCheck(this.id)"/></td>
				<!--만료일-->
				<td style="width:9%;"><input type="text" id="pd_end_date" style="width:100%; text-align: right;" placeholder="ex) 0000-00-00" onfocus="setDate()" onchange="endDateCheck(this.id)"/></td>
				<!-- 투입율 -->
				<td style="width:9%;"><input type="text" id="pd_ratio" value="100" style="width:100%; text-align: right;" readonly/></td>
				<td style="border-top:none;border-bottom:none"></td>
				<!--단가-->
				<td id="pd_uprice" style="width:9%; text-align: right;"></td>
				<!--등급-->
				<td id="hr_grade" style="width:9%; text-align: right;"></td>
				<!--기반분류-->
				<td id="hr_cwm_env" style="width:9%; text-align: right;"></td>
				<!--직무기술-->
				<td id="hr_job_skill" style="width:9%; text-align: right;"></td>
				<!--외주평가-->
				<td id="hr_abc" style="width:9%; text-align: right;"></td>
				<!--거주지-->
				<td id="hr_residence" style="width:9%; text-align: right;"></td>
			</tr>
			<c:choose>
				<c:when test="${message=='pass' }">
					<tr>
						<td colspan="5" style="border-right:none;"></td>
						<td colspan="7" style="border-left:none;">
							<span id="employeeInputInsertBtn" >저장</span>
							<span id="employeeInputDeleteBtn" >삭제</span>
							<span id="employeeInputResetBtn" >비우기</span>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	<!-- <div id="bottomLine" style="text-align: center;">
	</div> -->

</body>
</html>