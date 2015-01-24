angular.module('myWords.home')

    .service("HomeService", function ($http) {
        'use strict';

        this.getAll = function () {
            return $http.get('/wordservice/getall').
                success(function (data, status, headers, config) {
                    return data;
                });
        };

        this.getWordsForList = function (listId) {
            return $http.get('/wordservice/getwords/' + listId).
                success(function (data, status, headers, config) {
                    return data;
                });
        };

        this.getList = function (listId) {
            return $http.get('/wordservice/' + listId).
                success(function (data, status, headers, config) {
                    return data;
                });
        };

        this.updateWordList = function (wordList) {
            return $http.put('/wordservice/' + wordList.id, wordList).
                success(function (data, status, headers, config) {
                    return data;
                });
        };
    });