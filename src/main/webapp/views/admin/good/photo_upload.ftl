<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->


<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>上传详情图片</h2>
		<ol class="breadcrumb">
			<li><a href="">系统管理</a></li>
			<li><a href="${rootPath}/admin/goods/detail/${(good.id)!}">商品详情</a></li>
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
					<#list photos! as photo>
					<div class="file-box">
						<div class="photos">
							<a href="">

								<div class="image">
									<img alt="image" class="feed-photo"
										src="${photo!("暂无图片")}">
								</div>
								<div class="file-name">
								</div>
							</a>

						</div>
					</div>
					</#list>
					

				</div>
			</div>
		</div>
	</div>
</div>




<!--COMMON FOOTER-->
<#include "../include/footer.ftl">

<script type="text/javascript" src="${rootPath}/resources/js/admin/jquery.form.min.js"></script>


<script>
	var BASE_URL='${rootPath}';
</script>
<script id="uploadScript" type="text/javascript" src="${rootPath}/resources/js/admin/admin.upload.js" data="${(good.id)!}"></script>
<!--COMMON FOOTER-->