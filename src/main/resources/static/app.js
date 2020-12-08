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

  $scope.openDVDDialog = appFactory.openDialog('/templates/dialog/dvd.dialog.html')
  ('dvd.dialog.controller')
  ((formData) => {
    appFactory.doChange('dvd', 'insert', formData)
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
      console.log(data);
      return toJSON(post(`/${name}/${action}`, data));
    }
  }
});

