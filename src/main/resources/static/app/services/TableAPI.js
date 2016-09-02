CURMASApp.factory('TableAPI', ['$http', function($http) {
    var tableAPI = {};

    tableAPI.getAllCurrencies = function() {
        return $http({
            method: 'GET',
            url: '/api/curmas'
        }).then(function(res) { return res.data; });
    };

    tableAPI.getAllCurrencyStatuses = function() {
        return $http({
            method: 'GET',
            url: '/api/curmas/statuses'
        }).then(function(res) { return res.data; });
    };

    tableAPI.findByCurrencyCode = function(params) {
        return $http({
            method: 'GET',
            url: '/api/curmas/find-by-code',
            params: params
        }).then(function(res) { return res.data; });
    };

    tableAPI.findByCurrencyDescription = function(params) {
        return $http({
            method: 'GET',
            url: '/api/curmas/find-by-description',
            params: params
        }).then(function(res) { return res.data; });
    };

    tableAPI.findByStatus = function(data) {
        return $http({
            method: 'POST',
            url: '/api/curmas/find-by-status',
            data: data
        }).then(function(res) { return res.data; });
    };

    tableAPI.addNewCurrency = function(data) {
        return $http({
            method: 'POST',
            url: '/api/curmas/add-currency',
            data: data
        }).then(function(res) { return res.data; });
    };

    tableAPI.removeCurrency = function(data) {
        return $http({
            method: 'DELETE',
            url: '/api/curmas/remove-currency',
            data: data
        }).then(function(res) { return res.data; });
    };

    return tableAPI;
}]);