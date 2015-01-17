angular.module('myWords.home')

    .controller("HomeController", function ($scope, $http, HomeService) {
        'use strict';


        $http.get('app/data/data.json').
            success(function (data, status, headers, config) {
                $scope.data = data;
            }).
            error(function (data, status, headers, config) {
                // log error
            });

        HomeService.getList().then(function (data) {
            $scope.lists = data.data;
        }, function (error) {
            console.log("error");
        });

        console.log($scope.lists);

        this.shuffleWord = function (word) {
            console.log("adding");
            var idx;
            var x;
            if (word) {
                idx = $scope.data.indexOf(word);
                x = $scope.data.splice(idx, 1);
                x[0].done = true;
                $scope.data.push(x[0]);
            }
        }
    });