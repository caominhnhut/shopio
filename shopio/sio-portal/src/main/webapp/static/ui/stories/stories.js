angular.module('myApp.stories', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/stories', {
    templateUrl: 'sio-portal/static/ui/stories/stories.html',
    controller: 'StoriesCtrl'
  });
}])

.controller('StoriesCtrl', ['$scope', '$rootScope', '$http', '$location',
  function($scope, $rootScope, $http, $location){
    $scope.message = "The stories page will be present latter";
  }]);