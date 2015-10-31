(function () {
    $(function () {
        bindEvent();
    });

    function bindEvent() {
        $(".way").click(changeIcon);
        $(".checkbox-simulate").click(switchCheckbox);
        $("#choosetime").click(showDialog);
        $(".time-list li").click(addIcon);
        $("#mask").click(timeChooseHide);
        $("#dialog").click(stopPropagation);
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
    function showDialog(){
        setElement.g('dialog').style.display = 'block';
        setElement.g('mask').style.display = 'block';
        setElement.autoCenter( setElement.g('dialog') );
        setElement.fillToBody( setElement.g('mask') );
    }
    function timeChooseHide(){
        setElement.g('dialog').style.display = 'none';
        setElement.g('mask').style.display = 'none';
    }
    function stopPropagation(e){
        e.stopPropagation();
    }
    function addIcon(){
        $(this).find(">span").addClass("now-icon");
        $(this).siblings().find(">span").removeClass("now-icon");
    }

})();