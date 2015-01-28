angular.module('myWords.detail')

    .controller("DetailController", function ($scope, $http, $routeParams, HomeService) {
        'use strict';

        $scope.data = {
            name: "unknown"
        };

        var listId = $routeParams.listId;
        $scope.data.name = listId;

        function loadWordList() {
            console.log("loading list");
            return HomeService.getWordsForList(listId).then(function (data) {
                console.log("load list done");
                $scope.data.wordList = data.data;
                $scope.spinnerloading = false;
            });
            ;
        }

        function updateWord(word) {
            return HomeService.updateWord(word);
        }

        console.log("loading list init");
        loadWordList();

        $scope.wordNo = function (word) {
            $scope.spinnerloading = true;
            word.state = word.state - 1;
            word.know3 = word.know2;
            word.know2 = word.know1;
            word.know1 = false;
            updateWord(word).then(loadWordList());
        };

        $scope.wordYes = function (word) {
            $scope.spinnerloading = true;
            word.state = word.state + 1;
            word.know3 = word.know2;
            word.know2 = word.know1;
            word.know1 = true;
            updateWord(word).then(loadWordList());
        };

        $scope.wordDetail = function (word) {
            var w1 = word.know1 ? "Y" : "N"
            var w2 = word.know2 ? "Y" : "N";
            var w3 = word.know3 ? "Y" : "N";
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

    });