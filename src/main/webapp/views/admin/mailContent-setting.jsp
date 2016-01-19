<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>邮件内容设置</h2>
		<ol class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a>邮件设置</a></li>
			<li><strong>邮件内容设置</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-6">
			<form action="saveMailContent" class="form-horizontal" method="post"
				>
				<div class="form-group">
					<label class="control-label"> 提交投诉后的通知标题： </label> <input
						type="text" name="mail_subject" class="form-control"
						value="${systemInfo.mail_subject }" />
				</div>
				<div class="form-group">
					<label class="control-label"> 提交投诉后的通知的内容： </label>
					<textarea rows="5" class="form-control" name="mail_content">${systemInfo.mail_content }</textarea>
					<span class="help-inline">注意：%caseId%表示案例号，%submitTime%为提交时间，请保留</span>
				</div>
				<div class="form-group">
					<label class="control-label"> 审批后的通知标题： </label> <input type="text"
						name="mail_subject_sp" class="form-control"
						value="${systemInfo.mail_subject_sp }" />
				</div>
				<div class="form-group">
					<label class="control-label"> 审批后的通知的内容： </label>
					<textarea rows="5" class="form-control" name="mail_content_sp">${systemInfo.mail_content_sp }</textarea>
					<span class="help-inline">注意：%caseId%表示案例号，%submitTime%为提交时间，请保留</span>

				</div>
				<div class="form-group">
					<input type="submit" class="form-control btn btn-info" name=""
						value="保存" />
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