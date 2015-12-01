// (function(){
// 	$(function(){
// 		bindEvents();
// 	});
// 	function bindEvents(){
// 		$("input[type='checkbox']").click(isChecked);
// 	}
// 	$(".userMng .delete-people").click(function() {
// 		var people = new Array;
// 		$.each(checkboxs, function() {
// 			if ($(this).prop("checked")) {
// 				var person = {
// 					name: $(this).parent().parent().find(".td-user-name").html(),
// 					chebox: $(this)
// 				};
// 				people.push(person);
// 			}
// 		});
// 		var nameGroup = $(".userMng .name-group");
// 		nameGroup.empty();
// 		if (people.length >= 4) {
// 			nameGroup.addClass("group-not-one")
// 			for (var i = 0; i < people.length; i++) {
// 				nameGroup.append("<span class='name not-one-person'>" + people[i].name + "</span>")
// 			}
// 			showModelBox();
// 		} else if(people.length > 0){
// 			for (var i = 0; i < people.length; i++) {
// 				nameGroup.append("<span class='name'>" + people[i].name + "</span>")
// 			}
// 			showModelBox();
// 		}
// 		hideModelBoxListener();
// 		$(".userMng .confirmDelete .yes").unbind();
// 		$(".userMng .confirmDelete .yes").click(function(){
// 			$(".userMng .container form").submit();
// 		});
// 		return false;
// 	});


// })()