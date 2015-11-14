$(function () {
    simulateSelect();
});

function simulateSelect() {
    $(".tip").click(function () {
        //$(this).parent().find("select").show();
        setTimeout(function(){
            $(this).parent().find("select").trigger("click");
        }, 0);
    });
    $("select").click(function () {
        alert("click");
        $(this).attr("")
    })
}