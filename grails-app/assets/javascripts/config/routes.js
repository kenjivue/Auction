/**
 * Created by Kenji Vue on 5/3//2015.
 */


angular.module('app').config(function($routeProvider) {
  $routeProvider.when("/listings", {templateUrl: "templates/listing.html"});
  $routeProvider.when("/listing/:id", {templateUrl: "templates/Detail.html"});
  $routeProvider.when("/account", {templateUrl: "templates/account.html"});
  $routeProvider.when("/listing/find", {templateUrl: "templates/listing.html"});
  $routeProvider.when("/account/:id", {templateUrl: "templates/account.html"});
  $routeProvider.when("/review/:id", {templateUrl: "templates/review.html"});
  $routeProvider.otherwise({templateUrl: "templates/listing.html"});
});