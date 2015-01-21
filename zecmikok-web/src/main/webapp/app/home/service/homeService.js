angular.module('myWords.home')

    .service("HomeService", function ($http) {
        'use strict';

        var lists = ['abc', 'efg'];

        function logSomething(d) {
            console.log("loggin " + d);
        }

        this.getList = function () {
            return $http.get('rest/wordservice/getall').
                success(function (data, status, headers, config) {
                    logSomething(data);
                    return data;
                });
        };


        this.getList2 = function () {
            return lists;
        };
    });