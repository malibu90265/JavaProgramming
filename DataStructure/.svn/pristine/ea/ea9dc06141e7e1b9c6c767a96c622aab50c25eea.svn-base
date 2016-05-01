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

	function setDeleteSpanTagDisabled(){
		
		document.getElementById("deployRequirementsDeleteBtn").disabled = true;
	}
	
	$(document).ready(function() {
		
		setDeleteSpanTagDisabled();
		getDemoDeployRequirementsConditionsAjax(0);

		// 상태 입력 시
		$("#pjStatus").keyup(function(event){

			var code = event.keyCode;
			
			var pjStatus = $("#pjStatus").val();
			var data = chkNull(pjStatus);
			var chkHan = isHangle(data);
			
			if(chkHan == false && code!=8){
				alert("한글만 가능합니다!");
				data = data.substring(0,data.length-1);
				$("#pjStatus").val(data);
				return;
			}
		});
		
		// 프로젝트 id 입력 시
		$("#pjId").keyup(function(event){

			var code = event.keyCode;
			
			var pjId = $("#pjId").val();
			var data = chkNull(pjId);
			var chkHanEng = isNumAndEng(data);
			/* 			
				8 : backspace ,  192: ` , 219 : [ , 221 :  ], 220 : \
				validCheck.js파일의 isNumAndEng함수 내의 정규표현식에 먹히지 않아서 따로 체크해 줌			
			*/
 			if((chkHanEng == false && code!= 8) | (code==192 | code==219 | code==220 | code==221)){
				alert("영어+숫자 조합만 가능합니다!");
				data = data.substring(0,data.length-1);
				$("#pjId").val(data);
				return;
			}  
		});
		
		// 소요인원수 입력 시
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
			
			getDemoDeployRequirementsConditionsAjax(requirePerson);
		});
	});

	
</script>
</head>
<body>

	<div>
		<form:form commandName="deployRequirementsVO"
			id="deployRequirementsInsertForm" name="deployRequirementsInsertForm"
			method="post">
			<table>
				<tr>
					<th>프로젝트ID</th>
					<td>pj_1</td>
					<th>소요인원</th>
					<td><input type="text" name="pjDeployRequirements" id="requirePerson" style="width:100%;"></td>
					<th>프로젝트기간</th>
					<td colspan=2>2015.01.01 ~ 2015.12.31</td>
				</tr>
				<tr>
					<th>PM명</th>
					<td>3</td>
					<th>배치인원</th>
					<td>1</td>
					<th>근무지</th>
					<td>서울시 마포구</td>
					<td>CWM</td>
				</tr>
				<tr>
					<th>개발 환경</th>
					<td>Linux</td>
					<td>Tomcat</td>
					<td>MySQL</td>
					<td>HTML</td>
					<td>Java</td>
					<td>spring</td>
				</tr>

			</table>

			<div id="deployRequirementsConditions"></div>
		</form:form>
	</div>

	<div id="bottomLine" style="text-align: right;">
		<span id="deployRequirementsInsertBtn" style="cursor: pointer;">저장</span> 
		<span id="deployRequirementsDeleteBtn" style="cursor: pointer;" >삭제</span> 
		<span id="deployRequirementsResetBtn" style="cursor: pointer;">비우기</span> 
	</div>
	
</body>
</html>





<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<!-- 입력 값 검증을 위한 js 파일 include -->
<script type="text/javascript" src="<c:url value="/resources/js/vaildCheck.js"/>"></script>
<script type="text/javascript">

	function setDeleteSpanTagDisabled(){
		
		document.getElementById("deployRequirementsDeleteBtn").disabled = true;
	}
	
	$(document).ready(function() {
		
		setDeleteSpanTagDisabled();
		getDemoDeployRequirementsConditionsAjax(0);

		// 상태 입력 시
		$("#pjStatus").keyup(function(event){

			var code = event.keyCode;
			
			var pjStatus = $("#pjStatus").val();
			var data = chkNull(pjStatus);
			var chkHan = isHangle(data);
			
			if(chkHan == false && code!=8){
				alert("한글만 가능합니다!");
				data = data.substring(0,data.length-1);
				$("#pjStatus").val(data);
				return;
			}
		});
		
		// 프로젝트 id 입력 시
		$("#pjId").keyup(function(event){

			var code = event.keyCode;
			
			var pjId = $("#pjId").val();
			var data = chkNull(pjId);
			var chkHanEng = isNumAndEng(data);
			/* 			
				8 : backspace ,  192: ` , 219 : [ , 221 :  ], 220 : \
				validCheck.js파일의 isNumAndEng함수 내의 정규표현식에 먹히지 않아서 따로 체크해 줌			
			*/
 			if((chkHanEng == false && code!= 8) | (code==192 | code==219 | code==220 | code==221)){
				alert("영어+숫자 조합만 가능합니다!");
				data = data.substring(0,data.length-1);
				$("#pjId").val(data);
				return;
			}  
		});
		
		// 소요인원수 입력 시
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
			
			getDemoDeployRequirementsConditionsAjax(requirePerson);
		});
	});

	
</script>
</head>
<body>
	
	<div>
		<form:form commandName="deployRequirementsVO" id="deployRequirementsInsertForm" name="deployRequirementsInsertForm" method="post">
		<table>
			<tr>
				<th>상태</th>
				<td>
					<input type="text" name="pjStatus" id="pjStatus" placeholder="한글 입력">
				</td>
			</tr>
			<tr>
				<th>프로젝트ID</th>
				<td>
					<input type="text" name="pjId" id="pjId" placeholder="영어+숫자 조합 입력">
				</td>
			</tr>
			<tr>
				<th>프로젝트기간</th>
				<td>
					프로젝트기간
				</td>
			</tr>
			<tr>
				<th>기반분류</th>
				<td>
					기반분류
				</td>
			</tr>
			<tr>
				<th>소요인원수</th>
				<td>
					<input type="text" name="pjDeployRequirements" id="requirePerson" placeholder="숫자 입력">
				</td>
			</tr>
			<tr>
				<th>배치인원수</th>
				<td>
					배치인원수
				</td>
			</tr>
			<tr>
				<th>투입인원수</th>
				<td>
					투입인원수
				</td>
			</tr>
		</table>
		<div id="deployRequirementsConditions">
		
		</div>
		</form:form>
	</div>
	
	<div id="bottomLine" style="text-align: right;">
		<span id="deployRequirementsInsertBtn" style="cursor: pointer;">저장</span> 
		<span id="deployRequirementsDeleteBtn" style="cursor: pointer;" >삭제</span> 
		<span id="deployRequirementsResetBtn" style="cursor: pointer;">비우기</span> 
	</div>
	
</body>
</html> --%>