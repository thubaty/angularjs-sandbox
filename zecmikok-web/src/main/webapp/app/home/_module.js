angular.module('myWords.home', [])


    .config(function ($routeProvider) {
        'use strict';

        $routeProvider
            .when('/', {
                controller: 'HomeController as ctrl',
                templateUrl: 'app/home/view/index.html'
            });
    });

