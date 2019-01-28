'use strict'
const Sequelize = require('sequelize')
const sequelize = require('../sequelize')
const bank = require('./bank')
const klient = require('./klient')

const adres = sequelize.define('adres', {
  id: {
    type: Sequelize.UUID,
    primaryKey: true,
    autoIncrement: true
  },
  ulica: Sequelize.STRING,
  numerDomu: {
    type: Sequelize.INTEGER,
    field: 'Numer_domu'
  },
  numerLokalu: {
    type: Sequelize.INTEGER,
    field: 'Numer_lokalu'
  },
  kodPocztowy: {
    type: Sequelize.STRING,
    field: 'Kod_pocztowy'
  },
  miejscowosc: {
    type: Sequelize.STRING,
    field: 'Miejscowość'
  }
}, {
  timestamps: false,
  tableName: 'Adres'
})

adres.hasMany(bank, {
  as: 'adres',
  foreignKey: 'AdresID'
})

bank.belongsTo(adres, {
  as: 'adres',
  foreignKey: 'AdresID'
})

adres.hasMany(klient, {
  foreignKey: 'AdresID'
})

klient.belongsTo(adres, {
  foreignKey: 'AdresID'
})

module.exports = adres
