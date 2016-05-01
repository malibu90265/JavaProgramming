<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>PM평가 등록</title>
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/humanResource_css/demo.css" />

<script type="text/javascript" src="<c:url value="/resources/js/humanResource/Estimate/estimate.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/miniHeader.js"/>"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	// 기본 출력 : 헤더, 검색, 리스트
	getMiniHeaderAjax();
	getEstimationSignupSearchForm();
	getEstimateForm();
	
	// 저장 
	$("#mainDiv").on("click", "#estimationModifyBtn", function(){
		var count = $("#count").val();
		var pd_name, pj_id, pd_abc, pd_soft_abc, pd_abc_desc;
		
		for(var i=1; i <= count; i++) {
			pd_name = $("#pd_name" + i).val();
			pj_id = $("#pj_id" + i).val();
			pd_abc = $("select[name=pd_abc"+i+"]").val();
			pd_soft_abc = $("select[name=pd_soft_abc"+i+"]").val();
			pd_abc_desc = $("#pd_abc_desc" + i).val();
			estimationModifyFormAjax(pd_name, pj_id, pd_abc, pd_soft_abc, pd_abc_desc);
		}
	});
});
</script>
<style type="text/css">
	.search {width:30%; float: left; font-size: 1.5vh;font-size: 1.5vm;}
	.bordered {width: 100%; height: 70vh; height: 70vm; overflow-y:auto; font-size: 1.5vh;font-size: 1.5vm;}
	#hahahaDiv,#hahahahaDiv, #hahaDiv{float: right; clear: inherit;  border: dotted 1px #ebebeb;margin-bottom: 2px;padding: 2px 4px;  font-size: 1.5vh;font-size: 1.5vm;}
	.one, .two, .three {padding: 2px 4px;}
	.one, .three {padding: 2px 4px; font-weight: bold;}
	.one {background-color: #dce9f9;}
	.three {background-color: #FEE7F0;}
	#haDivAll {float: right; clear: inherit; width: 50%;}
</style>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader"></div>
	
	<div style="clear: inherit;"></div>
		
	<div class="container">
		<div class="contents">
			<table id="topTableName">
				<tr>
					<th><p id="topTableP">PM평가 등록</p></th>
				</tr>
			</table>
			<div id="dontHaveIdeaInThisDivName" class="search"></div>
			
			<div id="haDivAll">
				<div id="hahaDiv">
					<span class="one">인성평가 기준</span>	<span class="two">의사소통력, 성실, 협조성, 책임감 등을 다각적으로 평가합니다.</span>
				</div>
				<div id="hahahaDiv">
					<span class="one">개발성과</span>
					<span class="one">&nbsp; A &nbsp;</span>	<span class="two">&nbsp;매우 우수&nbsp;&nbsp;</span>
					<span class="one">&nbsp; B &nbsp;</span>	<span class="two">&nbsp;보통&nbsp;&nbsp;&nbsp;</span>
					<span class="one">&nbsp; C &nbsp;</span>	<span class="two">&nbsp;평균 이하&nbsp;&nbsp;</span>
					<span class="one">인성평가</span>
					<span class="one">&nbsp; A &nbsp;</span>	<span class="two">&nbsp;양호&nbsp;&nbsp;&nbsp;</span>
					<span class="one">&nbsp; B &nbsp;</span>	<span class="two">&nbsp;보통&nbsp;&nbsp;&nbsp;</span>
					<span class="one">&nbsp; C &nbsp;</span>	<span class="two">&nbsp;불량&nbsp;&nbsp;&nbsp;</span>
				</div>
				<div id="hahahahaDiv">
					<span class="three">(예시)</span>&nbsp;
					<span class="one">개발성과</span>	<span class="two">B</span>
					<span class="one">인성평가</span>	<span class="two">A &nbsp;&nbsp;</span>
					<span class="one">평가설명</span>	<span class="two">협조적이고 성실하나 의사소통에 어려움이 있음. 일에 대한 책임감은 있는듯.&nbsp;</span>
				</div>
			</div>
			
			<div id="mainDiv" class="bordered" ></div>
		</div><!-- contents -->
	</div><!-- container -->
</body>
</html>


