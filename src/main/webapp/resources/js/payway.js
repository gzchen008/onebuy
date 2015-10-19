(function () {
    $(function () {
        bindEvent();
    });

    function bindEvent() {
        $(".way").click(changeIcon);
        $(".checkbox-simulate").click(switchCheckbox);
    }

    function changeIcon() {
        $(this).css({"background-image": "url('../img/checkedPayWay.png')"});
        $(this).parent().parent().siblings().find(".way").css({"background-image": "url('../img/payWay.png')"})
    }

    function switchCheckbox() {
        if($(this).attr("class").split(" ")[1]=="on"){
            $(this).removeClass("on").addClass("off");
            $(this).parent().find("input").prop("checked", false);
        }else{
            $(this).removeClass("off").addClass("on");
            $(this).parent().find("input").prop("checked", true);
        }
    }
})();