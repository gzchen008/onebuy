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
						<h5>所有期数</h5>
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
									<#list pager.datas as stage>
									
									<tr>
										<td class="project-status">
										<#import "../macro/judge_stage.ftl" as s/>
										<#if (stage.status)??>
											<@s.judge stage.status/>
										<#else>
											<@s.judge 4/>
										</#if>
										
										</td>
										<td class="project-title"><a href="${rootPath}/admin/goods/detail/${stage.good.id}">${(stage.good.name)!}</a>
											<br> <small>创建于${stage.createTime}</small></td>
										<td class="project-completion">
										<small>当前进度：
										<#if stage??>
												${(stage.purchasedQuantity/stage.quantity)?string.percent}
												(${stage.purchasedQuantity}/${stage.quantity})
										</small>
											<div class="progress progress-mini">
												<div style="width: ${(stage.purchasedQuantity/stage.quantity)?string.percent};"
													class="progress-bar"></div>
											</div></td>
										<td class="project-completion">
										总价格:${stage.totalPrice}</td>
										<#else>0
										</#if>
										<td class="project-actions"><a href="${rootPath}/admin/stages/detail/${(stage.id)!}"
											class="btn btn-white btn-sm"><i class="fa fa-folder"></i>
												查看编辑本期</a> </td>
										<td class="project-actions"><a href="${rootPath}/admin/stages/delete/${(stage.id)!}"
											class="btn btn-white btn-sm"><i class="fa fa-folder"></i>
												删除此期</a> </td>
									</tr>
									</#list>
								</tbody>

							</table>
						</div>
					</div>
					<br />
					
					<#import "../macro/pager.ftl" as page>
					<@page.init pager.pageIndex pager.totalPage "${rootPath}${url}"/>
					
					
				</div>
			</div>
		</div>
	</div>
<!--COMMON FOOTER-->
<#include "../include/footer.ftl">
<!--COMMON FOOTER-->
<script>
$('li[id$="Li"]').attr('class','');
$('li#stageItemLi').attr('class','active');
</script>