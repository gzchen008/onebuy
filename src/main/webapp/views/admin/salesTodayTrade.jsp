<%--
  Created by IntelliJ IDEA.
  User: yangtk
  Date: 2015/11/29
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-cn">
    <jsp:include page="head.jsp">
        <jsp:param value="鲜出没订单管理中心" name="title"/>
    </jsp:include>
    <body id="orderManage" class="comment">
    <jsp:include page="menu.jsp">
        <jsp:param value="${session.admin.account}" name="username"/>
    </jsp:include>
    <div class="content">
        <div class="main-content">
            <div class="manage-type">
                <ul>
                    <li><a href="#">增加门店</a></li>
                    <li><a href="#">产品日销量统计</a></li>
                    <li><a href="#" class="hover-line">交易营业额统计</a></li>
                </ul>
            </div>
            <div class="inline-div">
                <span class="shop-icon"></span>
                <h3 class="inline-div-header">门店管理</h3>
                <h4>交易营业额统计</h4>
            </div>
            <div class="trade-time top-margin-2x bottom-margin-2x turnover-trade-time">
                <ul class="trade-record">
                    <li><a href="##">今日营业记录</a></li>
                    <li><a href="##">历史营业记录</a></li>
                    <li class="hover-bg"><a href="##">今日交易记录</a></li>
                    <li><a href="##">历史交易记录</a></li>
                </ul>
                <span>统计时间:</span>
                <input class="form-control time" type="date"/>
                <span>到</span>
                <input class="form-control time" type="date"/>
                <button class="btn btn-primary btn-border-none pull-right right-margin-1x">点此查询</button>
            </div>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>交易时间</th>
                    <th>订单号</th>
                    <th>交易金额</th>
                    <!--其下对应开始处理-->
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>35</td>
                    <td>无</td>
                    <td>无</td>
                </tr>
                </tbody>
            </table>

            <div class="page-divider btn-group" role="group" aria-label="page-divide">
                <a href="#" class="btn btn-default disabled">上一页</a>
                <a href="#" class="btn btn-default active">1</a>
                <a href="#" class="btn btn-default">2</a>
                <a href="#" class="btn btn-default">3</a>
                <a href="#" class="btn btn-default disabled">...</a>
                <a href="#" class="btn btn-default">10</a>
                <a href="#" class="btn btn-default">11</a>
                <a href="#" class="btn btn-default">12</a>
                <a href="#" class="btn btn-default">下一页</a>
            </div>
        </div>
    </div>
    <%@include file="script.jsp" %>
    </body>
</html>