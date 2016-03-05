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

<@block name="fastNav">
<!-- topbtn -->
   	<div id="div_fastnav" class="fast-nav-wrapper">
   		<ul class="fast-nav">
			<li id="li_top" style="display:list-item">
				<a href="javascript:;">
					<i class="am-icon-angle-up am-icon-md"></i>
				</a>
			</li>
		</ul>	
   	</div>
    <div class="ui-actionsheet">
        <div class="ui-actionsheet-cnt">
            <ul class="ui-list ui-list-text ui-list-cover">
                    <li class="ui-border-t" data-href="product-list-2.html">
                        <span>手机数码</span>
                    </li>
                                <li class="ui-border-t" data-href="product-list-3.html">
                        <span>家用电器</span>
                    </li>
                                <li class="ui-border-t" data-href="product-list-4.html">
                        <span>化妆个护</span>
                    </li>
                                <li class="ui-border-t" data-href="product-list-5.html">
                        <span>日常生活</span>
                    </li>
                                <li class="ui-border-t" data-href="product-list-6.html">
                        <span>美森造型</span>
                    </li>
                        </ul>
            <button class="ui-actionsheet-cancel">取消</button>
        </div>
    </div>
</@block>

<@block name="footer">
	<footer class="am-topbar am-topbar-fixed-bottom" >
  		<ul class="ui-tiled" style="font-size:14px;color:#666;">
	        <a href="${rootPath}/"><li class="ui-border-r <@block name="nav_index"></@block>"><span class="am-icon-home am-icon-md"></span>首页</li></a>
	        <a href="${rootPath}/stage/newest"><li class="ui-border-r <@block name="nav_newest"></@block>"><i class="am-icon-shopping-bag am-icon-sm"></i><div>最新揭晓</div></li></a>
	        <a href="${rootPath}/order/luck/show"><li class="ui-border-r <@block name="nav_show"></@block>"><i class="am-icon-camera-retro am-icon-sm"></i><div>晒单</div></li></a>
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