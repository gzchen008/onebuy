<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="header"><h1>鲜出没卖家管理系统</h1></div>
<div class="main-menu">
    <div class="portrait">
        <img src="${rootPath}/resources/img/portrait.jpg" alt="头像"/>
        <h2>${param.username}</h2>
        <p>欢迎登录!</p>
    </div>
    <ul class="list-group">
        <li class="list-group-item active"><a href="${rootPath}/merchant/order/orderManage?page=1">订单管理</a></li>
        <li class="list-group-item"><a href="${rootPath}/merchant/order/listOrder?page=1">交易记录</a></li>
        <li class="list-group-item"><a href="${rootPath}/merchant/order/turnover">营业额统计</a></li>
        <%-- <li class="list-group-item"><a href="${rootPath}/merchant/evaluate">用户评价查看</a></li> --%>
        <li class="list-group-item"><a href="${rootPath}/merchant/logout">退出系统</a></li>
    </ul>
</div>