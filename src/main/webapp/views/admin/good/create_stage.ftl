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
			<li><a href="${rootPath}/admin/goods/detail/${goodId!}">商品详情</a></li>
			<li><strong>开始新一期</strong></li>
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
						开始新一期 <small>必填</small>
					</h5>

				</div>
				<div class="ibox-content">
					<form method="get" class="form-horizontal" action="${rootPath}/admin/goods/stage/creating/${goodId!}">
						<div class="form-group">
							<label class="col-sm-2 control-label">总价格</label>

							<div class="col-sm-10">
								<input type="text" name="totalPrice" class="form-control" >
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">总份数</label>
							<div class="col-sm-10">
								<input type="text" name="quantity" class="form-control"> <span
									class="help-block m-b-none"></span>
							</div>
						</div>
						<div class="hr-line-dashed"></div>
							<div class="form-group">
							<label class="col-sm-2 control-label">截止时间(待)</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"> <span
									class="help-block m-b-none"></span>
							</div>
							</div>
							<div class="hr-line-dashed"></div>
						<div class="row">
						
						</div>
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