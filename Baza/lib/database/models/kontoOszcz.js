'use strict'
const Sequelize = require('sequelize')
const sequelize = require('../sequelize')

const kontoOszcz = sequelize.define('kontoOszcz', {
  id: {
    type: Sequelize.UUID,
    primaryKey: true,
    autoIncrement: true
  },
  oprocentowanie: Sequelize.FLOAT,
  kwota: Sequelize.FLOAT,
  dataUtworzenia: {
    type: Sequelize.DATE,
    field: 'Data_utworzenia'
  },
  kontoId: Sequelize.INTEGER
}, {
  timestamps: false,
  tableName: 'Konto_oszczędnościowe'
})

module.exports = kontoOszcz
