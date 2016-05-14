/**
 * create by CGZ
 * 
 */
var $storage = window.localStorage;

//为本地存储赋值
var setLocalItem = function(key, value){
	$storage.setItem(key, value);
}

//取本地存储值
var getLocalItem = function(key){
	return $storage.getItem(key);
}

//获取对象属性的数量
var getObjectPropCount = function(obj){
	var num = 0 ;
	for( var key in obj){
		num++;
	}
	return num;
}

$("[data-url]").on("click", function() {
	window.location = $(this).data("url");
});