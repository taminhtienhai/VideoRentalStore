const fetch = async (url, type, body) => fetch(url, { method: type, body });

const post = async (url, body) => {
  return fetch(url, 'post', body);
};

const get = async (url) => {
  return fetch(url, 'get', null);
};

/**
 *
 * @param request {Promise<any>}
 * @returns {Promise<void>}
 */
const handleError = async (request) => {
  request.catch(console.error);
}

export { post, get, handleError };
