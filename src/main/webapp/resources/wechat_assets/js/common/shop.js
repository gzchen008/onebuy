/**
 * create by cgz
 * 商城的共公操作
 * 依赖app.js
 */
define(function(){
	
	//获取购物车
	var getCart = function(){
		var cart = getLocalItem("cart");
		if(cart == null){
			cart = new Object();
			setLocalItem("cart", JSON.stringify(cart));
		}
		return cart;
	};
	
	
	return {
		getCart : getCart
	}
	
});