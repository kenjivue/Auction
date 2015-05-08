/**
 * Created by Kenji Vue on 5/3//2015.
 */


angular.module('app').config(function($routeProvider) {
  $routeProvider.when("/listings", {templateUrl: "templates/listings.html"});
  $routeProvider.when("/listing/:id", {templateUrl: "templates/listingDetail.html"});
  $routeProvider.when("/account", {templateUrl: "templates/account.html"});
  $routeProvider.when("/login", {templateUrl: "templates/login.html"});
  $routeProvider.otherwise({templateUrl: "templates/listings.html"});
});