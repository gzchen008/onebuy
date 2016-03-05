/**
 * create by CGZ
 * 
 */
$("[data-url]").on("click", function() {
	window.location = $(this).data("url");
});