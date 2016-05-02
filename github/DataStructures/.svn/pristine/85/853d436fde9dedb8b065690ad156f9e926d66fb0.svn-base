<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	/* 달력 출력 */
	$("#hr_hire_date").ready(function() { //입사일
		var id = "#hr_hire_date";
		setDate(id);
		
	});
	$("#hr_quit_date").ready(function() { //퇴사일
		var id = "#hr_quit_date";
		setDate(id);
		
	});
	$("#hr_career_date").ready(function() { //경력기준일
		var id = "#hr_career_date";
		setDate(id);
		
	});
	$("#hr_b4_upd").ready(function() { //이전단가 기준일
		var id = "#hr_b4_upd";
		setDate(id);
		
	});
	$("#hr_upd").ready(function() { //현재단가 기준일
		var id = "#hr_upd";
		setDate(id);
		
	});
	$("#hr_LMD").ready(function() { //최종 수정일
		var id = "#hr_LMD";
		setDate(id);
		
	});
	$("#hr_nextpj_date").ready(function() {
		var id = "#hr_nextpj_date";
		setDate(id);
		
	});
	
	
	//파일업로드시 미리보기
	function readURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$("#imagePreview").attr('src',e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	
$(document).ready(function() {
	//파일업로드 폼 보내기
	$("#humanResourceInsertBtn").click(function(){
		$("#humanResourceInsertForm").attr("action", "<c:url value="/humanResource/doInsertEmployeeInformation"/>");
		$("#humanResourceInsertForm").attr("method", "post");
		$("#humanResourceInsertForm").submit();
	});
});
	
</script>
<style>
	#samePersonCheckBtn {cursor: pointer; text-align: center;}
</style>
</head>
<body>

	<div>
	<form:form id="humanResourceInsertForm" name="humanResourceInsertForm" enctype="multipart/form-data">
		<table id="cssTable" style="width:850px;">
			<tr><th colspan="4" align="right"><span style="color:red;">*</span> : 필수 입력입니다.</th></tr>
			<tr align="right">
				<td rowspan=6 style="text-align:center;" >
					<img id="imagePreview" src="<c:out value="/resources/employee/emp_nophoto.jpg"/>" style="width: 15vh; height: 15vh; width: 15vm; height: 15vm; float:center; clear:both;"/>
				</td>
				<th>이름 <span style="color:red;">*</span></th>
				<td>
					<input type="text" name="hr_name" id="hr_name" style="width:100%;" />
					<input type="hidden" name="hr_company" id="hr_company" value="SQI소프트(주)" style="width:100%;" />
				</td>
				<th id="samePersonCheckBtn">중복 확인</th>
			</tr>
			<tr align="right">
				<th>소속팀 <span style="color:red;">*</span></th>
				<td colspan="2">
					<select name="tm_id" id="tm_id">
						<c:forEach var="rank" items="${teamOptions.keySet() }">
							<option value="${rank }" >${teamOptions.get(rank) }</option>
						</c:forEach>
					</select>
				</td>
				</tr>
				<tr align="right">
					<th>직급 <span style="color:red;">*</span></th>
					<td colspan="2">
						<select name="hr_position" id="hr_position">
							<c:forEach var="rank" items="${positonOptions.keySet() }">
								<option value="${rank }" >${positonOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>등급</th>
					<td colspan="2">
						<select name="hr_grade"> 
							<c:forEach var="rank" items="${gradeOptions.keySet() }">
								<option value="${rank }" >${gradeOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right"> 
					<th>이메일 <span style="color:red;">*</span></th>
					<td colspan="2">
						<input type="text" name="hr_email" id="hr_email" style="width:100%;" placeholder="id@sqisoft.com의 id만 입력해주세요."/>
					</td>
				</tr>
				<tr align="right">
					<th>핸드폰번호 <span style="color:red;">*</span></th>
					<td colspan="2">
						<input type="text" name="hr_mobile" id="hr_mobile"  placeholder="010-1234-5678" onchange="pnCheck(this)" style="width:100%;" />
					</td>
				</tr>
				<tr align="right">
					<th id="imagePreview">
						<input type="file" name="uploadFile" id="uploadFile" onchange ="readURL(this);" style="width:100%;"/>
					</th>
					<th>거주지</th>
					<td colspan="2">
						<input type="text" name="hr_residence" id="hr_residence" placeholder="서울은 '구', 그 외 지역은 '시'를 입력해주세요." style="width:100%;"/>
					</td>
				</tr>
				<tr align="right">
					<th>입사일 <span style="color:red;">*</span></th>
					<td>
						<input type="text" id="hr_hire_date" name="hr_hire_date" style="width:100%;"/>
					</td>
					<th>퇴사일</th>
					<td>
						<input type="text" id="hr_quit_date" name="hr_quit_date" style="width:100%;"/>
					</td>
				</tr>
				<tr align="right">
					<th>현재단가</th>
					<td>
					</td>
					<th>현재단가 기준일</th>
					<td>
						현재 날짜로 입력됩니다.
					</td>
				</tr>
				<tr align="right">
				</tr>
				<tr align="right">
					<th>최종수행Project</th>
					<td>
						<input type="text" id="hr_last_project" name="hr_last_project" style="width:100%;"/>
					</td>
					<th>차기PJ가능일</th>
					<td>
						<input type="text" id="hr_nextpj_date" name="hr_nextpj_date" style="width:100%;"/>
					</td>
				</tr>
				<tr align="right">
					<th>경력기준일</th>
					<td>
						<input type="text" id="hr_career_date" name="hr_career_date" style="width:100%;"/>
					</td>
					<th>IT경력</th>
					<td>
						<!-- 계산 -->
						<%-- <input type="text" id="hr_it_career" name="hr_it_career" placeholder="숫자를 입력해주세요." style="width:90%;"/> --%>
						00 년
					</td>
				</tr>
				<tr align="right">
					<th>기반분류</th>
					<td>
						<c:forEach var="hr_cwm_env_list_rank" items="${hrCwmEnvListOptions.keySet() }">
							<input type="checkbox" id="hr_cwm_env_list" name="hr_cwm_env_list" value="${hr_cwm_env_list_rank}">${hr_cwm_env_list_rank}
						</c:forEach>
					</td>
					<th>직무기술</th>
					<td>
						<select name="hr_job_skill">
								<option value="">선택</option>
							<c:forEach var="rank" items="${jobSkillOptions.keySet() }">
								<option value="${jobSkillOptions.get(rank) }">${jobSkillOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>최종출신교</th>
					<td>
						<input type="text" id="hr_last_school" name="hr_last_school" style="width:100%;"/>
					</td>
					<th>전공</th>
					<td>
						<input type="text" id="hr_major" name="hr_major" style="width:100%;"/>
					</td>
				</tr>
				<tr align="right">
					<th>OS</th>
					<td>
						<select name="hr_os"> 
							<c:forEach var="rank" items="${osOptions.keySet() }">
								<option value="${rank }" >${osOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
					<th>DB</th>
					<td>
						<select name="hr_DB"> 
							<c:forEach var="rank" items="${dbOptions.keySet() }">
								<option value="${rank }" >${dbOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>UI</th>
					<td>
						<select name="hr_ui"> 
							<c:forEach var="rank" items="${uiOptions.keySet() }">
								<option value="${rank }" >${uiOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
				
					<th>언어</th>
					<td>
						<select name="hr_lang">
							<c:forEach var="rank" items="${languageOptions.keySet() }">
								<option value="${rank }" >${languageOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>F/W</th>
					<td>
						<select name="hr_fw">
							<c:forEach var="rank" items="${frameWorkOptions.keySet() }">
								<option value="${rank }" >${frameWorkOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
					<th>M/W</th>
					<td>
						<select name="hr_mw"> 
							<c:forEach var="rank" items="${middleWareOptions.keySet() }">
								<option value="${rank }" >${middleWareOptions.get(rank) }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr align="right">
					<th>업무분류</th>
					<td><select name="hr_domain">
					<c:forEach var="rank" items="${domainOptions.keySet() }">
						<option value="${rank }" >${domainOptions.get(rank) }</option>
					</c:forEach>
				</select></td>
					<th>역할분류</th>
					<td><select name="hr_role"> 
					<c:forEach var="rank" items="${roleOptions.keySet() }">
						<option value="${rank }" >${roleOptions.get(rank) }</option>
					</c:forEach>
				</select></td>
				</tr>
				<tr align="right">
					<c:choose>
						<c:when test="${message=='pass'}">
							<th>로그인 권한</th>
							<td>
								<input type="radio" class="yns" name="yns" id="y" value="y"/>YES
								<input type="radio" class="yns" name="yns" id="n" value="n" checked="checked"/>NO
								<input type="radio" class="yns" name="yns" id="s" value="s"/>SYSTEM
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
		</form:form>
	</div>
	
	<c:choose>
		<c:when test="${message=='pass'}">
			<span id="humanResourceResetBtn">비우기</span>
			<span id="humanResourceDeleteBtn">삭제</span>
			<span id="humanResourceInsertBtn">저장</span>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	
</body>
</html>