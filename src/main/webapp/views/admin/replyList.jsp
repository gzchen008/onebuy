<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">

<link href="<c:url value="/css/admin/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/admin/font-awesome/css/font-awesome.css"/>?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="<c:url value="/css/admin/plugins/morris/morris-0.4.3.min.css"/>" rel="stylesheet">

<!-- Data Tables -->
<link href="<c:url value="/css/admin/plugins/dataTables/dataTables.bootstrap.css"/>" rel="stylesheet">

<!-- Gritter -->
<link href="<c:url value="/css/admin/plugins/gritter/jquery.gritter.css"/>" rel="stylesheet">

<link href="<c:url value="/css/admin/animate.css"/>" rel="stylesheet">
<link href="<c:url value="/css/admin/style.css"/>" rel="stylesheet">
<style>
body {
	background: #fff;
}
</style>
</head>
<body>
	<!-- 主内容 -->

	<div class="row">
	
		<div class="col-md-12 ">
			<div class="chat-discussion" style="height: 550px;">
					<h1>回复详情</h1>
				<c:forEach items="${crPage.list }" var="caseReply">
					<div class="chat-message">
						<c:if test="${caseReply.direction eq 1 }">
							<img class="message-avatar" src="<c:url value="/img/icon/manager.png"/>" alt="">
							<div class="message">
								<a class="message-author" href="#"> 工作人员：${caseReply.username } </a>
								<span class="message-date"> ${caseReply.rTime } </span> <span class="message-content"><c:if test="${caseReply.contentType eq 1 }"> ${caseReply.content } </c:if> <c:if
										test="${caseReply.contentType eq 2 }">
										<a href="<c:url value="/upload/replyImg/${caseReply.content }"/>" target="_blank"/><img src="<c:url value="/upload/replyImg/${caseReply.content }"/>" width="200" /></a>
									</c:if> </span>
							</div>
						</c:if>

						<c:if test="${caseReply.direction eq 2 }">

							<img class="message-avatar" src="${caseReply.headImg }" alt="">
							<div class="message">
								<a class="message-author" href="#"> 用户：${caseReply.nickname } </a>
								<span class="message-date"> ${caseReply.rTime } </span> <span class="message-content"><c:if test="${caseReply.contentType eq 1 }"> ${caseReply.content } </c:if> <c:if
										test="${caseReply.contentType eq 2 }">
										<a href="<c:url value="/upload/replyImg/${caseReply.content }"/>" target="_blank"/><img src="<c:url value="/upload/replyImg/${caseReply.content }"/>" width="200" /></a>
									</c:if> </span>
							</div>
						</c:if>
					</div>
				</c:forEach>

				<div style="width: 100%; text-align: center;">
					<ul class="pagination pagination-lg">
						<li>
							<a href="<c:url value="/admin/reply/replyList"/>?caseId=${caseId }&pageNumber=1">首页</a>
						</li>

						<c:if test="${crPage.pageNumber eq 1 }">
							<li class="disabled">
								<a href="#">&laquo;</a>
							</li>
						</c:if>
						<c:if test="${crPage.pageNumber != 1 }">
							<li>
								<a href="<c:url value="/admin/reply/replyList"/>?caseId=${caseId }&pageNumber=${crPage.pageNumber -1}">&laquo;</a>
							</li>
						</c:if>


						<li class="active">
							<a href="#"> ${crPage.pageNumber }</a>
						</li>

						<c:if test="${crPage.pageNumber eq crPage.totalPage }">
							<li class="disabled">
								<a href="#">&raquo;</a>
							</li>
						</c:if>
						<c:if test="${crPage.pageNumber != crPage.totalPage }">
							<li>
								<a href="<c:url value="/admin/reply/replyList"/>?caseId=${caseId }&pageNumber=${crPage.pageNumber +1}">&raquo;</a>
							</li>
						</c:if>

						<li>
							<a href="<c:url value="/admin/reply/replyList"/>?caseId=${caseId }&pageNumber=${crPage.totalPage}">尾页</a>
						</li>
						<li class="disabled">
							<a href="#">共${crPage.totalPage }页</a>
						</li>
					</ul>

				</div>
			</div>

		</div>

	</div>



	${msg }
	<!-- Mainly scripts -->
	<script src="<c:url value="/js/admin/jquery-2.1.1.min.js"/>"></script>
	<script src="<c:url value="/js/admin/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/admin/plugins/metisMenu/jquery.metisMenu.js"/>"></script>
	<script src="<c:url value="/js/admin/plugins/slimscroll/jquery.slimscroll.min.js"/>"></script>



	<!-- Custom and plugin javascript -->
	<script src="<c:url value="/js/admin/hplus.js?v=2.2.0"/>"></script>
	<script src="<c:url value="/js/admin/plugins/pace/pace.min.js"/>"></script>


	<!-- Data Tables -->
	<script src="<c:url value="/js/admin/plugins/dataTables/jquery.dataTables.js"/>"></script>
	<script src="<c:url value="/js/admin/plugins/dataTables/dataTables.bootstrap.js"/>"></script>
</body>
</html>