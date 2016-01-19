<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>投诉角色列表</h2>
		<ol class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a>功能设置</a></li>
			<li><strong>投诉角色设置</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-11">
			<table class="table">
				<tr>
					<th>名称</th>
					<th>图标</th>
					<th>查看</th>
				</tr>
				<c:forEach items ="${caseTypeInfos }" var="caseType">
					<tr>
						<td>${caseType.name }</td>
						<td><img width="80" src="<c:url value="/upload/img/${caseType.photo }"/>"/></td>
						<td><a href="<c:url value="/admin/setting/showCaseType"/>?id=${caseType.id }">查看</a></td>
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