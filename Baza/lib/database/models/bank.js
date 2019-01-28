'use strict'
const Sequelize = require('sequelize')
const sequelize = require('../sequelize')
const klient = require('./klient')
const konto = require('./konto')
const pracownik = require('./pracownik')

const bank = sequelize.define('bank', {
  id: {
    type: Sequelize.UUID,
    primaryKey: true,
    autoIncrement: true
  },
  nazwa: Sequelize.STRING,
  telefon: Sequelize.STRING,
  email: {
    type: Sequelize.STRING,
    field: 'E-mail'
  },
  adresId: Sequelize.INTEGER
}, {
  timestamps: false,
  tableName: 'Bank'
})

bank.hasMany(klient, {
  foreignKey: 'BankID'
})

klient.belongsTo(bank, {
  foreignKey: 'BankID'
})

bank.hasMany(konto, {
  foreignKey: 'BankID'
})

konto.belongsTo(bank, {
  foreignKey: 'BankID'
})

bank.hasMany(pracownik, {
  foreignKey: 'BankID'
})

pracownik.belongsTo(bank, {
  foreignKey: 'BankID'
})

module.exports = bank
