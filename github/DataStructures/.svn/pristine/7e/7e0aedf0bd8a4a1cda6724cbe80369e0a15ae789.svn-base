<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(function() {
		setDeleteSpanTagDisabled("pjProgressDeleteBtn");
	});
</script>

</head>
<body>
	<div id="upLine">
				<span id="pjReportBtn">주간보고서</span> 
	</div>
	<form:form commandName="pjProgressVO" id="pjProgressInsertForm" name="pjProgressInsertForm" method="post">
		<table class="inputbordered">
			<tr>
				<th class="inputTh">년월주</th>
				<td><input type="text" id="pp_date" name="pp_date" readonly="readonly" style="width:100%" value="${pjProgress.pp_date }"></td>
				<th class="inputTh">프로젝트 ID</th>
				<td><input type="text" id="pj_id" name="pj_id" readonly="readonly" style="width:100%" value="${pjProgress.pj_id }"></td>
				<th class="inputTh">우선순위</th>
				<td style="text-align: right;" ><input type="text" id="pp_priority" name="pp_priority" onchange="num_range(this, 99)" onkeydown="num_only(this);" style="width:100%"></td>
			</tr>
			<tr>
				<th class="inputTh">인썰 프로젝트 명</th>
				<td colspan="5">${pjProgress.pj_name }</td>
			</tr>
			<tr>
				<th class="inputTh">전주 계획</th>
				<td colspan="5">${pjProgress.pp_done_plan }</td>
			</tr>
			<tr>
				<th class="inputTh">전주 활동</th>
				<td colspan="5"><textarea name="pp_done" id="pp_done" rows="7" 
							style="width: 100%; ">${pjProgress.pp_done }</textarea></td>
			</tr>
			<tr>
				<th class="inputTh">금주 예정</th>
				<td colspan="5"><textarea name="pp_plan" id="pp_plan" rows="7" 
							style="width: 100%; ">${pjProgress.pp_plan }</textarea></td>
			</tr>
			<tr>
				<th class="inputTh">이슈 / 정보</th>
				<td colspan="5"><textarea name="pp_issue" id="pp_issue" rows="7" 
							style="width: 100%; ">${pjProgress.pp_issue }</textarea></td>
			</tr>
		</table>
	</form:form>

	<c:choose>
		<c:when test="${message=='pass' }">
			<div id="bottomLine">
				<span id="pjProgressSaveBtn">저장</span>
				<span id="pjProgressDeleteBtn">삭제</span>
				<span id="pjProgressResetBtn">비우기</span>
			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
<script type="text/javascript">
var oEditors = [];
var oEditors2 = [];
var oEditors3 = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder:  "pp_done"   ,
 sSkinURI: "/resources/SE2/SmartEditor2Skin.html",
 fCreator: "createSEditor2"
});

nhn.husky.EZCreator.createInIFrame({
	 oAppRef: oEditors2,
	 elPlaceHolder:  "pp_plan"   ,
	 sSkinURI: "/resources/SE2/SmartEditor2Skin.html",
	 fCreator: "createSEditor2"
	});
	
nhn.husky.EZCreator.createInIFrame({
	 oAppRef: oEditors3,
	 elPlaceHolder:  "pp_issue"   ,
	 sSkinURI: "/resources/SE2/SmartEditor2Skin.html",
	 fCreator: "createSEditor2"
	});
</script>

</html>