(function(){
	bindEvents();

	function bindEvents(){
		$(".header h3").click(menuShow);
		$("body").click(menuHide);
		$(".all-menu").click(stopPropagation);
	}
	function menuShow(e){
		e.stopPropagation();
		$(".all-menu").fadeIn("1000");
		$(".triangle").fadeIn("1000");
	}
	function menuHide(){
		$(".all-menu").fadeOut("0");
		$(".triangle").fadeOut("0");
	}
	function stopPropagation(e){
		e.stopPropagation();
	}
})()