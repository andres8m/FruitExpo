// script.js

// create the module and name it scotchApp
// also include ngRoute for all our routing needs
var scotchApp = angular.module('scotchApp', ['ngRoute','ui.materialize']);

// configure our routes
scotchApp.config(function($routeProvider) {
    $routeProvider

    // route for the home page
        .when('/', {
            templateUrl : 'pages/home/home.html',
            controller  : 'homeController'
        })

// ----------------------------------------------    Roles & users----------------------------------------------------------------------------------------------


        // route for the users page
        .when('/roles', {
            templateUrl : 'pages/users/users.html',
            controller  : 'aboutController'
        })






//-------------------------------- --------------------------       Registers ------------------------------------------------------------------------------

        // route for the registers page
        .when('/registers', {
            templateUrl : 'pages/registers/registers.html',
            controller  : 'contactController'
        })

        .when('/registers/newload', {
            templateUrl : 'pages/registers/load/newLoad.html',
            controller  : 'newLoadController'
        })

        .when('/registers/record', {
            templateUrl : 'pages/registers/record/record.html',
            controller  : 'recordController'
        })






 // ------------------------------------------------      Configuration ----------------------------------------------------------------------------------

        .when('/config', {
            templateUrl : 'pages/registers.html',
            controller  : 'contactController'
        });
});


scotchApp.controller('NavCtrl',
    ['$scope', '$location','$http','$rootScope', function ($scope, $location,$http,$rootScope) {

        $http.defaults.headers.common.Authorization = "Bearer "+ localStorage.getItem("token");

        $scope.navClass = function (page) {
            var currentRoute = $location.path().substring(1) || 'home';
            return page === currentRoute ? 'active' : '';
        };

        $scope.loadHome = function () {
            $location.url('/');
        };

        $scope.loadAbout = function () {
            $location.url('/roles');
        };

        $scope.loadContact = function () {
            $location.url('/registers');
        };

    }]);




// create the controller and inject Angular's $scope

// scotchApp.controller('mainController', function($scope) {
//     // create a message to display in our view
//     $scope.message = 'Everyone come and see how good I look!';
//
//
// });


// scotchApp.controller('aboutController', function($scope) {
//     $scope.message = 'Look! I am an users page.';
// });
//
// scotchApp.controller('contactController', function($scope) {
//     $scope.message = 'Contact us! JK. This is just a demo.';
// });
