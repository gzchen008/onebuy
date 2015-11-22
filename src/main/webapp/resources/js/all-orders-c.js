(function () {
    bindEvents();
    //current page index 
    var page = 1;
    function bindEvents() {
        $(".header h3").click(menuShow);
        $("body").click(menuHide);
        $(".all-menu").click(stopPropagation);
    }

    function menuShow(e) {
        e.stopPropagation();
        $(".all-menu").fadeIn("1000");
        $(".triangle").fadeIn("1000");
    }

    function menuHide() {
        $(".all-menu").fadeOut("0");
        $(".triangle").fadeOut("0");
    }

    function stopPropagation(e) {
        e.stopPropagation();
    }

    var loading = false;
    $(window).scroll(function () {
        if ((($(window).scrollTop() + $(window).height()) + 250) >= $(document).height()) {
            if (loading == false) {
                console.log("displaying");
                loading = true;
                $('.loading-bar').css("display", "block");
                $.ajax({
                	url:'/shop/order/listOrderJson',
                	data:{'page':page+1},
                	type:"get",
                	success:function(data){
                		$('.order-list').append(data.text);
                        $('.loading-bar').css("display", "none");
                        loading = false;
                        page++;
                	}
                });
               
            }
        }
    });


})();