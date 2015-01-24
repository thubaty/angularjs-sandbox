angular.module('myWords.detail')

    .controller("DetailController", function ($scope, $http, $routeParams, HomeService) {
        'use strict';

        var listId = $routeParams.listId;
        $scope.name = listId;

        console.log($routeParams.listId);

        HomeService.getWordsForList(listId).then(function (data) {
            $scope.data = data.data;
        }, function (error) {
            console.log("error");
        });

        this.shuffleWord = function (word) {

            HomeService.getList(listId).then(function (result) {
                var currentList = result.data;
                console.log(currentList);
                currentList.name = "someshit";
                HomeService.updateWordList(currentList);

            }, function (error) {
                console.log("error");
            });

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