/**
 * Created by Kenji Vue on 5/3/2015.
 */

'use strict';

angular.module('app').controller('AccountController', function ($scope, $resource, confirmDialog, Account) {
    var refreshAccountList = function () {
        $scope.accounts = Account.query();
        $scope.accounts.$promise.then(function (result) {
            $scope.totalItems = result.length;
            $scope.currentPage = 1;
        });
    };

    $scope.addAccount = function () {
        $scope.newAccount = {};
        $scope.alerts = [];
    };

    $scope.saveAccount = function () {
        var Account = $scope.newAccount;
        Account.save(Account).$promise.then(function () {
            $scope.alerts.push({type: 'success', msg: 'Account added: ' + Account.name});
            refreshAccountList();
        });
        delete $scope.newAccount;
    };

    $scope.deleteAccount = function (Account) {
        $scope.alerts = [];
        confirmDialog('Confirm Delete', 'Are you sure you want to delete Account "' + Account.name + '"?')
            .result.then(function () {
                Account.$delete({id: Account.id}).then(function () {
                    $scope.alerts.push({type: 'success', msg: Account.name + ' removed'});
                    refreshAccountList();
                });
            });
    };

    $scope.alerts = [];
    refreshAccountList();
});