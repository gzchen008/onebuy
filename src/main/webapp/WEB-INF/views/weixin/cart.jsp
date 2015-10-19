<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; chaRset=utf-8"/>
    <title>购物车</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" type="text/css"
          href="${rootPath }/resources/style/css/comment.css">
    <link rel="stylesheet" type="text/css"
          href="${rootPath }/resources/style/css/account.css">
    <script type="text/javascript"
            src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
</head>
<body class="product-info">
<div class="header">
    <span class="backspace"></span>

    <h3>购物车</h3>
    <span class="clear">清空</span>
</div>

<div class="container">
    <c:if test="${empty shoppingCart.cartItems }">
        购物车空空如也
    </c:if>

    <c:if test="${!empty shoppingCart.cartItems }">
        <ul>
            <c:forEach items="${shoppingCart.cartItems }" var="cartItem">
                <li id="${cartItem.cartItemId}"><img src="${rootPath }/${cartItem.good.photoUrl}">

                    <div class="account-detail">
                        <h3>${cartItem.good.name}</h3>

                        <div class="price">
                            <span>￥${cartItem.good.nowPrice}</span>
                            <span>${cartItem.good.quantity}/${cartItem.good.unit}</span>
                        </div>
                        <div class="shopping-num">
                            <span onclick="deleteOne(${cartItem.good.gid},this);"></span> <input
                                type="text" class="count" value="${cartItem.quantity}"/> <span
                                onclick="addOne(${cartItem.good.gid},this);"></span>
                        </div>
                    </div>
                    <div class="trash">
                        <span onclick="removeGood(${cartItem.good.gid},this)"></span>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</div>

<div class="pay">
    <span>商品总额:</span> <i id="total">￥${shoppingCart.total }</i>
    <a href="${rootPath}/order/payment"><button  type="submit">去结算(1)</button></a>
</div>
<%@include file="nav-footer.jsp" %>
<script>
    function removeGood(gid,obj) {
        $.ajax({
            url: '${rootPath}/cart/remove',
            data: {goodId: gid},
            type: 'POST',
            success: function (res) {
                if (res.status == 1) {
                    $(obj).parents("li").remove();
                    updateTotalUi(res);
                } else {
                }
            },
            error: function () {
                alert("网络错误");
            }
        });
    }
    function addOne(gid,obj) {
        var uiObj = $(obj).prev();
        var nowC =  parseInt(uiObj.val());
        changeQuntity(nowC+1,gid,uiObj);
    }
    function deleteOne(gid,obj) {
        var uiObj = $(obj).next();
        var nowC =  parseInt(uiObj.val());
        if (nowC-1 == 0) {
            //delete
           //$(obj).parents("li").remove();
            removeGood(gid,obj);
            return;
        }
        changeQuntity(nowC-1,gid,uiObj);
    }
    function changeQuntity(num, gid,uiObj) {
        var json = {
            goodId: gid,
            count: num
        };
        $.ajax(
                {
                    type: 'POST',
                    url: '${rootPath}/cart/updateCart',
                    data: json,
                    success: function (res) {
                        uiObj.val(res.quantity);
                        //总价更新
                        updateTotalUi(res);
                    },
                    error: function () {
                        alert("网络异常");
                    }
                }
        );
    }
    function updateTotalUi(res){
        $("#total").html("￥"+res.total);
        $(".tooltip").html("￥"+res.total);
    }
 
</script>

</body>
</html>