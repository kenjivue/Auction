/**
 * Created by Kenji Vue on 5/3//2015.
 */


'use strict';

angular.module('app').factory('Account', function ($resource) {
    return $resource('accounts', {},
        {save: {method: 'POST'}}
    );
});

