<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%
request.setAttribute("footer_active", 3);
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
	<title>我</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/comment.css">
	<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/me.css">
	<script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
	<style>
		a {
			text-decoration: none;
		}
	</style>
</head>
<body class="product-info">
	<div class="header">
		<h3>我的鲜出没</h3>
	</div>

	<div class="container">
		<div class="portrait">
			<img src="${rootPath }/resources/img/portrait.png">
			<h3>${user.name}</h3>
			<h5>ID:${user.uid}</h5>
		</div>
		<div class="personal-condition">
			<ul>
				<li>
					<h3>￥${user.wallet.overage }</h3>
					<span>余额</span>
				</li>
				<li>
					<h3>${user.wallet.credits }积分</h3>
					<span>积分</span>
				</li>
				<li><a href="${rootPath }/redpacket">
					<h3>${redCount }个</h3>
					<span>红包</span>
					</a>
				</li>
			</ul>
		</div>
		<div class="content">
			<ul>
				<li>
					<a href="${rootPath }/order/listOrder">
						<img src="${rootPath }/resources/img/order.png">
						<span>我的订单</span>
					</a>
				</li>
				<li>
					<a href="">
						<img src="${rootPath }/resources/img/myLove.png">
						<span>我喜欢</span>
					</a>
				</li>
				<li>
					<a href="${rootPath }/address/myaddress">
						<img src="${rootPath }/resources/img/meAdress.png">
						<span>我的地址</span>
					</a>
				</li>
				<li>
					<a href="">
						<img src="${rootPath }/resources/img/exchange.png">
						<span>积分兑换</span>
					</a>
				</li>
				<li>
					<a href="">
						<img src="${rootPath }/resources/img/bargin.png">
						<span>每日特价</span>
					</a>
				</li>
				<li>
					<a href="">
						<img src="${rootPath }/resources/img/severce.png">
						<span>在线客服</span>
					</a>
				</li>
			</ul>
		</div>
		<div class="sevice">
			客服电话：400-000-000
		</div>
	</div>
<%@include file="nav-footer.jsp" %>
</body>
</html>