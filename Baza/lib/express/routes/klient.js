'use strict'
const express = require('express')
const router = express.Router()
const authenticate = require('../../auth/funcs/authenticate')
const checkKlientPermission = require('../../auth/callbacks/checkKlientPermission')
const sequelize = require('../../database/sequelize')

// models
const klient = require('../../database/models/klient')
const konto = require('../../database/models/konto')
const adres = require('../../database/models/adres')
const transakcja = require('../../database/models/transakcja')
const pozyczka = require('../../database/models/pozyczka')
const kontoOszcz = require('../../database/models/kontoOszcz')

router.get('/profil', authenticate, checkKlientPermission, (req, res, next) => {
  return klient.findOne({
    where: {
      id: req.user.id
    },
    include: [{
      model: konto,
      required: false
    },
    {
      model: adres
    }]
  }).then(obj => {
    return res.json(obj)
  })
})

router.patch('/profil', authenticate, checkKlientPermission, (req, res, next) => {
  return klient.findOne({
    where: {
      id: req.user.id
    }
  }).then(profil => {
    return klient.update({
      imie: req.body.imie,
      nazwisko: req.body.nazwisko,
      telefon: req.body.telefon,
      email: req.body.email
    }, {
      where: {
        id: req.user.id
      }
    }).then(obj => {
      return adres.update({
        ulica: req.body.ulica,
        numerDomu: req.body.numerDomu,
        numerLokalu: req.body.numerLokalu,
        kodPocztowy: req.body.kodPocztowy,
        miejscowosc: req.body.miejscowosc
      }, {
        where: {
          id: profil.adresId
        }
      }).then(obj => {
        return res.json({
          success: 1
        })
      }).catch(err => {
        console.log(err)
        return res.json({
          success: 0
        })
      })
    }).catch(err => {
      console.log(err)
      return res.json({
        success: 0
      })
    })
  })
})

router.post('/transakcje/przelew', authenticate, checkKlientPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.user.id
    }
  }).then(kontoObj => {
    return transakcja.create({
      docelowyNrKonta: req.body.docelowyNrKonta,
      tytul: req.body.tytul,
      kwota: req.body.kwota,
      kategoria: 'Przelew',
      data: req.body.data,
      kontoId: kontoObj.id
    }).then(traObj => {
      return konto.findOne({
        where: {
          numer: req.body.docelowyNrKonta
        }
      }).then(kontoTarget => {
        return sequelize.query(`CALL przelew(${req.body.kwota}, ${kontoObj.id}, ${kontoTarget.id})`).then(x => {
          return res.json({
            success: 1
          })
        })
      })
    }).catch(err => {
      console.log(err)
      return res.json({
        success: 0
      })
    })
  })
})

router.get('/transakcje/historia', authenticate, checkKlientPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.user.id
    }
  }).then(kontoObj => {
    return transakcja.findAll({
      where: {
        kontoId: kontoObj.id
      },
      order: [
        ['id', 'DESC']
      ]
    }).then(obj => {
      return res.json(obj)
    })
  })
})

router.get('/pozyczki/historia', authenticate, checkKlientPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.user.id
    }
  }).then(kontoObj => {
    return pozyczka.findAll({
      where: {
        kontoId: kontoObj.id
      },
      order: [
        ['id', 'DESC']
      ]
    }).then(obj => {
      return res.json(obj)
    })
  })
})

router.get('/lokaty/historia', authenticate, checkKlientPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.user.id
    }
  }).then(kontoObj => {
    return kontoOszcz.findAll({
      where: {
        kontoId: kontoObj.id
      },
      order: [
        ['id', 'DESC']
      ]
    }).then(obj => {
      return res.json(obj)
    })
  })
})

module.exports = router
