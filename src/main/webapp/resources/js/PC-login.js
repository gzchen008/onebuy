(function(){

	showDialog();
	//	侦听浏览器窗口大小变化
	window.onresize = showDialog;

	function showDialog(){
		setElement.autoCenter(setElement.g('center-wrap'));
	}
	
})()