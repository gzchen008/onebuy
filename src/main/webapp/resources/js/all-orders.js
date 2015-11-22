(function () {
    bindEvents();

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
                $.get("http://115.29.98.130:8080/helloWorld.json", function (data) {
                    //以上链接异步请求不成功
                    //处理data
                    $('body').append(data.text);
                    $('.loading-bar').css("display", "none");
                    loading = false;
                });
            }
        }
    });


})();