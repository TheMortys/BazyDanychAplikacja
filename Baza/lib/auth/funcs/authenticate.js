'use strict'
const expressJwt = require('express-jwt')
const secret = require('../constants').jwtSecret
const authenticate = expressJwt({
  secret: secret
})
module.exports = authenticate
