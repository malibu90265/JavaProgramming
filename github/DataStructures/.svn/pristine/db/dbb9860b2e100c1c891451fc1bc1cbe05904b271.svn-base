	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if ((charCode > 31 && (charCode < 48 || charCode > 57))&&charCode!=45) {
	    		return false;
	    }
	    return true;
	}
	function isFloat(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        if (charCode == 46)
	        	return true;
	        else 
	    		return false;
	    }
	    return true;
	}
	var SetComma = function(str) {

		str = str.replace(/,/g, '');
		var retValue = "";
		for (i = 1; i <= str.length; i++) {
			if (i > 1 && (i % 3) == 1)
			{
				if(str.charAt(str.length - i)=='-'){
					retValue = str.charAt(str.length - i) + retValue;
					continue;
				}
				retValue = str.charAt(str.length - i) + "," + retValue;
			}
			else
				retValue = str.charAt(str.length - i) + retValue;
		}

		return retValue;
	}
	function numkeycheck(){ // 키코드값을 매개변수로 받는다
		var code = window.event.keyCode;

		if((code >=48 && code <=57) || (code >=96 && code <=105) || code == 110 || code == 190 || code ==8 || code == 9 || code ==13 ||code ==46) {
			window.event.returnVallue = true;
			return;
		}
		alert ("숫자만 입력 가능합니다.");
		window.event.returnValue =false;
		$("#pj_operate").val("");
		/*	$("#emp_phonenum2").val("");
		$("#emp_phonenum3").val("");*/

//		$("#emp_salary").val("");
		}