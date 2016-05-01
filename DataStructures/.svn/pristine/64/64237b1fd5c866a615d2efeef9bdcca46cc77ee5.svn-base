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

var SetInteger = function(str) {

	return str = str.replace(/,/g, '');
}

$(document).ready(function(){
	setTeam();
	$('#team_mm').keyup(function(){
		team_mem.value=team_mm.value/12;
	});
	$('#delete').click(function(){
		$.ajax({
				type : "POST",
				url:"/teamDelete.action",
				async : false,
				dataType : "json",
				data:{
					team_id :team_id.value
				},
				success : function() {	
					var name = document.getElementById("team_id");
					name.value="";	  
					name.disabled=false;
					var name = document.getElementById("team_name");
					name.value="";
					var name = document.getElementById("team_contract");
					name.value="";
					var name = document.getElementById("team_income");
					name.value="";
					var name = document.getElementById("team_profit_loss");
					name.value="";		  			
					var name = document.getElementById("team_outsource");
					name.value="";	  				  			
					var name = document.getElementById("team_product");
					name.value="";
					var name = document.getElementById("team_perofcost");			  		
					name.value="";	  		
					var name = document.getElementById("team_mm");
					name.value="";
					var name = document.getElementById("team_netincome");
					name.value="";	  			
					var name = document.getElementById("team_bep");
					name.value="";	  			
					var name = document.getElementById("team_netsales");
					name.value="";
					var name = document.getElementById("team_mem");
					name.value="";
					var name = document.getElementById("team_normal_cost");
					name.value="";
					var name= document.getElementById("delete");
					name.disabled=true;
					setTeam();
							
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}			
			});
	})
	$('#update').click(function(){
		if(team_id.value=='')
			alert('팀 ID를 입력하세요')
		else if(team_name.value=='')
			alert('팀 이름을 입력하세요')
		else{
			$.ajax({
				type : "POST",
				url:"/teamUpdate.action",
				async : false,
				dataType : "json",
				data:{
					team_id :team_id.value,
					team_name : team_name.value,
					team_contract : team_contract.value,
					team_income : team_income.value,
					team_profit_loss : team_profit_loss.value,
					team_outsource : team_outsource.value,
					team_product : team_product.value,
					team_perofcost: team_perofcost.value,
					team_mm : team_mm.value,
					team_mem : team_mem.value,
					team_normal_cost : team_normal_cost.value
				},
				success : function(ret) {
					var ret = ret.ret;
					if (ret == 1) {
						alert("수정되었습니다.")
					} else {
						alert("팀 정보가 추가되었습니다.")
					}
					 var name = document.getElementById("team_id");
						name.value="";	
						name.disabled=false;
						var name = document.getElementById("team_name");
						name.value="";
						var name = document.getElementById("team_contract");
						name.value="";
						var name = document.getElementById("team_income");
						name.value="";
						var name = document.getElementById("team_profit_loss");
						name.value="";		  			
						var name = document.getElementById("team_outsource");
						name.value="";	  				  			
						var name = document.getElementById("team_product");
						name.value="";
						var name = document.getElementById("team_perofcost");			  		
						name.value="";	  		
						var name = document.getElementById("team_mm");
						name.value="";
						var name = document.getElementById("team_netincome");
						name.value="";	  			
						var name = document.getElementById("team_bep");
						name.value="";	  			
						var name = document.getElementById("team_netsales");
						name.value="";
						var name = document.getElementById("team_mem");
						name.value="";
						var name = document.getElementById("team_normal_cost");
						name.value="";
						var name= document.getElementById("delete");
						name.disabled=true;
						setTeam();	
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}
			});
			}
	});	
	$('#cancel').click(function(){
		var name = document.getElementById("team_id");
			name.value="";	  		
			name.disabled=false;
			var name = document.getElementById("team_name");
			name.value="";
			var name = document.getElementById("team_contract");
			name.value="";
			var name = document.getElementById("team_income");
			name.value="";
			var name = document.getElementById("team_profit_loss");
			name.value="";		  			
			var name = document.getElementById("team_outsource");
			name.value="";	  				  			
			var name = document.getElementById("team_product");
			name.value="";
			var name = document.getElementById("team_perofcost");			  		
			name.value="";	  		
			var name = document.getElementById("team_mm");
			name.value="";
			var name = document.getElementById("team_netincome");
			name.value="";	  			
			var name = document.getElementById("team_bep");
			name.value="";	  			
			var name = document.getElementById("team_netsales");
			name.value="";
			var name = document.getElementById("team_mem");
			name.value="";
			var name = document.getElementById("team_normal_cost");
			name.value="";
			var name= document.getElementById("delete");
			name.disabled=true;
	});
	$('#team_contract').keyup(function(){
		var name = document.getElementById("team_netincome");
		name.value=(SetInteger(team_contract.value)-SetInteger(team_outsource.value)- SetInteger(team_product.value));
		
	});	
	$('#team_income').keyup(function(){
		var name = document.getElementById("team_netsales");
		name.value=SetInteger(team_income.value)-SetInteger(team_profit_loss.value);	  
	});	
	$('#team_profit_loss').keyup(function(){
		var name = document.getElementById("team_netsales");
		name.value=SetComma(String(SetInteger(team_income.value)-SetInteger(team_profit_loss.value)));	  
		var name = document.getElementById("team_bep");
		name.value=SetComma(String(SetInteger(team_netsales.value)-SetInteger(team_outsource.value)-SetInteger(team_product.value)));	
	});	
	$('#team_outsource').keyup(function(){
		var name = document.getElementById("team_netincome");
		name.value=SetComma(String(SetInteger(team_contract.value)-SetInteger(team_outsource.value)-SetInteger(team_product.value)));	  
		var name = document.getElementById("team_bep");
		name.value=SetComma(String(SetInteger(team_netsales.value)-SetInteger(team_outsource.value)-SetInteger(team_product.value)));	
	});	
	$('#team_product').keyup(function(){
		var name = document.getElementById("team_netincome");
		name.value=SetComma(String(SetInteger(team_contract.value)-SetInteger(team_outsource.value)-SetInteger(team_product.value)));	  
		var name = document.getElementById("team_bep");
		name.value=SetComma(String(SetInteger(team_netsales.value)-SetInteger(team_outsource.value)-SetInteger(team_product.value)));	
	});	
}); 
	
function getTeamDetail(e){
	var team_id = e;
	$.ajax({
		type : "POST",
		url:"/getTeam.action",
		async : false,
		dataType : "json",
		data:{				
			team_id : team_id
		},

		success : function(team) {
			var team_id=team.vo.team_id;
			var team_name=team.vo.team_name;
			var team_contract=team.vo.team_contract;
			var team_income=team.vo.team_income;
			var team_profit_loss=team.vo.team_profit_loss;
			var team_outsource=team.vo.team_outsource;
			var team_product=team.vo.team_product;
			var team_perofcost=team.vo.team_perofcost;
			var team_mm =team.vo.team_mm ;
			var team_mem = team.vo.team_mem;
			var team_normal_cost = team.vo.team_normal_cost;
			
				  			
							var name = document.getElementById("team_id");
							name.value=team_id;	  			
							name.disabled=true;
				  			var name = document.getElementById("team_name");
				  			name.value=team_name;
				  			var name = document.getElementById("team_contract");
				  			name.value=SetComma(String (team_contract));
				  			var name = document.getElementById("team_income");
				  			name.value=SetComma(String (team_income));
				  			var name = document.getElementById("team_profit_loss");
				  			name.value=SetComma(String (team_profit_loss));		  			
				  			var name = document.getElementById("team_outsource");
				  			name.value=SetComma(String (team_outsource));	  				  			
				  			var name = document.getElementById("team_product");
				  			name.value=SetComma(String (team_product));
				  			var name = document.getElementById("team_perofcost");			  		
				  			name.value=SetComma(String (team_perofcost));	  		
				  			var name = document.getElementById("team_mm");
				  			name.value=team_mm;
				  			var name = document.getElementById("team_mem");
				  			name.value=team_mem;
				  			var name = document.getElementById("team_normal_cost");
				  			name.value=SetComma(String (team_normal_cost));;
				  			var name = document.getElementById("team_netincome");
				  			name.value=SetComma(String (team_income-team_outsource-team_product));	  			
				  			var name = document.getElementById("team_bep");
				  			name.value=SetComma(String (team_income-team_profit_loss-team_outsource-team_product));	  			
				  			var name = document.getElementById("team_netsales");
				  			name.value=SetComma(String (team_income-team_profit_loss));
				  			var name= document.getElementById("cancel");
							name.disabled=false;
							var name= document.getElementById("update");
							name.disabled=false;
							var name= document.getElementById("delete");
							name.disabled=false;
							
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}			
	});	
}


function getTeamList(e){
	$(e.currentTarget).attr("id");
	var elem = document.getElementById(e);
	var team_id = elem.children[5].innerHTML;
	$.ajax({
		type : "POST",
		url:"/getTeam.action",
		async : false,
		dataType : "json",
		data:{				
			team_id : team_id
		},

		success : function(team) {
			var team_id=team.vo.team_id;
			var team_name=team.vo.team_name;
			var team_contract=team.vo.team_contract;
			var team_income=team.vo.team_income;
			var team_profit_loss=team.vo.team_profit_loss;
			var team_outsource=team.vo.team_outsource;
			var team_product=team.vo.team_product;
			var team_perofcost=team.vo.team_perofcost;
			var team_mm =team.vo.team_mm;
			var team_mem =team.vo.team_mem;
			var team_normal_cost =team.vo.team_normal_cost;
						
				  			var name = document.getElementById("team_id");
				  			name.value=team_id;	  	
				  			name.disabled=true;
				  			var name = document.getElementById("team_name");
				  			name.value=team_name;
				  			var name = document.getElementById("team_contract");
				  			name.value=SetComma(String(team_contract));
				  			var name = document.getElementById("team_income");
				  			name.value=SetComma(String (team_income ));
				  			var name = document.getElementById("team_profit_loss");
				  			name.value=SetComma(String (team_profit_loss));		  			
				  			var name = document.getElementById("team_outsource");
				  			name.value=SetComma(String (team_outsource));	  				  			
				  			var name = document.getElementById("team_product");
				  			name.value=SetComma(String (team_product));
				  			var name = document.getElementById("team_perofcost");			  		
				  			name.value=SetComma(String (team_perofcost));	  		
				  			var name = document.getElementById("team_mm");
				  			name.value=team_mm;
				  			var name = document.getElementById("team_mem");
				  			name.value=team_mem;
				  			var name = document.getElementById("team_normal_cost");
				  			name.value=SetComma(String (team_normal_cost));
				  			var name = document.getElementById("team_netincome");
				  			name.value=SetComma(String (team_income-team_outsource-team_product));	  			
				  			var name = document.getElementById("team_bep");
				  			name.value=SetComma(String (team_income-team_profit_loss-team_outsource-team_product));	  			
				  			var name = document.getElementById("team_netsales");
				  			name.value=SetComma(String (team_income-team_profit_loss));
				  			var name= document.getElementById("cancel");
							name.disabled=false;
							var name= document.getElementById("delete");
							name.disabled=false;
							
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}			
	});	
}
function setTeam()
{
	
	$.ajax({
	type : "POST",
	url:"/teamSearch.action",
	async : false,
	dataType : "json",
	data:{
	},

	success : function(search) {		
		var html = '<p style="margin-top:0px"><팀 선택></p>'; 
	$.each(search, function (index, item) {
		   html += '<table class="hover" >'; 
		   html += '<tr >';
		   html += '<th style="width:120px">팀 이름</th>';
		   html += '<th style="width:120px">계약목표</th>';
		   html += '<th style="width:120px">매출목표</th>';
		   html += '<th style="width:120px">순매출목표</th>';
		   html += '<th style="width:120px">이익목표</th>';
		   html += '</tr>';
		  for (var i=0; i<item.length; i++){
			  var id="140"+i;
			  if(item[i].team_id=="ON" || item[i].team_id=="TT" ){continue;}
					  
			html += '<tr id='+id+' style="cursor:pointer" onclick="getTeamList('+id+')">';
		   html += '<td align = "center">'+item[i].team_name+'</td>';
		   html += '<td align = "right">'+SetComma(String(item[i].team_contract))+'</td>';
		   html += '<td align = "right">'+SetComma(String(item[i].team_income))+'</td>';
		   html += '<td align = "right">'+SetComma(String(item[i].team_income - item[i].team_outsource -item[i].team_product))+'</td>';
		   html += '<td align = "right">'+SetComma(String(item[i].team_profit_loss))+'</td>';
		   html += '<td hidden>'+item[i].team_id+'</td>'
		   html += '</tr>';
		
		      }
		   html += '</table>';
		   $("#left_main").html(html);
		   
		
	});
				
	},
	error : function(xhr) {
		alert("search error html = " + xhr.statusText);
	}			
});

}