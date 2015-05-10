/**
 * Created by Kenji Vue on 5/3//2015.
 */

'use strict';

angular.module('app').controller('ListingController', function ($scope, $modal, $http, $location, Listing, loggedInUser) {
    $scope.loggedInUser = loggedInUser;
    var refreshListing = function(){
            $scope.listings = Listing.query();
            $scope.listings.$promise.then(function (result) {
                $scope.totalItems = result.length;
                $scope.currentPage = 1;

        });
    };
        var find = function () {
        var params = $scope.params;
        params.filter = txtSearch.value;
        params.Completed = showCompleted.value;
        return $http.get('/api/listings/'+params.max).then(function (response) {
            $scope.listings = response.data;
        });
    };
    $scope.alerts = [];

    $scope.getListings = function($event, id) {
        var checkbox = $event.target;
        if (checkbox.checked) {
            return $http.get('/api/listings/'+params.max).then(function (response) {
                $scope.listings = response.data;
            });
        }
        else {
            return $http.get('/api/listings/'+params.max+'&Completed=true').then(function (response) {
                $scope.listings = response.data;
            });
        }
    };

    $scope.addListing = function() {
        $scope.newListing = {};
    };

    $scope.saveListing = function() {
        $scope.clearAlerts();

        var listingInstance = $scope.newListing;
        listingInstance.name = txtListingName.value;
        listingInstance.description = txtListingDesc.value;
        //had to comment out this line because could not get HTML/javascript date to format in a way grails would accept
        //listing.startDate = txtStartDate.value;
        listingInstance.listingDays = txtDays.value;
        listingInstance.startingPrice = txtStartingPrice.value;
        listingInstance.deliverOption = pklDeliverOption.value;

        listingInstance.save(listingInstance).$promise.then(function(listingInstance) {
                $scope.alerts.push({type: 'success', msg: 'Listing added: ' + listingInstance.name});
                delete $scope.newListing;
                activeListings();
                $location.path("/api/listings");
            }, function(error) {
                $scope.alerts.push({type: 'danger', msg: 'error: Listing could not be created: ' + error.data});
            }
        );
    };

    $scope.cancelListing = function() {
        delete $scope.newListing;
    };

    $scope.closeAlert = function (index) {
        $scope.alerts.splice(index, 1);
    };

    $scope.clearAlerts = function () {
        $scope.alerts.forEach(function (index) {
            $scope.alerts.splice(index);
        });
    };
refreshListing();
});



