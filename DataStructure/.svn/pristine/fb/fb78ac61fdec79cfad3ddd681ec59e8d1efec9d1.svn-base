<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>메뉴관리</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/category-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/admin_css/menu-form.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/main_css/demo.css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/colorpicker/jscolor.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/admin/menuCategory.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/common/common.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vaildCheck.js"/>"></script>
	<script type="text/javascript">
		
		$(document).ready(function() {
			
			getMiniHeaderAjax();
			
			/* category function */
			resetCategoryPage();
			
			$("#categoryForm").on("click", "#categoryInsertBtn", function(){
				if(categoryValidationCheck()) {
					var formId = "#categoryInsertForm";
					existCategoryNameAjax(formId, "insert");
				}
			});
			
			$("#categoryDiv").on("click", ".categoryRow", function() {
				var categoryId = $(this).children().eq(0).text();
				getCategoryModifyFormAjax(categoryId);
			});
			
			$("#categoryForm").on("click", "#categoryModifyBtn", function(){
				if(categoryValidationCheck()) {
					var formId = "#categoryModifyForm";
					existCategoryNameAjax(formId, "modify");
				}
			});
			
			$("#categoryForm").on("click", "#categoryDeleteBtn", function(){
				if(confirm("정말로 삭제하시겠습니까??")) {
					var categoryId = $("#categoryId").val();
					deleteCategoryAjax(categoryId);
				}
			});
			
			$("#categoryForm").on("click", "#categoryResetBtn", function(){
				getCategoryInsertFormAjax();
			});
			
			/* menu function */
			
			$("#menuSearchDiv").on("change", "#categorySearch", function() {
				var categoryId = $(this).val();
				
				getMenuListAjax(categoryId);
			});
			
			$("#menuForm").on("click", "#menuInsertBtn", function(){
				if(menuValidationCheck()) {
					var formId = "#menuInsertForm";
					existMenuNameAjax(formId);
				}
			});
			
			$("#menuDiv").on("click", ".menuRow", function() {
				var categoryId = $(this).children().eq(0).attr("class");
				var menuSq = $(this).children().eq(1).text();
				
				getMenuModifyFormAjax(categoryId, menuSq);
			});
			
			$("#menuForm").on("click", "#menuDeleteBtn", function(){
				if(confirm("정말로 삭제하시겠습니까??")) {
					var categoryId = $("#categoryId").val();
					var menuSq = $("#menuSq").val();
					
					deleteMenuAjax(categoryId, menuSq);
				}
			});
			
			$("#menuForm").on("click", "#menuModifyBtn", function(){
				if(menuValidationCheck()) {
					var formId = "#menuModifyForm";
					modifyMenuAjax(formId);
				}
			});
			
			$("#menuForm").on("click", "#menuResetBtn", function(){
				getMenuInsertFormAjax();
			});
		});
		
</script>
</head>
<body>

	<!-- Top Navigation : 로그인 -->
	<div id="miniHeader">
	</div>
	
	<!-- 전체를 container div로 감싸야 footer가 아래로 붙습니다. -->
	<div class="categoryContainer">
		<section class="categoryContents">
			<h1 class="categoryContentsTitle">대분류 관리</h1>
			<div id="categoryDiv"></div>
			
			<div id="categoryForm"></div>		
		</section>
	</div>
		
	<div class="menuContainer">
		<section class="menuContents">
			<h1 class="menuContentsTitle">메뉴 관리</h1>
			<div id="menuSearchDiv"></div>
			
			<div id="menuDiv"></div>
			
			<div id="menuForm"></div>		
		</section>
	</div>	
	
</body>
</html>