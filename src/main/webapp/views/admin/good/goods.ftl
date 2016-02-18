<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->


<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>商品管理</h2>
		<ol class="breadcrumb">
			<li><a href="index">系统管理</a></li>
			<li><strong>商品管理</strong></li>
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
						<h5>所有商品</h5>
						<div class="ibox-tools">
							<a href="${rootPath}/admin/goods/create" class="btn btn-primary btn-xs">创建新商品</a>
						</div>
					</div>
					<div class="ibox-content">
						<div class="row m-b-sm m-t-sm">
							
							<div class="col-md-12">
								<div class="input-group">
									<form id="searchForm" method="get" action="${rootPath}/admin/goods/search">
									<input type="text" name="goodName" placeholder="请输入商品名称" value=""
										class="input-sm form-control">
									</form> 
									<span class="input-group-btn">
										<a onclick="submitForm()" type="button" class="btn btn-sm btn-primary">
									搜索</a>
									</span>
								</div>
							</div>
						</div>
						<div class="project-list">
							<table class="table table-hover">

								<tbody>
									<#list pager.datas as good>
									
									<tr>
										<td class="project-status">
										
										</td>
										<td class="project-title"><a href="${rootPath}/admin/goods/detail/${good.id}">${good.name!}</a>
											<br> <small>创建于${good.time}</small></td>
										<td class="project-completion">
										</td>
										<td class="project-completion">
										<td class="project-actions"><a href="${rootPath}/admin/goods/detail/${good.id}"
											class="btn btn-white btn-sm"><i class="fa fa-folder"></i>
												查看编辑</a> </td>
									</tr>
									</#list>
								</tbody>

							</table>
						</div>
					</div>
					<br />
					<#if pager.totalCount!=0>
					<#import "../macro/pager.ftl" as page>
					<@page.init pager.pageIndex pager.totalPage "${rootPath}/admin/goodsto?page="/>
					<#else> 
					<h2>无商品</h2>
					</#if>
				</div>
			</div>
		</div>
	</div>
<script>
	function submitForm(){
		$('#searchForm').submit();
	}
</script>
<!--COMMON FOOTER-->
<#include "../include/footer.ftl">
<!--COMMON FOOTER-->