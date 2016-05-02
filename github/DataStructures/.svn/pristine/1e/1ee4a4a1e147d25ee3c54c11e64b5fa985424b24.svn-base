$(document).ready(function() {
	binding.init();
	
	//initView();
	bizmailSearch();
	//2015-01-27 자동검색 추가
	$("#pj_prog").change(function(){bizmailSearch()});
	$("#biz_stat").change(function(){bizmailSearch()});
	$("#team").change(function(){bizmailSearch()});
	$("#pj_id").keyup(function(){bizmailSearch()});
});

/*function initView(){
	$('#searchbutton').trigger('click');
}*/

// 검색 함수
function bizmailSearch(){
	$.ajax({
		type : "POST",
		url : "/bizmileSearch.action",
		async : false,
		dataType : "json",
		data : {
			pj_id : $("#pj_id").val(),
			pj_prog : $("#pj_prog").val(),
			biz_stat : $("#biz_stat").val(),
			team_id : $("#team").val()==null?"al":$("#team").val()
		},
		success : function(search) {
			$.each(search, function(index, item) {
				var html = '<table class="hover" width="532px" cellspacing="1" cellpadding="0" border="0" style="text-align: center">';
				for (var i = 0; i < item.length; i++) {
					html += "<tr onclick=getBizmileDetail('" + item[i].pj_id + "') style='cursor:pointer'>";
					html += '<td style="width: 109px; border-top: 0;">' + item[i].team_name + '</td>';
					html += '<td style="width: 169px; border-top: 0;">' + item[i].pj_id + '</td>';
					html += '<td style="width: 121px; border-top: 0;">' + item[i].pj_prog + '</td>';
					html += '<td style="width: 121px; border-top: 0;">' + item[i].biz_stat + '</td>';
					html += '</tr>';
				}
				html += '</table>';
				$("#search_result").html(html);
			});
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}
var binding = {
		init : function(){
			binding.searchBinding();
			binding.cancelBinding();
			binding.updateBinding();
			binding.deleteBinding();
		},
		searchBinding : function(){
			$('#searchbutton').click(function() {
				bizmailSearch();
			});
		},
		cancelBinding : function(){	//영업 마일스톤 초기화.
			$('#cancel').click(function() {
				//영업 마일스톤 입력상자 초기화
				$("#right_main input[type=text]").val("");
				//영업 마일스톤 비활성화
				$("#right_main input").attr("disabled","disabled");
			});
		},
		updateBinding : function(){
			$('#update').click(function() {
				if(afterservice.value!="" && perform.value==""){
					alert("이전 단계가 수행되지 않았습니다.")
				}
				else if(perform.value!="" && contract.value==""){
					alert("이전 단계가 수행되지 않았습니다.")
				}
				else if(contract.value!="" && propose.value==""){
					alert("이전 단계가 수행되지 않았습니다.")
				}
				else if(propose.value!="" && present.value==""){
					alert("이전 단계가 수행되지 않았습니다.")
				}
				else if(present.value!="" && cus_converse.value==""){
					alert("이전 단계가 수행되지 않았습니다.")
				}
				else if(cus_converse.value!="" && needs_anal.value==""){
					alert("이전 단계가 수행되지 않았습니다.")
				}
				else if(needs_anal.value!="" && cus_meet.value==""){
					alert("이전 단계가 수행되지 않았습니다.")
				}
				else{
					$.ajax({
						type : "POST",
						url : "/bizmileUpdate.action",
						async : false,
						dataType : "json",
						data : {
							pj_id : pj_id_ret.value,
							cus_meet : cus_meet.value,
							needs_anal : needs_anal.value,
							cus_converse : cus_converse.value,
							present : present.value,
							propose : propose.value,
							contract : contract.value,
							perform : perform.value,
							afterservice : afterservice.value
						},
						success : function() {
							alert("저장되었습니다.");
							
							initView();
						},
						error : function(xhr) {
							alert("error html = " + xhr.statusText);
						}
					});
				}
			});
		},
		deleteBinding : function(){
			$('#delete').click(function() {
				var del = confirm('정말 삭제 하시겠습니까');
				if (del == false) {

				} else {
					$.ajax({
						type : "POST",
						url : "/projectDelete",
						async : false,
						dataType : "json",
						data : {
							pj_id : pj_id.value
						},
						success : function() {
							$.ajax({
								type : "POST",
								url : "/iqshr/projectSearch",
								async : false,
								dataType : "json",
								data : {
									searchid : $("#searchid").val(),
									searchteam : $("#searchteam").val(),
									searchprog : $("#searchprog").val()
								},
								success : function(search) {
									$.each(search, function(index, item) {
										var html = '<table class="hover" width="532px" cellspacing="1" cellpadding="0" border="0" style="text-align: center">';
										
										for (var i = 0; i < item.length; i++) {
											html += "<tr onclick=getProjectDetail('" + item[i].pj_id + "') style='cursor:pointer'>";
											html += '<td style="width: 109px; border-top: 0;">' + item[i].pj_id + '</td>';
											html += '<td style="width: 169px; border-top: 0;">' + item[i].team_id + '</td>';
											html += '<td style="width: 121px; border-top: 0;">' + item[i].pj_prog + '</td>';
											html += '<td style="width: 121px; border-top: 0;">' + item[i].budget_contract_sales + '</td>';
											html += '</tr>';
										}
										html += '</table>';
										$("#search_result").html(html);
									});
								},
								error : function(xhr) {
									alert("search error html = " + xhr.statusText);
								}
							});
						},
						error : function(xhr) {
							alert("error html = " + xhr.statusText);
						}
					});
				}
			});
		}
};

function getBizmileDetail(pj_id) {
	$.ajax({
		type : "POST",
		url : "/getBizMile.action",
		async : false,
		dataType : "json",
		data : {
			"pj_id" : pj_id
		},
		success : function(bizmile) {
			var ret = {
					pj_id_ret		: bizmile.vo.pj_id
					,team_name_ret	: bizmile.vo.team_name
					,cus_meet		: bizmile.vo.cus_meet
					,needs_anal		: bizmile.vo.needs_anal
					,cus_converse	: bizmile.vo.cus_converse
					,present			: bizmile.vo.present
					,propose			: bizmile.vo.propose
					,contract		: bizmile.vo.contract
					,perform			: bizmile.vo.perform
					,afterservice	: bizmile.vo.afterservice
			};
			
			//key, value
			$.each(ret, function(k,v){
				$("#"+k).val(v);
			});
			
			$("#right_main input").removeAttr("disabled","disabled");
			
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}