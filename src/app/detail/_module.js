angular.module('myWords.detail', [])

    .config(function ($routeProvider) {
        'use strict';

        $routeProvider
            .when('/detail/:listId', {
                templateUrl: 'app/detail/view/index.html',
                controller: "DetailController as ctrl"
            });
    });
