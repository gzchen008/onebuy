<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8"/>
	<title>结算中心</title>
	<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/comment.css">
	<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/payment.css">
	<script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
</head>
<body class="product-info">
	<form action="#" method="#">
		<div class="header">
			<span class="backspace"></span>

			<h3>结算中心</h3>
		</div>

		<div class="container">
			<div class="address">
				<a href="#" class="after-choose-address">
					<span class="address-after"></span>
					<div class="receiver-detail">
						<p>收货人：${address.userName }<i>${address.phoneNum }</i></p>
						<p>收货地址：${address.city }${address.area }${address.liveArea }${address.cabinet }</p>
					</div>
					<span></span>
				</a>
			</div>
			<div class="grey-divider"></div>
			<div class="logo">
				<!-- <img src="#">logo -->
			</div>
			<div class="goods-list">
				<ul>
					<c:forEach items="${shoppingCart.cartItems }" var="shoppingCartItem">
						<li id="${shoppingCartItem.cartItemId}">
							<a href="#">
								<img src="${rootPath }/${shoppingCartItem.good.photoUrl}">
						<span class="right">
							<span class="name">
								<span>${shoppingCartItem.good.name}</span><i>￥${shoppingCartItem.good.nowPrice}</i>
							</span>
							<span class="norms">
								<span>${shoppingCartItem.good.quantity}/${shoppingCartItem.good.unit}</span><i>x${shoppingCartItem.quantity }</i>
							</span>
						</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="regulations">
				<ul>
					<li>
						<a href="#">
							<span>请选择送达时间</span>
							<span><i></i></span>
						</a>
					</li>
					<li>
						<a href="#">
							<span>运费<i class="tip">(全场免费配送)</i></span>
							<span>运费:￥0<i></i></span>
						</a>
					</li>
					<li>
						<a href="#">
							<span>商品总额</span>
							<span><em>￥${shoppingCart.total }</em>共${shoppingCart.amount }件商品</span>
						</a>
					</li>
				</ul>
			</div>
			<div class="grey-divider"></div>
			<div class="regulations balance">
				<ul>
					<li>
						<a href="#">
							<span>红包</span>
							<span>使用红包<i></i></span>
						</a>
					</li>
					<li>
						<a>
							<label for="balance-input">余额<i class="tip">(剩余￥${user.wallet.overage })</i></label>
							<input type="checkbox" name="balance-input" id="balance-input"/>
							<span class="checkbox-simulate off"><span></span></span>
						</a>
					</li>
					<li class="constrain-li">
						<a>
							<label class="constrain" for="integration"><span>可用11鲜积分抵用￥1.1</span><span class="constrain">(满100积分起使用)</span></label>
							<input type="checkbox" name="integration" id="integration"/>
							<span class="checkbox-simulate off"><span></span></span>
						</a>
					</li>
				</ul>
			</div>
			<div class="grey-divider"></div>
			<div class="purchase">
				<h5>请选择支付方式</h5>
				<ul>
					<li>
						<label for="alipay">
							<span class="alipay-icon"></span>
							<input type="radio" name="format" value="alipay" id="alipay" checked="checked"/> 支付宝
							<i class="way"></i>
						</label>
					</li>
					<li>
						<label for="wechat">
							<span class="wechat-icon"></span>
							<input type="radio" name="format" value="wechat" id="wechat"/> 微信支付
							<i class="way"></i>
						</label>
					</li>
					<li>
						<label for="card">
							<span class="card-icon"></span>
							<input type="radio" name="format" value="card" id="card"/> 银行卡
							<i class="way"></i>
						</label>
					</li>
				</ul>
			</div>
		</div>
		<div class="pay">
			<span>合计:</span>
			<i>￥${shoppingCart.total }</i>
			<button type="submit">买单</button>
		</div>
	</form>
	<script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="${rootPath }/resources/js/payway.js"></script>
</body>
</html>