<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="apple-touch-fullscreen" content="YES">
    <title><@block name="title">一元云购</@block></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${wxAssets}/css/amazeui.min.css">
    <link rel="stylesheet" href="${wxAssets}/css/frozen.css">
  	<link rel="stylesheet" href="${wxAssets}/css/main.css">
  	<@block name="css"></@block>
    </head>
<body>
<@block name="header">
	<header class="ui-header ui-header-positive headh1" style="background-color: #ff0000!important;">
	    <a href="index.html"><i class="am-header-icon am-icon-home am-icon-sm"></i></a>
	    <h1>一元云购</h1>
	    <i class="am-header-icon am-icon-bars am-icon-sm" id="fenlei"></i>
	</header>
</@block>

<@block name="content">
</@block>

<@block name="footer">
	<footer class="am-topbar am-topbar-fixed-bottom" >
  		<ul class="ui-tiled" style="font-size:14px;color:#666;">
	        <a href="${rootPath}/"><li class="ui-border-r <@block name="nav_index"></@block>"><span class="am-icon-home am-icon-md"></span>首页</li></a>
	        <a href="${rootPath}/stage/newest"><li class="ui-border-r <@block name="nav_newest"></@block>"><i class="am-icon-shopping-bag am-icon-sm"></i><div>最新揭晓</div></li></a>
	        <a href="${rootPath}/order/lucky/show"><li class="ui-border-r <@block name="nav_show"></@block>"><i class="am-icon-camera-retro am-icon-sm"></i><div>晒单</div></li></a>
	        <a href="${rootPath}/member/cart"><li class="ui-border-r <@block name="nav_cart"></@block>"><span class="am-icon-shopping-cart am-icon-sm"></span><div>购物车</div></li></a>
	        <a href="${rootPath}/member/profile"><li   class="ui-border-r <@block name="nav_profile"></@block>"><i class="am-icon-user-plus am-icon-sm"></i><div>我的</div></li></a>
    	</ul>
	</footer>
</@block>

    <script type="text/javascript" src="${wxAssets}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${wxAssets}/js/amazeui.min.js"></script>
    <script type="text/javascript" src="${wxAssets}/js/main.js"></script>
    <@block name="scripts"></@block>
</body>
</html>