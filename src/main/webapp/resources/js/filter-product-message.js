$(function () {
   $(".img-load").change(function () {
      $(this).parent().find(".no-select").html($(this).val());
   });
});