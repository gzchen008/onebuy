<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>详细信息</h2>
		<ol class="breadcrumb">
			<li>
				<a href="#">系统管理</a>
			</li>
			<li>
				<a>投诉管理</a>
			</li>
			<li>
				<strong>详细信息</strong>
			</li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 主内容 -->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>${caseInfo.caseId }</h5>
				</div>
				<div class="ibox-content">
					<table class="table">
						<thead>
							<tr>
								<th>案件号:</th>
								<td>${caseInfo.caseId }</td>
								<th>联系人:</th>
								<td>${caseInfo.realName }</td>
								<th>联 系方式:</th>
								<td>${caseInfo.contact }</td>
							</tr>
						</thead>
						<thead>
							<tr>
								<th>邮箱:</th>
								<td>${caseInfo.mail }</td>
								<th>渠道:</th>
								<td>${caseInfo.title }</td>
								<th>类型:</th>
								<td>${caseInfo.typeName }</td>
							</tr>

							<tr>
								<th>申请时间：</th>
								<td>${caseInfo.submitTime }</td>

							</tr>
							<tr>
								<th>内容:</th>
								<td colspan="6">
									<textArea class="form-control" rows="5" disabled="disabled" class="width:100%;">${caseInfo.content }</textArea>
								</td>

							</tr>
							<tr>
								<th>图片:</th>
								<td colspan="6">
									<c:if test="${!empty caseInfo.photo1 }">
										<a href="<c:url value="/upload/img/${caseInfo.photo1 }"/>" target="_blank">
											<img width="32%" src="<c:url value="/upload/img/${caseInfo.photo1 }"/>" />
										</a>
									</c:if>
									<c:if test="${!empty caseInfo.photo2 }">
										<a href="<c:url value="/upload/img/${caseInfo.photo1 }"/>" target="_blank">
											<img width="32%" src="<c:url value="/upload/img/${caseInfo.photo2 }"/>" />
										</a>
									</c:if>
									<c:if test="${!empty caseInfo.photo3 }">
										<a href="<c:url value="/upload/img/${caseInfo.photo1 }"/>" target="_blank">
											<img width="32%" src="<c:url value="/upload/img/${caseInfo.photo3 }"/>" />
										</a>
									</c:if>
								</td>
							</tr>
							<tr>
								<th>审批说明</th>
								<td colspan="6">
									<form id="checkFrm" class="form-horizontal" action="check" method="post">
										<div class="form-group" style="width: 100%;">
											<textarea id="replyContent" rows="5" class="form-control" name="replyContent" placeholder="必须输入审批说明" required="required">${caseInfo.replayContent }</textarea>
										</div>
										<input type="hidden" name="id" value="${caseInfo.id }">
									</form>
								</td>
							</tr>
							<tr>
								<th>操作</th>
								<td colspan="2">
									<c:choose>
										<c:when test="${caseInfo.status eq 3 }">
											<button type="button" disabled="disabled" class="btn btn-info">已审批</button>
										</c:when>
										<c:otherwise>
											<button type="button" onclick="checkFrm_onclick();" class="btn btn-info">审批</button>
										</c:otherwise>
									</c:choose>
								</td>
								<td colspan="2">
									<a href="#" onclick="deleteTip();" class="btn btn-info">移至回收站</a>
								</td>
								<td colspan="2">
									<a href="javascript:history.go(-1);" class="btn btn-info">返回</a>
								</td>
							</tr>
							<tr>
								<td colspan="6"></td>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!--底部-->
<%@ include file="include/footer.jsp"%>
<script>
	function deleteTip() {
		if (!confirm("确定要删除至回收站 吗？")) {
			return;
		}
		$.ajax({
			url : "<c:url value="/admin/recoveryCase"/>?id=${caseInfo.id }",
			type : "GET",
			success : function(data) {
				if (data.status == "1") {
					alert("删除成功");
					window.location = "index";
				} else {
					alert(data.msg);
				}
			}
		});
	}

	function checkFrm_onclick() {
		if ($("#replyContent").val() == "") {
			alert("必须输入审批说明！");
			return;
		}
		$("#checkFrm").submit();
	}
</script>
</body>

</html>