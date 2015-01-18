angular.module('myWords.home', [])


    .config(function ($routeProvider) {
        'use strict';

        console.log("adding");

        $routeProvider
            .when('/', {
                controller: 'HomeController as ctrl',
                templateUrl: 'app/home/view/index.html'
            });
    });

