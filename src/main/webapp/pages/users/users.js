angular.module('scotchApp')
    .controller('aboutController', function ($scope,$rootScope,$http) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
        $rootScope.allow = true;
    });