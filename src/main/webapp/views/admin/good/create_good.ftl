<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->


<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>${title  !}</h2>
		<ol class="breadcrumb">
			<li><a href="index">系统管理</a></li>
			<li><a href="${rootPath}/admin/goods">商品管理</a></li>
			<li><strong>创建商品</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 内页导航结束 -->
<!--主内容开始-->
<div class="wrapper wrapper-content animated fadeInUp">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>
						创建商品 <small>必填</small>
					</h5>

				</div>
				<div class="ibox-content">
					<form id="createGoodForm" method="get" class="form-horizontal" action="${rootPath}/admin/goods/creating">
						<div class="form-group">
							<label class="col-sm-2 control-label">商品名称</label>

							<div class="col-sm-10">
								<input name="goodName" type="text" class="form-control required" >
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">商品描述</label>
							<div class="col-sm-10">
								<input type="text" name="goodDescription" class="form-control required" > 
								<span class="help-block m-b-none"></span>
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
						<div class="col-sm-2">
							在下方上传商品详情图片
							<input id="allUrl" name="url" type="hidden" value="">
							<input id="mainUrl" name="mainUrl" type="hidden" value="">
						</div>
							
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<button class="btn btn-primary" type="submit">保存内容</button>
								<button class="btn btn-white" type="submit">取消</button>
							</div>
						</div>

					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content">
                            <span>主图片：</span>
                                <form id="uploadMainForm">
								<input type="file" id="mainImgFile" name="FileContent" value="浏览" class="btn-rounded"></input> 
								<input type="submit" value="上传"/>
								</form>
                            </div>
                        </div>
                 </div>
                    
			</div>
			<br/>
			<div id="mainImg" class="col-sm-10">
							
			</div>
			<br/>
			<div class="col-lg-12">
				<span>详情图片：</span>
			</div>
			<form id="uploadForm">
				<input type="file" id="imgFile" name="FileContent" value="浏览" class="btn-rounded"></input> 
				<input type="submit" value="上传"/>
			</form>
			<div id="uploadImg" class="col-sm-10">
							
			</div>
		</div>
	</div>
</div>
<!--COMMON FOOTER-->
<#include "../include/footer.ftl">

<script type="text/javascript" src="${rootPath}/resources/js/admin/jquery.form.min.js"></script>
<script type="text/javascript" src="${rootPath}/resources/js/admin/jquery.validate.min.js"></script>
<script type="text/javascript" src="${rootPath}/resources/js/admin/jquery.metadata.js"></script>
<script type="text/javascript" src="${rootPath}/resources/js/admin/messages_zh.js"></script>

<script>
	$().ready(function() {
		$("#createGoodForm").validate();
	});
	var BASE_URL='${rootPath}';
	
</script>
<script type="text/javascript" src="${rootPath}/resources/js/admin/admin.create_good.upload.js"></script>

<!--COMMON FOOTER-->