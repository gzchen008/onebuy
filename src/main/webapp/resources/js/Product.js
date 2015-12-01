$(function(){
    sizeInit();
    move_fun();
    clickListener();
});

function sizeInit(){
    var totalHeight = $(".right-detail").outerHeight()+$(".search").height();
    $("body").css({"height": totalHeight+"px"});
    $(".content").css({"height":(totalHeight-55)+"px"});
    var $shoppingImg = $(".shop-detail a img");
    $shoppingImg.css({"height":$shoppingImg.width()+"px"});
}

function move_fun() {
    var span = document.getElementById("for-touch");
    var scrollDis = 0;
    var start_left;
    var start_top;
    document.addEventListener('DOMContentLoaded', function() {
        setTextareaPointerEvents('none');
    });
    span.addEventListener('touchstart', function (event) {
        //event.preventDefault();
        setTextareaPointerEvents('auto');
        if (event.targetTouches.length == 1) {
            var touch = event.targetTouches[0];
            start_top = touch.pageY;
            start_left = touch.pageX;
        }
    });
    span.addEventListener('touchmove', function (event) {
        event.preventDefault();
        setTextareaPointerEvents('none');
        //$(".test").html(scrollDis+","+$(".right-detail").height()+","+window.pageYOffset);
        if (event.targetTouches.length == 1) {
            var touch = event.targetTouches[0];
            if(scrollDis == window.pageYOffset){
                scrollDis += start_top - touch.pageY;
            }else if(scrollDis<0){
                scrollDis = 0;
            }else{
                scrollDis = window.pageYOffset;
            }
            window.scrollTo(0,scrollDis);
            if(touch.pageX - start_left > 100){
                //右滑
                $(".left-assortment").animate({"left":"0"},100);
                $(".right-detail").animate({"left":"37%"},100);
            }
            if(touch.pageX - start_left < -100){
                //左滑
                $(".right-detail").animate({"left":"0"},100);
                $(".left-assortment").animate({"left":"-37%"},100);
            }
        }
    });
    span.addEventListener('touchend', function (event) {
        setTimeout(function() {
            setTextareaPointerEvents('none');
        }, 0);
        event.stopPropagation();
    });
}
function setTextareaPointerEvents(value) {
    var nodes = document.getElementsByTagName('input');
    for(var i = 0; i < nodes.length; i++) {
        nodes[i].style.pointerEvents = value;
    }
}

function clickListener(){
    var $vgtbGd = $(".vegetable-garden");
    var isLeft = false;
    $vgtbGd.click(function () {
        if(!isLeft){
            $(".right-detail").animate({"left":"0"},100);
            $(".left-assortment").animate({"left":"-37%"},100);
            isLeft = true;
        }else{
            $(".left-assortment").animate({"left":"0"},100);
            $(".right-detail").animate({"left":"37%"},100);
            isLeft = false;
        }
    });
}
//function fixKeyboardBug(){
//    var isIOS = /(iPad|iPhone|iPod)/g.test(navigator.userAgent);
//    alert(isIOS);
//    if(isIOS){
//
//        var iOSKeyboardFix = {
//            targetElem: $('#fooSelector'),
//            init: (function(){
//                $("input, textarea").on("focus", function() {
//                    iOSKeyboardFix.bind();
//                });
//            })(),
//
//            bind: function(){
//                $(document).on('scroll', iOSKeyboardFix.react);
//                iOSKeyboardFix.react();
//            },
//
//            react: function(){
//
//                var offsetX  = iOSKeyboardFix.targetElem.offset().top;
//                var scrollX = $(window).scrollTop();
//                var changeX = offsetX - scrollX;
//
//                iOSKeyboardFix.targetElem.css({'position': 'fixed', 'top' : '-'+changeX+'px'});
//
//                $('input, textarea').on('blur', iOSKeyboardFix.undo);
//
//                $(document).on('touchstart', iOSKeyboardFix.undo);
//            },
//
//            undo: function(){
//
//                iOSKeyboardFix.targetElem.removeAttr('style');
//                document.activeElement.blur();
//                $(document).off('scroll',iOSKeyboardFix.react);
//                $(document).off('touchstart', iOSKeyboardFix.undo);
//                $('input, textarea').off('blur', iOSKeyboardFix.undo);
//            }
//        };
//
//    };
//}