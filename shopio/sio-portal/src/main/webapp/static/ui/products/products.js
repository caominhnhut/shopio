angular.module('myApp.products', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/product', {
    templateUrl: 'sio-portal/static/ui/products/products.html',
    controller: 'ProductCtrl'
  });
}])

.controller('ProductCtrl', ['$scope', '$rootScope', '$http', '$location', 'ServiceProvider',
  function($scope, $rootScope, $http, $location, serviceProvider){
	
	$scope.getProducts = function(){
		var promise = serviceProvider.getApi("sio-portal/static/json/product.json");
		promise.then(function (response) {
			$scope.products = response;
			console.log($scope.products);
		}, function (errorPayload) {
			console.log('Can not get latest products', errorPayload);
		})
	}
	
	$scope.getProducts();
  }

]);