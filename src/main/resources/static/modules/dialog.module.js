const dialog = angular.module('dialog', ['ngMaterial', 'ngMessages']);

dialog.controller('title.dialog.controller', function ($scope, $mdDialog) {
  $scope.dvd = {};
  $scope.close = () => $mdDialog.cancel();
  $scope.insert = () => $mdDialog.hide(new FormData($scope.dvd));
});

dialog.controller('customer.dialog.controller', function ($scope, $mdDialog) {
  $scope.customer = {};
  $scope.close = () => $mdDialog.cancel();
  $scope.insert = () => $mdDialog.hide($scope.customer);
});


dialog.service('dialogService', function () {

});
