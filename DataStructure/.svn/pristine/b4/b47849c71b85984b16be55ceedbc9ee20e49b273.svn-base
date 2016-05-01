<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	
</script>
</head>
<body>

	<div id="project_settinginsert">
		<form:form commandName="project_settingVO" id="project_settingModifyForm"
			name="project_settingModifyForm" enctype="multipart/form-data" method="post">
			<table class="inputbordered" style="width: 400px;">
				<tr>
					<td colspan ="4" style="background-color:white;">프로젝트 환경 정보</td>
				</tr>
				<tr>
					<th colspan = "2" style="width: 100px" >프로젝트ID</th>
<%-- 					<td colspan = "2" style="background-color:white; width: 100px"><input type="text" name="pj_id" id="pj_id" value ="${project_settingInfo.pj_id}" style="width: 100%; background-color: #EBEBE4;" readonly="readonly"></td> --%>
				    <td colspan = "2" style="background-color:white; width: 100px">${project_settingInfo.pj_id}
				    <input type="hidden" name="pj_id" id="pj_id" value ="${project_settingInfo.pj_id}"/></td>
					
				</tr>
				<tr>
					<th colspan = "2">PM명<span class="requiredAttr">*</span></th>
					<td colspan = "2"><input type="text" name="pj_pm" id="pj_pm" value ="${project_settingInfo.pj_pm}" placeholder="표준한글만 사용가능합니다." style="width: 100%"></td>
				</tr>
				<tr>
					<th colspan = "2">프로젝트 근무지<span class="requiredAttr">*</span></th>
					<td colspan = "2"><input type="text" name="pj_loc" id="pj_loc" value ="${project_settingInfo.pj_loc}" maxlength=3; placeholder="ex) 영등포구, 강동구 " style="width: 100%"></td>
				</tr>
				<tr>
					<th colspan = "2">기반 분류</th>
					<td colspan = "2">
					<c:forEach var="pj_cwm_env_list" items="${resultCwm.keySet() }">
							<c:choose>
								<c:when test="${resultCwm.get(pj_cwm_env_list) eq true}">
									&nbsp;<input type="checkbox" id="pj_cwm_env_list" name="pj_cwm_env_list" value="${pj_cwm_env_list}" checked="checked">${pj_cwm_env_list}
								</c:when>
								<c:otherwise>
									&nbsp;<input type="checkbox" id="pj_cwm_env_list" name="pj_cwm_env_list" value="${pj_cwm_env_list}">${pj_cwm_env_list}
								</c:otherwise>
							</c:choose>
							</c:forEach>
					</td>
				</tr>
				<tr>
					<th style="width: 70px">OS</th>
					<td style ="width: 130px"><select name="pj_os" id="pj_os" style="width: 100%;">
							<option>선택</option>
							<c:forEach var="OSList" items="${skill_envOSList}">
								<c:choose>
								<c:when test="${OSList.each_environment eq project_settingInfo.pj_os}">
									<option value = "${OSList.each_environment}" selected="selected">${OSList.each_environment}</option>
								</c:when>
								<c:otherwise>
									<option value = "${OSList.each_environment}">${OSList.each_environment}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<th style="width: 70px">DB</th>
					<td style="width: 130px"><select name="pj_DB" id="pj_DB" style="width: 100%;">
							<option>선택</option>		
							<c:forEach var="DBList" items="${skill_envDBList}">
								<c:choose>
								<c:when test="${DBList.each_environment eq project_settingInfo.pj_DB}">
								<option value = "${DBList.each_environment}" selected="selected" >${DBList.each_environment}</option>
								</c:when>
								<c:otherwise>
								<option value = "${DBList.each_environment}">${DBList.each_environment}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>	
				</tr>
				<tr>
					<th>UI</th>
					<td><select name="pj_ui" id="pj_ui" style="width:100%;"> 
								<option>선택</option>	
								<c:forEach var="UIList" items="${skill_envUIList}">
								<c:choose>
								<c:when test="${UIList.each_environment eq project_settingInfo.pj_ui}">
								<option value = "${UIList.each_environment}" selected="selected" >${UIList.each_environment}</option>
								</c:when>
								<c:otherwise>
								<option value = "${UIList.each_environment}">${UIList.each_environment}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<th>언어</th>
					<td><select name="pj_lang" id="pj_lang" style="width:100%;">	
							<option>선택</option>
							<c:forEach var="LangList" items="${skill_envLangList}">
							<c:choose>
								<c:when test="${LangList.each_environment eq project_settingInfo.pj_lang}">
								<option value = "${LangList.each_environment}" selected="selected" >${LangList.each_environment}</option>
								</c:when>
								<c:otherwise>
								<option value = "${LangList.each_environment}">${LangList.each_environment}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>			
				</tr>
				<tr>
					<th>F/W</th>
					<td><select name="pj_fw" id="pj_fw" style="width:100%;">
								<option>선택</option>
								<c:forEach var="FWList" items="${skill_envFWList}">
								<c:choose>
								<c:when test="${FWList.each_environment eq project_settingInfo.pj_fw}">
								<option value = "${FWList.each_environment}" selected="selected" >${FWList.each_environment}</option>
								</c:when>
								<c:otherwise>
								<option value = "${FWList.each_environment}">${FWList.each_environment}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<th>M/W</th>
					<td><select name="pj_mw" id="pj_mw" style="width:100%;">
								<option>선택</option>	
								<c:forEach var="MWList" items="${skill_envMWList}">
								<c:choose>
								<c:when test="${MWList.each_environment eq project_settingInfo.pj_mw}">
								<option value = "${MWList.each_environment}" selected="selected" >${MWList.each_environment}</option>
								</c:when>
								<c:otherwise>
								<option value = "${MWList.each_environment}">${MWList.each_environment}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
		</form:form>
	</div>

	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine">
				<span id="projectSaveBtn">저장</span> 
				<span id="projectModifyDeleteBtn" >삭제</span> 
				<span id="projectResetBtn">비우기</span>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>

</body>
</html>