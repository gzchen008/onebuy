<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
<title>全部订单</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/all-orders.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/font-awesome.min.css" />
</head>
<body>
	<div class="header">
		<span class="backspace"></span>

		<h3>
			全部订单<span></span>
		</h3>
	</div>

	<div class="container">
		<div class="want-more">
			<a href="#"> <span></span> 不够吃，我还要买买买 <i></i>
			</a>
		</div>
		<div class="new-divider"></div>
		<ul class="order-list ">
			<c:forEach items="${orders }" var="order">
				<li>
					<div class="info">
						<h4>订单编号 ${order.orderNumber }</h4>

						<p>${order.orderTime }&nbsp;&nbsp;</p>
						<span><c:choose>
							<c:when test="${order.orderState eq 1}">未付款</c:when>
							<c:when test="${order.orderState eq 2}">已付款</c:when>
							<c:when test="${order.orderState eq 3}">已配送</c:when>
							<c:when test="${order.orderState eq 4}">已取货</c:when>
							<c:when test="${order.orderState eq 5}">已取消</c:when>
						</c:choose></span>
					</div>
					<div class="pic">
						<c:forEach items="${order.goods }" var="orderItem">
							<img src="${rootPath }${orderItem.good.photoUrl}">
						</c:forEach>
						<span></span>

						<h3>共${order.goods.size() }件商品 ￥${order.money }</h3>
					</div>
					<div class="divider"></div>
					<div class="go-evaluate">
						<a href="${rootPath }/eval/evaluate?id=${order.oid}">去评价</a>
					</div>
				</li>
				<div class="big-divider"></div>
			</c:forEach>
		</ul>
	</div>


	<!-- //弹出框 -->
	<span class="triangle"></span>
	<span class="triangle"></span>

	<div class="all-menu">
		<ul class="order-list">
			<li><a href="#"><span id="all-orders"></span>全部订单</a></li>
			<li><a href="#"><span id="transform"></span>正在配送</a></li>
			<li><a href="#"><span id="arrived"></span>已经送达</a></li>
			<li><a href="#"><span id="wait-evaluate"></span>等待评价</a></li>
			<li><a href="#"><span id="my-address"></span>我的地址</a></li>
		</ul>
	</div>
	<div class="loading-bar">
		<i class="fa fa-spinner fa-pulse"></i>
	</div>
	<script type="text/javascript"
		src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
	<script type="text/javascript"
		src="${rootPath }/resources/js/regular.js"></script>
	<script type="text/javascript"
		src="${rootPath }/resources/js/all-orders-c.js"></script>
		<script type="text/javascript"
		src="${rootPath }/resources/js/common.js"></script>
</body>
</html>