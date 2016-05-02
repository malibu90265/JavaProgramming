<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
	// 소요인원수 집어넣을 것.
	var requirePerson = "0";
	
	$(document).ready(function() {
		
		var pjId = $("#deployRequirementsForm").find("#pj_id").text();
		getDeployRequirementsConditionsAjax(0, pjId);
		
		$("#requirePerson").keyup(function(){
			
			/* var code = window.event.keyCode;
			var id=event.target.id;
			if((code >=48 && code <=57) || (code >=96 && code <=105) || code == 110 || code == 190 || code ==8 || code == 9 || code ==13 ||code ==46) {
				window.event.returnValue = true;
			
				
				return;
			}
			 */
			 
			var code = window.event.keyCode;
			 
			// alert(code);
			 
			var requirePerson = $("#requirePerson").val();
			
			var chkNum = isNumber(requirePerson);
			
			if(chkNum == false){
				alert("숫자만 가능합니다!");
				return;
			} 
			
			getDeployRequirementsConditionsAjax(requirePerson, pjId);
			
		});
	});
	
	function isNumber(s) {
		  s += ''; // 문자열로 변환
		  s = s.replace(/^\s*|\s*$/g, ''); // 좌우 공백 제거
		  if (s == '' || isNaN(s)) return false;
		  return true;
	}
</script>
</head>
<body>
	
	
	<div>
		<table>
			<tr>
				<th>프로젝트ID</th>
				<td id="pj_id">${budgetVO.pj_id}</td>
			</tr>
			<tr>
				<th>프로젝트 기간</th>
				<td>${budgetVO.pj_start_day} - ${budgetVO.pj_end_day}</td>
			</tr>
			<tr>
				<th>기반분류</th>
				<td>${budgetVO.pj_require}</td>
			</tr>
			<tr>
				<th>소요인원수</th>
				<td><input type="text" id="requirePerson" value=${budgetVO.pn_num}></td>
			</tr>
		</table>
	</div>
	
	<div id="deployRequirementsConditions">
		
	</div>
		
	<div style="text-align: right;">
		<span id="deployRequirementsSaveBtn" style="cursor: pointer;">저장</span>
		<span id="deployRequirementsCancelBtn" style="cursor: pointer;">취소</span>
		<span id="deployRequirementsBackBtn" style="cursor: pointer;">되돌리기</span> 
	</div>
	
</body>
</html>