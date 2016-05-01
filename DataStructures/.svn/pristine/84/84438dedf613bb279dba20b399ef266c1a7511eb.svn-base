var SetComma = function(str) {
	str = str.replace(/,/g, '');
	var arry;
	var datt="";
	var chd="";
	var retValue = "";
	if(str.indexOf('.') > -1){
		arry=str.split(".");
		chd=arry[0];
		datt=arry[1];
	}
	else{
		chd+=str;
	}
	for (i = 1; i <= chd.length; i++) {
		if (i > 1 && (i % 3) == 1)
			retValue = chd.charAt(chd.length - i) + "," + retValue;
		else
			retValue = chd.charAt(chd.length - i) + retValue;
	}
	if(str.indexOf('.') > -1)
		retValue=retValue+"."+datt;
	
	return retValue;
}
var SetComma1 = function(str) {
	str = str.replace(/,/g, '');
	var arry;
	var datt="";
	var chd="";
	var retValue = "";
	if(str.indexOf('.') > -1){
		arry=str.split(".");
		chd=arry[0];
		datt=arry[1];
	}
	else{
		chd+=str;
	}
	for (i = 1; i <= chd.length; i++) {
		if (i > 1 && (i % 3) == 1)
			retValue = chd.charAt(chd.length - i) + "," + retValue;
		else
			retValue = chd.charAt(chd.length - i) + retValue;
	}
	if(str.indexOf('.') > -1)
		retValue=retValue+"."+datt;
	
	return retValue;
}

$(document).ready(function(){

	$('#team_div').setTeamdiv({});	
	$('#teamsearch').setSearchTeamdiv({all:true});
	$("#area").setAreadiv({});
	$("#searchid").focus();
	
	// 자동 검색 2015-01-27 추가 
	$("#searchid").keyup(function(){projectSearch()});
	$("#searchteam").change(function(){projectSearch()});
	$("#searchprog").change(function(){projectSearch()});
	
	insertpjActionBinding.searchBinding();
	insertpjActionBinding.cancelBinding();
	insertpjActionBinding.updateBinding();
	insertpjActionBinding.deleteBinding();
	
	projectSearch();
	
	//프로젝트 현황에서 넘어왔을 경우.
	var hid = $("#searchid").val();
	if(hid != null && hid != undefined && hid != ""){
		getProjectDetail(hid);
		return;
	}
	
//	$('#searchbutton').trigger('click');
	
	
}); 
	


function getProjectDetail(pjId){
	
        $(":checkbox[name='pj_require']:checkbox").each(function() {
            $(this).attr("checked", false);
        });

	$.ajax({
		type : "POST",
		url:"/getProject",
		async : false,
		dataType : "json",
		data:{				
			pj_id : pjId
		},

		success : function(project) {
//			debugger;
			var team_id=project.vo.team_id;
			var pj_id=project.vo.pj_id;
			var pj_name=project.vo.pj_name;
			var customer_name=project.vo.customer_name;
			var pj_prog=project.vo.pj_prog;
			var pj_operate=project.vo.pj_operate;
			var pj_start_day=project.vo.pj_start_day;
			var pj_end_day=project.vo.pj_end_day;
			var pj_sqimm=project.vo.pj_sqimm;
			var pj_outmm=project.vo.pj_outmm;
			var budget_contract_sales=project.vo.budget_contract_sales;
			var budget_product_cost=project.vo.budget_product_cost;
			var budget_outsource=project.vo.budget_outsource;
			var pj_loc=project.vo.pj_loc;
			var pj_pm=project.vo.pj_pm;
			var pj_etc=project.vo.pj_etc;	
			var top_customer=project.vo.top_customer;
			var pj_require=project.vo.pj_require?project.vo.pj_require:"";
			//alert(pj_require);
  			$('#team_id').setTeamdiv({hr:false,all:false,selectVal:team_id});	  			
  			var name = document.getElementById("pj_id");
  			name.value=pj_id;
  			name.disabled=true;		
  			var name = document.getElementById("pj_name");
  			name.value=pj_name;
  			var name = document.getElementById("customer_name");
  			name.value=customer_name;
  			name.disabled=false;	
  			var name = document.getElementById("top_customer");
  			name.value=top_customer;
  			var name = document.getElementById("pj_prog");
  			name.value=pj_prog;		  			
  			var name = document.getElementById("pj_operate");
  			name.value=pj_operate;	  				  			
  			var name = document.getElementById("pj_start_day");
  			name.value=pj_start_day;
  			var name = document.getElementById("pj_end_day");			  		
  			name.value=pj_end_day;	  		
  			var name = document.getElementById("pj_sqimm");
  			name.value=pj_sqimm;
  			var name = document.getElementById("pj_outmm");
  			name.value=pj_outmm;	  			
  			var name = document.getElementById("budget_contract_sales");
  			name.value=SetComma(String(budget_contract_sales));	  			
  			var name = document.getElementById("budget_product_cost");
  			name.value=SetComma(String(budget_product_cost));			  			
  			var name = document.getElementById("budget_outsource");
  			name.value=SetComma(String(budget_outsource));
  			
  			if(pj_loc==null || pj_loc=="null" || pj_loc==""){
	  			$("#area").setAreadiv({});				
  			}else{
	  			$("#area").setArea(1,pj_loc,{});	  				
  			}  				
  			var name = document.getElementById("pj_pm");
  			name.value=pj_pm;
  			var name = document.getElementById("pj_etc");
  			name.value=pj_etc;	
  			/*var name = document.getElementById("pj_require");
  			name.value=pj_require;	*/	
  			//alert(pj_require);
  		//	alert(pj_require.length);
  			var cmv;
  		    for(var i=0;i<pj_require.length;i++){
  		 
  		    	cmv=pj_require.substring( i,(i+1) );
  		    	
  		    	$(":checkbox[name='pj_require'][value=" +cmv+ "]").attr('checked','checked');
  					
  					
  		    }
  			
  			var name= document.getElementById("delete");
  			name.disabled=false;
  			name._visible=true;
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});	
}

// 검색 함수
function projectSearch(){
	$.ajax({
		type : "POST",
		url:"/projectSearch",
		async : false,
		dataType : "json",
		data:{				
			searchid:$("#searchid").val(),
			searchteam:$("#searchteam").val(),
			searchprog:$("#searchprog").val()
		},

		success : function(search) {		
			$.each(search, function (index, item) {
				var html = '<table width="490px" class="hover" cellspacing="1" cellpadding="0" border="0" style="text-align: center">'; 
				for (var i=0; i<item.length; i++){
					html += "<tr onclick=getProjectDetail('"+item[i].pj_id+"') style='cursor:pointer'>";
					html += '<td style="border-top: 0" width="123px">'+item[i].team_name+'</td>';
					html += '<td style="border-top: 0" width="138px">'+item[i].pj_id+'</td>';				   
					html += '<td style="border-top: 0" width="96px">'+item[i].pj_prog+'</td>';
					html += '<td style="border-top: 0" width="113px" align = right>'+SetComma(String(item[i].budget_contract_sales))+'</td>';
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

var insertpjActionBinding = {
		
	searchBinding: function(){
		$('#searchbutton').click(function(){
			projectSearch();
		});
	},
	cancelBinding: function(){
		$('#cancel').click(function(){
			if($("#h_id").val()==""){
				insertpjActionBinding.clearDetailData();

				var name = document.getElementById("pj_id");
				name.disabled=false;		
				var name= document.getElementById("delete");
				name.disabled=true;
				name._visible=false;
			}
			else {
				var url = "bizList.iqspf"; 
				$(location).attr('href',url);
			}
		});
	},
	updateBinding: function(){
		
		$('#update').click(function(){
			var envclass="";
			/*$("#getCheckedAll").click(function() {
				$("input[name=pj_require]:checked").each(function() {
					 envclass= $(this).val();
					console.log(envclass);
				});
			});*/
			$(":checkbox[name='pj_require']:checked").each(function(){
				
				envclass += $(this).val(); 
				});
			
			if($("#team").val()==""){
				alert("팀명을 입력하세요");
			}
			else if($("#pj_id").val()==""){
				alert("프로젝트 ID를 입력하세요");
			}
			else if($("#pj_name").val()==""){
				alert("프로젝트 명을 입력하세요");
			}
			else if($("#pj_start_day").val()==""){
				alert("시작일을 입력하세요");
			}
			else if($("#pj_end_day").val()==""){
				alert("종료일을 입력하세요");
			}
			else if($("#budget_contract_sales").val()==""){
				alert("계약액을 입력하세요")
			}
			else {
				var name= document.getElementById("delete");
				var altMessage = '수정 하시겠습니까';
				
				if(name.disabled==true){
					altMessage = '저장 하시겠습니까';		
				}
				
				if(confirm(altMessage)){
					$.ajax({
						type : "POST",
						url:"/projectUpdate",
						async : false,
						dataType : "json",
						data:{
							team_id: $('#team').val(),
							pj_id: pj_id.value,
							pj_name: pj_name.value,
							customer_name: customer_name.value,
							top_customer:top_customer.value,
							pj_prog: pj_prog.value,
							pj_operate: pj_operate.value,
							pj_start_day: pj_start_day.value,
							pj_end_day: pj_end_day.value,
							pj_sqimm: pj_sqimm.value,
							pj_outmm: pj_outmm.value,
							budget_contract_sales: budget_contract_sales.value,
							budget_product_cost: budget_product_cost.value,
							budget_outsource : budget_outsource.value,
							pj_loc: getAreaVal(),
							pj_pm: pj_pm.value,
							pj_etc: pj_etc.value,
							pj_require: envclass
						},
						success : function() {
							$('#searchbutton').trigger('click');
							alert("저장되었습니다.");
						},
						error : function(xhr) {
							alert("error html = " + xhr.statusText);
						}			
					});
				}
			}
		});
	},
	deleteBinding: function(){
		$('#delete').click(function(){
			if(confirm('삭제 하시겠습니까')){
				$.ajax({
					type : "POST",
					url:"/projectDelete",
					async : false,
					dataType : "json",
					data:{
						pj_id: pj_id.value
					},
	
					success : function() {	
						$('#searchbutton').trigger('click');
						insertpjActionBinding.clearDetailData();
						
						var name = document.getElementById("pj_id");
						name.disabled=false;
						var name= document.getElementById("delete");
						name.disabled=true;
						name._visible=false;
						
						alert("삭제되었습니다.");	
					},
					error : function(xhr) {
						alert("error html = " + xhr.statusText);
					}			
				});
			}
		});	
		if($("#h_id").val()!=""){
			$.ajax({
				type : "POST",
				url:"/getProject",
				async : false,
				dataType : "json",
				data:{				
					pj_id : searchid.value
				},

				success : function(project) {
					var team_id=project.vo.team_id;
					var pj_id=project.vo.pj_id;
					var pj_name=project.vo.pj_name;
					var customer_name=project.vo.customer_name;
					var pj_prog=project.vo.pj_prog;
					var pj_operate=project.vo.pj_operate;
					var pj_start_day=project.vo.pj_start_day;
					var pj_end_day=project.vo.pj_end_day;
					var pj_sqimm=project.vo.pj_sqimm;
					var pj_outmm=project.vo.pj_outmm;
					var budget_contract_sales=project.vo.budget_contract_sales;
					var budget_product_cost=project.vo.budget_product_cost;
					var budget_outsource=project.vo.budget_outsource;
					var pj_loc=project.vo.pj_loc;
					var pj_pm=project.vo.pj_pm;
					var pj_etc=project.vo.pj_etc;	
					var pj_require=project.vo.pj_require?project.vo.pj_require:"";
					var top_customer=project.vo.top_customer;
					
		  			$('#team_div').setTeamdiv({hr:false,all:false,selectVal:team_id});	
		  			
		  			if(pj_loc==null){
			  			$("#area").setAreadiv({});				
		  			}else{
			  			$("#area").setArea(1,pj_loc,{});	  				
		  			}
		  			
		  			var name = document.getElementById("pj_id");
		  			name.value=pj_id;
		  			name.disabled=true;		
		  			var name = document.getElementById("pj_name");
		  			name.value=pj_name;
		  			var name = document.getElementById("customer_name");
		  			name.value=customer_name;
		  			name.disabled=false;	
		  			var name = document.getElementById("top_customer");
		  			name.value=top_customer;
		  			var name = document.getElementById("pj_prog");
		  			name.value=pj_prog;		  			
		  			var name = document.getElementById("pj_operate");
		  			name.value=pj_operate;	  				  			
		  			var name = document.getElementById("pj_start_day");
		  			name.value=pj_start_day;
		  			var name = document.getElementById("pj_end_day");			  		
		  			name.value=pj_end_day;	  		
		  			var name = document.getElementById("pj_sqimm");
		  			name.value=pj_sqimm;
		  			var name = document.getElementById("pj_outmm");
		  			name.value=pj_outmm;	  			
		  			var name = document.getElementById("budget_contract_sales");
		  			name.value=SetComma(String(budget_contract_sales));	  			
		  			var name = document.getElementById("budget_product_cost");
		  			name.value=SetComma(String(budget_product_cost));			  			
		  			var name = document.getElementById("budget_outsource");
		  			name.value=SetComma(String(budget_outsource));
		  			var name = document.getElementById("pj_pm");
		  			name.value=pj_pm;
		  			var name = document.getElementById("pj_etc");
		  			name.value=pj_etc;	
		  			var name = document.getElementById("pj_require");
		  			name.value=pj_require;	
		  			
		  			var name= document.getElementById("delete");
		  			name.disabled=false;
		  			name._visible=true;
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}			
			});	
		}
	},
	clearDetailData: function(){
		$("#area").setAreadiv({});
		$("#team_id").setTeamdiv({});

		var name = document.getElementById("pj_id");
		name.value="";
		var name = document.getElementById("pj_name");
		name.value="";
		var name = document.getElementById("customer_name");
		name.value="";
		var name = document.getElementById("pj_prog");
		name.value="";	  			
		var name = document.getElementById("pj_operate");
		name.value="";	  				  			
		var name = document.getElementById("pj_start_day");
		name.value="";
		var name = document.getElementById("pj_end_day");			  		
		name.value="";  		
		var name = document.getElementById("pj_sqimm");
		name.value="";
		var name = document.getElementById("pj_outmm");
		name.value="";	  			
		var name = document.getElementById("budget_contract_sales");
		name.value="";  			
		var name = document.getElementById("budget_product_cost");
		name.value="";		  			
		var name = document.getElementById("budget_outsource");
		name.value="";
		var name = document.getElementById("pj_pm");
		name.value="";
		var name = document.getElementById("pj_etc");
		name.value="";	
		var name = document.getElementById("pj_require");
  		name.value="";
		var name = document.getElementById("top_customer");
		name.value="";	
	}
};