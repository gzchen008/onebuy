<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-cn">
	<jsp:include page="head.jsp">
		<jsp:param value="订单管理" name="title"/>
	</jsp:include>
	<body>
		<jsp:include page="menu.jsp">
			<jsp:param value="${sessionScope.account}" name="username"/>
		</jsp:include>
		<div class="content">
	    	<div class="content-header"><span class="position">您当前的位置：订单管理</span><!-- <span class="time">2015.10.30 星期五</span> --></div>
		   	 	<div class="main-content">
		            <thead>
		            <tr>
		                <th>订单号</th>
		                <th>下单时间</th>
		                <th>收货人</th>
		                <th>收获地址</th>
		                <th>产品信息</th>
		                <th>合计</th>
		                <th>订单状态</th>
		                <th>开始操作</th>
		                <!--其下对应开始处理-->
		            </tr>
		            </thead>
		            <tbody>
		            <c:forEach var="order" items="${RequestScope.orders}">
		            	<tr>
		                <td>${order.orderNumber}</td>
		                <td>${order.orderTime}</td>
		                <td>${order.address.username}</td>
		                <td>${order.address}</td>
		                <td>
		                	<c:forEach var="item" items="${order.goods}">
		                		${item.good.name}X${item.amount}</br>
		                	</c:forEach>
		                </td>
		                <td>${order.money}</td>
		                <c:choose>
		                	<c:when test="${order.orderState==2}">
		                	</c:when>
		                	<c:when test="${order.orderState==3}">
		                	</c:when>
		                	<c:when test="${order.orderState==4||order.orderState==9}">
		                	</c:when>
		                </c:choose>
		                <td class="untreated">未处理</td>
		                <td><a href="#" class="btn btn-primary btn-border-none">开始处理</a></td>
		            </tr>
		            </c:forEach>
		            
		            <tr>
		                <td>02</td>
		                <td>2015.10.30 18:40</td>
		                <td>张三两</td>
		                <td>广州市天河区汇景新城001柜</td>
		                <td>小白菜 X1</td>
		                <td>￥18</td>
		                <td>￥18</td>
		                <td>已处理</td>
		                <td><a href="#" class="btn btn-primary btn-border-none">查看详情</a></td>
		            </tr>
		            </tbody>
		        </table>
		
		        <div class="page-divider btn-group" role="group" aria-label="page-divide">
		            <a href="#" class="btn btn-default">上一页</a>
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