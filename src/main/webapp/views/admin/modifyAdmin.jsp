<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>修改个人密码</h2>
		<ol class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a>管理员设置</a></li>
			<li><strong>修改个人密码</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-6">
			<form class="form-horizontal" method="post" action="<c:url value="/admin/modifyPass"/>">
				<div class="form-group">
					<label class="control-label">原密码：</label>
					<input required="required" type="password" name="orgPassword" placeholder="请输入原密码" class="form-control">
				 </div>
				 <div class="form-group">
					<label class="control-label">新密码：</label>
					<input required="required" type="password" name="password" placeholder="请输入密码" class="form-control">
				 </div>
				  <div class="form-group">
					<label class="control-label">确认密码：</label>
					<input required="required" type="password" name="comPassword" placeholder="请输入确认密码" class="form-control">
				 </div>
				  <div class="form-group">
					<input type="submit" onclick="return check();" name="submit" value="提交" class="form-control btn btn-info" >
				 </div>
			</form>
		</div>
	</div>
</div>
<!--底部-->
<%@ include file="include/footer.jsp"%>
<script>
	function check(){
		var passwordInput = $("input[name=password]");
		var comPasswordInput = $("input[name=comPassword]");
		if(passwordInput.val() != comPasswordInput.val()){
			alert("两次密码不一致");
			return false;
		}
		return true;
		
	}
</script>
${msg }
</body>

</html>