<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>一元购商城后台</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link href="${rootPath}/resources/css/admin/bootstrap.min.css" rel="stylesheet">
<link href="${rootPath}/resources/css/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="${rootPath}/resources/css/admin/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

<!-- Data Tables -->
<link href="${rootPath}/resources/css/admin/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

<!-- Gritter -->
<link href="${rootPath}/resources/css/admin/plugins/gritter/jquery.gritter.css" rel="stylesheet">

<link href="${rootPath}/resources/css/admin/animate.css" rel="stylesheet">
<link href="${rootPath}/resources/css/admin/style.css" rel="stylesheet">
</head>

<body>
	<div id="wrapper">
		<!--导航-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span> <img alt="image" class="img-circle" src="" height="70" />
							</span>
							<a data-toggle="dropdown" class="dropdown-toggle" href="/">
								<span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">管理员</strong>
								</span> <span class="text-muted text-xs block"><b class="caret"></b></span>
								</span>
							</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li>
									<a href="${rootPath}/admin/edit">修改密码</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="${rootPath}/valicate/logout">安全退出</a>
								</li>
							</ul>
						</div>
						<div class="logo-element">H+</div>
					</li>
					<li id="goodItemLi" class="active">
						<a href="${rootPath}/admin/goods">
							<i class="fa fa-th-large"></i> <span class="nav-label">商品管理</span>
						</a>
						
					</li>
					<li id = "stageItemLi">
						<a href="/">
							<i class="fa fa fa-globe"></i> <span class="nav-label">活动管理</span><span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a href="${rootPath}/admin/stages/latest">所有期数</a>
							</li>
							<li>
								<a href="${rootPath}/admin/stages/processing">正在进行</a>
							</li>
						</ul>
					</li>
					<li id = "orderItemLi">
					<a href="${rootPath}/admin/orders">
							<i class="fa fa fa-globe"></i> <span class="nav-label">订单管理</span><span class="fa arrow"></span>
						</a>
					</li>
					<li id = "userItemLi">
					<a href="${rootPath}/admin/users">
							<i class="fa fa fa-globe"></i> <span class="nav-label">用户管理</span><span class="fa arrow"></span>
						</a>
					</li>
					<li id = "adItemLi">
						<a href="${rootPath}/admin/ad">
							<i class="fa fa-bar-chart-o"></i> <span class="nav-label">首页广告设置</span><span class="fa arrow"></span>
						</a>
					</li>
					
				</ul>
			</div>
		</nav>
		<!--导航结束-->
		<!-- 右侧全部内容 -->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<!-- 顶部内容 -->
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href=""${rootPath}/resources/admin/index">
							<i class="fa fa-bars"></i>
						</a>
						<form role="search" class="navbar-form-custom" method="post" action="search_results.html">
							
						</form>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li>
							<span class="m-r-sm text-muted welcome-message"><a href="${rootPath}/admin/goods" title="返回首页">
									<i class="fa fa-home"></i>
								</a>欢迎使用管理系统</span>
						</li>
						<li class="dropdown">
                           
                        </li>
						<li>
							<a href="${rootPath}/valicate/logout">
								<i class="fa fa-sign-out"></i> 退出
							</a>
						</li>
					</ul>
				</nav>
			</div>
			<!-- 顶部内容结束 -->