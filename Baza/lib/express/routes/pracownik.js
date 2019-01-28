'use strict'
const express = require('express')
const router = express.Router()
const authenticate = require('../../auth/funcs/authenticate')
const checkPracownikPermission = require('../../auth/callbacks/checkPracownikPermission')
const generateAccountNumber = require('../../utils/generateAccountNumber')
const encryptPwd = require('../../auth/funcs/encryptPwd')
const sequelize = require('../../database/sequelize')

// models
const klient = require('../../database/models/klient')
const konto = require('../../database/models/konto')
const pozyczka = require('../../database/models/pozyczka')
const bank = require('../../database/models/bank')
const adres = require('../../database/models/adres')
const kontoOszcz = require('../../database/models/kontoOszcz')
const pracownik = require('../../database/models/pracownik')
const transakcja = require('../../database/models/transakcja')

router.post('/konto/dodaj/klient', authenticate, checkPracownikPermission, (req, res, next) => {
  klient.findOne({
    where: {
      login: req.body.login
    }
  }).then(klientObj => {
    if (klientObj) return next(new Error('Login in use'))
    return adres.create({
      ulica: req.body.ulica,
      numerDomu: req.body.numerDomu,
      numerLokalu: req.body.numerLokalu,
      kodPocztowy: req.body.kodPocztowy,
      miejscowosc: req.body.miejscowosc
    }).then(obj => {
      return adres.findOne({
        where: {
          ulica: req.body.ulica||null,
          numerDomu: req.body.numerDomu,
          numerLokalu: req.body.numerLokalu||null,
          kodPocztowy: req.body.kodPocztowy,
          miejscowosc: req.body.miejscowosc
        }
      })
    }).then(adresObj => {
      return klient.create({
        imie: req.body.imie,
        nazwisko: req.body.nazwisko,
        pesel: req.body.pesel,
        nip: req.body.nip,
        dataUrodzenia: req.body.dataUrodzenia,
        login: req.body.login,
        haslo: req.body.haslo ? encryptPwd(req.body.haslo) : null,
        telefon: req.body.telefon,
        email: req.body.email,
        adresId: adresObj.id,
        bankId: req.user.bankId
      }).then(obj => {
        return klient.findOne({
          where: {
            login: req.body.login,
            imie: req.body.imie,
            nazwisko: req.body.nazwisko
          }
        }).then(klientObj => {
          let accountNumber = generateAccountNumber()
          return konto.create({
            numer: accountNumber,
            klientId: klientObj.id,
            bankId: req.user.bankId,
            pracownikId: req.user.id
          }).then(kontoObj => {
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
    }).catch(err => {
      console.log(err)
      return res.json({
        success: 0
      })
    })
  })
})

router.post('/konto/dodaj/pracownik', authenticate, checkPracownikPermission, (req, res, next) => {
  return pracownik.findOne({
    where: {
      login: req.body.login
    }
  }).then(obj => {
    if (obj) return next(new Error('Login in use'))
    return pracownik.create({
      imie: req.body.imie,
      nazwisko: req.body.nazwisko,
      login: req.body.login,
      haslo: encryptPwd(req.body.haslo),
      telefon: req.body.telefon,
      email: req.body.email,
      stanowisko: req.body.stanowisko,
      bankId: req.user.bankId
    }).then(pracownikObj => {
      return res.json({
        success: 1
      })
    }).catch(err => {
      console.log(err)
      return res.json({
        success: 0
      })
    })
  })
})

router.get('/konto/wyszukaj/klient', authenticate, checkPracownikPermission, (req, res, next) => {
  return klient.findOne({
    where: {
      imie: req.query.imie,
      nazwisko: req.query.nazwisko,
      pesel: req.query.pesel,
      bankId: req.user.bankId
    },
    include: [{
      model: konto
    },
    {
      model: adres
    }],
    subQuery: false
  }).then(klientObj => {
    return res.json(klientObj)
  })
})

router.patch('/konto/edytuj/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  return klient.findOne({
    where: {
      id: req.params.klientId
    }
  }).then(profil => {
    return klient.update({
      imie: req.body.imie,
      nazwisko: req.body.nazwisko,
      telefon: req.body.telefon,
      email: req.body.email
    }, {
      where: {
        id: req.params.klientId
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

router.delete('/konto/usun/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  return klient.findOne({
    where: {
      id: req.params.klientId
    }
  }).then(profil => {
    return konto.destroy({
      where: {
        klientId: profil.id
      }
    }).then(obj => {
      return klient.destroy({
        where: {
          id: req.params.klientId
        }
      }).then(obj => {
        return adres.destroy({
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
    }).catch(err => {
      console.log(err)
      return res.json({
        success: 0
      })
    })
  })
})

router.get('/bank/dane/', authenticate, checkPracownikPermission, (req, res, next) => {
  return bank.findOne({
    where: {
      id: req.user.bankId
    },
    include: [{
      model: adres,
      as: 'adres'
    }],
    subQuery: false
  }).then(bankObj => {
    return res.json(bankObj)
  })
})

router.patch('/bank/dane/', authenticate, checkPracownikPermission, (req, res, next) => {
  return bank.update({
    nazwa: req.body.nazwa,
    telefon: req.body.telefon,
    email: req.body.email
  }, {
    where: {
      id: req.user.bankId
    }
  }).then(bankObj => {
    return res.json({
      success: 1
    })
  }).catch(err => {
    console.log(err)
    return res.json({
      success: 0
    })
  })
})

router.post('/transakcje/przelew/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.params.klientId
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

router.post('/transakcje/wyplata/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.params.klientId
    }
  }).then(kontoObj => {
    return transakcja.create({
      kwota: req.body.kwota,
      kategoria: 'Wypłata',
      data: req.body.data,
      kontoId: kontoObj.id
    }).then(traObj => {
      return sequelize.query(`CALL wyplata(${req.body.kwota}, ${kontoObj.id})`).then(x => {
        return res.json({
          success: 1
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

router.post('/transakcje/wplata/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.params.klientId
    }
  }).then(kontoObj => {
    return transakcja.create({
      docelowyNrKonta: req.body.docelowyNrKonta,
      tytul: req.body.tytul,
      kwota: req.body.kwota,
      kategoria: 'Wpłata',
      data: req.body.data,
      kontoId: kontoObj.id
    }).then(traObj => {
      return sequelize.query(`CALL wplata(${req.body.kwota}, ${kontoObj.id})`).then(x => {
        return res.json({
          success: 1
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

router.get('/transakcje/historia/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  let sort
  let whereStatement = {}
  if (req.query.sort === 'date_DESC') {
    sort = [['id', 'DESC']]
  } else if (req.query.sort === 'date_ASC') {
    sort = [['id', 'ASC']]
  } else if (req.query.sort === 'kwota_DESC') {
    sort = [['Kwota', 'DESC']]
  } else if (req.query.sort === 'kwota_ASC') {
    sort = [['Kwota', 'ASC']]
  } else if (req.query.sort === 'typ_DESC') {
    sort = [['Kategoria', 'DESC']]
  } else if (req.query.sort === 'typ_ASC') {
    sort = [['Kategoria', 'ASC']]
  } else if (req.query.sort === 'konto_DESC') {
    sort = [['Docelowy_nr_konta', 'DESC']]
  } else if (req.query.sort === 'konto_ASC') {
    sort = [['Docelowy_nr_konta', 'ASC']]
  } else {
    sort = [['id', 'DESC']]
  }
  if (req.query.date) {
    whereStatement.Data = req.query.date
  }
  return konto.findOne({
    where: {
      klientId: req.params.klientId
    }
  }).then(obj => {
    whereStatement.kontoId = obj.id
    return transakcja.findAll({
      where: whereStatement,
      order: sort,
      subQuery: false
    }).then(tranObj => {
      return res.json(tranObj)
    })
  })
})

router.get('/pozyczki/lista/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  let sort
  if (req.query.sort === 'date_start_DESC') {
    sort = [['id', 'DESC']]
  } else if (req.query.sort === 'date_start_ASC') {
    sort = [['id', 'ASC']]
  } else if (req.query.sort === 'kwota_DESC') {
    sort = [['Kwota', 'DESC']]
  } else if (req.query.sort === 'kwota_ASC') {
    sort = [['Kwota', 'ASC']]
  } else if (req.query.sort === 'oprocentowanie_DESC') {
    sort = [['oprocentowanie', 'DESC']]
  } else if (req.query.sort === 'oprocentowanie_ASC') {
    sort = [['oprocentowanie', 'ASC']]
  } else if (req.query.sort === 'deadline_DESC') {
    sort = [['Termin_spłaty', 'DESC']]
  } else if (req.query.sort === 'deadline_ASC') {
    sort = [['Termin_spłaty', 'ASC']]
  } else {
    sort = [['id', 'DESC']]
  }
  return konto.findOne({
    where: {
      klientId: req.params.klientId
    }
  }).then(obj => {
    return pozyczka.findAll({
      where: {
        kontoId: obj.id
      },
      order: sort,
      subQuery: false
    }).then(tranObj => {
      return res.json(tranObj)
    })
  })
})

router.post('/pozyczki/dodaj/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.params.klientId
    }
  }).then(kontoObj => {
    return pozyczka.create({
      kwota: req.body.kwota,
      oprocentowanie: req.body.oprocentowanie,
      terminSplaty: req.body.terminSplaty,
      kontoId: kontoObj.id
    }).then(pozObj => {
      return sequelize.query(`CALL nowaPozyczka(${req.body.kwota}, ${kontoObj.id})`).then(x => {
        return res.json({
          success: 1
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

router.get('/lokaty/lista/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  let sort
  if (req.query.sort === 'date_start_DESC') {
    sort = [['id', 'DESC']]
  } else if (req.query.sort === 'date_start_ASC') {
    sort = [['id', 'ASC']]
  } else if (req.query.sort === 'kwota_DESC') {
    sort = [['Kwota', 'DESC']]
  } else if (req.query.sort === 'kwota_ASC') {
    sort = [['Kwota', 'ASC']]
  } else if (req.query.sort === 'oprocentowanie_DESC') {
    sort = [['oprocentowanie', 'DESC']]
  } else if (req.query.sort === 'oprocentowanie_ASC') {
    sort = [['oprocentowanie', 'ASC']]
  } else {
    sort = [['id', 'DESC']]
  }
  return konto.findOne({
    where: {
      klientId: req.params.klientId
    }
  }).then(obj => {
    return kontoOszcz.findAll({
      where: {
        kontoId: obj.id
      },
      order: sort,
      subQuery: false
    }).then(tranObj => {
      return res.json(tranObj)
    })
  })
})

router.post('/lokaty/dodaj/klient/:klientId', authenticate, checkPracownikPermission, (req, res, next) => {
  return konto.findOne({
    where: {
      klientId: req.params.klientId
    }
  }).then(kontoObj => {
    return kontoOszcz.create({
      kwota: req.body.kwota,
      oprocentowanie: req.body.oprocentowanie,
      kontoId: kontoObj.id
    }).then(konObj => {
      return sequelize.query(`CALL nowaLokata(${req.body.kwota}, ${kontoObj.id})`).then(x => {
        return res.json({
          success: 1
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

module.exports = router
