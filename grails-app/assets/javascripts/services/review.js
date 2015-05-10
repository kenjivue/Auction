/**
 * Created by Kenji Vue on 5/3//2015.
 */


'use strict';

angular.module('app').factory('Review', function ($resource) {
    return $resource('api/review/:id', {},
        {create: {method: 'PUT'}}
    );
});