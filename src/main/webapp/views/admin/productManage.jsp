<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="zh-cn">
	<jsp:include page="head.jsp">
		<jsp:param value="鲜出没中心管理系统" name="title"/>
	</jsp:include>
	<body id="productManage">
		<div class="header"><h1>鲜出没中心管理系统</h1></div>
		<jsp:include page="menu.jsp">
			<jsp:param value="${session.admin.account}" name="username"/>
		</jsp:include>
		<div class="content">
			<div class="main-content">
				<h3 class="main-content-header"><span></span>产品管理</h3>
				<a class="btn btn-primary btn-border-none pull-right left-margin-1x right-margin-3x " href="#">删除</a>
				<a class="btn btn-primary btn-border-none pull-right left-margin-1x" href="#">下架</a>
				<a class="btn btn-primary btn-border-none pull-right left-margin-1x" href="#">上架</a>
				<a class="btn btn-primary btn-border-none pull-right left-margin-1x" href="#">添加</a>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th><input type="checkbox"/>全选</th>
							<th>产品名字</th>
							<th>单价</th>
							<th>规格</th>
							<th>菜谱推荐</th>
							<th>产品图片</th>
							<th>商品状态</th>
							<th>编辑产品信息</th>
							<!--其下对应开始处理-->
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox"/>01</td>
							<td>小白菜</td>
							<td>￥15</td>
							<td>500g/袋</td>
							<td>
								<img src="${rootPath}/resources/img/vedetable.jpg" height="50" width="50">
								<p>小白菜</p>
							</td>
							<td>
								<img src="${rootPath}/resources/img/vedetable.jpg" height="50" width="50">
							</td>
							<td>上架</td>
							<td><a href="#" class="btn btn-primary btn-border-none">点击编辑</a></td>
						</tr>
					</tbody>
				</table>
	
				<div class="page-divider btn-group" role="group" aria-label="page-divide">
					<a href="#" class="btn btn-default disabled">上一页</a>
					<a href="#" class="btn btn-default active">1</a>
					<a href="#" class="btn btn-default">2</a>
					<a href="#" class="btn btn-default">3</a>
					<a href="#" class="btn btn-default disabled">...</a>
					<a href="#" class="btn btn-default">10</a>
					<a href="#" class="btn btn-default">11</a>
					<a href="#" class="btn btn-default">12</a>
					<a href="#" class="btn btn-default">下一页</a>
				</div>
			</div>
		</div>
	</body>
</html>