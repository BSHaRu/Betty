	$.datepicker.setDefaults($.datepicker.regional["ko"]);
	
	const regexBirth = /^\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/; 
	
	 function checkRegex(elP, valP, regexP, messageP, ajaxP){
		if(regexP.test(valP) === false){
			showMessage(elP,messageP,false);
			return false;
		}else if(regexP.test(valP) !== false
					&& ajaxP === null){
			showMessage(elP, "", true);
			return true;
		}else{
			if(ajaxP !== null)ajaxP(elP);
		}
	}
	
	function showMessage(elP,messageP,isCheck){
		$(elP).html(`<sapn style='margin-left:5px;font-size:12px;${isCheck ? 'color:green;' : 'color:red;'}'>${messageP}</span>`);
	}
	
	
	$("#birth").datepicker({
	    dateFormat: 'yy-mm-dd' //달력 날짜 형태
	    ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	    ,autoSize: false
	    ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
	    ,changeYear: true //option값 년 선택 가능
	    ,changeMonth: true //option값  월 선택 가능                
	    ,showAnim: "slideDown"
        ,buttonImage: "${path}/resources/img/assets/datepciekr/ui-icons_444444_256x240.png" // 버튼 이미지
	    ,yearRange: 'c-50:c+50'
	    ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함 
	    ,buttonText: "선택" //버튼 호버 텍스트              
	    ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
	    ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
	    ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
	    ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
	    ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
	    ,minDate: "-50Y"
	    ,maxDate: "0" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	    ,onClose : function(){
			var temVal = $(this).val();
			var message = "생년월일을 선택하세요.";
			var elP = $(this).parent().find(".result");
			boolBirth = checkRegex(elP, temVal, regexBirth, message, null);
		}
	});   
	
	

	$("#reserv").datepicker({
	    dateFormat: 'yy-mm-dd' //달력 날짜 형태
	    ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	    ,autoSize: false
	    ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
	    ,changeYear: true //option값 년 선택 가능
	    ,changeMonth: true //option값  월 선택 가능                
	    ,showAnim: "slideDown"
	    ,buttonImage: "${path}/resources/img/assets/datepciekr/ui-icons_444444_256x240.png" // 버튼 이미지
	    ,yearRange: 'c-0:c+1'
	    ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함 
	    ,buttonText: "선택" //버튼 호버 텍스트              
	    ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
	    ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
	    ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
	    ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
	    ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
	    ,minDate: "+1D"
	    ,maxDate: "+14D" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	}); 