import {get} from "../utils/ajax.util.js";
import { join } from "../utils/string.util.js";

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
  $scope.loadAllDVD = async (maximum) => ($scope.all = await homeService.findAllDVDWithLimit(maximum).json());
  $scope.findDVDByName = async (name) => ($scope.all = await homeService.findAllDVDWithTitle(name).json());
})

home.service('homeService', function () {
  const dvdUrl = {
    all: '/dvd/all/',
    byName: '/dvd/name/'
  }
  /**
   * @param limit {number}
   * @returns {Promise<*>}
   */
  this.findAllDVDWithLimit //= async (limit= 20) => await get(join(dvdUrl.all, limit)(''));
  = async (limit= 20) => [{ name: 'hi' }];
  /**
   * @param name {string}
   * @returns {Promise<any>}
   */
  this.findAllDVDWithTitle = async (name= 'harry potter') => await get(join(dvdUrl.byName, name)(''));
});
