/**
 * Created by Kenji Vue on 5/3//2015.
 */


'use strict';

angular.module('app').factory('Review', function ($resource) {
    return $resource('reviews', {},
        {save: {method: 'POST'}}
    );
});