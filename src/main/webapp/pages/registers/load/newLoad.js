angular.module('scotchApp')
    .controller('newLoadController', function ($scope,$rootScope,$http,$location) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
        $rootScope.allow = true;
        $scope.load={};
        $scope.openModal=false;

        $scope.getEmployees = function () {

            $http.get("http://localhost:8080/api/employee/all")
                .then(function (response) {
                    $scope.allEmployees=response.data.data;

                }, function (error) {
                    // console.log("Error");

                });


        };

        $scope.getEmployees();

        $scope.createLoad = function () {

            $http.post("http://localhost:8080/api/inventory/load", $scope.load)
                .then(function (response) {
                    // alert(response);
                    $scope.response=response.data.data;
                    $scope.openModal = true;

                }, function (error) {
                    alert(error);
                    // console.log("Error");
                });
        };

        $scope.getBack = function () {
            $scope.openModal = false;
            $location.url('registers');
        };





    });