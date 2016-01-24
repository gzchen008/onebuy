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
						<!-- <form enctype="multipart/form-data" method="post"
							action="${rootPath}/admin/goods/upload">
							<input class="btn btn-primary btn-block" type="file" name="file" value="上传图片"/> 
							<input class="btn btn-primary btn-block" type="submit" text="submit" />
						</form> -->
						<div id="uploader" class="wu-example">
    <div id="thelist" class="uploader-list"></div>
    <div class="btns">
        <div id="picker" class="webuploader-container"><div class="webuploader-pick">选择文件</div><div id="rt_rt_1a9p8qb7kgh196f1q971unbh5q1" style="position: absolute; top: 0px; left: 0px; width: 88px; height: 34px; overflow: hidden; bottom: auto; right: auto;"><input type="file" name="file" class="webuploader-element-invisible" multiple="multiple"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div></div>
        <button id="ctlBtn" class="btn btn-default">开始上传</button>
    </div>
    <div id="uploader-demo">
    <!--用来存放item-->
    <div id="fileList" class="uploader-list"></div>
    <div id="filePicker">选择图片</div>
</div>
</div>
						
						<img id="headImg" src=""
							class="img-thumbnail" >
						<p>
						<!-- <div class="progress">
							<div id="progress" class="progress-bar" role="progressbar"
								aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
								style="width: 0%;"></div>
						</div> -->
						<span id="downloadUrl"></span>
						<div id="fileid"></div>
						<div id="url"></div>
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
<script type="text/javascript" src="${rootPath}/resources/js/webuploader.js"></script>
		<!--引入CSS-->
		<link rel="stylesheet" type="text/css" href="${rootPath}/resources/css/webuploader.css">
<script>
var uploader = WebUploader.create({

    // 选完文件后，是否自动上传。
    auto: true,

    // swf文件路径
    swf:'${rootPath}/resources/Uploader.swf',

    // 文件接收服务端。
    server: 'http://localhost:8080/onebuy/admin/goods/upload',

    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#picker',

    // 只允许选择图片文件。
    accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
    }
});
//当有文件添加进来的时候
uploader.on( 'fileQueued', function( file ) {
    var $li = $(
            '<div id="' + file.id + '" class="file-item thumbnail">' +
                '<img>' +
                '<div class="info">' + file.name + '</div>' +
            '</div>'
            ),
        $img = $li.find('img');


    // $list为容器jQuery实例
    $list.append( $li );

    // 创建缩略图
    // 如果为非图片文件，可以不用调用此方法。
    // thumbnailWidth x thumbnailHeight 为 100 x 100
    uploader.makeThumb( file, function( error, src ) {
        if ( error ) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }

        $img.attr( 'src', src );
    }, thumbnailWidth, thumbnailHeight );
});


//文件上传过程中创建进度条实时显示。
uploader.on( 'uploadProgress', function( file, percentage ) {
    var $li = $( '#'+file.id ),
        $percent = $li.find('.progress span');

    // 避免重复创建
    if ( !$percent.length ) {
        $percent = $('<p class="progress"><span></span></p>')
                .appendTo( $li )
                .find('span');
    }

    $percent.css( 'width', percentage * 100 + '%' );
});

// 文件上传成功，给item添加成功class, 用样式标记上传成功。
uploader.on( 'uploadSuccess', function( file ) {
    $( '#'+file.id ).addClass('upload-state-done');
});

// 文件上传失败，显示上传出错。
uploader.on( 'uploadError', function( file ) {
    var $li = $( '#'+file.id ),
        $error = $li.find('div.error');

    // 避免重复创建
    if ( !$error.length ) {
        $error = $('<div class="error"></div>').appendTo( $li );
    }

    $error.text('上传失败');
});

// 完成上传完了，成功或者失败，先删除进度条。
uploader.on( 'uploadComplete', function( file ) {
    $( '#'+file.id ).find('.progress').remove();
});
</script>
<!--COMMON FOOTER-->