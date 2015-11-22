<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
  <jsp:include page="head.jsp">
  	<jsp:param value="营业额统计" name="title"/>
  </jsp:include>
  
  <body>
   <jsp:include page="menu.jsp">
		<jsp:param value="${SessionScope.merchant.account}" name="username"/>
   </jsp:include>
   <div class="content">
		<div class="content-header"><span class="position">您当前的位置：营业额统计</span><!-- <span class="time">2015.10.30 星期五</span> --></div>
		<div class="main-content">
			<h3 class="main-content-header">营业额统计</h3>
			<div class="trade-time top-margin-2x bottom-margin-2x">
				<thead>
					<span>交易时间:</span>
					<input class="form-control time" type="date"/>
					<span>到</span>
					<input class="form-control time" type="date"/>
					<button class="btn btn-primary btn-border-none pull-right">统计分析</button>
					<button class="btn btn-primary btn-border-none pull-right  right-margin-2x">点此查询</button>
				</thead>
			</div>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>类别</th>
						<th>销售数量</th>
						<th>销售额</th>
						<!--其下对应开始处理-->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${requestScop.items}">
					<tr>
						<td>${item.name}</td>
						<td>${item.amout}</td>
						<td>${item.money}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="page-divider btn-group" role="group" aria-label="page-divide">
				<a href="#" class="btn btn-default">上一页</a>
				<a href="#" class="btn btn-default active">1</a>
				<a href="#" class="btn btn-default">2</a>
				<a href="#" class="btn btn-default">3</a>
				<a href="#" class="btn btn-default disabled">...</a>
				<a href="#" class="btn btn-default">10</a>
				<a href="#" class="btn btn-default">11</a>
				<a href="#" class="btn btn-default">12</a>
				<a href="#" class="btn btn-default">下一页</a>
			</div>
		</div>
	</div>
  </body>
</html>
