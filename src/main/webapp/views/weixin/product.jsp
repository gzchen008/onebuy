<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%
	request.setAttribute("footer_active", 1);
%>
<!DOCTYPE html>
<html ng-app="app">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/Product.css">
<title>菜园子</title>
</head>
<body>
	<!--<p class="show-px-lzh"></p>-->
	<div class="header">
		<a class="home" href="#"><span class="logo"></span><em
			class="adjust-home-icon"><span class="home-icon"></span><span
				class="home-text">首页</span></em></a> <span class="vegetable-garden">菜园子</span>
	</div>
	<div class="search">
		<div class="_search">
			<span class="search-icon"></span>
			<form action="${rootPath }/good/search" method="post">
				<input name="keywords" class="search-you-want" type="search"
					placeholder="告诉小鲜鲜你想吃什么" />
			</form>
			<span></span>
		</div>
	</div>
	<div class="container">
		<div class="content">
			<div class="left-assortment">
				<ul>
					<li><a href="${rootPath }/good/product?kid=1"><c:if
								test="${currentKid eq 1 }">
								<span class="current">
							</c:if><span><span class="vegetable"></span><em>蔬菜&蛋</em> <c:if
									test="${currentKid eq 1 }"></span> </c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=2"><c:if
								test="${currentKid eq 2 }">
								<span class="current">
							</c:if><span><span class="meat"></span><em>小鲜肉</em></span> <c:if
								test="${currentKid eq 2 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=3"><c:if
								test="${currentKid eq 3 }">
								<span class="current">
							</c:if><span><span class="see"></span><em>海的味道</em></span> <c:if
								test="${currentKid eq 3 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=4"><c:if
								test="${currentKid eq 4 }">
								<span class="current">
							</c:if><span><span class="mother"></span><em>妈妈菜</em></span> <c:if
								test="${currentKid eq 4 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=5"> <c:if
								test="${currentKid eq 5 }">
								<span class="current">
							</c:if><span><span class="prior"></span><em>珍品优先</em></span> <c:if
								test="${currentKid eq 5 }">
								</span>
							</c:if></a></li>
					<li><a href="${rootPath }/good/product?kid=6"> <c:if
								test="${currentKid eq 6 }">
								<span class="current">
							</c:if><span><span class="bargain-price"></span><em>每日特价</em></span> <c:if
								test="${currentKid eq 6 }">
								</span>
							</c:if></a></li>
					<%-- <c:forEach items="${kinds }" var="kind">
						<li><a href="#"><span class="current"><span class="vegetable"></span><em>蔬菜&蛋</em></span></a></li>
					</c:forEach> --%>
				</ul>
			</div>
			<div id="for-touch" class="right-detail">
				<ul>
					<c:forEach items="${goods}" var="good" varStatus="i">
						<li>
							<div class="shop-detail">
								<a href="${rootPath }/good/product-info?gid=${good.gid}"> <img
									src="${rootPath }${good.photoUrl}">
									<div class="_detail">
										<p>${good.name }</p>
										<strong>推荐菜式：${good.dishes }等</strong> <i>${good.quantity }/${good.unit }</i>
										<span>￥${good.nowPrice }</span>
										<div class="old-price">
											<div class="old">￥${good.oldPrice }</div>
											<div class="first-line"></div>
											<div class="second-line"></div>
										</div>
									</div>
								</a>
							</div>
							<p class="slogan">无污染更健康</p>
							<div class="shopping-num">
								<span class="countBtn" action="1"></span> <input type="text"
									class="count" value="0" id="num" gid="${good.gid }" disabled="disabled" /> <span
									class="countBtn" action="2"></span>
							</div>
						</li>
					</c:forEach>

				</ul>
			</div>
		</div>
	</div>
	<%@include file="nav-footer.jsp"%>
	<!--<p class="test"></p>-->

	<%-- <script type="text/javascript"
		src="${rootPath }/resources/js/angular.min.js"></script>
	<script type="text/javascript"
		src="${rootPath }/resources/js/controllers.js"></script> --%>
	<script type="text/javascript"
		src="${rootPath }/resources/js/Product.js"></script>

	<!-- cgz -->
	<script type="text/javascript">
		var cartdata = ${cartdata};
		$.each(cartdata, function(i, e) {
			$("input[gid='" + e.gid + "']").val(e.count);
		});
	</script>
	<script>
		var quantity, gid;

		$(".countBtn").click(function() {
			if ($(this).attr("action") == "1") {
				quantity = parseInt($(this).parent().find(".count").val()) - 1;
				if(quantity < 0){
					quantity = 0;
				}
			} else {
				quantity = parseInt($(this).parent().find(".count").val()) + 1;
			}
			$(this).parent().find(".count").val(quantity);
			gid = $(this).parent().find(".count").attr("gid");
			//后台同步
			var json = {
				goodId : gid,
				count : quantity
			};
			$.ajax({
				type : 'POST',
				url : '${rootPath}/cart/updateCart',
				data : json,
				success : function(res) {
				},
				error : function() {
					alert("网络异常");
				}
			});
		});
	</script>
	<script type="text/javascript">
		$("input[name=keywords]").blur(function(){
			alert($(this).val());
		});
	</script>
</body>
</html>