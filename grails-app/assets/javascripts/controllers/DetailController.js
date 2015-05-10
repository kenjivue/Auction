/**
 * Created by Kenji Vue on 5/3//2015.
 */


'use strict';

angular.module('app').controller('DetailController', function ($scope, $routeParams, $location, $http, Bid, Review, loggedInUser) {
    $scope.loggedInUser = loggedInUser;
    $scope.alerts = [];
    var getListingDetail = function() {
        $scope.listings = Listing.query();
        $scope.listings.$promise.then(function (result) {
            $scope.totalItems = result.length;
            $scope.currentPage = 1;
        });
    };

    getListingDetail();

    $scope.newBid = function() {
        $scope.newBid = {};
    };

    $scope.saveBid = function() {

    };

    $scope.cancelBid = function() {
        $scope.clearAlerts();
        delete $scope.newBid;
    };

    $scope.newRev= function(){

    };

    $scope.saveRevi = function() {
        $scope.clearAlerts();

    };

    $scope.cancelRev = function() {

    };


    $scope.clearAlerts = function () {
        $scope.alerts.forEach(function (index) {
            $scope.alerts.splice(index);
        });
    };
});
