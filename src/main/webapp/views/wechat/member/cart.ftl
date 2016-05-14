<@override name="header"/>
<@override name="content">
    <div class="mask"></div>
    <div class="max-con"></div>
    <div class="g-Cart-list">
        <ul id="cartBody">
        </ul>
    </div>
    <div class="g-Total-bt g-car-new" id="mycartpay">
        <dl>
            <dt class="gray6">
                <p class="money-total">合计<em class="green">￥<span class="consume_cnt">0.00</span></em></p>
                <p class="pro-total">共<em class="good_cnt">0</em>个商品</p>
            </dt>
            <dd>
                <a href="javascript:;" id="a_payment" class="greenBtn w_account">去结算</a>
            </dd>
        </dl>
    </div>
    <script>
    function update_sum(){
        var good_cnt=0;
        var consume_cnt=0;
        for(var goodid in cache_cart){
            consume_cnt+=cache_cart[goodid];
            good_cnt++;
        }
        $(".consume_cnt").html(parseInt(consume_cnt)+".00");
        $(".good_cnt").html(good_cnt);
        if(good_cnt==0){
            $("#mycartpay").css("display","none");
            setTimeout(function empty(){
	$("#divNone").css("display","block");	
            },300);
        }else{
            $("#mycartpay").css("display","block");
            setTimeout(function empty(){
	$("#divNone").css("display","none");	
            },300);
        }
    }
    </script>
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
    <script type="text/tpl" id="maxgoodid">
        <strong>已更新至第<span class="cls_maxgoodid"><%=arguments[0]%></span>云</strong>
    </script>
    <script type="text/tpl" id="goodtpl">
            <li class="li<%=arguments[1]%>">
                <a href="#" class="fl u-Cart-img">
                    <img class="goodicon" src="<%=arguments[0]%>" alt="商品">
                </a>
                <div class="u-Cart-r">
                    <a href="#" class="gray6">(第<span class="goodid"><%=arguments[1]%></span>云)<span class="desc"><%=arguments[2]%></span></a>
                    <span class="gray9">
                        <em>剩余<span class="res"><%=arguments[3]%></span>人次</em>
                    </span>
                    <div class="num-opt">
                        <em class="num-mius dis" rel="<%=arguments[1]%>">
                            <i class="am-icon-minus"></i>
                        </em>
                        <input id="txtNum" name="pnum" maxlength="7"  class="gray6 mynum" value="<%=arguments[4]%>">
                        <em class="numadd" class="numadd" rel="<%=arguments[1]%>">
                            <i class="am-icon-plus"></i>
                        </em>
                        <a href="javascript:;" name="delLink" class="z-del delLink" rel="<%=arguments[1]%>">
                            <i class="am-icon-trash-o am-icon-md"></i>
                        </a>
                    </div>
                </div>
            </li>
    </script>
    <script type="text/javascript">

    var $_ul=$("#cartBody");
    console.log($_ul);
    //cart.html
    //confirm delete
    $_ul.on('click',".delLink",function(){
                var goodid=$(this).attr('rel');
    	$(".mask").fadeIn(200);
    	setTimeout(function time(){
    		$("#pageDialog").css("display","block")
    	}, 300);
    	$("#btnMsgCancel").on('click',function(){
    		$("#pageDialog").css("display","none");
    		$(".mask").fadeOut(200);
    	});
    	$("#btnMsgOk").on('click',function(){
                                setdata("test_data/user/"+userid+".json",goodid,0,function(result,res,num){
                                  if(num==0){
                                   $(".li"+goodid).remove();
                                   delete cache_cart[goodid];
                                  }  
                                })
		
                                update_sum();
    		
    		$("#pageDialog").css("display","none");
    		$(".mask").fadeOut(200);

    	});
    });
    $_ul.on('click',".num-mius",function(){
        var goodid=$(this).attr('rel');

        var mynum=parseInt($(".li"+goodid+" .mynum").val());
        mynum=mynum-1;

        var res=parseInt(cache_goods[goodid].res);
        res=res+1;
        if(mynum>=1){
            setdata("test_data/user/"+userid+".json",goodid,mynum,function(result,res,num){
                $(".li"+goodid+" .mynum").val(num);
                cache_goods[goodid].res=res;
                update_good(goodid);
            });
        }
    });
    $_ul.on('click',".numadd",function(){
        var goodid=$(this).attr('rel');

        var mynum=parseInt($(".li"+goodid+" .mynum").val());
        mynum=mynum+1;
        setdata("test_data/user/"+userid+".json",goodid,mynum,function(result,res,num){
            $(".li"+goodid+" .mynum").val(num);
            cache_goods[goodid].res=res;
            update_good(goodid);
        });
        
    });
    </script>
<script type="text/javascript">
//这是模拟数据
var emulate={
"test_data/sys.json":
	/*当前最大的云购id*/
	{
	    maxgoodid:"4387",
	},
"test_data/good/8388.json":
	{
	    desc:"珍藏包包",
	    res:"304",
	    icon:"images/2.jpg",
	},
"test_data/good/8389.json":
	{
	    desc:"精品香水",
	    res:"983",
	    icon:"images/1.jpg",
	},
"test_data/user/1192322386.json":
	{
	    8388:10,
	    8389:6,
	},
}
function getdata(path,callback){
    callback(JSON.stringify(emulate[path]));
}
function setdata(path,setk,setv,callback){
    if(path=="test_data/user/1192322386.json"){

        var goodid=setk;
        var oldv=emulate["test_data/user/1192322386.json"][goodid];

        diff=setv-oldv;
        
        var res=parseInt(emulate["test_data/good/"+goodid+".json"].res);
        console.log(path+" "+setk+" "+oldv+" "+setv+" "+diff+" "+res);
        res=res-diff;
        console.log(path+" "+setk+" "+oldv+" "+setv+" "+diff+" "+res);
        if(res>=0){
             emulate["test_data/good/"+goodid+".json"].res=res;
             emulate["test_data/user/1192322386.json"][goodid]=setv;
             if(setv==0){
                 delete emulate["test_data/user/1192322386.json"][goodid];
             }
             callback(1,res,setv);

        }else{
             callback(0,emulate["test_data/good/"+goodid+".json"].res,emulate["test_data/user/1192322386.json"][goodid]);
        }
        
    }else{
	emulate[path][setk]=v;
                callback(emulate[path][setk]);
    }
}
</script>
    <script type="text/javascript">
    var userid="1192322386";
    var maxgoodidtpl=$("#maxgoodid").text();
    //console.log(maxgoodidtpl);
    var maxgoodidfun=tplEngine(maxgoodidtpl);
    //console.log(maxgoodidfun);
    function update_maxgoodid(){
        getdata("test_data/sys.json",function(dat){//加载当前最新云购id
            var sys=eval("("+dat+")");
            //console.log(sys);
            if($(".max-con").text()==""){
                var node=maxgoodidfun(sys.maxgoodid);
                $(".max-con").append(node);
            }else{
                $(".cls_maxgoodid").text(sys.maxgoodid);
            }
        });
        
    }
    setInterval(update_maxgoodid,1000);
    update_maxgoodid();
    
    var goodtpl=$("#goodtpl").text();
    //console.log(goodtpl);
    var goodfun=tplEngine(goodtpl);


var cache_goods={};
var cache_cart={};
//---------------------------------------------数据缓存--------------------------------------------
/*
window.cache={
    goods:{},
    //cart:{},
    del:{},
}

*/

//---------------------------------------------数据缓存--------------------------------------------


    function update_li(userid){//加载用户的购物车数据，只有商品id和对应购买数量
        getdata("test_data/user/"+userid+".json",function(mycart_dat){
            var mycart=eval("("+mycart_dat+")");
            cache_cart=mycart;

            
            //----------------------------------避免破坏缓存数据
            /*
            if(window.cache.cart!=undefined){
                mycart=window.cache.cart;
            }else{
                window.cache.cart=mycart;
            }
            */

            //console.log(mycart);
            for(var goodid in mycart)/*if(window.cache.del[goodid]==undefined)*/{
                window.update_good=function(goodid){//加载具体的商品信息，剩余数量，描述，图片
	    getdata("test_data/good/"+goodid+".json",function(good_detail_dat){
                        var good_detail=eval("("+good_detail_dat+")");
                        cache_goods[goodid]=good_detail;
                        //----------------------------------避免破坏缓存数据
                        /*
                        if(window.cache.goods[goodid]!=undefined){
                            good_detail=window.cache.goods[goodid];
                        }else{
                            window.cache.goods[goodid]=good_detail;
                        }
                        */

                        update_sum();
                        //console.log(good_detail);
                        if($(".li"+goodid).length!=0){
                            $(".li"+goodid+" .goodicon").attr('src',good_detail.icon);
                            $(".li"+goodid+" .desc").html(good_detail.desc);
                            $(".li"+goodid+" .res").html(good_detail.res);
                            $(".li"+goodid+" .mynum").val(mycart[goodid]);
                            //console.log(good_detail);
                        }else{
                            var nodex=goodfun(good_detail.icon,goodid,good_detail.desc,good_detail.res,mycart[goodid]);
                            //console.log(nodex);
                            $("#cartBody").append(nodex);
                        }
                        
                    });
                };
                window.update_good(goodid);
            }
        });
    }
    update_li(userid);
    setInterval("update_li("+userid+")",200);

    </script>

</@override>
<@override name="scripts">
<script  src="${wxAssets}/js/pages/index.js"></script>
</@override>
<@override name="nav_cart">active</@override>
<@extends name="../common/base.ftl"/>
