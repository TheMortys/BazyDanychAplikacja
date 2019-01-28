'use strict'
const Sequelize = require('sequelize')
const sequelize = require('../sequelize')
const konto = require('./konto')

const klient = sequelize.define('klient', {
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
  pesel: Sequelize.STRING,
  nip: Sequelize.STRING,
  telefon: Sequelize.STRING,
  email: {
    type: Sequelize.STRING,
    field: 'E-mail'
  },
  dataUrodzenia: {
    type: Sequelize.DATE,
    field: 'Data_urodzenia'
  },
  adresId: Sequelize.INTEGER,
  bankId: Sequelize.INTEGER
}, {
  timestamps: false,
  tableName: 'Klient'
})

klient.hasMany(konto, {
  foreignKey: 'KlientID'
})

konto.belongsTo(klient, {
  foreignKey: 'KlientID'
})

module.exports = klient
