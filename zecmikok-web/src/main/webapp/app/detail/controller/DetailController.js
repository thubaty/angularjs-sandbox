angular.module('myWords.detail')

    .controller("DetailController", function ($scope, $http, $routeParams, HomeService) {
        'use strict';

        $scope.data = {
            name: "unknown"
        };

        var listId = $routeParams.listId;
        $scope.data.name = listId;

        function komuTrubisKara() {
            HomeService.getWordsForList(listId).then(function (data) {
                $scope.data.wordList = data.data;
            }, function (error) {
                console.log("error");
            });
        }

        function updateWord(word) {
            HomeService.updateWord(word).then(function (data) {
                komuTrubisKara();
            }, function (error) {
                console.log("error");
            });
        }

        komuTrubisKara();

        $scope.wordNo = function (word) {

            word.done = true;
            word.state = word.state - 1;
            word.know3 = word.know2;
            word.know2 = word.know1;
            word.know1 = false;

            updateWord(word);
            console.log(word);

            /* var idx;
            var x;
            if (word) {
                idx = $scope.data.wordList.indexOf(word);
                x = $scope.data.wordList.splice(idx, 1);
                x[0].done = true;
                $scope.data.wordList.push(x[0]);
             }*/
            komuTrubisKara();
        };

        $scope.wordDetail = function (word) {
            var w1 = word.know1 ? "Y" : "N"
            var w2 = word.know2 ? "Y" : "N";
            var w3 = word.know3 ? "Y" : "N";
            console.log(w1 + w2 + w3);
            return w1 + w2 + w3;
        }

        $scope.wordColor = function (word) {
            var w1 = word.know1 ? "Y" : "N"
            var w2 = word.know2 ? "Y" : "N";
            var w3 = word.know3 ? "Y" : "N";
            var kg = w1 + w2 + w3;
            if (kg == "YYY") {
                return "#2AB23F";
            } else if (kg == "NYY") {
                return "#788C47";
            } else if (kg == "YNY") {
                return "#5E9844";
            } else if (kg == "YYN") {
                return "#44A541";
            } else if (kg == "NNY") {
                return "#C6664F";
            } else if (kg == "NYN") {
                return "#927F49";
            } else if (kg == "YNN") {
                return "#AC734C";
            } else if (kg == "NYY") {
                return "#E05A52";
            } else {
                return "#F34439";
            }
        }

        $scope.wordYes = function (word) {

            word.done = true;
            word.state = word.state + 1;
            word.know3 = word.know2;
            word.know2 = word.know1;
            word.know1 = true;
            updateWord(word);
            console.log(word);

            komuTrubisKara();
        };
    });