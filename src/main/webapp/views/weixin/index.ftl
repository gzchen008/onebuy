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
	    <li><img src="${wxAssets}/images/3.jpg" /></li>
	    <li><img src="${wxAssets}/images/4.jpg" /></li>
	    <li><img src="${wxAssets}/images/1.jpg" /></li>
	  </ul>
	</div>
	<!-- 今日上新 -->
	<ul class="ui-row ui-row-padding" style="margin-top:10px;background:#fff;">
            <li class="ui-col ui-col-50"><span style="color:red;">今日新品</span></li>
            <li class="ui-col ui-col-50 txt-right"><span class="ui-txt-info" data-href="latests.html">更多</span></li>
    </ul>
	<ul class="ui-row ui-row-padding ui-border-r zxpadding" style="background-color:#fff;">
        <li class="ui-col ui-col-50 ui-border-r zxli" data-href="buy-78.html">
        	<div class="ui-list-pic" style="margin:0 auto;">
                 <img src="images/1.jpg" alt="左边">
            </div>	       
        	<h4 class="ui-nowrap" style="margin-top:5px;">【每日八点半价-极品铁观音】清香型茶叶铁观音礼盒装/1斤</h4>
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 ui-border-r" data-href="buy-77.html">
            <div class="ui-list-pic" style="margin:0 auto;">
                 <img src="images/2.jpg" alt="右边">
            </div>	 
            <h4 class="ui-nowrap" style="margin-top:5px;">【SYMA司马航模X5SW】 无人机遥控飞机</h4>
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
    </ul>
	<!-- 人气精选 -->
	<ul class="ui-row ui-row-padding" style="margin-top:8px;background:#fff;">
        <li class="ui-col ui-col-50"><span style="color:red;">人气精选</span></li>
        <li class="ui-col ui-col-50 txt-right"><span class="ui-txt-info" data-href="product.html">更多</span></li>
    </ul>
	
	<ul id="lists" class="ui-row ui-row-padding ui-border-b index-list" style="background:#ffffff;">
       <#list recommendStageList as stage>
	        <li class="ui-col ui-col-50 zxli" data-href="product-info-208.html" style="position:relative;">
		       	<div class="ui-list-pic" style="margin:0 auto;">
	                 <img src="images/1.jpg" alt="左边">
	            </div>	 
		        <h4 class="ui-nowrap">${stage.name}</h4>
		        <h5 class="ui-txt-info">价值：￥${stage.price!}</h5>
		     	<div class="ui-progress ui-border-radius">
		            <span style="width:94.3%"></span>
		        </div>
		      <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
		            <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
		            <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
		        </ul> -->
	            <div class="btn-wrap">
	                <a href="javascript:;" class="buy-btn">立即一元云购</a>
	            </div>
	        </li>
        </#list>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-190.html" style="position:relative;">
           	<div class="ui-list-pic" style="margin:0 auto;">
                 <img src="images/2.jpg" alt="左边">
            </div>	 
            <h4 class="ui-nowrap">【合胜影城】面值100元 电影票一张</h4>
            <h5 class="ui-txt-info">价值：￥100.00</h5>
            <div class="ui-progress ui-border-radius">
                <span style="width:92.0%"></span>
            </div>
           <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-131.html" style="position:relative;">
           	<div class="ui-list-pic" style="margin:0 auto;">
                 <img src="images/3.jpg" alt="左边">
            </div>	 
            <h4 class="ui-nowrap">飞利浦（PHILIPS）49PUF6050/T3 49英寸8核真4K安卓LED电视机</h4>
           	<h5 class="ui-txt-info">价值：￥3688.00</h5>
            <div class="ui-progress ui-border-radius">
                <span style="width:90.2%"></span>
            </div>
            <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-220.html" style="position:relative;">
         	<div class="ui-list-pic" style="margin:0 auto;">
                 <img src="images/4.jpg" alt="左边">
            </div>	 
            <h4 class="ui-nowrap">玻璃杯便携运动车载杯.男女可爱随手杯带盖水杯</h4>
            <h5 class="ui-txt-info">价值：￥28.00</h5>
            <div class="ui-progress ui-border-radius">
                <span style="width:85.7%"></span>
            </div>
            <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-199.html" style="position:relative;">
           	<div class="ui-list-pic" style="margin:0 auto;">
                 <img src="images/1.jpg" alt="左边">
            </div>	 
            <h4 class="ui-nowrap">Apple iPhone 6s plus 5.5 64G 颜色随机 移动联通电信4G手机</h4>
            <h5 class="ui-txt-info">价值：￥6888.00</h5>
            <div class="ui-progress ui-border-radius">
                <span style="width:85.2%"></span>
            </div>
            <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-178.html" style="position:relative;">
           	<div class="ui-list-pic" style="margin:0 auto;">
                <img src="images/2.jpg" alt="左边">
            </div>	 
            <h4 class="ui-nowrap">鲁花5S一级花生油3.68L 物理压榨食用油 健康</h4>
            <h5 class="ui-txt-info">价值：￥118.00</h5>
          	<div class="ui-progress ui-border-radius">
                <span style="width:84.7%"></span>
            </div>
            <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-179.html" style="position:relative;">
           	<div class="ui-list-pic" style="margin:0 auto;">
                <img src="images/3.jpg" alt="左边">
            </div>	 
            <h4 class="ui-nowrap">【羽绒被】100%全棉防羽布</h4>
            <h5 class="ui-txt-info">价值：￥288.00</h5>
            <div class="ui-progress ui-border-radius">
                <span style="width:84.7%"></span>
            </div>
            <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-192.html" style="position:relative;">
            <div class="ui-list-pic" style="margin:0 auto;">
                 <img src="images/4.jpg" alt="左边">
           	</div>	 
            <h4 class="ui-nowrap">【暖手袋】3D猫星人暖手袋~萌死你</h4>
            <h5 class="ui-txt-info">价值：￥88.00</h5>
            <div class="ui-progress ui-border-radius">
                <span style="width:84.1%"></span>
            </div>
            <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-182.html" style="position:relative;">
           	<div class="ui-list-pic" style="margin:0 auto;">
                <img src="images/1.jpg" alt="左边">
            </div>	 
            <h4 class="ui-nowrap">【金嫂子】金福豪华三件套锅高档铁锅不粘锅炒锅汤锅奶锅永康礼品套装</h4>
            <h5 class="ui-txt-info">价值：￥268.00</h5>
            <div class="ui-progress ui-border-radius">
                <span style="width:82.8%"></span>
            </div>
         	 <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
        <li class="ui-col ui-col-50 zxli" data-href="product-info-186.html" style="position:relative;">
           	<div class="ui-list-pic" style="margin:0 auto;">
                <img src="images/2.jpg" alt="左边">
            </div>	 
            <h4 class="ui-nowrap">华为 HUAWEI WATCH 华为手表 经典系列（星河银） 黑色尖尾真皮表带</h4>
            <h5 class="ui-txt-info">价值：￥2888.00</h5>
            <div class="ui-progress ui-border-radius">
                <span style="width:82.8%"></span>
            </div>
           <!--   <ul class="ui-row ui-txt-info ui-fontsize-14" style="line-height:120%;">
                <li class="ui-col ui-col-50" style="text-align:left;">14 已参与</li>
                <li class="ui-col ui-col-50" style="text-align:right;">剩余 9</li>
            </ul> -->
            <div class="btn-wrap">
                <a href="javascript:;" class="buy-btn">立即一元云购</a>
            </div>
        </li>
    </ul class="end">
   <!--  <div class="load-more" data-loading="正在加载中..." data-done="加载完成"></div> -->
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
</@override>
<@extends name="common/base.ftl"/>