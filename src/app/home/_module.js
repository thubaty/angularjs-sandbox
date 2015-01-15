angular.module('myWords.home', [])


    .config(function ($routeProvider) {
        'use strict';

        console.log("adding");

        $routeProvider
            .when('/', {
                controller: 'WordController as ctrl',
                templateUrl: 'app/home/view/index.html'
            });
    });

