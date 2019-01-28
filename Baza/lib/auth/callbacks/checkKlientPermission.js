'use strict'
const klient = require('../../database/models/klient')

module.exports = (req, res, next) => {
  return klient.findOne({
    where: {
      id: req.user.id,
      login: req.user.login
    }
  }).then((userRes) => {
    if (!userRes) {
      let err = new Error('Not user')
      return next(err)
    }
    return next()
  }).catch(err => {
    return next(err)
  })
}
