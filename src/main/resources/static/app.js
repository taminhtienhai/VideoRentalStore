const app = angular.module('app',['ngRoute', 'home', 'product']);

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

app.controller('app.controller', function ($scope, appFactory) {
  $scope.searchBox = '';

  $scope.openDialog = appFactory.openDialog;

});

app.service('appService', function () {
  this.scream = (message) => alert(message);
});

app.factory('appFactory', function ($mdDialog) {
  return {
    openDialog: (templateUrl) => (controller) => (confirm) => $mdDialog
      .show({ templateUrl, controller })
      .then(confirm, () => console.log(`Cancel dialog ${templateUrl}`))
  }
});

