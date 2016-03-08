/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global angular */

var sisAd = angular.module('SisAd', [
    'ui.router',
    'oc.lazyLoad'
]);

sisAd.config(function ($stateProvider, $urlRouterProvider) {
    //For any unmatched url,redirect to /state1
    $urlRouterProvider.otherwise("/state1");

    //Now set up the states
    $stateProvider
            .state('state1', {
                url: "/state1",
                templateUrl: "state1/state1.html",
                controller:"state1Ctrl",
                resolve:{
                    loadMyCtrl:['$ocLazyLoad',function($ocLazyLoad){
                            return $ocLazyLoad.load(
                                    'state1/state1Ctrl.js'
                                    );
                    }]
                }
            })
            .state('state2', {
                url: "/state2",
                templateUrl: "state2/state2.html",
                controller:"state2Ctrl"
            })
            .state('state3', {
                url: "/state3",
                templateUrl: "state3/state3.html",
                controller:"state3Ctrl"
            });
});


