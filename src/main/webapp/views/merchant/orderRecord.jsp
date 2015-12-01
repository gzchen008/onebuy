<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <jsp:include page="head.jsp">
  	<jsp:param value="交易记录" name="title"/>
  </jsp:include>
  <body>
    <jsp:include page="menu.jsp">
    	<jsp:param value="${sessionScope.merchant.account}" name="username"/>
    </jsp:include>
    <div class="content">
        <div class="content-header"><span class="position">您当前的位置：历史交易记录</span><span class="time">2015.10.30 星期五</span></div>
        <div class="main-content">
            <h3 class="main-content-header">历史交易记录</h3>
            <a class="btn btn-primary active btn-border-none" href="#">今日交易记录</a>
            <a class="btn btn-primary btn-border-none" href="#">历史交易记录</a>
            <div class="trade-time">
                <thead>
                    <span>交易时间:</span>
                    <input class="form-control time" type="date" name="startDate"/>
                    <span>到</span>
                    <input class="form-control time" type="date" name="endDate"/>
                    <input type="submit" class="btn btn-primary btn-border-none pull-right" value="点此查询">
                    <!-- <button class="btn btn-primary btn-border-none pull-right">点此查询</button> -->
                </thead>
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
                	<c:forEach var="record" items="${requestScope.orders}">
                		<tr>
	                        <td>${record.orderTime}</td>
	                        <td>${record.orderNumber}</td>
	                        <td>${record.money}</td>
                   		</tr>
                	</c:forEach>
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
  </body>
</html>
