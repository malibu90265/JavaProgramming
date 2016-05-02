<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<!-- 입력 값 검증을 위한 js 파일 include -->
<script type="text/javascript" src="<c:url value="/resources/js/vaildCheck.js"/>"></script>
<script type="text/javascript">

	// 소요인원수 집어넣을 것.
	var pjId = "${deployRequirements.pjId}";
	
	$(document).ready(function() {
		
		getDeployRequirementsConditionsModifyAjax(pjId);
		
		// 상태 수정 시
		$("#pjStatus").keyup(function(event){
			var code = event.keyCode;
			var pjStatus = $("#pjStatus").val();
			var data = chkNull(pjStatus);
			var chkHan = isHanAndEng(data);
			/*	
				8 : backspace ,  192: ` , 219 : [ , 221 :  ], 220 : \
				validCheck.js파일의 isHanAndEng함수 내의 정규표현식에 먹히지 않아서 따로 체크해 줌			
			*/
			if((chkHan == false && code!=8) | (code==192 | code==219 | code==220 | code==221)){
				alert("한글+영어 조합만 가능합니다.!");
				data = data.substring(0,data.length-1);
				$("#pjStatus").val(data);
				return;
			}
		});
		
		// 소요인원수 수정 시
		$("#requirePerson").keyup(function(event){
			
			var code = event.keyCode;
			var requirePerson = $("#requirePerson").val();
			var data = chkNull(requirePerson);
			var chkNum = isNumber(data);
			
			if(chkNum == false && code!=8){
				alert("숫자만 가능합니다!");
				data = data.substring(0,data.length-1);
				$("#requirePerson").val(data);
				return;
			} 
			getDeployRequirementsConditionsAjax(requirePerson);
		});
	});
	
</script>
</head>
<body>

	<div>
		<form:form commandName="deployRequirementsVO"
			id="deployRequirementsModifyForm" name="deployRequirementsModifyForm"
			method="post">
			<table>
				<tr>
					<th>프로젝트ID</th>
					<td>pj_1</td>
					<th>PM명</th>
					<td>홍길동B</td>
					<th>프로젝트기간</th>
					<td>2015.01.01 ~ 2015.12.31</td>
				</tr>
				<tr>
					<th>소요인원</th>
					<td>3</td>
					<th>배치인원</th>
					<td>1</td>
					<th>근무지</th>
					<td>서울시 마포구</td>
				</tr>
				<tr>
					<th colspan="2" rowspan="2">프로젝트 사용 기술</th>
					<td>Linux</td>
					<td>Tomcat</td>
					<td>DB</td>
				</tr>
				<tr>
					<td>UI</td>
					<td>Language</td>
					<td>Framework</td>
				</tr>

			</table>
			<div id="deployRequirementsConditions"></div>
		</form:form>
	</div>

	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine" style="text-align: right;">
				<span id="deployRequirementsModifyBtn" style="cursor: pointer;">저장</span>
				<span id="deployRequirementsDeleteBtn" style="cursor: pointer;">삭제</span>
				<span id="deployRequirementsResetBtn" style="cursor: pointer;">비우기</span>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>

</body>
</html>