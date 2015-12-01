<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
<title>我的地址</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/payment.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/address-history.css">

</head>
<body>
	<div class="header">
		<span class="backspace"></span>

		<h3>我的地址</h3>
		<a href="${rootPath}/address/myaddressAdd">
			<button>新增</button>
		</a>
	</div>

	<div class="container">
		<ul>
			<c:forEach items="${lsAddr }" var="addr">
				<li>
					<div class="address">
						<a href="#" class="after-choose-address"> <span
							class="address-after"></span>

							<div class="receiver-detail">
								<p>
									收货人：${addr.userName}<i>${addr.phoneNum}</i>
								</p>

								<p>收货地址：${addr.city}${addr.area}${addr.liveArea}${addr.cabinet}</p>
							</div> <span class="delet-address"></span>
						</a>
					</div>
					<div class="grey-divider"></div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<script type="text/javascript"
		src="${rootPath }/resources/js/jquery-1.11.2.js"></script>

	<script type="text/javascript"
		src="${rootPath }/resources/js/common.js"></script>

</body>
</html>