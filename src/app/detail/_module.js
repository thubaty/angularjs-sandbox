angular.module('myWords.detail', [])

    .config(function ($routeProvider) {
        'use strict';

        $routeProvider
            .when('/detail', {
                templateUrl: 'app/detail/view/index.html'
            });
    });
