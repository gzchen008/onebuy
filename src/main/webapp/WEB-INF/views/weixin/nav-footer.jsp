<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8" %>


<div class="footer">
    <ul>
        <li><a href="${rootPath }/good/product"> <span> <span class="footer-icon"
                                      id="icon1"></span> <i>首页</i>
				</span>
        </a></li>
        <li><a href="${rootPath }/good/product"> <span> <span class="footer-icon"
                                      id="icon2"></span> <i>产品</i>
				</span>
        </a></li>
        <li><a href="${rootPath }/cart/cart"> <span> <span class="footer-icon"
                                      id="icon3"> <span class="tooltip">￥${shoppingCart.total}</span>
					</span> <i>购物车</i>
				</span>
        </a></li>
        <li><a href="${rootPath }/user/me"> <span> <span class="footer-icon"
                                      id="icon4"></span> <i>我</i>
				</span>
        </a></li>
    </ul>
</div>

