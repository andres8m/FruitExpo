angular.module('scotchApp')
    .controller('contactController', function ($scope,$rootScope,$http,$location) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
        $rootScope.allow = true;




        $scope.loadNewLoad = function () {
            $location.url('registers/newload');
        };

        $scope.loadRecords = function () {
            $location.url('registers/record');
        };




    });