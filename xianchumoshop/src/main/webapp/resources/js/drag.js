function span_move_fun() {
    var span = document.getElementById("move_k");
    var start_left;
    var start_top;
    span.addEventListener('touchstart', function (event) {
        event.preventDefault();
        if (event.targetTouches.length == 1) {
            var touch = event.targetTouches[0];
            start_top = touch.pageY;
            start_left = touch.pageX;
        }
    });
    span.addEventListener('touchmove', function (event) {
        event.preventDefault();
        if (event.targetTouches.length == 1) {
            var touch = event.targetTouches[0];
            if(touch.pageX - start_left > 400){
                alert("右滑");
            }
            if(touch.pageX - start_left < -400){
                alert("左滑")
            }
        }
    });
    span.addEventListener('touchend', function (event) {
        event.stopPropagation();
    });
}
