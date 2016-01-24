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
						<form enctype="multipart/form-data" method="post"
							action="${rootPath}/admin/goods/upload?id=${good.id}">
							<input class="btn btn-primary btn-block" type="file" name="file" value="上传图片"/> 
							<input class="btn btn-primary btn-block" type="submit" text="submit" />
						</form>
						<img id="headImg" src=""
							class="img-thumbnail" >
						<p>
						<div class="progress">
							<div id="progress" class="progress-bar" role="progressbar"
								aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
								style="width: 0%;"></div>
						</div>
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
<!--COMMON FOOTER-->