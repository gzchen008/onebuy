<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="main-menu">
	<div class="portrait">
		<img src="${rootPath}/resources/img/portrait.jpg" alt="头像"/>
		<h3>欢迎你~${param.username}</h3>
	</div>
	<ul class="list-group">
		<li class="list-group-item active"><a href="#">产品管理</a></li>
		<li class="list-group-item"><a href="#">门店管理</a></li>
		<li class="list-group-item"><a href="#">用户管理</a></li>
		<li class="list-group-item"><a href="#">订单管理</a></li>
	</ul>
</div>
