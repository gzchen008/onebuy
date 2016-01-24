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
			<li><strong>编辑商品</strong></li>
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
						编辑商品 <small>必填</small>
					</h5>

				</div>
				<div class="ibox-content">
					<form method="get" class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">商品名称</label>

							<div class="col-sm-10">
								<input type="text" class="form-control" value="${good.name}">
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">商品描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"> <span
									class="help-block m-b-none" value="${(good.description)!("无")}"></span>
							</div>
						</div>
						<div class="hr-line-dashed"></div>

						<div class="row">
						<div class="col-sm-2">
						<form enctype="multipart/form-data" method="post"
							action="${rootPath}/admin/goods/upload">
							<input class="btn btn-primary btn-block" type="file" name="file" value="上传图片"/> 
							<input class="btn btn-primary btn-block" type="submit" text="submit" />
						</form>
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
		</div>
	</div>
</div>
<!--COMMON FOOTER-->
<#include "../include/footer.ftl">
<!--COMMON FOOTER-->