/**
 * Created by Kenji Vue on 5/3//2015.
 */


'use strict';

angular.module('app').factory('Bid', function ($resource) {
    return $resource('api/bids/:id', {},
        {create: {method: 'PUT'}}
    );
});