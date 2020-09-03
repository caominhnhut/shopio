angular.module('myApp.register', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/register', {
    templateUrl: 'sio-portal/static/ui/register/register.html',
    controller: 'RegisterCtrl'
  });
}])

.controller('RegisterCtrl', ['$scope', '$rootScope', '$http', '$location', '$uibModalInstance',
  function($scope, $rootScope, $http, $location, $uibModalInstance) {

      $scope.signup = function(){
        $uibModalInstance.close("signup");
      }

      $scope.signupWithEmail = function(){
        $uibModalInstance.dismiss();
      }
}]);
