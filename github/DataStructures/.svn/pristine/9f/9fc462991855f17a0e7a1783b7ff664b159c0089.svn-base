<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	$(document).ready(function(){
		$("#project_insertSaveBtn").attr("disabled",true);
	})
	
</script>
</head>
<body>
	<div id="project_settinginsert">
		<form:form commandName="project_settingVO" id="project_settingInsertForm"
			name="project_settingInsertForm" method="post">
			<table class="inputbordered" style="width: 400px;">
				<tr>
					<td colspan ="4" style="background-color:white;">프로젝트 환경 정보</td>
				</tr>
				<tr>
					<th colspan = "2" style="width: 100px">프로젝트ID</th>
					<td colspan = "2" style="background-color:white; width: 100px">${project_settingInfo.pj_id}</td>
				</tr>
				<tr>
					<th colspan = "2" style="width: 100px">PM명<span class="requiredAttr">*</span></th>
					<td colspan = "2" style="background-color:white;"><input type="text" name="pj_pm" id="pj_pm" disabled="disabled" style="width: 100%"></td>
				</tr>
				<tr>
					<th colspan = "2">프로젝트 장소<span class="requiredAttr">*</span></th>
					<td colspan = "2" style="background-color:white;"><input type="text" name="pj_loc" id="pj_loc" disabled="disabled" style="width: 100%"></td>
				</tr>
				<tr>
					<th colspan = "2">기반 분류</th>
					<td colspan = "2" style="background-color:white;">&nbsp;<input type="checkbox" name="pj_cwm_env" value="C" disabled="disabled">C
									  &nbsp;<input type="checkbox" name="pj_cwm_env" value="W" disabled="disabled">W
						              &nbsp;<input type="checkbox" name="pj_cwm_env" value="M" disabled="disabled">M&nbsp;
						              <input type="checkbox" name="pj_cwm_env" value="O" disabled="disabled">O
					</td>
				</tr>
				<tr>
					<th style="width: 70px">OS</th>
					<td style="background-color:white; width: 130px" ><select name="pj_os" id="pj_os" disabled="disabled" style="background-color:#EBEBE4; width : 100%;">
								<option></option>
						</select>
					</td>
					<th style="width: 70px">DB</th>
					<td style="background-color:white; width: 130px"><select name="pj_DB" id="pj_DB" disabled="disabled" style="background-color:#EBEBE4; width : 100%;" >		
								<option></option>
						</select>
					</td>	
				</tr>
				<tr>
					<th style="width: 70px">UI</th>
					<td style="background-color:white; width: 130px"><select name="pj_ui" id="pj_ui" disabled="disabled" style="background-color:#EBEBE4; width : 100%;">
								<option></option>
						</select>
					</td>
					<th style="width: 70px">언어</th>
					<td style="background-color:white; width: 130px"><select name="pj_lang" id="pj_lang" disabled="disabled" style="background-color:#EBEBE4; width : 100%;">	
							<option></option>
						</select>
					</td>			
				</tr>
				<tr>
					<th style="width: 70px">F/W</th>
					<td style="background-color:white; width: 130px"><select name="pj_fw" id="pj_fw" disabled="disabled" style="background-color:#EBEBE4; width : 100%;">
							<option></option>
						</select>
					</td>
					<th style="width: 70px">M/W</th>
					<td style="background-color:white; width: 130px"><select name="pj_mw" id="pj_mw" disabled="disabled" style="background-color:#EBEBE4; width : 100%;">	
								<option></option>
						</select>
					</td>
				</tr>
			</table>
		</form:form>
	</div>

	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine">
				<span id="project_insertSaveBtn">저장</span> 
				<span id="project_insertDeleteBtn">삭제</span> 
				<span id="project_insertResetBtn">비우기</span>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
</html>