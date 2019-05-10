angular.module('app', ['ngAnimate', 'ngRoute', 'ngResource', 'ngDialog'])
    .config(function ($routeProvider) {
		
        $routeProvider.when('/proposal', {
            templateUrl: '/html/proposal.html',
            controller: 'ProposalController'
        });
		
        $routeProvider.otherwise({ redirectTo: '/' });

    });