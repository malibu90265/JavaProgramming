<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 메인 페이지에서 쓰이는 마이메뉴 헤더 입니다. -->
	<div class="drop-area" >
		<div class="my_menu">MY<br/>MENU</div>
			<c:forEach var="i" begin="1" end="9">
				<c:choose>
					<c:when test="${myMenuListMap.containsKey(i) }">
						<div id="seq ${myMenuListMap.get(i).seq}" class="drop-area__item">
							<div class="grid__item" 
								id="dragTextMyMenu ${myMenuListMap.get(i).categoryId} ${myMenuListMap.get(i).sq }" 
								draggable="true" 
								ondragstart="drag(event)"
								ondrop="mymenuDrop(event)" 
								ondragover="allowDrop(event)"
								style='background-color:<c:out value="${myMenuListMap.get(i).categoryColor}"/>;'>
									<a href='<c:url value='${myMenuListMap.get(i).url }'/>' id="atag_${myMenuListMap.get(i).categoryId}_${myMenuListMap.get(i).sq }" draggable="false">
										${myMenuListMap.get(i).categoryName }<br/><p id="ptag_${myMenuListMap.get(i).categoryId}_${myMenuListMap.get(i).sq }" draggable="false">${myMenuListMap.get(i).name }</p>
									</a>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div id="seq ${i}" class="drop-area__item" ondrop="mymenuDrop(event)" ondragover="allowDrop(event)">
							<span id="dropAreaItemSpanId" class="dropAreaHc dropAreaVc">여기에<br/>메뉴를<br/>추가하세요.</span>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		<div class="drop-area__item_trash_can" ondrop="trashBoxDrop(event)" ondragover="allowDrop(event)">
			<img src="<c:url value='/resources/images/icon_trash.png'/>" />
		</div>
		<div style="clear:both;"></div>
	</div><!-- drop-area -->