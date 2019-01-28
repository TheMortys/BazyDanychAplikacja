'use strict'
const passport = require('passport')
const LocalStrategy = require('passport-local').Strategy
const klient = require('../../database/models/klient')
const pracownik = require('../../database/models/pracownik')
const encryptPwd = require('../funcs/encryptPwd')

passport.use('klient-local', new LocalStrategy({
  usernameField: 'login',
  passwordField: 'password'
}, (username, password, done) => {
  return klient.findOne({
    where: {
      login: username
    }
  }).then((userRes) => {
    if (!userRes) {
      return done(null, false, {
        message: 'Incorrect login',
        status: 401
      })
    }
    if (userRes.haslo !== encryptPwd(password)) {
      return done(null, false, {
        message: 'Incorrect password',
        status: 401
      })
    }
    return done(null, userRes)
  }).catch(err => {
    return done(err)
  })
}))

passport.use('pracownik-local', new LocalStrategy({
  usernameField: 'login',
  passwordField: 'password'
}, (username, password, done) => {
  return pracownik.findOne({
    where: {
      login: username
    }
  }).then((userRes) => {
    if (!userRes) {
      return done(null, false, {
        message: 'Incorrect login',
        status: 401
      })
    }
    if (userRes.haslo !== encryptPwd(password)) {
      return done(null, false, {
        message: 'Incorrect password',
        status: 401
      })
    }
    return done(null, userRes)
  }).catch(err => {
    return done(err)
  })
}))

module.exports = passport
