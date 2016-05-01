
// 2015.08.26 생성
// resources/js 폴더에 있는 js 파일 중에서 필요해 보이는 기능만 모아놓은 파일
// 빠진 것도 있을 수도 있음..


/**
 * 위치 파일 : bizlist.js, emp_standby.js, insertproject.js, report.js, SetNum.js, teamlist.js
 * 현재 각자 다른 방식으로 구현되어 있음
 * 
 * 입력 값으로 돈(숫자)이 들어 왔을때 
 * 3자리씩 컴마를 insert하는 기능
 * ex) 1000000 -> 1,000,000
 */
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


/**
 * 위치 파일 : customerManager.js , duplicationCheck.js, bizlist.jsp
 * 
 * 문자열에서 html과 php 태그를 제거하는 기능
 * 
 */
function strip_tags (input, allowed) {
    allowed = (((allowed || "") + "").toLowerCase().match(/<[a-z][a-z0-9]*>/g) || []).join(''); // making sure the allowed arg is a string containing only tags in lowercase (<a><b><c>)
    var tags = /<\/?([a-z][a-z0-9]*)\b[^>]*>/gi, commentsAndPhpTags = /<!--[\s\S]*?-->|<\?(?:php)?[\s\S]*?\?>/gi;
    return input.replace(commentsAndPhpTags, '').replace(tags, function ($0, $1) {        
    	return allowed.indexOf('<' + $1.toLowerCase() + '>') > -1 ? $0 : '';
    });
}


/**
 * 위치 파일 : emp_inputck.js
 * 
 * 입력한 date의 keycode를 받아와서 한글만 입력 가능하게 하는 기능
 */
function namekeycheck(mkey) // 키코드값을 매개변수로 받는다
{	
	if ((mkey > 90 || mkey < 97) || mkey > 122) // 키값이 영자나 숫자, 특수기호가 입력되면
												// 경고문출력
	{
		alert("한글만 입력가능합니다.");
		event.returnValue = false; // 리턴값을 false로 주어 문자가 입력되는걸 방지
	
	}

}

/**
 * 위치파일 : emp_inputck.js
 * 
 * 입력한 data의 keycode를 이용해 숫자만 입력 가능하게 하는 기능
 */
function salaykeycheck(){ // 키코드값을 매개변수로 받는다
	var code = window.event.keyCode;
	if((code >=48 && code <=57) || (code >=96 && code <=105) || code == 110 || code == 190 || code ==8 || code == 9 || code ==13 ||code ==46) {
		window.event.returnValue = true;
		return;
	}
	
	alert ("숫자만 입력 가능합니다.");
	window.event.returnValue =false;
}

/**
 * 위치파일 : SetNum.js
 * 
 * keycode를 이용해 숫자만 입력 가능하게 하는 기능
 */
function numkeycheck(){ // 키코드값을 매개변수로 받는다
	var code = window.event.keyCode;

	if((code >=48 && code <=57) || (code >=96 && code <=105) || code == 110 || code == 190 || code ==8 || code == 9 || code ==13 ||code ==46) {
		window.event.returnVallue = true;
		return;
	}
	alert ("숫자만 입력 가능합니다.");
	window.event.returnValue =false;
	$("#pj_operate").val("");
}

/**
 * 위치파일 : SetNum.js
 * 
 * 숫자만 입력가능하게 하는 기능
 * isNumber과 isFloat함수의 차이를 모르겠음...
 */

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

/**
 * 위치파일 : teamlist.js
 * 
 *  / 를 제거하는 기능
 *  ex) 2015/08/26 -> 20150826
 */
var SetInteger = function(str) {

	return str = str.replace(/,/g, '');
}

