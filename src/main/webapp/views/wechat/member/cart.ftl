<@override name="header"/>
<@override name="content">
    <div class="mask"></div>
    <div class="g-Cart-list">
        <ul id="cartBody">
            <li>
                <a href="#" class="fl u-Cart-img">
                    <img src="images/1.jpg" alt="商品">
                </a>
                <div class="u-Cart-r">
                    <a href="#" class="gray6"><strong>已更新至第70766云</strong>(第1492云)金宝盈 黄金招财猫手机壳装饰品 Au999 0.2g</a>
                    <span class="gray9">
                        <em>剩余10人次</em>
                    </span>
                    <div class="num-opt">
                        <em class="num-mius dis" id="nummius">
                            <i class="am-icon-minus"></i>
                        </em>
                        <input id="txtNum" name="pnum" maxlength="7" type="number" class="gray6" value="1">
                        <em class="numadd" id="numadd">
                            <i class="am-icon-plus"></i>
                        </em>
                        <a href="javascript:;" name="delLink" class="z-del" id="delLink">
                            <i class="am-icon-trash-o am-icon-md"></i>
                        </a>
                    </div>
                </div>
            </li>
        </ul>
    </div>
   
    <div class="g-Total-bt g-car-new" id="mycartpay">
        <dl>
            <dt class="gray6">
                <p class="money-total">合计<em class="green"><span>￥</span>1.00</em></p>
                <p class="pro-total">共<em>1</em>个商品</p>
            </dt>
            <dd>
                <a href="javascript:;" id="a_payment" class="greenBtn w_account">去结算</a>
            </dd>
        </dl>
    </div>
    <!-- confirm delete -->
    <div id="pageDialog" class="pageDialog">
        <div class="clearfix m-round u-tipsEject">
            <div class="u-tips-txt">您确定要删除吗？</div>
            <div class="u-Btn">
                <div class="u-Btn-li">
                    <a href="javascript:;" id="btnMsgCancel" class="z-CloseBtn">取消</a>
                </div>
                <div class="u-Btn-li">
                    <a href="javascript:;" id="btnMsgOk" class="z-DefineBtn">确定</a>
                </div>            
            </div>
        </div>
    </div>
    <!--  when cart is empty -->
    <div id="divNone" class="empty" style="display: none">
        <s class="am-icon-cart-plus am-icon-lg"></s>
        购物车为空
    </div>
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
</@override>
<@override name="nav_cart">active</@override>
<@extends name="../common/base.ftl"/>