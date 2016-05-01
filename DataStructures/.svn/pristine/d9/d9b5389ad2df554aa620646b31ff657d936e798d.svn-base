<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>행사사진</title>
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admin_css/photo.css"/>">
<link rel="stylesheet" type="text/css"
	href="/resources/css/humanResource_css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/humanResource/hrPrice.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {

		getMiniHeaderAjax();

		getHRPriceSearchForm();
		
		
		<c:set var="i" value="1"/>
		<c:forEach begin="1" end="3">
		
		
		$(".btn_${i}").click(function(){
			$(".updateForm_${i}").attr("action", "<c:url value="/admin/doUpdate"/>");
			$(".updateForm_${i}").attr("method", "post");
			$(".updateForm_${i}").submit();
			
		});
		<c:set var="i" value="${i+1}"/>
		</c:forEach>
		
		

		
		
		
	});
	

</script>
</head>
<body>
	<div id="miniHeader"></div>

	<div class="container">
		<!-- <section class="contents">
			<h1 class="contentsTitle">Test</h1>
			<div id="hrPriceSearchForm"></div>
			<div id="hrPriceForm"></div>
			<div id="hrPriceList"></div>
		</section> -->
		<!--  -->
		<%-- <c:forEach var="articleList" items="${articleList }">
		<tr>
		<table border="1" width="650px" height="800px">
		<c:forEach var="photoList" items="${photoList }">
		<tr>
		<td><img width="300px"src="/admin/download/${photoList.photoIndex}"/></td>
		</tr> 
		</c:forEach> --%>
		<!--  -->
		
		<section class="contents">
		<h1 class="contentsTitle">행사사진</h1>
		<h6 class="contentsTitle">(파일선택을 클릭하여 사진을 선택하고 업로드 버튼을 눌러주세요!)</h6>
		<div class="bordered">
			<table >
			
			<c:set var="i" value="1"/>
			<c:forEach var="photoList" items="${photoList }">
				<tr><th class="img"><img  width="300px" height="225px" src="/admin/download/${photoList.photoIndex}"/></th></tr> 
				<tr>
					<th>
					<form name = "updateForm_${i}" id ="updateForm_${i}" class ="updateForm_${i}" enctype="multipart/form-data">
						<input type="hidden" name="photoIndex"  value="${photoList.photoIndex}"/>
						<input type="file" name="uploadFile"  />
					</form>
					<span  id="btn_${i}" class="btn_${i} }">업로드</span>
					</th>
				</tr>
				<c:set var="i" value="${i+1}"/>
				</c:forEach>
			</table>
		</div>
			</section>
	
		</div>
		
	
</body>
</html>
