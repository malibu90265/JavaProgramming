//한글이 완성 됐는지 체크한다.
// 입력중인글자가 ㄱ,ㄴ,ㄷ,...ㅏㅑㅇ.. 일경우는 저장하지 않음
    function checkLastWord(text) {
        var check = ["ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ",
                        "ㄲ", "ㄸ", "ㅃ", "ㅆ", "ㅉ", "ㅏ", "ㅑ", "ㅓ", "ㅕ", "ㅗ", "ㅛ", "ㅜ", "ㅠ", "ㅡ", "ㅣ", "ㅐ", "ㅒ", "ㅔ", "ㅖ"
                        ,"a","b","c","d","e","f","g","h","i","j","k","l","n","m","o","p","q","r","s","t","u","v","w","x","y","z"];
        for (var i = 0; i < text.length; i++) {
        	var pj_name = text.substring(i,i+1);
        	for(var j=0;j<check.length;j++){
        	if (pj_name == check[j])
                return false;
        	}
        }
        return true;
    }
    
	/**
  	 * 
  	 * @param form : 현재 입력한 form data
  	 * 
  	 * 저장 button을 눌렀을 때
  	 * 현재 form의 모든 입력 값을 검증하는 함수 : 입력 값이 없을 경우 alert! 
  	 * 
  	 */
  	function project_settingNullCheckData(formId){
  		if($(formId).find("#pj_pm").val()==""){
			alert("PM명을 입력하세요!")
			return false;
		}
		if($(formId).find("#pj_loc").val()==""){
			alert("프로젝트 장소를 입력하세요!")
			return false;
		}
		else{
			return true;
		}
  	} 