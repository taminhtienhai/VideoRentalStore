import {post, toJSON} from "./utils/ajax.util.js";

const app = angular.module('app',
  ['ngRoute', 'ngMaterial', 'home', 'product', 'dialog']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: '/templates/home.template.html',
      controller: 'home.controller'
    })
    .when('/product', {
      templateUrl: '/templates/product.template.html',
      controller: 'product.controller'
    })
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

app.controller('app.controller', function ($scope, appFactory, appService) {
  $scope.searchBox = '';

  // Open Add New Title Dialog
  $scope.openTitleDialog = appFactory.openDialog('/templates/dialog/title.dialog.html')
  ('title.dialog.controller')
  ((formData) => {
    appFactory.doChange('title', 'insert', formData)
      .then(console.log);
  });

  // Open Add New Customer Dialog
  $scope.openCustomerDialog = appFactory.openDialog('/templates/dialog/customer.dialog.html')
  ('customer.dialog.controller')
  ((formData) => {
    appFactory.doChange('customer', 'insert', formData)
      .then(console.log);
  });

});

app.service('appService', function () {
  this.scream = (message) => alert(message);
});

app.factory('appFactory', function ($mdDialog) {
  return {
    openDialog: (templateUrl) => (controller) => (confirm) => () => $mdDialog
      .show({
        templateUrl,
        controller,
        clickOutsideToClose:true
      })
      .then(confirm, () => console.log(`Cancel dialog ${templateUrl}`)),
    doChange: (name, action, data) => {
      return toJSON(post(`/${name}/${action}`, data));
    }
  }
});

