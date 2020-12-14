const session = {
  add: (key, value) => sessionStorage.setItem(key, value),
  delete: (key) => sessionStorage.removeItem(key),
  get: (key) => sessionStorage.getItem(key)
};

export { session }
