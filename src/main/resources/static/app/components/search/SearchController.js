angular.module('CURMASApp').controller('CurMasSearchController',
    ['$rootScope', '$scope', '$state', 'TableAPI', '$log',
    function($rootScope, $scope, $state, TableAPI, $log) {

    $scope.searchResults = [];

    $scope.searchByCode = function(code) {
        TableAPI.findByCurrencyCode({code: code}).then(function(response) {
            $scope.searchResults = response;
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    $scope.searchByDescription = function(description) {
        TableAPI.findByCurrencyDescription({description: description}).then(function(response) {
            $scope.searchResults = response;
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    $scope.searchByStatus = function(status) {
        TableAPI.findByStatus(status).then(function(response) {
            $scope.searchResults = response;
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };

    $scope.setup = function() {

        /* get list of currency statuses */
        TableAPI.getAllCurrencyStatuses().then(function(response) {
            $scope.statuses = response;
        }, function(error) {
            $log.error('ERROR|' + error.data.timestamp + '|' + error.data.message);
        });
    };
    $scope.setup();
}]);