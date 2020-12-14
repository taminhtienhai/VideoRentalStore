import {get, toJSON} from "../utils/ajax.util.js";
import { join } from "../utils/string.util.js";
import { compute } from "../utils/functional.util.js";

const home = angular.module('home', []);

home.controller('home.controller', function ($scope, homeService) {
  $scope.catalog = [];
  // Display all DVD
  homeService.findAllDVDWithLimit().then((data) => {
    console.log(data);
    $scope.catalog = data;
  });

  // $scope.product = { name: 'phone' };
  // $scope.loadAllDVD = async (maximum) => ($scope.all = await homeService.findAllDVDWithLimit(maximum));
  // $scope.findDVDByName = async (name) => ($scope.all = await homeService.findAllDVDWithTitle(name));

  $scope.$on('ChangeModeEvent', function (_, data) {
    switch (data) {
      case '0': // Find all dvd
        console.log("find all dvd active");
        homeService.getByURL(homeService.url.dvd.all).then(data => {
          console.log(data);
          $scope.catalog = data;
        });
        break;
      case '1': // Find all customer
        console.log("find all customer active");
        homeService.getByURL(homeService.url.customer.all).then(data => {
          console.log(data);
          $scope.catalog = data;
        });
        break;
    }
  });
});

home.service('homeService', function () {
  const dvdUrl = {
    all: '/title/all/',
    byName: '/title/name/'
  }
  const customerUrl = {
    all: '/customer/all'
  }

  this.url = {
    dvd: dvdUrl,
    customer: customerUrl
  }

  this.getByURL = (url) => compute(toJSON, get)(url) || [];
  /**
   * @returns {Promise<*>}
   */
  this.findAllDVDWithLimit
    = () => compute(toJSON, get, join(dvdUrl.all))('') || [];
  /**
   * @param name {string}
   * @returns {Promise<any>}
   */
  this.findAllDVDWithTitle
    = (name= 'harry potter') => compute(toJSON, get, join(dvdUrl.byName, name))('') || [];

  this.findAllCustomer
    = () => compute(toJSON, get, join(dvdUrl.all))('') || [];
});
