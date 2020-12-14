import {post, toJSON} from "./utils/ajax.util.js";

const app = angular.module('app',
  ['ngRoute', 'ngMaterial', 'home', 'dialog']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: '/templates/home.template.html',
      controller: 'home.controller'
    })
    // .when('/product', {
    //   templateUrl: '/templates/product.template.html',
    //   controller: 'product.controller'
    // })
    .when('/error', {
      templateUrl: '/templates/error.template.html'
    })
    .otherwise({
      redirectTo: '/error',
    });
});

app.component('app', {
  templateUrl: '/templates/app.template.html',
  controller: 'app.controller'
});

app.controller('app.controller', function ($scope, appFactory) {
  $scope.searchBox = '';
  $scope.mode = 0;
  // Open Add New Title Dialog
  $scope.openTitleDialog = appFactory.openDialog('/templates/dialog/title.dialog.html')
  ('title.dialog.controller')
  ((formData) => {
    appFactory
      .doChange('title', 'insert', formData)
      .then(appFactory.handleAPIError)
      .catch(appFactory.handleFetchError);
  });

  // Open Add New Customer Dialog
  $scope.openCustomerDialog = appFactory.openDialog('/templates/dialog/customer.dialog.html')
  ('customer.dialog.controller')
  ((formData) => {
    appFactory
      .doChange('customer', 'insert', formData)
      .then(appFactory.handleAPIError)
      .catch(appFactory.handleFetchError);
  });

  $scope.openRentalDialog = appFactory.openDialog('/templates/dialog/rental.dialog.html')
  ('rental.dialog.controller')
  ((formData) => {
    appFactory
      .doChange('rental', 'insert', formData)
      .then(appFactory.handleAPIError)
      .catch(appFactory.handleFetchError);
  });

  $scope.changeMode = () => $scope.$broadcast('ChangeModeEvent', $scope.mode);

});

app.service('appService', function ($scope) {
  this.scream = (message) => alert(message);
});

app.factory('appFactory', function ($mdDialog, $mdToast) {
  const simpleToast = (message) => $mdToast
    .simple()
    .textContent(message)
    .position('bottom right')
    .toastClass('md-success-toast-theme')
    .hideDelay(2500);

  return {
    openDialog: (templateUrl) => (controller) => (confirm) => () => $mdDialog
      .show({
        templateUrl,
        controller,
        clickOutsideToClose:true
      })
      .then(confirm, () => console.log(`Cancel dialog ${templateUrl}`)),
    doChange: (name, action, data) => {
      return post(`/${name}/${action}`, data);
    },
    handleFetchError: (error) => {
      $mdToast.show(simpleToast(error));
    },
    handleAPIError: (request) => {
      console.log(request);
      if (request.status != '200') {
        return $mdToast.show(simpleToast(request.message));
      }
      return $mdToast.show(simpleToast('Success'));
    }
  }
});

