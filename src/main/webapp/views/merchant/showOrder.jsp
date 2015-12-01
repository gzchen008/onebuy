<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>交易中的订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <table class="table table-striped">
              <thead>
                 <tr>
                    <th>订单编号</th>
                    <th>下单时间</th>
                    <th>付款金额</th>
                    <th>商品</th>
                    <th>联系电话</th>
                    <th>送货地址</th>
                    <th>确认订单</th>
                 </tr>
              </thead>
              <tbody>
              	 <c:forEach var="parkingPlace" items="${requestScope.orders}" varStatus="status">
                 <tr>
                    <td>${order.orderNumber}</td>
                    <td>${order.orderTime}</td>
                    <td>${order.money}</td>
                    <td>
                    <c:forEach var="good" items="${order.goods}">
                    	${good}
                    </c:forEach>
                    </td>
                 	<td>${order.user.phone}</td>
                 	<td>${order.user.address}</td>
                 	<td><a href='/views/merchant/confirmOrder.jsp?order_id=${order.oid}'>确认</a></td>
                 </tr>
              	 </c:forEach>
              </tbody>
           </table>
  </body>
</html>
