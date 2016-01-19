<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>波斯庄园投诉平台后台</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link href="<c:url value="/css/admin/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/admin/font-awesome/css/font-awesome.css"/>" rel="stylesheet">

<!-- Morris -->
<link href="<c:url value="/css/admin/plugins/morris/morris-0.4.3.min.css"/>" rel="stylesheet">

<!-- Data Tables -->
<link href="<c:url value="/css/admin/plugins/dataTables/dataTables.bootstrap.css"/>" rel="stylesheet">

<!-- Gritter -->
<link href="<c:url value="/css/admin/plugins/gritter/jquery.gritter.css"/>" rel="stylesheet">

<link href="<c:url value="/css/admin/animate.css"/>" rel="stylesheet">
<link href="<c:url value="/css/admin/style.css"/>" rel="stylesheet">

</head>

<body>
	<div id="wrapper">
		<!--导航-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">

						<div class="dropdown profile-element">
							<span> <img alt="image" class="img-circle" src="<c:url value="/img/icon/manager.png"/>" height="70" />
							</span>
							<a data-toggle="dropdown" class="dropdown-toggle" href="/">
								<span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${admin.username }</strong>
								</span> <span class="text-muted text-xs block">${admin.atName } <b class="caret"></b></span>
								</span>
							</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">

								<li>
									<a href="<c:url value="/admin/modifyAdmin.jsp"/>">修改密码</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="<c:url value="/admin/logout"/>">安全退出</a>
								</li>
							</ul>
						</div>
						<div class="logo-element">H+</div>

					</li>
					<li <c:if test="${active eq 1 }">class="active"</c:if>>
						<a href="index.html">
							<i class="fa fa-th-large"></i> <span class="nav-label">投诉管理</span> <span class="label label-warning pull-right">${undoCount }</span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a href="<c:url value="/admin/index"/>">新投诉*</a>
							</li>
							<li>
								<a href="<c:url value="/admin/processing"/>">处理中投诉</a>
							</li>
							<li>
								<a href="<c:url value="/admin/ending"/>">已结束投诉</a>
							</li>
							<li>
								<a href="<c:url value="/admin/recovery"/>">投诉回收站</a>
							</li>
							<li>
								<a href="<c:url value="/admin/showAll"/>">所有投诉</a>
							</li>
						</ul>
					</li>
					<li <c:if test="${active eq 2 }">class="active"</c:if>>
						<a href="/">
							<i class="fa fa fa-globe"></i> <span class="nav-label">邮件设置</span><span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">

							<li>
								<a href="<c:url value="/admin/setting/mailAccount"/>">邮件帐户</a>
							</li>
							<li>
								<a href="<c:url value="/admin/setting/mailContent"/>">内容设置</a>
							</li>

						</ul>
					</li>
					<li <c:if test="${active eq 3 }">class="active"</c:if>>
						<a href="/">
							<i class="fa fa fa-globe"></i> <span class="nav-label">功能设置</span><span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">

							<li>
								<a href="<c:url value="/admin/setting/caseType"/>">投诉角色设置</a>
							</li>
							<li>
								<a href="<c:url value="/admin/setting/caseTitle"/>">投诉渠道/问题设置</a>
							</li>


						</ul>
					</li>
					<li <c:if test="${active eq 4 }">class="active"</c:if>>
						<a href="#">
							<i class="fa fa-bar-chart-o"></i> <span class="nav-label">界面设置</span><span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a href="<c:url value="/admin/setting/indexPhoto"/>?id=1">首页图片一</a>
							</li>
							<li>
								<a href="<c:url value="/admin/setting/indexPhoto"/>?id=2">首页图片二</a>
							</li>
						</ul>
					</li>
					<li <c:if test="${active eq 5 }">class="active"</c:if>>
						<a href="mailbox.html">
							<i class="fa fa-envelope"></i> <span class="nav-label">帐号设置</span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a href="<c:url value="/admin/listAdmin"/>">帐号列表</a>
							</li>
							<li>
								<a href="<c:url value="/admin/addAdminView"/>">添加帐号</a>
							</li>
						</ul>
					</li>
					<li <c:if test="${active eq 6 }">class="active"</c:if>>
						<a href="">
							<i class="fa fa-envelope"></i> <span class="nav-label">更新网站缓存</span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a href="<c:url value="/admin/setting/updateCache"/>">更新网站缓存</a>
							</li>

						</ul>
					</li>
					<li>
						<a href="">
							<i class="fa fa-envelope"></i> <span class="nav-label">积分系统</span>
						</a>
						<ul class="nav nav-second-level">
							<li>
								<a href="<c:url value="/sign/admin/index"/>">转到积分系统</a>
							</li>

						</ul>
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
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href=""<c:url value="/admin/index"/>">
							<i class="fa fa-bars"></i>
						</a>
						<form role="search" class="navbar-form-custom" method="post" action="search_results.html">
							<div class="form-group">
								<input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
							</div>
						</form>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li>
							<span class="m-r-sm text-muted welcome-message"><a href="<c:url value="/admin/index"/>" title="返回首页">
									<i class="fa fa-home"></i>
								</a>欢迎使用波斯庄园管理系统</span>
						</li>
						<li class="dropdown">
                            <a class="dropdown-toggle count-info" href="<c:url value="/admin/reply/unReadList"/>">
                                <i class="fa fa-envelope"></i> <span class="label label-warning">${unreadReplyCount }</span>
                            </a>
                        </li>
						<li>
							<a href="<c:url value="/admin/logout"/>">
								<i class="fa fa-sign-out"></i> 退出
							</a>
						</li>
					</ul>

				</nav>
			</div>
			<!-- 顶部内容结束 -->