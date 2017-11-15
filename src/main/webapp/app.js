var scotchApp = angular.module('scotchApp', ['ui.materialize'])

    .controller('BodyController', ["$scope","$http","$timeout","$window", function ($scope, $http, $timeout,$window)
    {
        $scope.user={};
        $scope.canSend = true;
        $scope.actionButton = "Iniciar sesion";
        $scope.actionLink ="Registrate";

        $scope.login = function () {

            if($scope.actionButton ==="Iniciar sesion")
            {
                $http.post("http://localhost:8080/api/user/login", $scope.user).then
                (

                    function(response)
                    {
                        // console.log($scope.trialCompany);
                        $scope.succesfulRegister = true;
                        alert("se inicio");


                        // $timeout(function() {
                        //     $window.location.href = 'https://app.inin.global/#!/cuenta/login';
                        // }, 10000); // 3 seconds
                    },
                    function(error){
                        // console.log($scope.trialCompany);
                        $scope.errorsFounded = error.data.message;
                        alert($scope.errorsFounded);

                    }
                );
            }
            else
            {

                $http.post("http://localhost:8080/api/user/register", $scope.user).then
                (

                    function(response)
                    {
                        // console.log($scope.trialCompany);
                        $scope.succesfulRegister = true;
                        alert("se inicio");


                        // $timeout(function() {
                        //     $window.location.href = 'https://app.inin.global/#!/cuenta/login';
                        // }, 10000); // 3 seconds
                    },
                    function(error){
                        // console.log($scope.trialCompany);
                        $scope.errorsFounded = error.data.message;
                        alert($scope.errorsFounded);

                    }
                );


            }

        };

        $scope.setRegister = function () {
            if($scope.actionButton ==="Registrate")
            {
                $scope.actionButton = "Iniciar sesion";
                $scope.actionLink ="Registrate";
            }
            else
            {
                $scope.actionButton ="Registrate";
                $scope.actionLink ="Iniciar sesion";
            }
        }


        

    }]);