angular.module('myWords.detail')

    .controller("DetailController", function ($scope, $http, $routeParams) {
        'use strict';

        $scope.name = $routeParams.listId;

        $http.get('app/data/data.json').
            success(function (data, status, headers, config) {
                $scope.data = data;
            }).
            error(function (data, status, headers, config) {
                // log error
            });

        this.shuffleWord = function (word) {
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