<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>MainPage</title>

<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.11.0.js"/>'></script>
<script type="text/javascript">

	var widthVar = 120;
	var heightVar = 120;
	
	$(document).ready(function() {
		
		$(".bookmarkBox").css({
			"float" : "left",
			"width" : widthVar,
			"height" : heightVar,
			"border" : "1px solid #aaaaaa"
		});
		
		$(".box").css({
			"float" : "left",
			"width" : widthVar,
			"height" : heightVar,
			"border" : "1px solid #aaaaaa"
		});
	});
	
	function allowDrop(ev) {
		ev.preventDefault();
	}
	
	var parentClassName = "";
	function drag(ev) {
		ev.dataTransfer.setData("text", ev.target.id);
		var data = ev.dataTransfer.getData("text");
		parentClassName = document.getElementById(data).parentNode.className;
	}

	// box drop
	function drop(ev) {
		ev.preventDefault();
		var data = ev.dataTransfer.getData("text");
		var cloneData = document.getElementById(data).cloneNode(true);
		ev.target.appendChild(cloneData);
	}
	
	// 즐겨찾기 drop
	function bookmarkDrop(ev) {
		if(parentClassName == "box") {
			ev.preventDefault();
			alert(parentClassName);
		} else {
			ev.preventDefault();
			var data = ev.dataTransfer.getData("text");
			ev.target.appendChild(document.getElementById(data));
			ev.target.removeChild(document.getElementById(data));
		}
	}
	
</script>

</head>
<body>

	<div align="right">
		<span style="cursor: pointer;">로그인</span> <span ondrop="bookmarkDrop(event)" ondragover="allowDrop(event)" style="cursor: pointer;">휴지통</span>
	</div>
	
	<div>
		<div style="width: 120px; height: 120px; float: left;">
			<img src="<c:url value="/resources/images/logo.png"/>"/>
		</div>
		<c:forEach var="i" begin="1" end="7">
			<div id="div${i }" class="bookmarkBox" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
		</c:forEach>
	</div>
	<div style="clear: both;"></div>
	<div>
		<c:forEach var="i" begin="1" end="56">
			<div class="box">
				<span id="dragText${i }" draggable="true" ondragstart="drag(event)">dragText   ${i }</span>
			</div>
			<c:if test="${i % 8 == 0 }">
				<div style="clear: both;"></div>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>