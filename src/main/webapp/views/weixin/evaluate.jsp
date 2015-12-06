<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
<title>评价</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/payment.css">
</head>
<body class="product-info">
	<form action="${ rootPath}/eval/saveEval" method="post">
		<input type="hidden" value="${order.oid }" name="oid"/>
		<input type="hidden" value="${order.merchant.mid }" name="mid"/>
		<input type="hidden" value="${order.user.uid }" name="uid"/>
		<div class="header">
			<span class="backspace"></span>

			<h3>评价</h3>
		</div>

		<div class="container">
			<div class="evaluate-content">
				<ul>
					<c:forEach items="${order.goods }" var="orederItem">
						<li>
							<div class="text-evaluate">
								<div class="pic">
									<img src="${rootPath }${orederItem.good.photoUrl}">

									<p>${orederItem.good.name}</p>
								</div>
								<textarea name="comment" placeholder="请写下你对此宝贝的评价哦"></textarea>
							</div>
							<div class="wrap">
								<h3>星级</h3>

								<div class="range">
									<ul>
										<li><span status="1" class="star"></span></li>
										<li><span status="1" class="star"></span></li>
										<li><span status="1" class="star"></span></li>
										<li><span status="1" class="star"></span></li>
										<li><span status="1" class="star"></span></li>
									</ul>
									<input class="starts-count hidden" type="text" name="fraction" value="1" />
									<input type="hidden" name="gid" value="${orederItem.good.gid }" />
								</div>
							</div>
						</li>
						<div class="grey-divider"></div>
					</c:forEach>
				</ul>
			</div>

			<div class="pay">
				<button type="submit" id="sub-evaluation">提交</button>
			</div>

			<!-- //弹出框 -->
			<div id="mask"></div>
			<div id="dialog" class="no-bg">
				<img class="bg-evaluation" src="${rootPath }/resources/img/17.2.png"> <span id="close"></span>

				<p class="thank">感谢您宝贵的评价，</p>

				<p class="thank">获得***，</p>

				<p class="thank">我们会认真听取珍藏的</p>
				<button class="continue" id="evaluate-continue">继续逛菜园子</button>
			</div>
		</div>
	</form>

	<script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="${rootPath }/resources/js/regular.js"></script>
	<script type="text/javascript" src="${rootPath }/resources/js/payway-cgz.js"></script>
	<script type="text/javascript" src="${rootPath }/resources/js/common.js"></script>
</body>
</html>