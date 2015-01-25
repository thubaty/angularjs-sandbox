angular.module('myWords.detail')

    .controller("DetailController", function ($scope, $http, $routeParams, HomeService) {
        'use strict';

        $scope.data = {
            name: "unknown"
        };

        var listId = $routeParams.listId;
        $scope.data.name = listId;

        HomeService.getWordsForList(listId).then(function (data) {
            $scope.data.wordList = data.data;
        }, function (error) {
            console.log("error");
        });

        $scope.shuffleWord = function (word) {

            word.done = true;
            word.state = word.state + 1;
            HomeService.updateWord(word);
            console.log(word);

            var idx;
            var x;
            if (word) {
                idx = $scope.data.wordList.indexOf(word);
                x = $scope.data.wordList.splice(idx, 1);
                x[0].done = true;
                $scope.data.wordList.push(x[0]);
            }
        };
    });