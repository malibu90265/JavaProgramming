<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>


<script type="text/javascript">

	function setDeleteSpanTagDisabled(){
		document.getElementById("deployRequirementsDeleteBtn").disabled = true;
	}
	
	$(document).ready(function() {
		setDeleteSpanTagDisabled();
		//getDeployRequirementsConditionsAjax(0);
		
		$("#requirePerson").keyup(function(event){
			var code = event.keyCode;
			var num = $("#requirePerson").val();
			var pj_id = $("#pj_detail_id").text();
			var chckNum;
			$.ajax({
				type : "POST",
				url : "/deployRequirements/checkNumAjax",
				data : {
					pj_id	: pj_id,
				},
				success : function(data) {
					chckNum = data;
						if(num == "" || num == null) {
							num = 0;
							getInsertPageAjax(num, pj_id);
							return;
						}
						if(num < chckNum) {
							if(!confirm("이미 입력되어있는 소요인원보다 적은 인원을 소요하시겠습니까??")) {
								$("#requirePerson").val(chckNum);
								getInsertPageAjax(chckNum, pj_id);
							}
						}
					
				},
				error : function(xhr) {
					alert("checkNumAjax = " + xhr.statusText);
				}
			});
			
			if(isNumber(num)) {
				getInsertPageAjax(num, pj_id);
			} else {
				if(num != "" || num != null) {}
				$("#requirePerson").val(num.replace(/[^(0-9)]/gi,""));
			}
			
		});
		
	});
	
</script>
<style type="text/css">
	/* th {width:15%;}  */
</style>
</head>
<body>

	<div>
		<table id="deployRequirementsDetailForm" >
			<tr>
				<th>프로젝트ID</th>
				<td id="pj_detail_id">${deployRequirementsDetailFormList.pj_id}</td>
				<th>소요인원</th>
				<td><input type="text" name="pjDeployRequirements" id="requirePerson" ></td>
				<th>프로젝트기간</th>
				<td id="pj_end_date" colspan=2>${deployRequirementsDetailFormList.pj_start_date } ~ ${deployRequirementsDetailFormList.pj_end_date }</td>
			</tr>
			<tr>
				<th>PM명</th>
				<td>${deployRequirementsDetailFormList.pj_pm}</td>
				<th>배치인원</th>
				<td>${deployRequirementsDetailFormList.pr_place}</td><!--★★★★★★★★★★배치인원 구하는법  -->
				<th>근무지</th>
				<td> ${deployRequirementsDetailFormList.pj_loc}</td>
				<td>${deployRequirementsDetailFormList.pj_cwm_env}</td>
			</tr>
			<tr>
				<th>개발 환경</th>
				<td>${deployRequirementsDetailFormList.pj_os}</td>
				<td>${deployRequirementsDetailFormList.pj_DB}</td>
				<td>${deployRequirementsDetailFormList.pj_ui}</td>
				<td>${deployRequirementsDetailFormList.pj_lang}</td>
				<td>${deployRequirementsDetailFormList.pj_fw}</td>
				<td>${deployRequirementsDetailFormList.pj_mw}</td>
			</tr>
		</table>
		<div id="deployRequirementsConditions"></div>
	</div>

	<div id="requireInsertForm"></div>

	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine" style="text-align: right;">
				<span id="deployRequirementsInsertBtn" style="cursor: pointer;">저장</span> 
				<span id="deployRequirementsDeleteBtn" style="cursor: pointer;" onclick="deletePjRequire('${deployRequirementsDetailFormList.pj_id}')">삭제</span> 
				<span id="deployRequirementsResetBtn" style="cursor: pointer;">비우기</span> 
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>
