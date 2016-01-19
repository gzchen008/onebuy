<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>波斯庄园投诉后台 - 登录</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="<c:url value="/css/admin/bootstrap.min.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="/css/admin/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet">

<!-- Morris -->
<link
	href="<c:url value="/css/admin/plugins/morris/morris-0.4.3.min.css"/>"
	rel="stylesheet">

<!-- Data Tables -->
<link
	href="<c:url value="/css/admin/plugins/dataTables/dataTables.bootstrap.css"/>"
	rel="stylesheet">
<link href="<c:url value="/css/admin/animate.css"/>" rel="stylesheet">
<link href="<c:url value="/css/admin/style.css"/>" rel="stylesheet">



</head>

<body class="gray-bg">

	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>

				<h1 class="logo-name">H+</h1>

			</div>
			<h3>欢迎使用${website_name }投诉系统</h3>
	
			<form class="m-t" role="form" action="<c:url value="/admin/login"/>" method="POST">
				<div class="form-group">
					<span style="color:red;">${msg }</span>
					<input type="text" class="form-control" name="username" placeholder="用户名"
						required="required">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="password" placeholder="密码"
						required="required">
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">登
					录</button>


			</form>
		</div>
	</div>

	<!-- Mainly scripts -->
	<script src="<c:url value="/js/admin/jquery-2.1.1.min.js"/>"></script>
	<script src="<c:url value="/js/admin/bootstrap.min.js"/>"></script>
	<script
		src="<c:url value="/js/admin/plugins/metisMenu/jquery.metisMenu.js"/>"></script>
	<script
		src="<c:url value="/js/admin/plugins/slimscroll/jquery.slimscroll.min.js"/>"></script>



	<!-- Custom and plugin javascript -->
	<script src="<c:url value="/js/admin/hplus.js?v=2.2.0"/>"></script>
	<script src="<c:url value="/js/admin/plugins/pace/pace.min.js"/>"></script>


	<!-- Data Tables -->
	<script
		src="<c:url value="/js/admin/plugins/dataTables/jquery.dataTables.js"/>"></script>
	<script
		src="<c:url value="/js/admin/plugins/dataTables/dataTables.bootstrap.js"/>"></script>

</body>

</html>
