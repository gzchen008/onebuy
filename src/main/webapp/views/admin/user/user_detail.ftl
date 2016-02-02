<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->


<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>${title  !}</h2>
		<ol class="breadcrumb">
			<li><a href="index">系统管理</a></li>
			<li><a href="${rootPath}/admin/users">用户管理</a></li>
			<li><strong>用户详情</strong></li>
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
						编辑用户 <small>必填</small>
					</h5>

				</div>
				<div class="ibox-content">
					<form method="get" class="form-horizontal" action="${rootPath}/admin/users/update/${(user.id)!}">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>

							<div class="col-sm-10">
								<input type="text" name="username" class="form-control" value="${(user.username)!("无")}">
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">用户密码</label>
							<div class="col-sm-10">
								<input type="text" name="password" class="form-control" value="${(user.password)!("无")}"> 
								<span class="help-block m-b-none" value=""></span>
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">手机</label>
							<div class="col-sm-10">
								<input type="text" name="phone" class="form-control" value="${(user.phone)!("无")}"> 
								<span class="help-block m-b-none" value=""></span>
							</div>
						</div>
						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<label class="col-sm-2 control-label">微信号</label>
							<div class="col-sm-10">
								<input type="text" name="wxOpenid" class="form-control" value="${(user.wxOpenid)!("无")}"> 
								<span class="help-block m-b-none" value=""></span>
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