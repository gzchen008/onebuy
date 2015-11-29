<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="header"><h1>鲜出没中心管理系统</h1></div>
<div class="main-menu">
	<div class="portrait">
		<img src="${rootPath}/resources/img/portrait.jpg" alt="头像"/>
		<h3>欢迎你~${param.username}</h3>
	</div>
	<ul class="list-group">
		<li class="list-group-item active"><a href="${rootPath}/admin/goodManage/listGood?page=1">产品管理</a></li>
		<li class="list-group-item"><a href="${rootPath}/admin/merchant/listMerchant?page=1">门店管理</a></li>
		<li class="list-group-item"><a href="${rootPath}/admin/user/listUser?page=1">用户管理</a></li>
		<li class="list-group-item"><a href="${rootPath}/admin/order/listOrder?page=1">订单管理</a></li>
	</ul>
</div>
