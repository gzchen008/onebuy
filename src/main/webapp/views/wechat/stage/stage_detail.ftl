<@override name="content">
	<!-- main content -->
 <#if stage ??>
    <div class="issue"><!-- 期数列表 -->
        <ul>
            <li><span class="am-icon-angle-left .am-icon-lg angle_left"></span></li>
            <li><a href="#" class="hover">第${stage.num!}期</a></li>
            <li><span class="am-icon-angle-right .am-icon-lg angle-right"></span></li>
        </ul>
    </div>
    <div class="am-slider am-slider-default" data-am-flexslider id="demo-slider-0">
      <ul class="am-slides">
        		<li><img src="${stage.good.mainPhoto!}" /></li>
      </ul>
    </div>
    <ul class="ui-list ui-border-tb ui-list-cover" style="margin-top:5px;">
        <li class="ui-border-b">
            <h4 class="ui-list-info">(<#if stage.id ??>第${stage.num!}期<#else>未开始</#if>) ${stage.good.name!} 
                <span class="ui-txt-red">${stage.good.description!}</span>
            </h4>
        </li>
        <li>
            <div class="ui-list-info ui-fontsize-14">
                <ul class="ui-row ui-txt-info">
                    <li class="ui-col ui-col-50 ui-align-left">价值：￥${(stage.totalPrice?string("0.00"))!}</li>
                    <li class="ui-col ui-col-50 ui-align-right"></li>
                </ul>
                <div class="ui-progress ui-border-radius" style="margin-bottom:5px;">
                    <span style="width:${(stage.purchasedQuantity / stage.quantity *100 )!}%"></span>
                </div>
                <ul class="ui-row ui-txt-info" style="line-height:120%;margin-top:8px;">
                    <li class="ui-col ui-col-33" style="text-align:left;"><span class="ui-txt-red">${stage.purchasedQuantity!}</span><br/>已参与</li>
                    <li class="ui-col ui-col-33" style="text-align:center;">${stage.quantity!}<br/>总需份数</li>
                    <li class="ui-col ui-col-33" style="text-align:right;">${(stage.quantity - stage.purchasedQuantity)!}<br/>剩余</li>
                </ul>
                <div id="for_lucky" style="position:relative;"></div>
                <div class="ui-align-center ui-border-radius" style="padding:5px; background-color:#e4e4e4; margin-top:10px;">
                    <h5 class="ui-txt-info">您没有参与本期哦</h5>
                </div>
            </div>
        </li>
        <li class="ui-border-t">
            <div class="ui-list-info">
                <ul class="ui-row">
                    <li class="ui-col ui-col-40">
                        <div style="padding:0 5px 0 5px">
                            <button data-act="link" data-val="186" class="ui-btn ui-btn-md ui-btn-danger" style="width:100%;">立即购买</button>
                        </div>
                    </li>
                    <li class="ui-col ui-col-40">
                        <div style="padding:0 5px 0 5px">
                            <button id="addToCartBtn" data-act="cart" data-val="186" class="ui-btn ui-btn-md ui-btn-primary" style="width:100%;">加入购物车</button>
                        </div>
                    </li>
                    <li class="ui-col ui-col-15 ui-align-right" data-href="cart.html">
                        <div>
                            <i class="am-icon-shopping-cart" style="font-size:250%;position: relative;"><span class="ui-tag ui-tag-num" style="display:none;">0</span></i>
                        </div>
                    </li>
                </ul>
            </div>
        </li>
    </ul>
    <div class="ann_btn">
        <a href="join_detail.html">参与记录<s class="fr am-icon-angle-right"></s></a>
        <a href="pw_detail.html">图文详情<em>(建议在wifi下使用)</em><s class="fr am-icon-angle-right"></s></a>
        <a href="product_share.html">商品晒单<s class="fr am-icon-angle-right"></s></a>
    </div>
   </#if>
</@override>

<@override name="scripts">
	<script type="text/javascript">
		var DATA = {
		 <#if stage ??>
			stage : {
				id 					:	 ${stage.id!null},
				goodName  :  	 "${stage.good.name!}",
				price				: 	 ${stage.price!0}
				
			}
		</#if>
		}
	</script>
	<script  src="${wxAssets}/js/pages/stage_detail.js"></script>
</@override>
<@extends name="../common/base.ftl"/>