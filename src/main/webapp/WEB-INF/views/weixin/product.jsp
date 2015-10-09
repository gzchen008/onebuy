<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/Product.css">
<title>产品</title>
</head>
<body>
	<!--<p class="show-px-lzh"></p>-->
	<div class="header">
		<span class="backspace"></span>
		<h3>产品</h3>
		<span class="share"></span>
	</div>
	<div class="search">
		<a href="#" class="_search"> <span class="search-icon"></span> <span
			class="search-want">搜索你想吃的</span>
		</a>
	</div>
	<div class="container">
		<div class="content">
			<div class="left-assortment">
				<ul>
					<li><a href="${rootPath }/good/product?kid=1"><c:if
								test="${currentKid eq 1 }">
								<span class="current">
							</c:if><span><span class="vegetable"></span><em>蔬菜&蛋</em>
						<c:if test="${currentKid eq 1 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=2"><c:if
								test="${currentKid eq 2 }">
								<span class="current">
							</c:if><span><span class="meat"></span><em>小鲜肉</em></span><c:if test="${currentKid eq 2 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=3"><c:if
								test="${currentKid eq 3 }">
								<span class="current">
							</c:if><span><span
								class="see"></span><em>海的味道</em></span><c:if test="${currentKid eq 3 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=4"><c:if
								test="${currentKid eq 4 }">
								<span class="current">
							</c:if><span><span
								class="mother"></span><em>妈妈菜</em></span><c:if test="${currentKid eq 4 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=5">
					<c:if
								test="${currentKid eq 5 }">
								<span class="current">
							</c:if><span><span
								class="prior"></span><em>珍品优先</em></span><c:if test="${currentKid eq 5 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=6">
					<c:if
								test="${currentKid eq 6 }">
								<span class="current">
							</c:if><span><span
								class="bargain-price"></span><em>每日特价</em></span><c:if test="${currentKid eq 6 }">
								</span>
							</c:if></a></li>
					<%-- <c:forEach items="${kinds }" var="kind">
						<li><a href="#"><span class="current"><span class="vegetable"></span><em>蔬菜&蛋</em></span></a></li>
					</c:forEach> --%>
				</ul>
			</div>
			<div id="for-touch" class="right-detail">
				<ul>
					<c:forEach items="${goods}" var="good">
						<li>
							<div class="shop-detail">
								<a href="${rootPath }/good/product-info?gid=${good.gid}"> <img
									src="${rootPath }${good.photoUrl}">
									<div class="_detail">
										<p>${good.name }</p>
										<span>￥${good.nowPrice }</span> <i>${good.quantity }/${good.unit }</i>
									</div>
								</a>
							</div> <a class="shopping-car"></a>
							<div class="shopping-num">
								<span></span> <input type="text" class="count" value="0" /> <span></span>
							</div>
						</li>
					</c:forEach>
					
				</ul>
			</div>
		</div>
	</div>
	<%@include file="nav-footer.jsp" %>
	<!--<p class="test"></p>-->
	<script type="text/javascript"
		src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
	<script type="text/javascript"
		src="${rootPath }/resources/js/Product.js"></script>
</body>
</html>