<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>管理员列表</h2>
		<ol class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a>帐号设置</a></li>
			<li><strong>帐号列表</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-10">
			<table class="table">
				<tr>
					<th>用户名</th>
					<th>密码</th>
					<th>最后登录时间</th>
					<th>帐号类型</th>
					<th>操作</th>
				</tr>
				<c:forEach items ="${admins}" var="admin">
					<tr>
						<td>${admin.username }</td>
						<td>${admin.password }</td>
						<td>${admin.lastTime }</td>
						<td>${admin.atName }</td>
						<td><a href="<c:url value="/admin/deleteAdmin"/>?id=${admin.id }">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<!--底部-->
<%@ include file="include/footer.jsp"%>
${msg }
</body>

</html>