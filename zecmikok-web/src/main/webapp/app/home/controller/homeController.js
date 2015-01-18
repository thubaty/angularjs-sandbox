angular.module('myWords.home')

    .controller("HomeController", function ($scope, $http, HomeService) {
        'use strict';

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
        };
    });