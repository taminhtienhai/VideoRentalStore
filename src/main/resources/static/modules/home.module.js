import {get, toJSON} from "../utils/ajax.util.js";
import { join } from "../utils/string.util.js";
import { compute } from "../utils/functional.util.js";

const home = angular.module('home', []);

home.controller('home.controller', function ($scope, homeService) {
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
  $scope.product = { name: 'phone' };
  $scope.loadAllDVD = async (maximum) => ($scope.all = await homeService.findAllDVDWithLimit(maximum));
  $scope.findDVDByName = async (name) => ($scope.all = await homeService.findAllDVDWithTitle(name));
});

home.service('homeService', function () {
  const dvdUrl = {
    all: '/customer/all/',
    byName: '/dvd/name/'
  }
  /**
   * @param limit {number}
   * @returns {Promise<*>}
   */
  this.findAllDVDWithLimit
    = (limit= 20) => compute(toJSON, get, join(dvdUrl.all, limit))('') || [];
  /**
   * @param name {string}
   * @returns {Promise<any>}
   */
  this.findAllDVDWithTitle
    = (name= 'harry potter') => compute(toJSON, get, join(dvdUrl.byName, name))('') || [];
});
