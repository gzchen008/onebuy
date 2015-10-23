(function(){

	showDialog();
	//	侦听浏览器窗口大小变化
	window.onresize = showDialog;

	function showDialog(){
		autoCenter(g('center-wrap'));
	}

	//	获取元素对象	
	function g(id){return document.getElementById(id);}

	//	自动居中元素（el = Element）
	function autoCenter( el ){
		var bodyW = document.documentElement.clientWidth;
		var bodyH = document.documentElement.clientHeight;

		var elW = el.offsetWidth;
		var elH = el.offsetHeight;

		el.style.left = (bodyW-elW)/2 + 'px';
		el.style.top = (bodyH-elH)/2 + 'px';
		
	}

})()