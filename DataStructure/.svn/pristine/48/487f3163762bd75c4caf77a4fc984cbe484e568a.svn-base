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
<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->

<script type="text/javascript" src="resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>

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
	$(window).ready(function() {
		/* setTeamReport(); */
		/* setTeam(); */
		//TODO
		/* setNav(0, 3); */
	});
	var oEditors = [];
	$(function() {
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
	          elPlaceHolder: "report_txt", //textarea에서 지정한 id와 일치해야 합니다. 
	          //SmartEditor2Skin.html 파일이 존재하는 경로
	          sSkinURI: "resources/SE2/SmartEditor2Skin.html",
	          htParams : {
	              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseToolbar : true,             
	              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseVerticalResizer : true,     
	              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	              bUseModeChanger : true,         
	              fOnBeforeUnload : function(){
	                   
	              }
	          }, 
	          /* fOnAppLoad : function(){
	              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
	              oEditors.getById["report_txt"].exec("PASTE_HTML", []);
	          }, */
	          fCreator: "createSEditor2"
		});
		//저장버튼 클릭시 form 전송
	      $("#save").click(function(){
	          oEditors.getById["report_txt"].exec("UPDATE_CONTENTS_FIELD", []);
	          $("#reportForm").submit();
	      });
	});
function cancleBtn() {
	location.href="viewReport.do";
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
		
		<div id="viewRepoertAjax"
			style="width : 1350px; backgreound: white; margin-right : 20px; float: left; margin-top : 30px;">
			<form name="reportForm" id="reportForm" action="updatingReport.do" method="post">
				<input type="hidden" id="team_id" name="team_id" value="${requestScope.vo.team_id }"/>
				<input type="hidden" id="w_date" name="w_date" value="${requestScope.vo.w_date }"/>
				<textarea rows="30" cols="160" name="report_txt" id="report_txt">${requestScope.vo.report_txt }</textarea>
				<input type="button" id="save" value="저장"/>
				<input type="button" onclick="cancleBtn();" value="취소"/>
			</form>
		</div>
		</section>
	</div>
	
</body>
</html>