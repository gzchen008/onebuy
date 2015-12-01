(function(){

	var quantity=angular.module('app',[]);
	quantity.controller('count',function($scope){
		count($scope);
	});
	function count($scope){
		$scope.counter=0;
	
		$scope.add=function(amount,value){
			$scope.counter=parseInt(value);
			$scope.counter+=amount;
		};
		$scope.subtract=function(amount,value){
			$scope.counter=parseInt(value);
			if($scope.counter==0){
				$scope.counter==0
			}else{
				$scope.counter-=amount;
			}
		};
		
	window.counter=$scope.counter;
	}

})()