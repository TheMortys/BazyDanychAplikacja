'use strict'
const crypto = require('crypto')

const generateRefreshToken = (user) => {
  return user.id.toString() + '.' + crypto.randomBytes(40).toString('hex')
}

module.exports = generateRefreshToken
