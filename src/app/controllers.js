angular.module('myWords')

    .controller('WordController', function ($scope) {
        'use strict';

        $scope.data = {
            filterByDone: false,
            tasks: [
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

        /*this.saveNewTask = function() {
         $scope.data.tasks.push({
         text: $scope.data.text,
         done: false,
         tags: $scope.data.newTaskTags,
         });
         $scope.data.text = '';
         $scope.data.newTaskTags = [];
         };

         this.getDoneCount = function() {
         return _.reduce($scope.data.tasks, function(memo, task) {
         if (task.done) {
         return memo + 1
         } else {
         return memo
         }
         }, 0);
         }

         this.filterByDone = function(task) {
         if ($scope.data.filterByDone) {
         return task.done;
         }

         return true;
         }

         this.filterByTags = function(task) {
         if ($scope.data.selectedTags.length) {
         var matchedTags = _.intersection($scope.data.selectedTags, task.tags);
         return !!matchedTags.length;
         }

         return true;
         }*/
    });
