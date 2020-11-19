const product = angular.module('product', []);

product.controller('product.controller', function ($scope) {
  $scope.product = { name: 'phone' };
})
