<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>支付成功</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/comment.css">
    <link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/success-payment.css">
    <script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
</head>
<body>
<div class="header">
    <span class="backspace"></span>
</div>
<div class="container">
    <div class="for-passage">
        <div class="check"><span></span>支付成功</div>
        <p>鲜大提醒你:</p>
        <p>您专属提菜密码:***,${order.address.cabinet }柜</p>
        <p>鲜二保证13:00前飞过去为您送达</p>
        <p>请留意短信提醒</p>
        <div class="divider"></div>
        <a href="#" class="more">不够吃，我还要买买买</a>
    </div>
    <div class="section">
        <h3>大家都喜欢吃</h3>
        <div class="divider"></div>
        <ul class="love-search">
            <li>
                <a href="#">
                    <img src="${rootPath }/resources/img/vedetable.jpg">
                    <i>进口小白菜</i>
                    <span>￥20</span>
                    <span>500/g</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${rootPath }/resources/img/vedetable.jpg">
                    <i>进口小白菜</i>
                    <span>￥20</span>
                    <span>500/g</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${rootPath }/resources/img/vedetable.jpg">
                    <i>进口小白菜</i>
                    <span>￥20</span>
                    <span>500/g</span>
                </a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
