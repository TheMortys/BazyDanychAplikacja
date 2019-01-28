'use strict'
const jwt = require('jsonwebtoken')
const secret = require('../constants').jwtSecret

const generateJwt = (user) => {
  return jwt.sign({
    id: user.id,
    login: user.login,
    email: user.email,
    imie: user.imie,
    nazwisko: user.nazwisko
  }, secret)
}

module.exports = generateJwt
