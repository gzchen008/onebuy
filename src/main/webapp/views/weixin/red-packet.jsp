<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
<title>我的红包</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/red-packet.css">
</head>
<body>
	<div class="header">
		<span class="backspace"></span>
		<h3>红包</h3>
	</div>

	<div class="container">
		<div class="bg"></div>
		<ul class="red-list">
			<c:forEach items="${packets }" var="packet">

				<li><a href="#">
						<div class="relative">
							<span>${packet.money }元</span> <i>满${packet.lowestMoney }元起用</i>
							<p>有效期至${packet.dueDate }</p>
							<p>还有5天过期</p>
						</div>
				</a></li>
			</c:forEach>

		</ul>
	</div>
	<script type="text/javascript"
		src="${rootPath }/resources/js/jquery-1.11.2.js"></script>

	<script type="text/javascript"
		src="${rootPath }/resources/js/common.js"></script>
</body>
</html>