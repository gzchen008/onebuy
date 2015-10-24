<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
<title>首页</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/index.css">
<script type="text/javascript"
	src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
</head>

<body>
	<div class="header">
		<span class="backspace"></span> <span>广州</span>

		<div class="_search">
			<span></span>

			<form action="${rootPath }/good/search" method="post">
				<input class="search-you-want" type="text" placeholder="告诉小鲜鲜你想吃什么" />
			</form>
		</div>
	</div>

	<div class="container">
		<div class="section" id="sectionOne">
			<img src="${rootPath }/resources/img/4443838_123745222125_2.jpg">
		</div>
		<div class="section">
			<div class="information">
				<span id="Limittime"></span>

				<h3>限时抢购</h3>

				<p>剩余时间：34：42：09</p>
			</div>
			<ul class="bargin-goods">
				<c:forEach items="${tlGoods }" var="tlGood">
					<li><a href="#"><img
							src="${rootPath }/resources/img/vedetable.jpg"></a>

						<p>￥15.9</p></li>
				</c:forEach>
				

			</ul>
		</div>
		<div class="big-divider"></div>
		<div class="section">
			<div class="information">
				<span id="niceGoods"></span>

				<h3>精选商品</h3>
			</div>
			<ul class="nice-list">
				<c:forEach items="${recGoods }" var="good">
					<li><a href="#">
							<div class="goods-detaile">
								<h4>${good.name }</h4>
								<span>${good.quantity }/${good.unit }</span>

								<p>限时包邮</p>
								<span><i>RMB</i>${good.nowPrice }</span>
							</div> <img src="${rootPath }/resources/img/vedetable.jpg">
					</a></li>
				</c:forEach>
				<li><a href="#">
						<div class="goods-detaile">
							<h4>金元帅原始老苹果</h4>
							<span>约2.5kg/箱</span>

							<p>限时包邮</p>
							<span><i>RMB</i>39<i>.9</i></span>
						</div> <img src="${rootPath }/resources/img/vedetable.jpg">
				</a></li>
				<li><a href="#">
						<div class="goods-detaile">
							<h4>金元帅原始老苹果</h4>
							<span>约2.5kg/箱</span>

							<p>限时包邮</p>
							<span><i>RMB</i>39<i>.9</i></span>
						</div> <img src="${rootPath }/resources/img/vedetable.jpg">
				</a></li>
			</ul>
		</div>
	</div>


	<%@include file="nav-footer.jsp"%>
</body>
</html>
