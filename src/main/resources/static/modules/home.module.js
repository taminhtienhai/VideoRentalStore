const home = angular.module('home', []);

home.controller('home.controller', function ($scope) {
  $scope.all = [
    { name: 'phone' },
    { name: 'mouse' },
    { name: 'keyboard'},
    { name: 'bag'},
    { name: 'bag'},
    { name: 'bag'},
    { name: 'bag'},
    { name: 'bag'},
    { name: 'bag'},
    { name: 'bag'}
  ];
})
