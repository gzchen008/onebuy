<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <jsp:include page="head.jsp">
  	<jsp:param value="用户评价查看" name="	title"/>
  </jsp:include>
  
  <body>
    <jsp:include page="menu.jsp">
    	<jsp:param value="${sessionScope.account}" name="username"/>
    </jsp:include>
    <div class="content">
		<div class="content-header"><span class="position">您当前的位置：用户评价查看</span><span class="time">2015.10.30 星期五</span></div>
		<div class="main-content">
			<h3 class="main-content-header"><span class="evaluate"></span>用户评价查看</h3>
			<div class="evaluate-list">
				<ul>
					<li>
						<div class="evaluate-content">
							<span class="check-id">订单号：122345</span>
							<span class="time">2015.11.01 11:15</span>
							<p class="comment">蔬菜味道很新鲜，味道很不错，家里人很喜欢。下次还会再来光临，牛排肉质很嫩。感觉很新鲜，五分好评。</p>
						</div>
						<div class="evaluate-product">
							<span class="product">产品:</span>
							<ul>
								<li>进口小白菜<i>X1</i></li>
								<li>西冷牛排<i>X4</i></li>
							</ul>
						</div>
						<div class="evaluate-user">
							<span class="user-name">用户:我是张三两</span>
							<span class="star-comment"><i>星级:</i>
								<em class="star"></em><em class="star"></em><em class="star"></em><em class="star"></em><em class="star"></em>
							</span>
						</div>
					</li>
				</ul>
			</div>

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
