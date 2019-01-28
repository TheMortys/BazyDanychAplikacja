'use strict'
const express = require('express')
const router = express.Router()
const klientAuthenticate = require('../../auth/callbacks/klientAuthenticate')
const pracownikAuthenticate = require('../../auth/callbacks/pracownikAuthenticate')
const generateJwtKlient = require('../../auth/funcs/generateJwtKlient')
const generateJwtPracownik = require('../../auth/funcs/generateJwtPracownik')

router.post('/login/pracownik', pracownikAuthenticate, (req, res, next) => {
  return res.json({
    imie: req.user.imie,
    nazwisko: req.user.nazwisko,
    authToken: generateJwtPracownik(req.user)
  })
})

router.post('/login/klient', klientAuthenticate, (req, res, next) => {
  return res.json({
    imie: req.user.imie,
    nazwisko: req.user.nazwisko,
    pesel: req.user.pesel,
    nip: req.user.nip,
    authToken: generateJwtKlient(req.user)
  })
})

module.exports = router
