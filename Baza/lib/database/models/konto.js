'use strict'
const Sequelize = require('sequelize')
const sequelize = require('../sequelize')
const kontoOszcz = require('./kontoOszcz')
const pozyczka = require('./pozyczka')
const transakcja = require('./transakcja')

const konto = sequelize.define('konto', {
  id: {
    type: Sequelize.UUID,
    primaryKey: true,
    autoIncrement: true
  },
  numer: Sequelize.STRING,
  saldo: Sequelize.FLOAT,
  dataUtworzenia: {
    type: Sequelize.DATE,
    field: 'Data_utworzenia'
  },
  klientId: Sequelize.INTEGER,
  bankId: Sequelize.INTEGER,
  pracownikId: Sequelize.INTEGER
}, {
  timestamps: false,
  tableName: 'Konto'
})

konto.hasMany(kontoOszcz, {
  foreignKey: 'KontoID'
})

kontoOszcz.belongsTo(konto, {
  foreignKey: 'KontoID'
})

konto.hasMany(pozyczka, {
  foreignKey: 'KontoID'
})

pozyczka.belongsTo(konto, {
  foreignKey: 'KontoID'
})

konto.hasMany(transakcja, {
  foreignKey: 'KontoID'
})

transakcja.belongsTo(konto, {
  foreignKey: 'KontoID'
})

module.exports = konto
