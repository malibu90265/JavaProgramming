function getProjectDetail(pjId){
	
	$("#jogun p:first-child input").val("");
	$("#pj_need_detail #inputbox tbody").empty();
	
	// 다른 프로젝트 선택하면 초기화
	$.ajax({
		type : "POST",
		url:"/Pjneeds_DetailList",
		async : true,
		dataType : "json",
		data:{				
			pj_id:pjId
		},
		success : function(data) {
			var vo = {
				pj_id			: data.budgetVO.pj_id
				,pj_start_day	: data.budgetVO.pj_start_day
				,pj_end_day		: data.budgetVO.pj_end_day
				,pj_require		: data.budgetVO.pj_require
				,pn_num			: data.budgetVO.pn_num
			};
			
			//조회 값 바인딩
			$.each(vo, function(k,v){
				$("#"+k).val(v);
			});
			
			//프로젝트 ID, 기간 비활성화
			$("#jogun p input[type=text]").attr("disabled","disabled");
			//저장버튼 활성화
			$("#submit_btn").removeAttr("disabled");
			
			//취소버튼 활성화
			$('#cancel_btn').removeAttr("disabled");
			
			//project 클릭시 인원 입력상자 활성화
			$("#jogun p #pn_num").removeAttr("disabled");
			if(pn_num!="")maketable(pn_num);
			
			//인력소요에 default날짜 저장
			$("#temp_pj_start_day").val(vo.pj_start_day);
			$("#temp_pj_end_day").val(vo.pj_end_day);
			
			//데이터 불러오기
			var detailVO = data.pjneedsVO;
			$("#pj_need_detail #inputbox tbody tr").each(function(k,v){
				$(v).find("[name=pn_num]").text(detailVO[k].pn_num);
				$(v).find("select[name=pn_grade]").val(detailVO[k].pn_grade);
				$(v).find("select[name=pn_skill]").val(detailVO[k].pn_skill);
				$(v).find("input[name=needstartday]").val(detailVO[k].pn_day_from);
				$(v).find("input[name=needendday]").val(detailVO[k].pn_day_to);
			});
			
		},
		error : function(xhr) {
			alert("error html7 = " + xhr.statusText);
		}			
	});
}

var changePnNumEvent;

$(document).ready(function(){
	//버튼 기능 활성화
	pjneedsDetailBtn.init();
	
	$("#pn_num").keyup(function(){
		//숫자 replace
		this.value = this.value.replace(/[^0-9.]/g,'');
		clearTimeout(changePnNumEvent);
		changePnNumEvent = setTimeout(function() {
			maketable();
		  }, 550);
	});
	
	//요구인원에서 키를 누를때
	$("#pn_num").keydown(function(e){
		// . 제외 code : 190
		// Allow: backspace, delete, tab, escape, enter 
		if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
			// Allow: Ctrl+A
			(e.keyCode == 65 && e.ctrlKey === true) || 
			// Allow: home, end, left, right
			(e.keyCode >= 35 && e.keyCode <= 39)) {
				// let it happen, don't do anything
				return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
        	e.preventDefault();
        }
	});
	
	//요구인원에서 포커스가 나갈때
	$("#pn_num").blur(function(){
		if(this.value == undefined || this.value == ""){
			this.value = 0;
		}else{
			this.value = this.value.replace(/[^0-9]/g,'');
		}
	});
	
	calendar();
});	

// 인력소요 요구조건 테이블 TR 추가 및 삭제
function maketable(){
	var pn_num=$("#pn_num").val();
	if(pn_num==""){
		$("#pj_need_detail #inputbox tbody").empty();
	}
	else if(pn_num!=""){
		if($("#pj_need_detail #inputbox").html()!=null){
			//요구조건 테이블의 TR 갯수
			var trCnt = $("#pj_need_detail #inputbox tbody tr").length;
			
			// 요구인원 줄일 시 TR 삭제
			if(trCnt>pn_num){
				$("#pj_need_detail #inputbox tbody tr:gt(" + pn_num + "),#pj_need_detail #inputbox tbody tr:eq(" + pn_num + ")").remove();
			}
			// 요구 인원 늘릴시 TR 삽입
			else if(trCnt<pn_num){
				
				for(var i=trCnt;i<pn_num;i++){
					$("#pj_need_detail #inputbox tbody").append(makeNeedReqTableTr(i));
				}
				$("#pj_need_detail #inputbox tbody tr:gt(" + trCnt + ") [name=needstartday], #pj_need_detail #inputbox tbody tr:eq(" + trCnt + ") [name=needstartday]").val($("#pj_start_day").val());
				$("#pj_need_detail #inputbox tbody tr:gt(" + trCnt + ") [name=needendday], #pj_need_detail #inputbox tbody tr:eq(" + trCnt + ") [name=needendday]").val($("#pj_end_day").val());
				
				$("#pj_need_detail #inputbox tbody tr:gt(" + trCnt + ") [name=needstartday], #pj_need_detail #inputbox tbody tr:eq(" + trCnt + ") [name=needstartday]").datepicker("option", "maxDate", $("#pj_end_day").val());
				$("#pj_need_detail #inputbox tbody tr:gt(" + trCnt + ") [name=needendday], #pj_need_detail #inputbox tbody tr:eq(" + trCnt + ") [name=needendday]").datepicker("option", "minDate", $("#pj_start_day").val());
			}
			
		}else{
			var html="";
			
			html+='<table border="1" style="margin:0px 10px 0px; padding:40px; width: 590px;"  id="inputbox">';
			html+='<colgroup>';
			html+='<col style="width: 90px;" />';
			html+='<col style="width: 62px;" />';
			html+='<col style="width: 95px;" />';
			html+='<col style="width: *;" />';
			html+='</colgroup>';
			html+='<tbody>';
			for(var i=0;i<pn_num;i++){
				html+= makeNeedReqTableTr(i);
			}
			html+='</tbody></table>';
			$("#pj_need_detail").html(html);
			
			$("#pj_need_detail #inputbox [name=needstartday]").val($("#pj_start_day").val());
			$("#pj_need_detail #inputbox [name=needendday]").val($("#pj_end_day").val());
			
			$("#pj_need_detail #inputbox [name=needstartday]").datepicker("option", "maxDate", $("#pj_end_day").val());
			$("#pj_need_detail #inputbox [name=needendday]").datepicker("option", "minDate", $("#pj_start_day").val());
		}
	}
	
}

// 인력소요 요구조건 리스트
function makeNeedReqTableTr(trNum){
	var html = '';
	html+='<tr align="center">';
	html+='<td name="pn_num">'+(trNum+1)+'</td>';
	html+='<td><select name="pn_grade"><option value="특급">특급</option><option value="고급">고급</option><option value="중급">중급</option><option value="초급">초급</option></select></td>'
	html+='<td>';
    html+='<select name="pn_skill">';
    html+='<option value="SERVER">SERVER</option><option value="UI">UI</option><option value="DB">DB</option><option value="모바일">모바일</option><option value="빌드">빌드</option><option value="기타">기타</option>'
    html+='</select>';
	html+='</td>';
	html+='<td>';
	html+='<input type="text" style="width: 138px; text-align: center;"  name="needstartday" onMouseDown ="maxdate(this)" class="needstartday">&nbsp;-&nbsp;';
	html+='<input type="text" style="width: 138px; text-align: center;"  name="needendday" onMouseDown ="mindate(this)" class="needendday"></td>';
	html+='</tr>';
	return html;
}

function maxdate(dpElement) {
	$(dpElement).datepicker();
	$(dpElement).datepicker("option", "maxDate", $(dpElement).closest("tr").find("input[name=needendday]").val());
	$(dpElement).datepicker("option", "onClose", function(selectedDate) {
		$(dpElement).closest("tr").find("input[name=needendday]").datepicker("option", "minDate", selectedDate);
	});
}
function mindate(dpElement) {
	$(dpElement).datepicker();
	$(dpElement).datepicker("option", "minDate", $(dpElement).closest("tr").find("input[name=needstartday]").val());
	$(dpElement).datepicker("option", "onClose", function(selectedDate) {
		$(dpElement).closest("tr").find("input[name=needstartday]").datepicker("option", "maxDate", selectedDate);
	});
}
function initialize(){
	$("p input").val('');
	$("#jogun input").attr('disabled','disabled');
	$("#inputbox input").val('');
	
	console.log("초기화 실행")
}


var pjneedsDetailBtn = {
	init : function(){
		//취소버튼
		pjneedsDetailBtn.cancelBinding();
		//저장버튼
		pjneedsDetailBtn.saveBinding();
	},
	
	cancelBinding : function(){
		$('#cancel_btn').click(function(){
			var pjId = $("#jogun p #pj_id").val();
			
			//저장후 프로젝트 재검색		pjneeds_search.js
			PjneedsSearch();
			
			$("#jogun input[type=text]").val("");
			//저장버튼 비활성화
			$("#submit_btn").attr("disabled","disabled");
			//취소버튼 비활성화
			$("#cancel_btn").attr("disabled","disabled");
			
			//재조회
			getProjectDetail(pjId);
		});
	},
	
	saveBinding : function(){
		$('#submit_btn').click(function(){
			
			var altMsg="저장하시겠습니까?";
			if(confirm(altMsg)){
				var arr = [];
				$("#pj_need_detail #inputbox tbody tr").each(function(k,v){
					var saveTr = {};
					saveTr['pj_id'] = $("#pj_id").val();
					saveTr['pn_num'] = $(v).find("[name=pn_num]").text();
					saveTr['pn_grade'] = $(v).find("select[name=pn_grade]").val();
					saveTr['pn_skill'] = $(v).find("select[name=pn_skill]").val();
					saveTr['pn_day_from'] = $(v).find("input[name=needstartday]").val();
					saveTr['pn_day_to'] = $(v).find("input[name=needendday]").val();
					
					arr.push(saveTr);
				});
				$.ajax({
					type : "POST",
					url:"/Pjneeds_Insert.action",
					async : false,
					dataType : "json",
					data:{
						pj_id : $("#pj_id").val()
						, pn_num : $("#pn_num").val()
						, list : JSON.stringify(arr)
					},
					success : function() {
						//저장후 프로젝트 재검색		pjneeds_search.js
						PjneedsSearch();
						
						alert("정상적으로 저장되었습니다.")
					},
					error : function(xhr) {
						alert("error html = " + xhr.statusText);
					}
				});
			}
		});
	}
};
/*function calendar() {
	$.datepicker.regional['ko'] = {
		closeText : '닫기',
		prevText : '이전달',
		nextText : '다음달',
		currentText : '오늘',
		monthNames : [ '1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)',
				'5월(MAY)', '6월(JUN)', '7월(JUL)', '8월(AUG)', '9월(SEP)',
				'10월(OCT)', '11월(NOV)', '12월(DEC)' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		weekHeader : 'Wk',
		dateFormat : 'yy-mm-dd',
		firstDay : 0,
		isRTL : false,
		showMonthAfterYear : true,
		yearSuffix : '',
		//         showOn: 'both',
		//         buttonText: "달력",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true,
		yearRange : 'c-99:c+99',
	};
	$.datepicker.setDefaults($.datepicker.regional['ko']);
}*/