/**
 * Created by Kenji Vue on 5/3//2015.
 */


'use strict';

angular.module('app').factory('Listing', function ($resource) {
    return $resource('api/listing/:id', {},
        {create: {method: 'PUT'}}
    );
});

