'use strict';
// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.factories',
  'myApp.services',
  'myApp.home',
  'myApp.products',
  'myApp.location',
  'myApp.stories',
  'myApp.productDetail',
  'myApp.login',
  'myApp.register',
  'myApp.category',
  'myApp.shoppingCart',
  'myApp.navigation',
  'myApp.policy',
  'myApp.contact',
  'ui.bootstrap'
]).
config(['$locationProvider', '$routeProvider', "$httpProvider", function($locationProvider, $routeProvider, $httpProvider) {
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
  $routeProvider.otherwise({redirectTo: '/'});
}])
.controller('IndexCtrl', ['$scope', '$rootScope', '$http', '$location', '$uibModal',
  function($scope, $rootScope, $http, $location, $uibModal) {

    $scope.openLoginView = function() {
        var modalInstance =  $uibModal.open({
            templateUrl: "sio-portal/static/ui/login/login.html",
            controller: "LoginCtrl",
            size: '',
        });

        modalInstance.result.then(function(response){
            console.log("Response from login from", response);
            $scope.result = '${response} button hitted';
            console.log("Result from login form", $scope.result);
        });
    };
}]);