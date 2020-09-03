angular.module('myApp.policy', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/policy', {
    templateUrl: 'sio-portal/static/ui/policy/policy.html',
    controller: 'PolicyCtrl'
  });
}])

.controller('PolicyCtrl', ['$scope', '$rootScope', '$http', '$location',
  function($scope, $rootScope, $http, $location){
    $scope.message = "The policy page will be present latter";
  }]);