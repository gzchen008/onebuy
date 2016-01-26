<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->


<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>上传详情图片</h2>
		<ol class="breadcrumb">
			<li><a href="">系统管理</a></li>
			<li><a href="${rootPath}/admin/goods/detail/${(good.id)!}"></a>商品详情</li>
			<li><strong>上传详情图片</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 内页导航结束 -->

<div class="wrapper wrapper-content">
	<div class="row">
		<div class="col-lg-3">
			<div class="ibox float-e-margins">
				<div class="ibox-content">
					<div class="file-manager">
						<h5>显示：</h5>

						<div class="hr-line-dashed"></div>
						<form id="uploadForm">
							<input type="file" id="imgFile" name="FileContent" value="浏览" class="btn-rounded"></input> 
							<input type="submit" value="上传"/>
						</form>
						<div class="hr-line-dashed"></div>

						<h5 class="tag-title">标签</h5>

						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-9 animated fadeInRight">
			<div class="row">
				<div class="col-lg-12">

					<div class="file-box">
						<div class="photos">
							<a href="file_manager.html#">

								<div class="image">
									<img alt="image" class="feed-photo"
										src="${rootPath}/upload/goods/iphone6s.jpg">
								</div>
								<div class="file-name">
									Italy street.jpg <br> <small>添加时间：2014-10-13</small>
								</div>
							</a>

						</div>
					</div>
					<div class="file-box">
						<div class="photos">
							<a href="file_manager.html#"> <span class="corner"></span>

								<div class="image">
									<img alt="image" class="img-responsive" src="">
								</div>
								<div class="file-name">
									My feel.png <br> <small>添加时间：2014-10-13</small>
								</div>
							</a>
						</div>
					</div>
					<div class="file-box">
						<div class="photos">
							<a href="file_manager.html#"> <span class="corner"></span>

								<div class="icon">
									<i class="fa fa-music"></i>
								</div>
								<div class="file-name">
									Michal Jackson.mp3 <br> <small>添加时间：2014-10-13</small>
								</div>
							</a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>




<!--COMMON FOOTER-->
<#include "../include/footer.ftl">
<script type="text/javascript" src="${rootPath}/resources/js/admin/jquery.form.min.js"></script> 
<script>
var url;
$(document).ready(function(){
	initUploadForm();
});

$('input[name=FileContent]').change(function () {
	initUploadForm();
});

function initUploadForm () {
	$.getJSON('${rootPath}/pic/getsign', function(data) {
		var sign = data.sign;
		url = data.url + '?sign=' + encodeURIComponent(sign);
		var options = { 
	            type: 'post',
	            url: url,
	            dataType: 'json',
			    success:function(ret) { 
			    	uploadImgUrl(ret.data.download_url);
			    	//alert(ret.data.download_url);
			    	//alert(ret.data.fileid);
			    	//alert(ret.data.url);
			    },
			    error:function (ret) {
			    	alert('上传失败，请重试:'+ret.responseText);
			    }
			}; 
			// pass options to ajaxForm 
			$('#uploadForm').ajaxForm(options);
	});	
}


function uploadImgUrl(downloadurl){
	$.ajax({
		type:'POST',
		url:'${rootPath}/pic/uploadPicUrl',
		data:{
			'goodId':'${(good.id)!}',
			'downloadUrl':downloadurl
		},
		dateType : 'json',
		success:function(data){
			if(data.code==0){
	    		alert("上传头像成功");
			}
			else if(data.code==1)
				alert("上传失败，请重试");
		}
	});
}
</script>

<!--COMMON FOOTER-->