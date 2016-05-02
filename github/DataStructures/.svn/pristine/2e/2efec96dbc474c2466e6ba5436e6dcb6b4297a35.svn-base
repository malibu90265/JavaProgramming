<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" type="text/css" href="resources/css/common.css">
<script src="resources/js/jquery-1.11.0.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="resources/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>

<script src="resources/js/report.js" type="text/javascript"></script>
<script>
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    		return false;
    }
    return true;
}
function isFloat(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        if (charCode == 46)
        	return true;
        else 
    		return false;
    }
    return true;
}
function updateReport() {
	var formData = document.reportForm;
	formData.action = "updateReport.do";
	formData.submit();
}
	$(window).ready(function() {
		
	});
function insertPage() {
	location.href="insertReport.do";
}
function downloadFile(e) {
	location.href="downloadDocs.do";
}
</script>
<style type="text/css">
.hover tr:hover {
        background-color: #ffff99;font-weight:bold;
 }
</style>
</head>
<body>
	
	<div class="container">
		
		<section class="contents"> <!-- TODO -->
		<h1 class="contentsTitle">주간보고</h1>
		<div id="history">
				 <form name="reportForm" method="post">
				 검색 :&nbsp;&nbsp; 
					<select name="w_date" id="w_date">
						<c:forEach items="${requestScope.date_list}" var="date">
							<option <c:if test="${requestScope.vo.w_date eq date}"> selected="selected" </c:if>
							value="${date}">${date}
						</c:forEach>
					</select>
					<select name="team_id" id="team_id">
						<option <c:if test="${requestScope.vo.team_id eq '1S'}"> selected="selected" </c:if> value="1S">SI사업팀</option>
						<option <c:if test="${requestScope.vo.team_id eq '2S'}"> selected="selected" </c:if> value="2S">커머스사업팀</option>
						<option <c:if test="${requestScope.vo.team_id eq '3E'}"> selected="selected" </c:if> value="3E">에너지사업팀</option>
						<option <c:if test="${requestScope.vo.team_id eq '4N'}"> selected="selected" </c:if> value="4N">보안사업팀</option>
						<option <c:if test="${requestScope.vo.team_id eq '5D'}"> selected="selected" </c:if> value="5D">미디어사업팀</option>
						<option <c:if test="${requestScope.vo.team_id eq '6C'}"> selected="selected" </c:if> value="6C">경영지원팀</option>
					</select>
					<input type="submit" value="조회"/>
					<input type="button" style="margin-left: 30px;" onclick="insertPage();" value="금주보고작성"/>
					<button onclick="updateReport();">수정</button>
				</form>
		</div>
		<div id="report_table">
			<table>
				<tr>
					<th>팀명</th>
					<th>날짜</th>
					<th>파일명</th>
				</tr>
				<c:forEach items="${requestScope.vo_list }" var="vo">
					<tr onclick="downloadFile('${vo.file_name}')" bgcolor="chucknorris">
						<td>${vo.team_id }</td>
						<td>${vo.w_date }</td>
						<td>${vo.file_name }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="irl">	
			<%-- ${requestScope.vo.report_txt } --%>
			<iframe src="https://docs.google.com/document/d/1O0jWCyIrCuRDjv0dxh5tiO8CJelBFMXMRn0oJQu5Rbk/pub?embedded=true" style="width:100%;height:1000px;"></iframe>
			<!-- <a href="https://docs.google.com/document/d/1O0jWCyIrCuRDjv0dxh5tiO8CJelBFMXMRn0oJQu5Rbk/pub">https://docs.google.com/document/d/1O0jWCyIrCuRDjv0dxh5tiO8CJelBFMXMRn0oJQu5Rbk/pub</a> -->
		</div>
		<div><button onclick="updateReport();">수정</button></div>
		
		</section>
	</div>
	
</body>
</html>