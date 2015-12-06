<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; chaRset=utf-8" />
<title>产品详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/comment.css">
<link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/product-info.css">
<link rel="stylesheet" href="${rootPath }/resources/style/css/slider.css" type="text/css">
<script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
</head>
<body class="product-info">
	<div class="header">
		<span class="backspace"></span>

		<h3>菜园子</h3>
		<span class="share"></span>
	</div>
	<div class="slider">
		<ul>
			<c:forEach items="${good.info.imgs}" var="img">
				<li><a href="#">
						<img src="${rootPath}/${img}">
					</a></li>
			</c:forEach>
		</ul>
	</div>
	<div class="information">
		<h4>${good.name}</h4>
		<p class="slogan">无污染更健康</p>
		<p class="recommend-veg">推荐菜式，蒜蓉青菜等等</p>
		<div class="cost">
			<span>￥${good.nowPrice}</span>
			<div class="old-price">
				<div class="old">￥10000</div>
				<div class="first-line"></div>
				<div class="second-line"></div>
			</div>
			<div class="shopping-num">
				<span onclick="deleteOne();"></span> <input id="quantity" type="text" class="count" value="${cartItem.quantity }" /> <span onclick="addOne();"></span>
				<em class="mask"></em>
			</div>
		</div>
		<div class="divider"></div>
		<div class="norms">
			<span class="norms-span">规格</span> <i>${good.quantity}/${good.unit}</i>
		</div>
		<div class="divider"></div>
		<div class="dispatching">
			<span class="norms-span">配送服务</span> <i class="time-tip">可选时间点送达，请至少提前一小时下单</i>
		</div>
		<div class="divider"></div>
		<!--<div class="dispatching">
			<span class="norms-span">商品评价</span>

			<div class="p-right">
				<span><i>${good.score }</i>分</span><i></i>
			</div>
		</div>
		<div class="divider"></div>-->
		<div class="dispatching">
			<span class="vgtb-teach norms-span">菜谱教程</span>
		</div>
		<div class="divider"></div>
		<div class="dispatching one-rec">
			<a class="one-recommend" href="#">
				<span class="norms-span">蒜蓉小白菜</span><span class="next-page"></span><img src="${rootPath }/resources/img/vedetable.jpg">
			</a>
		</div>
		<div class="divider"></div>
		<div class="dispatching one-rec">
			<a class="one-recommend" href="#">
				<span class="norms-span">白菜炒瘦肉</span><span class="next-page"></span><img src="${rootPath }/resources/img/vedetable.jpg">
			</a>
		</div>
		<div class="divider"></div>
		<div class="dispatching">
			<a class="more" href="#">
				<span class="norms-span">点此查看更多</span>
			</a>
		</div>
		<div class="divider"></div>
		<div class="dispatching">
			<span class="pro-comment norms-span">商品评价</span>
		</div>
		<div class="divider"></div>
		<div class="dispatching">
			<span class="norms-span comment">太白金星：很新鲜很美味</span>
		</div>
		<div class="divider"></div>
		<div class="dispatching">
			<span class="norms-span comment">三三两：吃起来味道不错，菜谱很贴心</span>
		</div>
		<div class="divider"></div>
		<div class="dispatching">
			<a class="more" href="#">
				<span class="norms-span">点此查看更多</span>
			</a>
		</div>
		<div class="divider"></div>
	</div>
	<%@include file="nav-footer.jsp"%>
	<script type="text/javascript" src="${rootPath }/resources/js/yxMobileSlider.js"></script>
	<script>
    function addOne() {
        var nowC = parseInt($("#quantity").val());
        changeQuntity(nowC + 1);
    }
    function deleteOne() {
        var nowC = parseInt($("#quantity").val());
        if (nowC == 0)
            return;
        if (nowC - 1 == 0) {
            $.ajax({
                url: '${rootPath}/cart/remove',
                data: {goodId: ${good.gid}},
                type: 'POST',
                success: function (res) {
                    if (res.status == 1) {
                    } else {
                    }
                },
                error: function () {
                    alert("网络错误");
                }
            });
        }
        changeQuntity(nowC - 1);
    }
    function changeQuntity(num) {
        var json = {
            goodId:${good.gid},
            count: num
        };
        $.ajax(
                {
                    type: 'POST',
                    url: '${rootPath}/cart/updateCart',
                    data: json,
                    success: function (res) {
                        $("#quantity").val(num);
                        updateTotalUi(res);
                    },
                    error: function () {
                        alert("网络异常");
                    }


                }
        );
    }
    function updateTotalUi(res){
       // $("#total").html("￥"+res.total);
        $(".tooltip").html("￥"+res.total);
    }

</script>
	<script type="text/javascript" src="${rootPath }/resources/js/common.js"></script>
</body>
</html>