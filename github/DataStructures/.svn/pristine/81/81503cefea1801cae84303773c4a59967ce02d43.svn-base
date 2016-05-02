<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
function setNav(main, sub) {
	$(".mainNav", "#mainNavContainer").eq(main).addClass("navSelected");
	$(".subNavContainerChild","#subNavContainer").eq(main).show();
	$(".subNavContainerChild","#subNavContainer").eq(main).children().eq(sub).addClass("navSelected");
}
</script>
<div class="header">
	<div class="header_area">
		<div>
			<img src="resources/images/logo.png"/>
		</div>
		<div id="mainNavContainer">
			<div class="mainNav" onclick="javascript:location.href='totalChart.iqspf'">손익현황</div>
			<div class="mainNav" onclick="javascript:location.href='bizList.iqspf'">프로젝트현황</div>
			<div class="mainNav" onclick="javascript:location.href='emp_List.do'">인력현황</div>
		</div>
	</div>
</div>