angular.module('CURMASApp').controller('CurMasController',
    ['$rootScope', '$scope', '$state', 'TableAPI', '$log',
    function($rootScope, $scope, $state, TableAPI, $log) {

    $scope.createFromCopy = {
        currencyCode: "",
        currencyDescription: "",
        status: {}
    };

    $scope.getAllCurrencies = function() {

        TableAPI.getAllCurrencies().then(function(response) {
            $scope.allCurrencies = response;
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    $scope.editCurrency = function(currency) {
        currency.editMode = true;

        /* get list of currency statuses */
        TableAPI.getAllCurrencyStatuses().then(function(response) {
            $scope.statuses = [];
            angular.forEach(response, function(status) {
                $scope.statuses.push(status);
                if (currency.status.status == status.status) {
                    currency.status = status;
                }
            });
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    $scope.removeCurrency = function(currency) {
        TableAPI.removeCurrency(currency).then(function(response) {
            /* reload currencies */
            $scope.getAllCurrencies();
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    /* reset input */
    $scope.ignoreCreateFrom = function() {
        $scope.createFromCopy.currencyCode = "";
        $scope.createFromCopy.currencyDescription = "";
        $scope.createFromCopy.status = {};
    };

    $scope.addCurrencyFrom = function(currency) {

        $scope.createFromCopy.currencyCode = currency.currencyCode;
        $scope.createFromCopy.currencyDescription = currency.currencyDescription;
        $scope.createFromCopy.status = currency.status;

        /* get list of currency statuses */
        TableAPI.getAllCurrencyStatuses().then(function(response) {
            $scope.statuses = [];
            angular.forEach(response, function(status) {
                $scope.statuses.push(status);
                if (currency.status.status == status.status) {
                    $scope.createFromCopy.status = status;
                }
            });
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    $scope.addNewCurrency = function(currency) {
        TableAPI.addNewCurrency(currency).then(function(response) {

            $log.info('currency added successfully');

            /* reset input */
            $scope.createFromCopy.currencyCode = "";
            $scope.createFromCopy.currencyDescription = "";
            $scope.createFromCopy.status = {};

            /* reload currencies */
            $scope.getAllCurrencies();

        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    /* initial load currencies */
    $scope.getAllCurrencies();
}]);