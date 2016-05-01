<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<script src="resources/js/jquery-1.11.0.js"></script>
	<script>
		function setNav(main, sub, sub2){
			$(".mainNav", "#mainNavContainer").eq(main).addClass("navSelected");
			$(".subNav", "#subNavContainer").eq(sub).addClass("navSelected");
			$(".subNav", "#subNavContainer").eq(sub).next().show();
			if(sub2 != null){
				$(".subNav", "#subNavContainer").eq(sub).next().children().eq(sub2).addClass("navSelected");
			}
		}
		$(window).ready(function(){
			//TODO
			setNav(0,0,0);
		});
	</script>
</head>
<body>
	<div class="header">
		<div class="header_area">
			<div>
				<img src="resources/images/logo.png"/>
			</div>
			<div id="mainNavContainer">
				<div class="mainNav"><a href="totalChart.iqspf">손익현황</a></div>
				<div class="mainNav"><a href="bizList.iqspf">프로젝트현황</a></div>
				<div class="mainNav">인력현황</div>
			</div>
		</div>
	</div>
	<div class="container">
		
	</div>
	<div class="footer">
		<p>서울시 영등포구 경인로 775 (문래동3가) 에이스하이테크시티 1동 803호</p>
		<p>TEL : 02-2109-1900 / FAX : 02-2109-1999 / MAIL : webmaster@sqisoft.com</p>
		<p>Copyright ⓒ 1999~2014 SQISOFT ALL RIGHTS RESERVED.</p>
	</div>
</body>
</html>