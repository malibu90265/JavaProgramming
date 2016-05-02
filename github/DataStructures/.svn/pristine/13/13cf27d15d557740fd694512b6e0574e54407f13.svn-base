// 검색
function getHRPriceSearchForm() {
	$.ajax({
		type : "POST",
		url : "/humanResource/getHRPriceSearchFormAjax",
		success : function(data) {
			$("#hrPriceSearchForm").empty();
			$("#hrPriceSearchForm").html(data);
			
			selectChangeFunction();
		},
		error : function(xhr) {
			alert("error getHRPriceSearchForm = " + xhr.statusText);
		}
	});
}

function selectChangeFunction() {
	var tm_id = $("#tm_id").val();
	getHRPriceInsertForm(tm_id);
}

function getHRPriceListAjax() {
	$.ajax({
		type: "post",
		url : "/humanResource/getHRPriceList",
		success: function(data) {
			$("#hrPriceList").empty();
			$("#hrPriceList").html(data);
		}, error : function(xhr) {
			alert("allTeamPriceBtn = " + xhr.statusText);
		}
	});
}

//Insert
function getHRPriceInsertForm(tm_id) {
	$.ajax({
		type : "POST",
		url : "/humanResource/getHRPriceInsertFormAjax",
		data : {"tm_id": tm_id},
		success : function(data) {
			$("#hrPriceForm").empty();
			$("#hrPriceForm").html(data);
			
			$("#hrPriceForm #hp_team").val(tm_id);
			
			if(allTeamPriceBtnClickCnt) getHRPriceListAjax()
		},
		error : function(xhr) {
			alert("error getHRPriceInsertForm = " + xhr.statusText);
		}
	});
}

function insertHRPriceInfoAjax(formId) {
	$.ajax({
		type : "POST",
		url : "/humanResource/insertHRPriceInfoAjax",
		data : $(formId).serialize(),
		success : function(data) {
			alert(data.message);
			getHRPriceInsertForm(data.tm_id)
		},
		error : function(xhr) {
			alert("error insertHRPriceInfoAjax = " + xhr.statusText);
		}
	});
}

function HPComma(str) {
	var str = str.replace(/,/g, '');
	var resultVal = "";
	for (i = 1; i <= str.length; i++) {
		if(i > 1 && (i % 3) == 1) {
			resultVal = str.charAt(str.length - i) + "," + resultVal;
		}
		else {
			resultVal = str.charAt(str.length - i) + resultVal;
		} 
	} 
	return resultVal;
}

function CommaObj(obj) {
	var str = obj.value.replace(/,/g, '');
	var resultVal = "";
	for (i = 1; i <= str.length; i++) {
		 if(i > 1 && (i % 3) == 1) {
			resultVal = str.charAt(str.length - i) + "," + resultVal;
		}
		else {
			resultVal = str.charAt(str.length - i) + resultVal;
		} 
	} 
	obj.value = resultVal;
}

function numOnlyAndComma(obj) {
	if (event.keyCode != 45 && (event.keyCode != 46) && (event.keyCode != 8)
			&& (event.keyCode < 48) || (event.keyCode > 57) && ((event.keyCode < 96) || (event.keyCode > 105))) {
		event.returnValue = false;
	}
	obj.value = obj.value.replace(/[ㄱ-ㅣ가-힣a-zA-Z]/,'');
	CommaObj(obj);
}

//text에 빈칸 있을 시에 저장 안되도록
function textEmptyValidcheck(frm){
	 var em = frm.elements;
	 for (var i = 0; i < em.length; i++) {
	        if ((em[i].value == '') || (em[i].value == null) ){
	        	alert("단가를 모두 입력하여주십시요.");
	        	return false;
	        }
	    }
	 return true;
}