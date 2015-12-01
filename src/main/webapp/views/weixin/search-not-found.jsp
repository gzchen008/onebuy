<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
<title>找不到结果，尝试其它？</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css"
	href="${rootPath }/resources/style/css/search-not-fond.css">
<script type="text/javascript"
	src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
</head>
<body>
	<div class="header">
		<span class="backspace"></span>
		<div class="_search">
			<span id="searchBtn"></span>
			<form id="searchForm" action="${rootPath }/good/search" method="post">
				<input class="search-you-want" type="text" placeholder="告诉小鲜鲜你想吃什么" />
			</form>
			<span></span>
		</div>
	</div>
	<!--<p class="not-fond">臣妾找不到呀，</p>-->
	<!--<p class="other">尝尝其他菜想必极好。</p>-->
	<div class="section">
		<h3>大家都喜欢吃</h3>
		<ul class="love-search">
			<li><a href="#"> <img
					src="${rootPath }/resources/img/vedetable.jpg"> <i>进口小白菜</i>
					<span>￥20</span> <span>500/g</span>
			</a></li>
			<li><a href="#"> <img
					src="${rootPath }/resources/img/vedetable.jpg"> <i>进口小白菜</i>
					<span>￥20</span> <span>500/g</span>
			</a></li>
			<li><a href="#"> <img
					src="${rootPath }/resources/img/vedetable.jpg"> <i>进口小白菜</i>
					<span>￥20</span> <span>500/g</span>
			</a></li>
		</ul>
	</div>
	<script>
		$("#searchBtn").click(function() {
			$("#searchForm").submit();
		});
	</script>
	<script src="${rootPath }/resources/js/comment.js"></script>
	<script type="text/javascript"
		src="${rootPath }/resources/js/common.js"></script>
</body>
</html>