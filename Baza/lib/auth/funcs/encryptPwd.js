'use strict'
const crypto = require('crypto')
const secret = require('../constants').pwdSecret

const encryptPwd = (pwd) => {
  return crypto.createHash('sha256').update(secret + '|' + pwd, 'utf-8').digest('hex')
}

module.exports = encryptPwd
