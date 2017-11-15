angular.module('scotchApp')
    .controller('homeController', function ($scope,$rootScope,$http,$location) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
        $rootScope.allow = false;
        $scope.user = {};


        $scope.login = function () {

                $http.post("http://localhost:8080/api/user/login", $scope.user).then
                (
                    function(response)
                    {
                        // console.log($scope.trialCompany);
                        var token = response.data.data.token;
                        localStorage.setItem("token", token);


                        $http.defaults.headers.common.Authorization = "Bearer "+ localStorage.getItem("token");
                        $scope.succesfulRegister = true;
                        $rootScope.allow = true;


                        // alert("se inicio");
                        $location.path( '/roles' );


                        // $timeout(function() {
                        //     $window.location.href = 'https://app.inin.global/#!/cuenta/login';
                        // }, 10000); // 3 seconds
                    },
                    function(error){
                        // console.log($scope.trialCompany);
                        $rootScope.allow = false;
                        $scope.errorsFounded = error.data.message;
                        alert($scope.errorsFounded);

                    }
                );


        };


        $scope.go = function ( path ) {
            $location.path( path );
        };

    });