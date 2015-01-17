angular.module('myWords.home')

    .service("HomeService", function ($http) {
        'use strict';

        var lists = ['abc', 'efg'];


        this.getList = function () {
            return $http.get('app/data/lists.json').
                success(function (data, status, headers, config) {
                    console.log(data);
                    return data;
                });
        };


        this.getList2 = function () {
            return lists;
        };
    });