const isPro = Object.is(process.env.NODE_ENV, 'production')

module.exports = {
  baseUrl: isPro ? 'http://localhost:3000/api/' : 'api/'
}
