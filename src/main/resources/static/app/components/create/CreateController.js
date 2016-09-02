angular.module('CURMASApp').controller('CurMasAddController',
    ['$rootScope', '$scope', '$state', 'TableAPI', '$log',
    function($rootScope, $scope, $state, TableAPI, $log) {

    $scope.newCurrency = {
        currencyCode: "",
        currencyDescription: "",
        status: {}
    };

    $scope.setup = function() {

        /* get list of currency statuses */
        TableAPI.getAllCurrencyStatuses().then(function(response) {
            $scope.statuses = response;
            $scope.newCurrency.status = response[0];
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    $scope.setup();

    $scope.addNewCurrency = function(currency) {
        TableAPI.addNewCurrency(currency).then(function(response) {

            $log.info('currency added successfully');

            /* reset input */
            $scope.newCurrency.currencyCode = "";
            $scope.newCurrency.currencyDescription = "";

        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };
}]);