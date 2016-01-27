$(document).ready(function(){
	initUploadForm(0);
});

$('input[id=mainImgFile]').change(function () {
	
	initUploadForm(0);
});

$('input[id=imgFile]').change(function () {
	
	initUploadForm(1);
});

function initUploadForm (num) {
	$.getJSON(BASE_URL+'/photo/getsign', function(data) {
		var sign = data.sign;
		var url = data.url + '?sign=' + encodeURIComponent(sign);
		var options = { 
	            type: 'post',
	            url: url,
	            dataType: 'json',
			    success:function(ret) { 
			    	alert('上传图片成功');
			    	if(num==0){
			    		$('div#mainImg').append('<img src="'+ret.data.download_url+'"></img>');
				    	$('input#mainUrl').attr('value',ret.data.download_url);
				    	
			    	}
			    	else{
			    		$('div#uploadImg').append('<img src="'+ret.data.download_url+'"></img>');
				    	$('input#allUrl').attr('value',$('input#allUrl').attr('value')+','+ret.data.download_url);
			    	}
			    	
			    	//alert(ret.data.download_url);
			    	//alert(ret.data.fileid);
			    	//alert(ret.data.url);
			    },
			    error:function (ret) {
			    	alert('上传失败，请重新上传图片:'+ret.responseText);
			    }
			}; 
			// pass options to ajaxForm 
			if(num==0){
				$('#uploadMainForm').ajaxForm(options);
			}
			else{
				$('#uploadForm').ajaxForm(options);
			}
			
			
	});	
}

