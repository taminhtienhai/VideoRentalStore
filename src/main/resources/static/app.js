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

app.controller('app.controller', function ($scope) {
  $scope.searchBox = '';
});

app.service('appService', function () {
  this.scream = (message) => alert(message);
});

