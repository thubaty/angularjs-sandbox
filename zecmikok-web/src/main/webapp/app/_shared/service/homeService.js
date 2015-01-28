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

        this.updateWord = function (word) {
            return $http.put('/wordservice/', word).
                success(function (data, status, headers, config) {
                    return data;
                });
        };
    });