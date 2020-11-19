/**
 *
 * @param characters {string | number}
 * @returns {function(string): string}
 */
const join = (...characters) => (separator) => characters.join(separator);

export { join };
