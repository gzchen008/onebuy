(function(){

	window.setElement={//工具类
		g:_g,
		autoCenter:_autoCenter,
		fillToBody:_fillToBody,
		// stopPropagation:_stopPropagation
	}
	//	获取元素对象	
	function _g(id){
		return document.getElementById(id);
	}
	//	自动居中元素（el = Element）
	function _autoCenter( el ){
		var bodyW = document.documentElement.clientWidth;
		var bodyH = document.documentElement.clientHeight;

		var elW = el.offsetWidth;
		var elH = el.offsetHeight;

				console.log("-------------"+(bodyW-elW)/2 +"----------"+(bodyH-elH)/2);

		el.style.left = (bodyW-elW)/2 + 'px';
		el.style.top = (bodyH-elH)/2 + 'px';
		
	}
	//	自动扩展元素到全部显示区域
	function _fillToBody( el ){
		el.style.width  = document.documentElement.clientWidth  +'px';
		el.style.height = document.documentElement.clientHeight + 'px';
	}
	// //停止冒泡
	// function _stopPropagation(e){
	// 	e.stopPropagation();
	// }
})()