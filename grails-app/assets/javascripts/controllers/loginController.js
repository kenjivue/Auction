/**
 * Created by Kenji Vue on 5/3//2015.
 */

'use strict';

angular.module('app').controller('loginController', function ($rootScope, $scope, $modal, $http) {

    var authenticate = function (credentials, callback) {

        var headers = credentials ? {
            authorization: "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('account', {headers: headers})
            .success(function (data) {
                if (data.username) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }).error(function () {
                $rootScope.authenticated = false;
                callback && callback();
            });

    };

    $scope.credentials = {};

    $scope.login = function () {
        authenticate($scope.credentials, function () {
            if ($rootScope.authenticated) {
                $location.path("/Auction");
            } else {
                $scope.alerts.push({type: 'danger', msg: 'error logging in'});
            }
        });
    };

    $scope.alerts = [];
});