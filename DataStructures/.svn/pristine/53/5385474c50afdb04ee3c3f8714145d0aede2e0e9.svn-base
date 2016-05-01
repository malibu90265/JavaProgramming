	/* 	
	 *  data 입력 시	
	 *	한글, 숫자, 영어, 한글+숫자, 한글+영어, 영어+숫자 
	 * 	체크를 위해  정규식을 이용한 함수 모음
	 */		

	// 한글만
	function isHangle(h) {
		  regexp = /^[ㄱ-ㅣ가-힣]+$/;
		  if(!regexp.test(h)){
		    return false;
		  }
		  return true;
	}  
	
	// 숫자만
	function isNumber(n) {
		regexp = /^[0-9]+$/;
		  if(!regexp.test(n)){
		    return false;
		  }
		  return true;
	}
	
	// 영어만
	function isEnglish(e) {
		regexp = /^[A-za-z]+$/;
		  if(!regexp.test(e)){
		    return false;
		  }
		  return true;
	}
	
	// 숫자와 . (정수표현)
	function isNumberDot(e) {
		regexp = /^[0-9]+.[0-9]{2}$/;
		  if(!regexp.test(e)){
			  alert("정수형 숫자로만 입력하세요.\n ex) 3.14 (소수 둘째자리까지)");
		    return false;
		  }
		  return true;
	}
	
	// 숫자 + 영어만
  	function isNumAndEng(ne) {
		  regexp =  /^[A-za-z0-9]+$/g;
		  if(!regexp.test(ne)){
		    return false;
		  }
		  return true;
	} 
	
	// 한글 + 영어만
  	function isHanAndEng(he) {
		  regexp =  /^[ㄱ-ㅣ가-힣A-za-z]+$/g;
		  if(!regexp.test(he)){
		    return false;
		  }
		  return true;
	} 
	// 한글 + 숫자만
  	function isHanAndNum(hn) {
		  regexp =  /^[ㄱ-ㅣ가-힣0-9]+$/g;
		  if(!regexp.test(hn)){
		    return false;
		  }
		  return true;
	} 
  	// 전화번호 	형식 : 033-1234-5678
  	function isPhoneNum(pn) {
		  regexp =  /^[0-9]{2,4}-[0-9]{3,4}-[0-9]{4}$/;
		  if(!regexp.test(pn)){
		    return false;
		  }
		  return true;
	}
  	
  	function mmCheck(input){
		if(!isNumberDot(input.value)){
			input.value = '';
		}
  	}
  	
  	function pnCheck(input){
		if(!isPhoneNum(input.value)){
			alert("전화번호 형식으로 입력하여 주세요. \n  ex) 010-1234-5678");
			input.value = '';
		}
  	}
  	
  	function LengthCheck(obj, length) {
  		if(obj.value.length > (length-1)){
  			alert(length + "자리까지 입력할 수 있습니다.");
  			obj.value="";
  		}
  	}
  	
  	function num_only(obj) {
  		if (event.keyCode != 45 && (event.keyCode != 46) && (event.keyCode != 8) &&(event.keyCode != 9)
  				&& (event.keyCode < 48) || (event.keyCode > 57) && ((event.keyCode < 96) || (event.keyCode > 105))) {
  			event.returnValue = false;
  		}
  		obj.value = obj.value.replace(/[가-힣a-zA-Z]/,'');
  	}
  	
  	/**
  	 * 
  	 * @param form : 현재 입력한 form data
  	 * 
  	 * 저장 button을 눌렀을 때
  	 * 현재 form의 모든 입력 값을 검증하는 함수 : 입력 값이 없을 경우 alert! 
  	 * 
  	 */
  	function isNullCheckData(form){
  		if($(form).find("#pjStatus").val()==""){
			alert("상태 정보를 입력하세요!")
			return false;
		}
		if($(form).find("#pjId").val()==""){
			alert("프로젝트 id를 입력하세요!")
			return false;
		}
		var checkRp = $(form).find("#requirePerson").val();
		if(checkRp=="" || checkRp==0){
			alert("소요인원수를 입력하세요!")
			return false;
		}
  	} 
  	
  	/**
  	 * 
  	 * @param s : 각 입력 field 별 data
  	 * @returns
  	 * 
  	 * 현재 field에 
  	 * data 값이 없을 경우 null
  	 * data가 있을 경우 해당 data 값 return
  	 */
  	function chkNull(s){
		if(s==null || s=='' || s==""){
			return s = null;
		}
		return s;
	}