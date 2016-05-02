$(document).ready(function() {
	searchCus();
	$('#searchbutton').click(function() {
		searchCus();
	});
	
	// 자동검색
	$("#searchcus").change(function(){searchCus()});
	$("#searchid").keyup(function(){searchCus()});
	
	$('#cancel').click(function() {
		var name = document.getElementById("customer_name");
		name.value = "";
		var name = document.getElementById("customer_div");
		name.value = "";

		var name = document.getElementById("customer_regno");
		name.value = "";

		var name = document.getElementById("customer_credit");
		name.value = "";
		var name = document.getElementById("h_name");
		name.value = "";

		var name = document.getElementById("customer_head");
		name.value = "";
		var name = document.getElementById("customer_loc");
		name.value = "";
		var name = document.getElementById("etc");
		name.value = "";
		var name = document.getElementById("delete");
		name.disabled = true;
	});
	$('#update').click(function() {
		var name = document.getElementById("delete");
		var del
		if (name.disabled == true) {
			del = confirm('정말 입력 하시겠습니까');
		} else {
			del = confirm('정말 수정 하시겠습니까');
		}
		if (del == false) {

		} else {

			$.ajax({
				type : "POST",
				url : "/customerUpdate.action",
				async : false,
				dataType : "json",
				data : {
					customer_div : customer_div.value,
					customer_name : customer_name.value,
					customer_credit : customer_credit.value,
					customer_regno : customer_regno.value,
					customer_head : customer_head.value,
					customer_loc : customer_loc.value,
					h_name : h_name.value,
					etc : etc.value
				},

				success : function() {
					searchCus();
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}
			});
		}
	});

	$('#delete').click(function() {
		var del = confirm('정말 삭제 하시겠습니까');
		if (del == false) {

		} else {
			$.ajax({
				type : "POST",
				url : "/customerDelete.action",
				async : false,
				dataType : "json",
				data : {
					customer_div : customer_div.value,
					h_name : h_name.value
				},

				success : function() {
					searchCus();
				},
				error : function(xhr) {
					alert("error html = " + xhr.statusText);
				}
			});
		}
	});
});

function getCustomerDetail(e) {
	$(e.currentTarget).attr("id");
	var elem = document.getElementById(e);
	var name = elem.children[1].innerHTML;
	var div = elem.children[0].innerHTML;
	name=strip_tags (name, "");
	$.ajax({
		type : "POST",
		url : "/getCustomer.action",
		async : false,
		dataType : "json",
		data : {
			name : name,
			div : div
		},

		success : function(result) {
			var customer_name = result.vo.customer_name;
			var customer_credit = result.vo.customer_credit;
			var customer_regno = result.vo.customer_regno;
			var customer_div = result.vo.customer_div;
			var customer_head = result.vo.customer_head;
			var customer_loc = result.vo.customer_loc;
			var etc = result.vo.etc;

			var name = document.getElementById("customer_name");
			name.value = customer_name;
			var name = document.getElementById("h_name");
			name.value = customer_name;
			var name = document.getElementById("customer_credit");
			name.value = customer_credit;
			var name = document.getElementById("customer_regno");
			name.value = customer_regno;
			var name = document.getElementById("customer_div");
			name.value = customer_div;
			var name = document.getElementById("customer_head");
			name.value = customer_head;
			var name = document.getElementById("customer_loc");
			name.value = customer_loc;
			var name = document.getElementById("etc");
			name.value = etc;
			var name = document.getElementById("delete");
			name.disabled = false;
		},
		error : function(xhr) {
			alert("error html = " + xhr.statusText);
		}
	});
}
function searchCus() {
	
	$.ajax({
				type : "POST",
				url : "/customerSearch.action",
				async : false,
				dataType : "json",
				data : {
					name : $("#searchid").val(),
					div : $("#searchcus").val()
				},

				success : function(search) {
					$
							.each(
									search,
									function(index, item) {

										var html = '<TABLE id="fuck" class="fuck" cellpadding="0" cellspacing="0" border="0">'
										html += '<TR>'
										html += '<TD>'
										html += '<table style="text-align:center"width="480px" cellspacing="1" cellpadding="0" border="0" class="main_table">'
										html += '<tr>';
										html += '<th style="width:100px; height:22px">업 체 구 분</th>';
										html += '<th style="width:247px">고 객 명</th>';
										html += '<th style="width:133px">사업자 번호</th>';
										html += '</tr>';
										html += '</table>'
										html += '</TD>'
										html += '</TR>'
										html += '<TR>'
										html += '<TD>'
										html += '<div style="width: 502px; height: 600px; overflow-y: auto">'
										html += '<table width="484px" cellspacing="1" cellpadding="0" border="0" class="main_table" style="text-align:center">'
										for (var i = 0; i < item.length; i++) {
											var regno = "";
											var id = "140" + i;
											if (item[i].customer_regno != null)
												regno = item[i].customer_regno;
											html += '<tr id='
													+ id
													+ ' onclick=getCustomerDetail('
													+ id
													+ ') style="cursor:pointer">';
											if (item[i].customer_div == 0)
												var div = '수주계약';
											else if (item[i].customer_div == 1)
												var div = '외주업체';
											else
												var div = '상품판매';
											html += '<td style="border-top: 0; width:99px">' + div + '</td>';
											html += '<td style="border-top: 0; width:246px;  text-overflow: ellipsis; overflow: hidden;"><nobr>'
													+ item[i].customer_name
													+ '<nobr></td>';
											html += '<td style="border-top: 0; width:133px">' + regno + '</td>';
											html += '</tr>';

										}
										html += '</table>';

										html += '</div>';
										html += '</TD>';
										html += '</TR>';
										html += '</TABLE>';
										$("#search_result").html(html);

									});

				},
				error : function(xhr) {
					alert("search error html = " + xhr.statusText);
				}
			});
}
function strip_tags (input, allowed) {
    allowed = (((allowed || "") + "").toLowerCase().match(/<[a-z][a-z0-9]*>/g) || []).join(''); // making sure the allowed arg is a string containing only tags in lowercase (<a><b><c>)
    var tags = /<\/?([a-z][a-z0-9]*)\b[^>]*>/gi, commentsAndPhpTags = /<!--[\s\S]*?-->|<\?(?:php)?[\s\S]*?\?>/gi;
    return input.replace(commentsAndPhpTags, '').replace(tags, function ($0, $1) {        return allowed.indexOf('<' + $1.toLowerCase() + '>') > -1 ? $0 : '';
    });
}