<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8"%>


<div class="footer">

	<ul>
		<li><a href="${rootPath }/good/product"> <span id="garden">
					<span class="footer-icon <c:if test="${footer_active eq 1 }">footer-active</c:if>" id="icon1"></span> <i>菜园子</i>
			</span>
		</a></li>
		<li><a href="${rootPath }/cart/cart"> <span id="basket">
					<span class="footer-icon <c:if test="${footer_active eq 2 }">footer-active</c:if>" id="icon2"></span> <i>菜篮子</i>
			</span>
		</a></li>
		<li><a href="${rootPath }/user/me"> <span id="footer-me">
					<span class="footer-icon <c:if test="${footer_active eq 3 }">footer-active</c:if>" id="icon3"> <!-- <span class="tooltip">￥20</span> -->
				</span> <i>我</i>
			</span>
		</a></li>
		<li><a href="#"> <span> <span class="footer-icon"
					id="icon4"></span> <i>鲜友汇</i>
			</span>
		</a></li>
	</ul>
</div>
<script type="text/javascript"
	src="${rootPath }/resources/js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="${rootPath }/resources/js/common.js"></script>
