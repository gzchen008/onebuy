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
        //评价页面
        $("#sub-evaluation").click(showDialog);
        $("#mask").click(timeChooseHide);
        $("#bg-evaluation").click(stopPropagation);
        $(document).on("click",".star",changeStatus);
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
    //评价页面的星星变化
    function changeStatus(){
        var status=$(this).attr("status");
        if(status==1){
          $(this).css({"background-image":"url('../../web/img/161.png')"});
          $(this).get(0).setAttribute("status", "0");
      }else{
        $(this).css({"background-image":"url('../../web/img/16.png')"});
        $(this).get(0).setAttribute("status", "1");
    }
}
})();