$(document).ready(function(){
	initUploadForm(0);
});

$('input[name=FileContent]').change(function () {
	
	initUploadForm(0);
});

$('input[name=MainFileContent]').change(function () {
	
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
				    	$('input#mainUrl').attr('value',$('#mainUrl').value()+','+ret.data.download_url);
			    	}
			    	else{
			    		$('div#uploadImg').append('<img src="'+ret.data.download_url+'"></img>');
				    	$('input#allUrl').attr('value',$('#allUrl').value()+','+ret.data.download_url);
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
			$('#uploadForm').ajaxForm(options);
	});	
}

