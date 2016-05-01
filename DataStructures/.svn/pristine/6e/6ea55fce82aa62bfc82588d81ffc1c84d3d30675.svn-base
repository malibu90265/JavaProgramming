<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	
	/* 달력 출력 : value가 있어서 class로 받음 */
	$(".hr_hire_date").ready(function() { //입사일
		var id = ".hr_hire_date";
		setDate(id);

	});
	$(".hr_quit_date").ready(function() { //퇴사일
		var id = ".hr_quit_date";
		setDate(id);
		
	});
	$(".hr_career_date").ready(function() { //경력기준일
		var id = ".hr_career_date";
		setDate(id);
		
	});
	$(".hr_b4_upd").ready(function() { //이전단가 기준일
		var id = ".hr_b4_upd";
		setDate(id);
		
	});
	$(".hr_upd").ready(function() { //현재단가 기준일
		var id = ".hr_upd";
		setDate(id);
		
	});
	$(".hr_LMD").ready(function() { //최종 수정일
		var id = ".hr_LMD";
		setDate(id);
		
	});
	$(".hr_nextpj_date").ready(function() { // 차기 프로젝트
		var id = ".hr_nextpj_date";
		setDate(id);
		
	});
	
	//파일업로드시 미리보기 >>> this is not working
	function readURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			console.log(reader);
			reader.onload = function(e){
				$(".imagePreview").attr('src',e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
	
$(document).ready(function() {
	//파일업로드 폼 보내기
	$("#humanResourceModifyBtn").click(function(){
		$("#humanResourceModifyForm").attr("action", "<c:url value="/humanResource/doUpdateEmployeeInformation"/>");
		$("#humanResourceModifyForm").attr("method", "post");
		$("#humanResourceModifyForm").submit();
	});
});	
	
</script>
<style>
	#cssTable th {text-align:right;}
</style>
</head>
<body>

	<div>
		<form:form  id="humanResourceModifyForm" name="humanResourceModifyForm" enctype="multipart/form-data">
			<table id="cssTable" style="width:850px;">
				<tr><th colspan="4"><span style="color:red;">*</span> : 필수 입력입니다.</th></tr>
				<tr align="right">
					<td rowspan=6 style="text-align:center;">
						<c:choose>
							<c:when test="${humanResourceVO.hr_img == null}">
								<img class="imagePreview" name="uploadFile" src="<c:out value="/resources/employee/imguploadproblem.png"/>" 
									style="width: 15vh; height: 15vh; width: 15vm; height: 15vm; float:center; clear:right;"/>
							</c:when>
							<c:otherwise>
								<img class="imagePreview" name="uploadFile" src="<c:out value="/humanResource/download/${humanResourceVO.hr_name}"/>" 
								style="width: 15vh; height: 15vh; width: 15vm; height: 15vm; float:center; clear:right;"/>
							</c:otherwise>
						</c:choose>
					</td>
					<th>이름 <span style="color:red;">*</span></th>
					<td id="modifyNameTD" colspan="2">
						<input type="text" name="hr_name" id="hr_name" style="width:100%;" value="${humanResourceVO.hr_name}">
						<input type="hidden" name="hr_company" id="hr_company" style="width:100%;" value="SQI소프트(주)">
					</td>
				</tr>
				<tr align="right">
					<th>소속팀<span style="color:red;">*</span></th>
					<td colspan=2>
						<select name="tm_id"> 
							<c:forEach var="tm_id_rank" items="${teamOptions.keySet()}" >
								<c:choose>
									<c:when test="${tm_id_rank == humanResourceVO.tm_id}">
										<option value="${tm_id_rank}" selected="selected">${teamOptions.get(tm_id_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${tm_id_rank}" >${teamOptions.get(tm_id_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>직급<span style="color:red;">*</span></th>
					<td colspan=2>
						<select name="hr_position">
							<c:forEach var="hr_position_rank" items="${positonOptions.keySet()}">
								<c:choose>
									<c:when test="${hr_position_rank == humanResourceVO.hr_position}">
										<option value="${hr_position_rank}" selected="selected">${positonOptions.get(hr_position_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_position_rank}" >${positonOptions.get(hr_position_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>등급</th>
					<td  colspan="2">
						<select name="hr_grade"> 
							<c:forEach var="hr_grade_rank" items="${gradeOptions.keySet()}">
								<c:choose>
									<c:when test="${hr_grade_rank == humanResourceVO.hr_grade}">
										<option value="${hr_grade_rank}" selected="selected">${gradeOptions.get(hr_grade_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_grade_rank}" >${gradeOptions.get(hr_grade_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>이메일 <span style="color:red;">*</span></th>
					<td colspan="2"><input type="text" name="hr_email" id="hr_email" value="${humanResourceVO.hr_email }" style="width:100%;"></td>
				</tr>
				<tr align="right">
					<th>핸드폰번호 <span style="color:red;">*</span></th>
					<td colspan="2"><input type="text" name="hr_mobile" id="hr_mobile"  style="width:100%;" value="${humanResourceVO.hr_mobile }"></td>
				</tr>
				<tr align="right">
					<!-- 파일 라인 -->
					<th>
						<input type="file" name="uploadFile" id="uploadFile" onchange ="readURL(this);" style="width:100%;"/>
					</th>
					<th>거주지</th>
					<td colspan="2">
						<input type="text" name="hr_residence" id="hr_residence" placeholder="서울은 '구', 그 외 지역은 '시'를 입력해주세요." style="width:100%;" value="${humanResourceVO.hr_residence }" />
					</td>
				</tr>
				<tr align="right">
					<th>입사일 <span style="color:red;">*</span></th>
					<td>
					<input type="text" name="hr_hire_date" class="hr_hire_date" value="${humanResourceVO.hr_hire_date }" style="width:100%;"/>
					</td>
					<th>퇴사일</th>
					<td><input type="text" name="hr_quit_date" class="hr_quit_date" value="${humanResourceVO.hr_quit_date }" style="width:100%;"/></td>
				</tr>
				<c:choose>
					<c:when test="${humanResourceVO.hr_quit_date != null}">
						<tr>
							<th>소속회사</th>
							<td colspan="3">
								<input id="hr_company" name="hr_company" value="${humanResourceVO.hr_company }" style="width:100%;">
							</td>
						</tr>
					</c:when>
					<c:otherwise>
					
					</c:otherwise>
				</c:choose>
				<tr align="right">
					<th>현재단가</th>
					<td>
						<input id="hr_company" name="hr_company" value="${humanResourceVO.hr_uprice }" style="width:100%;" readonly="readonly">
					</td>
					<th>현재단가 기준일</th>
					<td>
						${humanResourceVO.hr_upd }
					</td>
				</tr>
				<tr align="right">
					<th>최종수행Project</th>
					<td>
						${humanResourceVO.hr_last_project }
						<%-- ${defaultRanks.get(rank)} --%>
					</td>
					<th>차기PJ가능일</th>
					<td>
						<input type="text" name="hr_nextpj_date" class="hr_nextpj_date" value="${humanResourceVO.hr_nextpj_date }" style="width:100%;"/>
					</td>
				</tr>
				<tr align="right">
					<th>경력기준일</th>
					<td>
						<input type="text" name="hr_career_date" class="hr_career_date" value="${humanResourceVO.hr_career_date }" style="width:100%;"/>
					</td>
					<th>IT경력</th>
					<td id="hr_it_career">
						${humanResourceVO.hr_it_career } 년
					</td>
				</tr>
				<tr align="right">
					<th>기반분류</th>
					<td>
						<c:forEach var="hr_cwm_env_list_rank" items="${resultCwm.keySet() }">
							<c:choose>
								<c:when test="${resultCwm.get(hr_cwm_env_list_rank) eq true}">
									<input type="checkbox" name="hr_cwm_env_list" value="${hr_cwm_env_list_rank}" checked="checked">${hr_cwm_env_list_rank}
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="hr_cwm_env_list" value="${hr_cwm_env_list_rank}">${hr_cwm_env_list_rank}
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</td>
					<th>직무기술</th>
					<td>
						<select name="hr_job_skill">
							<option value="">선택</option>
							<c:forEach var="hr_job_skill_rank" items="${jobSkillOptions.keySet() }">
								<c:choose>
									<c:when test="${jobSkillOptions.get(hr_job_skill_rank) == humanResourceVO.hr_job_skill}">
										<option value="${jobSkillOptions.get(hr_job_skill_rank)}" selected="selected">${jobSkillOptions.get(hr_job_skill_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${jobSkillOptions.get(hr_job_skill_rank)}" >${jobSkillOptions.get(hr_job_skill_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>최종출신교</th>
					<td>
						<input type="text" id="hr_last_school" name="hr_last_school" style="width:100%;" value="${humanResourceVO.hr_last_school }"/>
					</td>
					<th>전공</th>
					<td>
						<input type="text" id="hr_major" name="hr_major" style="width:100%;" value="${humanResourceVO.hr_major }"/>
					</td>
				</tr>
				<tr align="right">
					<th>OS</th>
					<td>
						<select name="hr_os"> 
							<c:forEach var="hr_os_rank" items="${osOptions.keySet() }">
								<c:choose>
									<c:when test="${hr_os_rank == humanResourceVO.hr_os}">
										<option value="${hr_os_rank}" selected="selected">${osOptions.get(hr_os_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_os_rank}" >${osOptions.get(hr_os_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<th>DB</th>
					<td>
						<select name="hr_DB"> 
							<c:forEach var="hr_DB_rank" items="${dbOptions.keySet() }">
								<c:choose>
									<c:when test="${hr_DB_rank == humanResourceVO.hr_DB}">
										<option value="${hr_DB_rank}" selected="selected">${dbOptions.get(hr_DB_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_DB_rank}" >${dbOptions.get(hr_DB_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>UI</th>
					<td>
						<select name="hr_ui"> 
							<c:forEach var="hr_ui_rank" items="${uiOptions.keySet() }">
								<c:choose>
									<c:when test="${hr_ui_rank == humanResourceVO.hr_ui}">
										<option value="${hr_ui_rank}" selected="selected">${uiOptions.get(hr_ui_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_ui_rank}" >${uiOptions.get(hr_ui_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<th>언어</th>
					<td>
						<select name="hr_lang">
							<c:forEach var="hr_lang_rank" items="${languageOptions.keySet() }">
								<c:choose>
									<c:when test="${hr_lang_rank == humanResourceVO.hr_lang}">
										<option value="${hr_lang_rank}" selected="selected">${languageOptions.get(hr_lang_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_lang_rank}" >${languageOptions.get(hr_lang_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>F/W</th>
					<td>
						<select name="hr_fw">
							<c:forEach var="hr_fw_rank" items="${frameWorkOptions.keySet() }">
								<c:choose>
									<c:when test="${hr_fw_rank == humanResourceVO.hr_fw}">
										<option value="${hr_fw_rank}" selected="selected">${frameWorkOptions.get(hr_fw_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_fw_rank}" >${frameWorkOptions.get(hr_fw_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<th>M/W</th>
					<td>
						<select name="hr_mw"> 
							<c:forEach var="hr_mw_rank" items="${middleWareOptions.keySet() }">
								<c:choose>
									<c:when test="${hr_mw_rank == humanResourceVO.hr_mw}">
										<option value="${hr_mw_rank}" selected="selected">${middleWareOptions.get(hr_mw_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_mw_rank}" >${middleWareOptions.get(hr_mw_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>업무분류</th>
					<td>
						<select name="hr_domain">
							<c:forEach var="hr_domain_rank" items="${domainOptions.keySet() }">
								<c:choose>
									<c:when test="${hr_domain_rank == humanResourceVO.hr_domain}">
										<option value="${hr_domain_rank}" selected="selected">${domainOptions.get(hr_domain_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_domain_rank}" >${domainOptions.get(hr_domain_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<th>역할분류</th>
					<td>
						<select name="hr_role"> 
							<c:forEach var="hr_role_rank" items="${roleOptions.keySet() }">
								<c:choose>
									<c:when test="${hr_role_rank == humanResourceVO.hr_role}">
										<option value="${hr_role_rank}" selected="selected">${roleOptions.get(hr_role_rank)}</option>
									</c:when>
									<c:otherwise>
										<option value="${hr_role_rank}" >${roleOptions.get(hr_role_rank)}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<c:choose>
						<c:when test="${message=='pass'}">
							<th>로그인 권한</th>
							<td>
								<input type="radio" name="yns" id="y" value="y"/>YES
								<input type="radio" name="yns" id="n" value="n" checked="checked"/>NO
								<input type="radio" name="yns" id="s" value="s"/>SYSTEM
							</td>
							<th>최종수정일</th>
							<td></td>
						</c:when>
						<c:otherwise>
							<th>최종수정일</th>
							<td colspan="3"></td>
						</c:otherwise>
					</c:choose>	
				</tr>
			</table>
			<!-- <div id="humanResourceConditions"></div> -->
		</form:form>
	</div>
	
	<c:choose>
		<c:when test="${message=='pass'}">
			<span id="humanResourceResetBtn">비우기</span>
			<span id="humanResourceDeleteBtn">삭제</span>
			<span id="humanResourceModifyBtn">수정</span>
			<span id="humanResourceProjectHistoryBtn">PJ수행이력</span>
		</c:when>
		<c:otherwise>
			<span id="humanResourceProjectHistoryBtn">PJ수행이력</span>
		</c:otherwise>
	</c:choose>

</body>
</html>