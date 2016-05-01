<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SQI_SOFT_isqpf</title>


<script type="text/javascript">
	var currentScrollTop = 0;

	// 비동기식 jQuery이므로 window load 후 jQuery를 실행해야 함
	window.onload = function() {
		// 새로고침 했을 경우를 대비한 메소드 실행
		scrollController();

		// 스크롤을 하는 경우에만 실행됨
		$(window).on('scroll', function() {
			scrollController();
		});
	}

	// 메인 메뉴의 위치를 제어하는 함수
	function scrollController() {
		currentScrollTop = $(window).scrollTop();
		if (currentScrollTop < 150) {
			$('#blog-header-container').css('top', -(currentScrollTop));
			$('#menu-container').css('top', 150 - (currentScrollTop));
			if ($('#menu-container').hasClass('fixed')) {
				$('#menu-container').removeClass('fixed');
				$('#menu-container .menu-icon').removeClass('on');
			}
		} else {
			if (!$('#menu-container').hasClass('fixed')) {
				$('#blog-header-container').css('top', -150);
				$('#menu-container').css('top', 0);
				$('#menu-container').addClass('fixed');
				$('#menu-container .menu-icon').addClass('on');
			}
		}
	}
</script>

</head>

<body>
	<div id="blog-header-container">
		<h1>SQI 업무관리 시스템</h1>
	</div>
	<div id="menu-container">
		<div id="topMenu">
			<ul>
				<li class="topMenuLi"><a class="menuLink" href="iqspMain.iqspf">SQI soft</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">손익현황</a>
					<ul class="submenu">
						<li><a href="<c:url value="/totalChart.iqspf"/>" class="submenuLink longLink">총 괄 표</a></li>
						<li><a href="#"
							class="submenuLink longLink">전주 대비표</a></li>
						<li><a href="#" class="submenuLink longLink">추 세 분 석</a></li>
						<li><a href="teamList.iqspf" class="submenuLink longLink">연간목표</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">프로젝트 현황</a>
					<ul class="submenu">
						<li><a href="bizList.iqspf" class="submenuLink">프로젝트 정보</a></li>
						<li><a href="#" class="submenuLink ">계약 진행</a></li>
						<li><a href="#" class="submenuLink ">인력 소요</a></li>
						<li><a href="#" class="submenuLink ">실행 예산</a></li>
						<li><a href="#" class="submenuLink ">고객 정보</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">기타 사항</a></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink" href="#">추가 사항</a></li>
			</ul>
		</div>
	</div>
</body>
</html>