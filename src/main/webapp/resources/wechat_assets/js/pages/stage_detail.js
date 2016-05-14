require(["shop", "amazeui", "main", "app"], function(Shop){
	
	/*var cart = {
			id : {
				desc:"珍藏包包",
				res:"304",
				icon:"images/2.jpg"
			}
	
	};*/
	//TODO 初始化页面与购物车有关的数据
	var initPage = function(){
		
	};
	initPage();
	$("#addToCartBtn").on("click", function() {
		var cart = $.parseJSON(Shop.getCart());
		//空购物车
		if(getObjectPropCount(cart) == 0 ){
			cart["s" + DATA.stage.id] = {
					name : DATA.stage.goodName,
					quantity : 1
			};
			setLocalItem("cart", JSON.stringify(cart));
		}else{
			for(var sId in cart){
				if("s"+DATA["stage"]["id"] == sId){
					console.log("yes");
					cart["s"+sId].quantity++;
				}
			}
		}
		
	});
	
	
});