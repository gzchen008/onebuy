<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-cn">
	<jsp:include page="head.jsp">
		<jsp:param value="订单管理" name="title"/>
	</jsp:include>
	<body>
		<jsp:include page="menu.jsp">
			<jsp:param value="${sessionScope.merchant.account}" name="username"/>
		</jsp:include>
		<div class="content">
        <div class="content-header"><span class="position">您当前的位置：订单管理</span><!-- <span class="time">2015.10.30 星期五</span> --></div>
        <div class="main-content">
            <h3 class="main-content-header">订单管理</h3>
            <a class="btn btn-primary active btn-border-none" href="${rootPath}/merchant/order/orderManage?page=1">查看订单</a>
            <a class="btn btn-primary btn-border-none" href="${rootPath}/merchant/order/someOrder?state=1&page=1">未处理订单</a>
            <a class="btn btn-primary btn-border-none" href="${rootPath}/merchant/order/someOrder?state=2&page=1">已处理订单</a>
            <table class="table table-striped table-bordered table-hover">
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
		            <c:forEach var="order" items="${requestScope.orders}">
		            	<tr>
			                <td>${order.orderNumber}</td>
			                <td>${order.orderTime}</td>
			                <td>${order.address.userName}</td>
			                <td>${order.address.address}</td>
			                <td>
			                	<c:forEach var="item" items="${order.goods}">
			                		${item.good.name}X${item.amount}<span class="hidden">${item.good.name}X${item.amount}</span></br>
			                	</c:forEach>
			                </td>
			                <td>${order.money}</td>
			                <!--1订单生成 2卖家已付款 3商家已发货 4买家已提货 9交易失败 -->
			                <c:choose>
			                	<c:when test="${order.orderState == 1}">
			                		<td class="untreated">未处理</td>
			                		<td><a href="#" class="btn btn-primary btn-border-none">新订单</a></td>
			                	</c:when>
			                	<c:when test="${order.orderState == 2}">
			                		<td class="untreated">未处理</td>
			                		<td><a id="begin-deal" href="#" data="/shop/merchant/order/comfirmOrder?orderId=${order.oid}" class="begin-handle-btn btn btn-primary btn-border-none" 
			                				data-target=".begin-handle" data-toggle="modal">开始处理</a></td>
			                	</c:when>
			                	<c:when test="${order.orderState == 3}">
			                		<td class="untreated">处理中</td>
			                		<td><a href="#" class="check-detail-btn btn btn-primary btn-border-none"
			                				 data-target=".check-detail" data-toggle="modal">查看详情</a></td>
			                	</c:when>
			                	<c:when test="${order.orderState == 4||order.orderState == 9}">
			                		<td class="untreated">已处理</td>
			                		<td><a href="#" class="check-detail-btn btn btn-primary btn-border-none"
			                				 data-target=".check-detail" data-toggle="modal">查看详情</a></td>
			                	</c:when>
			                </c:choose>
		            	</tr>
		            </c:forEach>
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
			<div class="modal fade begin-handle" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
	         aria-hidden="true">
		        <div class="modal-dialog modal-lg">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal" ><span
		                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		                    <h4 class="modal-title">开始处理</h4>
		                </div>
		                <div class="modal-body">
		                    <table class="table table-striped table-bordered table-hover">
		                        <thead>
		                        <tr>
		                            <th>序号</th>
		                            <th>下单时间</th>
		                            <th>收货人</th>
		                            <th>收获地址</th>
		                            <th>合计</th>
		                            <!--其下对应开始处理-->
		                        </tr>
		                        </thead>
		                        <tbody>
		                        <tr>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                        </tr>
		                        </tbody>
		                    </table>
		                    <ul class="list-group">
		                        <li class="list-group-item active-green">产品信息</li>
		                    </ul>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                    <button id="deal" type="button" class="btn btn-primary btn-border-none" onClick="deal()">开始处理</button>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		<div class="modal fade check-detail" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">开始处理</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>下单时间</th>
                            <th>收货人</th>
                            <th>收获地址</th>
                            <th>合计</th>
                            <!--其下对应开始处理-->
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>01</td>
                            <td>2015.10.30 18:40</td>
                            <td>张三两</td>
                            <td>广州市天河区汇景新城001柜</td>
                            <td>￥18</td>
                        </tr>
                        </tbody>
                    </table>
                    <ul class="list-group">

                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    <script src="${rootPath}/resources/js/jquery-1.11.2.js"></script>
<script src="${rootPath}/resources/js/bootstrap.min.js"></script>
<script src="${rootPath}/resources/js/PC-order-management.js"></script>
	</body>
</html>