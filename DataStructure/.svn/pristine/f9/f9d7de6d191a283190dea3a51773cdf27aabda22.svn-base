<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src='<c:url value="/resources/js/common/changePassword.js"/>'></script>
	
<!-- 비밀번호 변경 팝업 -->
<div class="layer">
	<div class="bg"></div>
	<div id="layer2" class="pop-layer">
		<div class="pop-container">
			<div class="pop-conts">
				<!--content //-->
				<!-- ctxt mb20 -->
				<form id="changePasswordForm" method="post" action="<c:url value="/changePwd/modify"/>">
					<h1>비밀번호 변경</h1>
					<input	type="password"
							placeholder="현재 비밀번호"
							name="chkPassword"
							id="chkPassword"
							autocomplete="off" />
					<input	type="password"
							placeholder="변경 비밀번호"
							name="password"
							id="passwordChange" />
					<input	type="password"
							placeholder="변경 비밀번호 확인"
							name="passwordCon"
							id="passwordChangeCon" />
					<div>
					<input type="hidden" name="email" id="email"/>
					</div><!-- password-container -->
					<!-- 로그인 버튼 -->
				<div style="clear:right;"></div>
					<div class="btn-r">
					<a href="#" class="cbtn">취소</a>
					<button class="button submit" type="submit">변경</button>
				</div>
				</form>
				<!--// content-->
			</div><!-- pop-conts -->
		</div><!-- pop-container -->
	</div><!-- layer2 -->
</div><!-- layer -->