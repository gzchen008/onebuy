$(function(){
    //var fillInput = $(".fill-input");
    //var addon = $(".fill-recipe-form-group .input-group-addon");
    //fillInput.keyup(function(){
    //    if($(this).val().length <= 5){
    //        addon.html( $(this).val().length + "/5");
    //    }else{
    //        $(this).val($(this).val().substring(0, 5));
    //    }
    //    console.log($(this).val().length + "/5");
    //});

    var fileInput = $(".file-input");
    fileInput.change(function(){
        $(".no-selected").html($(this).val());
    });
});