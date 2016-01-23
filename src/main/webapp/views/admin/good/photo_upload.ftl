<!-- COMMON HEAD -->
<#include "../include/top.ftl">
<!-- COMMON HEAD -->
<!-- 内页导航开始 -->


<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>${title  !}</h2>
		<ol class="breadcrumb">
			<li><a href="">系统管理</a></li>
			<li><a href="${rootPath}/admin/goods/detail/${(good.id)!}"></a>商品详情</li>
			<li><strong>上传详情图片</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 内页导航结束 -->




<!--COMMON FOOTER-->
<#include "../include/footer.ftl">
<!--COMMON FOOTER-->