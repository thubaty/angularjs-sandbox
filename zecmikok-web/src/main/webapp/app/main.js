angular.module('myWords', ['ngRoute', 'myWords.home', 'myWords.shared', 'myWords.detail'])

    .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.
                otherwise({
                    redirectTo: 'app/_shared/views/error/404.html'
                });
        }]);


