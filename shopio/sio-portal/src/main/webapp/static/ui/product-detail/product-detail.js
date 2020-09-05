angular.module('myApp.productDetail', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/product/:productId', {
    templateUrl: 'sio-portal/static/ui/product-detail/product-detail.html',
    controller: 'ProductDetailCtrl'
  });
}])

.controller('ProductDetailCtrl', ['$scope', '$http', '$routeParams', 'ServiceProvider', function($scope, $http, $routeParams, serviceProvider){
    
	$scope.getProductById = function() {
		var promise = serviceProvider.getApi(URL_PRODUCTS);
		promise.then(function (response) {
			$scope.product = searchProductByCurrentProductId(response);
			console.log(product.images);
		}, function (errorPayload) {
			console.log('Can not get products', errorPayload);
		})
	}
	
	$scope.getProductById();
	
	$scope.showImageByUrl = function(url){
		console.log(url);
		$('#mainImage').attr('src', url);
	}
	
	function searchProductByCurrentProductId(products) {
		var productId = $routeParams.productId;
		for(product of products) {
			if(product.id == productId) {
				return product;
			}
		}
	}
	
}]);