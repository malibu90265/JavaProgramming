<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
    <h2>게시판 목록</h2>
    <table class="board_list">
        <colgroup>
            <col width="5%"/>
            <col width="5%"/>
            <col width="*"/>
            <col width="5%"/>
            <col width="10%"/>
        </colgroup>
        <thead>
            <tr>
            	<th scope="col"><input type="checkbox" id="checkedAll" name="checkedAll" value="checkedAll"></th>
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">조회수</th>
                <th scope="col">작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${fn:length(list) > 0}">
                    <c:forEach items="${list }" var="row">
                        <tr>
                        	<td><input type="checkbox" id="check" name="check" value="${row.IDX }"></td>
                            <td>${row.IDX }</td><!-- 글번호 -->
                            <td class="title">
                                <a href="#this" name="title">${row.TITLE }</a>
                                <!-- 각 게시글을 조회할 때 필요한 정보인 해당 게시글의 번호를 알기 위해서 hidden 태그를 이용해 각 글번호를 숨겨놓음. -->
                                <input type="hidden" id="IDX" value="${row.IDX }"> 
                            </td>
                            <td>${row.HIT_CNT }</td>
                            <td>${row.CREA_DTM }</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="4">조회된 결과가 없습니다.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    <br/>
    <div  align="right">
    	<a href="#this" class="btn" id="write">글쓰기</a>
    	<a href="#this" class="btn" id="delete" name="delete">삭제</a>
    </div>
    
     
    <%@ include file="/WEB-INF/include/include-body.jspf" %>
    <script type="text/javascript">
        $(document).ready(function(){
        	//전체선택 및 해제
            $('input[name=checkedAll]').on('change', function(){
            	  $('input[name=check]').prop('checked', this.checked);
            	});

        	
            $("#write").on("click", function(e){ //글쓰기 버튼
                e.preventDefault();
                fn_openBoardWrite();
            }); 
            
            $("a[name='title']").on("click", function(e){ //제목 클릭시
                e.preventDefault();
                fn_openBoardDetail($(this));
            });
            
            $("#delete").on("click", function(e){ //삭제하기 버튼
				e.preventDefault();
				var arr = $('input[name=check]:checked').serializeArray().map(function(item) { return item.value });
				for(var i=0; i<arr.length; i++){
					console.log("삭제함수들어가기");
					fn_deleteBoard(arr[i]);
					console.log("삭제함수 나옴");
				}
				//삭제되었습니다 alert창 띄우기
				//전체선택&선택된 체크박스 해제시켜주기
			});
        });
         
         
        function fn_openBoardWrite(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/sample/openBoardWrite.do' />");
            comSubmit.submit();
        }
         
        function fn_openBoardDetail(obj){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/sample/openBoardDetail.do' />");
            //addParam 메소드 : 서버로 전송될 key와 value를 인자값으로 받는다.
            //obj.parent().find("#IDX").val() : JQuery를 이용하여 선택된 <a> 태그의 부모 노드 내에서 IDX라는 값을 가진 태그를 찾아 그 값을 가져옴.
            comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
            comSubmit.submit();
        }
        
        function fn_deleteBoard(arr){
        	//for문을 이용해 연속으로 요청하는 거 가능한지. 
        	console.log("arr = "+arr);
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/sample/deleteBoard.do' />");
			comSubmit.addParam("IDX", arr);
			comSubmit.submit();
		}
        
    </script> 
</body>
</html>