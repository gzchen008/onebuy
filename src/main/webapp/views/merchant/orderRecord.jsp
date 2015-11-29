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
                    <input id="start" class="form-control time" type="date" name="startDate"/>
                    <span>到</span>
                    <input id="end" class="form-control time" type="date" name="endDate"/>
                    <!-- <button class="btn btn-primary btn-border-none pull-right" onClick="tradeTimeQuery()" value="点此查询"> -->
                    <button class="btn btn-primary btn-border-none pull-right" onClick="tradeTimeQuery()">点此查询</button>
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
                	<c:forEach var="record" items="${requestScope.pages.list}">
                		<tr>
	                        <td>${record.orderTime}</td>
	                        <td>${record.orderNumber}</td>
	                        <td>${record.money}</td>
                   		</tr>
                	</c:forEach>
                </tbody>
            </table>
			
             <div class="page-divider btn-group" role="group" aria-label="page-divide">
	        	<c:if test="${requestScope.pages.nowPage != 1}">
	        		<a href="/shop/merchant/order/listOrder?page=${requestScope.pages.prePage}" class="btn btn-default">上一页</a>
	        	</c:if>
	        	<c:choose>
	        		<c:when test="${requestScope.pages.pageCount>11 && requestScope.pages.nowPage>7}">
						<a href="/shop/merchant/order/listOrder?page=1" class="btn btn-default active">1</a>
						<a href="/shop/merchant/order/listOrder?page=2" class="btn btn-default active">2</a>
						<c:forEach var="page" begin="${requestScope.pages.nowPage-4}" end="${requestScope.pages.nowPage+3}">
							<c:choose>
								<c:when test="${page!=requestScope.pages.nowPage&&page<requestScope.pages.pageCount}">
									<a href="/shop/merchant/order/listOrder?page=${page}" class="btn">${page}</a>
								</c:when>
								<c:when test="${page==requestScope.pages.nowPage}">
									<a href="#" class="btn btn-default active">${requestScope.pages.nowPage}</a>
								</c:when>
							</c:choose>
							<c:if test="${requestScope.pages.pageCount>requestScope.pages.nowPage+3}">
								<a href="#" class="btn btn-default disabled">...</a>
							</c:if>
						</c:forEach>
		        	</c:when>
		        	<c:otherwise>
		        		<c:forEach var="page" begin="1" end="${requestScope.pages.pageCount}">
			        		<c:choose>
			        			<c:when test="${page == requestScope.pages.nowPage}">
			        				<a href="#" class="btn btn-default active">${page}</a>
			        			</c:when>
			        			<c:otherwise>
			        				<a href="/shop/merchant/order/listOrder?page=${page}" class="btn">${page}</a>
			        			</c:otherwise>
			        		</c:choose>
			        	</c:forEach>
		        	</c:otherwise>
	        	</c:choose>
	            <c:if test="${requestScope.pages.nowPage != requestScope.pages.pageCount}">
	        		<a href="/shop/merchant/order/listOrder?page=${requestScope.pages.nextPage}"
	        			 class="btn btn-default">下一页</a>
	        	</c:if>
	        </div>
        </div>
    </div>
    <script src="${rootPath}/resources/js/jquery-1.11.2.js"></script>
    <script src="${rootPath}/resources/js/PC-order-management.js"></script>
  </body>
</html>
