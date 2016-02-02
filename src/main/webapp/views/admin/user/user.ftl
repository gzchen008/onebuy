<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->


<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>${title!}</h2>
		<ol class="breadcrumb">
			<li><a href="index">系统管理</a></li>
			<li><strong>${title!}</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 内页导航结束 -->
<!--主内容开始-->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-12">
			<div class="wrapper wrapper-content animated fadeInUp">

				<div class="ibox">
					<div class="ibox-title">
						<h5>所有用户</h5>
						<div class="ibox-tools">
						</div>
					</div>
					<div class="ibox-content">
						<div class="row m-b-sm m-t-sm">
							<div class="col-md-1">
								<button type="button" id="loading-example-btn"
									class="btn btn-white btn-sm">
									<i class="fa fa-refresh"></i>刷新
								</button>
							</div>
							<div class="col-md-11">
								<div class="input-group">
									<input type="text" placeholder="请输入商品名称"
										class="input-sm form-control"> <span
										class="input-group-btn">
										<button type="button" class="btn btn-sm btn-primary">
											搜索</button>
									</span>
								</div>
							</div>
						</div>
						<div class="project-list">
							<table class="table table-hover">

								<tbody>
									<#list pager.datas as user>
									
									<tr>
										<td class="project-status">
										
										</td>
										<td class="project-title"><a href="${rootPath}/admin/users/detail/${user.id}">${(user.username)!}</a>
											<br></td>
										<td class="project-completion">
											<small>手机号:${(user.phone)!("无")}</small>
										</td>
										<td class="project-completion">
											微信号:
											${(user.wxOpenid)!("无")}
										</td>
										<td class="project-actions"><a href="${rootPath}/admin/users/detail/${(user.id)!}"
											class="btn btn-white btn-sm"><i class="fa fa-folder"></i>
												查看编辑</a> </td>
										
									</tr>
									</#list>
								</tbody>

							</table>
						</div>
					</div>
					<br />
					
					<#import "../macro/pager.ftl" as page>
					<@page.init pager.pageIndex pager.totalPage "${rootPath}${url!}"/>
					
					
				</div>
			</div>
		</div>
	</div>
<!--COMMON FOOTER-->
<#include "../include/footer.ftl">
<!--COMMON FOOTER-->
<script>
$('li[id$="Li"]').attr('class','');
$('li#userItemLi').attr('class','active');
</script>