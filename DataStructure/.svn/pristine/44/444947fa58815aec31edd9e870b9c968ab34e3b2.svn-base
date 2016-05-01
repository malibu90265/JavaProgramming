<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MainPage</title>
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="/resources/css/main_css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/main_css/bottom-area.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/main_css/standardform.css" />
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.js"/>'></script>
	<script type="text/javascript">

	function allowDrop(ev) {
		ev.preventDefault();
	}
	
	var parentClassName = "";
	function drag(ev) {
		ev.dataTransfer.setData("text", ev.target.id);
		var data = ev.dataTransfer.getData("text");
		parentClassName = document.getElementById(data).parentNode.className;
	}

	// 개별 항목을 즐겨찾기(상단바)에 올립니다.
	function drop(ev) {
		ev.preventDefault();
		var data = ev.dataTransfer.getData("text");
		// 데이터가 있을 경우. target은 위치를 바라봄.
		if(ev.target.firstChild != null) {
			alert("이미 데이터가 있습니다.");
		} 
		else {
			var cloneData = document.getElementById(data).cloneNode(true);
			ev.target.appendChild(cloneData);
		}
	}
	
	// 즐겨찾기에 있는 데이터를 쓰레기통으로 넣습니다.
	function bookmarkDrop(ev) {
		
		 if (parentClassName == "grid") {
				ev.preventDefault();
				alert("original data");
			}
		else {
				ev.preventDefault();
				var data = ev.dataTransfer.getData("text");
				ev.target.appendChild(document.getElementById(data));
				ev.target.removeChild(document.getElementById(data));
			}
		}  
	</script>

</head>
<body>
<!-- ************************************ 
	error 1: 휴지통 : main_script.jsp
	toDo: 색 입히기  : main.jsp
	************************************* -->
		<div class="container" >
			<!-- Top Navigation : 로그인 -->
			<jsp:include page="./../common/login_header.jsp"></jsp:include>
			<div style="clear:both;"></div>
			
			<!-- 상단 (로고 + 즐겨찾기 + 쓰레기통) -->
			<jsp:include page="./../common/bookmark_header.jsp"></jsp:include>
			<div style="clear:both;"></div>
			
			<!-- 중간 메뉴 -->
			<div class="content">
				<div id="grid" class="grid">
				
				<c:forEach var="main" items="${mainAddressList }" >
					<c:choose>
			          <c:when test="${main.bigClass == 1 }">
			            <c:set var="color" value="#51c6d7" />
			          </c:when>
			          <c:when test="${main.bigClass == 2 }">
			            <c:set var="color" value="#c4b935" />
			          </c:when>
			          <c:when test="${main.bigClass == 3 }">
			            <c:set var="color" value="#fc9227" />
			          </c:when>
			          <c:when test="${main.bigClass == 4 }">
			            <c:set var="color" value="#ffd324" />
			          </c:when>
			          <c:otherwise>
			            <c:set var="color" value="#3B3B3D" />
			          </c:otherwise>
			        </c:choose>
						<div class="grid__item" 
							id="dragText${main.id }" 
							draggable="true" 
							ondragstart="drag(event)" 
							style='background-color:<c:out value="${color}"/>;'>
								<a href='<c:url value="${main.address }"/>'>
									${main.middleName }<br/><p>${main.smallName }</p>
								</a>
						</div>
					<c:if test="${main.id % 8 == 7 }">
						<div style="clear: both;"></div>
					</c:if>
				</c:forEach>
				</div>
				<div style="clear: both;"></div>

				<!-- 바닥 -->
				<jsp:include page="./../common/footer.jsp"></jsp:include>
			</div><!-- /content -->
		</div><!-- /container -->
	</body>
</html>