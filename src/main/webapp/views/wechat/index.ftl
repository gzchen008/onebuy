<@override name="content">
	<!-- 轮播 -->
	<div class="am-slider am-slider-default" data-am-flexslider id="demo-slider-0">
	  <ul class="am-slides">
	  	<#if carouselAdsList ??>
	  		<#list carouselAdsList as carouselAds>
				<li><img src="${wxAssets}/${carouselAds.photo}" /></li>
			</#list>
		</#if>
	    <li><img src="${wxAssets}/images/2.jpg" /></li>
	  </ul>
	</div>
	<!-- 今日上新 -->
	<ul class="ui-row ui-row-padding" style="margin-top:10px;background:#fff;">
            <li class="ui-col ui-col-50"><span style="color:red;">今日新品</span></li>
            <li class="ui-col ui-col-50 txt-right"><span class="ui-txt-info" data-href="latests.html">更多</span></li>
    </ul>
	<ul class="ui-row ui-row-padding ui-border-r zxpadding" style="background-color:#fff;">
		<#if newGoodList ??>
			<#list newGoodList as good>
		        <li data-url="${rootPath}/stage/product/${good.id!}/detail" class="ui-col ui-col-50 ui-border-r zxli" data-href="buy-78.html">
		        	<div class="ui-list-pic" style="margin:0 auto;">
		                 <img src="${good.mainPhoto!}" alt="${good.name!}">
		            </div>	       
		        	<h4 class="ui-nowrap" style="margin-top:5px;">${good.name!}</h4>
		        </li>
	        </#list>
	    </#if>
    </ul>
	<#-- 人气精选 -->
	<ul class="ui-row ui-row-padding" style="margin-top:8px;background:#fff;">
        <li class="ui-col ui-col-50"><span style="color:red;">人气精选</span></li>
        <li class="ui-col ui-col-50 txt-right"><span class="ui-txt-info" data-url="product.html">更多</span></li>
    </ul>
	
	<ul id="lists" class="ui-row ui-row-padding ui-border-b index-list" style="background:#ffffff;">
	<#if recommendStageList ??>
       <#list recommendStageList as stage>
	        <li class="ui-col ui-col-50 zxli" data-href="product-info-208.html" style="position:relative;">
		       	<div class="ui-list-pic" style="margin:0 auto;">
	                 <img src="${stage.good.mainPhoto!}" alt="${stage.good.name!}">
	            </div>	 
		        <h4 class="ui-nowrap">${stage.good.name!}</h4>
		        <h5 class="ui-txt-info">价值：￥${stage.totalPrice!}</h5>
		     	<div class="ui-progress ui-border-radius">
		            <span style="width:94.3%"></span>
		        </div>
		       <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
		            <li class="ui-col ui-col-50" style="text-align:left;">${stage.purchasedQuantity!}已参与</li>
		            <li class="ui-col ui-col-50" style="text-align:right;">剩余 ${stage.quantity - stage.purchasedQuantity }</li>
		        </ul>
	            <div class="btn-wrap">
	                <a href="javascript:;" class="buy-btn">立即一元云购</a>
	            </div>
	        </li>
        </#list>
    </#if>
    </ul class="end">
   <!--  <div class="load-more" data-loading="正在加载中..." data-done="加载完成"></div> -->
</@override>
<@override name="scripts"><script  src="${wxAssets}/js/pages/index.js"></script></@override>
<@override name="nav_index">active</@override>
<@extends name="common/base.ftl"/>