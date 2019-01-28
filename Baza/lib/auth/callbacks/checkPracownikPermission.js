'use strict'
const pracownik = require('../../database/models/pracownik')

module.exports = (req, res, next) => {
  return pracownik.findOne({
    where: {
      id: req.user.id,
      login: req.user.login
    }
  }).then((userRes) => {
    if (!userRes) {
      let err = new Error('Not pracownik')
      return next(err)
    }
    return next()
  }).catch(err => {
    return next(err)
  })
}
