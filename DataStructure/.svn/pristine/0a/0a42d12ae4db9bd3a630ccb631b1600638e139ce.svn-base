<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>셀렉트 박스 데이터 관리</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/basicInfo/basicInfo-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/basicInfo/basicInfo.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
	<script type="text/javascript">
		
		$(document).ready(function() {
			
			getMiniHeaderAjax();
			
			getMainPageAjax();
		});
</script>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader">
	</div>
	
	<div class="basicInfoContainer">
		<section class="basicInfoContents">
			<c:forEach var="item" items="${selectBoxItems.keySet() }" varStatus="status">
				<div class="mainDiv" id="${item }MainDiv" style="float: left;">
					
				</div>
				<%-- <c:if test="${status.count == 3 }">
					<div style="clear: both;"></div>
				</c:if> --%>
				
			</c:forEach>
		</section>
	</div>
		
</body>
</html>
