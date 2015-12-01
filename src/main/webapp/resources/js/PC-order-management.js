<<<<<<< HEAD
$(function () {
    bindEven();
});

function bindEven() {
    addListToListGroup($(".begin-handle-btn"), $(".begin-handle .list-group"));

    addListToListGroup($(".check-detail-btn"), $(".check-detail .list-group"));
}

function addListToListGroup($btn, $listGrp) {
    $btn.click(function () {
        var $listGroup = $listGrp;
        $listGroup.empty();
        $listGroup.append('<li class="list-group-item active-green">产品信息</li>');
        var products = $(this).parent().parent().find(".all-product span");
        for (var i = 0; i < products.length; i++) {
            var $li = $('<li class="list-group-item">' + products.get(i).innerHTML + '</li>');
            $listGroup.append($li);
        }
    });
=======
$(function () {
    bindEven();
});

function bindEven() {
    addListToListGroup($(".begin-handle-btn"), $(".begin-handle .list-group"));

    addListToListGroup($(".check-detail-btn"), $(".check-detail .list-group"));
}

function addListToListGroup($btn, $listGrp) {
    $btn.click(function () {
        var $listGroup = $listGrp;
        $listGroup.empty();
        $listGroup.append('<li class="list-group-item active-green">产品信息</li>');
        var products = $(this).parent().parent().find(".all-product span");
        for (var i = 0; i < products.length; i++) {
            var $li = $('<li class="list-group-item">' + products.get(i).innerHTML + '</li>');
            $listGroup.append($li);
        }
    });
}

function deal() {
    window.location.href = $("#begin-deal").attr('data');
}

function tradeTimeQuery() {
    window.location.href = "/shop/merchant/order/listOrder?startTime="
    	+$('#start').val()+"&endTime="+$('#end').val()+"&page=1";
>>>>>>> 3655d0546b452eaea1b9ee1ae08c67e5e29d3cc0
}