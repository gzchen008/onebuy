<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>邮件设置</h2>
		<ol class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a>邮件设置</a></li>
			<li><strong>帐户设置</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-6">
			<form action="saveMailAccount" class="form-horizontal" method="post">
				<div class="form-group">
					<label class="control-label">
						邮件地址：
					</label>
					<input type="email" class="form-control" name="mailUsername" value="${gRSystem.mailUsername }"/>
				</div>
				<div class="form-group">
					<label class="control-label">
						密码：
					</label>
					<input type="password" class="form-control" name="mailPassword" value="${gRSystem.mailPassword }"/>
				</div>
				<div class="form-group">
					<input type="submit" class="form-control btn btn-info" name="" value="保存"/>
				</div>
			</form>
		</div>
	</div>
</div>
<!--底部-->
<%@ include file="include/footer.jsp"%>
${msg }
</body>

</html>