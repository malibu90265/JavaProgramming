<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="layer">
	<div class="bg"></div>
	<div id="layer2" class="pop-layer">
		<div class="pop-container">
			<div class="pop-conts">
				<table class="inputbordered">
					<tr>
						<th>프로젝트명</th>
						<th colspan="2">배치기간</th>
						<th>근무월수</th>
						<th>기반분류</th>
						<th>근무지</th>
						<th>평가</th>
						<th>평가 설명</th>
					</tr>
					<c:forEach var="humanResourceEach" items="${humanResourceEachList }" varStatus="i">
					<tr>
						<td>${humanResourceEach.pj_name }</td>
						<td>${humanResourceEach.pd_start_date }</td>
						<td>${humanResourceEach.pd_end_date }</td>
						<td style="text-align:center;">${humanResourceEach.span_of_work_date }</td>
						<td></td>
						<td></td>
						<td>${humanResourceEach.pd_abc }</td>
						<td>${humanResourceEach.pd_abc_desc }</td>
					</tr>
					</c:forEach>
				</table>
				<div style="clear:right;"></div>
					<div class="btn-r">
					외부 배경을 누르면 팝업창이 닫힙니다.
				</div>
			</div><!-- pop-conts -->
		</div><!-- pop-container -->
	</div><!-- layer2 -->
</div><!-- layer -->
