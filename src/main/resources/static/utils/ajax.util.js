/**
 * @param url
 * @param type
 * @param body
 * @returns {Promise<Response>}
 */
const request = (url, type, body) => fetch(url, { method: type, body });

/**
 * @param url
 * @param body
 * @returns {Promise<Response>}
 */
const post = (url, body) => request(url, 'post', body);

/**
 * @param url
 * @returns {Promise<Response>}
 */
const get = (url) => request(url, 'get', null);

const toJSON = async (request) => (await request)?.json();
/**
 *
 * @param request {Promise<any>}
 * @returns {Promise<void>}
 */
const handleError = (request) => {
  request.catch(console.error);
}

export { post, get, handleError, toJSON };
