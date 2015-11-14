<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; chaRset=utf-8"/>
    <title>全部订单</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/comment.css">
    <link rel="stylesheet" type="text/css" href="${rootPath }/resources/style/css/all-orders.css">
</head>
<body>
<div class="header">
    <span class="backspace"></span>

    <h3>全部订单<span></span></h3>
</div>

<div class="container">
    <div class="want-more">
        <a href="#">
            <span></span>
            不够吃，我还要买买买
            <i></i>
        </a>
    </div>
    <div class="new-divider"></div>
    <ul class="order-list ">
        <c:forEach items="" var="">
            <li>
                <div class="info">
                    <h4>订单编号 1234567</h4>

                    <p>2015.10.26&nbsp&nbsp22:35:04</p>
                    <span>待付款</span>
                </div>
                <div class="pic">
                    <img src="${rootPath }/resources/img/vedetable.jpg">
                    <img src="${rootPath }/resources/img/vedetable.jpg">
                    <img src="${rootPath }/resources/img/vedetable.jpg">
                    <span></span>

                    <h3>共四件商品 ￥52</h3>
                </div>
                <div class="divider"></div>
                <div class="go-evaluate">
                    <a href="#">去评价</a>
                </div>
            </li>
        </c:forEach>
        <div class="big-divider"></div>
        <li>
            <div class="info">
                <h4>订单编号 1234567</h4>

                <p>2015.10.26&nbsp&nbsp22:35:04</p>
                <span>待付款</span>
            </div>
            <div class="pic">
                <img src="../img/vedetable.jpg">
                <img src="../img/vedetable.jpg">
                <img src="../img/vedetable.jpg">
                <span></span>

                <h3>共四件商品 ￥52</h3>
            </div>
            <div class="divider"></div>
            <div class="go-evaluate">
                <a href="#">去评价</a>
            </div>
        </li>
        <div class="big-divider"></div>
        <li>
            <div class="info">
                <h4>订单编号 1234567</h4>

                <p>2015.10.26&nbsp&nbsp22:35:04</p>
                <span>待付款</span>
            </div>
            <div class="pic">
                <img src="../img/vedetable.jpg">
                <img src="../img/vedetable.jpg">
                <img src="../img/vedetable.jpg">
                <span></span>

                <h3>共四件商品 ￥52</h3>
            </div>
            <div class="divider"></div>
            <div class="go-evaluate">
                <a href="#">去评价</a>
            </div>
        </li>
        <div class="big-divider"></div>
    </ul>
</div>


<!-- //弹出框 -->
<span class="triangle"></span>
<span class="triangle"></span>

<div class="all-menu">
    <ul class="order-list">
        <li><a href="#"><span id="all-orders"></span>全部订单</a></li>
        <li><a href="#"><span id="transform"></span>正在配送</a></li>
        <li><a href="#"><span id="arrived"></span>已经送达</a></li>
        <li><a href="#"><span id="wait-evaluate"></span>等待评价</a></li>
        <li><a href="#"><span id="my-address"></span>我的地址</a></li>
    </ul>
</div>

<script type="text/javascript" src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="${rootPath }/resources/js/regular.js"></script>
<script type="text/javascript" src="${rootPath }/resources/js/all-orders.js"></script>
</body>
</html>