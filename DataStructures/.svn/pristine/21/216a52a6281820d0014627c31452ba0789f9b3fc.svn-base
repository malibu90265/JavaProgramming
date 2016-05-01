//$("btn").click(function(){
//	alert(123)
//	$("tr","#emptable1").each(function(k,v){
//		if($(v).children().eq(0).find("input").attr("checked") == "checked")
//		{
//			$("#emptable2").append(v);
//		}
//	});
//});
var trcnt=0,trcnt2=0;
function moveUp()
{
	
	$("tr","#ready").each(function(k,v){

		if($(v).children().eq(0).find("input").attr("checked") == "checked"){
	
			var htmladd="";
			htmladd+='<tr>'
			htmladd+='<td style="border-top:0; width: 20px;" align="center">'+$(v).children().eq(0).html()+'</td>';
			htmladd+='<td style="border-top:0; width: 96px;" align="center">'+$(v).children().eq(1).html()+'</td>';
			htmladd+='<td style="border-top:0; width: 40px;" align="center">'+$(v).children().eq(2).html()+'</td>';
			htmladd+='<td style="border-top:0; width: 39px;" align="center">'+$(v).children().eq(3).html()+'</td>';
			if($(v).children().eq(4).html()=="대기"||$(v).children().eq(4).html()=="-"){
				htmladd+='<td style="border-top:0; width: 110px;" align="center"></td>';
			}
			else{
				htmladd+='<td style="border-top:0; width: 110px;" align="center">'+$(v).children().eq(4).html()+'</td>';
			}
			var pj_id=$("#pj_id").html();
			if(pj_id=="") {
				alert("배치 할 프로젝트를 선택하지 않았습니다.")
				$(v).children().eq(0).find("input[type=checkbox]").prop("checked",false);
				return;
			}
			if(pj_id==$(v).children().eq(4).html())
			{	
				alert($(v).children().eq(1).html()+"는(은) 이 프로젝트를 이미 수행 중 입니다.")
				$(v).children().eq(0).find("input[type=checkbox]").prop("checked",false);
			}
			

			else
				{
				trcnt++;
			    var dateId = trcnt;
			    htmladd+='<td style="border-top:0; width: 86px;" align="center"><input style = "width :95%; height:100%;" class="cpstartday"  type="text" disabled value="'+" "+'"/></td>';
			    
			    if($(v).children().eq(5).html()=="-"||$(v).children().eq(4).html()=="대기"||$(v).children().eq(4).html()=="-"){
			    	htmladd+='<td style="border-top:0; width: 87px;" align="center"><input style = "width :95%; height:100%;" class="cpendday"  type="text" disabled/></td>';
			    }else{
			    	htmladd+='<td style="border-top:0; width: 87px;" align="center"><input style = "width :95%; height:100%;" class="cpendday"  type="text" disabled value="'+$(v).children().eq(5).html() +'"/></td>';
			    }
				
				htmladd+='<td hidden style="border-top:0; width: 119px;" align="center"><input style = "width :95%; height:100%;"  type="text" disabled value="'+$(v).children().eq(6).html() +'" /></td>';
				htmladd+='<td style="border:0; background-coler:white; width: 29px;" align="center"></td>';
				htmladd+='<td style="border-top:0; width: 101px;" align="center">'+$("#pj_id").html()+'</td>';
				htmladd+='<td style="border-top:0; width: 86px;" align="center"><input style = "width :95%; height:100%;" class="apstartday" id="'+dateId+'" type="text"  /></td>';
				trcnt++;
			    dateId = trcnt;
				htmladd+='<td style="border-top:0; width: 86px;" align="center"><input style = "width :95%; height:100%;"  class="apendday" id="'+dateId+'"  type="text"   /></td>';
				//htmladd+='<td  align="center">'+$(v).children().eq(6).html()+'</td>';
				htmladd+='<td style="border-top:0; width: 104px; align="center"><input style = "width :95%; height:100%;" type="text" value="'+$(v).children().eq(10).html() +'"/></td>';
				htmladd+='<td style="border-top:0; width: 144px; align="center" text-align="center">'+$(v).children().eq(11).html()+'</td>';
				
						
				htmladd +='<td hidden>'+$(v).children().eq(8).html()+'</td>';
				htmladd +='<td hidden>'+$(v).children().eq(9).html()+'</td>';
			
				htmladd+='<td hidden id="state">move</td>'
			
			
				htmladd+='</tr>';
				for(var k in deletelist) if(k==$(v).children().eq(1).html())delete deletelist[k];
				
				//var a1=$(".apstartday").attr("id").val();
			//	var a2=$(".apendday").attr("id");
			//	alert(a1);
			//	alert(a2);
				/*$("#posting2").append(htmladd);
				$(".cpendday").datepicker();
				
				$(".apstartday").datepicker();
				$(".apstartday").datepicker("option", "maxDate", $(".apendday").val());
				$(".apstartday").datepicker("option", "onClose", function(selectedDate) {
					$(".apendday").datepicker("option", "minDate", selectedDate);
				});

				$(".apendday").datepicker();
				$(".apendday").datepicker("option", "minDate", $(".apstartday").val());
				$(".apendday").datepicker("option", "onClose", function(selectedDate) {
					$(".apstartday").datepicker("option", "maxDate", selectedDate);
				});*/
				
				$("#posting2").append(htmladd);
			$(".cpendday").datepicker();
				
				$("#"+(dateId-1)).datepicker();
				$("#"+(dateId-1)).datepicker("option", "maxDate", $("#"+dateId).val());
				$("#"+(dateId-1)).datepicker("option", "onClose", function(selectedDate) {
					$("#"+dateId).datepicker("option", "minDate", selectedDate);
				});

				$("#"+dateId).datepicker();
				$("#"+dateId).datepicker("option", "minDate", $("#"+(dateId-1)).val());
				$("#"+dateId).datepicker("option", "onClose", function(selectedDate) {
					$("#"+(dateId-1)).datepicker("option", "maxDate", selectedDate);
				});
				//alet()
				$(v).children().eq(0).find("input[type=checkbox]").prop("checked",false);
				if ($(v).children().eq(1).html() !='')
					$(v).remove();

			}
			
			
			

		}
	});
}

function moveDown()
{
	$("tr","#posting2").each(function(k,v){
		if($(v).children().eq(0).find("input").attr("checked") == "checked")
		{
			var name = document.getElementById('pj_end_day');
			var pj_end_day = Number((name.value).replace(/-/g, ''));
			var cpendday = Number(($(v).children().eq(5).find("input").val()).replace(/-/g, ''));
		  
	/*
			if($(v).children().eq(4).html()==$("#pj_id").html() ){
				
				alert($(v).children().eq(1).html()+"는(은)  현재 프로젝트를 수행하고 있으므로 이동할 수 없습니다." + "\n" +
						"만료일 이전 일을 선택 후 저장 하시면 해당 날짜 이후 자동으로 빠지게 되며"+ "\n"+
						"오늘 또는 오늘 이전 날짜를 입력 후 저장을 하시면 현재 프로젝트에서 빠지게 됩니다.")
				$(v).children().eq(0).find("input[type=checkbox]").prop("checked",false);
				
				
				/* alert($(v).children().eq(1).html()+"는(은)  현재 "+$(v).children().eq(5).find("input").val()+"~"+$(v).children().eq(6).find("input").val()
				 +"에 \n"+$(v).children().eq(4).html()+"프로젝트를 수행하고 있습니다." + "\n" +
						"배치를 취소하시겠습니까 ? "+ "\n"+
						"(배치 취소를 완료하려면 저장버튼을 클릭해주세요.)")
				 
			}*/
			
				// 배치 예정인 사람은 alert이 뜨지않는데 이미 투입된 사람의 alert의 취소시 에러 나는거 해결 ->  count 
				var count=0;
				if($(v).children().eq(4).html()==$("#pj_id").html() ){
				//프로젝트를 진행중인 사람이 배치를 취소하려 할때 뜨는 alert 
					var altMsg=$(v).children().eq(1).html()+"는(은)  현재 "+$(v).children().eq(5).find("input").val()+"~"+$(v).children().eq(6).find("input").val()
				 +"에 \n"+$(v).children().eq(4).html()+"프로젝트를 수행하고 있습니다." + "\n" +
						"배치를 취소하시겠습니까 ? "+ "\n"+
						"(배치 취소를 완료하려면 저장버튼을 클릭해주세요.)";
					count++;
				}

			//else {
			if(count==0||confirm(altMsg)==true){
			//if(confirm(altMsg)==true){
					var htmladd="";
					htmladd+='<tr bgcolor="#C7C4FF">'
						htmladd+='<td style="border-top:0; width: 21px;" align="center">'+$(v).children().eq(0).html()+'</td>';
						htmladd+='<td style="border-top:0; width: 106px;" align="center">'+$(v).children().eq(1).html()+'</td>';
						htmladd+='<td style="border-top:0; width: 72px;" align="center">'+$(v).children().eq(2).html()+'</td>';
						htmladd+='<td style="border-top:0; width: 72px;" align="center">'+$(v).children().eq(3).html()+'</td>';
						htmladd+='<td style="border-top:0; width: 120px;" align="center">'+$(v).children().eq(4).html()+'</td>';
//						htmladd+='<td style="border-top:0; width: 97px;" align="center">'+$(v).children().eq(5).find("input").val()+'</td>';
						htmladd+='<td style="border-top:0; width: 115px;" align="center">'+$(v).children().eq(6).find("input").val()+'</td>';
						htmladd+='<td hidden style="border:0; width: 18px;" align="center">'+$(v).children().eq(7).find("input").val()+'</td>';
						htmladd+='<td style="border:0; background-coler:white; width: 75px;" align="center"></td>';
					//	htmladd+='<td  align="center">'+$(v).children().eq(9).find("input").val()+'</td>';
						
						var pj_id=$("#pj_id").html();
						//선택한 프로젝트와 현재 프로젝트와 같을때, 배치 취소 할 경우 pj_history 에서 삭제하기 위해  현재 프로젝트 id를 가져감 
						if(pj_id==$(v).children().eq(4).html() && $(v).children().eq(16).html()=="fixed")
							deletelist[$(v).children().eq(1).html()]=$(v).children().eq(4).html()+","+$(v).children().eq(2).html();
						//선택한 프로젝트와 배치예정 프로젝트와 같을때, 배치 취소 할 경우 pj_history 에서 삭제하기 위해 배치예정프로젝트 id를 가져감 
						else if
						(pj_id==$(v).children().eq(9).html() && $(v).children().eq(16).html()=="fixed")
							deletelist[$(v).children().eq(1).html()]=$(v).children().eq(9).html()+","+$(v).children().eq(2).html();
						
						// 선택된 해당 프로젝트에 배치 되지 않은 경우 move down 시 인력의 원래 배치 프로젝트를 배치대상자 필드에서 출력하기 위하여 
						if ($(v).children().eq(14).html() == $(v).children().eq(9).html()){
							//해당 PJ로 저장 된 경우
							htmladd+='<td style="border-top:0; width: 120px;" align="center">'+$(v).children().eq(9).html()+'</td>';
							htmladd+='<td style="border-top:0; width: 97px;" align="center">'+$(v).children().eq(10).find("input").val()+'</td>';
						} else {
							//move만 한 경우(검색이 아닌 배치대상자에서 up,down했을 경우 데이터가 본래 존재X)
							htmladd+='<td style="border-top:0; width: 120px;" align="center">'+$(v).children().eq(14).html()+'</td>';
							htmladd+='<td style="border-top:0; width: 97px;" align="center">'+$(v).children().eq(15).html()+'</td>';
						}
						htmladd+='<td style="border-top:0;" align="center">'+$(v).children().eq(12).find("input").val()+'</td>';
						htmladd+='<td style="border-top:0; width: 135px;" align="center">'+$(v).children().eq(13).html()+'</td>';
						htmladd+='</tr>';
						
						
						//alert(deletelist);
						console.log(htmladd)
						//$("#posting1_tbd").append(htmladd);
						
						//move down 시 배치대상자 list의 가장 상단에 옴 
						$("#posting1_tbd_movedown").append(htmladd);
						$(v).remove();
					
				}
				
		//	}
			
		}
	});
}
//$(document).ready(function(){
//	calendar1();
//});
function calendar1() {
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

	
}
function OpenWindow(url, intWidth, intHeight) {
	winObject = window.open(url, "_blank", "width=" + intWidth + ",height="
			+ intHeight + ", resizable=no, scrollbars=no");
}



