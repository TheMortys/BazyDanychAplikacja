'use strict'
const Sequelize = require('sequelize')
const sequelize = require('../sequelize')
const konto = require('./konto')

const pracownik = sequelize.define('pracownik', {
  id: {
    type: Sequelize.UUID,
    primaryKey: true,
    autoIncrement: true
  },
  imie: {
    type: Sequelize.STRING,
    field: 'Imię'
  },
  nazwisko: Sequelize.STRING,
  login: Sequelize.STRING,
  haslo: {
    type: Sequelize.STRING,
    field: 'Hasło'
  },
  email: {
    type: Sequelize.STRING,
    field: 'E-mail'
  },
  telefon: Sequelize.STRING,
  stanowisko: Sequelize.STRING,
  bankId: Sequelize.INTEGER
}, {
  timestamps: false,
  tableName: 'Pracownik'
})

pracownik.hasMany(konto, {
  foreignKey: 'PracownikID'
})

konto.belongsTo(pracownik, {
  foreignKey: 'PracownikID'
})

module.exports = pracownik
