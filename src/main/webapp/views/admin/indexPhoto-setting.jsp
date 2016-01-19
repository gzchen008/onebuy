<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>首页图片设置</h2>
		<ol class="breadcrumb">
			<li><a href="#">系统管理</a></li>
			<li><a>界面设置</a></li>
			<li><strong>首页图片设置</strong></li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-6">
			<form action="saveIndexPhoto" class="form-horizontal" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label class="control-label">
						当前图片：
					</label>
					<c:if test="${id eq 1 }">
						<img width ="640" src="<c:url value='/upload/img/'/>${systemInfo.indexBanner1 }"/>
					</c:if>
					<c:if test="${id eq 2 }">
						<img width ="640" src="<c:url value='/upload/img/'/>${systemInfo.indexBanner2 }"/>
					</c:if>
				</div>
				<div class="form-group">
					<label class="control-label">
						更换图片：
					</label>
					<input type="file" class="form-control" name="photo"/>
				</div>
				<div class="form-group">
					<input type="hidden" name="id" value="${id }">
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