$(function () {
    simulateSelect();
});

function simulateSelect() {
    // $(".tip").click(function () {
    // //$(this).parent().find("select").show();
    // setTimeout(function(){
    // $(this).parent().find("select").trigger("click");
    // }, 0);
    // });
    // $("select").click(function () {
    // alert("click");
    // $(this).attr("")
    // })

    $("#county")
        .change(
        function () {
            var cid = $(this).children('option:selected').attr("cid");
            $
                .ajax({
                    url: 'findChildById',
                    data: {
                        'pid': cid
                    },
                    type: 'POST',
                    dataType: 'json',
                    success: function (res) {
                        var htmlstr = "\<option value=\"tip\"\>请选择\<\/option\>";
                        $.each(res, function (n, value) {
                        	   htmlstr += '\<option ' +
                               'cid=\"' + value.abid + '\"' +
                               'value=\"'
                               + value.name + '\"\>'
                               + value.name
                               + '\</option\>';
                        });
                        $("#community").html(htmlstr);

                    }
                });
        });

    $("#community")
        .change(
        function () {
            var cid = $(this).children('option:selected').attr("cid");
            //修改隐藏域的值
            $("#liveAreaId").val(cid);
            //alert(cid);
            // ajax
            $
                .ajax({
                    url: 'findChildById',
                    data: {
                        'pid': cid
                    },
                    type: 'POST',
                    dataType: 'json',
                    success: function (res) {
                        var htmlstr = "\<option value=\"tip\"\>请选择\<\/option\>";
                        $.each(res, function (n, value) {
                            htmlstr += '\<option ' +
                            'cid=\"' + value.abid + '\"' +
                            'value=\"'
                            + value.name + '\"\>'
                            + value.name
                            + '\</option\>';
                        });
                        $("#cabinet").html(htmlstr);
                    }

                });
        });

}