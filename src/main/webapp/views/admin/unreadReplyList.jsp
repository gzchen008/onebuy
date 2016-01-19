<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 头部 -->
<%@ include file="include/head.jsp"%>
<!-- 内页导航开始 -->
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>${title }</h2>
		<ol class="breadcrumb">
			<li>
				<a href="#">系统管理</a>
			</li>
			<li>
				<a>投诉管理</a>
			</li>
			<li>
				<strong>查看新回复</strong>
			</li>
		</ol>
	</div>
	<div class="col-lg-2"></div>
</div>
<!-- 内页导航结束 -->
<!--主内容开始-->
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">

				<div class="ibox-content">

					<table class="table table-striped table-bordered table-hover dataTables-example">
						<thead>
							<tr>
								<th>案例号</th>
								<th>用户</th>
								<th>时间</th>
								<th>内容</th>
								<th>回复</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${unReadList}" var="unreadInfo">
								<tr class="gradeA">
									<td>
										<a  href="<c:url value="/admin/showProcessDetail"/>?id=${unreadInfo.cid }">${unreadInfo.caseId }</a>
									</td>
									<td><div><img width="40" src="${unreadInfo.headImg }"/>${unreadInfo.nickname }
									</div>
									</td>
									<td>${unreadInfo.rTime }</td>
									<td class="center">
										<c:if test="${unreadInfo.contentType eq 1 }">
											<c:if test="${fn:length(unreadInfo.content )>20}">
											${fn:substring(unreadInfo.content,0 ,20 )}...
											</c:if>
											<c:if test="${fn:length(unreadInfo.content)<20}">${unreadInfo.content}</c:if>
										</c:if>
										<c:if test="${unreadInfo.contentType eq 2 }">
											<img width="100" src="<c:url value="/upload/replyImg/"/>${unreadInfo.content}" />
										</c:if>
									</td>
									<td>
										<a target="_blank" href="<c:url value="/admin/showProcessDetail"/>?id=${unreadInfo.cid }">答复</a>
									</td>
								</tr>
							</c:forEach>
						<c:if test="${empty unReadList }">暂无新消息</c:if>

						</tbody>
						<tfoot>
							<tr>

							</tr>
						</tfoot>
					</table>

				</div>
			</div>
		</div>
	</div>
</div>
<!--底部-->
<%@ include file="include/footer.jsp"%>

<!--统计代码，可删除-->


<script>
	$(document).ready(function() {
		$('.dataTables-example').dataTable();

		/* Init DataTables */
		var oTable = $('#editable').dataTable();

		/* Apply the jEditable handlers to the table */
		oTable.$('td').editable('../example_ajax.php', {
			"callback" : function(sValue, y) {
				var aPos = oTable.fnGetPosition(this);
				oTable.fnUpdate(sValue, aPos[0], aPos[1]);
			},
			"submitdata" : function(value, settings) {
				return {
					"row_id" : this.parentNode.getAttribute('id'),
					"column" : oTable.fnGetPosition(this)[2]
				};
			},

			"width" : "90%",
			"height" : "100%"
		});

	});
</script>
</body>

</html>