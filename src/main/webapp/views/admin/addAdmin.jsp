<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% request.setAttribute("active", 5); 
	//查找管理员类型
	
%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>添加管理帐号</h2>
		<ol class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a>帐号设置</a></li>
			<li><strong>添加管理帐号</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-6">
			<form class="form-horizontal" method="post" action="<c:url value="/admin/addAdmin"/>">
				<div class="form-group">
					<label class="control-label">用户名：</label>
					<input type="text" name="username" placeholder="请输入用户名" class="form-control">
				 </div>
				 <div class="form-group">
					<label class="control-label">帐号类型：</label>
					<select name="typeId" class="form-control">
						<c:forEach items="${typeLs }" var="info">
							<option value="${info.id }">${info.atName }</option>
						</c:forEach>
					</select>
				 </div>
				 <div class="form-group">
					<label class="control-label">密码：</label>
					<input type="password" name="password" placeholder="请输入密码" class="form-control">
				 </div>
				  <div class="form-group">
					<label class="control-label">确认密码：</label>
					<input type="password" name="comPassword" placeholder="请输入确认密码" class="form-control">
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