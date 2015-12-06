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
		<div class="header">
			<span class="backspace"></span>
			<h3>感谢评价</h3>
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

	<script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="${rootPath }/resources/js/regular.js"></script>
	<script type="text/javascript" src="${rootPath }/resources/js/common.js"></script>
	<script>
		//弹出层
		setElement.g('dialog').style.display = 'block';
		setElement.g('mask').style.display = 'block';
		setElement.autoCenter(setElement.g('dialog'));
		setElement.fillToBody(setElement.g('mask'));
		//继续
		$("#evaluate-continue").click(function(){
			window.location="${rootPath}/good/product";
		});
		
	</script>
</body>
</html>