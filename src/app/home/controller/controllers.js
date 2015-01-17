angular.module('myWords.home')

    .controller('WordController', function ($scope) {
        'use strict';

        console.log('out');

        $scope.data = {
            groups: [
                {"text": "Buy beer", "done": false, "tags": ["home", "urgent"]},
                {"text": "Send spreadsheet", "done": false, "tags": ["work", "urgent"]}, {
                    "text": "Send spreadsheet",
                    "done": false,
                    "tags": ["work", "urgent"]
                }, {"text": "Call Jim", "done": false, "tags": ["work"]}, {
                    "text": "Recharge credit card",
                    "done": false,
                    "tags": ["wife", "urgent"]
                }, {
                    "text": "Print monthly report",
                    "done": false,
                    "tags": ["work", "urgent"]
                }, {"text": "Print monthly report", "done": false, "tags": ["work", "urgent"]}
            ]
        };

        this.shuffleWord = function (word) {
            console.log("adding");
            var idx;
            var x;
            if (word) {
                idx = $scope.data.tasks.indexOf(word);
                x = $scope.data.tasks.splice(idx, 1);
                x[0].done = true;
                $scope.data.tasks.push(x[0]);
        }
        }
    });