angular.module('scotchApp')
    .controller('recordController', function ($scope,$rootScope,$http,$location) {
        // create a message to display in our view
        $rootScope.allow = true;
        $scope.openModal=false;
        $scope.getBack = function () {
            $scope.openModal = false;
            $location.url('registers');
        };


        $scope.getLoads = function () {

            $http.get("http://localhost:8080/api/inventory/loads")
                .then(function (response) {
                    $scope.allLoads = response.data.data;
                }, function (error) {
                    // console.log("Error");
                });
        };

        $scope.getLoads();




    });