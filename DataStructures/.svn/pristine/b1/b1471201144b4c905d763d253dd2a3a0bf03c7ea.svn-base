//$(document).ready(function(){
//	$("#mainDisplayRock table tr").each(function(k,v){
//	 $(v).on("mouseover",function(k1,v2){
//	  
//	  $(v).children().css("background-color", "#B2EBF4")
//	  $("#leftDisplay table tr").eq($(v).index()).css("background-color", "#B2EBF4")
//	 })
//	});
//	$("#leftDisplay table tr").each(function(k,v){
//	 $(v).on("mouseover",function(k1,v2){
//	  
//	  $(v).children().css("background-color", "#B2EBF4")
//	  $("#mainDisplayRock table tr").eq($(v).index()).css("background-color", "#B2EBF4")
//		 })
//		});
//	$("#mainDisplayRock table tr").each(function(k,v){
//	 $(v).on("mouseleave ",function(k1,v2){
//	  
//	  $(v).children().css("background-color", "#FFFFFF")
//	  $("#leftDisplay table tr").eq($(v).index()).css("background-color", "#FFFFFF")
//	 })
//	});
//	$("#leftDisplay table tr").each(function(k,v){
//	 $(v).on("mouseleave ",function(k1,v2){
//	  
//	  $(v).children().css("background-color", "#FFFFFF")
//	  $("#mainDisplayRock table tr").eq($(v).index()).css("background-color", "#FFFFFF")
//	 })
//	});
//	
//	//leftDisplay
////			$(".main_table").mouseout(function(){
////		var pj_id=$(this).children().eq(3).children().html();
////			$("tr",".main_table").each(function(k,v){
////				if($(v).children().eq(3).children().html()==pj_id)
////					var ln=($(v).parents().find("tr").length+1)/2+k-2;
////				//$(v).children().css("background-color", "#B2EBF4")
////				console.log($(v).parents().find("tr").eq(ln).html())
////			})
////	})
//	
//})





var SetComma = function(str) {
	str = str.replace(/,/g, '');
	var retValue = "";
	for (i = 1; i <= str.length; i++) {
		if (i > 1 && (i % 3) == 1)
			retValue = str.charAt(str.length - i) + "," + retValue;
		else
			retValue = str.charAt(str.length - i) + retValue;
	}

	return retValue;
}


function check(search) {
	$.ajax({
		type : "POST",
		url : "/bizlist.action",
		async : false,
		dataType : "json",
		data : {
			search : search
		},
		success : function(data) {
			
			var html = '<table width="359px" cellspacing="1" cellpadding="0" border="0" class="main_table">';
			$.each(data.list, function(entryIndex, list) {				
				html += '<tr id="'+list.pj_id+'">';
				html += '<th style="border-top:0; width: 117px">' + list.team_name+ '</th>'; // 팀명
				html += '<td align="center" style="border-top:0; width: 55px">' + list.pj_prog + '</td>';// 상태
				html += '<td align="center" style="border-top:0; width: 81px; text-overflow: ellipsis; overflow: hidden;"><nobr>' + list.state + '</nobr></td>';// 영업단계
				html += '<td style="border-top:0; width: 106px; text-overflow: ellipsis; overflow: hidden;" align="center"><a href="insertproject.iqspf?pj_id='+list.pj_id+'" style="text-decoration: none">' + list.pj_id + "</a></td>";// 프로젝트ID" ;
				html += "</tr>";
			});
			html += "</table>";
			$("#leftDisplay").html(html);
			
			var html = '<table width="1725px" cellspacing="1" cellpadding="0" border="0" class="main_table">';
			$.each(data.list, function(entryIndex, list) {
				var sum=Number(list.pj_sqimm)+Number(list.pj_outmm);
				if (list.pj_pm == null) {
					list.pj_pm = "";
				}
				if (list.pj_etc == null) {
					list.pj_etc = "";
				}
				if (list.top_customer == null) {
					list.top_customer = "";
				}	
				if (list.pj_sqimm == null){
					list.pj_sqimm = "";
				}
				if (list.pj_outmm == null){
					list.pj_outmm = "";
				}
				if (list.customer_name == null){
					list.customer_name = "";
				}
				
				
				html += "<tr>";
				html += '<td align="center" style="border-top:0; border-left:0; width:266px; text-overflow: ellipsis; overflow: hidden;"><a href="insertproject.iqspf?pj_id='+list.pj_id+'" style="text-decoration: none"><nobr>' + list.pj_name + "</nobr></a></td>";// 프로젝트명
				html += '<td align="center" style="border-top:0; width:95px; text-overflow: ellipsis; overflow: hidden;"><nobr>' + list.customer_name + '</nobr></td>';// 발주고객
				html += '<td align="center" style="border-top:0; width:95px; text-overflow: ellipsis; overflow: hidden;"><nobr>' + list.top_customer + '</nobr></td>';// 계약고객
				html += '<td style="border-top:0; width:117px;" align="center">' + list.pj_start_day + "</td>";
				html += '<td style="border-top:0; width:117px;" align="center">' + list.pj_end_day + "</td>";
				html += '<td style="border-top:0; width:50px;" align="right">' + list.pj_period + "</td>";// 기간
				html += '<td style="border-top:0; width:91px;" align="right">' + list.pj_operate + '%' + "</td>";// 수행비율

				html += '<td style="border-top:0; width:96px;" align="right">' + SetComma(String(list.budget_contract_sales)) + "</td>";// 계약액
				html += '<td style="border-top:0; width:95px;" align="right">'+ SetComma(String(list.budget_sales))+"</td>";// 매출액
				html += '<td style="border-top:0; width:95px;" align="right">' + SetComma(String(list.budget_outsource)) + "</td>";// 외주비
				html += '<td style="border-top:0; width:95px;" align="right">' + SetComma(String(list.budget_product_cost)) + "</td>";// 상품비
				html += '<td style="border-top:0; width:95px;" align="right">'+ SetComma(String(list.profit))+"</td>";// 순매출액
				html += '<td style="border-top:0; width:69px;" align="right">'+  sum + " </td>";// 총 MM
				html += '<td style="border-top:0; width:69px;" align="right">' + list.pj_sqimm + "</td>";// 자사MM
				html += '<td style="border-top:0; width:69px;" align="right">' + list.pj_outmm + "</td>";// 외주MM
				html += '<td style="border-top:0; width:105px; text-overflow: ellipsis; overflow: hidden;"	align="center"><nobr>' + list.pj_pm + '</nobr></td>';// PM
				html += '<td style="border-top:0; width:105px; text-overflow: ellipsis; overflow: hidden;" align="center"><nobr>' + list.pj_etc + "</nobr></td>";// 비고
				html += "</tr>";
			});
			html += "</table>";
			$("#mainDisplayRock").html(html);				
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}
