function setDate(id) {
	var pj_start_date = $("#pj_start_date"); //프로젝트 시작일
	var pj_end_date = $("#pj_end_date"); //프로젝트 종료일
	var pj_propose_date = $("#pj_propose_date"); //프로젝트 제안일
	var pj_contract_date = $("#pj_contract_date"); //프로젝트 계약일
	var pb_start_date = $("#pb_start_date");//프로젝트 시작일(예산)
	var pb_end_date = $("#pb_end_date");//프로젝트 종료일(예산)
	$.datepicker.regional['ko'] = {
		dateFormat : 'yy-mm-dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
				'10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		yearSuffix : '년',
		showMonthAfterYear : true,
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	};
	$.datepicker.setDefaults($.datepicker.regional['ko']);

	//제안일 선택
	pj_propose_date.datepicker();
	pj_propose_date.datepicker("option", "maxDate",
			pj_contract_date.val());
	pj_propose_date.datepicker(
			"option",
			"onClose",
			function(selectedDate) {
				pj_contract_date.datepicker("option",
						"minDate", selectedDate);
			});
	//계약일 선택
	pj_contract_date.datepicker();
	pj_contract_date.datepicker("option", "minDate",
			pj_propose_date.val());
	pj_contract_date.datepicker("option", "maxDate",
			pj_start_date.val());
	pj_contract_date.datepicker(
			"option",
			"onClose",
			function(selectedDate) {
				pj_propose_date.datepicker("option",
						"maxDate", selectedDate);
				pj_start_date.datepicker("option", "minDate",
						selectedDate);
			});
	//프로젝트 시작일 선택
	pj_start_date.datepicker();
	pj_start_date.datepicker("option", "minDate",
			pj_contract_date.val());
	pj_start_date.datepicker("option", "maxDate",
			pj_end_date.val());
	pj_start_date.datepicker(
			"option",
			"onClose",
			function(selectedDate) {
				pj_end_date.datepicker("option", "minDate",
						selectedDate);
				pj_contract_date.datepicker("option",
						"maxDate", selectedDate);
			});
	//프로젝트 종료일 선택
	pj_end_date.datepicker();
	pj_end_date.datepicker("option", "minDate",
			pj_start_date.val());
	pj_end_date.datepicker(
			"option",
			"onClose",
			function(selectedDate) {
				pj_start_date.datepicker("option", "maxDate",
						selectedDate);
			});
	
	pb_start_date.datepicker();
	pb_start_date.datepicker("option", "maxDate",
			pb_end_date.val());
	pb_start_date.datepicker(
			"option",
			"onClose",
			function(selectedDate) {
				pb_end_date.datepicker("option", "minDate",
						selectedDate);
			});
	
	pb_end_date.datepicker();
	pb_end_date.datepicker("option", "minDate",
			pb_start_date.val());
	pb_end_date.datepicker(
			"option",
			"onClose",
			function(selectedDate) {
				pb_start_date.datepicker("option", "maxDate",
						selectedDate);
			});
	
}



