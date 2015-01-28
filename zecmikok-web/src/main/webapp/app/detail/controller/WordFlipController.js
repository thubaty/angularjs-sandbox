angular.module('myWords.detail')

    .controller("WordFlipController", function ($scope) {
        'use strict';

        $scope.wordFlipped = false;

        $scope.toggleWord = function () {
            $scope.wordFlipped = !$scope.wordFlipped;
        }

        $scope.isFlipped = function () {
            return $scope.wordFlipped
        }
    });