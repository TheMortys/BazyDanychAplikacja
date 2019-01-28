'use strict'
const passport = require('../strategies/passport')

module.exports = (req, res, next) => {
  passport.authenticate('pracownik-local', {
    session: false
  }, (err, user, info) => {
    if (err) return next(err)
    if (!user) return next(info)
    req.user = user
    next()
  })(req, res, next)
}
