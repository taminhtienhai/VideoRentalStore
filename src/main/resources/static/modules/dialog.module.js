import {compute} from "../utils/functional.util.js";
import {get, toJSON} from "../utils/ajax.util.js";

const dialog = angular.module('dialog', ['ngMaterial', 'ngMessages']);

dialog.controller('title.dialog.controller', function ($scope, $mdDialog) {
  $scope.dvd = {};
  $scope.close = () => $mdDialog.cancel();
  $scope.insert = () => $mdDialog.hide($scope.dvd);
});

dialog.controller('customer.dialog.controller', function ($scope, $mdDialog) {
  $scope.customer = {};
  $scope.close = () => $mdDialog.cancel();
  $scope.insert = () => $mdDialog.hide($scope.customer);
});

dialog.controller('rental.dialog.controller', function ($scope, $mdDialog, dialogService) {
  $scope.rentalInfo = {};
  $scope.videos = [];
  $scope.close = () => $mdDialog.cancel();
  $scope.insert = () => {
    $scope.rentalInfo.customer = {
      id: $scope.rentalInfo.customerId
    };
    $scope.rentalInfo.rentalDetails = $scope.rentalInfo.videos.map(video => ({ dvd: video.id }));
    $mdDialog.hide($scope.rentalInfo);
  };

  $scope.addVideo = () => {
    const titleId = $scope.rentalInfo.titleId;
    const existed = $scope.videos.some(video => video.id == titleId);
    existed || dialogService
      .findVideoById(titleId)
      .then(video => video && $scope.videos.push(video));
  }
});


dialog.service('dialogService', function () {
  this.findVideoById = (id) => {
    return compute(toJSON, get)(`/title/find/${id}`);
  };
});
