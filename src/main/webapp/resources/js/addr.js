function sample6_execDaumPostcode(){
    new daum.Postcode({
        oncomplete : function(data){
            var fullAddr='';
            var extraAddr = '';
            if(data.userSelectedType === 'R'){ 
                fullAddr = data.roadAddress;
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ?','+data.buildingName : data.buildingName);
                }
                fullAddr += (extraAddr !== '' ? ' ('+extraAddr+')' : '');
            }else{
                fullAddr = data.jibunAddress;
            }
            $("#post").val(data.zonecode);
            $("#addr").val(fullAddr);
            $("#addrDetail").focus();
        }
    }).open();
}