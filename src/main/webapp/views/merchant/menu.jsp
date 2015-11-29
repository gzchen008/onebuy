<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header"><h1>鲜出没卖家管理系统</h1></div>
<div class="main-menu">
    <div class="portrait">
        <img src="../../resources/img/portrait.jpg" alt="头像"/>
        <h2>${param.username}</h2>
        <p>欢迎!</p>
    </div>
    <ul class="list-group">
        <li class="list-group-item"><a href="${rootPath}/merchant/order/orderManage?page=1">订单管理</a></li>
        <li class="list-group-item active"><a href="${rootPath}/merchant/order/listOrder?page=1">交易记录</a></li>
        <li class="list-group-item"><a href="${rootPath}/merchant/order/turnover?startDay=<%=new java.util.Date()%>&page=1">营业额统计</a></li>
         <li class="list-group-item"><a href="${rootPath}/merchant/evaluate?page=1">用户评价查看</a></li>
        <li class="list-group-item"><a href="${rootPath}/merchant/logout">退出系统</a></li>
    </ul>
</div>