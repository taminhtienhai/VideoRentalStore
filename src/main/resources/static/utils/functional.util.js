/**
 * @param func
 * @returns {function(*=): *}
 */
const compute = (...func) => (init) => func.reduceRight((pre, cur) => cur.call(null, pre), init);

/**
 *
 * @param func
 * @returns {function(*=): *}
 */
const compose = (...func) => (init) => func.reduce((pre, cur) => cur.call(null, pre), init);

export { compute, compose }
