<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>${teamName}주간보고서</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/project_css/progress-list-form.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/main_css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script  src="<c:url value="/resources/tablecols/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/tablecols/js/colResizable-1.5.min.js"/>"></script>
<link rel="stylesheet" href="/resources/css/project_css/print.css"
	type="text/css" media="print">
<script type="text/javascript">
$(function(){	

	var onSampleResized = function(e){
		alert("들어가줘요..");
		var columns = $(e.currentTarget).find("th");
		alert(columns);
		var msg = "columns widths: ";
		columns.each(function(){ msg += $(this).width() + "px; "; })
		$("#sample2Txt").html(msg);
		
	};	

	$(".bordered").colResizable({
		liveDrag:true, 
		gripInnerHtml:"<div class='grip'></div>", 
		draggingClass:"dragging", 
		onResize:onSampleResized});
	
});	
</script>
</head>
<body>
	<div>
		<input type="submit" id="print" value="print" onClick="window.print()" />
	</div>
	<div class="container">
		<section class="contents">
			<h1 class="contentsTitle">${teamName }주간보고서 (${pp_date }째 주)</h1>
			<div id="pjProgressByYMWListTable">
				<table class="bordered" id = "bordered" style="table-layout: fixed; word-break: break-all;">
					<tr>
						<th class="sq">순번</th>
						<th class="pj_id">프로젝트 ID</th>
						<th class="pp_done_plan">전주 계획</th>
						<th class="pp_done">전주 활동</th>
						<th class="pp_plan">금주 예정</th>
						<th class="pp_issue">이슈 / 정보</th>
					</tr>
					<c:if test="${pjProgressList.size() == 0 }">
						<tr>
							<td colspan="6" style="text-align: center;">작성된 주간 보고서가
								없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="pjProgress" items="${pjProgressList}"
						varStatus="status">
						<tr>
							<td class="sq" style="border-top: 1px solid #ccc;">${status.count }</td>
							<td class="pj_id" style="border-top: border-top: 1px solid #ccc;">${pjProgress.pj_id }</td>
							<td class="pp_done_plan" 
								style="overflow:hidden; border-top: border-top: 1px solid #ccc;">${pjProgress.pp_done_plan }</td>
							<td class="pp_done"
								style="overflow:hidden; border-top: border-top: 1px solid #ccc;">${pjProgress.pp_done }</td>
							<td class="pp_plan"
								style="overflow:hidden; border-top: border-top: 1px solid #ccc;">${pjProgress.pp_plan }</td>
							<td class="pp_issue"
								style="overflow:hidden; border-top: border-top: 1px solid #ccc;">${pjProgress.pp_issue }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
	</div>
</body>
</html>