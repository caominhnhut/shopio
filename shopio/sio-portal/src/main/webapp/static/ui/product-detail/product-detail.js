angular.module('myApp.productDetail', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/product/:productId', {
    templateUrl: 'sio-portal/static/ui/product-detail/product-detail.html',
    controller: 'ProductDetailCtrl'
  });
}])

.controller('ProductDetailCtrl', ['$scope', '$rootScope', '$http', '$location',
  function($scope, $rootScope, $http, $location){
    $scope.message = "this is product detail page";
  }]);