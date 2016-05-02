<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 메인을 제외한 곳에서 쓰일 로그아웃 + 마이메뉴 헤더입니다. -->
<div class="codrops-top_mini clearfix">
	<span class="left">
		<a href="<c:url value="/admin/main"/>">
			<img class="logo_img" src="/resources/images/ico_bz.png" alt="Dual-View Slideshow Image"/>
		</a>
	</span>
	<span id="my_menu_button">( MY MENU )</span>
		<c:forEach var="key" items="${mymenu.keySet() }">
			<a class="my_menu_each" href='<c:url value="${mymenu.get(key).url}"/>'>
				${mymenu.get(key).name}
			</a>
		</c:forEach>
	<span class="right">
	<a class="codrops-icon-mini" href="<c:url value="/logout"/>">
		<span>로그아웃</span>
	</a>
	</span>
</div>
